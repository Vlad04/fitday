package info.androidhive.firebase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
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
    int user_level;
    String musculo;
    double weight_calentamiento;
    double weight;
    String exercise_1;
    String exercise_2;
    String exercise_3;
    String exercise_4;
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
                calentamiento="2 Sets of 10-12 repetitions";
                musculo="Chest";
                exercise_1="Bench Press";
                exercise_2="Incline Bench Press";
                exercise_3="Chest Dip";
                exercise_4="Machine Fly";
                weight_calentamiento=12.5;
                weight=20;
                series=4;
                repeticiones="4-6";

            }
        });
        medium_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_level=2;
                calentamiento="2 Sets of 10-12 repetitions";
                musculo="Chest";
                exercise_1="Barbell Bench Press";
                exercise_2="Barbell Incline Bench Press";
                exercise_3="Dumbell Bench Press";
                exercise_4="Dumbell Incline Bench Press";
                weight_calentamiento=25;
                weight=40;
                series=4;
                repeticiones="4-6";
            }
        });
        expert_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_level=3;
                calentamiento="2 Sets of 10-12 repetitions";
                musculo="Chest";
                exercise_1="Barbell Bench Press";
                exercise_2="Barbell Fly";
                exercise_3="Dumbell Bench Press";
                exercise_4="Chest Dip";
                weight_calentamiento=35;
                weight=70;
                series=4;
                repeticiones="4-6";
            }
        });
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
//              String key = fragment_input_db.getText().toString().trim();

                    final String routine_name = "Usuario " + user_name.getText().toString();
//              String name=user_name.getText().toString().trim();
                    final int age = Integer.parseInt(user_age.getText().toString().trim());
                    final double weight_user = Double.parseDouble(user_weight.getText().toString().trim());


                    //Level user
                    DatabaseReference name_Ref = Root_reference.child(routine_name).child("Name ");
                    DatabaseReference age_Ref = Root_reference.child(routine_name).child("Age ");
                    DatabaseReference weight_Ref = Root_reference.child(routine_name).child("Weight ");
                    DatabaseReference user_level_Ref=Root_reference.child(routine_name).child("Level ");
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
                    DatabaseReference routine_plan_Ref_date = Root_reference.child(routine_name).child("Routine ").child("Date ");
                    DatabaseReference routine_plan_Ref_machine = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Exercise ");
                    DatabaseReference routine_plan_Ref_peso = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Weight ");
                    DatabaseReference routine_plan_Ref_repetitions = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Repetitions ");
                    DatabaseReference routine_plan_Ref_series = Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Series ");
                    DatabaseReference routine_plan_Ref_calentamiento=Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Calentamiento ");
                    DatabaseReference routine_plan_Ref_weight_calentamiento=Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Peso de calentamiento ");
                    DatabaseReference routine_plan_Ref_musculo=Root_reference.child(routine_name).child("Routine ").child("Machine ").child("Muscle ");


                String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

                    name_Ref.setValue(user_name.getText().toString().trim());
                    age_Ref.setValue(age);
                    weight_Ref.setValue(weight_user);
                    user_level_Ref.setValue(user_level);
                    routine_plan_Ref_date.setValue(date);
                    routine_plan_Ref_musculo.setValue(musculo);
                    routine_plan_Ref_calentamiento.setValue(calentamiento);
                    routine_plan_Ref_weight_calentamiento.setValue(weight_calentamiento);
                    routine_plan_Ref_machine.setValue(exercise_1);
                    routine_plan_Ref_peso.setValue(weight);
                    routine_plan_Ref_repetitions.setValue(repeticiones);
                    routine_plan_Ref_series.setValue(series);
                    //Root_reference.setValue(routine_name);
                    Intent intent = new Intent(getActivity(), GenerarPlan.class);
                    startActivity(intent);
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
