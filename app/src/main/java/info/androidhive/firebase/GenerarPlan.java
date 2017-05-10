package info.androidhive.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;


public class GenerarPlan extends AppCompatActivity {


    Button generate_plan, done_button;
    private String[] arraySpinner;
    Intent i;
    TextView rutina;
    TextView calentamiento;
    TextView exercise, exercise2, exercise3, exercise4;
    TextView muscle;
    TextView peso_de_calentamiento;
    TextView repetitions;
    TextView series;
    TextView weight;


    TextView getCalentamiento;
    TextView getExercise, getExercise2, getExercise3, getExercise4;
    TextView getMuscle;
    TextView getPeso_de_calentamiento;
    TextView getRepetitions;
    TextView getSeries;
    TextView getWeight;


    ArrayList<TextView> textViewsVal;
    ArrayList<TextView> textViewsName;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_plan);
        i = getIntent();

        rutina=(TextView)findViewById(R.id.rutina_textview);
        calentamiento=(TextView)findViewById(R.id.calentamiento_textview);
        exercise=(TextView)findViewById(R.id.exercise_textview);
        exercise2=(TextView)findViewById(R.id.Exercise_2_textView);
        exercise3=(TextView)findViewById(R.id.Exercise_3_TextView);
        exercise4=(TextView)findViewById(R.id.Exercise_4_TextView);

        muscle=(TextView)findViewById(R.id.muscle_textview);
        peso_de_calentamiento=(TextView)findViewById(R.id.peso_calentamiento_textview);
        repetitions=(TextView)findViewById(R.id.repetitions_textview);
        series=(TextView)findViewById(R.id.series_textview);
        weight=(TextView)findViewById(R.id.weight_textview);

        getCalentamiento=(TextView)findViewById(R.id.calentamiento_valor);
        getExercise=(TextView)findViewById(R.id.exercise_valor);
        getExercise2=(TextView)findViewById(R.id.Exercise_2_valor);
        getExercise3=(TextView)findViewById(R.id.Exercise_3_valor);
        getExercise4=(TextView)findViewById(R.id.Exercise_4_Value);

        getMuscle=(TextView)findViewById(R.id.muscle_valor);
        getPeso_de_calentamiento=(TextView)findViewById(R.id.peso_calentaiento_valor);
        getRepetitions=(TextView)findViewById(R.id.repetitions_valor);
        getSeries=(TextView)findViewById(R.id.series_valor);
        getWeight=(TextView)findViewById(R.id.weight_valor);


        textViewsName = new ArrayList<TextView>();
        textViewsName.add(calentamiento);
        textViewsName.add(exercise);
        textViewsName.add(exercise2);
        textViewsName.add(exercise3);
        textViewsName.add(exercise4);
        textViewsName.add(muscle);
        textViewsName.add(peso_de_calentamiento);
        textViewsName.add(repetitions);
        textViewsName.add(series);
        textViewsName.add(weight);

        textViewsVal = new ArrayList<TextView>();
        textViewsVal.add(getCalentamiento);
        textViewsVal.add(getExercise);
        textViewsVal.add(getExercise2);
        textViewsVal.add(getExercise3);
        textViewsVal.add(getExercise4);
        textViewsVal.add(getMuscle);
        textViewsVal.add(getPeso_de_calentamiento);
        textViewsVal.add(getRepetitions);
        textViewsVal.add(getSeries);
        textViewsVal.add(getWeight);

        generate_plan=(Button)findViewById(R.id.generate_plan_button);
        Toast.makeText(this.getApplicationContext(),user.getEmail().toString(),Toast.LENGTH_SHORT).show();



        //String user=fragmentWithButton.routine_name;
        //Toast.makeText(getApplicationContext(),user,Toast.LENGTH_SHORT).show();

        /*
        this.arraySpinner = new String[] {
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
        };
        Spinner s = (Spinner) findViewById(R.id.spinner01);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);
        */

        generate_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(GenerarPlan.this, ExpertSystem.class);
                    Intent user_level_intent = getIntent();
                    String current_user_level = user_level_intent.getExtras().getString("current_user_level_from_calendar");
                    Log.d("Hey there, from GENERAR PLAN ACTIVITY the user level is", current_user_level);
                    intent.putExtra("user level from GENERAR PLAN", current_user_level);
                    startActivity(intent);
                }
                catch(Exception e)
                {
                    Intent new_intent=new Intent(GenerarPlan.this,MainActivity.class);
                    startActivity(new_intent);
                }

            }
        });


        Intent intent = getIntent();
        String current_day = intent.getExtras().getString("current day");

        Log.d("current value of day",current_day);
        reference = database.getReference("Usuario Prueba 4").child("Routine ").child("Machine ").child(current_day);

            reference.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.d("hey guy","im here");
                    rutina.setText(dataSnapshot.getKey());
                    int i = 0;
                    Log.d("number of childs",""+dataSnapshot.getChildrenCount());

                    for (DataSnapshot child : dataSnapshot.getChildren()) {

                        if (i < 10) {
                            Log.d("hey guy","im here 2");
                            textViewsName.get(i).setText(child.getKey());
                            textViewsVal.get(i).setText(child.getValue().toString());
                            Log.d("User key", child.getKey());
                            Log.d("User ref", child.getRef().toString());
                            Log.d("User val", child.getValue().toString());
                            i++;
                        }

                    }
                }


                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }


}