package com.zulfa.androiddasar;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends Activity {

    private EditText editText1,editText2;
    private FirebaseAuth mAuth;
    private Button btnLogin,btnRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText1 = (EditText)findViewById(R.id.etLoginEmail);
        editText2 = (EditText)findViewById(R.id.etLoginPass);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnRegis = (Button)findViewById(R.id.Regis);
        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this, "Please Wait...","Prosess...", true);
                (mAuth.signInWithEmailAndPassword(editText1.getText().toString(), editText2.getText().toString()))
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();

                                if (task.isSuccessful()){
                                    Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_LONG).show();
                                    Intent o = new Intent(LoginActivity.this, MainActivity.class);
                                    o.putExtra("Email", mAuth.getCurrentUser().getEmail());
                                    startActivity(o);
                                }
                                else {
                                    Log.e( "ERROR", task.getException().toString());
                                    Toast.makeText(LoginActivity.this, task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(a);
            }
        });
    }
}
