package hu.bme.aut.spaceweatherapp.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hu.bme.aut.spaceweatherapp.data.entities.GS_item;

@Dao
public interface GsDao {
    @Query("SELECT * FROM GS")
    List<GS_item> getAll();

    @Query("DELETE FROM GS")
    void deleteAll();

    @Insert
    long insert(GS_item gsItem);

    @Update
    void update(GS_item gsItem);

    @Delete
    void deleteItem(GS_item gsItem);
}
