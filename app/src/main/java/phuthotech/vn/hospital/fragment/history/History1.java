package phuthotech.vn.hospital.fragment.history;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.base.BaseFragment;

/**
 * Created by kingpes on 9/18/18.
 */

public class History1 extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history1_fragment, container, false);
        return view;
    }
}
