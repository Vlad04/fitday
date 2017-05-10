package info.androidhive.firebase;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ExpertSystem extends AppCompatActivity {

    Button Done;
    EditText how_many_days_go;
    Calendario user_level=new Calendario();
    EditText get_hurt;
    EditText tired;
    EditText heavy_Week;

    //String message = String.valueOf(intent.getStringExtra("message"));
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference Root_reference=firebaseDatabase.getReference();
    private String[] arraySpinner;
    private String[] yes_no_hurt;
    private String[] yes_no_tired;
    private String[] yes_no_heavy_week;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_system);
        Done=(Button)findViewById(R.id.Done);



        //int how_many_days=Integer.parseInt(how_many_days_go.getText().toString().trim());
        //int did_get_hurt=Integer.parseInt(get_hurt.getText().toString().trim());
        //int are_you_tired=Integer.parseInt(tired.getText().toString().trim());
        //int future_heavy_week=Integer.parseInt(heavy_Week.getText().toString().trim());


        this.arraySpinner = new String[] {
                "1", "2", "3", "4", "5"
        };

        this.yes_no_hurt=new String[]{
                "Yes", "No"
        };

        this.yes_no_tired=new String[]{
                "Yes", "No"
        };

        this.yes_no_heavy_week=new String[]{
                "Yes", "No"
        };

        final Spinner spinner_days = (Spinner) findViewById(R.id.spinner_days);
        final Spinner spinner_hurt = (Spinner) findViewById(R.id.Spinner_hurt);
        final Spinner spinner_tired = (Spinner) findViewById(R.id.spinner_tired);
        final Spinner spinner_heavy_week = (Spinner) findViewById(R.id.spinner_heavy_week);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        spinner_days.setAdapter(adapter);

        ArrayAdapter<String> adapter_hurt = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, yes_no_hurt);
        spinner_hurt.setAdapter(adapter_hurt);

        ArrayAdapter<String> adapter_tired = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, yes_no_tired);
        spinner_tired.setAdapter(adapter_tired);

        ArrayAdapter<String> adapter_heavy_week = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, yes_no_heavy_week);
        spinner_heavy_week.setAdapter(adapter_heavy_week);







        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //Toast.makeText(getApplicationContext(),spinner_days.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
                    double new_libs = 0;
                    //System.out.println("Welcome please answer these questions");

                    Feedback feedback = new Feedback();

                    //Scanner reader = new Scanner(System.in);

                    //System.out.println("From 5 days of training how many did you complete");
                    feedback.days = Integer.parseInt(spinner_days.getSelectedItem().toString());
                    //feedback.days = days_selection;

                    int value_injure = 0;
                    int value_tired = 0;
                    int value_week = 0;

                    if (spinner_hurt.getSelectedItem().toString() == "Yes")
                        value_injure = 1;
                    else if (spinner_hurt.getSelectedItem().toString() == "No") {
                        value_injure = 0;
                    }

                    if (spinner_tired.getSelectedItem().toString() == "Yes")
                        value_tired = 1;
                    else if (spinner_tired.getSelectedItem().toString() == "No") {
                        value_tired = 0;
                    }

                    if (spinner_heavy_week.getSelectedItem().toString() == "Yes")
                        value_week = 1;
                    else if (spinner_heavy_week.getSelectedItem().toString() == "No") {
                        value_week = 0;
                    }


                    //System.out.println("Did you get hurt ? (Y=1/N=0)");
                    feedback.injure = value_injure;

                    //System.out.println("Are you tired ? (Y=1/N=0)");
                    feedback.tired = value_tired;

                    //System.out.println("Are you going to have a heavy week ? (Y=1/N=0)");
                    feedback.next_week = value_week;

                    int next_level = feedback.inference_engine();
                    System.out.println(feedback.b_days);
                    System.out.println(feedback.b_injure);
                    System.out.println(feedback.b_tired);
                    System.out.println(feedback.b_next_week);
                    //Intent mIntent = getIntent();
                    //int level = mIntent.getIntExtra("intVariableName", fragment.user_level);
                    //Toast.makeText(getApplicationContext(),String.valueOf(next_level),Toast.LENGTH_SHORT).show();
                    Log.d("next level", String.valueOf(next_level));


                    Intent user_level_intent = getIntent();
                    String level = user_level_intent.getExtras().getString("user level from GENERAR PLAN");
                    Log.d("Hey there, here from EXPERT SYSTEM the user level is", "" + level);
                    //Toast.makeText(getApplicationContext(),String.valueOf(level),Toast.LENGTH_SHORT).show();
                    if (next_level == 1) {
                        //System.out.println("Congrats you go next level");
                        Toast.makeText(getApplicationContext(), "Congrats you go next level", Toast.LENGTH_SHORT).show();
                        if (level.equals("1")) {
                            new_libs = 2.5;
                        }

                        if (level.equals("2")) {
                            new_libs = 5;
                        }

                        if (level.equals("3")) {
                            new_libs = 10;
                        }
                        Intent user_intent = getIntent();
                        //String current_level = user_intent.getExtras().getString("current day");
                        //Log.d("current level",String.valueOf(current_level));
                        //System.out.printf("You should lift %f libs more",new_libs);
                        Toast.makeText(getApplicationContext(), "You should lift " + new_libs + " libs more", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Keep on the same level", Toast.LENGTH_SHORT).show();
                    }

                    Intent intent = new Intent(ExpertSystem.this, MainActivity.class);
                    startActivity(intent);
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Please create a routine first",Toast.LENGTH_SHORT).show();
                    Intent new_intent=new Intent(ExpertSystem.this,MainActivity.class);
                    startActivity(new_intent);

                }
            }
        });
    }

}
