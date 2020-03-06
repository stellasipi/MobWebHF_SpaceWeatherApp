package hu.bme.aut.spaceweatherapp.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import hu.bme.aut.spaceweatherapp.data.dao.CmeDao;
import hu.bme.aut.spaceweatherapp.data.entities.CME_item;
import hu.bme.aut.spaceweatherapp.data.types.CMEAnalyses;

@Database(
        entities = {CME_item.class},
        version = 1,
        exportSchema = false
)
//@TypeConverters(value = {CMEAnalyses.class})
public abstract class CMEdatabase extends RoomDatabase {
    public abstract CmeDao cmeDao();
}
