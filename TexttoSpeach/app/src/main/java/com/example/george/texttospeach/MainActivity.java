package com.example.george.texttospeach;

import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {
    private int result = 0;
    private TextToSpeech tts;
    Button go;
    EditText user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(this,this);
        go = (Button)findViewById(R.id.go);
        user = (EditText)findViewById(R.id.in);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut();
            }
        });
    }
    @Override
    public void onDestroy()
    {
        if (tts != null){
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();

    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS){
            result = tts.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(this,"Missing data",Toast.LENGTH_LONG).show();
                go.setEnabled(false);
            }else{
                go.setEnabled(true);
            }
        }
        else{
            Log.e("TTS", "Intialization fail");
        }
    }
    private void speakOut(){
        String text = user.getText().toString();
        if (result != tts.setLanguage(Locale.US)){
            Toast.makeText(getApplicationContext(),"Enter right word",Toast.LENGTH_LONG).show();
        }else
        {
            tts.speak(text,TextToSpeech.QUEUE_FLUSH,null);
        }
    }
}
