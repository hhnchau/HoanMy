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
import phuthotech.vn.hospital.model.HealthCard;
import phuthotech.vn.hospital.model.api.patient.Additional;
import phuthotech.vn.hospital.model.api.patient.Health;
import phuthotech.vn.hospital.picker.MyDatePicker;
import phuthotech.vn.hospital.picker.OnDatePickerClickListener;
import phuthotech.vn.hospital.utils.Utils;

import static android.app.Activity.RESULT_OK;

/**
 * Created by kingpes on 8/31/18.
 */

public class AddNew2 extends BaseFragment implements View.OnClickListener {
    private View view;
    private MyEditText edtInsuranceCode, edtFromDate, edtToDate, edtHospitalCode, edtOverTime, edtAddressInsurance;
    private MyAutoCompleteTextView edtHospitalName, edtInsuredCode;
    private ImageView imgAdd;
    private Bundle bundleImage;

    private List<Additional> listsHospitalName = new ArrayList<>();
    private List<Additional> listsInsuredCode = new ArrayList<>();
    private Health health;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (AddNewFragment.forms != null) {
            listsHospitalName = AddNewFragment.forms.getCombo9();
            listsInsuredCode = AddNewFragment.forms.getCombo10();

            health = AddNewFragment.forms.getDob2();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addnew2_fragment, container, false);
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
        ImageView imgHospitalName = view.findViewById(R.id.imgHospitalName);
        imgHospitalName.setOnClickListener(this);
        ImageView imgInsuredCode = view.findViewById(R.id.imgInsuredCode);
        imgInsuredCode.setOnClickListener(this);
        ImageView imgOverTime = view.findViewById(R.id.imgOverTime);
        imgOverTime.setOnClickListener(this);

        edtInsuranceCode = view.findViewById(R.id.edtInsuranceCode);
        edtFromDate = view.findViewById(R.id.edtFromDate);
        edtToDate = view.findViewById(R.id.edtToDate);
        edtHospitalCode = view.findViewById(R.id.edtHospitalCode);

        edtHospitalName = view.findViewById(R.id.edtHospitalName);
        edtAddressInsurance = view.findViewById(R.id.edtAddressInsurance);
        edtInsuredCode = view.findViewById(R.id.edtInsuredCode);
        edtOverTime = view.findViewById(R.id.edtOverTime);

        AutoCompleteTextViewAdapter adapter;
        if (getActivity() != null) {
            adapter = new AutoCompleteTextViewAdapter(getActivity(), listsHospitalName);
            edtHospitalName.setAdapter(adapter);
            edtHospitalName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Additional additional = (Additional) parent.getItemAtPosition(position);
                    health.setHoptlc(additional.getID());
                }
            });

            adapter = new AutoCompleteTextViewAdapter(getActivity(), listsInsuredCode);
            edtInsuredCode.setAdapter(adapter);
        }

    }

    private void updateView(HealthCard healthCard) {
        if (healthCard != null) {
            edtInsuranceCode.setText(healthCard.getSn());
            edtFromDate.setText(healthCard.getStartDate());
            edtToDate.setText(healthCard.getEndDate());
            edtHospitalCode.setText(healthCard.getFirstRegistration());
            if (findHospital(splitHospitalCode(healthCard.getFirstRegistration()))) {
                edtHospitalName.setText(healthCard.getName());
            }
            edtAddressInsurance.setText(healthCard.getAddress());
            edtInsuredCode.setText(healthCard.getObjectCode());
            edtOverTime.setText(healthCard.getTimeOver5Year());
        }
    }

    private String splitHospitalCode(String code){
        StringBuilder result = new StringBuilder();
        String[] c = code.split("-");
        for (String aC : c) {
            result.append(aC.trim());
        }
        return result.toString();
    }

    private boolean findHospital(String code){
        for (int i = 0; i < listsHospitalName.size(); i++){
            if (listsHospitalName.get(i).getCODE().equals(code)){
                return true;
            }
        }
        return false;
    }

    public boolean validate() {
        boolean result = true;
        if (!edtInsuranceCode.getText().toString().trim().equals("")) {

            String s;

            health.setNohicd(edtInsuranceCode.getText().toString());

            s = edtFromDate.getText().toString();
            if (s.equals("")) {
                edtFromDate.setError("*");
                result = false;
            } else {
                health.setStrday(Utils.dateFormat(s));
            }

            s = edtToDate.getText().toString();
            if (s.equals("")) {
                edtToDate.setError("*");
                result = false;
            } else {
                health.setEndday(Utils.dateFormat(s));
            }

            s = edtHospitalCode.getText().toString();
            if (s.equals("")) {
                edtHospitalCode.setError("*");
                result = false;
            }

            s = edtAddressInsurance.getText().toString();
            if (s.equals("")) {
                edtAddressInsurance.setError("*");
                result = false;
            } else {
                health.setAddrhi(s);
            }


            health.setLivpla(edtInsuredCode.getText().toString());

            health.setTime5y(Utils.dateFormat(edtOverTime.getText().toString()));


            if (AddNewFragment.forms != null)
                AddNewFragment.forms.setDob2(health);
        }

        return result;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgHospitalName:
                edtHospitalName.showDropDown();
                break;

            case R.id.imgInsuredCode:
                edtInsuredCode.showDropDown();
                break;

            case R.id.imgOverTime:
                MyDatePicker.getInstance().show(getActivity(), new OnDatePickerClickListener() {
                    @Override
                    public void onDate(String date) {
                        edtOverTime.setText(date);
                    }
                });
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
