package com.wickvood.albumsearch.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;
import com.wickvood.albumsearch.R;
import com.wickvood.albumsearch.mvp.model.AlbumsModel;
import com.wickvood.albumsearch.mvp.model.SongsModel;
import com.wickvood.albumsearch.mvp.presenter.AlbumDetailPresenter;
import com.wickvood.albumsearch.mvp.views.AlbumDetailView;
import com.wickvood.albumsearch.ui.adapters.AlbumDetailAdapter;

import java.util.List;

public class AlbumDetailActivity extends MvpAppCompatActivity implements AlbumDetailView {

    @InjectPresenter
    AlbumDetailPresenter songsPresenter;

    private AlbumDetailAdapter songsAdapter;
    private RecyclerView songsRecyclerView;
    private List<SongsModel> songsModelList;
    private AlertDialog errorDialog;

    private TextView albumName;
    private TextView artistName;
    private ImageView albumImage;
    private ProgressBar progressBar;
    private AlbumsModel selectedAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);

        initView();
        getIntentExtras();
        loadSongs();
    }

    private void initView(){

        albumName = findViewById(R.id.tv_album_name_detail);
        artistName = findViewById(R.id.tv_artist_name_detail);
        albumImage = findViewById(R.id.image_album);
        progressBar = findViewById(R.id.progressBar_detail);
        progressBar.setVisibility(View.GONE);

        songsRecyclerView = findViewById(R.id.recyclerview_songs);
        songsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        songsAdapter = new AlbumDetailAdapter(this,songsModelList);
        songsRecyclerView.setAdapter(songsAdapter);
    }

    private void getIntentExtras(){
        Bundle term = getIntent().getExtras();
        selectedAlbum = term.getParcelable("ALBUM_OBJ");
        albumName.setText(selectedAlbum.getCollectionName());
        artistName.setText(selectedAlbum.getArtistName());
        setTitle(selectedAlbum.getCollectionName());
        Glide.with(this).load(selectedAlbum.getArtworkUrl100()).into(albumImage);
    }

    public void loadSongs(){
        songsPresenter.loadSongs(selectedAlbum.getCollectionId());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void showError(String message) {
        errorDialog = new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(message)
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        songsPresenter.onErrorCancel();
                    }
                })
                .show();
    }

    @Override
    public void hideError() {
        if (errorDialog != null && errorDialog.isShowing()){
            errorDialog.hide();
        }
    }

    @Override
    public void onStartLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFinishLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showListProgress() {
        songsRecyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideListProgress() {
        progressBar.setVisibility(View.GONE);
        songsRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setSongsModel(List<SongsModel> songsModelList) {
        songsAdapter.setSongsModelList(songsModelList);
    }

}
