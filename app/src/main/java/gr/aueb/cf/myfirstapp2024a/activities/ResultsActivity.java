package gr.aueb.cf.myfirstapp2024a.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import gr.aueb.cf.myfirstapp2024a.R;
import gr.aueb.cf.myfirstapp2024a.utils.SharedPreferencesUtil;

public class ResultsActivity extends AppCompatActivity {

    private double bmi;
    private int age;
    private int weight;
    private int height;
    private String gender;
    private TextView tvIntegerPart;
    private TextView tvFractionalPart;
    private Button btnSaveResults;
    private TextView tvUnderweight;
    private TextView tvNormalWeight;
    private TextView tvOverweight;
    private TextView tvObesity;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_results);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initView();

        Intent intent = getIntent();
        bmi = intent.getDoubleExtra("bmi", 0);
        age = intent.getIntExtra("age", 0);
        weight = intent.getIntExtra("weight", 0);
        height = intent.getIntExtra("height", 0);
        gender = intent.getStringExtra("gender");

        String formattedBmi = String.format("%.2f", bmi); // Format BMI to 2 decimal places
        String[] bmiParts = formattedBmi.split("\\.");  // Split formatted BMI into integer and fractional parts
        tvIntegerPart.setText(bmiParts[0]);
        tvFractionalPart.setText(bmiParts[1]);

        btnSaveResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesUtil.saveValues(getApplicationContext(), bmi, age, weight, height, gender);
            }
        });

        // color changes
        if (bmi < 18.5) {
            tvUnderweight.setTextColor(ContextCompat.getColor(this, R.color.underWeightColor));
            tvUnderweight.setTypeface(tvUnderweight.getTypeface(), Typeface.BOLD);
        } else if (bmi <= 24.9) {
            tvNormalWeight.setTextColor(ContextCompat.getColor(this, R.color.normalWeightColor));
            tvNormalWeight.setTypeface(tvNormalWeight.getTypeface(), Typeface.BOLD);
        } else if (bmi <= 29.9) {
            tvOverweight.setTextColor(ContextCompat.getColor(this, R.color.overweightColor));
            tvOverweight.setTypeface(tvOverweight.getTypeface(), Typeface.BOLD);
        } else {
            tvObesity.setTextColor(ContextCompat.getColor(this, R.color.obesityColor));
            tvObesity.setTypeface(tvObesity.getTypeface(), Typeface.BOLD);
        }
    }

    private void initView() {
        tvIntegerPart = findViewById(R.id.tv_integer_part);
        tvFractionalPart = findViewById(R.id.tv_fractional_part);
        btnSaveResults = findViewById(R.id.btn_save_results);
        tvUnderweight = findViewById(R.id.tv_underweight);
        tvNormalWeight = findViewById(R.id.tv_normal_weight);
        tvOverweight = findViewById(R.id.tv_overweight);
        tvObesity = findViewById(R.id.tv_obesity);
    }
}