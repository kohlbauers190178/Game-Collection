package net.htlgkr.kohlbauers190178.gamecollection;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button btnStartTicTacToe;
    Button btnStartPPSTest;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        btnStartTicTacToe = view.findViewById(R.id.btnStartTicTacToeGame);
        btnStartPPSTest = view.findViewById(R.id.btnStartPPSTestGame);

        btnStartTicTacToe.setOnClickListener(this);
        btnStartPPSTest.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        Button btnClicked = getActivity().findViewById(view.getId());


        if (btnClicked.getId() == btnStartTicTacToe.getId()) {
            startTicTacToeGame();
        } else if (btnClicked.getId() == btnStartPPSTest.getId()) {
            startPPSGame();
        } else {
            Toast.makeText(getActivity(), "Error choosing game", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    private void startPPSGame() {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.constraintLayout, PressPerSecondTestFragment.newInstance("", ""), "PressPerSecondTestFragment")
                .addToBackStack(null)
                .commit();
    }


    public void startTicTacToeGame() {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.constraintLayout, TicTacToeFragment.newInstance("", ""), "TicTacToeFragment")
                .addToBackStack(null)
                .commit();
    }
}