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

public class RegisterActivity extends Activity {

    private EditText editText1, editText2;
    private FirebaseAuth firebaseAuth;
    private Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editText1 = (EditText)findViewById(R.id.etRegisterEmail);
        editText2 = (EditText)findViewById(R.id.etRegisterPass);
        Register = (Button)findViewById(R.id.btnRegister);
        firebaseAuth = FirebaseAuth.getInstance();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = ProgressDialog.show(RegisterActivity.this, "PleaseWait...", "Prosesss", true);
                (firebaseAuth.createUserWithEmailAndPassword(editText1.getText().toString(), editText2.getText().toString()))
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();

                                if (task.isSuccessful()){
                                    Toast.makeText(RegisterActivity.this, "Registrasi Berhasil", Toast.LENGTH_LONG).show();
                                    Intent a = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(a);
                                }
                                else {
                                    Log.e( "ERROR", task.getException().toString());
                                    Toast.makeText(RegisterActivity.this, task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
    }
}
