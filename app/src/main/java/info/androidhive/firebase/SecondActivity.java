package info.androidhive.firebase;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity {

    Button btnSales, btnContact, btnStore,signOut;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Localiza los botones que llevan a las distintas actividades de la aplicacion (contacts, sales, store).
        btnContact = (Button)findViewById(R.id.btnContact);
        btnSales = (Button)findViewById(R.id.btnSales);
        btnStore = (Button)findViewById(R.id.btnStore);
        signOut = (Button) findViewById(R.id.sign_out);

        auth = FirebaseAuth.getInstance();

        //Si da click en sales envia a la actividad Sales.
      btnSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,Sales.class);
                startActivity(intent);
            }
        });
        //Si da click en contact, lleva en la actividad de contactos.
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,ContactoActivity.class);
                startActivity(intent);
            }
        });
        //Si da click en store, envia a la actividad de store.
        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,SuppliesActivity.class);
                startActivity(intent);
            }
        });

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

    }
    public void signOut() {
        Intent intent = new Intent(SecondActivity.this,LoginActivity.class);
        startActivity(intent);
    }

}
