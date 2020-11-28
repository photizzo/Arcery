# Telleagri Android App

This is an Android project for Tellerium. This project include frequently used libraries and architecture we have decided to adopt for developing Android apps. This document describes the various processes and guidelines that the android team will use for consistency across board.

## Getting Started

These instructions will give you heads up on how to get started, architecture flow, implementations using in this project.

### Architecture.

![](https://res.cloudinary.com/hngfun/image/upload/v1578931056/Group_23_l51pg7.png)

I decided to adopt```Clean Architecture``` for the development because of it allow decoupling different units of your code in an organized manner. That way the code gets easier to understand, modify and test. Read more about this [here](https://medium.com/exploring-android/learn-clean-architecture-for-android-at-caster-io-8f1513621c30)


## The project consist of some basic implementations and patterns which includes:

* MVVM architectural approaches for the Presentation layer
* Persistence is handled using [Room](https://developer.android.com/jetpack/androidx/releases/room)
* Dependency injection using [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android#inject-interfaces)
* Orchestration of data flow using [RxJava](https://github.com/ReactiveX/RxJava) looking to move to Kotlin Flow soon
* Network operations with [Retrofit](https://square.github.io/retrofit/)
* Unit testing using [Mockito](https://github.com/mockito/mockito)
* [Espresso](https://developer.android.com/training/testing/espresso) UI tests
* Push Notifications with [Firebase Cloud Messaging](https://firebase.google.com/docs/cloud-messaging)


## Naming Conventions
Variable , methods & Classes names must be self descriptive also in camel case.
e.g 
* ```PostActivity``` for class name
* ```fragment_post``` layout file name
* ```tvPostTite``` View id reference
* ```performLogin()``` method name


## Documentation & Comments
We use docs blocks to write description documentation and comment for classess and methods. This should clearly describe it functionality and logic executions.

## Linting
Linting is handled by[ktlint](https://ktlint.github.io/). Click [here](https://ktlint.github.io/) to see common use cases of how to structure your code.

## How to contribute effectively
1. Branch out from the develop branch to your feature branch

### Domain Layer
1. Create Model classes for the feature if needed.
2. Add the use case to the neccessary repository interface.
3. Create Usecases for the feature in the `interactors`
4. If the Usecase needs any data to carry out any operation provide a nested param class.

### Data Layer
1. Add remote and cache operations to the `Cache` and `Remote` interface.
2. Add the cache or remote interface implementation to its correct data source classes.
3. Add the implmentation of the domain interface repository in the data

### Presentation layer
- Update use case implementaion in the ViewModel classes

### UI Layer
- Add your UI Implementation as specified in the design
- Use viewmodel to interact with the other layers of the application.
