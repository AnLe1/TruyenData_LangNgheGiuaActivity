package com.lca.app.truyendata_langnghegiuaactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {
    private TextView tvNumberA;
    private TextView tvNumberB;
    private Button btnResult;
    private int numberA;
    private int numberB;
    public static final String RESULT="RESULT";
    public static final int RESULT_SET= 20189;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        initWidget();
        getData();
        setEvents();
    }

    private void setEvents() {
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = numberA+numberB;
                Intent intent = new Intent();
                intent.putExtra(RESULT,result);
                setResult(RESULT_SET,intent);
                finish();
            }
        });
    }

    private void getData() {
        Intent intent = getIntent();
        numberA = intent.getIntExtra(InputActivity.NUMBERA,0);
        numberB = intent.getIntExtra(InputActivity.NUMBERB,0);
        tvNumberA.setText(numberA+"");
        tvNumberB.setText(numberB+"");
    }

    private void initWidget() {
        tvNumberA= (TextView) findViewById(R.id.tv_number_A);
        tvNumberB= (TextView) findViewById(R.id.tv_number_B);
        btnResult= (Button) findViewById(R.id.btnResult);
    }


}
