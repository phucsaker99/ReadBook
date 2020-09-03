package com.example.readbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.readbook.adapter.BookAdapter;
import com.example.readbook.databinding.ActivityMainBinding;
import com.example.readbook.databinding.ItemBookBinding;
import com.example.readbook.model.Book;
import com.example.readbook.utils.AllListData;

public class MainActivity extends AppCompatActivity implements BookAdapter.BookListener {
    public static final String TITLE = "1";
    public static final String AUTHOR = "2";
    public static final String CHAPTER = "3";
    public static final String UPDATE = "4";
    public static final String IMAGE = "5";
    public static final String POSTDATE = "6";
    public static final String CATE = "7";
    public static final String STATU = "8";


    private AllListData allListData;
    private ActivityMainBinding binding;
    private BookAdapter adapter;

    //Animation
    private Animation topAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
        initToolbar();
    }

    private void initView() {
        allListData = new AllListData();
        adapter = new BookAdapter(getLayoutInflater());
        binding.lvBook.setAdapter(adapter);
        adapter.setData(allListData.getBookData());
        adapter.setBookListener(this);
    }

    private void initToolbar() {
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    @Override
    public void onItemBookClicked(Book book, ItemBookBinding v) {
        String title = book.getTitle();
        String author = book.getAuthor();
        String chapter = book.getChapter();
        String update = book.getUpdate();
        int image = book.getImage();
        String postDate = book.getPostDate();
        String category = book.getCategory();
        String status = book.getStatus();

        Intent intent = new Intent(MainActivity.this, BookDetailActivity.class);
        intent.putExtra(TITLE, title);
        intent.putExtra(AUTHOR, author);
        intent.putExtra(CHAPTER, chapter);
        intent.putExtra(UPDATE, update);
        intent.putExtra(IMAGE, image);
        intent.putExtra(POSTDATE, postDate);
        intent.putExtra(CATE, category);
        intent.putExtra(STATU, status);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        v.image.setAnimation(topAnim);
        v.tvTitle.setAnimation(topAnim);
        v.tvAuthor.setAnimation(topAnim);
        v.tvChapter.setAnimation(bottomAnim);
        v.tvUpdate.setAnimation(bottomAnim);

        //setup animation
        Pair[] pairs = new Pair[5];
        pairs[0]= new Pair<View, String>(v.image, "ts_image");
        pairs[1]= new Pair<View, String>(v.tvTitle, "ts_title");
        pairs[2]= new Pair<View, String>(v.tvAuthor, "ts_author");
        pairs[3]= new Pair<View, String>(v.tvChapter, "ts_chapter");
        pairs[4]= new Pair<View, String>(v.tvUpdate, "ts_update");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
            startActivity(intent, options.toBundle());
        }
    }

    @Override
    public void onItemBookLongClicked(int position) {

    }

    @SuppressLint("WrongConstant")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                binding.drawerLayout.openDrawer(Gravity.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}