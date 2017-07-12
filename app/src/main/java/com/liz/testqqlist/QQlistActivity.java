package com.liz.testqqlist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Liz on 17/7/4.
 */
public class QQlistActivity extends Activity {

    private String[] names = new String[]{"小明","小虎"};
    private String[] descs = new String[]{"别人都叫我小名","小虎子的大名"};
    private int[] images = new int[]{R.drawable.image1, R.drawable.image2};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqlist);

        List<Map<String, Object>> listitems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i< names.length; i++){
            Map<String, Object> listitem = new HashMap<String, Object>();
            listitem.put("friendname", names[i]);
            listitem.put("frienddesc", descs[i]);
            listitem.put("friendimage", images[i]);
            listitems.add(listitem);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, listitems,
                R.layout.qqitem,
                new String[]{"friendname","frienddesc","friendimage"},
                new int[]{R.id.name,R.id.desc,R.id.qqimage}
        );

        ListView list = (ListView)findViewById(R.id.qqlist_view);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(QQlistActivity.this, "hello world,"+ position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
