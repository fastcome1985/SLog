package com.starlinkings.slog.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.starlinkings.slog.dlog.DLog;
import com.starlinkings.slog.vlog.VLog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button changeTagBtn;
    private final String tag = "MainActivity";
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeTagBtn = (Button) findViewById(R.id.change_tag);
        changeTagBtn.setOnClickListener(this);
        findViewById(R.id.log_i_1).setOnClickListener(this);
        findViewById(R.id.log_easy).setOnClickListener(this);
        findViewById(R.id.log_t).setOnClickListener(this);
        findViewById(R.id.log_open).setOnClickListener(this);
        findViewById(R.id.log_close).setOnClickListener(this);
        findViewById(R.id.vlog_set).setOnClickListener(this);
        findViewById(R.id.vlog_append).setOnClickListener(this);
        findViewById(R.id.jump).setOnClickListener(this);
        VLog.init(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.change_tag:
                i++;
                String newTag = tag + i;
                Toast.makeText(MainActivity.this, "tag已经变为:" + newTag, Toast.LENGTH_SHORT).show();
                DLog.setTag(newTag);
                break;
            case R.id.log_i_1:
                DLog.i("this is a log of dlog");
                break;
            case R.id.log_easy:
                DLog.easylog(Log.INFO, MainActivity.class.getSimpleName(), "this is log_easy ");
                break;
            case R.id.log_t:
                DLog.t("once tag", 5).i("the tag of this tag use only once");
                break;
            case R.id.log_close:
                DLog.closeDlog();
                break;
            case R.id.log_open:
                DLog.openDlog();
                break;
            case R.id.vlog_set:
                VLog.log("set floatlog hello world " + " \n");
                break;
            case R.id.vlog_append:
                VLog.appendLog("app end vlog helloworld ++ " + " \n");
                break;

            case R.id.jump:
                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(intent);
                break;
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        VLog.clear();
    }
}
