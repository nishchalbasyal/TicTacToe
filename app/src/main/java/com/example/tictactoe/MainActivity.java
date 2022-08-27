package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,btnRestart;
    TextView header;

    int player_o = 0;
    int player_x = 1;

    int[] filler = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    boolean condition = true;

    int active_player = player_o;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        header = findViewById(R.id.textView2);
        header.setText("O Turn");
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btnRestart = findViewById(R.id.button19);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartGame();
            }
        });



    }




    @Override
    public void onClick(View v) {

        Button clickedBtn = findViewById(v.getId());

        if (!condition) {
            return;
        }

        int clickedTag = Integer.parseInt((v.getTag().toString()));
        if (filler[clickedTag] != -1) {
            return;
        }
        filler[clickedTag] = active_player;
        if (active_player == player_o) {
            clickedBtn.setText("O");
            active_player = player_x;
            clickedBtn.setBackgroundColor(getResources().getColor((R.color.orange)));
            header.setText("X Turn");


        } else {
            clickedBtn.setText("X");
            active_player = player_o;
            clickedBtn.setBackgroundColor(getResources().getColor((R.color.skyblue)));
            header.setText("O Turn");

        }

        checkForWin();


    }

    public void checkForWin() {
        int[][] winPos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

        for (int i = 0; i < 8; i++) {
            int val0 = winPos[i][0];
            int val1 = winPos[i][1];
            int val2 = winPos[i][2];

            if (filler[val0] == filler[val1] && filler[val0] == filler[val2]) {
                if (filler[val0] != -1) {

                    condition = false;

                    if (filler[val0] == player_o && filler[val1] == player_o && filler[val2] == player_o){
                        showDialog("O is winner");}
                    else {
                        showDialog("X is winner");
                    }
                    break;

                }
            }
        }
    }


        public void showDialog (String Winner){
            new AlertDialog.Builder(this)
                    .setTitle(Winner)
                    .setPositiveButton("Restart Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            restartGame();
                        }
                    })
                    .show();



        }

        public void restartGame () {
            active_player = player_o;
            header.setText("O turn");
            filler = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
            btn1.setText("");
            btn2.setText("");
            btn3.setText("");
            btn4.setText("");
            btn5.setText("");
            btn6.setText("");
            btn7.setText("");
            btn8.setText("");
            btn9.setText("");

            btn1.setBackgroundColor(getResources().getColor((R.color.purple_500)));
            btn2.setBackgroundColor(getResources().getColor((R.color.purple_500)));
            btn3.setBackgroundColor(getResources().getColor((R.color.purple_500)));
            btn4.setBackgroundColor(getResources().getColor((R.color.purple_500)));
            btn5.setBackgroundColor(getResources().getColor((R.color.purple_500)));
            btn6.setBackgroundColor(getResources().getColor((R.color.purple_500)));
            btn7.setBackgroundColor(getResources().getColor((R.color.purple_500)));
            btn8.setBackgroundColor(getResources().getColor((R.color.purple_500)));
            btn9.setBackgroundColor(getResources().getColor((R.color.purple_500)));

            condition = true;


        }

    }



