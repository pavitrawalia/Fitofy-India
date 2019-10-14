package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NameRollActivity extends AppCompatActivity {

    EditText editTextName, editTextRoll;
    Button buttonReady;
    String Name , Roll ;

    SharedPreferences sharedPreferences;
    String organisation, className, secName;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_roll);
        editTextName = findViewById(R.id.editTextName);
        editTextRoll = findViewById(R.id.editTextRoll);
        buttonReady = findViewById(R.id.buttonReady);

        className = getIntent().getExtras().getString("class");
        secName = getIntent().getExtras().getString("section");

        sharedPreferences = getSharedPreferences("Organisation", Context.MODE_PRIVATE);

        organisation = sharedPreferences.getString("OrgName", organisation);

        firebaseDatabase = FirebaseDatabase.getInstance("https://fitofyindia.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference("Organisation/" + organisation);



        buttonReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Name = editTextName.getText().toString();
                Roll = editTextName.getText().toString();

                databaseReference.child(className).child(secName).child(Roll);


                Intent i = new Intent(getBaseContext(), OrganisationMainActivity.class);
                startActivity(i);

                finish();

            }
        });


    }
}
