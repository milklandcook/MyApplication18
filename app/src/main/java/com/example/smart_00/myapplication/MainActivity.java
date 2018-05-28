package com.example.smart_00.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rGroup;
    RadioButton rdoDog, rdoCat, rdoRabbit, rdoHorse;
    Button btnImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("직접해보기");
        rGroup = (RadioGroup) findViewById(R.id.rGroup);
        rdoDog = (RadioButton) findViewById(R.id.rdoDog);
        rdoCat = (RadioButton) findViewById(R.id.rdoCat);
        rdoRabbit = (RadioButton) findViewById(R.id.rdoRabbit);
        rdoHorse = (RadioButton) findViewById(R.id.rdoHorse);
        btnImage = (Button) findViewById(R.id.btnImage);

        final Integer[] radioID = { R.id.rdoDog, R.id.rdoCat, R.id.rdoRabbit, R.id.rdoHorse };
        final Integer[] petID = { R.drawable.dog, R.drawable.cat, R.drawable.rabbit, R.drawable.horse };

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = rGroup.getCheckedRadioButtonId();
                View dialogView = (View) View.inflate(MainActivity.this,R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                ImageView ivePet = (ImageView) dialogView.findViewById(R.id.ivPet);

                switch (rGroup.getCheckedRadioButtonId()) {
                    case R.id.rdoDog:
                        ivePet.setImageResource(petID[0]);
                        dlg.setTitle("강아지");
                        break;
                    case R.id.rdoCat:
                        ivePet.setImageResource(petID[1]);
                        dlg.setTitle("고양이");
                        break;
                    case R.id.rdoRabbit:
                        ivePet.setImageResource(petID[2]);
                        dlg.setTitle("토끼");
                        break;
                    case R.id.rdoHorse:
                        ivePet.setImageResource(petID[3]);
                        dlg.setTitle("말");
                        break;

                }

                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();

            }
        });






    }
}
