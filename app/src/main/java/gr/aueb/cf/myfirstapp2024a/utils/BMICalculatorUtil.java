package gr.aueb.cf.myfirstapp2024a.utils;

public class BMICalculatorUtil {
    public static double calculateBMI(int age, double weightKg, double heightCM, String gender) {
        // Convert height from cm to meters
        double heightM = heightCM / 100.0;

        // Calculate BMI
        double bmi = weightKg / (heightM * heightM);

        // Adjustments based on age and gender (optional)
        if (age < 18) {
            // Applying a correction factor for teenagers, as BMI may vary with age
            bmi = bmi * 1.1;
        }

        if ("female".equalsIgnoreCase(gender)) {
            // Slight adjustment for females (if desired)
            bmi = bmi * 0.98;
        }

        return bmi;
    }
}
