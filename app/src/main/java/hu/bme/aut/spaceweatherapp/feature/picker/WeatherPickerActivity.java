package hu.bme.aut.spaceweatherapp.feature.picker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import hu.bme.aut.spaceweatherapp.R;
import hu.bme.aut.spaceweatherapp.data.db.CMEdatabase;
import hu.bme.aut.spaceweatherapp.data.types.CME;
import hu.bme.aut.spaceweatherapp.data.types.GS;
import hu.bme.aut.spaceweatherapp.data.types.RBE;
import hu.bme.aut.spaceweatherapp.data.types.SF;
import hu.bme.aut.spaceweatherapp.network.NetworkManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.slybeaver.slycalendarview.SlyCalendarDialog;

public class WeatherPickerActivity extends AppCompatActivity implements SlyCalendarDialog.Callback {

    Button backToCalendar;
    Calendar pickedFirstDate;
    Calendar pickedSecondDate;
    NetworkManager networkManager;
    //CMEdatabase cmeDatabase;

    public List<CME> cmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_picker);
        new SlyCalendarDialog()
                .setSingle(false)
                .setCallback(WeatherPickerActivity.this)
                .setEndDate(new Date())
                .show(getSupportFragmentManager(), "TAG_SLYCALENDAR");

        backToCalendar=findViewById(R.id.btCal);

        /*cmeDatabase= Room.databaseBuilder(
                getApplicationContext(),
                CMEdatabase.class,
                "cme-database"
        ).build();*/

        backToCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SlyCalendarDialog()
                        .setSingle(false)
                        .setCallback(WeatherPickerActivity.this)
                        .setStartDate(pickedFirstDate.getTime())
                        .setEndDate(pickedSecondDate.getTime())
                        .show(getSupportFragmentManager(), "TAG_SLYCALENDAR");
            }
        });

        //Coronal Mass Ejection
        ImageButton btnCME=findViewById(R.id.btnCME);
        btnCME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showDetailsIntent = new Intent();
                showDetailsIntent.setClass(WeatherPickerActivity.this, CMEActivity.class);
                startActivity(showDetailsIntent);
            }
        });

        //Geomagnetic Storm
        /*ImageButton btnGS=findViewById(R.id.btnGS);
        btnCME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gsIntent=new Intent(WeatherPickerActivity.this, GSActivity.class);
                startActivity(gsIntent);
            }
        });

        //Radiation Belt Enhancement
        ImageButton btnRBE=findViewById(R.id.btnRBE);
        btnCME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rbeIntent=new Intent(WeatherPickerActivity.this, RBEActivity.class);
                startActivity(rbeIntent);
            }
        });

        //Solar Flare
        ImageButton btnSF=findViewById(R.id.btnSF);
        btnCME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sfIntent=new Intent(WeatherPickerActivity.this, SFActivity.class);
                startActivity(sfIntent);
            }
        });*/


    }

    /*@Override
    public void onDateSelected(int year, int month, int day) {

        tempPickedDate=Calendar.getInstance();
        tempPickedDate.set(year,month,day);
        pickedDate=tempPickedDate.getTime();
        test.setText(pickedDate.toString());


    }*/


    @Override
    public void onCancelled() {

    }

    @Override
    public void onDataSelected(Calendar firstDate, Calendar secondDate, int hours, int minutes) {
        pickedFirstDate=firstDate;
        pickedSecondDate=secondDate;
        String firstDateS="";
        String secondDateS="";
        if(firstDate!=null){firstDateS=firstDate.get(Calendar.YEAR)+"-"+(firstDate.get(Calendar.MONTH)+1)+"-"+firstDate.get(Calendar.DAY_OF_MONTH);}
        if(secondDate!=null){secondDateS=secondDate.get(Calendar.YEAR)+"-"+(secondDate.get(Calendar.MONTH)+1)+"-"+secondDate.get(Calendar.DAY_OF_MONTH);}

        //CME
        NetworkManager.getInstance().getCME(firstDateS,secondDateS).enqueue(new Callback<List<CME>>() {
            @Override
            public void onResponse(Call<List<CME>> call, Response<List<CME>> response) {
                //a db-be majd itt kell beolvasni
                cmes=response.body();
                /*for(CME cme:cmes){
                    final CME_item temp;
                    new AsyncTask<Void,Void,CME_item>(){
                        @Override
                        protected CME_item doInBackground(Void... voids) {
                            temp.id = cmeDatabase.cmeDao().insert(temp);
                            return temp;
                        }
                        @Override
                        protected void onPostExecute(CME_item cme_item){

                        }
                    }.execute();
                }*/

            }

            @Override
            public void onFailure(Call<List<CME>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Didn't get any data",Toast.LENGTH_SHORT).show();
            }
        });

        //GS
        NetworkManager.getInstance().getGS(firstDateS,secondDateS).enqueue(new Callback<List<GS>>() {
            @Override
            public void onResponse(Call<List<GS>> call, Response<List<GS>> response) {
                //a db-be majd itt kell beolvasni
                List<GS> gses=response.body();
            }

            @Override
            public void onFailure(Call<List<GS>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Didn't get any data",Toast.LENGTH_SHORT).show();
            }
        });

        //RBE
        NetworkManager.getInstance().getRBE(firstDateS,secondDateS).enqueue(new Callback<List<RBE>>() {
            @Override
            public void onResponse(Call<List<RBE>> call, Response<List<RBE>> response) {
                //a db-be majd itt kell beolvasni
                List<RBE> rbes=response.body();

            }

            @Override
            public void onFailure(Call<List<RBE>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Didn't get any data",Toast.LENGTH_SHORT).show();
            }
        });

        //SF
        NetworkManager.getInstance().getSF(firstDateS,secondDateS).enqueue(new Callback<List<SF>>() {
            @Override
            public void onResponse(Call<List<SF>> call, Response<List<SF>> response) {
                //a db-be majd itt kell beolvasni
                List<SF> sfs=response.body();
            }

            @Override
            public void onFailure(Call<List<SF>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Didn't get any data",Toast.LENGTH_SHORT).show();
                Log.d("onFailure",t.getMessage());
            }
        });

    }
}
