package com.livtask;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.JsonElement;
import com.livtask.data.api.RetrofitInstance;
import com.livtask.data.api.RetrofitInterface;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApplicationController extends Application {

    public static JSONObject languageJsonObject;
    public static String languageKey;

    @Override
    public void onCreate() {
        super.onCreate();
        fetchLanguageModel();
    }

    /**
     * Method to fetch vernacular json
     */
    private void fetchLanguageModel() {
        Call<JsonElement> call = getServerInstance().getEngLang();
        call.enqueue(callback);
    }

    public final Callback<JsonElement> callback = new Callback<JsonElement>() {
        @Override
        public void onResponse(@NonNull Call<JsonElement> call, @NonNull Response<JsonElement> response) {
            try {
                languageJsonObject = new JSONObject(response.body().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onFailure(@NonNull Call<JsonElement> call, Throwable t) {
            Log.e("CALLBACK",t.getLocalizedMessage());
        }
    };

    /**
     * Method to retrieve the Retrofit instance
     * @return RetrofitInterface This returns RetrofitInterface instance for network calls.
     */
    private RetrofitInterface getServerInstance() {
        return RetrofitInstance.getRetrofitInstance().create(RetrofitInterface.class);
    }
}
