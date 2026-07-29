plugins {
    // 1. Android Application (AGP)
    id("com.android.application") version "8.7.3" apply false

    // 2. Kotlin Android
    id("org.jetbrains.kotlin.android") version "2.1.0" apply false

    // 3. Kotlin Compose Compiler
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.0" apply false

    // 4. Google Services (for Firebase)
    id("com.google.gms.google-services") version "4.4.2" apply false

    // 5. Hilt (Dependency Injection)
    id("com.google.dagger.hilt.android") version "2.51.1" apply false

    // 6. KSP (Required for Room Database with Kotlin 2.1+)
    id("com.google.devtools.ksp") version "2.1.0-1.0.29" apply false
}