package phuthotech.vn.hospital.fragment.register;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.base.BaseFragment;

/**
 * Created by kingpes on 9/21/18.
 */

public class Register3 extends BaseFragment {
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
                        v = vi.inflate(R.layout.register3_fragment, viewGroup, false);
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
    }
}
