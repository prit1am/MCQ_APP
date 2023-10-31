package com.example.mcq_quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView register;
    ImageView pass;
    EditText email1;
    EditText password1;
    public static String PRES_NAME="MyPrefsFile";
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        register=findViewById(R.id.textView4);
        pass=findViewById(R.id.imageView4);
        email1=findViewById(R.id.editTextTextEmailAddress);
        password1=findViewById(R.id.editTextTextPassword);
        auth=FirebaseAuth.getInstance();
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password1.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    password1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    pass.setImageResource(R.drawable.openeye);
                }else{
                    pass.setImageResource(R.drawable.closeeye);
                    password1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Registeration.class);
                startActivity(i);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=email1.getText().toString();
                String password=password1.getText().toString();
                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this, "INVALID!", Toast.LENGTH_SHORT).show();
                }
                else {
                    login(email, password);
                }
                SharedPreferences sharedPreferences=getSharedPreferences(MainActivity.PRES_NAME,0);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putBoolean("hasLoggedIn",true);
                editor.apply();
            }
        });
    }
    private void login(String email,String password)
    {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(MainActivity.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(MainActivity.this,HomePage.class);
                startActivity(i);
            }
        });
        auth.signInWithEmailAndPassword(email,password).addOnFailureListener(MainActivity.this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Check Email and Password you entered", Toast.LENGTH_SHORT).show();
            }
        });
    }

}