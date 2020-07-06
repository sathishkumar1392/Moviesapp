Created by SATHISH KUMAR R on 05-07-2020

# Movies Offers
A sample application  consist of 1 screens:
 * A Movies list screen with items containing the title, subTittle , price and  image of the movies.

Introduction
------------
The application  achieved solid principle  based on MVVM Architecture and Repository patterns. Implemented
Architecture principles follow Google recommended [Guide to app architecture](https://developer.android.com/jetpack/docs/guide).


The application is written entirely in Kotlin.

Android Jetpack is used as an Architecture glue including but not limited to ViewModel, LiveData,
LifeCycles and Data Binding. See a complete list in "Libraries used" section.

The application does network HTTP requests via Retrofit, OkHttp and GSON.

Kotlin Coroutines manage background threads with simplified code and reducing needs for callbacks.
Combination of Coroutines and Kotlin build in functions (transformation, collections) are preferred

Koin is used for dependency injection.

Glide is used for image loading.

 Libraries Used
 --------------

 The application goal is to show case current Android Architecture state using out of box
 Android tools made by Google (Android Jetpack) and 3rd party community driven libraries.

 Android Jetpack is a set of components, tools and guidance to make great Android apps. They bring
 together the existing Support Library and Architecture Components and arranges them into four
 categories:
   * [Android KTX] - Write more concise, idiomatic Kotlin code.
   * [Data Binding] - Declaratively bind observable data to UI elements.
   * [Lifecycles] - Create a UI that automatically responds to lifecycle events.
   * [LiveData] - Build data objects that notify views when the underlying database changes.
   * [ViewModel] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
      asynchronous tasks for optimal execution.
 * [UI] - Details on why and how to use UI Components in your apps - together or separate.

 * Third party
   * [Kotlin Coroutines][91] for managing background threads with simplified code
      and reducing needs for callbacks.
   * [Koin] A fast dependency injector.
   * [Retrofit 2] A configurable REST client.
   * [OkHttp 3] A type-safe HTTP client.
   * [GSON] A Json - Object converter using reflection.
   * [Glide] Image loading.

   Android Studio IDE setup
   ------------------------
   The  Android Studio I used is  "4.0" Stable version
