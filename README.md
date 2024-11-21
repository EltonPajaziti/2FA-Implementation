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


3. **Android SDK**:
   - Install **Android SDK 33** or a later version.
   - Configure it in **Android Studio**:
     - Go to `File > Project Structure > SDK Location`.
     - Ensure the SDK path is properly set up.

4. **Gmail App Password**:
   - Generate an **App Password** for your Gmail account:
     - Login to your Google account.
     - Go to **Security** > **App Passwords**.
     - Follow the instructions to create a password for this app.
   - Update the credentials in the file `MailSender.java`:
     ```java
     private final String userEmail = "your-email@gmail.com";
     private final String userPassword = "your-app-password";
     ```

---

## Setup Instructions

### 1. Clone the Repository
Clone the repository to your local machine using the following command:
```bash
git clone https://github.com/EltonPajaziti/2FA-Implementation.git
cd 2FA-Implementation
```
### 2. Open in Android Studio
- Open **Android Studio**.
- Click on **Open an Existing Project**.
- Navigate to the project directory and open it.

### 3. Build and Run
- Connect your Android device or open an emulator.
- Click on **Run** in Android Studio.
- The application will be installed and launched on the device.
---
## Contributors

This project was developed and maintained by:

- **Elton Pajaziti**  


