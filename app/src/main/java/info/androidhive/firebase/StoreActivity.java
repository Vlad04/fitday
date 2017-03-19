package info.androidhive.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity {

    TextView textViewLacteos1;
    TextView textViewLacteosLecheValor;
    TextView textViewLacteos2;
    TextView textViewLacteosLecheValor2;
    TextView textViewLacteos3;
    TextView textViewLacteosLecheValor3;
    TextView title;
    Button buttonUpdate;
    Button buttonAdd;
    Button buttonDelete;
    EditText editTextArticulo;
    EditText editTextValor;
    Intent i;

    ArrayList<TextView> textViewsVal;
    ArrayList<TextView> textViewsName;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        i = getIntent();

        title = (TextView)findViewById(R.id.textView5);

        textViewLacteos1 = (TextView)findViewById(R.id.textViewLacteos1);
        textViewLacteosLecheValor = (TextView)findViewById(R.id.textViewLecheValor);
        textViewLacteos2 = (TextView)findViewById(R.id.textViewLacteos2);
        textViewLacteosLecheValor2 = (TextView)findViewById(R.id.textViewLecheValor2);
        textViewLacteos3 = (TextView)findViewById(R.id.textView10);
        textViewLacteosLecheValor3 = (TextView)findViewById(R.id.textView11);
        editTextArticulo = (EditText)findViewById(R.id.editTextArticulo);
        editTextValor = (EditText)findViewById(R.id.editTextValor);
        buttonUpdate = (Button)findViewById(R.id.buttonUpdate);
        buttonAdd = (Button)findViewById(R.id.buttonAdd);
        buttonDelete = (Button)findViewById(R.id.buttonDelete);

        textViewsName = new ArrayList<TextView>();
        textViewsName.add(textViewLacteos1);
        textViewsName.add(textViewLacteos2);
        textViewsName.add(textViewLacteos3);

        textViewsVal = new ArrayList<TextView>();
        textViewsVal.add(textViewLacteosLecheValor);
        textViewsVal.add(textViewLacteosLecheValor2);
        textViewsVal.add(textViewLacteosLecheValor3);



    }

    protected void onStart(){
        super.onStart();
        if(i.getStringExtra("Test").equals("Lacteos")) {
            reference = database.getReference("Lacteos");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    title.setText(dataSnapshot.getKey());
                    int i = 0;
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        if (i<3){
                            textViewsName.get(i).setText(child.getKey());
                            textViewsVal.get(i).setText(child.getValue().toString());
                            Log.d("User key", child.getKey());
                            Log.d("User ref", child.getRef().toString());
                            Log.d("User val", child.getValue().toString());
                            i++;
                        }

                    }
                    // String text = dataSnapshot.getKey();
                    // String text2 = dataSnapshot.child("Leche Lala").getValue().toString();
                    // textViewLacteos1.setText(text);
                    //textViewLacteosLecheValor.setText(text2);

                    buttonAdd.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            String key = editTextArticulo.getText().toString();
                            String value = editTextValor.getText().toString();

                            DatabaseReference childRef = reference.child(key);

                            childRef.setValue(value);

                        }
                    });

                    buttonUpdate.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            String key = editTextArticulo.getText().toString();
                            String value = editTextValor.getText().toString();

                            DatabaseReference childRef = reference.child(key);

                            childRef.setValue(value);

                        }
                    });

                    buttonDelete.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            String key = editTextArticulo.getText().toString();

                            DatabaseReference childRef = reference.child(key);

                            childRef.removeValue();

                        }
                    });

                }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else if(i.getStringExtra("Test").equals("Refrescos")) {
            reference = database.getReference("Refrescos");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    title.setText(dataSnapshot.getKey());
                    int i = 0;
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        if (i<3) {
                            textViewsName.get(i).setText(child.getKey());
                            textViewsVal.get(i).setText(child.getValue().toString());
                            Log.d("User key", child.getKey());
                            Log.d("User ref", child.getRef().toString());
                            Log.d("User val", child.getValue().toString());
                            i++;
                        }
                    }
                    // String text = dataSnapshot.getKey();
                    // String text2 = dataSnapshot.child("Leche Lala").getValue().toString();
                    // textViewLacteos1.setText(text);
                    //textViewLacteosLecheValor.setText(text2);

                    buttonAdd.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            String key = editTextArticulo.getText().toString();
                            String value = editTextValor.getText().toString();

                            DatabaseReference childRef = reference.child(key);

                            childRef.setValue(value);

                        }
                    });

                    buttonUpdate.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            String key = editTextArticulo.getText().toString();
                            String value = editTextValor.getText().toString();

                            DatabaseReference childRef = reference.child(key);

                            childRef.setValue(value);

                        }
                    });

                    buttonDelete.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            String key = editTextArticulo.getText().toString();

                            DatabaseReference childRef = reference.child(key);

                            childRef.removeValue();

                        }
                    });

                }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else if(i.getStringExtra("Test").equals("Cervezas")) {
            reference = database.getReference("Cervezas");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    title.setText(dataSnapshot.getKey());
                    int i = 0;
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        if (i<3) {
                            textViewsName.get(i).setText(child.getKey());
                            textViewsVal.get(i).setText(child.getValue().toString());
                            Log.d("User key", child.getKey());
                            Log.d("User ref", child.getRef().toString());
                            Log.d("User val", child.getValue().toString());
                            i++;
                        }
                    }
                    // String text = dataSnapshot.getKey();
                    // String text2 = dataSnapshot.child("Leche Lala").getValue().toString();
                    // textViewLacteos1.setText(text);
                    //textViewLacteosLecheValor.setText(text2);

                    buttonAdd.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            String key = editTextArticulo.getText().toString();
                            String value = editTextValor.getText().toString();

                            DatabaseReference childRef = reference.child(key);

                            childRef.setValue(value);

                        }
                    });

                    buttonUpdate.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            String key = editTextArticulo.getText().toString();
                            String value = editTextValor.getText().toString();

                            DatabaseReference childRef = reference.child(key);

                            childRef.setValue(value);

                        }
                    });

                    buttonDelete.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            String key = editTextArticulo.getText().toString();

                            DatabaseReference childRef = reference.child(key);

                            childRef.removeValue();

                        }
                    });

                }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
