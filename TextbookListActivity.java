package com.example.textbookapp.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.textbookapp.R;
import com.example.textbookapp.models.Textbook;
import com.example.textbookapp.storage.TextbookRepository;
import java.util.List;

public class TextbookListActivity extends AppCompatActivity {

    private ListView listView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_textbooks);

        listView = findViewById(R.id.listView);
        List<Textbook> textbooks = TextbookRepository.getInstance().getAllTextbooks();

        ArrayAdapter<Textbook> adapter = new ArrayAdapter<>(
            this, android.R.layout.simple_list_item_1, textbooks
        );
        listView.setAdapter(adapter);
    }
}
