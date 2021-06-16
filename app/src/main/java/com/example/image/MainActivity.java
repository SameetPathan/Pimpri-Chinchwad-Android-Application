package com.example.image;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;

    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp=getSharedPreferences("logged",MODE_PRIVATE);
        if(sp.getBoolean("logged",false)){

            Intent intent = new Intent(getApplicationContext(),NoticePanel.class);
            startActivity(intent);
        }

        Button login= findViewById(R.id.login);
        EditText username= findViewById(R.id.username);
        EditText password= findViewById(R.id.password);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String USERNAME=username.getText().toString();
                String PASSWORD=password.getText().toString();
                if(USERNAME.equals("PCM1") && PASSWORD.equals("PCM1") || USERNAME.equals("PCM2") && PASSWORD.equals("PCM2") ){
                    sp.edit().putBoolean("logged",true).apply();
                    Intent intent = new Intent(getApplicationContext(),NoticePanel.class);
                    startActivity(intent);


                }
                else {
                    Toast.makeText(MainActivity.this,"Please Check Your UserName And Password ",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    // Function to check and request permission.
    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission)
                == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[] { permission },
                    requestCode);
        }
        else {
            Toast.makeText(MainActivity.this,
                    "Permission already granted",
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super
                .onRequestPermissionsResult(requestCode,
                        permissions,
                        grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this,
                        "Camera Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            }
            else {
                Toast.makeText(MainActivity.this,
                        "Camera Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
        else if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this,
                        "Storage Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            }
            else {
                Toast.makeText(MainActivity.this,
                        "Storage Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    public void storage(View view) {
        checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,STORAGE_PERMISSION_CODE);

    }

    public void camera(View view) {
        checkPermission(Manifest.permission.CAMERA,CAMERA_PERMISSION_CODE);
    }

}