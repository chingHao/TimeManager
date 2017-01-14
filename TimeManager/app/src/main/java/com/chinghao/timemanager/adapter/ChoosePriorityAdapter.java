package com.chinghao.timemanager.adapter;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chinghao.timemanager.R;
import com.chinghao.timemanager.data.ImageFactory;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ChingHao on 2017/1/12.
 */

public class ChoosePriorityAdapter extends RecyclerView.Adapter {

    public static class Item {
        String name;
        @DrawableRes
        int resId;

        public Item(String name, int resId) {
            this.name = name;
            this.resId = resId;
        }
    }

    private final LayoutInflater mInflater;
    private List<Item> mList = new ArrayList<>();
    private Context mContext;

    private int mCheckItem;

    {
        int[] priorityIcons = ImageFactory.createPriorityIcons();
        mList.add(new Item("每天", priorityIcons[0]));
        mList.add(new Item("坚持", priorityIcons[1]));
        mList.add(new Item("事件", priorityIcons[2]));
        mList.add(new Item("必须", priorityIcons[3]));

    }

    public int getCheckItem() {
        return mCheckItem;
    }

    public void setCheckItem(int checkItem) {
        notifyItemChanged(mCheckItem);

        notifyItemChanged(checkItem);

        mCheckItem = checkItem;
    }

    public ChoosePriorityAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_choose_priority, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder h = (Holder) holder;
        Item item=mList.get(position);
        h.mIvPriorityIcon.setImageResource(item.resId);
        h.mTvPriorityText.setText(item.name);
        h.mIvMask.setVisibility(View.INVISIBLE);
        if (mCheckItem==position){
            h.mIvMask.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_priority_icon)
        ImageView mIvPriorityIcon;
        @BindView(R.id.iv_mask)
        ImageView mIvMask;
        @BindView(R.id.tv_priority_text)
        TextView mTvPriorityText;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(view -> mOnItemOnClickListener.onClick(view, getAdapterPosition()));
        }
    }

    public interface OnItemOnClickListener {

        void onClick(View view, int position);
    }

    private OnItemOnClickListener mOnItemOnClickListener;

    public void setOnItemOnClickListener(OnItemOnClickListener onItemOnClickListener) {
        mOnItemOnClickListener = onItemOnClickListener;
    }
}
