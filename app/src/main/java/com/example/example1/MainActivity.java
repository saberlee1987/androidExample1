package com.example.example1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewFullName;

    private String firstName="";
    private String lastName="";
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult()
            , result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data!=null) {
                        firstName = data.getStringExtra("firstName");
                        lastName = data.getStringExtra("lastName");
                        String fullName = firstName.concat(" ").concat(lastName);
                        Toast.makeText(this, "fullName : ".concat(fullName)
                                , Toast.LENGTH_LONG).show();
                        textViewFullName.setText(fullName);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button openButton = findViewById(R.id.btn_open_profile);
        textViewFullName = findViewById(R.id.textViewFullName);
        openButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("pageLabel","Profile Page");
            intent.putExtra("firstName",firstName);
            intent.putExtra("lastName",lastName);
            activityResultLauncher.launch(intent);
        });
    }


}