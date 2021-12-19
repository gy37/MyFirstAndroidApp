package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final int TEST_REQUEST_CODE = 1000;
    //logt
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMethod();
    }

    /** called when the user taps the send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editTextTextPersonName);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void initMethod() {
        Locale primaryLocale = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            primaryLocale = getResources().getConfiguration().getLocales().get(0);
            String locale = primaryLocale.getDisplayName();
            Toast.makeText(this, locale, Toast.LENGTH_SHORT).show();
        }
        Log.i(TAG, "initMethod: test log");

        Button button = findViewById(R.id.button11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LayoutActivity.class);
                startActivity(intent);
            }
        });

        Button button1 = findViewById(R.id.button18);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.button19);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        Button button3 = findViewById(R.id.button20);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        Button button4 = findViewById(R.id.button22);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(intent);
            }
        });

        Button button5 = findViewById(R.id.button23);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewsListActivity.class);
                startActivity(intent);
            }
        });

        Button button6 = findViewById(R.id.button24);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BroadcastActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i("MainActivity", String.valueOf(newConfig));
        //check the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }

    public void toActivityTest(View view) {
//        Intent intent = new Intent("com.example.myfirstapp.ACTION_START_TEST");//隐式
//        intent.addCategory("com.example.myfirstapp.MY_CATEGORY");
//        startActivity(intent);

        Intent intent = new Intent(this, ActivityTest.class);//显式
        startActivityForResult(intent, TEST_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TEST_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra(ActivityTest.TEST_EXTRA_MESSAGE);
                    Toast.makeText(this, returnData, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}