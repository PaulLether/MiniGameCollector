package com.example.minigamecollector;

public class Players {
    private int ID;
    private String name;
    private boolean playing;
    private String value;


    public Players(int givenID, String givenName, boolean givenPlaying, String givenValue)
    {
        setID(givenID);
        setName(givenName);
        setPlaying(givenPlaying);
        setValue(givenValue);
    }


    public int getID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
    }

    public boolean getPlaying()
    {
        return playing;
    }

    public String getValue()
    {
        return value;
    }

    public void setID(int givenID)
    {
        ID = givenID;
    }

    public void setName(String givenName)
    {
        name = givenName;
    }

    public void setPlaying(boolean givenPlaying)
    {
        playing = givenPlaying;
    }

    public void setValue(String givenValue)
    {
        value = givenValue;
    }

}
