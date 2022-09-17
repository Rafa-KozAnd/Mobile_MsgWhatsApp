package com.up.trabalhomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout number;
    private TextInputEditText editNumber;
    private TextInputLayout msg;
    private TextInputEditText editMsg;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.TextInputLayoutNumber);
        editNumber = findViewById(R.id.number);
        msg = findViewById(R.id.TextInputLayoutMsg);
        editMsg = findViewById(R.id.msg);
        send = findViewById(R.id.send);

        send.setOnClickListener(v -> {
            sendMessage();
        });
    }

    private void sendMessage() {

        String number = editNumber.getText().toString();
        String msg = editMsg.getText().toString();

        Uri webpage = Uri.parse("https://api.whatsapp.com/send?phone=" + number + "&text=" + msg);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

        startActivity(webIntent);
    }
}