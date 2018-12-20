package phuthotech.vn.hospital.custom;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.model.api.patient.Additional;
import phuthotech.vn.hospital.utils.Utils;

/**
 * Created by kingpes on 8/31/18.
 */

public class MyListView extends LinearLayout {
    private ListView listView;
    private MyAdapter adapter;
    private List<Additional> lists;

    public interface OnItemClickListener {
        void onItemClickListener(View view, String s);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public MyListView(Context context) {
        super(context);
        create(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        create(context);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        create(context);
    }

    private void create(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.mylistview, this);
            listView = findViewById(R.id.myListView);

            listView.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
            });
        }
    }

    public void setListView(final MyListView myListView, final List<Additional> list, String keyword) {
        this.lists = list;

        adapter = new MyAdapter(myListView.getContext(), R.layout.mylistviewitem, lists, keyword);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onItemClickListener.onItemClickListener(myListView, list.get(position).getNAME());
            }
        });
    }

    public void notifyDataSetChange(List<Additional> list) {
        this.lists = list;
        adapter.notifyDataSetChanged();
    }
}

class MyAdapter extends ArrayAdapter<Additional> {
    private Context context;
    private int row;
    private List<Additional> lists;
    private String keyword;

    MyAdapter(@NonNull Context context, int resource, List<Additional> lists, String keyword) {
        super(context, resource, lists);
        this.context = context;
        this.row = resource;
        this.lists = lists;
        this.keyword = keyword;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(row, null);
        }

        TextView txt = convertView.findViewById(R.id.title);

        Additional additional = lists.get(position);
        if (additional != null)

            txt.setText(Utils.spannable(additional.getNAME(), keyword));


        return convertView;
    }
}

