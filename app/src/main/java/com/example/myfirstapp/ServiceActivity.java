package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myfirstapp.Download.DownloadService;
import com.example.myfirstapp.Services.MyIntentService;
import com.example.myfirstapp.Services.MyService;

public class ServiceActivity extends AppCompatActivity {
    private static final String TAG = "ServiceActivity";
    private MyService.DownloadBinder myDownloadBinder;
    private DownloadService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: " + name + " service: " + service);
            if (service instanceof MyService.DownloadBinder) {
                myDownloadBinder = (MyService.DownloadBinder)service;
                myDownloadBinder.startDownload();
                myDownloadBinder.getProgress();
            } else if (service instanceof DownloadService.DownloadBinder) {
                downloadBinder = (DownloadService.DownloadBinder)service;
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        Button start = findViewById(R.id.button44);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(ServiceActivity.this, MyService.class);
                startService(startIntent);
            }
        });

        Button stop = findViewById(R.id.button45);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stopIntent = new Intent(ServiceActivity.this, MyService.class);
                stopService(stopIntent);
            }
        });

        Button bind = findViewById(R.id.button46);
        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bindIntent = new Intent(ServiceActivity.this, MyService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE);
            }
        });
        Button unbind = findViewById(R.id.button47);
        unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(connection);
            }
        });

        Button startIntentService = findViewById(R.id.button48);
        startIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + "Thread id is " + Thread.currentThread().getId());
                Intent intentService = new Intent(ServiceActivity.this, MyIntentService.class);
                startService(intentService);
            }
        });

        Intent intent = new Intent(this, DownloadService.class);
        startService(intent);//启动服务，保证服务在后台运行
        bindService(intent, connection, BIND_AUTO_CREATE);//绑定服务可以让activity和service进行通信
        if (ContextCompat.checkSelfPermission(ServiceActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ServiceActivity.this, new String[]{ Manifest.permission.WRITE_EXTERNAL_STORAGE }, 1);
        }
        Button startDownload = findViewById(R.id.button49);
        startDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (downloadBinder == null) {
                    return;
                }
                String url = "https://mirrors.nju.edu.cn/eclipse//oomph/epp/2022-03/R/eclipse-inst-jre-mac64.dmg";
                downloadBinder.startDownload(url);
            }
        });
        Button pauseDownload = findViewById(R.id.button50);
        pauseDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (downloadBinder == null) {
                    return;
                }
                downloadBinder.pauseDownload();
            }
        });
        Button cancelDownload = findViewById(R.id.button51);
        cancelDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (downloadBinder == null) {
                    return;
                }
                downloadBinder.cancelDownload();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "拒绝权限将无法使用程序", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);//活动销毁时，取消绑定服务
    }
}