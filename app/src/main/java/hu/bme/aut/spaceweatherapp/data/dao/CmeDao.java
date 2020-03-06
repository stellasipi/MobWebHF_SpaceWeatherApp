package hu.bme.aut.spaceweatherapp.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hu.bme.aut.spaceweatherapp.data.entities.CME_item;

@Dao
public interface CmeDao {
    @Query("SELECT * FROM CME")
    List<CME_item> getAll();

    @Query("DELETE FROM CME")
    void deleteAll();

    @Insert
    long insert(CME_item cmeItem);

    @Update
    void update(CME_item cmeItem);

    @Delete
    void deleteItem(CME_item cmeItem);
}
