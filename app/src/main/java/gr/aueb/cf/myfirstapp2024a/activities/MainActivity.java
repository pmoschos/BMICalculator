package gr.aueb.cf.myfirstapp2024a.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import gr.aueb.cf.myfirstapp2024a.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding; // View Binding instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize View Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Enable edge-to-edge content
        EdgeToEdge.enable(this);

        // edge-to-edge σχεδιασμός, δηλαδή περιεχόμενο που φτάνει στις άκρες της οθόνης
        // Set window insets padding
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            // Retrieve the insets related to the System Bars (e.g., Status Bar and Navigation Bar)
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            // Apply padding to the main layout (v) to prevent content from overlapping
            // with the System Bars (e.g., Status Bar at the top or Navigation Bar at the bottom)
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            // Return the insets to allow further processing of the WindowInsets
            return insets;
        });


        // Set an OnClickListener for the button
        binding.btnGetStarted.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CalculationActivity.class);
            startActivity(intent);
        });
    }


}