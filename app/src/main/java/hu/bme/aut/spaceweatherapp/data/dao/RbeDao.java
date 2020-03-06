package hu.bme.aut.spaceweatherapp.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hu.bme.aut.spaceweatherapp.data.entities.RBE_item;

@Dao
public interface RbeDao {
    @Query("SELECT * FROM RBE")
    List<RBE_item> getAll();

    @Query("DELETE FROM RBE")
    void deleteAll();

    @Insert
    long insert(RBE_item shoppingItems);

    @Update
    void update(RBE_item shoppingItem);

    @Delete
    void deleteItem(RBE_item shoppingItem);
}
