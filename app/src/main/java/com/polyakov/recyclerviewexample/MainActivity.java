package com.polyakov.recyclerviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import android.support.design.widget.FloatingActionButton;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EmailAdapter.EmailItemClicked {
    private static final String EMAIL_ITEM ="email item";
    private List<EmailItem> list = generateEmailList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView emailRecycler = findViewById(R.id.email_recycler_view);
        emailRecycler.setLayoutManager(new LinearLayoutManager(this));

        EmailAdapter emailAdapter = new EmailAdapter(list, this,this);
        emailRecycler.setAdapter(emailAdapter);

        FloatingActionButton fab = findViewById(R.id.myFAB);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreatActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void itemClickedCallback(int itemPosition) {
        Intent intent = new Intent(this, OwnActivity.class);
        intent.putExtra(EMAIL_ITEM, list.get(itemPosition));
        startActivity(intent);
    }

    private List<EmailItem> generateEmailList() {
        List<EmailItem> list = new ArrayList<>();
        list.add(new EmailItem("https://image.freepik.com/free-icon/no-translate-detected_318-40485.jpg","GitHub", "A personal access token has beenadded to your account", "consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoqu", "15m"));
        list.add(new EmailItem("https://cdn0.iconfinder.com/data/icons/free-social-media-set/24/discord-512.png","Discord", "Download new Update ", "New functions will give you many reasons to choose our program dolor. Aenean massa. Cum sociis natoque penatibus et magnis", "20m"));
        list.add(new EmailItem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRadiaMyPLZV9DCt7cDAz3ZnulcgDZAyj2cs7JmSvZjlS8oeaGG","Pinterest", "18 new images on your page ", "ipsum dolor sit amet, consectetuer amazing social netwotk and how it works", "55m"));
        list.add(new EmailItem("https://cdn2.iconfinder.com/data/icons/instagram-new/512/instagram-logo-color-512.png","Instagram", "Free social media ", "ipsum dolor sit amet, consectetuer amazing social netwotk and how it works", "55m"));
        return list;
    }
}
