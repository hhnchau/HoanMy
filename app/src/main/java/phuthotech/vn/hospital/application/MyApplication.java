package phuthotech.vn.hospital.application;

import android.app.Application;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import phuthotech.vn.hospital.api.ApiService;
import phuthotech.vn.hospital.api.Host;
import phuthotech.vn.hospital.api.RequestInterceptor;
import phuthotech.vn.hospital.log.MyLog;
import phuthotech.vn.hospital.model.api.patient.Form;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kingpes on 8/20/18.
 */

public class MyApplication extends Application {
    public static ApiService apiService;
    @Override
    public void onCreate() {
        super.onCreate();

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(new RequestInterceptor());
        builder.connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS);
        OkHttpClient okHttpClient = builder.build();


        try {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Host.URL)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();

            apiService = retrofit.create(ApiService.class);

        }catch (Exception e){
            e.printStackTrace();
            MyLog.print("Cannot connect to server!");
        }
    }

    /*
    * Variable
    */
    private Form form;

    public Form getForm(){
        return form;
    }

    public void setCommon(Form form){
        this.form = form;
    }

    //((MyApplication) this.getApplication()).setCommon("");

    //((MyApplication) this.getApplication()).getCommon("");
}
