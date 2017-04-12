package info.androidhive.firebase;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExpertSystem extends AppCompatActivity {

    Button Done;
    EditText how_many_days_go;
    EditText get_hurt;
    EditText tired;
    EditText heavy_Week;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_system);
        Done=(Button)findViewById(R.id.Done);

        how_many_days_go=(EditText)findViewById(R.id.how_many_days);
        get_hurt=(EditText)findViewById(R.id.did_hurt);
        tired=(EditText)findViewById(R.id.you_tired);
        heavy_Week=(EditText)findViewById(R.id.heavy_Week);

        //int how_many_days=Integer.parseInt(how_many_days_go.getText().toString().trim());
        //int did_get_hurt=Integer.parseInt(get_hurt.getText().toString().trim());
        //int are_you_tired=Integer.parseInt(tired.getText().toString().trim());
        //int future_heavy_week=Integer.parseInt(heavy_Week.getText().toString().trim());






        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double new_libs =0;
                int level = 0;


                //System.out.println("Welcome please answer these questions");

                Feedback feedback = new Feedback();
                FragmentWithButton fragment=new FragmentWithButton();

                //Scanner reader = new Scanner(System.in);

                //System.out.println("From 5 days of training how many did you complete");
                feedback.days = Integer.parseInt(how_many_days_go.getText().toString().trim());

                //System.out.println("Did you get hurt ? (Y=1/N=0)");
                feedback.injure = Integer.parseInt(get_hurt.getText().toString().trim());

                //System.out.println("Are you tired ? (Y=1/N=0)");
                feedback.tired = Integer.parseInt(tired.getText().toString().trim());

                //System.out.println("Are you going to have a heavy week ? (Y=1/N=0)");
                feedback.next_week = Integer.parseInt(heavy_Week.getText().toString().trim());

                int next_level = feedback.inference_engine();

                System.out.println(feedback.b_days);
                System.out.println(feedback.b_injure);
                System.out.println(feedback.b_tired);
                System.out.println(feedback.b_next_week);


                if (next_level == 1){
                    //System.out.println("Congrats you go next level");
                    Toast.makeText(getApplicationContext(),"Congrats you go next level",Toast.LENGTH_SHORT).show();
                    if (level == 1 ) {
                        new_libs = 2.5;
                    }

                    if (level == 2 ) {
                        new_libs = 5;
                    }

                    if (level == 3 ) {
                        new_libs = 10;
                    }

                    //System.out.printf("You should lift %f libs more",new_libs);
                    Toast.makeText(getApplicationContext(),"You should lift " + new_libs +" libs more",Toast.LENGTH_SHORT).show();
                }

                else{
                    System.out.println("Keep on the same level");
                }

                Intent intent=new Intent(ExpertSystem.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
/*
    public void main(String[] args) {

        double new_libs =0;
        int level = 1;


        System.out.println("Welcome please answer these questions");

        Feedback feedback = new Feedback();

        //Scanner reader = new Scanner(System.in);

        System.out.println("From 5 days of training how many did you complete");
        feedback.days = how_many_days;

        System.out.println("Did you get hurt ? (Y=1/N=0)");
        feedback.injure = did_get_hurt;

        System.out.println("Are you tired ? (Y=1/N=0)");
        feedback.tired = are_you_tired;

        System.out.println("Are you going to have a heavy week ? (Y=1/N=0)");
        feedback.next_week = future_heavy_week;

        int next_level = feedback.inference_engine();

        System.out.println(feedback.b_days);
        System.out.println(feedback.b_injure);
        System.out.println(feedback.b_tired);
        System.out.println(feedback.b_next_week);


        if (next_level == 1){
            //System.out.println("Congrats you go next level");
            Toast.makeText(getApplicationContext(),"Congrats you go next level",Toast.LENGTH_SHORT).show();
            if (level == 1 ) {
                new_libs = 2.5;
            }

            if (level == 2 ) {
                new_libs = 5;
            }

            if (level == 3 ) {
                new_libs = 10;
            }

            //System.out.printf("You should lift %f libs more",new_libs);
            Toast.makeText(getApplicationContext(),"You should lift " + new_libs +" libs more",Toast.LENGTH_SHORT).show();
        }

        else{
            System.out.println("Keep on the same level");
        }
    }
    */
}
