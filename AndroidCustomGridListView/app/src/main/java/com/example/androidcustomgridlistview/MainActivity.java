package com.example.androidcustomgridlistview;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {
    GridView grid;
    String[] web = {
            "Facebook","Instagram","Pinterest",
            "Twitter","Youtube","Flickr","Github","Whatsapp",
            "TikTok","Linkedin","TelegramApp","Messenger",
            "Reddit","Viber", "WordPress",
    };
    int[] imageId = {
            R.drawable.download1, R.drawable.download2, R.drawable.download3,
            R.drawable.download4, R.drawable.download5, R.drawable.download6,
            R.drawable.download7, R.drawable.download8, R.drawable.download9,
            R.drawable.download10, R.drawable.download11, R.drawable.download12,
            R.drawable.download13, R.drawable.download14, R.drawable.download15
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomGrid adapter = new CustomGrid(MainActivity.this, web, imageId);
        grid = findViewById(R.id.grid);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked at " + web[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}

