package com.sms.fuad;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Contain extends AppCompatActivity {

    private static final int SMS_COUNT = 30;
    private final ArrayList<String> smsTexts = new ArrayList<>(SMS_COUNT);

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_contain);

        for (int i = 1; i <= SMS_COUNT; i++) {
            smsTexts.add(getIntent().getStringExtra("SMS" + i));
        }

        for (int i = 1; i <= SMS_COUNT; i++) {
            final int index = i; 

            int smsTextId = getResources().getIdentifier("sms" + i, "id", getPackageName());
            TextView smsTextView = findViewById(smsTextId);
            if (smsTextView != null) {
                smsTextView.setText(smsTexts.get(i - 1));
            }

            int shareBtnId = getResources().getIdentifier("sms" + i + "_share", "id", getPackageName());
            Button shareButton = findViewById(shareBtnId);
            if (shareButton != null) {
                shareButton.setOnClickListener(view -> {
                    String textToShare = smsTexts.get(index - 1);
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT, textToShare);
                    intent.setType("text/plain");
                    startActivity(Intent.createChooser(intent, "শেয়ার করুন"));
                });
            }

            int sendBtnId = getResources().getIdentifier("sms" + i + "_send", "id", getPackageName());
            Button sendButton = findViewById(sendBtnId);
            if (sendButton != null) {
                sendButton.setOnClickListener(view -> {
                    String textToSend = smsTexts.get(index - 1);
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"));
                    intent.putExtra("sms_body", textToSend);
                    startActivity(intent);
                });
            }
        }
    }
}