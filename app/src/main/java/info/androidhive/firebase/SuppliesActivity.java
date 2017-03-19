package info.androidhive.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuppliesActivity extends AppCompatActivity {

    Button buttonCervezas;
    Button buttonLacteos;
    Button buttonRefrescos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplies);

        buttonCervezas = (Button)findViewById(R.id.buttonCervezas);
        buttonLacteos = (Button)findViewById(R.id.buttonLacteos);
        buttonRefrescos = (Button)findViewById(R.id.buttonRefrescos);

        buttonCervezas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuppliesActivity.this,StoreActivity.class);
                intent.putExtra("Test", "Cervezas");
                startActivity(intent);
            }
        });

        buttonLacteos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuppliesActivity.this,StoreActivity.class);
                intent.putExtra("Test", "Lacteos");
                startActivity(intent);
            }
        });

        buttonRefrescos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuppliesActivity.this,StoreActivity.class);
                intent.putExtra("Test", "Refrescos");
                startActivity(intent);
            }
        });

    }



}
