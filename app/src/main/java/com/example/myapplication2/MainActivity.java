package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name,CSCname;
    TextView nameLabel,CSCNameLabel;
    Button submit;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       nameLabel=findViewById(R.id.set_your_di);
       CSCNameLabel=findViewById(R.id.what_is_you);
        name=findViewById(R.id.editText);
        CSCname=findViewById(R.id.CSCname);
        submit=findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty())
                {
                    name.setError("Enter a name");
                    name.requestFocus();
                    return;
                }
                if(CSCname.getText().toString().trim().isEmpty())
                {
                    CSCname.setError("Enter a CSCname");
                    CSCname.requestFocus();
                    return;
                }
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("name", name.getText().toString().trim());
                i.putExtra("CSCname",CSCname.getText().toString().trim());
                startActivity(i);
            }
        });

    }
    public void closeKeyboard(View view)
    {

        if(view!=null)
        {
            InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

}

