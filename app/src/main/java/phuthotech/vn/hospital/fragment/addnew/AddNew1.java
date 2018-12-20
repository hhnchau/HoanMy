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
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.adapter.AutoCompleteTextViewAdapter;
import phuthotech.vn.hospital.base.BaseFragment;
import phuthotech.vn.hospital.custom.MyAutoCompleteTextView;
import phuthotech.vn.hospital.custom.MyEditText;
import phuthotech.vn.hospital.enums.Gender;
import phuthotech.vn.hospital.image.Image;
import phuthotech.vn.hospital.model.HealthCard;
import phuthotech.vn.hospital.model.api.patient.Additional;
import phuthotech.vn.hospital.model.api.patient.Patient;
import phuthotech.vn.hospital.picker.MyDatePicker;
import phuthotech.vn.hospital.picker.OnDatePickerClickListener;
import phuthotech.vn.hospital.utils.Utils;

import static android.app.Activity.RESULT_OK;

/**
 * Created by kingpes on 8/31/18.
 */

public class AddNew1 extends BaseFragment implements View.OnClickListener {
    private View view;
    private TextView tvGenderErr;
    private ImageView imgAdd, imgMale, imgFemale;
    private MyAutoCompleteTextView edtNationality, edtNation, edtJob, edtCity, edtDistrict, edtWard;
    private MyEditText edtBirthday, edtName, edtPhone, edtStreet, edtIdentity, edtPassport, edtMail, edtParentName, edtParentIdentity;
    private Bundle bundleImage;

    private Gender gender = Gender.MF;

    private List<Additional> listsNationality = new ArrayList<>();
    private List<Additional> listsNation = new ArrayList<>();
    private List<Additional> listsJob = new ArrayList<>();
    private List<Additional> listsCity = new ArrayList<>();
    private List<Additional> listsDistrict = new ArrayList<>();
    private List<Additional> listsWard = new ArrayList<>();

    private Patient patient;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (AddNewFragment.forms != null) {
            listsNationality = AddNewFragment.forms.getCombo1();
            listsNation = AddNewFragment.forms.getCombo2();
            listsJob = AddNewFragment.forms.getCombo3();
            listsCity = AddNewFragment.forms.getLstDob4();
            listsDistrict = AddNewFragment.forms.getCombo5();
            listsWard = AddNewFragment.forms.getCombo6();

            patient = AddNewFragment.forms.getDob1();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addnew1_fragment, container, false);
        initView();
        if (getArguments() != null)
            updateView((HealthCard) getArguments().getParcelable("QR"));
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBirthday:
                MyDatePicker.getInstance().show(getActivity(), new OnDatePickerClickListener() {
                    @Override
                    public void onDate(String date) {
                        edtBirthday.setText(date);
                    }
                });
                break;

            case R.id.imgNationality:
                edtNationality.showDropDown();
                break;

            case R.id.imgNation:
                edtNation.showDropDown();
                break;

            case R.id.imgJob:
                edtJob.showDropDown();
                break;

            case R.id.imgCity:
                edtCity.showDropDown();
                break;

            case R.id.imgDistrict:
                edtDistrict.showDropDown();
                break;

            case R.id.imgWard:
                edtWard.showDropDown();
                break;

            case R.id.imgMale:
                gender = Gender.Male;
                handleGender();
                break;

            case R.id.imgFeMale:
                gender = Gender.Female;
                handleGender();
                break;

            case R.id.addImage:
                startCamera();
                break;

        }
    }

    private void handleGender() {
        tvGenderErr.setError(null);
        if (gender == Gender.Male) {
            imgMale.setImageResource(R.drawable.ic_checked);
            imgFemale.setImageResource(R.drawable.ic_uncheck);
        } else if (gender == Gender.Female) {
            imgMale.setImageResource(R.drawable.ic_uncheck);
            imgFemale.setImageResource(R.drawable.ic_checked);
        }
    }

    private void initView() {
        tvGenderErr = view.findViewById(R.id.tvErr);
        imgAdd = view.findViewById(R.id.addImage);
        imgAdd.setOnClickListener(this);
        imgMale = view.findViewById(R.id.imgMale);
        imgMale.setOnClickListener(this);
        imgFemale = view.findViewById(R.id.imgFeMale);
        imgFemale.setOnClickListener(this);


        ImageView imgBirthday = view.findViewById(R.id.imgBirthday);
        imgBirthday.setOnClickListener(this);
        ImageView imgNationality = view.findViewById(R.id.imgNationality);
        imgNationality.setOnClickListener(this);
        ImageView imgNation = view.findViewById(R.id.imgNation);
        imgNation.setOnClickListener(this);
        ImageView imgJob = view.findViewById(R.id.imgJob);
        imgJob.setOnClickListener(this);
        ImageView imgCity = view.findViewById(R.id.imgCity);
        imgCity.setOnClickListener(this);
        ImageView imgDistrict = view.findViewById(R.id.imgDistrict);
        imgDistrict.setOnClickListener(this);
        ImageView imgWard = view.findViewById(R.id.imgWard);
        imgWard.setOnClickListener(this);

        edtName = view.findViewById(R.id.edtName);
        edtPhone = view.findViewById(R.id.edtTel);
        edtStreet = view.findViewById(R.id.edtStreet);
        edtIdentity = view.findViewById(R.id.edtIdentity);
        edtPassport = view.findViewById(R.id.edtPassport);
        edtMail = view.findViewById(R.id.edtMail);
        edtParentName = view.findViewById(R.id.edtParentName);
        edtParentIdentity = view.findViewById(R.id.edtParentIdentity);
        edtBirthday = view.findViewById(R.id.edtBirthday);

        edtNationality = view.findViewById(R.id.edtNationality);
        edtNation = view.findViewById(R.id.edtNation);
        edtJob = view.findViewById(R.id.edtJob);
        edtCity = view.findViewById(R.id.edtCity);
        edtDistrict = view.findViewById(R.id.edtDistrict);
        edtWard = view.findViewById(R.id.edtWard);

        AutoCompleteTextViewAdapter adapter;
        if (getActivity() != null) {
            adapter = new AutoCompleteTextViewAdapter(getActivity(), listsNationality);
            edtNationality.setAdapter(adapter);
            edtNationality.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Additional additional = (Additional) parent.getItemAtPosition(position);
                    patient.setNation(additional.getID());
                }
            });

            adapter = new AutoCompleteTextViewAdapter(getActivity(), listsNation);
            edtNation.setAdapter(adapter);
            edtNation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Additional additional = (Additional) parent.getItemAtPosition(position);
                    patient.setEthnic(additional.getID());
                }
            });

            adapter = new AutoCompleteTextViewAdapter(getActivity(), listsJob);
            edtJob.setAdapter(adapter);
            edtJob.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Additional additional = (Additional) parent.getItemAtPosition(position);
                    patient.setJobid(additional.getID());
                }
            });

            adapter = new AutoCompleteTextViewAdapter(getActivity(), listsCity);
            edtCity.setAdapter(adapter);
            edtCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Additional additional = (Additional) parent.getItemAtPosition(position);
                    patient.setProvin(additional.getID());
                }
            });

            adapter = new AutoCompleteTextViewAdapter(getActivity(), listsDistrict);
            edtDistrict.setAdapter(adapter);
            edtDistrict.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Additional additional = (Additional) parent.getItemAtPosition(position);
                    patient.setDistric(additional.getID());
                }
            });

            adapter = new AutoCompleteTextViewAdapter(getActivity(), listsWard);
            edtWard.setAdapter(adapter);
            edtWard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Additional additional = (Additional) parent.getItemAtPosition(position);
                    patient.setWard(additional.getID());
                }
            });
        }
    }

    private void updateView(HealthCard healthCard) {
        if (healthCard != null) {
            edtName.setText(healthCard.getName());
            edtBirthday.setText(healthCard.getBirthday());
            if (healthCard.getGender() == 0) {
                gender = Gender.Female;
                handleGender();
            } else if (healthCard.getGender() == 1) {
                gender = Gender.Male;
                handleGender();
            }
        }
    }

    public boolean validate() {
        String s;
        boolean result = true;
        s = edtName.getText().toString();
        if (s.equals("")) {
            edtName.setError("*");
            result = false;
        } else {
            String[] name = Utils.splitName(s);
            patient.setFsname(name[0]);
            patient.setLsname(name[1]);
        }

        if (gender.getType() == 10) {
            tvGenderErr.setError("*");
            result = false;
        } else {
            patient.setSex(gender.getType());
        }

        s = edtBirthday.getText().toString();
        if (s.equals("")) {
            edtBirthday.setError("*");
            result = false;
        } else {
            patient.setBirthday(s);

            String[] date = Utils.splitDate(s);

            if (!date[0].equals(""))
                patient.setDaybr(Integer.parseInt(date[0]));
            if (!date[1].equals(""))
                patient.setMonth(Integer.parseInt(date[1]));
            patient.setYearbr(Integer.parseInt(date[2]));

        }

        s = edtPhone.getText().toString();
        if (!s.equals(""))
            patient.setPhone(s);


        s = edtCity.getText().toString();
        if (s.equals("")) {
            edtCity.setError("*");
            result = false;
        }

        s = edtDistrict.getText().toString();
        if (s.equals("")) {
            edtDistrict.setError("*");
            result = false;
        }

        s = edtWard.getText().toString();
        if (s.equals("")) {
            edtWard.setError("*");
            result = false;
        }

        s = edtStreet.getText().toString();
        if (s.equals("")) {
            edtStreet.setError("*");
            result = false;
        } else {
            patient.setNofhus(s);
        }

        s = edtIdentity.getText().toString();
        if (!s.equals(""))
            patient.setCardid(s);

        s = edtPassport.getText().toString();
        if (!s.equals(""))
            patient.setPaport(s);

        s = edtMail.getText().toString();
        if (!s.equals(""))
            patient.setEmail(s);

        s = edtParentName.getText().toString();
        int age = Utils.CalculateAge(edtBirthday.getText().toString());
        if (age > -1 && age < 7 && s.equals("")) {
            edtParentName.setError("*");
            result = false;
        } else {
            patient.setFaname(s);
        }

        s = edtParentIdentity.getText().toString();
        if (!s.equals(""))
            patient.setFacard(s);

        String address =
                edtStreet.getText() + " " +
                edtWard.getText() + " " +
                edtDistrict.getText() + " " +
                edtCity.getText();
        patient.setAddres(address);

        if (AddNewFragment.forms != null)
            patient.setIdlink(Long.parseLong(new SimpleDateFormat("yyMMddHHmmss", Locale.ENGLISH).format(new Date())));
            AddNewFragment.forms.setDob1(patient);
        return result;
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


