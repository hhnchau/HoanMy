package phuthotech.vn.hospital.api;

import android.content.Context;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.alert.Alert;
import phuthotech.vn.hospital.alert.OnAlertClickListener;
import phuthotech.vn.hospital.application.MyApplication;
import phuthotech.vn.hospital.loading.Loading;
import phuthotech.vn.hospital.log.MyLog;
import phuthotech.vn.hospital.model.api.patient.Form;
import phuthotech.vn.hospital.model.api.patient.FormPatient;
import phuthotech.vn.hospital.model.api.history.FormHistory;
import phuthotech.vn.hospital.model.api.Request;
import phuthotech.vn.hospital.model.api.Result;
import phuthotech.vn.hospital.model.api.register.FormRegister;
import phuthotech.vn.hospital.model.api.register.Register;


/**
 * Created by kingpes on 8/20/18.
 */

public class ApiManager {
    private static ApiManager instance = null;

    public static ApiManager getInstance() {
        if (instance == null) {
            instance = new ApiManager();
        }
        return instance;
    }


    public void getPatient(final Context context, final int patcde, final OnCallback onCallback) {
        Loading.getInstance().show(context);
        CompositeManager.add(MyApplication.apiService.getPatient(new Request(1, "opatient", patcde))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<FormPatient>() {

                    @Override
                    public void onNext(FormPatient formPatient) {
                        Loading.getInstance().hide();
                        if (formPatient != null && formPatient.getData() != null)
                            onCallback.onCallBack(formPatient.getData().get(0));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Loading.getInstance().hide();
                        showAlertNoConnect(context, new OnRetry() {
                            @Override
                            public void request() {
                                getPatient(context, patcde, onCallback);
                            }
                        });
                    }

                    @Override
                    public void onComplete() {
                        MyLog.print("API GetNew Complete");
                        Loading.getInstance().hide();
                    }
                }));
    }

    //Get ID New Patient
    public void getNew(final Context context, final OnCallback onCallback) {
        Loading.getInstance().show(context);
        CompositeManager.add(MyApplication.apiService.getNew(new Request(1, "opatient"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<FormPatient>() {

                    @Override
                    public void onNext(FormPatient formPatient) {
                        Loading.getInstance().hide();
                        if (formPatient != null && formPatient.getData() != null && onCallback != null)
                            onCallback.onCallBack(formPatient.getData().get(0));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Loading.getInstance().hide();
                        showAlertNoConnect(context, new OnRetry() {
                            @Override
                            public void request() {
                                getNew(context, onCallback);
                            }
                        });
                    }

                    @Override
                    public void onComplete() {
                        Loading.getInstance().hide();
                        MyLog.print("API GetNew Complete");
                    }
                }));
    }

    //Save New
    public void savePatient(final Context context, final Form forms, final OnCallback onCallback) {
        Loading.getInstance().show(context);
        CompositeManager.add(MyApplication.apiService.savePatient(forms)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Result>() {

                    @Override
                    public void onNext(Result result) {
                        Loading.getInstance().hide();
                        if (result != null && onCallback != null)
                            onCallback.onCallBack(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Loading.getInstance().hide();
                        showAlertNoConnect(context, new OnRetry() {
                            @Override
                            public void request() {
                                savePatient(context, forms, onCallback);
                            }
                        });
                    }

                    @Override
                    public void onComplete() {
                        Loading.getInstance().hide();
                        MyLog.print("API GetNew Complete");
                    }
                }));

    }

    //Get Patient
    public void getRegister(final Context context, final int patcde, final OnCallback onCallback){
        Loading.getInstance().show(context);
        CompositeManager.add(MyApplication.apiService.getRegister(new Request(1,"oregisterh", patcde))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<FormRegister>() {

                    @Override
                    public void onNext(FormRegister formRegister) {
                        Loading.getInstance().hide();
                        if (formRegister != null && formRegister.getData() != null && onCallback != null)
                            onCallback.onCallBack(formRegister.getData().get(0));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Loading.getInstance().hide();
                        showAlertNoConnect(context, new OnRetry() {
                            @Override
                            public void request() {
                                getRegister(context, patcde, onCallback);
                            }
                        });
                    }

                    @Override
                    public void onComplete() {
                        Loading.getInstance().hide();
                        MyLog.print("API GetNew Complete");
                    }
                }));
    }

    //Get All Patient
    public void getList(final Context context, final OnCallback onCallback){
        Loading.getInstance().show(context);
        CompositeManager.add(MyApplication.apiService.getList(new Request(1))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<FormPatient>() {

                    @Override
                    public void onNext(FormPatient formPatient) {
                        Loading.getInstance().hide();
                        if (formPatient != null && formPatient.getData() != null && onCallback != null)
                            onCallback.onCallBack(formPatient.getData().get(0));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Loading.getInstance().hide();
                        showAlertNoConnect(context, new OnRetry() {
                            @Override
                            public void request() {
                                getList(context, onCallback);
                            }
                        });
                    }

                    @Override
                    public void onComplete() {
                        Loading.getInstance().hide();
                        MyLog.print("API GetNew Complete");
                    }
                }));
    }

    //Get Patient Detail
    public void getDetail(final Context context, final OnCallback onCallback){
        Loading.getInstance().show(context);
        CompositeManager.add(MyApplication.apiService.getDetail(new Request(1))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<FormRegister>() {

                    @Override
                    public void onNext(FormRegister formRegister) {
                        Loading.getInstance().hide();
                        if (formRegister != null && formRegister.getData() != null && onCallback != null)
                            onCallback.onCallBack(formRegister.getData().get(0));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Loading.getInstance().hide();
                        showAlertNoConnect(context, new OnRetry() {
                            @Override
                            public void request() {
                                getDetail(context, onCallback);
                            }
                        });
                    }

                    @Override
                    public void onComplete() {
                        Loading.getInstance().hide();
                        MyLog.print("API GetNew Complete");
                    }
                }));
    }

    //Get Data for Register
    public void getLoadForm(final Context context, final OnCallback onCallback){
        Loading.getInstance().show(context);
        CompositeManager.add(MyApplication.apiService.getLoadForm(new Request(1,"oregisterh", 0))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<FormRegister>() {

                    @Override
                    public void onNext(FormRegister formRegister) {
                        Loading.getInstance().hide();
                        if (formRegister != null && formRegister.getData() != null && onCallback != null)
                            onCallback.onCallBack(formRegister.getData().get(0));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Loading.getInstance().hide();
                        showAlertNoConnect(context, new OnRetry() {
                            @Override
                            public void request() {
                                getLoadForm(context, onCallback);
                            }
                        });
                    }

                    @Override
                    public void onComplete() {
                        Loading.getInstance().hide();
                        MyLog.print("API GetNew Complete");
                    }
                }));
    }

    //Save Register
    public void saveRegister(final Context context, final Register register, final OnCallback onCallback) {
        Loading.getInstance().show(context);
        CompositeManager.add(MyApplication.apiService.saveRegister(register)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Result>() {

                    @Override
                    public void onNext(Result result) {
                        Loading.getInstance().hide();
                        if (result != null && onCallback != null)
                            onCallback.onCallBack(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Loading.getInstance().hide();
                        showAlertNoConnect(context, new OnRetry() {
                            @Override
                            public void request() {
                                saveRegister(context, register, onCallback);
                            }
                        });
                    }

                    @Override
                    public void onComplete() {
                        Loading.getInstance().hide();
                        MyLog.print("API GetNew Complete");
                    }
                }));

    }

    //Get History
    public void getHistoryPatientOnHQ(final Context context, final String url, final int intPatID, final String strCMND, final String strBHYT, final OnCallback onCallback) {
        Loading.getInstance().show(context);
        CompositeManager.add(MyApplication.apiService.getHistoryPatientOnHQ(url,1, intPatID, strCMND, strBHYT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<FormHistory>() {

                    @Override
                    public void onNext(FormHistory formHistories) {
                        if (formHistories != null && onCallback != null)
                            onCallback.onCallBack(formHistories);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Loading.getInstance().hide();
                        showAlertNoConnect(context, new OnRetry() {
                            @Override
                            public void request() {
                                getHistoryPatientOnHQ(context, url, intPatID, strCMND, strBHYT, onCallback);
                            }
                        });
                    }

                    @Override
                    public void onComplete() {
                        Loading.getInstance().hide();
                        MyLog.print("API GetNew Complete");
                    }
                }));

    }

    private void showAlertNoConnect(Context context, final OnRetry onRetry) {
        Alert.getInstance().show(context, "Không thể kết nối tới máy chủ!", context.getString(R.string.btn_ok), null, false, new OnAlertClickListener() {
            @Override
            public void onYes() {
                onRetry.request();
            }

            @Override
            public void onNo() {

            }
        });
    }
}


