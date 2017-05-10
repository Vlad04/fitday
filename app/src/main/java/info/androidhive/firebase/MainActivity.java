package info.androidhive.firebase;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements FragmentWithButton.OnFragmentInteractionListener{
    String current_user_level="";
    Button crear_rutina, ver_rutina, sing_out_button, test_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crear_rutina=(Button)findViewById(R.id.crear_rutina_button);
        ver_rutina=(Button)findViewById(R.id.ver_rutina_button);
        sing_out_button=(Button)findViewById(R.id.Sign_out_button);
        test_button=(Button)findViewById(R.id.Test_button);

        /*crear_rutina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CrearRutinaQuestions.class);
                startActivity(intent);
            }
        });
        */

        ver_rutina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Calendario.class);
                startActivity(intent);
            }
        });
        test_button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                    Intent intent = new Intent(MainActivity.this, ExpertSystem.class);
                    intent.putExtra("current_user_level_from_main_activity", current_user_level);
                try {

                    Intent user_level_intent = getIntent();
                    current_user_level = user_level_intent.getExtras().getString("current_user_level_from_calendar");
                    Log.d("Hey there, here from MAIN ACTIVITY the user level is", current_user_level);
                }
                catch (Exception e){
                    Log.d("well","this is embarrasing");
                }
                startActivity(intent);



            }
        });




        sing_out_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });


    }
    public void Create_fragment(View v)
    {
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        FragmentWithButton newFragment=FragmentWithButton.newInstance("Hello","Vlad");
        transaction.add(R.id.fragment_space,newFragment, "button");
        transaction.commit();
    }

    public void remove_fragment(View v)
    {
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        FragmentWithButton oldFragment=(FragmentWithButton)manager.findFragmentByTag("button");
        if(oldFragment!=null)
        {
            transaction.remove(oldFragment);
            transaction.commit();
        }
    }

    public void signOut() {
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void toastText(String text, String text2) {

    }
}
