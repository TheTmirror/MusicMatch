package com.mocoteam1.musicmatch;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import static java.lang.Math.abs;

public class ShareSong extends AppCompatActivity {

    private static final String TAG = ShareSong.class.getSimpleName();
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_song);
        setSongInformations();

        Button shareButton = (Button) findViewById(R.id.shareSongShareButton);
        ConstraintLayout content = (ConstraintLayout) findViewById(R.id.shareSongContent);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShareSong.this, VoteSong.class);
                startActivity(i);
            }
        });

        mDetector = new GestureDetectorCompat(this, new GestureListener(this));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private void setSongInformations() {
        Log.d(TAG, "Spotify API wird angesprochen");
        Log.d(TAG, "Spotify Informationen werden bezogen");
        Log.d(TAG, "Textfelder werden gefüllt");
        Log.d(TAG, "Setzen der Felder erfolgreich");
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private final String DEBUG_TAG = GestureListener.class.getSimpleName();
        private Context context;

        public GestureListener(Context context) {
            this.context = context;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            Log.d(DEBUG_TAG, "onDown wurde ausgeführt: " + e.toString());
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d(DEBUG_TAG, "x: " + velocityX + " y: " + velocityY);
            if(abs(velocityX) > abs(velocityY))
                if(velocityX < 0) {
                    Intent i = new Intent(context, VoteSong.class);
                    startActivity(i);
                }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

}
