package com.example.parcial2androidecoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private TextView currentQuestion;
    private EditText inputScore;
    private Button btnOk;
    private FirebaseDatabase database;
    private String quid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();

        btnOk = findViewById(R.id.btnOk);
        inputScore = findViewById(R.id.inputScore);
        currentQuestion = findViewById(R.id.currentQuestion);

        loadDatabase();
        btnOk.setOnClickListener(
                (v) ->{
                   DatabaseReference scoresRef = database.getReference().child("parcial2").child("scores").push();
                   Score score = new Score(
                           scoresRef.getKey(),
                           inputScore.getText().toString(),
                           quid
                   );

                   scoresRef.setValue(score);



                }
        );


    }

    private void loadDatabase() {
        DatabaseReference ref = database.getReference().child("parcial2").child("questions");
        ref.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot child : snapshot.getChildren()) {
                            Question question = child.getValue(Question.class);

                            if(question.getIsActual().equals("true")){
                                quid = question.getId();
                                currentQuestion.setText(question.getDescription());
                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                }
        );
    }
}