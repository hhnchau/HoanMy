package phuthotech.vn.hospital.fragment.history;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import phuthotech.vn.hospital.R;

/**
 * Created by kingpes on 9/19/18.
 */

public class ClinicAdapter extends PagerAdapter {
    private List<String> lists;

    public ClinicAdapter(List<String> lists) {
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.clinic_item, container, false);


        TextView txt = view.findViewById(R.id.txt);
        txt.setText(position + "");

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
