package hu.bme.aut.spaceweatherapp.feature.picker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.List;

import hu.bme.aut.spaceweatherapp.R;
import hu.bme.aut.spaceweatherapp.data.db.CMEdatabase;
import hu.bme.aut.spaceweatherapp.data.entities.CME_item;
import hu.bme.aut.spaceweatherapp.feature.view.CMEAdapter;

public class CMEActivity extends AppCompatActivity {

    CMEdatabase cmeDatabase;
    RecyclerView recyclerView;
    CMEAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cme);

        cmeDatabase = Room.databaseBuilder(
                getApplicationContext(),
                CMEdatabase.class,
                "shopping-list"
        ).build();
        initRecyclerView();
        //loadItemsInBackground();
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.MainRecyclerView);
        adapter = new CMEAdapter();
        loadItemsInBackground();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void loadItemsInBackground() {
        new AsyncTask<Void, Void, List<CME_item>>() {

            @Override
            protected List<CME_item> doInBackground(Void... voids) {
                return cmeDatabase.cmeDao().getAll();
            }

            @Override
            protected void onPostExecute(List<CME_item> cme_items) {
                adapter.update(cme_items);
            }
        }.execute();
    }
}
