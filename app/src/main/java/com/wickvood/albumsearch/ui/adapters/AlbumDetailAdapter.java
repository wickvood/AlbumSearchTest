package com.wickvood.albumsearch.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wickvood.albumsearch.R;
import com.wickvood.albumsearch.mvp.model.SongsModel;

import java.util.List;

public class AlbumDetailAdapter extends RecyclerView.Adapter<AlbumDetailAdapter.ViewHolder> {

    private List<SongsModel> songsModelList;
    private Context context;

    public AlbumDetailAdapter(Context context, List<SongsModel> songsModelsList) {
        this.context = context;
        this.songsModelList = songsModelsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.song_item,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        SongsModel songsModel = songsModelList.get(i);
        viewHolder.songName.setText(songsModel.getTrackName());
    }

    @Override
    public int getItemCount() {
        return songsModelList != null ? songsModelList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView songName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            songName = itemView.findViewById(R.id.song_name);
        }
    }

    public void  setSongsModelList(List<SongsModel> songsModelList){
        this.songsModelList = songsModelList;
        notifyDataSetChanged();
    }
}
