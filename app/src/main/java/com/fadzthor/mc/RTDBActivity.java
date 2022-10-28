package com.fadzthor.mc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RTDBActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private EditText txtNama, txtNPM;
    private Button btnSave, btnReturn;
    ProgressDialog progressDialog;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtdbactivity);
        spinner = findViewById(R.id.spProdi);
        mDatabase = FirebaseDatabase.getInstance().getReference("User");
        txtNama = findViewById(R.id.etNama);
        txtNPM = findViewById(R.id.etNPM);
        progressDialog = new ProgressDialog(this);
        btnSave = findViewById(R.id.btnSave);
        btnReturn = findViewById(R.id.btnReturn);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                startActivity(intent);
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
    public void sendData(View view){
        writeNewUser();
    }
    public void writeNewUser() {
        User user = new User(
                txtNama.getText().toString(),
                txtNPM.getText().toString(),
                spinner.getSelectedItem().toString()
        );
        mDatabase.child("users").child(user.getNpm()).setValue(user);
        progressDialog.setMessage("Uploading Data..");
        progressDialog.show();
        progressDialog.dismiss();
        Toast.makeText(getApplicationContext(),"Upload Successful!",Toast.LENGTH_SHORT).show();
    }
}