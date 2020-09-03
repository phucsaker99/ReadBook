package com.example.readbook.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readbook.databinding.ItemBookBinding;
import com.example.readbook.model.Book;

import java.util.ArrayList;
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {
    private BookListener bookListener;
    private LayoutInflater inflater;
    private ArrayList<Book> data;

    public void setData(ArrayList<Book> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setBookListener(BookListener bookListener) {
        this.bookListener = bookListener;
    }

    public BookAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBookBinding binding = ItemBookBinding.inflate(inflater, parent, false);
        return new BookHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final BookHolder holder, final int position) {
        holder.binding.setItem(data.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookListener.onItemBookClicked(data.get(position), holder.binding);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                bookListener.onItemBookLongClicked(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0:data.size();
    }

    public class BookHolder extends RecyclerView.ViewHolder{
        public ItemBookBinding binding;
        public BookHolder(@NonNull ItemBookBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface BookListener {
        void onItemBookClicked(Book book, ItemBookBinding v);
        void onItemBookLongClicked(int position);
    }
}
