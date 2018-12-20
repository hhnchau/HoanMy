package phuthotech.vn.hospital.fragment.history;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.api.ApiManager;
import phuthotech.vn.hospital.api.OnCallback;

/**
 * Created by kingpes on 9/5/18.
 */

public class HistoryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_fragment, container, false);


        History1 frame1 = new History1();
        History2 frame2 = new History2();


        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame1, frame1, History1.class.getName())
                    .add(R.id.frame2, frame2, History2.class.getName())
                    .commit();


        ApiManager.getInstance().getHistoryPatientOnHQ(getActivity(), "http://172.16.0.48:16910/api/MPI/GetHistoryPatientOnHQ", 26, "332551147", "DN725847777777777774", new OnCallback() {
            @Override
            public void onCallBack(Object object) {

            }
        });


        return view;
    }
}
