package yoosanghyeon.tagsamplerecyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import yoosanghyeon.tagsamplerecyclerview.listener.TagContainerClickListener;
import yoosanghyeon.tagsamplerecyclerview.listener.TagViewClickListener;

/**
 * Created by yoosanghyeon on 2017-06-08.
 */

public class TagViewAdapter extends RecyclerView.Adapter<TagVIewHolder> implements TagViewClickListener {

    private Context mContext;

    // data init var
    private ArrayList<String> tagTitles;

    // item selcted data var
    private ArrayList<String> selectedTagDatas;

    // tagList selected Lisenter
    private TagContainerClickListener tagContainerClickListener;



    public TagViewAdapter(Context context, @Nullable ArrayList<String> tagTitles, TagContainerClickListener tagContainerClickListener) {
        mContext = context;
        if (tagTitles != null) {
            this.tagTitles = tagTitles;
        } else {
            this.tagTitles = new ArrayList<>();
        }

        selectedTagDatas = new ArrayList<>();

        this.tagContainerClickListener = tagContainerClickListener;

    }

    @Override
    public TagVIewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tag_view, parent, false);
        TagVIewHolder tagVIewHolder = new TagVIewHolder(itemView);
        return tagVIewHolder;
    }

    @Override
    public void onBindViewHolder(TagVIewHolder holder, int position) {

        holder.onBindToDataTagView(mContext, tagTitles.get(position), this);
    }

    @Override
    public int getItemCount() {
        return tagTitles.size();
    }

    @Override
    public void onSelectedClick(String tag) {
        selectedTagDatas.add(tag);
        tagContainerClickListener.onSelectedTags(selectedTagDatas);
    }

    @Override
    public void onDeselectedClick(String tag) {
        selectedTagDatas.remove(tag);
        tagContainerClickListener.onSelectedTags(selectedTagDatas);
    }
}
