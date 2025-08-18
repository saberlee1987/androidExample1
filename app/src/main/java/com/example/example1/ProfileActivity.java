package com.example.example1;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        EditText editTextFirstName = findViewById(R.id.editTextFirstName);
        EditText editTextLastName = findViewById(R.id.editTextLastName);
        if (getIntent() !=null) {
            Intent intent = getIntent();
            if (intent.hasExtra("pageLabel")) {
                String pageLabel = intent.getStringExtra("pageLabel");
                TextView pageLabelTextView = findViewById(R.id.pageLabel);
                pageLabelTextView.setText(pageLabel);
            }
            if (intent.hasExtra("firstName")) {
                String firstName = intent.getStringExtra("firstName");
                editTextFirstName.setText(firstName);
            }
            if (intent.hasExtra("lastName")) {
                String lastName = intent.getStringExtra("lastName");
                editTextLastName.setText(lastName);
            }
        }
        Button btnConfirm = findViewById(R.id.btn_confirm);
        btnConfirm.setOnClickListener(v -> {
            String firstName = editTextFirstName.getText().toString();
            String lastName = editTextLastName.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("firstName",firstName);
            intent.putExtra("lastName",lastName);
            setResult(Activity.RESULT_OK,intent);
            finish();

        });


    }
}