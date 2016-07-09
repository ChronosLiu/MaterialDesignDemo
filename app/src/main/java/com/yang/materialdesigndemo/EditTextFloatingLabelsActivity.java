package com.yang.materialdesigndemo;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditTextFloatingLabelsActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private TextInputLayout usernameTIL;
    private TextInputLayout passwordTIL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_floating_labels);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("EditTextFloatingLabels");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        usernameTIL = (TextInputLayout) findViewById(R.id.textInput_username);
        passwordTIL = (TextInputLayout) findViewById(R.id.textInput_password);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);


        Button login = (Button) findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateEmail(usernameTIL.getEditText().getText().toString())){
                    usernameTIL.setError("Not a valid email address!");
                } else if (!validatePassword(passwordTIL.getEditText().getText().toString())){
                    passwordTIL.setError("Not avalid password");
                } else {
                    usernameTIL.setErrorEnabled(false);
                    passwordTIL.setErrorEnabled(false);

                    login();
                }


            }
        });



    }


    private boolean validateEmail(String email){
        String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    private boolean validatePassword(String password){
        return password.length()>5;
    }
    private void login(){
        Snackbar.make(relativeLayout,"Login Success!",Snackbar.LENGTH_SHORT).show();
    }

}
