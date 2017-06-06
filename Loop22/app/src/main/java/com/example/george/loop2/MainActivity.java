package com.example.george.loop2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.TintContextWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv1,tv2,tv3;
    EditText et1,et2;
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        bt1=(Button)findViewById(R.id.bt1);
        bt2=(Button)findViewById(R.id.bt2);
        bt3=(Button)findViewById(R.id.bt3);
        bt4=(Button)findViewById(R.id.bt4);
        bt5=(Button)findViewById(R.id.bt5);
        bt6=(Button)findViewById(R.id.bt6);
        bt7=(Button)findViewById(R.id.bt7);
        bt8=(Button)findViewById(R.id.bt8);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int a=Integer.parseInt(et1.getText().toString());
        int b=Integer.parseInt(et2.getText().toString());
       for (int c=1;c<=b;c++)
       {
           switch (v.getId())
           {
               case R.id.bt2:
               {
                   for (int d=1;d<=a;d++)
                   {
                       for (int e=1;e<=d;e++)
                       {
                           tv3.append("*");
                       }
                       tv3.append("\n");
                   }
               }break;
               case R.id.bt3:
               {
                   for (int f=a;f>=1;f--)
                   {
                       for (int g=f;g>1;g--)
                       {
                           tv3.append(" ");
                       }
                       for (int h=a;h>=f;h--)
                       {
                           tv3.append("*");
                       }
                       tv3.append("\n");
                   }
               }break;
               case R.id.bt1:
               {
                   for (int i=1;i<=a;i++)
                   {
                       for(int j=i;j<a;j++)
                       {
                           tv3.append(" ");
                       }
                       for (int k=1;k<=i;k++)
                       {
                           tv3.append("*");
                       }
                       for (int l=1;l<i;l++)
                       {
                           tv3.append("*");
                       }
                       tv3.append("\n");
                   }
               }break;
               case R.id.bt5:
               {
                   for (int m=a;m>=1;m--)
                   {
                       for (int n=1;n<=m;n++)
                       {
                           tv3.append("*");
                       }
                       tv3.append("\n");
                   }
               }break;
               case R.id.bt6:
               {
                   for (int o=1;o<=a;o++)
                   {
                       for(int p=1;p<o;p++)
                       {
                           tv3.append(" ");
                       }
                       for (int q=a;q>=o;q--)
                       {
                           tv3.append("*");
                       }
                       tv3.append("\n");
                   }
               }break;
               case R.id.bt4:
               {
                   for (int r=1;r<=a;r++)
                   {
                       for(int s=1;s<r;s++)
                       {
                           tv3.append(" ");
                       }
                       for(int t=a;t>=r;t--)
                       {
                           tv3.append("*");
                       }
                       for(int u=a;u>r;u--)
                       {
                           tv3.append("*");
                       }
                       tv3.append("\n");
                   }
               }break;
               case R.id.bt7:
               {
                   if (a%2==0)
                   {
                       Toast.makeText(this,"input odd",Toast.LENGTH_SHORT).show();
                   }
                   else {
                       for (int x = 1; x <= a; x++) {
                           if (x <= a / 2 + 1) {
                               for (int n = x; n < a / 2 + 1; n++) {
                                   tv3.append(" ");
                               }
                               for (int t = 1; t <= x; t++) {
                                   tv3.append("*");
                               }
                               for (int s = 1; s < x; s++) {
                                   tv3.append("*");
                               }

                           } else {
                               for (int n = a / 2 + 1; n < x; n++) {
                                   tv3.append(" ");
                               }
                               for (int m = x; m <= a; m++) {
                                   tv3.append("*");
                               }
                               for (int t = x; t < a; t++) {
                                   tv3.append("*");
                               }
                           }
                           tv3.append("\n");


                       }
                   }
               }break;
               case R.id.bt8:
               {
                   if (a%2==1)
                   {
                       Toast.makeText(this,"put even",Toast.LENGTH_SHORT).show();
                   }
                   else {
                       for (int d = 1; d <= a; d++) {
                           if (d <= a / 2) {
                               for (int e = a / 2; e >= d; e--) {
                                   tv3.append("*");
                               }
                               for (int f = 1; f < d; f++) {
                                   tv3.append(" ");
                               }
                               for (int g = 1; g < d; g++) {
                                   tv3.append("  ");
                               }
                               for (int h = a / 2; h >= d; h--) {
                                   tv3.append("*");
                               }
                           } else {
                               for (int i = a / 2; i < d; i++) {
                                   tv3.append("*");
                               }
                               for (int j = a; j > d; j--) {
                                   tv3.append(" ");
                               }
                               for (int k = a; k > d; k--) {
                                   tv3.append("  ");
                               }
                               for (int l = a / 2; l < d; l++) {
                                   tv3.append("*");
                               }
                           }
                           tv3.append("\n");
                       }
                   }

               }


           }
       }

    }
}
