package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private MediaPlayer mMediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red","wetetti",R.drawable.color_red));
        words.add(new Word("mustard yellow","chiwiita",R.drawable.color_mustard_yellow));
        words.add(new Word("dusty yellow","topiisa",R.drawable.color_dusty_yellow));
        words.add(new Word("green","chokokki",R.drawable.color_green));
        words.add(new Word("brown","takaakki",R.drawable.color_brown));
        words.add(new Word("gray","topoppi",R.drawable.color_gray));
        words.add(new Word("black","kululli",R.drawable.color_black));
        words.add(new Word("white","kelilli",R.drawable.color_white));


        WordAdapter Adapter = new WordAdapter(this,words,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this,word.getAudioResourceId());
                mMediaPlayer.start();

            }
        });

    }

    private void releaseMediaPlayer()
    {
        if(mMediaPlayer!=null)
        {
            mMediaPlayer.release();
            mMediaPlayer=null;
        }
    }

}