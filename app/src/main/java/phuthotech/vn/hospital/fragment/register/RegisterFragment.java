package phuthotech.vn.hospital.fragment.register;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.alert.Alert;
import phuthotech.vn.hospital.api.ApiManager;
import phuthotech.vn.hospital.api.OnCallback;
import phuthotech.vn.hospital.base.BaseFragment;
import phuthotech.vn.hospital.fragment.addnew.AddNew2;
import phuthotech.vn.hospital.fragment.addnew.AddNew1;
import phuthotech.vn.hospital.fragment.addnew.AddNew3;
import phuthotech.vn.hospital.adapter.ViewPagerAdapter;
import phuthotech.vn.hospital.loading.Loading;
import phuthotech.vn.hospital.model.api.Result;
import phuthotech.vn.hospital.model.api.register.Register;

/**
 * Created by kingpes on 9/5/18.
 */

public class RegisterFragment extends BaseFragment {
    private View view;

    private FloatingActionButton fabPlus, fabSave, fabPrint;
    private Animation animFabOpen, animFabClose, animFabClockwise, animFabAnticlockwise;
    private boolean isOpen = false;

    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private RegisterTab registerTab;
    private int lastPage = 0;

    public static Register register;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.register_fragment, container, false);
        initFragment();
        initTab();
        initFab();
        viewPagerChange();
        getLoadForm();
        return view;
    }

    private void initFragment() {
        if (getActivity() != null) {
            viewPager = view.findViewById(R.id.viewPager);
            adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
            adapter.addFragment(new Register1());
            adapter.addFragment(new Register2());
            //adapter.addFragment(new Register3());
            //adapter.addFragment(new Register4());
            //adapter.addFragment(new Register5());
            //adapter.addFragment(new Register6());
            adapter.addFragment(new Register7());
            //viewPager.setAdapter(adapter);
            //viewPager.setOffscreenPageLimit(6);
        }
    }

    private void initFab(){
        fabPlus = view.findViewById(R.id.fabPlus);
        fabSave = view.findViewById(R.id.fabSave);
        fabPrint = view.findViewById(R.id.fabPrint);

        animFabOpen = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_open);
        animFabClose = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_close);
        animFabClockwise = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_rotate_clockwise);
        animFabAnticlockwise = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_rotate_anticlockwise);

        fabPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen){

                    fabSave.startAnimation(animFabClose);
                    fabPrint.setAnimation(animFabClose);
                    fabPlus.startAnimation(animFabAnticlockwise);

                    fabSave.setClickable(false);
                    fabPrint.setClickable(false);
                    isOpen = false;

                }else {
                    fabSave.startAnimation(animFabOpen);
                    fabPrint.setAnimation(animFabOpen);
                    fabPlus.startAnimation(animFabClockwise);

                    fabSave.setClickable(true);
                    fabPrint.setClickable(true);
                    isOpen = true;
                }
            }
        });


        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        fabPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printData();
            }
        });
    }

    private void initTab(){
        registerTab = view.findViewById(R.id.tab);
        registerTab.setOnTabClickListener(new RegisterTab.OnTabClickListener() {
            @Override
            public void onTab(int tab) {
                viewPager.setCurrentItem(tab);
            }
        });
    }

    private void viewPagerChange(){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (lastPage > position){
                    //Move to Left
                    registerTab.scroll(-1);
                }else if (lastPage < position){
                    //Move to Right
                    registerTab.scroll(1);
                }
                lastPage = position;
                registerTab.setTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void getLoadForm(){
        ApiManager.getInstance().getLoadForm(getActivity(), new OnCallback() {
            @Override
            public void onCallBack(Object object) {
                register = (Register) object;
                viewPager.setAdapter(adapter);
                viewPager.setOffscreenPageLimit(6);
            }
        });
    }

    private void saveData() {

        //Loading.getInstance().show(getActivity());

//        Register1 frag1 = (Register1) adapter.instantiateItem(viewPager, RegisterTab.TAB1);
//        boolean f1 = frag1.validate();
//        if (!f1 && viewPager.getCurrentItem() != RegisterTab.TAB1)
//            registerTab.setBadge1();
//
//        Register2 frag2 = (Register2) adapter.instantiateItem(viewPager, RegisterTab.TAB2);
//        boolean f2 = frag2.validate();
//        if (!f2 && viewPager.getCurrentItem() != RegisterTab.TAB2)
//            registerTab.setBadge2();
//
//        Register3 frag3 = (Register3) adapter.instantiateItem(viewPager, RegisterTab.TAB3);
//        boolean f3 = frag3.validate();
//        if (!f3 && viewPager.getCurrentItem() != RegisterTab.TAB3)
//            registerTab.setBadge3();
//
//        Register4 frag4 = (Register4) adapter.instantiateItem(viewPager, RegisterTab.TAB4);
//        boolean f4 = frag4.validate();
//        if (!f4 && viewPager.getCurrentItem() != RegisterTab.TAB4)
//            registerTab.setBadge4();
//
//        Register5 frag5 = (Register5) adapter.instantiateItem(viewPager, RegisterTab.TAB5);
//        boolean f5 = frag5.validate();
//        if (!f5 && viewPager.getCurrentItem() != RegisterTab.TAB5)
//            registerTab.setBadge5();
//
//        Register6 frag6 = (Register6) adapter.instantiateItem(viewPager, RegisterTab.TAB6);
//        boolean f6 = frag6.validate();
//        if (!f6 && viewPager.getCurrentItem() != RegisterTab.TAB6)
//            registerTab.setBadge6();
//
//        Register7 frag7 = (Register7) adapter.instantiateItem(viewPager, RegisterTab.TAB7);
//        boolean f7 = frag7.validate();
//        if (!f7 && viewPager.getCurrentItem() != RegisterTab.TAB7)
//            registerTab.setBadge7();

//        Loading.getInstance().hide();
//        if (f1 && f2 && f3 && f4 && f5 && f6 && f7){

            fabSave.setEnabled(false);
            ApiManager.getInstance().saveRegister(getActivity(), register, new OnCallback() {
                @Override
                public void onCallBack(Object object) {
                    Result result = (Result) object;
                    if (result != null && result.getCode() == 0 && result.isData()) {
                        fabSave.setEnabled(true);
                        Alert.getInstance().show(getActivity(), getString(R.string.alert_ok), getString(R.string.btn_ok), null, false, null);
                    }
                }
            });

        //}
    }

    public void printData(){

    }

}
