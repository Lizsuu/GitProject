package com.liz.testqqlist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //点击后,通过intent启动QQlistActivity
        Button bt_goto_qqlist = (Button) findViewById(R.id.goto_qqlist);
        bt_goto_qqlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QQlistActivity.class);
                startActivity(intent);
            }
        });

        preferences = getSharedPreferences("apk1_pref",MODE_PRIVATE);
        editor = preferences.edit();
        //点击后,读取preferences里的数据
        Button bt_read_preferences = (Button)findViewById(R.id.read_preferences);
        bt_read_preferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = preferences.getString("time",null);
                Integer random = preferences.getInt("random",0);
                String result = time == null ? "暂时没有数据" : "您上次写入数据的时间为:"+time+"\n上次写入的随机数为:" + random;
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        });
        //点击后,写入时间和random
        Button bt_write_preferences = (Button)findViewById(R.id.write_preferences);
        bt_write_preferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日" + "HH:mm:ss");
                editor.putString("time","时间获取失败");
                editor.putInt("random",(int) (Math.random() * 100));
                editor.commit();
            }
        });

    }
}
