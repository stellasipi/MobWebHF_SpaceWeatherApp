package hu.bme.aut.spaceweatherapp.network;

import java.util.List;

import hu.bme.aut.spaceweatherapp.data.types.CME;
import hu.bme.aut.spaceweatherapp.data.types.GS;
import hu.bme.aut.spaceweatherapp.data.types.RBE;
import hu.bme.aut.spaceweatherapp.data.types.SF;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DonkiApi {
    @GET("CME")
    Call<List<CME>> getCME(
            @Query("startDate") String startDate,
            @Query("endDate") String endDate
    );
    @GET("GST")
    Call<List<GS>> getGS(
            @Query("startDate") String startDate,
            @Query("endDate") String endDate
    );
    @GET("FLR")
    Call<List<SF>> getSF(
            @Query("startDate") String startDate,
            @Query("endDate") String endDate
    );
    @GET("RBE")
    Call<List<RBE>> getRBE(
            @Query("startDate") String startDate,
            @Query("endDate") String endDate
    );
}

