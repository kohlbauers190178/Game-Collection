package net.htlgkr.kohlbauers190178.gamecollection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportFragmentManager().beginTransaction().replace(R.id.constraintLayout, MainFragment.newInstance("",""), "MainFragment").addToBackStack(null).commit();
    }

    @Override
    public void onClick(View view) {
        /*
        Button btnClicked = findViewById(view.getId());


        if (btnClicked.getId() == R.id.btnStartTicTacToeGame) {
            startTicTacToeGame();
        } else if (btnClicked.getId() == R.id.btnStartPPSTestGame) {
            startPPSGame();
        } else {
            Toast.makeText(this, "Error choosing game", Toast.LENGTH_SHORT).show();
            return;
        }

        findViewById(R.id.btnStartTicTacToeGame).setVisibility(View.GONE);
        findViewById(R.id.btnStartPPSTestGame).setVisibility(View.GONE);
        */

    }

    private void startPPSGame() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.constraintLayout, PressPerSecondTestFragment.newInstance("", ""), "PressPerSecondTestFragment")
                .addToBackStack(null)
                .commit();
    }


    public void startTicTacToeGame() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.constraintLayout, TicTacToeFragment.newInstance("", ""), "TicTacToeFragment")
                .addToBackStack(null)
                .commit();
    }
}