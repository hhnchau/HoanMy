package phuthotech.vn.hospital.fragment.register;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.base.BaseFragment;
import phuthotech.vn.hospital.custom.chip.ChipAdapter;
import phuthotech.vn.hospital.custom.chip.ChipView;
import phuthotech.vn.hospital.custom.chip.ChipViewAdapter;
import phuthotech.vn.hospital.model.api.register.LstDob;

/**
 * Created by kingpes on 9/21/18.
 */

public class Register7 extends BaseFragment {
    private View v;

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
                        v = vi.inflate(R.layout.register7_fragment, viewGroup, false);
                        viewGroup.addView(v);


                        initView();


                        ChipView cvTag = v.findViewById(R.id.cvTag);
                        ChipViewAdapter adapter = new ChipViewAdapter((ArrayList<LstDob>) RegisterFragment.register.getLstDOB1(), new ChipAdapter.OnItemClickListener() {
                            @SuppressWarnings("unchecked")
                            @Override
                            public void onClick(ArrayList<Object> listChips) {
                                List<LstDob> list = (List<LstDob>)(Object) listChips;
                                RegisterFragment.register.setLstDOB8(list);
                            }
                        });
                        cvTag.setAdapter(adapter);



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
//        Toast.makeText(getActivity(), event.message + "7", Toast.LENGTH_SHORT).show();
//    }
}
