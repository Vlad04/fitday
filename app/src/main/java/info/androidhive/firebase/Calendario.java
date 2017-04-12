package info.androidhive.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;


public class Calendario extends AppCompatActivity {

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
            }
        });
        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Calendario.this,ExpertSystem.class);
                startActivity(intent);
            }
        });
    }
}
