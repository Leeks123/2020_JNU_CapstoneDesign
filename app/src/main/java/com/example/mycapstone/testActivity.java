package com.example.mycapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

public class testActivity extends AppCompatActivity {

    PhotoCardDatabase pdb =
            PhotoCardDatabase.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        try {
            pdb.openDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        final ImageView img = findViewById(R.id.testImage);
        PhotoCard p = pdb.getRandomData(1,1);
        img.setImageBitmap(p.img);
        img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                PhotoCard p = pdb.getRandomData(1,1);
                img.setImageBitmap(p.img);
            }
        });
    }
}
