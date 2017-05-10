package info.androidhive.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.concurrent.ExecutionException;


public class Calendario extends AppCompatActivity {
    public String current_user_level;
    Button Done;
    CalendarView calendar;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        Done=(Button)findViewById(R.id.Done_button);


        calendar=(CalendarView) findViewById(R.id.calendar);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMont) {

                Toast.makeText(getApplicationContext(),dayOfMont+"/"+month+"/"+year,Toast.LENGTH_LONG).show();
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMont);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                //Toast.makeText(getApplicationContext(),dayOfWeek+"/",Toast.LENGTH_SHORT).show();
                //Log.d("day of week", String.valueOf(dayOfWeek));


                String day="";
                if(dayOfWeek==1)
                {
                    day="Sunday ";
                }
                else if(dayOfWeek==2)
                {
                    day="Monday ";
                }
                else if(dayOfWeek==3)
                {
                    day="Tuesday ";
                }
                else if(dayOfWeek==4)
                {
                    day="Wednesday ";
                }
                else if(dayOfWeek==5)
                {
                    day="Thursday ";
                }
                else if(dayOfWeek==6)
                {
                    day="Friday ";
                }
                else if(dayOfWeek==7)
                {
                    day="Saturday ";
                }
                Log.d("current date",day);

                if(dayOfWeek==7 || dayOfWeek==1)
                {
                    Toast.makeText(getApplicationContext(),"Rest for this day",Toast.LENGTH_SHORT).show();
                }
                else {


                        Intent intent = new Intent(Calendario.this, GenerarPlan.class);
                        intent.putExtra("current day", day);
                        startActivity(intent);

                        try {
                            Intent user_level_intent = getIntent();

                            current_user_level = user_level_intent.getExtras().getString("current_user_level");
                            intent.putExtra("current_user_level_from_calendar", current_user_level);

                            Log.d("Hey there!, from CALENDARIO the user level is", current_user_level);
                            startActivity(intent);
                        }
                        catch(Exception e)
                    {
                        Log.d("well","this is embarrasing");
                    }

                }
            }
        });
        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Calendario.this, MainActivity.class);
                intent.putExtra("current_user_level_from_calendar_2", current_user_level);

                startActivity(intent);
            }
        });


    }


    @Override
    public void onBackPressed() {
        // do nothing.
        Toast.makeText(getApplicationContext(), "Please select one day", Toast.LENGTH_SHORT).show();
    }


}
