package com.android.dvs.machinetesthealthcoco;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtUserName, mEdtPassword;
    private Button mBtnSubmit;
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;
    private String USERNAME = "UserName";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtUserName = findViewById(R.id.edt_UsserName_Id);
        mEdtPassword = findViewById(R.id.edt_Password_Id);
        mBtnSubmit = findViewById(R.id.btn_Submit_Id);

        sharedpreferences = getApplicationContext().getSharedPreferences("MyPref", 0);
        editor = sharedpreferences.edit();


        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = mEdtUserName.getText().toString().trim();
                String password = mEdtPassword.getText().toString().trim();

                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {

                    Toast.makeText(getApplicationContext(), "Enter USername and Password ", Toast.LENGTH_LONG).show();

                } else {


                    editor.putString(USERNAME, userName);
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this, ViewpagerActivity.class);
                    startActivity(intent);

                }

            }
        });


    }

}
