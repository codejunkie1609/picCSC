package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements  StatesAndDistricts{
    private Spinner state,dist;
    private Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        state=findViewById(R.id.state);
        dist=findViewById(R.id.dist);
        go=findViewById(R.id.button2);
        ArrayAdapter a1=new ArrayAdapter(this,android.R.layout.simple_spinner_item,statesList);
        a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(a1);
        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setSpinner(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(state.getSelectedItem().toString().equals("State/UT"))
                {
                    Toast.makeText(getApplicationContext(),"select a state",Toast.LENGTH_SHORT).show();

                }
                else {
                    startActivity(new Intent(getApplicationContext(),CaptureImage.class));
                }
            }
        });
    }

    private void setSpinner(int i) {
         if(i==1) {
            ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,AP );
            a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dist.setAdapter(a2);
        }
         else if(i==2) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ArP );
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==3) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Assam );
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==4) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Bihar );
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==5) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Chattisgarh);
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==6) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Goa );
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==7) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Gujarat);
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==8) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Haryana );
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==9) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,HP );
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==10) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Jharkhand );
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==11) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Karnataka );
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==12) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Kerala );
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==13) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,MP );
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==14) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Maha);
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==15) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Manipur );
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==16) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Meghalaya );
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==17) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Mizoram);
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==18) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Nagaland);
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }
         else if(i==19) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Odisha );
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);}
            else if(i==20) {
                 ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Punjab );
                 a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 dist.setAdapter(a2);
             }
             else if(i==21) {
                 ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Rajasthan);
                 a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 dist.setAdapter(a2);
             }
             else if(i==22) {
                 ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Sikkim);
                 a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 dist.setAdapter(a2);
             }
             else if(i==23) {
                 ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,TamilNadu );
                 a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 dist.setAdapter(a2);
             }
             else if(i==24) {
                 ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Telangana);
                 a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 dist.setAdapter(a2);
             }
             else if(i==25) {
                 ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Tripura );
                 a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 dist.setAdapter(a2);
             }
             else if(i==26) {
                 ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,UK );
                 a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 dist.setAdapter(a2);
             }
             else if(i==27) {
                 ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,UP );
                 a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 dist.setAdapter(a2);
             }
             else if(i==28) {
                 ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,WB );
                 a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 dist.setAdapter(a2);
             }
             else if(i==29) {
                 ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Andaman );
                 a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 dist.setAdapter(a2);
             }
             else if(i==30) {
                 ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Chandigarh );
                 a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 dist.setAdapter(a2);
             }
             else if(i==31) {
                 ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,DDNH );
                 a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 dist.setAdapter(a2);
             }
             else if(i==32) {
                 ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,DamanAndDiu );
                 a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 dist.setAdapter(a2);
             }
             else if(i==33) {
                 ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Delhi);
                 a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 dist.setAdapter(a2);
             }
             else if(i==34) {
                 ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,JK );
                 a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 dist.setAdapter(a2);
             }
             else if(i==35) {
                 ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Ladakh );
                 a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 dist.setAdapter(a2);
             }
         else if(i==36) {
             ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Puducherry);
             a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             dist.setAdapter(a2);
         }

         }



    }
