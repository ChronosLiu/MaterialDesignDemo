package com.yang.materialdesigndemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 洋 on 2016/7/8.
 */
public class BookRecyclerAdapter extends RecyclerView.Adapter<BookViewHolder> {

    private List<Book> bookList = new ArrayList<>();

    private Context context ;

    private OnRecyclerItemClickListener listener;

    public BookRecyclerAdapter(Context context,OnRecyclerItemClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
        notifyDataSetChanged();
    }


    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycler_item_book,parent,false);
        BookViewHolder bookViewHolder = new BookViewHolder(view,listener);


        return bookViewHolder;
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.titleTv.setText(book.getTitle());
        String desc = "作者："+book.getAuthor()[0] +"\n出版年："+book.getPubDate()+
                "\n页数："+book.getPages()+"\n定价："+book.getPrice();
        holder.descTv.setText(desc);
        holder.bookIv.setImageDrawable(context.getResources().getDrawable(book.getImageId(),null));

    }

    @Override
    public int getItemCount() {

        return bookList==null?0:bookList.size();
    }
}
