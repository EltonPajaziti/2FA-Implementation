package com.example.a2fa_class;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import javax.mail.MessagingException;

public class LoginActivity extends AppCompatActivity {
    private MailSender mailSender= new MailSender();

    private String emailUser="";
    private String passUser="";

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText emailET= findViewById(R.id.emailET);
        final EditText passwordET= findViewById(R.id.passwordET);
        final Button signInBtn= findViewById(R.id.signInBtn);
        final TextView signUpTW= findViewById(R.id.signUpTW);

        signInBtn.setOnClickListener(v -> {
            String email= emailET.getText().toString().trim();
            String password= passwordET.getText().toString().trim();
            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(LoginActivity.this,"Enter the email and password",Toast.LENGTH_SHORT).show();
            }else if (email.equals(emailUser) && password.equals(passUser)){
                String otp= generateOtp();
                sendOtpEmail(email,otp);
                Intent intent= new Intent(LoginActivity.this,VerifyActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("otp",otp);
                startActivity(intent);
            }else{
                Toast.makeText(LoginActivity.this,"Invalid email or password",Toast.LENGTH_SHORT).show();
            }
        });
        signUpTW.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
        });
    }

    private String generateOtp(){
        Random random= new Random();
        return String.format("%06d",random.nextInt(1000000));
    }

    private void sendOtpEmail(String email, String otp){
        new Thread(()->{
            try{
                mailSender.sendOtpEmail(email,otp);
                runOnUiThread(()->Toast.makeText(LoginActivity.this,"OTP sent to"+ email , Toast.LENGTH_SHORT).show());
            }  catch (MessagingException e ){
                runOnUiThread(()->Toast.makeText(LoginActivity.this,"Failed to send OTP",Toast.LENGTH_SHORT).show());
                e.printStackTrace();
            }
        }).start();
    }
}
