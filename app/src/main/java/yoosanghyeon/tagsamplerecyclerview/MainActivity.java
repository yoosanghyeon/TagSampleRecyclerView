package yoosanghyeon.tagsamplerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import yoosanghyeon.tagsamplerecyclerview.listener.TagContainerClickListener;

public class MainActivity extends AppCompatActivity implements TagContainerClickListener {

    RecyclerView recyclerView;

    TagViewAdapter tagViewAdapter;

    ArrayList<String> tagDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onDataInit();

        recyclerView = (RecyclerView) findViewById(R.id.tag_recyclerviewe);
        tagViewAdapter = new TagViewAdapter(this, tagDatas, this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        recyclerView.setAdapter(tagViewAdapter);

    }

    private void onDataInit() {
        tagDatas = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            tagDatas.add("tags :: " + i);
        }
    }

    @Override
    public void onSelectedTags(ArrayList<String> onSelectedTagsDatas) {
        for (String tag : onSelectedTagsDatas){
            Log.e("Activity::onSelectedTag", tag);
        }

    }
}
