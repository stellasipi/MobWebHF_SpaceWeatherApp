package hu.bme.aut.spaceweatherapp.network;

import java.util.List;

import hu.bme.aut.spaceweatherapp.data.types.CME;
import hu.bme.aut.spaceweatherapp.data.types.GS;
import hu.bme.aut.spaceweatherapp.data.types.RBE;
import hu.bme.aut.spaceweatherapp.data.types.SF;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    private static final String SERVICE_URL = "https://kauai.ccmc.gsfc.nasa.gov/DONKI/WS/get/";

    private static NetworkManager instance;

    public static NetworkManager getInstance() {
        if (instance == null) {
            instance = new NetworkManager();
        }
        return instance;
    }

    private Retrofit retrofit;
    private DonkiApi donkiApi;

    private NetworkManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(SERVICE_URL)
                .client(new OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        donkiApi = retrofit.create(DonkiApi.class);
    }

    public Call<List<CME>> getCME(String startDate, String endDate) {
        return donkiApi.getCME(startDate,endDate);
    }
    public Call<List<GS>> getGS(String startDate, String endDate) {
        return donkiApi.getGS(startDate,endDate);
    }
    public Call<List<RBE>> getRBE(String startDate, String endDate) {
        return donkiApi.getRBE(startDate,endDate);
    }
    public Call<List<SF>> getSF(String startDate, String endDate) {
        return donkiApi.getSF(startDate,endDate);
    }


}
