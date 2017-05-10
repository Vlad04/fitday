package info.androidhive.firebase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentWithButton.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentWithButton#newInstance} factory method to
 * create an instance of this fragment.
 */


public class FragmentWithButton extends Fragment implements ValueEventListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<String> categorias;
    //CategoriaAdapter categoriasAdapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button fragmen_button_db;
    EditText routine_name_db;
    EditText user_name;
    EditText user_age;
    EditText user_weight;
    Button beginner_button;
    Button medium_button;
    Button expert_button;
    public int user_level;
    String musculo_lunes;
    String musculo_martes;
    String musculo_miercoles;
    String musculo_jueves;
    String musculo_viernes;
    double weight_calentamiento;
    double weight;
    String exercise_1;
    String exercise_2;
    String exercise_3;
    String exercise_4;

    String exercise_1_martes;
    String exercise_2_martes;
    String exercise_3_martes;
    String exercise_4_martes;



    String exercise_1_miercoles;
    String exercise_2_miercoles;
    String exercise_3_miercoles;
    String exercise_4_miercoles;


    String exercise_1_jueves;
    String exercise_2_jueves;
    String exercise_3_jueves;
    String exercise_4_jueves;

    String exercise_1_viernes;
    String exercise_2_viernes;
    String exercise_3_viernes;
    String exercise_4_viernes;
    int series;
    String repeticiones;
    String calentamiento;
    private OnFragmentInteractionListener mListener;


    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference Root_reference=firebaseDatabase.getReference();

    public void change_level()
    {
        beginner_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user_level=1;


                //Monday
                calentamiento="2 Sets of 10-12 repetitions";
                musculo_lunes="Chest";
                exercise_1="Bench Press";
                exercise_2="Incline Bench Press";
                exercise_3="Chest Dip";
                exercise_4="Machine Fly";
                weight_calentamiento=12.5;
                weight=20;
                series=4;
                repeticiones="4-6";

                //Tuesday
                musculo_martes="Biceps and triceps";
                exercise_1_martes="Barbell Curl";
                exercise_2_martes="Dumbell Concentration Curls";
                exercise_3_martes="Cable Triceps pushdown";
                exercise_4_martes="Dumbell Standing Triceps Extension";

                //Wednesday
                musculo_miercoles="Shoulders and Back";
                exercise_1_miercoles="Dumbbell Arnold Press";
                exercise_2_miercoles="Dumbell Shoulder Shrug";
                exercise_3_miercoles="Barbell Deadlift";
                exercise_4_miercoles="Wide Grip Lat Pulldown";

                //Thursday
                musculo_jueves="Abs";
                exercise_1_jueves="Crunches";
                exercise_2_jueves="Dumbell Side Bend";
                exercise_3_jueves="Weighted Decline Crunch";
                exercise_4_jueves="Hit";

                //Friday
                musculo_viernes="Legs";
                exercise_1_viernes="Leg Press";
                exercise_2_viernes="Lying Leng Curls";
                exercise_3_viernes="Leg Extension";
                exercise_4_viernes="Barbell Squat";


            }

        });
        medium_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_level=2;


                //MONDAY
                calentamiento="2 Sets of 10-12 repetitions";
                musculo_lunes="Chest";
                exercise_1="Barbell Bench Press";
                exercise_2="Barbell Incline Bench Press";
                exercise_3="Dumbell Bench Press";
                exercise_4="Dumbell Incline Bench Press";
                weight_calentamiento=25;
                weight=40;
                series=4;
                repeticiones="4-6";


                //Tuesday
                musculo_martes="Biceps and triceps";
                exercise_1_martes="Barbell Close Grip Bech Press";
                exercise_2_martes="Dumbell Concentration Curls";
                exercise_3_martes="Barbell Triceps Extension";
                exercise_4_martes="Dumbell Standing Triceps Extension";

                //Wednesday
                musculo_miercoles="Shoulders and Back";
                exercise_1_miercoles="T Bar Row";
                exercise_2_miercoles="One arm dumbell Row";
                exercise_3_miercoles="Barbell Deadlift";
                exercise_4_miercoles="Weighted Pull Ups";

                //Thursday
                musculo_jueves="Abs";
                exercise_1_jueves="Crunches";
                exercise_2_jueves="Dumbell Side Bend";
                exercise_3_jueves="Weighted Decline Crunch";
                exercise_4_jueves="Hit Medium";

                //Friday
                musculo_viernes="Legs";
                exercise_1_viernes="Leg Press";
                exercise_2_viernes="Lying Leng Curls";
                exercise_3_viernes="Leg Extension";
                exercise_4_viernes="Barbell Squat";
            }
        });
        expert_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_level=3;


                //MONDAY
                calentamiento="2 Sets of 10-12 repetitions";
                musculo_lunes="Chest";
                exercise_1="Barbell Bench Press";
                exercise_2="Barbell Fly";
                exercise_3="Dumbell Bench Press";
                exercise_4="Chest Dip";
                weight_calentamiento=35;
                weight=70;
                series=4;
                repeticiones="4-6";


                //Tuesday
                musculo_martes="Biceps and triceps";
                exercise_1_martes="Barbell Curl";
                exercise_2_martes="Barbell Seated Overhead TRiceps Extension";
                exercise_3_martes="Cable Triceps pushdown";
                exercise_4_martes="Dumbell Standing Triceps Extension";

                //Wednesday
                musculo_miercoles="Shoulders and Back";
                exercise_1_miercoles="Dumbbell Arnold Press";
                exercise_2_miercoles="Smith Machine Shrug";
                exercise_3_miercoles="Barbell Deadlift";
                exercise_4_miercoles="Weighted Pull Ups";

                //Thursday
                musculo_jueves="Abs";
                exercise_1_jueves="Crunches";
                exercise_2_jueves="Dumbell Side Bend";
                exercise_3_jueves="Weighted Decline Crunch";
                exercise_4_jueves="Hit Advanced";

                //Friday
                musculo_viernes="Legs";
                exercise_1_viernes="Leg Press";
                exercise_2_viernes="Seated Calf Raise";
                exercise_3_viernes="Leg Extension";
                exercise_4_viernes="Standing Barbell Calf Raise";

            }
        });
        Intent intent = new Intent(getActivity(), ExpertSystem.class);
        intent.putExtra("current_user_level_from_button", user_level);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment_with_button, container, false);
        final TextView textView=(TextView)getActivity().findViewById(R.id.fragment_text);
        user_name=(EditText)view.findViewById(R.id.Name_user);
        user_age=(EditText)view.findViewById(R.id.Age_user);
        user_weight=(EditText)view.findViewById(R.id.Weight_user);
        fragmen_button_db=(Button)view.findViewById(R.id.fragment_button);
        beginner_button=(Button)view.findViewById(R.id.Beginner);
        medium_button=(Button)view.findViewById(R.id.Medium);
        expert_button=(Button)view.findViewById(R.id.Expert);
        change_level();
        fragmen_button_db.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                try {


//              String key = fragment_input_db.getText().toString().trim();

                    if (user_name.length() == 0 || user_age.length() == 0 || user_weight.length() == 0) {
                        Toast.makeText(getActivity(), "Please enter the information", Toast.LENGTH_SHORT).show();
                    } else {


                        final String routine_name = "Usuario " + user_name.getText().toString();

//              String name=user_name.getText().toString().trim();
                        final int age = Integer.parseInt(user_age.getText().toString().trim());
                        final double weight_user = Double.parseDouble(user_weight.getText().toString().trim());
                        Intent shared_intent_name = new Intent(getActivity(), GenerarPlan.class);
                        String strName = null;
                        shared_intent_name.putExtra("EXTRA_SESSION_ID", strName);
                        startActivity(shared_intent_name);

                        //Level user
                        DatabaseReference name_Ref = Root_reference.child(routine_name).child("Name ");
                        DatabaseReference age_Ref = Root_reference.child(routine_name).child("Age ");
                        DatabaseReference weight_Ref = Root_reference.child(routine_name).child("Weight ");
                        DatabaseReference user_level_Ref = Root_reference.child(routine_name).child("Level ");
/*
calentamiento="2 Sets of 10-12 repetitions";    LISTO
                musculo="Chest";            LISTO
                exercise_1="Barbell Bench Press";
                exercise_2="Barbell Fly";
                exercise_3="Dumbell Bench Press";
                exercise_4="Chest Dip";
                weight_calentamiento=35;   LISTO
                weight=70;    LISTO
                series=4;       LISTO
                repeticiones="4-6";     LISTO
 */
                        //Level routine
                        DatabaseReference routine_plan_Ref_date = Root_reference.child(routine_name).child("Routine ").child("Date Created");
                        DatabaseReference routine_plan_Ref_day = Root_reference.child(routine_name).child("Routine ").child("Monday ");
                        //MONDAY
                        DatabaseReference routine_plan_Ref_machine = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Monday ").child("Exercise 1 ");
                        DatabaseReference routine_plan_Ref_machine_2 = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Monday ").child("Exercise 2 ");
                        DatabaseReference routine_plan_Ref_machine_3 = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Monday ").child("Exercise 3 ");
                        DatabaseReference routine_plan_Ref_machine_4 = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Monday ").child("Exercise 4 ");
                        //TUESDAY
                        DatabaseReference routine_plan_Ref_machine_Martes = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Tuesday ").child("Exercise 1 ");
                        DatabaseReference routine_plan_Ref_machine_2_Martes = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Tuesday ").child("Exercise 2 ");
                        DatabaseReference routine_plan_Ref_machine_3_Martes = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Tuesday ").child("Exercise 3 ");
                        DatabaseReference routine_plan_Ref_machine_4_Martes = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Tuesday ").child("Exercise 4 ");
                        //WEDNESDAY
                        DatabaseReference routine_plan_Ref_machine_Miercoles = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Wednesday ").child("Exercise 1 ");
                        DatabaseReference routine_plan_Ref_machine_2_Miercoles = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Wednesday ").child("Exercise 2 ");
                        DatabaseReference routine_plan_Ref_machine_3_Miercoles = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Wednesday ").child("Exercise 3 ");
                        DatabaseReference routine_plan_Ref_machine_4_Miercoles = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Wednesday ").child("Exercise 4 ");
                        //THURSDAY
                        DatabaseReference routine_plan_Ref_machine_Jueves = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Thursday ").child("Exercise 1 ");
                        DatabaseReference routine_plan_Ref_machine_2_Jueves = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Thursday ").child("Exercise 2 ");
                        DatabaseReference routine_plan_Ref_machine_3_Jueves = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Thursday ").child("Exercise 3 ");
                        DatabaseReference routine_plan_Ref_machine_4_Jueves = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Thursday ").child("Exercise 4 ");
                        //FRIDAY
                        DatabaseReference routine_plan_Ref_machine_Viernes = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Friday ").child("Exercise 1 ");
                        DatabaseReference routine_plan_Ref_machine_2_Viernes = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Friday ").child("Exercise 2 ");
                        DatabaseReference routine_plan_Ref_machine_3_Viernes = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Friday ").child("Exercise 3 ");
                        DatabaseReference routine_plan_Ref_machine_4_Viernes = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Friday ").child("Exercise 4 ");


                        //MONDAY
                        DatabaseReference routine_plan_Ref_peso = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Monday ").child("Weight ");
                        DatabaseReference routine_plan_Ref_repetitions = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Monday ").child("Repetitions ");
                        DatabaseReference routine_plan_Ref_series = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Monday ").child("Series ");
                        DatabaseReference routine_plan_Ref_calentamiento = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Monday ").child("Calentamiento ");
                        DatabaseReference routine_plan_Ref_weight_calentamiento = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Monday ").child("Peso de calentamiento ");
                        DatabaseReference routine_plan_Ref_musculo = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Monday ").child("Muscle ");


                        //TUESDAY
                        //DatabaseReference routine_plan_Ref_machine_MARTES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Tuesday ").child("Exercise ");
                        DatabaseReference routine_plan_Ref_peso_MARTES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Tuesday ").child("Weight ");
                        DatabaseReference routine_plan_Ref_repetitions_MARTES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Tuesday ").child("Repetitions ");
                        DatabaseReference routine_plan_Ref_series_MARTES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Tuesday ").child("Series ");
                        DatabaseReference routine_plan_Ref_calentamiento_MARTES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Tuesday ").child("Calentamiento ");
                        DatabaseReference routine_plan_Ref_weight_calentamiento_MARTES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Tuesday ").child("Peso de calentamiento ");
                        DatabaseReference routine_plan_Ref_musculo_MARTES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Tuesday ").child("Muscle ");


                        //WEDNESDAY
                        //DatabaseReference routine_plan_Ref_machine_MIERCOLES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Wednesday ").child("Exercise ");
                        DatabaseReference routine_plan_Ref_peso_MIERCOLES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Wednesday ").child("Weight ");
                        DatabaseReference routine_plan_Ref_repetitions_MIERCOLES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Wednesday ").child("Repetitions ");
                        DatabaseReference routine_plan_Ref_series_MIERCOLES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Wednesday ").child("Series ");
                        DatabaseReference routine_plan_Ref_calentamiento_MIERCOLES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Wednesday ").child("Calentamiento ");
                        DatabaseReference routine_plan_Ref_weight_calentamiento_MIERCOLES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Wednesday ").child("Peso de calentamiento ");
                        DatabaseReference routine_plan_Ref_musculo_MIERCOLES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Wednesday ").child("Muscle ");

                        //THURSDAY
                        //DatabaseReference routine_plan_Ref_machine_JUEVES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Thursday ").child("Exercise ");
                        DatabaseReference routine_plan_Ref_peso_JUEVES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Thursday ").child("Weight ");
                        DatabaseReference routine_plan_Ref_repetitions_JUEVES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Thursday ").child("Repetitions ");
                        DatabaseReference routine_plan_Ref_series_JUEVES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Thursday ").child("Series ");
                        DatabaseReference routine_plan_Ref_calentamiento_JUEVES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Thursday ").child("Calentamiento ");
                        DatabaseReference routine_plan_Ref_weight_calentamiento_JUEVES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Thursday ").child("Peso de calentamiento ");
                        DatabaseReference routine_plan_Ref_musculo_JUEVES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Thursday ").child("Muscle ");

                        //FRIDAY
                        //DatabaseReference routine_plan_Ref_machine_VIERNES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Friday ").child("Exercise ");
                        DatabaseReference routine_plan_Ref_peso_VIERNES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Friday ").child("Weight ");
                        DatabaseReference routine_plan_Ref_repetitions_VIERNES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Friday ").child("Repetitions ");
                        DatabaseReference routine_plan_Ref_series_VIERNES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Friday ").child("Series ");
                        DatabaseReference routine_plan_Ref_calentamiento_VIERNES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Friday ").child("Calentamiento ");
                        DatabaseReference routine_plan_Ref_weight_calentamiento_VIERNES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Friday ").child("Peso de calentamiento ");
                        DatabaseReference routine_plan_Ref_musculo_VIERNES = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Friday ").child("Muscle ");


                        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

                        name_Ref.setValue(user_name.getText().toString().trim());      //check for trim method
                        age_Ref.setValue(age);
                        weight_Ref.setValue(weight_user);
                        user_level_Ref.setValue(user_level);
                        routine_plan_Ref_date.setValue(date);
                        routine_plan_Ref_musculo.setValue(musculo_lunes);
                        routine_plan_Ref_calentamiento.setValue(calentamiento);
                        routine_plan_Ref_weight_calentamiento.setValue(weight_calentamiento);

                        //MONDAY
                        routine_plan_Ref_machine.setValue(exercise_1);
                        routine_plan_Ref_machine_2.setValue(exercise_2);
                        routine_plan_Ref_machine_3.setValue(exercise_3);
                        routine_plan_Ref_machine_4.setValue(exercise_4);
                        //TUESDAY
                        routine_plan_Ref_machine_Martes.setValue(exercise_1_martes);
                        routine_plan_Ref_machine_2_Martes.setValue(exercise_2_martes);
                        routine_plan_Ref_machine_3_Martes.setValue(exercise_3_martes);
                        routine_plan_Ref_machine_4_Martes.setValue(exercise_4_martes);

                        //WEDNESDAY
                        routine_plan_Ref_machine_Miercoles.setValue(exercise_1_miercoles);
                        routine_plan_Ref_machine_2_Miercoles.setValue(exercise_2_miercoles);
                        routine_plan_Ref_machine_3_Miercoles.setValue(exercise_3_miercoles);
                        routine_plan_Ref_machine_4_Miercoles.setValue(exercise_4_miercoles);

                        //THURSDAY
                        routine_plan_Ref_machine_Jueves.setValue(exercise_1_jueves);
                        routine_plan_Ref_machine_2_Jueves.setValue(exercise_2_jueves);
                        routine_plan_Ref_machine_3_Jueves.setValue(exercise_3_jueves);
                        routine_plan_Ref_machine_4_Jueves.setValue(exercise_4_jueves);
                        //FRIDAY
                        routine_plan_Ref_machine_Viernes.setValue(exercise_1_viernes);
                        routine_plan_Ref_machine_2_Viernes.setValue(exercise_2_viernes);
                        routine_plan_Ref_machine_3_Viernes.setValue(exercise_3_viernes);
                        routine_plan_Ref_machine_4_Viernes.setValue(exercise_4_viernes);

                        routine_plan_Ref_peso.setValue(weight);
                        routine_plan_Ref_repetitions.setValue(repeticiones);
                        routine_plan_Ref_series.setValue(series);


                        //TUESDAY

                        routine_plan_Ref_musculo_MARTES.setValue(musculo_martes);
                        routine_plan_Ref_calentamiento_MARTES.setValue(calentamiento);
                        routine_plan_Ref_weight_calentamiento_MARTES.setValue(weight_calentamiento);
                        //routine_plan_Ref_machine_MARTES.setValue(exercise_1_martes);
                        //routine_plan_Ref_machine_MARTES.setValue(exercise_2_martes);
                        //routine_plan_Ref_machine_MARTES.setValue(exercise_3_martes);
                        //routine_plan_Ref_machine_MARTES.setValue(exercise_4_martes);
                        routine_plan_Ref_peso_MARTES.setValue(weight);
                        routine_plan_Ref_repetitions_MARTES.setValue(repeticiones);
                        routine_plan_Ref_series_MARTES.setValue(series);

                        //WEDNESDAY
                        routine_plan_Ref_musculo_MIERCOLES.setValue(musculo_miercoles);
                        routine_plan_Ref_calentamiento_MIERCOLES.setValue(calentamiento);
                        routine_plan_Ref_weight_calentamiento_MIERCOLES.setValue(weight_calentamiento);
                        //routine_plan_Ref_machine_MIERCOLES.setValue(exercise_1_miercoles);
                        //routine_plan_Ref_machine_MIERCOLES.setValue(exercise_2_miercoles);
                        //routine_plan_Ref_machine_MIERCOLES.setValue(exercise_3_miercoles);
                        //routine_plan_Ref_machine_MIERCOLES.setValue(exercise_4_miercoles);
                        routine_plan_Ref_peso_MIERCOLES.setValue(weight);
                        routine_plan_Ref_repetitions_MIERCOLES.setValue(repeticiones);
                        routine_plan_Ref_series_MIERCOLES.setValue(series);

                        //THURSDAY
                        routine_plan_Ref_musculo_JUEVES.setValue(musculo_jueves);
                        routine_plan_Ref_calentamiento_JUEVES.setValue(calentamiento);
                        routine_plan_Ref_weight_calentamiento_JUEVES.setValue(weight_calentamiento);
                        //routine_plan_Ref_machine_JUEVES.setValue(exercise_1_jueves);
                        //routine_plan_Ref_machine_JUEVES.setValue(exercise_2_jueves);
                        //routine_plan_Ref_machine_JUEVES.setValue(exercise_3_jueves);
                        //routine_plan_Ref_machine_JUEVES.setValue(exercise_4_jueves);
                        routine_plan_Ref_peso_JUEVES.setValue(weight);
                        routine_plan_Ref_repetitions_JUEVES.setValue(repeticiones);
                        routine_plan_Ref_series_JUEVES.setValue(series);

                        //FRIDAY
                        routine_plan_Ref_musculo_VIERNES.setValue(musculo_viernes);
                        routine_plan_Ref_calentamiento_VIERNES.setValue(calentamiento);
                        routine_plan_Ref_weight_calentamiento_VIERNES.setValue(weight_calentamiento);
                        //routine_plan_Ref_machine_VIERNES.setValue(exercise_1_viernes);
                        //routine_plan_Ref_machine_VIERNES.setValue(exercise_2_viernes);
                        //routine_plan_Ref_machine_VIERNES.setValue(exercise_3_viernes);
                        //routine_plan_Ref_machine_VIERNES.setValue(exercise_4_viernes);
                        routine_plan_Ref_peso_VIERNES.setValue(weight);
                        routine_plan_Ref_repetitions_VIERNES.setValue(repeticiones);
                        routine_plan_Ref_series_VIERNES.setValue(series);


                        //Root_reference.setValue(routine_name);
                        Intent intent = new Intent(getActivity(), Calendario.class);
                        intent.putExtra("current_user_level", String.valueOf(user_level));
                        startActivity(intent);


                    }
                }catch(Exception e)
                {
                    Toast.makeText(getActivity(),"Please enter correct information",Toast.LENGTH_SHORT).show();
                }
                }



        });
        return view;
    }



    public FragmentWithButton() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentWithButton.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentWithButton newInstance(String param1, String param2) {
        FragmentWithButton fragment = new FragmentWithButton();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }




    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void toastText(String text, String text2);
    }
}
