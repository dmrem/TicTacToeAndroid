package com.dmrem.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    boolean AIEnabled;
    boolean currentPlayer;
    byte[] boardState; // ordered left to right, top to bottom, 0=x, 1=o, else=empty
    ImageButton[] buttons;
    TextView currentPlayerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        String opponent = intent.getStringExtra(MainActivity.OPPONENT_TYPE);

        if(opponent.equals("Human")){
            AIEnabled = false;
        }
        else{
            throw new UnsupportedOperationException("Unknown opponent type!");
        }

        currentPlayer = true;
        boardState = new byte[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
        buttons = new ImageButton[]{
                findViewById(R.id.imbtnTL), findViewById(R.id.imbtnTM), findViewById(R.id.imbtnTR),
                findViewById(R.id.imbtnML), findViewById(R.id.imbtnMM), findViewById(R.id.imbtnMR),
                findViewById(R.id.imbtnBL), findViewById(R.id.imbtnBM), findViewById(R.id.imbtnBR)
            };
        refreshBoard();
        currentPlayerTextView = findViewById(R.id.txvCurrentPlayer);
        currentPlayerTextView.setText(R.string.playerOnesTurn);
    }

    /**
     * Changes the images that each image button shows according to the current board state.
     */
    protected void refreshBoard(){
        for(int i = 0; i < 9; i++){
            switch (boardState[i]){
                case 0:
                    buttons[i].setImageResource(R.drawable.x);
                    break;
                case 1:
                    buttons[i].setImageResource(R.drawable.o);
                    break;
                default:
                    buttons[i].setImageResource(R.drawable.black);
                    break;
            }
        }
    }

    /**
     * Processes the player's chosen move and prepares for the other player's turn.
     * If AI is enabled, plays the AI's move as well (not yet implemented).
     */
    protected void postMoveWork(){
        currentPlayer = !currentPlayer;
        currentPlayerTextView.setText(currentPlayer ? R.string.playerOnesTurn : R.string.playerTwosTurn);
        refreshBoard();
    }

    /**
     * Resets the game.
     * @param view Unused.
     */
    public void clickResetButton(View view){
        currentPlayer = true;
        currentPlayerTextView.setText(R.string.playerOnesTurn);
        boardState = new byte[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
        refreshBoard();
    }

    // From here on are all the event handling functions for the 9 buttons in the tic tac toe grid
    
    public void clickTopLeft(View view) {
        if (boardState[0] != 0 && boardState[0] != 1) {
            boardState[0] = (byte) (currentPlayer ? 0 : 1);
            postMoveWork();
        }
    }

    public void clickTopMiddle(View view) {
        if (boardState[1] != 0 && boardState[1] != 1) {
            boardState[1] = (byte) (currentPlayer ? 0 : 1);
            postMoveWork();
        }
    }

    public void clickTopRight(View view) {
        if (boardState[2] != 0 && boardState[2] != 1) {
            boardState[2] = (byte) (currentPlayer ? 0 : 1);
            postMoveWork();
        }
    }


    public void clickMiddleLeft(View view) {
        if (boardState[3] != 0 && boardState[3] != 1) {
            boardState[3] = (byte) (currentPlayer ? 0 : 1);
            postMoveWork();
        }
    }

    public void clickMiddleMiddle(View view) {
        if (boardState[4] != 0 && boardState[4] != 1) {
            boardState[4] = (byte) (currentPlayer ? 0 : 1);
            postMoveWork();
        }
    }

    public void clickMiddleRight(View view) {
        if (boardState[5] != 0 && boardState[5] != 1) {
            boardState[5] = (byte) (currentPlayer ? 0 : 1);
            postMoveWork();
        }
    }


    public void clickBottomLeft(View view) {
        if (boardState[6] != 0 && boardState[6] != 1) {
            boardState[6] = (byte) (currentPlayer ? 0 : 1);
            postMoveWork();
        }
    }

    public void clickBottomMiddle(View view) {
        if (boardState[7] != 0 && boardState[7] != 1) {
            boardState[7] = (byte) (currentPlayer ? 0 : 1);
            postMoveWork();
        }
    }

    public void clickBottomRight(View view) {
        if (boardState[8] != 0 && boardState[8] != 1) {
            boardState[8] = (byte) (currentPlayer ? 0 : 1);
            postMoveWork();
        }
    }
}