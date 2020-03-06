package hu.bme.aut.spaceweatherapp.data.types;

import androidx.room.TypeConverter;

import java.util.ArrayList;

public class CMEAnalyses {
    public Double latitude;
    public Double longitude;
    public Double speed;
    public String type;

    /*
    public CMEAnalyses(Double latitude, Double longitude, Double speed, String type) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.speed = speed;
        this.type = type;
    }
    public CMEAnalyses(){};



    @TypeConverter
    public CMEAnalyses fromValues(ArrayList<Object> list){
        return new CMEAnalyses((Double)list.get(0),(Double)list.get(1),(Double)list.get(2),(String)list.get(3));
    }

    @TypeConverter
    public ArrayList<Object> CMEAnalyses(CMEAnalyses cmeAnalyses){
        ArrayList<Object> list=new ArrayList<>();
        list.add(cmeAnalyses.latitude);
        list.add(cmeAnalyses.longitude);
        list.add(cmeAnalyses.speed);
        list.add(cmeAnalyses.type);
        return list;
    }*/
}
