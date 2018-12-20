package phuthotech.vn.hospital.fragment.history;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.base.BaseFragment;

/**
 * Created by kingpes on 9/18/18.
 */

public class History2 extends BaseFragment {
    private View view;

    private int dots_count;
    private ImageView[] dots;
    private int currentDot = 0;

    private DiagnoseAdapter diagnoseAdapter;
    private List<String> listsDiagnose;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.history2_fragment, container, false);
        initDiagnose();
        initClinic();
        return view;
    }

    private void initDiagnose() {
        RecyclerView recyclerView = view.findViewById(R.id.rcDiagnose);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listsDiagnose = new ArrayList<>();
        listsDiagnose.add("1");
        listsDiagnose.add("1");
        listsDiagnose.add("1");
        listsDiagnose.add("1");
        diagnoseAdapter = new DiagnoseAdapter(listsDiagnose);
        recyclerView.setAdapter(diagnoseAdapter);
    }

    private void initClinic() {
        ViewPager vpClinic = view.findViewById(R.id.vpClinic);
        List<String> listBanner = new ArrayList<>();
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");
        listBanner.add("C");


        ClinicAdapter clinicAdapter = new ClinicAdapter(listBanner);
        vpClinic.setAdapter(clinicAdapter);
        LinearLayout indicator = view.findViewById(R.id.indicator);
        initIndicator(getActivity(), indicator, clinicAdapter.getCount());
        viewPagerChange(vpClinic);
    }

    private void viewPagerChange(ViewPager viewPager) {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentDot = position;
                updateIndicator(getActivity(), currentDot);
                updateData(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initIndicator(Context context, LinearLayout indicator, int totalDots) {
        dots_count = totalDots;
        dots = new ImageView[dots_count];

        if (dots_count > 1) {
            for (int i = 0; i < dots_count; i++) {
                dots[i] = new ImageView(context);
                dots[i].setImageDrawable(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.dot_none_active));

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(1, 0, 1, 0);

                indicator.addView(dots[i], params);
            }

            //Set Default
            dots[0].setImageDrawable(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.dot_active));
        }
    }

    private void updateIndicator(Context context, int currentDot) {
        if (dots_count > 1) {
            for (int i = 0; i < dots_count; i++) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.dot_none_active));
            }
            dots[currentDot].setImageDrawable(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.dot_active));
        }
    }

    private void updateData(int p){
        //listsDiagnose.clear();
        //listsDiagnose.add(p + "");
        //diagnoseAdapter.notifyDataSetChanged();
    }

}
