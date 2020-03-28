package com.hiro.lovememory;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    File startDate;
    int days;
    RelativeLayout mainLayout;
    TextView txvDays;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
//        getSupportActionBar().hide(); //hide the title bar
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_main);
        txvDays = findViewById(R.id.txvDays);
        SetStartDate();
//        if (!startDate.exists()) {
//
//        } else {
//            try {
//                InputStream stream = MainActivity.this.openFileInput("days.txt");
//                if (stream != null) {
//                    InputStreamReader inputStreamReader = new InputStreamReader(stream);
//                    days = inputStreamReader.read();
//                    txvDays.setText((days));
//                    inputStreamReader.close();
//                }
//            } catch (IOException e) {
//                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
//            }
//        }
    }

    private void SetStartDate(){
        final Date now = new Date();
        final Calendar dayPicked = Calendar.getInstance();

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dayPicked.set(year,month, dayOfMonth);
                days = (int) TimeUnit.MILLISECONDS.toDays(now.getTime() - dayPicked.getTime().getTime()) + 2;
                txvDays.setText(Integer.toString(days));
//                try {
//                    OutputStreamWriter writer = new OutputStreamWriter(MainActivity.this.openFileOutput("days.txt", Context.MODE_PRIVATE));
//                    writer.write((days));
//                    txvDays.setText((days));
//                    writer.close();
//                } catch (Exception e) {
//                    Toast.makeText(MainActivity.this, "Error while writing file!", Toast.LENGTH_SHORT).show();
//                }
            }
        }, dayPicked.get(Calendar.YEAR), dayPicked.get(Calendar.MONTH), dayPicked.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    private void ExitApp(){
        moveTaskToBack(true);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
