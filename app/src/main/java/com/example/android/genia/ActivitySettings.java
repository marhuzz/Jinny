package com.example.android.genia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Marhuz on 22.09.2017.
 */

public class ActivitySettings extends AppCompatActivity {
    private EditText editTextSalary;
    private EditText editTextDream;
    private EditText editTextDreamPrice;
    private EditText editTextMunicipal;
    private EditText editTextSaveMoney;
    private int dreamPrice;
    private String dream;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button button = (Button) findViewById(R.id.button_next);
        editTextSalary = (EditText) findViewById(R.id.Salary);
        editTextDream = (EditText) findViewById(R.id.Dream);
        editTextDreamPrice = (EditText) findViewById(R.id.Dream_price);
        editTextMunicipal = (EditText) findViewById(R.id.MunicipalServices);
        editTextSaveMoney = (EditText) findViewById(R.id.Save_money);
    }

    public void onClickButtonNext(View view){
        if(checkForNumbers()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("salary",editTextSalary.getText().toString());
            intent.putExtra("municipal",editTextMunicipal.getText().toString());
            intent.putExtra("saveMoney",editTextSaveMoney.getText().toString());
            intent.putExtra("dreamPrice",editTextDreamPrice.getText().toString());
            startActivity(intent);
        }
    }

    public boolean checkForNumbers() {
        if (editTextSalary.getText().toString().equals("")) {
            editTextSalary.setHint("Введите ваш доход!");
            return false;
        }
        if (editTextMunicipal.getText().toString().equals("")) {
            editTextMunicipal.setHint("Введите вашу стоимость ЖКХ");
            return false;
        }
        if (editTextDream.getText().toString().equals("")) {
            editTextDream.setHint("Введите вашу мечту!");
            return false;
        }
        if (editTextDreamPrice.getText().toString().equals("")) {
            editTextDreamPrice.setHint("Введите стоимость мечты!");
            return false;
        }
        if (editTextSaveMoney.getText().toString().equals("")) {
            editTextSaveMoney.setHint("Введите количество откладываемых денег!");
            return false;
        }
        if (!editTextSalary.getText().toString().matches("\\d+")) {
            editTextSalary.setHint("Введите только цифры!");
            return false;
        }
        if (!editTextMunicipal.getText().toString().matches("\\d+")) {
            editTextMunicipal.setHint("Введите только цифры!");
            return false;
        }
        if (!editTextDreamPrice.getText().toString().matches("\\d+")) {
            editTextDreamPrice.setHint("Введите только цифры!");
            return false;
        }
        if (!editTextSaveMoney.getText().toString().matches("\\d+")) {
            editTextSaveMoney.setHint("Введите только цифры!");
            return false;
        } else return true;
    }

    public int getDreamPrice() {
        return dreamPrice;
    }

    public String getDream() {
        return dream;
    }
}
