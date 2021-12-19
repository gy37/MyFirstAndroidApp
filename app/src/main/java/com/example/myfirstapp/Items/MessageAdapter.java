package com.example.myfirstapp.Items;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstapp.R;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private List<MessageItem> mMessageItemList;
    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMessage;
        TextView rightMessage;
        public ViewHolder(View view) {
            super(view);
            leftLayout = view.findViewById(R.id.left_layout);
            rightLayout = view.findViewById(R.id.right_layout);
            leftMessage = view.findViewById(R.id.left_message);
            rightMessage = view.findViewById(R.id.right_message);
        }
    }

    public MessageAdapter(List<MessageItem> messageItemList) {
        mMessageItemList = messageItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MessageItem messageItem = mMessageItemList.get(position);
        if (messageItem.getType() == MessageItem.TYPE_RECEIVED) {
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMessage.setText(messageItem.getContent());
        } else if (messageItem.getType() == MessageItem.TYPE_SENT) {
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightMessage.setText(messageItem.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMessageItemList.size();
    }
}
