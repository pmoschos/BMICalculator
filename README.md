# BMI Calculator Android App

![Total Views](https://views.whatilearened.today/views/github/pmoschos/BMICalculator.svg) ![GitHub last commit](https://img.shields.io/github/last-commit/pmoschos/BMICalculator) ![License](https://img.shields.io/badge/license-MIT-green.svg)

## 👩‍💼 Overview

BMI Calculator is an intuitive Android application designed to calculate the Body Mass Index (BMI) based on the user's age, weight, height, and gender. This app provides health insights by categorizing BMI results and allows users to save their results for future reference.

---

## ✨ Key Features

- **Interactive BMI Calculation:** Easy-to-use interface to calculate BMI with real-time input adjustments.
- **Data Persistence:** Save BMI results locally for future reference.
- **Dynamic UI Feedback:** Color-coded results based on BMI categories.
- **Edge-to-Edge Design:** Modern UI adhering to Material Design principles.
- **Error Handling:** Validations for user input with informative messages.

---

## 👩‍💻 Screenshots

![image](https://github.com/user-attachments/assets/38c9ef32-83db-4c7e-b839-4dbe736ebe5e)

---

## 📚 Libraries Used

### Core Libraries:
- **AndroidX Libraries:**
  ```gradle
  implementation 'androidx.appcompat:appcompat:1.6.1'
  implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
  ```
- **View Binding:** Simplifies UI component access.
- **SharedPreferences:** For storing user data locally.

---

## 🔧 Technical Requirements

- **Android Studio:** Version 4.1 or later.
- **Java JDK:** Version 11 or higher.
- **Min SDK:** API level 28 (Android 9.0).
- **Target SDK:** API level 34.

---

## 🚀 Setup and Installation

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/pmoschos/BMICalculator.git
   ```
2. **Open in Android Studio:**
   - Open the project in Android Studio.
   - Sync Gradle files to install dependencies.
3. **Build and Run:**
   - Connect your Android device or emulator.
   - Click `Run` to build and launch the app.

---

## 🔍 User Interface Features

### 1. **Main Screen:**
   - Displays the app title and logo.
   - A "Get Started" button navigates to the BMI calculation screen.

### 2. **Calculation Screen:**
   - Adjustable inputs for age, weight, and height.
   - Gender selection via a switch.
   - A "Calculate BMI" button to compute results.

### 3. **Results Screen:**
   - BMI result displayed with integer and fractional parts.
   - Color-coded feedback for BMI categories (Underweight, Normal, Overweight, Obese).
   - Option to save results locally.

---

## 💻 Basic Processes

### Sending data to from CalculationActivity to ResultsActivity:
```java
btnCalculateBMI.setOnClickListener(view -> {
    double bmi = BMICalculatorUtil.calculateBMI(age, weight, height, gender);
    Intent intent = new Intent(CalculationActivity.this, ResultsActivity.class);
    intent.putExtra("bmi", bmi);
    intent.putExtra("age", age);
    intent.putExtra("weight", weight);
    intent.putExtra("height", height);
    intent.putExtra("gender", gender);
    startActivity(intent);
});
```

### Saving Results Localy:
```java
btnSaveResults.setOnClickListener(view -> {
    SharedPreferencesUtil.saveValues(getApplicationContext(), bmi, age, weight, height, gender);
    Toast.makeText(getApplicationContext(), "Results saved!", Toast.LENGTH_SHORT).show();
});
```

---

## 📢 Stay Updated

Be sure to ⭐ this repository to stay updated with new examples and enhancements!

## 📄 License
🔐 This project is protected under the [MIT License](https://mit-license.org/).


## Contact 📧
Panagiotis Moschos - pan.moschos86@gmail.com


---
<h1 align=center>Happy Coding 👨‍💻 </h1>

<p align="center">
  Made with ❤️ by 
  <a href="https://www.linkedin.com/in/panagiotis-moschos" target="_blank">
  Panagiotis Moschos</a> (https://github.com/pmoschos)
</p>

