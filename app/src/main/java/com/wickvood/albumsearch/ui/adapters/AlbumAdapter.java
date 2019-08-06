package com.wickvood.albumsearch.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wickvood.albumsearch.R;
import com.wickvood.albumsearch.mvp.model.AlbumsModel;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {


    private List<AlbumsModel> albumsModelList;
    private AlbumClickListener albumClickListener;
    private Context context;

    public AlbumAdapter(Context context, List<AlbumsModel> albumsModelList) {
        this.albumsModelList = albumsModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.album_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        AlbumsModel albumsModel = albumsModelList.get(i);
        final String albumImageUrl = albumsModel.getArtworkUrl100();

        Glide.with(context).load(albumImageUrl).into(viewHolder.albumImage);
        viewHolder.artistName.setText(albumsModel.getArtistName());
        viewHolder.collectionName.setText(albumsModel.getCollectionName());
    }

    @Override
    public int getItemCount() {
        return albumsModelList != null ? albumsModelList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView collectionName;
        TextView artistName;
        ImageView albumImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            collectionName = itemView.findViewById(R.id.tv_album_name);
            artistName = itemView.findViewById(R.id.tv_artist_name);
            albumImage = itemView.findViewById(R.id.collection_art);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && albumsModelList != null){
                albumClickListener.onAlbumClick(
                        albumsModelList.get(position));
            }
        }
    }

    public void setAlbumsModelList(List<AlbumsModel> albumsModelList) {
        this.albumsModelList = albumsModelList;
        notifyDataSetChanged();
    }


   public interface AlbumClickListener{
        void onAlbumClick(AlbumsModel albumsModel);
   }

   public void setItemClickListener(AlbumClickListener listener){
        this.albumClickListener = listener;
   }


}
