package gr.aueb.cf.myfirstapp2024a.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtil {
    private static final String SHARED_PREF = "app_shared_pref";
    private static final String BMI = "bmi";
    private static final String AGE = "age";
    private static final String WEIGHT = "weight";
    private static final String HEIGHT = "height";
    private static final String GENDER = "gender";

    public static void saveValues(Context context, double bmi, int age, int weight, int height, String gender) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(BMI, (float) bmi);
        editor.putInt(AGE, age);
        editor.putInt(WEIGHT, weight);
        editor.putInt(HEIGHT, height);
        editor.putString(GENDER, gender);

        editor.apply();
    }

    public static double loadBmi(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        return (double) sharedPreferences.getFloat(BMI, 0.0f);
    }

    public static int loadAge(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(AGE, 30);
    }

    public static int loadWeight(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(WEIGHT, 78);
    }

    public static int loadHeight(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(HEIGHT, 150);
    }

    public static String loadGender(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getString(GENDER, "");
    }
}
