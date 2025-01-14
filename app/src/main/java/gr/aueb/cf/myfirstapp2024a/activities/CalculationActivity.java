package gr.aueb.cf.myfirstapp2024a.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import gr.aueb.cf.myfirstapp2024a.R;
import gr.aueb.cf.myfirstapp2024a.utils.BMICalculatorUtil;
import gr.aueb.cf.myfirstapp2024a.utils.SharedPreferencesUtil;

public class CalculationActivity extends AppCompatActivity {

    private Button btnCalculateBMI;
    private TextView tvAge;
    private TextView tvWeight;
    private TextView tvHeight;
    private Button btnDecreaseAge;
    private Button btnIncreaseAge;
    private Button btnDecreaseWeight;
    private Button btnIncreaseWeight;
    private SeekBar skHeight;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch genderSwitch;
    private int age;
    private int weight;
    private int height;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initView();

        age = SharedPreferencesUtil.loadAge(getApplicationContext());
        weight = SharedPreferencesUtil.loadWeight(getApplicationContext());
        height = SharedPreferencesUtil.loadHeight(getApplicationContext());
        gender = SharedPreferencesUtil.loadGender(getApplicationContext());

        tvAge.setText(String.valueOf(age));
        tvWeight.setText(String.valueOf(weight));
        tvHeight.setText(String.valueOf(height));
        skHeight.setProgress(height);

        // Set the switch based on saved gender value
        // "Female" will correspond to the ON state
        genderSwitch.setChecked(!"male".equalsIgnoreCase(gender)); // "Male" will correspond to the OFF state

        // Add switch listener to handle gender selection
        genderSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                gender = "female";
                Toast.makeText(CalculationActivity.this, "Gender: Female", Toast.LENGTH_SHORT).show();
            } else {
                gender = "male";
                Toast.makeText(CalculationActivity.this, "Gender: Male", Toast.LENGTH_SHORT).show();
            }
        });

        btnDecreaseAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (age > 1) {
                    age -= 1;
                    tvAge.setText(String.valueOf(age));
                } else {
                    Toast.makeText(CalculationActivity.this, "Η ελάχιστη επιτρεπτή ηλικία είναι 1", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnIncreaseAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (age < 100) {
                    age += 1;
                    tvAge.setText(String.valueOf(age));
                } else {
                    Toast.makeText(CalculationActivity.this, "Η μέγιστη επιτρεπτή ηλικία είναι 100", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDecreaseWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (weight > 3) {
                    weight -= 1;
                    tvWeight.setText(String.valueOf(weight));
                } else {
                    Toast.makeText(CalculationActivity.this, "Το βάρος δεν μπορεί να είναι μικρότερο από 3kg", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnIncreaseWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (weight < 250) {
                    weight += 1;
                    tvWeight.setText(String.valueOf(weight));
                } else {
                    Toast.makeText(CalculationActivity.this, "Το βάρος δεν μπορεί να υπερβαίνει τα 250kg", Toast.LENGTH_SHORT).show();
                }
            }
        });

        skHeight.setMin(50);
        skHeight.setMax(250);
        skHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                height = i;
                tvHeight.setText(String.valueOf(height));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                double bmi = BMICalculatorUtil.calculateBMI(age, weight, height, gender);
                // Toast.makeText(CalculationActivity.this, String.format("%.2f",bmi), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CalculationActivity.this, ResultsActivity.class);
                intent.putExtra("bmi", bmi);
                intent.putExtra("age", age);
                intent.putExtra("weight", weight);
                intent.putExtra("height", height);
                intent.putExtra("gender", gender);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        tvAge = findViewById(R.id.tv_age);
        tvWeight = findViewById(R.id.tv_weight);
        tvHeight = findViewById(R.id.tv_height);
        btnDecreaseAge = findViewById(R.id.btn_decrease_age);
        btnIncreaseAge = findViewById(R.id.btn_increase_age);
        btnDecreaseWeight = findViewById(R.id.btn_decrease_weight);
        btnIncreaseWeight = findViewById(R.id.btn_increase_weight);
        skHeight = findViewById(R.id.seekbar_height);
        genderSwitch = findViewById(R.id.gender_switch);
        btnCalculateBMI = findViewById(R.id.btn_calculate_bmi);
    }
}