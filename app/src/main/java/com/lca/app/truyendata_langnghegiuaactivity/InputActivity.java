package com.lca.app.truyendata_langnghegiuaactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {
    private EditText edtNumberA;
    private EditText edtNumberB;
    private Button btnStartActivityFResult;

    public static final String NUMBERA="NUMBERA";
    public static final String NUMBERB="NUMBERB";
    public static final int REQUEST_CODE= 2018;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        initWidget();
        setEvents();
    }

    private void initWidget() {
        edtNumberA= (EditText) findViewById(R.id.edt_number_A);
        edtNumberB= (EditText) findViewById(R.id.edt_number_B);
        btnStartActivityFResult= (Button) findViewById(R.id.btnStaAcFResult);
    }
    private void setEvents(){
        btnStartActivityFResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((!TextUtils.isEmpty(edtNumberA.getText().toString())) && (!TextUtils.isEmpty(edtNumberB.getText().toString()))){
                int numberA = Integer.parseInt(edtNumberA.getText().toString());
                int numberB = Integer.parseInt(edtNumberB.getText().toString());

                    Intent intent = new Intent(InputActivity.this,OutputActivity.class);
                    intent.putExtra(NUMBERA,numberA);
                    intent.putExtra(NUMBERB,numberB);
                    startActivityForResult(intent,REQUEST_CODE);
                }else{
                    Toast.makeText(InputActivity.this, "phai nhap day du", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE){
            switch (resultCode){
                case OutputActivity.RESULT_SET:
                    int result=data.getIntExtra(OutputActivity.RESULT,0);
                    Toast.makeText(this, result+"", Toast.LENGTH_SHORT).show();
                    break;
                case 2018:
//                    code code
                    default:
                        break;
            }
        }
    }
}
