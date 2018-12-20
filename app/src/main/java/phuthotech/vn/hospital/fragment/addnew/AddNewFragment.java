package phuthotech.vn.hospital.fragment.addnew;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.adapter.ViewPagerAdapter;
import phuthotech.vn.hospital.alert.Alert;
import phuthotech.vn.hospital.api.ApiManager;
import phuthotech.vn.hospital.api.OnCallback;
import phuthotech.vn.hospital.base.BaseFragment;
import phuthotech.vn.hospital.loading.Loading;
import phuthotech.vn.hospital.model.HealthCard;
import phuthotech.vn.hospital.model.api.patient.Form;
import phuthotech.vn.hospital.model.api.Result;
import phuthotech.vn.hospital.scanner.Scanner;

import static android.app.Activity.RESULT_OK;

/**
 * Created by kingpes on 8/31/18.
 */

public class AddNewFragment extends BaseFragment {
    private View view;
    private FloatingActionButton fab;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private AddNewTab addNewTab;

    public static Form forms;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addnew_fragment, container, false);
        fab = view.findViewById(R.id.fab);
        initFragment();
        initTab();
        findAllInfo();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        return view;
    }

    private void saveData() {

        Loading.getInstance().show(getActivity());

        AddNew1 frag1 = (AddNew1) adapter.instantiateItem(viewPager, AddNewTab.TAB1);
        boolean f1 = frag1.validate();
        if (!f1 && viewPager.getCurrentItem() != AddNewTab.TAB1)
            addNewTab.setBadge1();

        AddNew2 frag2 = (AddNew2) adapter.instantiateItem(viewPager, AddNewTab.TAB2);
        boolean f2 = frag2.validate();
        if (!f2 && viewPager.getCurrentItem() != AddNewTab.TAB2)
            addNewTab.setBadge2();

        AddNew3 frag3 = (AddNew3) adapter.instantiateItem(viewPager, AddNewTab.TAB3);
        boolean f3 = frag3.validate();
        if (!f3 && viewPager.getCurrentItem() != AddNewTab.TAB3)
            addNewTab.setBadge3();

        Loading.getInstance().hide();
        if (f1 && f2 && f3){

            fab.setEnabled(false);
            ApiManager.getInstance().savePatient(getActivity(), forms, new OnCallback() {
                @Override
                public void onCallBack(Object object) {
                    Result result = (Result) object;
                    if (result != null && result.getCode() == 0 && result.isData()) {
                        fab.setEnabled(true);
                        Alert.getInstance().show(getActivity(), getString(R.string.alert_ok), getString(R.string.btn_ok), null, false, null);
                    }
                }
            });

        }else {
            Toast.makeText(getActivity(), "Vui lòng nhập đầy đủ thông tin.", Toast.LENGTH_SHORT).show();
        }
    }

    private void initFragment() {
        if (getActivity() != null) {
            viewPager = view.findViewById(R.id.viewPager);
            adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
            adapter.addFragment(new AddNew1());
            adapter.addFragment(new AddNew2());
            adapter.addFragment(new AddNew3());
            //viewPager.setAdapter(adapter);
            //viewPager.setOffscreenPageLimit(3);
        }
    }

    private void initTab() {
        addNewTab = view.findViewById(R.id.tab);
        addNewTab.setOnTabClickListener(new AddNewTab.OnTabClickListener() {
            @Override
            public void onTab(int tab) {
                viewPager.setCurrentItem(tab);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addNewTab.setTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void findAllInfo() {
        ApiManager.getInstance().getNew(getActivity(), new OnCallback() {
            @Override
            public void onCallBack(Object object) {
                forms = (Form) object;
                viewPager.setAdapter(adapter);
                viewPager.setOffscreenPageLimit(3);
            }
        });
    }

    public void onQr() {
        startScanner();
    }

    /*
    * Scanner
    */

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1001) {
                HealthCard healthCard = data.getParcelableExtra("SCANNER");

                if (getActivity() != null) {
                    adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("QR", healthCard);

                    AddNew1 infoFragment = new AddNew1();
                    infoFragment.setArguments(bundle);
                    adapter.addFragment(infoFragment);

                    AddNew2 healthFragment = new AddNew2();
                    healthFragment.setArguments(bundle);
                    adapter.addFragment(healthFragment);

                    AddNew3 privateFragment = new AddNew3();
                    privateFragment.setArguments(bundle);
                    adapter.addFragment(privateFragment);

                    viewPager.setAdapter(adapter);
                    viewPager.setOffscreenPageLimit(3);
                }

            }
        }

    }

    private void onScanner() {
        startActivityForResult(new Intent(getActivity(), Scanner.class), 1001);
    }

    private void startScanner() {
        if (getActivity() != null) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                //Request
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 1000);
            } else {
                //Start Application
                onScanner();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1000:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Start Application
                    onScanner();
                } else {
                    Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

}
