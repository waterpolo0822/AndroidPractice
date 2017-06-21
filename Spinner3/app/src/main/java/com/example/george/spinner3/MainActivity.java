package com.example.george.spinner3;

import android.content.Intent;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText song,singer,memo;
    RadioButton radioButton;
    Toolbar tool;
    Button tk,photo,device;
    Spinner spinner;
    String []array = {"IT","ENGLISH","INTERN","TEACHER"};
    String genre;
    String gender;
    RadioGroup radio;
    ImageView imageView;
    int b = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        song = (EditText)findViewById(R.id.song);
        singer = (EditText)findViewById(R.id.singer);
        memo = (EditText)findViewById(R.id.memo);
        spinner = (Spinner)findViewById(R.id.spinner);
        tool = (Toolbar)findViewById(R.id.toolbar);
        radio = (RadioGroup)findViewById(R.id.gender);
        imageView = (ImageView)findViewById(R.id.image);
        photo = (Button)findViewById(R.id.photo);
        device = (Button)findViewById(R.id.device);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getfile();
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(intent,1);
            }
        });


        setSupportActionBar(tool);

        ArrayAdapter<?> adapter = new ArrayAdapter<String>(this,R.layout.spinner_item,array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        tk = (Button)findViewById(R.id.ok);

        device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent,1001);
            }
        });




    }
    public File getfile(){
        File folder = new File("sdcard/camera_app");
        if (!folder.exists()){
            folder.mkdir();
        }
        File imagefile = new File(folder,b+"student.image.jpg");
        return imagefile;
    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        if (requestCode==1){
        String path = "sdcard/camera_app/"+b+"student.image.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));
        b++;}
        if (requestCode==1001&&resultCode==RESULT_OK){
            Uri uri = null;
            if (data != null){
                uri = data.getData();
                try {
                    Bitmap bitmap = getBimap(uri);
                    imageView.setImageBitmap(bitmap);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
    }
    public Bitmap getBimap(Uri uri)throws IOException{
        ParcelFileDescriptor parcelFileDescriptor = getContentResolver().openFileDescriptor(uri,"r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        genre = String.valueOf(parent.getItemAtPosition(position));
        tk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = radio.getCheckedRadioButtonId();
                radioButton = (RadioButton)findViewById(selected);
                gender = radioButton.getText().toString();
                String uta = song.getText().toString();
                String kash = singer.getText().toString();
                String me = memo.getText().toString();
                BitmapDrawable drawable = (BitmapDrawable)imageView.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,bos);
                final byte[] img = bos.toByteArray();
                DataBase helper = new DataBase(getApplicationContext());
                try {
                    helper.add(uta,kash,gender,genre,me,img);
                    Toast.makeText(MainActivity.this,"REGISTER SUCCESS",Toast.LENGTH_LONG).show();
                }
                catch (SQLException e){
                    Toast.makeText(MainActivity.this,"SOMETHING WRONG",Toast.LENGTH_LONG).show();
                }


            }
        });


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu:
                Intent m = new Intent(getApplicationContext(),Show.class);
                startActivity(m);
                break;
            case R.id.show:
                Intent intent = new Intent(getApplicationContext(),Test.class);
                startActivity(intent);
                break;
        }
        return true;
    }


}
