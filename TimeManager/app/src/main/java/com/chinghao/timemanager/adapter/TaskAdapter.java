package com.chinghao.timemanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chinghao.timemanager.R;
import com.chinghao.timemanager.data.ImageFactory;
import com.chinghao.timemanager.entities.TaskDetailEntity;
import com.chinghao.timemanager.entities.TaskState;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ChingHao on 2016/12/22.
 */

public class TaskAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<TaskDetailEntity> mList;

    private boolean showPriority = true;
    private final int[] mPriorityIcons;

    public boolean isShowPriority(){
        return showPriority;
    }
    public void setShowPriority(boolean showPriority){
        this.showPriority=showPriority;
    }

    public TaskAdapter(Context context, List<TaskDetailEntity> list) {
        this.mContext = context;
        this.mList = list;
        mPriorityIcons = ImageFactory.createPriorityIcons();
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.task_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder h= (Holder) holder;
        TaskDetailEntity entity=mList.get(position);
        h.setEntity(entity);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_content)
        TextView mTvContent;
        TaskDetailEntity entity;
        @BindView(R.id.sdv_icon)
        SimpleDraweeView mSdvIcon;
        @BindView(R.id.iv_curr_priority)
        ImageView mIvCurrPriority;
        @BindView(R.id.ll_task_finished_mask)
        LinearLayout mLlTaskFinishedMask;
        public Holder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);

            itemView.setOnClickListener(v -> mListener.onItemClick(getAdapterPosition(), entity));
            itemView.setOnLongClickListener(v -> {
                mListener.onItemLongClick(getAdapterPosition(), entity);
                return true;
            });
        }
        void setEntity(TaskDetailEntity entity){
            this.entity=entity;
            mTvTitle.setText(entity.getTitle());

            String content=entity.getContent();
            int length=content.length();
            String s= content.substring(0,Math.min(length,28));
            if (length>= 28) s += "...";
            mTvContent.setText(s);

            mSdvIcon.setImageURI(entity.getIcon());

            if (showPriority){
                if (!mIvCurrPriority.isShown())
                    mIvCurrPriority.setVisibility(View.VISIBLE);
                int priority =entity.getPriority();
                mIvCurrPriority.setImageResource(mPriorityIcons[priority]);
            }else{
                if (mIvCurrPriority.isShown())
                    mIvCurrPriority.setVisibility(View.INVISIBLE);
            }

            int state =entity.getState();
            if (state == TaskState.FINISHED)
                mLlTaskFinishedMask.setVisibility(View.VISIBLE);
            else
                mLlTaskFinishedMask.setVerticalGravity(View.INVISIBLE);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position ,TaskDetailEntity entity);
        void onItemLongClick(int position ,TaskDetailEntity entity);
    }
    private OnItemClickListener mListener;
    public void setListener(final OnItemClickListener listener){
        mListener=listener;
    }

}
