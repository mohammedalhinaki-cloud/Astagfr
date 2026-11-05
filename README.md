# Astagfr (استغفار)

**A native Android remembrance counter with an Arabic-first interface.**

Astagfr is a Kotlin Android application built around a simple daily use case: keeping track of *istighfar* (seeking forgiveness). The interface is designed for quick, one-handed interaction, with both an open-ended counter and a customizable target.

## Features

- **Open counter:** count without setting a goal.
- **Target mode:** set a personal target and follow progress around a circular indicator.
- **Goal feedback:** see a completion dialog when the selected target is reached.
- **Persistent progress:** saved counts, target, mode, and theme preferences are restored after reopening the application.
- **Theme options:** system, light, and dark appearances.
- **Arabic-first design:** Arabic text and number formatting, plus subtle visual feedback when tapping.
- **Reset confirmation:** confirmation before resetting the current counter.

## Technology

| Area | Implementation |
| --- | --- |
| Language | Kotlin |
| Platform | Android |
| UI | Jetpack Compose + Material 3 |
| State | AndroidViewModel, StateFlow |
| Local persistence | SharedPreferences |
| Build | Gradle (Kotlin DSL) |
| Minimum Android API | 24 |

## Project structure

```text
app/src/main/
├── java/com/example/
│   ├── MainActivity.kt
│   ├── data/
│   │   └── IstighfarPreferences.kt
│   └── ui/
│       ├── IstighfarScreen.kt
│       ├── IstighfarViewModel.kt
│       ├── components/
│       └── theme/
├── res/
└── AndroidManifest.xml
```

## Run locally

1. Clone this repository and open it in **Android Studio**.
2. Install the Android SDK required by `app/build.gradle.kts` and allow Gradle to synchronize.
3. Review `.env.example` for environment configuration if needed; never commit real API keys or signing credentials.
4. Choose an Android device or emulator and run the **app** configuration.

> This README describes features visible in the source code. A clean build and tests have not yet been independently verified.

## Screenshots

Screenshots of the running application can be added in a future update. No screenshots are included here yet.

## About this project

A personal Android application project, presented as part of a software development portfolio.

**Developer:** Mohammed · Computer Science student at Qassim University  
**Portfolio:** [Developer Portfolio](https://mohammedalhinaki-cloud.github.io/) · [Project Showcase](https://mohammedalhinaki-cloud.github.io/Astagfr/)  
**GitHub:** [mohammedalhinaki-cloud](https://github.com/mohammedalhinaki-cloud)

---

*The repository has no declared open-source license; please do not assume permission to reuse or redistribute its source code.*
