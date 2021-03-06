package com.example.ecampus.Result_upload;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ecampus.Model.StudentData;
import com.example.ecampus.Model.StudentData2;
import com.example.ecampus.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Sem2Activity extends AppCompatActivity {

    EditText enrollno, subone, subtwo, subthree, subfour,subfive, subsix, subseven;
    Button btn_uploadData;
    FirebaseDatabase database;
    DatabaseReference student_data;
    String stenroll, stsubone, stsubtwo, stsubthree, stsubfour,stsubfive, stsubsix, stsubseven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem2);

        enrollno = (EditText)findViewById(R.id.enroll);
        subone = (EditText) findViewById(R.id.sub1);
        subtwo = (EditText) findViewById(R.id.sub2);
        subthree = (EditText) findViewById(R.id.sub3);
        subfour = (EditText) findViewById(R.id.sub4);
        subfive = (EditText) findViewById(R.id.sub5);
        subsix = (EditText) findViewById(R.id.sub6);
        subseven = (EditText) findViewById(R.id.sub7);
        btn_uploadData = (Button) findViewById(R.id.resubmit);
        database = FirebaseDatabase.getInstance();
        student_data = database.getReference("Sem 2");



        btn_uploadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stenroll = enrollno.getText().toString();
                stsubone = subone.getText().toString();
                stsubtwo = subtwo.getText().toString();
                stsubthree = subthree.getText().toString();
                stsubfour = subfour.getText().toString();
                stsubfive = subfive.getText().toString();
                stsubsix = subsix.getText().toString();
                stsubseven = subseven.getText().toString();

                student_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (stenroll.isEmpty())
                        {
                            enrollno.setError("Please enter your Enrollment No");
                            enrollno.requestFocus();
                        }

                        else if (stsubone.isEmpty())
                        {
                            subone.setError("Please enter your Marks");
                            subone.requestFocus();
                        }

                        else if (stsubtwo.isEmpty())
                        {
                            subtwo.setError("Please enter your Marks");
                            subtwo.requestFocus();
                        }

                        else if (stsubthree.isEmpty())
                        {
                            subthree.setError("Please enter your Marks");
                            subthree.requestFocus();
                        }

                        else if (stsubfour.isEmpty())
                        {
                            subfour.setError("Please enter your Marks");
                            subfour.requestFocus();
                        }

                        else if (stsubfive.isEmpty())
                        {
                            subfive.setError("Please nenter your marks");
                            subfive.requestFocus();
                        }

                        else if (stsubsix.isEmpty())
                        {
                            subsix.setError("Please enter your Marks");
                            subsix.requestFocus();
                        }

                        else if (stsubseven.isEmpty())
                        {
                            subseven.setError("Please enter your Marks");
                            subseven.requestFocus();
                        }

                        else
                        {
                            StudentData2 studentData = new StudentData2(stenroll, stsubone, stsubtwo, stsubthree, stsubfour,stsubfive, stsubsix, stsubseven);
                            student_data.child(stenroll).setValue(studentData);
                            Toast.makeText(Sem2Activity.this,"Result is uploaded.",Toast.LENGTH_SHORT).show();

                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });



    }
}
