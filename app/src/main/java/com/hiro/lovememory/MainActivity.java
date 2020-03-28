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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    File file;
    int days;
    Date startDate;
    RelativeLayout mainLayout;
    TextView txvDays;
    ImageButton btnExit, btnInfo, imgbtnHeart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
//        getSupportActionBar().hide(); //hide the title bar
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_main);
        txvDays = findViewById(R.id.txvDays);
        btnExit = findViewById(R.id.btnExit);
        btnInfo = findViewById(R.id.btnInfo);
        imgbtnHeart = findViewById(R.id.imgbtnHeart);
        imgbtnHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetStartDate();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExitApp();
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Love Memory - Develop by Văn Phát IT", Toast.LENGTH_LONG).show();
            }
        });

        file = new File(MainActivity.this.getFilesDir(), "startDate");
        if (!file.exists()){
            SetStartDate();
        } else {
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Scanner reader = new Scanner(file, "UTF-8");
                startDate = format.parse(reader.nextLine());
                reader.close();
                days = (int) TimeUnit.MILLISECONDS.toDays(new Date().getTime() - startDate.getTime()) + 1;
                txvDays.setText(String.valueOf(days));
            } catch (Exception e){
                Toast.makeText(this, "Error while reading", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void SetStartDate(){
        final Date now = new Date();
        final Calendar dayPicked = Calendar.getInstance();

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dayPicked.set(year,month, dayOfMonth);
                days = (int) TimeUnit.MILLISECONDS.toDays(now.getTime() - dayPicked.getTime().getTime()) + 1;

                try {
                    File file = new File(MainActivity.this.getFilesDir(), "startDate");
                    FileWriter writer = new FileWriter(file);
                    SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
                    writer.write(String.valueOf(formater.format(dayPicked.getTime())));
                    txvDays.setText(String.valueOf(days));
                    writer.flush();
                    writer.close();
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error while writting!", Toast.LENGTH_SHORT).show();
                }
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
