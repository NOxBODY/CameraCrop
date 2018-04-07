package com.example.sabet.test;

import android.content.ContentResolver;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ShowActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        imageView = findViewById(R.id.imageView);
//        imageView.setImageBitmap(MainActivity.bitmap);
        Glide.with(this).load(MainActivity.bitmap).into(imageView);
        /*ContentResolver cr = getContentResolver();
        String title = "myBitmap";
        String description = "My bitmap created by Android-er";
        String savedURL = MediaStore.Images.Media
                .insertImage(cr, MainActivity.bitmap, title, description);*/
    }
}
