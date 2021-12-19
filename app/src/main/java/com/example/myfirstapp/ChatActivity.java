package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myfirstapp.Items.MessageAdapter;
import com.example.myfirstapp.Items.MessageItem;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private List<MessageItem> messageItemList = new ArrayList<>();
    private EditText inputText;
    private Button sendButton;
    private RecyclerView messageRecyclerView;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        initMessages();

        inputText = findViewById(R.id.chat_text);
        sendButton = findViewById(R.id.chat_button);
        messageRecyclerView = findViewById(R.id.chat_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        messageRecyclerView.setLayoutManager(layoutManager);
        messageAdapter = new MessageAdapter(messageItemList);
        messageRecyclerView.setAdapter(messageAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    MessageItem messageItem = new MessageItem(content, MessageItem.TYPE_SENT);
                    messageItemList.add(messageItem);
                    messageAdapter.notifyItemInserted(messageItemList.size() - 1);
                    messageRecyclerView.scrollToPosition(messageItemList.size() - 1);
                    inputText.setText("");
                }
            }
        });
    }

    private void initMessages() {
        MessageItem item1 = new MessageItem("Hello world.", MessageItem.TYPE_RECEIVED);
        messageItemList.add(item1);
        MessageItem item2 = new MessageItem("Hello. Who is that.", MessageItem.TYPE_SENT);
        messageItemList.add(item2);
        MessageItem item3 = new MessageItem("This is computer.", MessageItem.TYPE_RECEIVED);
        messageItemList.add(item3);
    }
}