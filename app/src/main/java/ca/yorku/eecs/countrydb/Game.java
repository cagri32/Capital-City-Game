package ca.yorku.eecs.countrydb;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game
{
    private CountryDB db;
    public GameActivity activity;
    public String an;

    public Game(){
        this.db = new CountryDB();
    }

    public String qa()
    {
        Map<String, Country> data = db.getData();
        List<String> capitals = db.getCapitals();
        int numberofData = data.size();
        int index = (int)(numberofData*Math.random());  //Random Number Generator to pick a country
        String c = capitals.get(index); //Random Capital City
        Country ref = data.get(c);
        String s ="";
        double random = Math.random();
        if (random < 0.5){
            s ="What is the capital of " +ref.getName()+" ?";
            an = ref.getCapital();
//            s +="\nYour Answer: ";
//            s += "\nCorrect Answer: "+ref.getCapital();
        }
        else {
            s =ref.getCapital()+" is the capital of?";
            an = ref.getName();
//            s +="\nYour Answer: ";
//            s += "\nCorrect Answer: "+ref.getName();
        }


        return  s;
    }

    public boolean correct(){

        return an.equalsIgnoreCase(activity.getAnswer());
    }

}
