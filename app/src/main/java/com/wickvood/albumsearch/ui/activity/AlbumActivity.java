package com.wickvood.albumsearch.ui.activity;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.wickvood.albumsearch.R;
import com.wickvood.albumsearch.mvp.model.AlbumsModel;
import com.wickvood.albumsearch.mvp.presenter.AlbumPresenter;
import com.wickvood.albumsearch.mvp.views.AlbumView;
import com.wickvood.albumsearch.ui.adapters.AlbumAdapter;

import java.util.List;


public class AlbumActivity extends MvpAppCompatActivity implements AlbumView,AlbumAdapter.AlbumClickListener{

    @InjectPresenter
    AlbumPresenter albumPresenter;

    private AlbumAdapter albumAdapter;
    private RecyclerView albumRecyclerView;
    private List<AlbumsModel> albumsModelList;
    private AlertDialog errorDialog;

    private TextView tvNoAlbum;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        tvNoAlbum = findViewById(R.id.tv_noAlbum);
        progressBar = findViewById(R.id.progressBar_album);
        progressBar.setVisibility(View.GONE);

        albumRecyclerView = findViewById(R.id.recycler_view_album);
        albumRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        albumAdapter = new AlbumAdapter(this,albumsModelList);
        albumAdapter.setItemClickListener(this);
        albumRecyclerView.setAdapter(albumAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Search album by artists");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchAlbum(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    public void searchAlbum(String query){
        albumPresenter.searchAlbum(query);
    }

    @Override
    public void showError(String message) {
        errorDialog = new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(message)
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        albumPresenter.onErrorCancel();
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
        tvNoAlbum.setVisibility(View.GONE);
    }

    @Override
    public void onFinishLoading() {
        progressBar.setVisibility(View.GONE);
    }


    @Override
    public void showListProgress() {
        albumRecyclerView.setVisibility(View.GONE);
        tvNoAlbum.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideListProgress() {
        progressBar.setVisibility(View.GONE);
        albumRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setAlbumsModel(List<AlbumsModel> albumsModelList) {
       albumAdapter.setAlbumsModelList(albumsModelList);
    }

    @Override
    public void onAlbumClick(AlbumsModel selectedAlbum) {
        final Intent intent = new Intent(this, AlbumDetailActivity.class);
        intent.putExtra("ALBUM_OBJ",selectedAlbum);
        startActivity(intent);
    }
}
