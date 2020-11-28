package com.agromall.presentation.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


inline fun <T> Flow<T>.handleError(crossinline action: (value: String) -> Unit): Flow<T> =
    catch { e -> action(e.localizedMessage) }

fun <T, K, R> LiveData<T>.combineWith(
    liveData: LiveData<K>,
    block: (T?, K?) -> R
): MutableLiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(this) {
        result.value = block(this.value, liveData.value)
    }
    result.addSource(liveData) {
        result.value = block(this.value, liveData.value)
    }
    return result
}

fun <T, K, L, R> LiveData<T>.combineWithTwo(
    liveData: LiveData<K>,
    data: LiveData<L>,
    block: (T?, K?, L?) -> R
): MutableLiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(this) {
        result.value = block(this.value, liveData.value, data.value)
    }
    result.addSource(liveData) {
        result.value = block(this.value, liveData.value, data.value)
    }
    result.addSource(data) {
        result.value = block(this.value, liveData.value, data.value)
    }
    return result
}

fun <T, K, L, R, I> LiveData<T>.combineWithThreeLiveData(
    liveData: LiveData<K>,
    data: LiveData<L>,
    thirdLiveData: LiveData<I>,
    block: (T?, K?, L?, I?) -> R
): MutableLiveData<R> {

    val result = MediatorLiveData<R>()
    result.addSource(this) {
        result.value = block(this.value, liveData.value, data.value, thirdLiveData.value)
    }

    result.addSource(liveData) {
        result.value = block(this.value, liveData.value, data.value, thirdLiveData.value)
    }
    result.addSource(data) {
        result.value = block(this.value, liveData.value, data.value, thirdLiveData.value)
    }

    result.addSource(thirdLiveData) {
        result.value = block(this.value, liveData.value, data.value, thirdLiveData.value)
    }

    return result
}


//
//fun File.copyTo(file: File) {
//    inputStream().use { input ->
//        file.outputStream().use { output ->
//            input.copyTo(output)
//        }
//    }
//}

fun String.addDays(num: Int): String{
    var date: Date
    val sdd = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val sdf = SimpleDateFormat("yyyy-MM-dd")
    var returnStr = ""
    try {
        date = sdf.parse(this)
        val cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.DATE, num)
        returnStr = sdd.format(cal.time)
    }catch (e: Exception){
        e.printStackTrace()
    }

    return returnStr
}

fun isValidFile(fileName: String): Boolean {
    val file = File(fileName)
    if (file.exists()) {
        // Get length of file in bytes
        // Get length of file in bytes
        val fileSizeInBytes = file.length()
        // Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
        // Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
        val fileSizeInKB = fileSizeInBytes / 1024
        // Convert the KB to MegaBytes (1 MB = 1024 KBytes)
        // Convert the KB to MegaBytes (1 MB = 1024 KBytes)
        return fileSizeInKB >= 5
    }
    return false
}
