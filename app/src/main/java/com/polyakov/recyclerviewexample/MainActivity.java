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

    private List<EmailItem> list = generateEmailList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView emailRecycler = findViewById(R.id.email_recycler_view);
        emailRecycler.setLayoutManager(new LinearLayoutManager(this));
        EmailAdapter emailAdapter = new EmailAdapter(list, this);
        emailRecycler.setAdapter(emailAdapter);
        FloatingActionButton fab = findViewById(R.id.email_recycler_view);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreatActivity.class);
                startActivity(intent);
            }
        });
    }

    // переопределённый метод callback. Вызывается при кликах на элементы.
    // Больше информации можно найти в классе адаптера
    @Override
    public void itemClickedCallback(int itemPosition) {
        String toastMessage = "The message from " + list.get(itemPosition).getTitle() + " was clicked!";
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }

    private List<EmailItem> generateEmailList() {
        List<EmailItem> list = new ArrayList<>();
        list.add(new EmailItem("Alex Buranov", "Companies Worldwide Manage Their Business with NetSuite.", "consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoqu", "A moment ago"));
        list.add(new EmailItem("Mike Street", "Real-Time Dashboards ", "etuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis", "20m"));
        list.add(new EmailItem("Lucas 9-9", "Why is Python so popular despite being so slow? ", "ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis", "55m"));
        list.add(new EmailItem("Amazon Rose", "Will Canada buy the F-35? ", "Thanks for accepting my connection, it’s great to have someone with similar interests in my network!", "1h"));
        list.add(new EmailItem("Kazi Ahmed", null, "Lorem impus... WHAT???!!!", "4h"));
        list.add(new EmailItem("New letter", "Artem sent you a new message", "Thanks for accepting my connection, it’s great to have someone with similar interests in my network!", "2d"));
        list.add(new EmailItem(null, "I hacked your computer", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, ", "2d"));
        list.add(new EmailItem("Pushpendra Yad", "", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, ", "2d"));
        list.add(new EmailItem("Alex Buranov", "Companies Worldwide Manage Their Business with NetSuite.", "consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoqu", "3d"));
        list.add(new EmailItem("Mike Street", "Real-Time Dashboards ", "etuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis", "3d"));
        list.add(new EmailItem("Lucas 9-9", "Why is Python so popular despite being so slow? ", "ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis", "3d"));
        list.add(new EmailItem("Amazon Rose", "Will Canada buy the F-35? ", "Thanks for accepting my connection, it’s great to have someone with similar interests in my network!", "3d"));
        list.add(new EmailItem("Kazi Ahmed", null, "Lorem impus... WHAT???!!!", "3d"));
        list.add(new EmailItem("New letter", "Artem sent you a new message", "Thanks for accepting my connection, it’s great to have someone with similar interests in my network!", "3d"));
        list.add(new EmailItem(null, "I hacked your computer", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, ", "3d"));
        list.add(new EmailItem("Pushpendra Yad", "", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, ", "4d"));
        return list;
    }
}
