package info.androidhive.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GenerarPlan extends AppCompatActivity {

    Button generate_plan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_plan);
        generate_plan=(Button)findViewById(R.id.generate_plan_button);
        generate_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GenerarPlan.this,Calendario.class);
                startActivity(intent);
            }
        });
    }
}
