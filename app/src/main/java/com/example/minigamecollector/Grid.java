package com.example.minigamecollector;

import android.widget.ImageView;

public class Grid {
    private int value[][];
    private ImageView imageViewObject[][];

    public Grid(int columnValue, int rowValue)
    {
        value = new int[columnValue][rowValue];
        imageViewObject = new ImageView[columnValue][rowValue];

    }

    public int sizeX()
    {
        return value[0].length;
    }

    public int sizeY()
    {
        return value[1].length;
    }

    public void setImageObject(int columnValue, int rowValue, ImageView currentImageView)
    {
        imageViewObject[columnValue][rowValue] = currentImageView;
    }

    public int getValue(int columnValue, int rowValue)
    {
        return value[columnValue][rowValue];
    }


    public void setValue(int columnValue, int rowValue, int givenValue)
    {
        value[columnValue][rowValue] = givenValue;
    }

    public void setCellImage(int columnValue, int rowValue,  int imageValue)
    {
        imageViewObject[columnValue][rowValue].setImageResource(imageValue);
    }

    public ImageView[][] getImageViewer()
    {
        return imageViewObject;
    }
}
