package hu.bme.aut.spaceweatherapp.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hu.bme.aut.spaceweatherapp.data.entities.SF_item;

@Dao
public interface SfDao {
    @Query("SELECT * FROM SF")
    List<SF_item> getAll();

    @Query("DELETE FROM SF")
    void deleteAll();

    @Insert
    long insert(SF_item sfItem);

    @Update
    void update(SF_item shoppsfItemingItem);

    @Delete
    void deleteItem(SF_item sfItem);
}
