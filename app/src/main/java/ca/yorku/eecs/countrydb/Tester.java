package ca.yorku.eecs.countrydb;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Tester
{
    public static void main(String args[]){
        try
        {
            CountryDB db = new CountryDB();
            List<String> capitals = db.getCapitals();
            System.out.println(capitals.size());
            String c = capitals.get(107);
            System.out.println(c);

            Map<String, Country> data = db.getData();
            System.out.println(data.size());
            Country ref = data.get(c);
            System.out.println(ref.toString());

            Game g = new Game();


        }
        catch (Exception e){
        }
    }
}
