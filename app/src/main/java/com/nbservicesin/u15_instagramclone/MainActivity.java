package com.nbservicesin.u15_instagramclone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

/**
 * Instagram Clone from Udemy
 * From - 15. App #1 - Instagram Clone
 * Part - 1. Parse Server Setup - Backend
 * <p>
 * Help : https://parseplatform.org/
 * Progress :  45.00 min
 */

public class MainActivity extends AppCompatActivity {
    private Button btnSave;
    private EditText edtName, edtPunchSpeed, edtPunchPower, edtKickSpeed, edtKickPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // log the installation
        ParseInstallation.getCurrentInstallation().saveInBackground();

        edtName = findViewById(R.id.edtName);
        edtPunchSpeed = findViewById(R.id.edtPunchSpeed);
        edtPunchPower = findViewById(R.id.edtPunchPower);
        edtKickSpeed = findViewById(R.id.edtKickspeed);
        edtKickPower = findViewById(R.id.edtKickPower);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ParseObject kickBoxer = new ParseObject("KickBoxer");
                    kickBoxer.put("name", edtName.getText().toString());
                    kickBoxer.put("punchSpeed", Integer.parseInt(edtPunchSpeed.getText().toString()));
                    kickBoxer.put("punchPower", Integer.parseInt(edtPunchPower.getText().toString()));
                    kickBoxer.put("kickSpeed", Integer.parseInt(edtKickSpeed.getText().toString()));
                    kickBoxer.put("kickPower", Integer.parseInt(edtKickPower.getText().toString()));

                    // boxer.saveInBackground();

                    kickBoxer.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            // what to do when saving completed
                            if (e == null) {
//                            Toast.makeText(MainActivity.this, kickBoxer.get("name") + " is saved successfully", Toast.LENGTH_SHORT).show();
                                // from - https://github.com/Shashank02051997/FancyToast-Android
                                FancyToast.makeText(MainActivity.this, kickBoxer.get("name") + " is saved successfully", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();

                            } else {
//                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                // from - https://github.com/Shashank02051997/FancyToast-Android
                                FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_SHORT, FancyToast.ERROR, true).show();

                            }
                        }
                    });
                } catch (Exception e) {
                    FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_SHORT, FancyToast.ERROR, true).show();
                }
            }
        });
    }

    public void helloWorldTapped(View view) {

//        ParseObject boxer = new ParseObject("Boxer");
//        boxer.put("punch_speed",200);
////        boxer.saveInBackground();
//        boxer.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                // what to do when saving completed
//                if(e==null){
//                    Toast.makeText(MainActivity.this, "boxer object is saved successfully", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });

    }

    // All Fancy Toasts - - https://github.com/Shashank02051997/FancyToast-Android
    public void showFancyWarningToast(View view) {
        FancyToast.makeText(this, "This is a Waning Toast !", FancyToast.LENGTH_LONG, FancyToast.WARNING, true).show();

    }

    public void displayFancyInfoToast(View view) {
        FancyToast.makeText(this, "This is a info Toast !", FancyToast.LENGTH_LONG, FancyToast.INFO, true).show();

    }

    public void showConfusingToast(View view) {
        FancyToast.makeText(this, "This is a Confusing Toast !", FancyToast.LENGTH_LONG, FancyToast.CONFUSING, true).show();

    }
}