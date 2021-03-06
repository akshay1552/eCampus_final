package com.example.ecampus.student_course_reg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecampus.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StCourse6Activity extends AppCompatActivity {

    EditText enrollno, courseone, coursetwo, coursethree, coursefour, coursefive, coursesix;
    Button btn_uploadData;
    FirebaseDatabase database;
    DatabaseReference course_data6;
    String stenroll, stcourseone, stcoursetwo, stcoursethree, stcoursefour, stcoursefive, stcoursesix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st_course6);

        enrollno = (EditText)findViewById(R.id.enroll);
        courseone = (EditText)findViewById(R.id.course1);
        coursetwo = (EditText)findViewById(R.id.course2);
        coursethree = (EditText)findViewById(R.id.course3);
        coursefour = (EditText)findViewById(R.id.course4);
        coursefive = (EditText)findViewById(R.id.course5);
        coursesix = (EditText)findViewById(R.id.course6);
        btn_uploadData = (Button)findViewById(R.id.CoursesubmitBtn);

        database = FirebaseDatabase.getInstance();
        course_data6 = database.getReference("Course6");

        btn_uploadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stenroll = enrollno.getText().toString();
                stcourseone = courseone.getText().toString();
                stcoursetwo = coursetwo.getText().toString();
                stcoursethree = coursethree.getText().toString();
                stcoursefour = coursefour.getText().toString();
                stcoursefive = coursefive.getText().toString();
                stcoursesix = coursesix.getText().toString();

                course_data6.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        CourseData6 courseData6 = new CourseData6(stenroll, stcourseone, stcoursetwo, stcoursethree, stcoursefour, stcoursefive, stcoursesix);
                        course_data6.child(stenroll).setValue(courseData6);
                        Toast.makeText(StCourse6Activity.this, "Course Registered.",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }
}
