package phuthotech.vn.hospital.fragment.register;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.api.ApiManager;
import phuthotech.vn.hospital.api.OnCallback;
import phuthotech.vn.hospital.base.BaseFragment;
import phuthotech.vn.hospital.model.api.patient.Form;
import phuthotech.vn.hospital.model.api.register.Combo;
import phuthotech.vn.hospital.model.api.register.Dob;
import phuthotech.vn.hospital.model.api.register.Register;
import phuthotech.vn.hospital.sheet.SheetPatient;

/**
 * Created by kingpes on 9/21/18.
 */

public class Register1 extends BaseFragment {
    private View v;
    private WebView webView;
    private EditText edtSn;
    private TextView tvDetail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.base_layout, container, false);

        new Handler().post(new Runnable() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void run() {

                if (getActivity()!= null) {

                    ViewGroup viewGroup = view.findViewById(R.id.baseLayout);
                    LayoutInflater vi = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    if (vi != null) {
                        v = vi.inflate(R.layout.register1_fragment, viewGroup, false);
                        viewGroup.addView(v);

                        initView();


                        edtSn.setOnKeyListener(new View.OnKeyListener() {
                            @Override
                            public boolean onKey(View v, int keyCode, KeyEvent event) {

                                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                                    getPatientRegister(edtSn.getText().toString());
                                    return true;

                                }

                                return false;
                            }
                        });
                    }
                }
            }
        });

        return view;
    }

    public boolean validate() {
        return false;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initView(){
        edtSn = v.findViewById(R.id.edtSn);

        v.findViewById(R.id.imgSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPatientRegister(edtSn.getText().toString());
            }
        });


        final ImageView imgFind = v.findViewById(R.id.imgFind);
        imgFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgFind.setEnabled(false);
                ApiManager.getInstance().getList(getActivity(), new OnCallback() {
                    @Override
                    public void onCallBack(Object object) {
                        imgFind.setEnabled(true);
                        Form form = (Form) object;
                        if (form != null) {
                            List<Combo> list = form.getCombo();
                            SheetPatient.getInstance().show(getActivity(), list, new SheetPatient.OnItemClickListener() {
                                @Override
                                public void onItemClickListener(String sn) {
                                    getPatientRegister(sn);
                                }
                            });
                        }
                    }
                });
            }
        });

        webView = v.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setBackgroundColor(Color.TRANSPARENT);

        tvDetail = v.findViewById(R.id.tvEdit);
        tvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EventBus.getDefault().post(new MessageEvent("Chau"));
            }
        });
    }

    private void getPatientRegister(String patcde){
        if (patcde.isEmpty()){
            Toast.makeText(getActivity(), getResources().getString(R.string.toast_sn_empty), Toast.LENGTH_SHORT).show();
            return;
        }
        ApiManager.getInstance().getRegister(getActivity(), Integer.parseInt(patcde), new OnCallback() {
            @Override
            public void onCallBack(Object object) {
                Register register = (Register) object;
                final Dob dob = register.getDob1();
                if (dob!=null) {


                    //tvDetail.setVisibility(View.VISIBLE);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            webView.loadDataWithBaseURL("", getString(R.string.html_detail,
                                    String.valueOf(dob.getPatid()),
                                    dob.getFullname(),
                                    dob.getSex(),
                                    dob.getBirthday(),
                                    dob.getCardid(),
                                    dob.getAddres()), "text/html", "UTF-8", "");
                        }
                    }, 100);

                    if (RegisterFragment.register != null) {
                        dob.setIdlink(Long.parseLong(new SimpleDateFormat("yyMMddHHmmss", Locale.ENGLISH).format(new Date())));
                        RegisterFragment.register.setDob1(dob);
                    }

                }
            }
        });
    }

}
