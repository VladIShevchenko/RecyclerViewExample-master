package com.polyakov.recyclerviewexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.ViewHolder> {

    private List<EmailItem> emailsPreviewList;
    private EmailItemClicked callback;
    private Context context;

    // конструктор, принимает на вход нужный лист с данными, для дальнейшей работы с ними.
    public EmailAdapter(List<EmailItem> emailsPreviewList,
                 EmailItemClicked callback, Context context) {
        this.emailsPreviewList = emailsPreviewList;
        this.callback = callback;
        this.context = context;
    }


    // тут мы должны указать layout для работы с элементами
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_recycler_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION && callback != null) {
                    callback.itemClickedCallback(adapterPosition);
                }
            }
        });
        return holder;
    }

    // метод вызывается для отрисовки нового экземпляра.
    // Будет вызван у каждого нового элемента.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final EmailItem item = emailsPreviewList.get(position);
        if (item.getUserImg() != null && !item.getUserImg().isEmpty()) {
            Glide.with(context)
                    .load(item.getUserImg())
                    .into(holder.iv_avatar);
        } else {
            String userImgDefault = "http://simpleicon.com/wp-content/uploads/user1.png";
            Glide.with(context)
                    .load(userImgDefault)
                    .into(holder.iv_avatar);
        }

        if (item.getTitle() != null && !item.getTitle().isEmpty()) {
            holder.titleTv.setText(item.getTitle());
        } else {
            // в случае пустой или null строки в объекте, ставим вместо него другой текст
            holder.titleTv.setText(R.string.email_title_placeholder);
        }
        if (item.getSubTitle() != null && !item.getSubTitle().isEmpty()) {
            holder.subTitleTv.setText(item.getSubTitle());
        } else {
            // в случае пустой или null строки в объекте, прячем textview с текущего элемента
            holder.subTitleTv.setVisibility(View.GONE);
        }
        if (item.getContent() != null && !item.getContent().isEmpty()) {
            holder.contentTv.setText(item.getContent());
        } else {
            holder.contentTv.setVisibility(View.GONE);
        }

        if (item.getDate() != null && !item.getDate().isEmpty()) {
            holder.dateTv.setText(item.getDate());
        }
    }

    // метод вызывается для получения максимального количества элементов
    @Override
    public int getItemCount() {
        if (emailsPreviewList == null) return 0;
        return emailsPreviewList.size();
    }

    interface EmailItemClicked {
        void itemClickedCallback(int itemPosition);
    }

  public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv, subTitleTv, contentTv, dateTv;
      ImageView iv_avatar;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.title_text_view);
            subTitleTv = itemView.findViewById(R.id.subtitle_text_view);
            contentTv = itemView.findViewById(R.id.content_text_view);
            dateTv = itemView.findViewById(R.id.time_text_view);
            iv_avatar = itemView.findViewById(R.id.photo);
        }
    }
}
