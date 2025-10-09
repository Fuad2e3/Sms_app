package com.sms.fuad;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Button bijoy;
    Button birthday;
    Button boka;
    Button eid;
    Button fabruary;
    Button frend;
    Button indpendents;
    Button islamic;
    Button love;
    Button love1;
    Button love2;
    Button maride;
    Button monapora;
    Button morning;
    Button nboborshi;
    Button newyears;
    Button night;
    Button sad;
    Button suvokamona;
    Button vlantiynday;

    private void startContainActivityWithStrings(String prefix) {
        Intent intent = new Intent(this, Contain.class);
        for (int i = 1; i <= 30; i++) {
            String smsKey = "SMS" + i;
            String resourceName = prefix + i;

            int stringId = getResources().getIdentifier(
                    resourceName, "string", getPackageName());

            if (stringId != 0) {
                intent.putExtra(smsKey, getString(stringId));
            }
        }
        startActivity(intent);
    }

    private final View.OnClickListener smsClickListener = view -> {
        String prefix = "";
        int id = view.getId();

        if (id == R.id.eid) prefix = "eid";
        else if (id == R.id.love) prefix = "love";
        else if (id == R.id.love1) prefix = "love3";
        else if (id == R.id.love2) prefix = "love6";
        else if (id == R.id.nboborshi) prefix = "n";
        else if (id == R.id.bijoy) prefix = "b";
        else if (id == R.id.newyears) prefix = "m";
        else if (id == R.id.islamik) prefix = "z";
        else if (id == R.id.boka) prefix = "x";
        
        if (!prefix.isEmpty()) {
            startContainActivityWithStrings(prefix);
        }
    };

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);

        this.eid = findViewById(R.id.eid);
        this.love = findViewById(R.id.love);
        this.love1 = findViewById(R.id.love1);
        this.love2 = findViewById(R.id.love2);
        this.nboborshi = findViewById(R.id.nboborshi);
        this.bijoy = findViewById(R.id.bijoy);
        this.newyears = findViewById(R.id.newyears);
        this.islamic = findViewById(R.id.islamik);
        this.boka = findViewById(R.id.boka);
        this.monapora = findViewById(R.id.monapora);
        this.morning = findViewById(R.id.morning);
        this.night = findViewById(R.id.night);
        this.indpendents = findViewById(R.id.indpendents);
        this.fabruary = findViewById(R.id.fabruary);
        this.sad = findViewById(R.id.sad);
        this.frend = findViewById(R.id.frend);
        this.vlantiynday = findViewById(R.id.vlantiynday);
        this.maride = findViewById(R.id.maride);
        this.suvokamona = findViewById(R.id.suvokamona);
        this.birthday = findViewById(R.id.birthday);

        this.eid.setOnClickListener(smsClickListener);
        this.love.setOnClickListener(smsClickListener);
        this.love1.setOnClickListener(smsClickListener);
        this.love2.setOnClickListener(smsClickListener);
        this.nboborshi.setOnClickListener(smsClickListener);
        this.bijoy.setOnClickListener(smsClickListener);
        this.newyears.setOnClickListener(smsClickListener);
        this.islamic.setOnClickListener(smsClickListener);
        this.boka.setOnClickListener(smsClickListener);
        this.monapora.setOnClickListener(smsClickListener);
        this.morning.setOnClickListener(smsClickListener);
        this.night.setOnClickListener(smsClickListener);
        this.indpendents.setOnClickListener(smsClickListener);
        this.fabruary.setOnClickListener(smsClickListener);
        this.sad.setOnClickListener(smsClickListener);
        this.frend.setOnClickListener(smsClickListener);
        this.vlantiynday.setOnClickListener(smsClickListener);
        this.maride.setOnClickListener(smsClickListener);
        this.suvokamona.setOnClickListener(smsClickListener);
        this.birthday.setOnClickListener(smsClickListener);
    }
}