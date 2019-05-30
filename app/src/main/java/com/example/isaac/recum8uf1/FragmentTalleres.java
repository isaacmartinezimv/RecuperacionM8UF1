package com.example.isaac.recum8uf1;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class FragmentTalleres extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentTalleres() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentTalleres newInstance(String param1, String param2) {
        FragmentTalleres fragment = new FragmentTalleres();
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
        View view = inflater.inflate(R.layout.fragment_talleres, container, false);

        HiloAPI hilo = new HiloAPI();
        hilo.execute("https://jdarestaurant.firebaseio.com/talleres.json");

        return view;
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    class HiloAPI extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            // Declaramos una variable de tipo HttpURLConection, una de tipo URL y una de tipo string
            HttpURLConnection connection;
            URL url;
            connection = null;
            String result;
            result ="";

            // Intentamos realizar la conexión a API obteniendo el link que le hemos pasado a esta clase por parametro mediante strings[0]
            try{
                url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();

                //Leemos los datos de entrada
                InputStream inputStream = connection.getInputStream();


                // Hacemos un bucle para leer y guardar caracter a caracter los datos de entrada en nuestra variable “result”
                int data = inputStream.read();
                while(data != -1) {
                    result += (char) data;
                    data = inputStream.read();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Una vez tenemos todos los datos, los retornamos
            Log.i("RESULT", result);
            return result;
        }
    }
}
