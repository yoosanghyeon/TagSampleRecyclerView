package yoosanghyeon.tagsamplerecyclerview;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import yoosanghyeon.tagsamplerecyclerview.listener.TagViewClickListener;

/**
 * Created by yoosanghyeon on 2017-06-08.
 */

 public  class TagVIewHolder extends RecyclerView.ViewHolder {

    private Button tagView;
    private boolean selectedTagView = true;

    private TagViewClickListener tagViewClickListener;
    private Context mContext;



    public TagVIewHolder(View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(View view){
        tagView = (Button) view.findViewById(R.id.item_tag_btn);
        tagView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedTagView){
                    tagViewClickListener.onSelectedClick(tagView.getText().toString());
                    tagView.setBackground(mContext.getDrawable(R.drawable.shape_slected_tagview));
                    selectedTagView = false;
                }else{
                    tagViewClickListener.onDeselectedClick(tagView.getText().toString());
                    tagView.setBackground(mContext.getDrawable(R.drawable.shape_unslected_tagview));
                    selectedTagView = true;
                }
            }
        });

    }

    public void onBindToDataTagView(final Context context, final String tagTItle, final TagViewClickListener tagViewClickListener){
        tagView.setText(tagTItle);

        mContext = context;
        this.tagViewClickListener = tagViewClickListener;
    }
}
