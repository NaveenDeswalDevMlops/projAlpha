# Bebe Di Rasoi (Android)

Production-oriented Kotlin + Jetpack Compose food delivery app focused on warm, hygienic, affordable home-style meals for students and teachers.

## 1) Project Structure

```
BebeDiRasoi/
├── app/
│   ├── build.gradle.kts
│   └── src/main/java/com/bebedirasoi/
│       ├── data/                # Firebase + payment + models
│       ├── domain/              # Repository contracts
│       ├── ui/                  # Compose screens + navigation + viewmodels
│       ├── core/theme/          # App theming
│       ├── di/                  # Hilt modules
│       ├── BebeDiRasoiApp.kt
│       └── MainActivity.kt
├── firestore.rules
├── dummy_data.json
└── README.md
```

## 2) Implemented Features

### Customer
- Splash + onboarding
- Email auth UI flow (Firebase repository wiring included)
- Browse menu / add to cart
- Checkout flow with Razorpay manager scaffold
- Order confirmation + tracking
- Profile entrypoint + address/history placeholders

### Admin (basic in-app)
- Admin dashboard scaffold
- Repository support for add/edit/delete meals and status updates

### Platform
- MVVM, repository pattern, Hilt DI
- Firebase Auth, Firestore, FCM service integration points
- Compose UI with warm color palette

## 3) Firestore Collections
- `users`
- `meals`
- `orders`
- `categories`
- `reviews`

Schema examples are available in `dummy_data.json`.

## 4) Firebase Setup Steps

1. Create Firebase project.
2. Add Android app package: `com.bebedirasoi`.
3. Download `google-services.json` and place in `app/google-services.json`.
4. Enable:
   - Authentication → Email/Password and Google Sign-In
   - Firestore Database
   - Cloud Messaging
5. Deploy rules:
   ```bash
   firebase deploy --only firestore:rules
   ```

## 5) Razorpay Setup Steps

1. Create Razorpay account and obtain API Key ID.
2. Add backend order creation endpoint (required for real payment security).
3. Pass generated Razorpay `order_id` to `RazorpayManager.launchCheckout(...)`.
4. Handle payment callbacks in Activity and verify signature from backend.

## 6) Required Dependencies (already in Gradle)

- Jetpack Compose BOM + Material3
- Navigation Compose
- Hilt + Hilt Navigation Compose + KSP
- Firebase BOM (Auth, Firestore, Messaging)
- Google Sign-In (`play-services-auth`)
- Razorpay Checkout SDK
- Coil Compose

## 7) Build & Run

> Note: this repository avoids committing binary artifacts (including `gradle-wrapper.jar`).
> If your environment requires the wrapper, regenerate it first:
>
> ```bash
> gradle wrapper --gradle-version 8.14.3 --offline
> ```

```bash
./gradlew assembleDebug
```

Min SDK: 26 (Android 8.0)
Target/Compile SDK: 35

## 9) PR / Branch Troubleshooting

If your branch or PR creation fails with a message like **"Binary files are not supported"**:

1. Check staged changes for binaries:
   ```bash
   git diff --cached --numstat
   ```
2. Run helper check:
   ```bash
   scripts/check_no_binary_files.sh
   ```
3. Ensure `gradle/wrapper/gradle-wrapper.jar` is **not** committed in this environment.
4. Regenerate wrapper locally when needed:
   ```bash
   gradle wrapper --gradle-version 8.14.3 --offline
   ```

## 8) Notes for Production Hardening

- Implement Google sign-in token exchange in `AuthRepository`.
- Persist cart locally (Room/DataStore).
- Add backend webhook processing for payment success/failure and status sync.
- Add FCM token upload and topic subscriptions (daily menu notifications).
- Add comprehensive UI tests and instrumentation tests.
