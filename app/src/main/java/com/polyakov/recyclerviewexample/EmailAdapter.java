package com.polyakov.recyclerviewexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.ViewHolder> {

    private List<EmailItem> emailsPreviewList;
    private EmailItemClicked callback;

    // конструктор, принимает на вход нужный лист с данными, для дальнейшей работы с ними.
    EmailAdapter(List<EmailItem> emailsPreviewList,
                        EmailItemClicked callback) {
        this.emailsPreviewList = emailsPreviewList;
        this.callback = callback;
    }

    // тут мы должны указать layout для работы с элементами
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        // указываем лаяут
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_recycler_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        // добавляем слушатель кликов на все подобные лаяуты (добавится слушатель всего один раз)
        // рекомендую подробно прочесть про анонимные классы, если не понятен код ниже
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // находим позицию элемента, на оторый нажали
                int adapterPosition = holder.getAdapterPosition();
                // проверяем корректность позиции и наличие callback
                if (adapterPosition != RecyclerView.NO_POSITION && callback != null) {
                    // делегируем работу с данными через callback.
                    // В адаптере не должно быть лишней логики.
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
        // получаем текущий элемент у нашего листа
        final EmailItem item = emailsPreviewList.get(position);
        // проверка наших объектов на null или пустую строку
        if (item.getTitle() != null && !item.getTitle().isEmpty()) {
            holder.titleTv.setText(item.getTitle());
        } else {
            // в случае пустой или null строки в объекте, ставим вместо него другой текст
            holder.titleTv.setText(R.string.addressee);
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

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv, subTitleTv, contentTv, dateTv;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.title_text_view);
            subTitleTv = itemView.findViewById(R.id.subtitle_text_view);
            dateTv = itemView.findViewById(R.id.time_text_view);
        }
    }
}
