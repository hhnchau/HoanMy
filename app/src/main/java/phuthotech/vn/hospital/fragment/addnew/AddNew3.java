package phuthotech.vn.hospital.fragment.addnew;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.adapter.AutoCompleteTextViewAdapter;
import phuthotech.vn.hospital.base.BaseFragment;
import phuthotech.vn.hospital.custom.MyAutoCompleteTextView;
import phuthotech.vn.hospital.custom.MyEditText;
import phuthotech.vn.hospital.image.Image;
import phuthotech.vn.hospital.log.MyLog;
import phuthotech.vn.hospital.model.HealthCard;
import phuthotech.vn.hospital.model.api.patient.Additional;
import phuthotech.vn.hospital.model.api.patient.Private;
import phuthotech.vn.hospital.picker.MyDatePicker;
import phuthotech.vn.hospital.picker.OnDatePickerClickListener;
import phuthotech.vn.hospital.utils.Utils;

import static android.app.Activity.RESULT_OK;

/**
 * Created by kingpes on 8/31/18.
 */

public class AddNew3 extends BaseFragment implements View.OnClickListener {
    private View view;
    private MyEditText edtPrivateCode, edtFromDate, edtToDate, edtAddressInsured;
    private MyAutoCompleteTextView edtCompanyName, edtCompanyInsured;
    private ImageView imgAdd;
    private Bundle bundleImage;

    private List<Additional> listsCompanyName = new ArrayList<>();
    private List<Additional> listsCompanyInsured = new ArrayList<>();

    private Private pzivate;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (AddNewFragment.forms != null) {
            listsCompanyName = AddNewFragment.forms.getCombo9();
            listsCompanyInsured = AddNewFragment.forms.getCombo10();

            pzivate = AddNewFragment.forms.getDob3();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addnew3_fragment, container, false);
        initView();
        if (getArguments() != null)
            updateView((HealthCard) getArguments().getParcelable("QR"));
        return view;
    }

    private void initView() {
        imgAdd = view.findViewById(R.id.addImage);
        imgAdd.setOnClickListener(this);


        ImageView imgFromDate = view.findViewById(R.id.imgFromDate);
        imgFromDate.setOnClickListener(this);
        ImageView imgToDate = view.findViewById(R.id.imgToDate);
        imgToDate.setOnClickListener(this);
        ImageView imgCompanyName = view.findViewById(R.id.imgCompanyName);
        imgCompanyName.setOnClickListener(this);
        ImageView imgCompanyInsured = view.findViewById(R.id.imgCompanyInsured);
        imgCompanyInsured.setOnClickListener(this);

        edtPrivateCode = view.findViewById(R.id.edtPrivateCode);
        edtFromDate = view.findViewById(R.id.edtFromDate);
        edtToDate = view.findViewById(R.id.edtToDate);
        edtCompanyName = view.findViewById(R.id.edtCompanyName);
        edtCompanyInsured = view.findViewById(R.id.edtCompanyInsured);
        edtAddressInsured = view.findViewById(R.id.edtAddressInsured);

        AutoCompleteTextViewAdapter adapter;
        if (getActivity() != null) {
            adapter = new AutoCompleteTextViewAdapter(getActivity(), listsCompanyName);
            edtCompanyName.setAdapter(adapter);
            edtCompanyName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Additional additional = (Additional) parent.getItemAtPosition(position);
                    pzivate.setIdcombhi(additional.getID());
                }
            });

            adapter = new AutoCompleteTextViewAdapter(getActivity(), listsCompanyInsured);
            edtCompanyInsured.setAdapter(adapter);
            edtCompanyInsured.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Additional additional = (Additional) parent.getItemAtPosition(position);
                    pzivate.setIdcom(additional.getID());
                }
            });
        }

    }

    private void updateView(HealthCard healthCard) {
        if (healthCard != null) {
            MyLog.print("");
        }
    }

    public boolean validate(){
        boolean result = true;
        if (!edtPrivateCode.getText().toString().trim().equals("")) {

            String s;

            pzivate.setNobhi(edtPrivateCode.getText().toString().trim());

            s = edtFromDate.getText().toString();
            if (s.equals("")){
                edtFromDate.setError("*");
                result =false;
            }else {
                pzivate.setStrday(Utils.dateFormat(s));
            }

            s = edtToDate.getText().toString();
            if (s.equals("")){
                edtToDate.setError("*");
                result =false;
            }else {
                pzivate.setEndday(Utils.dateFormat(s));
            }

            s = edtCompanyName.getText().toString();
            if (s.equals("")){
                edtCompanyName.setError("*");
                result =false;
            }

            s = edtCompanyInsured.getText().toString();
            if (s.equals("")){
                edtCompanyInsured.setError("*");
                result =false;
            }

            s = edtAddressInsured.getText().toString();
            if (s.equals("")){
                edtAddressInsured.setError("*");
                result =false;
            }else {
                pzivate.setAddress(s);
            }

            if (AddNewFragment.forms != null)
                AddNewFragment.forms.setDob3(pzivate);
        }

        return result;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgCompanyName:
                edtCompanyName.showDropDown();
                break;

            case R.id.imgCompanyInsured:
                edtCompanyInsured.showDropDown();
                break;

            case R.id.imgFromDate:
                MyDatePicker.getInstance().show(getActivity(), new OnDatePickerClickListener() {
                    @Override
                    public void onDate(String date) {
                        edtFromDate.setText(date);
                    }
                });
                break;

            case R.id.imgToDate:
                MyDatePicker.getInstance().show(getActivity(), new OnDatePickerClickListener() {
                    @Override
                    public void onDate(String date) {
                        edtToDate.setText(date);
                    }
                });
                break;

            case R.id.addImage:
                startCamera();
                break;

        }
    }

    /*
    * Camera
    */

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1002) {

                bundleImage = data.getExtras();
                if (bundleImage != null) {
                    Image.getInstance().load((Bitmap) bundleImage.get("data"), imgAdd);
                }

            }
        }

    }

    private void onCamera() {
        startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), 1002);
    }

    private void startCamera() {
        if (getActivity() != null) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                //Request
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 1000);
            } else {
                //Start Application
                onCamera();
                //onScanner();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1000:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Start Application
                    onCamera();
                } else {
                    Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (bundleImage != null)
            outState.putBundle("savePatient-instance", bundleImage);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("savePatient-instance")) {
            bundleImage = savedInstanceState.getBundle("savePatient-instance");
            if (bundleImage != null) {
                Image.getInstance().load((Bitmap) bundleImage.get("data"), imgAdd);
            }

        }
    }
}
