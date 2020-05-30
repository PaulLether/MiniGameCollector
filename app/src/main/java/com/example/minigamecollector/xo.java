package com.example.minigamecollector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class xo extends AppCompatActivity implements Game{

    private Grid currentGrid;
    private Button buttonPlay;
    private boolean gameInProcess = false;
    private int currentGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xo);

        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        currentGrid = new Grid(3,3);
        int currentCell = 1;

        for(int columnIndex = 0; columnIndex < 3 ; columnIndex++)
        {
            for(int rowIndex = 0 ; rowIndex < 3 ; rowIndex++)
            {

                String currentView = "imageView" + currentCell;
                currentGrid.setValue(columnIndex, rowIndex, -1);
                int resID = getResources().getIdentifier(currentView, "id", getPackageName());
                currentGrid.setImageObject(columnIndex, rowIndex,(ImageView) findViewById(resID));
                imagePressed((ImageView) findViewById(resID), currentCell);
                currentCell++;
            }
        }
        cellImageSet();

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startButtonPress(v);
            }
        });

    }

    public void cellImageSet()
    {
        for(int columnIndex = 0; columnIndex < 3 ; columnIndex++)
        {
            for(int rowIndex = 0 ; rowIndex < 3 ; rowIndex++)
            {
                if(currentGrid.getValue(columnIndex, rowIndex) == -1)
                    currentGrid.setCellImage(columnIndex, rowIndex, R.drawable.empty);
                else if(currentGrid.getValue(columnIndex, rowIndex) == 0)
                    currentGrid.setCellImage(columnIndex, rowIndex, R.drawable.xgo);
                else if(currentGrid.getValue(columnIndex, rowIndex) == 1)
                    currentGrid.setCellImage(columnIndex, rowIndex, R.drawable.ogo);
            }
        }

    }

    public void imagePressed(ImageView givenView, final int currentCell)
    {
        givenView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // checking if a game is in progress
                    if(gameInProcess) {
                        // checking that the cell hasn't already got a value
                        int columnValue = findColumn(currentCell);
                        int rowValue = findRow(currentCell);

                        if(currentGrid.getValue(columnValue, rowValue) == -1) {
                            Log.i("value", "times = " + currentCell);
                            currentGrid.setValue(columnValue, rowValue, currentGo);
                            cellImageSet();

                            if(checkEnd())
                            {
                                endGame();
                            }
                            else
                            {
                                swapGo();
                            }
                        }
                        else
                        {
                            screenMessage("That place has already been taken");
                        }
                    }
                }
            });
    }

    public void swapGo()
    {
        if(currentGo == 0)
            currentGo = 1;
        else
            currentGo = 0;
    }

    public int findRow(int givenNumber)
    {
        givenNumber--;
        return givenNumber%3;
    }

    public int findColumn(int givenNumber)
    {
        givenNumber--;
        return givenNumber/3;
    }

    public void startButtonPress(View v)
    {
        startGame();
        buttonPlay.setText("Restart");
        gameInProcess = true;
    }

    @Override
    public void startGame() {
        for(int columnIndex = 0; columnIndex < 3 ; columnIndex++)
        {
            for(int rowIndex = 0 ; rowIndex < 3 ; rowIndex++)
            {
                currentGrid.setValue(columnIndex, rowIndex,-1);
            }
        }
        currentGo = 0;
        cellImageSet();
    }

    public void screenMessage(String message)
    {
        Context context = getApplicationContext();
        CharSequence text = "" + message;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    @Override
    public void endGame() {
        if(currentGo == 0)
            screenMessage("X won");
        else
            screenMessage("O won");
        gameInProcess = false;

    }

    @Override
    public boolean checkEnd() {
        // method checks if there is a winner
        for(int currentPlayer = 0 ; currentPlayer < 2 ; currentPlayer++)
        {
            /*
                    x  x  x
                    -  -  -
                    -  -  -
            */
            if(currentGrid.getValue(0,0) == currentPlayer
               && currentGrid.getValue(1,0) == currentPlayer
               && currentGrid.getValue(2,0) == currentPlayer)
            {
                return true;
            }
            /*
                    -  -  -
                    x  x  x
                    -  -  -
            */
            else if(currentGrid.getValue(0,1) == currentPlayer
                    && currentGrid.getValue(1,1) == currentPlayer
                    && currentGrid.getValue(2,1) == currentPlayer)
            {
                return true;
            }
             /*
                    -  -  -
                    -  -  -
                    x  x  x
            */
            else if(currentGrid.getValue(0,2) == currentPlayer
                    && currentGrid.getValue(1,2) == currentPlayer
                    && currentGrid.getValue(2,2) == currentPlayer)
            {
                return true;
            }
            /*
                    x  -  -
                    -  x  -
                    -  -  x
            */
            else if(currentGrid.getValue(0,0) == currentPlayer
                    && currentGrid.getValue(1,1) == currentPlayer
                    && currentGrid.getValue(2,2) == currentPlayer)
            {
                return true;
            }
            /*
                    -  -  x
                    -  x  -
                    x  -  -
            */
            else if(currentGrid.getValue(2,0) == currentPlayer
                    && currentGrid.getValue(1,1) == currentPlayer
                    && currentGrid.getValue(0,2) == currentPlayer)
            {
                return true;
            }
            /*
                    x  -  -
                    x  -  -
                    x  -  -
            */
            else if(currentGrid.getValue(0,0) == currentPlayer
                    && currentGrid.getValue(0,1) == currentPlayer
                    && currentGrid.getValue(0,2) == currentPlayer)
            {
                return true;
            }
             /*
                    -  x  -
                    -  x  -
                    -  x  -
            */
            else if(currentGrid.getValue(1,0) == currentPlayer
                    && currentGrid.getValue(1,1) == currentPlayer
                    && currentGrid.getValue(1,2) == currentPlayer)
            {
                return true;
            }
             /*
                    -  -  x
                    -  -  x
                    -  -  x
            */
            else if(currentGrid.getValue(2,0) == currentPlayer
                    && currentGrid.getValue(2,1) == currentPlayer
                    && currentGrid.getValue(2,2) == currentPlayer)
            {
                return true;
            }
        }
        return false;
    }


}


