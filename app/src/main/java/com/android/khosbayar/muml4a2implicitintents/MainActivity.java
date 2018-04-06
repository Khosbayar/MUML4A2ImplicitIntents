package com.android.khosbayar.muml4a2implicitintents;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_TAKE_PICTURE = 1;
    private EditText mPhonenum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPhonenum = findViewById(R.id.etPhoneNumber);
    }

    public void makeCall(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + mPhonenum.getText().toString()));
        startActivity(intent);
    }

    public void openCamera(View view) {
        Intent i = new Intent();
        i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(i);
    }

    public void openWebBrowser(View view) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://www.google.com/"));
        startActivity(Intent.createChooser(i, "Google"));
    }

    public void findOnMap(View view) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("geo:41.017981, -91.967171"));
        startActivity(i);
    }
}
