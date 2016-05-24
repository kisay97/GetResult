package com.estsoft.getresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CallerActivity extends AppCompatActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0){
            if (resultCode == Activity.RESULT_OK){
                int i = data.getIntExtra("data-int", -1);
                String s = data.getStringExtra("data-string");

                String result = "data-int : " + i + ", data-string : " + s;
                ((TextView)findViewById(R.id.result)).setText(result);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller);

        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CallerActivity.this, CalleeActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
