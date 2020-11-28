import Versions.androidCoreVersion
import Versions.androidJUnitVersin
import Versions.appCompatVersion
import Versions.archVersion
import Versions.assertJVersion
import Versions.constraintLayoutVersion
import Versions.coreKtxVersion
import Versions.daggerVersion
import Versions.espressoVersion
import Versions.glideVersion
import Versions.gsonVersion
import Versions.hdodenhofVersion
import Versions.hiltLifeCycleVersion
import Versions.hiltVersion
import Versions.jUnitVersion
import Versions.javaxAnnotationVersion
import Versions.javaxInjectVersion
import Versions.kotlinVersion
import Versions.legacySupportVersion
import Versions.lifecycleVersion
import Versions.loggingInterceptorVersion
import Versions.lottieVersion
import Versions.materialDesignVersion
import Versions.mockitoKotlinVersion
import Versions.moshiVersion
import Versions.mpAndroidChartVersion
import Versions.okHttpProfilingVersion
import Versions.okHttpVersion
import Versions.recyclerViewVersion
import Versions.retrofitVersion
import Versions.roboelectricVersion
import Versions.roomVersion
import Versions.rxKotlinVersion
import Versions.rxandroidVersion
import Versions.sethoVersion
import Versions.signaturePadVersion
import Versions.stepViewVersion
import Versions.timberVersion
import Versions.truthVersion
import Versions.viewModelKtxVersion
import Versions.viewPager2Version

object Config {
    val compileSdkVersion = 30
    val minSdkVersion = 17
    val targetSdkVersion = 30
    val versionCode = 1
    val versionName = "1.0.0"
    val buildToolsVersion = "30.0.1"
}

object Versions {
    val kotlinVersion = "1.3.61"
    val javaxAnnotationVersion = "1.0"
    val coreKtxVersion = "1.3.1"
    val viewModelKtxVersion = "2.2.0"
    val javaxInjectVersion = "1"
    val rxKotlinVersion = "2.4.0"
    val jUnitVersion = "4.12"
    val mockitoKotlinVersion = "2.2.0"
    val assertJVersion = "3.8.0"
    val lifecycleVersion = "2.2.0"
    val archVersion = "2.1.0"
    val roomVersion = "2.2.5"
    val roboelectricVersion = "4.3"
    val daggerVersion = "2.16"
    val hiltVersion = "2.28-alpha"
    val hiltLifeCycleVersion = "1.0.0-alpha02"
    val gsonVersion = "2.8.2"
    val okHttpVersion = "4.8.1"
    val retrofitVersion = "2.8.1"
    val loggingInterceptorVersion = "4.2.1"
    val okHttpProfilingVersion = "1.0.4"
    val moshiVersion = "1.9.2"
    val glideVersion = "4.11.0"
    val timberVersion = "4.7.0"
    val rxandroidVersion = "2.1.1"
    val recyclerViewVersion = "1.0.0"
    val appCompatVersion = "1.1.0"
    val kotlinExtensionVersion = "1.1.0"
    val constraintLayoutVersion = "2.0.0-beta4"
    val hdodenhofVersion = "3.0.1"
    val legacySupportVersion = "1.0.0"
    val materialDesignVersion = "1.1.0"
    val ktxVersion = "1.3.0"
    val lottieVersion = "3.3.1"
    val stepViewVersion = "1.5.1"
    val viewPager2Version = "1.0.0"
    val signaturePadVersion = "1.2.1"
    val mpAndroidChartVersion = "v3.1.0"
    val barCodeScannerVersion = "2.1.0:"

    //testing
    val androidCoreVersion = "1.2.0"
    val androidJUnitVersin = "1.1.1"
    val truthVersion = "0.42"
    val espressoVersion = "3.2.0"
    val sethoVersion = "1.5.1"
}

object Libraries {
    //android
    val recyclerView = "androidx.recyclerview:recyclerview:$recyclerViewVersion"
    val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
    val hdodenhof = "de.hdodenhof:circleimageview:$hdodenhofVersion"
    val androiXLegacy = "androidx.legacy:legacy-support-v4:$legacySupportVersion"
    val materialDesign = "com.google.android.material:material:$materialDesignVersion"
    val glide = "com.github.bumptech.glide:glide:$glideVersion"
    val glideCompiler = "com.github.bumptech.glide:compiler:$glideVersion"

    //annotation
    val javaxAnnotation = "javax.annotation:jsr250-api:$javaxAnnotationVersion"
    val javaxInject = "javax.inject:javax.inject:$javaxInjectVersion"

    //rxJava
    val rxandroid = "io.reactivex.rxjava2:rxandroid:$rxandroidVersion"
    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:$rxKotlinVersion"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"

    //ktx
    val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
    val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModelKtxVersion"
    val fragmentKtx = "androidx.fragment:fragment-ktx:1.2.5"
    val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.2.0"
    val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
    val roomKtx = "androidx.room:room-ktx:2.2.5"

    //room
    val roomRunTime = "androidx.room:room-runtime:$roomVersion"
    val roomCompiler = "androidx.room:room-compiler:$roomVersion"
    val roomExtensionAndCoroutine = "androidx.room:room-ktx:$roomVersion"
    val roomRxJava = "androidx.room:room-rxjava2:$roomVersion"

    // optional - Guava support for Room, including Optional and ListenableFuture
    val roomGuava = "androidx.room:room-guava:$roomVersion"


    //map
    val map = "com.google.maps.android:android-maps-utils-v3:2.0.3"
    val airlocation = "com.github.mumayank:AirLocation:2.4"
    var mapLibrary = "com.google.android.libraries.maps:maps:3.1.0-beta"

    //co-routine
    val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5"
    val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.3"

    //lifecycle libraries
    val lifecyleRuntime = "androidx.lifecycle:lifecycle-runtime:$lifecycleVersion"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:$lifecycleVersion"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:$lifecycleVersion"
    val lifecycleRxStreams = "androidx.lifecycle:lifecycle-reactivestreams:$lifecycleVersion"

    //networking
    val moshi = "com.squareup.moshi:moshi:$moshiVersion"
    val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
    val moshiKotlin = "com.squareup.moshi:moshi-kotlin:1.9.2"
    val gson = "com.google.code.gson:gson:$gsonVersion"
    val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"

    val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    val retrofitConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"
    val rxjavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"
    val moshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$loggingInterceptorVersion"
    val okHttpProfiling = "com.itkacher.okhttpprofiler:okhttpprofiler:$okHttpProfilingVersion"

    //dagger
    val dagger = "com.google.dagger:dagger-android:$daggerVersion"
    val daggerSupport = "com.google.dagger:dagger-android-support:$daggerVersion"
    val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"
    val daggerProcessor = "com.google.dagger:dagger-android-processor:$daggerVersion"
    val daggerHilt = "com.google.dagger:hilt-android:$hiltVersion"
    val daggerHiltProcessor = "com.google.dagger:hilt-android-compiler:$hiltVersion"
    val hiltLifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:$hiltLifeCycleVersion"
    val hiltLifecycleProcessor = "androidx.hilt:hilt-compiler:$hiltLifeCycleVersion"

    //logging
    val timber = "com.jakewharton.timber:timber:$timberVersion"

    //animations
    val lottie = "com.airbnb.android:lottie:$lottieVersion"

    val stepView = "com.shuhart.stepview:stepview:$stepViewVersion"
    val viewPager2 = "androidx.viewpager2:viewpager2:$viewPager2Version"
    val signaturePad = "com.github.gcacace:signature-pad:$signaturePadVersion"
    val setho = "com.facebook.stetho:stetho:$sethoVersion"
    val mpAndroidChart = "com.github.PhilJay:MPAndroidChart:$mpAndroidChartVersion"
    val barCodeScanner = "com.budiyev.android:code-scanner:2.1.0"
}

object TestLibraries {
    //Testing dependencies
    val jUnit = "junit:junit:$jUnitVersion"
    val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:$mockitoKotlinVersion"
    val assertJ = "org.assertj:assertj-core:$assertJVersion"
    val roboelectric = "org.robolectric:robolectric:$roboelectricVersion"
    val lifecycleTest = "androidx.arch.core:core-testing:$archVersion"
    val roomTest = "androidx.room:room-testing:$roomVersion"


    val androidXJUnit = "androidx.test.ext:junit:$androidJUnitVersin"

    // Core library
    val androidXCore = "androidx.test:core:$androidCoreVersion"

    // AndroidJUnitRunner and JUnit Rules
    val androidXTestRunnner = "androidx.test:runner:$androidCoreVersion"
    val androidXTestRules = "androidx.test:rules:$androidCoreVersion"

    // Assertions
    val androidXTruth = "androidx.test.ext:truth:$androidCoreVersion"
    val googleTruth = "com.google.truth:truth:$truthVersion"

    // Espresso dependencies
    val espressoCore = "androidx.test.espresso:espresso-core:$espressoVersion"
    val espressoContrib = "androidx.test.espresso:espresso-contrib:$espressoVersion"
    val espresooIntent = "androidx.test.espresso:espresso-intents:$espressoVersion"
    val espressoAccessiblity = "androidx.test.espresso:espresso-accessibility:$espressoVersion"
    val espressoWeb = "androidx.test.espresso:espresso-web:$espressoVersion"
    val espresspIdlineConcurrent = "androidx.test.espresso.idling:idling-concurrent:$espressoVersion"
    val espresso = "androidx.test.espresso:espresso-idling-resource:$espressoVersion"
}