package hu.bme.aut.spaceweatherapp.data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import hu.bme.aut.spaceweatherapp.data.types.RBEins;

@Entity(tableName = "RBE")
public class RBE_item {
    @PrimaryKey(autoGenerate = true)
    public Long id;
    public String rbeID;
    public RBEins instruments;
}
