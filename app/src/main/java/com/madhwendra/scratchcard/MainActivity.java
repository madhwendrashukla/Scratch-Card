package com.madhwendra.scratchcard;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.anupkumarpanwar.scratchview.ScratchView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScratchView scratchView = findViewById(R.id.scratch_view);
        scratchView.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                scratchView.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "Coupon Unlocked", Toast.LENGTH_LONG).show();
                ;
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
                if (percent >= 0.5) {
                    Log.d("Reveal Percentage", "onRevealPercentChangedListener: " + String.valueOf(percent));
                }
            }
        });

    }
}