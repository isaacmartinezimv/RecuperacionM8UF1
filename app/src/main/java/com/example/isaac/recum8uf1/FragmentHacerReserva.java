package com.example.isaac.recum8uf1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FragmentHacerReserva extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Elementos de pantalla
    EditText edtValoracion;
    EditText edtComentarios;
    Button btnHacerComentario;

    //Declaramos variables para Firebase
    FirebaseDatabase database;
    DatabaseReference databaseReference;

    //Definimos el nombre del elemento raiz de la base de datos
    String databasePath = "talleres";


    private OnFragmentInteractionListener mListener;

    public FragmentHacerReserva() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentHacerReserva newInstance(String param1, String param2) {
        FragmentHacerReserva fragment = new FragmentHacerReserva();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hacer_reserva, container, false);

        edtValoracion = view.findViewById(R.id.editValoracionID);
        edtComentarios = view.findViewById(R.id.editComentariosID);
        btnHacerComentario = view.findViewById(R.id.btnHacerComentrio);

        //Firebase Database
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference(databasePath);

        //Generamos listerner para el boton
        btnHacerComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hacerComentario();
            }
        });

        return view;
    }

    //Funcion que lee los datos introducidos por el usuario y los escribe en firebase DB
    private void hacerComentario(){
        final String valoraciones = edtValoracion.getText().toString();
        final String comentarios = edtComentarios.getText().toString();

        //Instanciamos un objeto TallerModel
        TallerModel nuevoTaller = new TallerModel(valoraciones, comentarios);

        //creamos una clave para introducir un elemento en FB
        String nuevoTallerID = databaseReference.push().getKey();

        //creamos un hijo con esta clave e introducimos los datos del objeto TallerModel
        databaseReference.child(nuevoTallerID).setValue(nuevoTaller);
        Toast.makeText(getActivity(), "Comentario Añadido", Toast.LENGTH_SHORT).show();
        clearEditFields();
    }
    
    public void clearEditFields(){
        SystemClock.sleep(500);
        edtComentarios.getText().clear();
        edtValoracion.getText().clear();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

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
        void onFragmentInteraction(Uri uri);
    }
}
