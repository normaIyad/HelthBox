package com.example.myapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        PDFView view = findViewById(R.id.pdf_view);
        Intent intent = getIntent();
        String value = intent.getStringExtra("file");
        view.fromAsset(value+".pdf").load();
    }
}