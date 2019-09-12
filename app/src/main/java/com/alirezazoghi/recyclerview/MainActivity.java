package com.alirezazoghi.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.parent_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        recyclerView.setAdapter(new ParentAdapter(this, getString()));
    }

    private List<List<String>> getString() {
        List<List<String>> s = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<String> strings = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                strings.add(String.valueOf(j));
            }
            s.add(strings);
        }
        return s;
    }
}
