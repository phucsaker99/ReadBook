package com.example.readbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;

import com.example.readbook.databinding.ActivityBookDetailBinding;
import com.example.readbook.model.BookDetails;
import com.example.readbook.utils.AllListData;

import java.util.ArrayList;

public class BookDetailActivity extends AppCompatActivity {
    private ActivityBookDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_book_detail);
        initView();
        initToolbar();
    }

    private void initToolbar() {
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initView() {
        ArrayList<BookDetails> b = new AllListData().getBookDetailData();
        Intent intent = getIntent();
        binding.imBook.setImageResource(intent.getIntExtra(MainActivity.IMAGE, R.drawable.ic_launcher_background));
        binding.title.setText(intent.getStringExtra(MainActivity.TITLE));

        for (BookDetails m: b
        ) {
            if (m.getTitle().equals(intent.getStringExtra(MainActivity.TITLE))){
                binding.tvAuthor.setText("Author: " + intent.getStringExtra(MainActivity.AUTHOR));
                binding.tvCategory.setText("Category: " +intent.getStringExtra(MainActivity.CATE));
                binding.tvStatus.setText("Status: " +intent.getStringExtra(MainActivity.STATU));
                binding.tvChapter.setText("Chapter: " +intent.getStringExtra(MainActivity.CHAPTER));
                binding.tvPost.setText("Post: " +intent.getStringExtra(MainActivity.POSTDATE));
                binding.tvUpdate.setText("Update: " +intent.getStringExtra(MainActivity.UPDATE));
                binding.tvDescription.setText(m.getDescription());
                binding.toolbar.setTitle(intent.getStringExtra(MainActivity.TITLE));
                return;
            }
        }
        binding.tvDescription.setText("Updating");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}