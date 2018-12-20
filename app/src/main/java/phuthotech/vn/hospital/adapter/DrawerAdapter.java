package phuthotech.vn.hospital.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.model.Drawerz;

/**
 * Created by kingpes on 9/5/18.
 */

public class DrawerAdapter extends BaseAdapter {
    private Context context;
    private List<Drawerz> lists;

    public DrawerAdapter(Context context, List<Drawerz> lists) {
        this.context = context;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                convertView = inflater.inflate(R.layout.draweritem, parent, false);

        }

        TextView drawerTitle = convertView.findViewById(R.id.drawerTitle);
        drawerTitle.setText(lists.get(position).getTitle());

        return convertView;
    }
}

