package com.bumaiyangcong.uibestpractice;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pange on 公元17-06-11.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<Msg> mMsgList;



    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftlayout;
        LinearLayout rightlayout;
        TextView leftMsg;
        TextView rightMsg;
        public ViewHolder(View view) {
            super(view);
            leftlayout = (LinearLayout) view.findViewById(R.id.left_layout);
            rightlayout = (LinearLayout) view.findViewById(R.id.right_layout);
            leftMsg = (TextView) view.findViewById(R.id.left_msg);
            rightMsg = (TextView) view.findViewById(R.id.right_msg);
        }
    }
    public MsgAdapter(List<Msg>msglist){
        mMsgList=msglist;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg=mMsgList.get(position);
        //如果是收到的消息，则显示左边的消息布局，将右边的布局隐藏
        if (msg.getType()==Msg.TYPE_RECEIVED){
            holder.leftlayout.setVisibility(View.VISIBLE);
            holder.rightlayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        }else{
            holder.rightlayout.setVisibility(View.VISIBLE);
            holder.rightlayout.setVisibility(View.GONE);
            holder.rightMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }


}
