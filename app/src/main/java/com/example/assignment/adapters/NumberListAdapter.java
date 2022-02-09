package com.example.assignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.R;
import com.example.assignment.databinding.ItemNumBinding;
import com.example.assignment.models.ListData;

import java.util.List;

public class NumberListAdapter extends RecyclerView.Adapter<NumberListAdapter.MyViewHolder> {

    private static final String TAG = NumberListAdapter.class.getSimpleName();
    private Context mContext;
    private List<ListData> soItemDetailModelList;
    private LayoutInflater layoutInflater;

    public NumberListAdapter(Context context, List<ListData> soItemDetailModelsList) {
        mContext = context;
        this.soItemDetailModelList = soItemDetailModelsList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemNumBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_num, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int position) {

        ListData data = soItemDetailModelList.get(position);
        myViewHolder.performBinding(data);
    }

    @Override
    public int getItemCount() {
        return soItemDetailModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ItemNumBinding itemNumBinding;

        public MyViewHolder(final ItemNumBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemNumBinding = itemBinding;
        }

        public void performBinding(ListData data){
            if (data  != null){
               itemNumBinding.txtItemNum.setText("" + data.getNumber());
               itemNumBinding.txtItemNum.setTextColor(mContext.getResources().getColor(data.getColorRes()));
            }
        }
    }

}
