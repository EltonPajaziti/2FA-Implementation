# 2FA with OTP

A secure **Two-Factor Authentication (2FA)** system implemented in Java for Android. The project demonstrates how to enhance user account security by sending a One-Time Password (OTP) via email during the login process.

## Features
- **Secure Login**: Users must log in with an email and password.
- **OTP Generation**: A random 6-digit OTP is generated and sent to the user's email.
- **Email Integration**: OTP delivery is handled via Google SMTP.
- **Resend OTP**: Users can request a new OTP after a short cooldown period.
- **Validation**: OTPs are validated before granting access to the application.

---

## Project Structure
- `LoginActivity.java`: Manages login, OTP generation, and email sending.
- `SignUpActivity.java`: Mock signup activity for demonstration purposes.
- `VerifyActivity.java`: Handles OTP verification and resend logic.
- `MailSender.java`: Sends OTP emails using JavaMail API.
- `SuccessActivity.java`: Displayed after successful OTP verification.

---

## Prerequisites
To run this project, ensure the following:

1. **Android Studio**: Download and install [Android Studio](https://developer.android.com/studio).
2. **JavaMail API**: Add the necessary dependencies to your project:
   ```groovy
   implementation 'javax.mail:javax.mail-api:1.6.2'
   implementation 'com.sun.mail:javax.mail:1.6.2'
