package phuthotech.vn.hospital.api;

import io.reactivex.Observable;
import phuthotech.vn.hospital.model.api.patient.Form;
import phuthotech.vn.hospital.model.api.patient.FormPatient;
import phuthotech.vn.hospital.model.api.history.FormHistory;
import phuthotech.vn.hospital.model.api.Request;
import phuthotech.vn.hospital.model.api.Result;

import phuthotech.vn.hospital.model.api.register.FormRegister;
import phuthotech.vn.hospital.model.api.register.Register;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by kingpes on 8/18/18.
 */

public interface ApiService {

    /*PATIENT*/
    @Headers({"Content-Type: application/json; charset=UTF-8", "Accept: application/json"})
    @POST("/PatientServices/executelist/Get")
    Observable<FormPatient> getPatient(@Body Request param);

    @Headers({"Content-Type: application/json; charset=UTF-8", "Accept: application/json"})
    @POST("/PatientServices/executelist/GetNew")
    Observable<FormPatient> getNew(@Body Request param);

    @Headers({"Content-Type: application/json; charset=UTF-8", "Accept: application/json"})
    @POST("/PatientServices/execute/Save")
    Observable<Result> savePatient(@Body Form form);
    
    @Headers({"Content-Type: application/json; charset=UTF-8", "Accept: application/json"})
    @POST("/PatientServices/executelist/GetList")
    Observable<FormPatient> getList(@Body Request param);


    /*REGISTER*/
    @Headers({"Content-Type: application/json; charset=UTF-8", "Accept: application/json"})
    @POST("/RegisterServices/executelist/Get")
    Observable<FormRegister> getRegister(@Body Request param);

    @Headers({"Content-Type: application/json; charset=UTF-8", "Accept: application/json"})
    @POST("/RegisterServices/executelist/GetLoadForm")
    Observable<FormRegister> getLoadForm(@Body Request param);

    @Headers({"Content-Type: application/json; charset=UTF-8", "Accept: application/json"})
    @POST("/RegisterServices/executelist/GetDetail")
    Observable<FormRegister> getDetail(@Body Request param);

    @Headers({"Content-Type: application/json; charset=UTF-8", "Accept: application/json"})
    @POST("/RegisterServices/execute/Save")
    Observable<Result> saveRegister(@Body Register register);


    /*HISTORY*/
    @GET()
    Observable<FormHistory> getHistoryPatientOnHQ(@Url String url, @Header("intSiteRef") int intSiteRef, @Header("intPatID") int intPatID, @Header("strCMND") String strCMND, @Header("strBHYT") String strBHYT );

}







