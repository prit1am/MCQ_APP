package com.example.mcq_quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registeration extends AppCompatActivity {
    private Button b1;
    private EditText e1;
    private EditText e2;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        b1=findViewById(R.id.reg);
        e1=findViewById(R.id.emai);
        e2=findViewById(R.id.pass);
        auth=FirebaseAuth.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=e1.getText().toString();
                String password=e2.getText().toString();

                if(TextUtils.isEmpty(email)||TextUtils.isEmpty(password)){
                    Toast.makeText(Registeration.this,"Enter email and password",Toast.LENGTH_SHORT).show();

                }
                else{
                    registration(email,password);

                }

            }
        });
    }
    private void registration(String email,String password){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Registeration.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    sendEmailVerification();

                }
                else{
                    Toast.makeText(Registeration.this,"Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void sendEmailVerification(){
        FirebaseUser firebaseUser= auth.getCurrentUser();
        if(firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(Registeration.this,"Verification Email is sent",Toast.LENGTH_SHORT).show();
                    auth.signOut();
                    finish();
                    Intent i= new Intent(Registeration.this,MainActivity.class);
                    startActivity(i);



                }
            });

        }
    }
}