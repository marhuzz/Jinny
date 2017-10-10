package com.example.android.genia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";
    private TextView textViewExpenseInWeek;
    private TextView textViewExpenseInDay;
    private TextView textViewActualExpenseInDay;
    private TextView textViewActualExpenseInWeek;
    View progressBar;
    String salary;
    String municipal;
    String saveMoney;
    String dreamPrice;
    String dream;
    Wast wast;
    private ActivitySettings activitySettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_osnova);
        progressBar = (ProgressBar) findViewById(R.id.progress_dream);
        textViewExpenseInDay = (TextView) findViewById(R.id.expense_in_day);
        textViewExpenseInWeek = (TextView) findViewById(R.id.expense_in_week);
        textViewActualExpenseInDay = (TextView) findViewById(R.id.actual_expense_in_day);
        textViewActualExpenseInWeek =(TextView) findViewById(R.id.actual_expense_in_week);
        salary = getIntent().getStringExtra("salary");
        municipal = getIntent().getStringExtra("municipal");
        saveMoney = getIntent().getStringExtra("saveMoney");
        dreamPrice = getIntent().getStringExtra("dreamPrice");
        if(salary != null && municipal != null && saveMoney != null) {
            wast = new Wast(Integer.parseInt(salary), Integer.parseInt(municipal), Integer.parseInt(saveMoney));
            textViewExpenseInDay.setText(wast.recommendedWastADay() + "");
            textViewExpenseInWeek.setText(wast.recommendedWastAWeek() + "");
            textViewActualExpenseInDay.setText(wast.actualWastADay() + "");
            textViewActualExpenseInWeek.setText(wast.actualWastAWeek() + "");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.action_settings:
                Intent intent = new Intent(this,ActivitySettings.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void postProgress(int progress){
        String strProgress = String.valueOf(progress) + " %";
    }
}
