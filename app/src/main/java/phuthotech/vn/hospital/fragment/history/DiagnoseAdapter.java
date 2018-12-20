package phuthotech.vn.hospital.fragment.history;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import phuthotech.vn.hospital.R;

/**
 * Created by kingpes on 9/19/18.
 */

public class DiagnoseAdapter extends RecyclerView.Adapter<DiagnoseAdapter.MyViewHolder> {
    private List<String> lists;

    public DiagnoseAdapter(List<String> lists) {
        this.lists = lists;
    }

    public interface OnItemClick {
        void onClick(int p);
    }

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.diagnose_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.name.setText(lists.get(position));

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        MyViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txt);

        }
    }
}
