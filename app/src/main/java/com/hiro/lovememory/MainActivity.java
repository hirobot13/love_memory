package com.hiro.lovememory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    ImageView imgvLock;
    ImageButton imgbtnExit, imgbtnBackSpace;
    TextView txvPassword;

    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.login);

        Initialize();
        ButtonClick();
        ImageButtonClick();
    }

    private void ButtonClick(){
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password += "0";
                txvPassword.setText(password);
                if (password.equals("2705")){
                    imgvLock.setImageResource(R.drawable.unlock);
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password += "1";
                txvPassword.setText(password);
                if (password.equals("2705")){
                    imgvLock.setImageResource(R.drawable.unlock);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password += "2";
                txvPassword.setText(password);
                if (password.equals("2705")){
                    imgvLock.setImageResource(R.drawable.unlock);
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password += "3";
                txvPassword.setText(password);
                if (password.equals("2705")){
                    imgvLock.setImageResource(R.drawable.unlock);
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password += "4";
                txvPassword.setText(password);
                if (password.equals("2705")){
                    imgvLock.setImageResource(R.drawable.unlock);
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password += "5";
                txvPassword.setText(password);
                if (password.equals("2705")){
                    imgvLock.setImageResource(R.drawable.unlock);
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password += "6";
                txvPassword.setText(password);
                if (password.equals("2705")){
                    imgvLock.setImageResource(R.drawable.unlock);
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password += "7";
                txvPassword.setText(password);
                if (password.equals("2705")){
                    imgvLock.setImageResource(R.drawable.unlock);
                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password += "8";
                txvPassword.setText(password);
                if (password.equals("2705")){
                    imgvLock.setImageResource(R.drawable.unlock);
                }
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password += "9";
                txvPassword.setText(password);
                if (password.equals("2705")){
                    imgvLock.setImageResource(R.drawable.unlock);
                }
            }
        });
    }

    private void ImageButtonClick(){
        imgbtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExitApp();
            }
        });

        imgbtnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.isEmpty() == false){
                    password = password.substring(0, password.length() - 1);
                    txvPassword.setText(password);
                }
            }
        });
    }

    private void Initialize(){
        imgvLock = findViewById(R.id.imgvLock);
        txvPassword = findViewById(R.id.txvPassword);
        //Buttons
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        //ImageButtons
        imgbtnExit = findViewById(R.id.imgbtnExit);
        imgbtnBackSpace = findViewById(R.id.imgbtnBackSpace);
    }

    private void ExitApp(){
        moveTaskToBack(true);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
