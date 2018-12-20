package phuthotech.vn.hospital.fragment.register;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.adapter.AutoCompleteTextViewAdapter;
import phuthotech.vn.hospital.base.BaseFragment;
import phuthotech.vn.hospital.custom.MyAutoCompleteTextView;
import phuthotech.vn.hospital.model.api.patient.Additional;
import phuthotech.vn.hospital.model.api.register.Dob;

/**
 * Created by kingpes on 9/21/18.
 */

public class Register2 extends BaseFragment implements View.OnClickListener {
    private View v;
    private MyAutoCompleteTextView edtPurpose, edtFormality, edtReceive, edtObject, edtCost, edtDiscount;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.base_layout, container, false);

        new Handler().post(new Runnable() {
            @Override
            public void run() {

                if (getActivity()!= null) {

                    ViewGroup viewGroup = view.findViewById(R.id.baseLayout);
                    LayoutInflater vi = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    if (vi != null) {
                        v = vi.inflate(R.layout.register2_fragment, viewGroup, false);
                        viewGroup.addView(v);


                        initView();


                    }
                }
            }
        });

        return view;
    }

    public boolean validate() {
        return false;
    }

    private void initView() {
        ImageView imgPurpose = v.findViewById(R.id.imgPurpose);
        imgPurpose.setOnClickListener(this);
        ImageView imgFormality = v.findViewById(R.id.imgFormality);
        imgFormality.setOnClickListener(this);
        ImageView imgReceive = v.findViewById(R.id.imgReceive);
        imgReceive.setOnClickListener(this);
        ImageView imgObject = v.findViewById(R.id.imgObject);
        imgObject.setOnClickListener(this);
        ImageView imgCost = v.findViewById(R.id.imgCost);
        imgCost.setOnClickListener(this);
        ImageView imgDiscount = v.findViewById(R.id.imgDiscount);
        imgDiscount.setOnClickListener(this);

        edtPurpose = v.findViewById(R.id.edtPurpose);
        edtFormality = v.findViewById(R.id.edtFormality);
        edtReceive = v.findViewById(R.id.edtReceive);
        edtObject = v.findViewById(R.id.edtObject);
        edtCost = v.findViewById(R.id.edtCost);
        edtDiscount = v.findViewById(R.id.edtDiscount);

        AutoCompleteTextViewAdapter adapter;
        if (getActivity() != null) {

            //Purpose
            adapter = new AutoCompleteTextViewAdapter(getActivity(), RegisterFragment.register.getCombo2());
            edtPurpose.setAdapter(adapter);
            edtPurpose.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Additional additional = (Additional) parent.getItemAtPosition(position);
                    Dob dob = RegisterFragment.register.getDob1();
                    dob.setPurpos(additional.getID());
                    RegisterFragment.register.setDob1(dob);
                }
            });

            //Formality
            adapter = new AutoCompleteTextViewAdapter(getActivity(), RegisterFragment.register.getCombo4());
            edtFormality.setAdapter(adapter);
            edtFormality.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Additional additional = (Additional) parent.getItemAtPosition(position);
                    Dob dob = RegisterFragment.register.getDob1();
                    dob.setFormco(additional.getID());
                    RegisterFragment.register.setDob1(dob);
                }
            });

            //Receive
            adapter = new AutoCompleteTextViewAdapter(getActivity(), RegisterFragment.register.getCombo3());
            edtReceive.setAdapter(adapter);
            edtReceive.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Additional additional = (Additional) parent.getItemAtPosition(position);
                    Dob dob = RegisterFragment.register.getDob1();
                    dob.setTyprec(additional.getID());
                    RegisterFragment.register.setDob1(dob);
                }
            });

            //Object
            adapter = new AutoCompleteTextViewAdapter(getActivity(), RegisterFragment.register.getCombo7());
            edtObject.setAdapter(adapter);
            edtObject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Additional additional = (Additional) parent.getItemAtPosition(position);
                    Dob dob = RegisterFragment.register.getDob1();
                    dob.setObject(additional.getID());
                    RegisterFragment.register.setDob1(dob);
                }
            });


//            //Cost
//            adapter = new AutoCompleteTextViewAdapter(getActivity(), RegisterFragment.register.getCombo2());
//            edtCost.setAdapter(adapter);
//            edtCost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Additional additional = (Additional) parent.getItemAtPosition(position);
//
//                }
//            });
//
//
//            //Discount
//            adapter = new AutoCompleteTextViewAdapter(getActivity(), RegisterFragment.register.getCombo2());
//            edtDiscount.setAdapter(adapter);
//            edtDiscount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Additional additional = (Additional) parent.getItemAtPosition(position);
//
//                }
//            });
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgPurpose:
                edtPurpose.showDropDown();
                break;
            case R.id.imgFormality:
                edtFormality.showDropDown();
                break;
            case R.id.imgReceive:
                edtReceive.showDropDown();
                break;
            case R.id.imgObject:
                edtObject.showDropDown();
                break;
            case R.id.imgCost:
                break;
            case R.id.imgDiscount:
                break;
        }
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        if (getActivity() != null)
//            EventBus.getDefault().register(getActivity());
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (getActivity() != null)
//            EventBus.getDefault().unregister(getActivity());
//    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMessageEvent(MessageEvent event){
//        Toast.makeText(getActivity(), event.message + "2", Toast.LENGTH_SHORT).show();
//    }

}
