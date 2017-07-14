package com.example.kic.shesaid;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    private ColorWheel mColorWheel = new ColorWheel();
    //Declare View variables
    private TextView mFactTextView;
    private Button mShowQuoteButton;
    private ImageView mImageView;
    private FrameLayout mFrameLayout;
    private Typeface tf1, tf2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //Assign the views
        mFactTextView = (TextView) findViewById(R.id.quote_text_view);
        mImageView = (ImageView) findViewById(R.id.display_image);
        mShowQuoteButton = (Button) findViewById(R.id.next_quote_button);
        mFrameLayout = (FrameLayout) findViewById(R.id.frame_layout_main);

        tf1 = Typeface.createFromAsset(getAssets(), "DancingScript-Bold.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "DancingScript-Regular.ttf");

        mFactTextView.setTypeface(tf1);
        mShowQuoteButton.setTypeface(tf1);


        showRandomQuote();

        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String fact = mFactList.getFact();
                int color = mColorWheel.getColor();
                //Update view with random quote object
                showRandomQuote();
                mFrameLayout.setBackgroundColor(0xff000000);
                mShowQuoteButton.setTextColor(color);
            }
        };
        mShowQuoteButton.setOnClickListener(Listener);
    }

    public void showRandomQuote() {
        shuffleQuotes();
        //load the image
//        mImageView.setImageResource(quoteArray[0].getmImage());
            //load image with glide-def better performance dropping memory usage to consistent 11mb
          Glide.with(this)
                  .load(quoteArray[0].getmImage())
                  .into(mImageView);
        //load the quote
        mFactTextView.setText(quoteArray[0].getmQuote());
        //Fade in the text of the quote
        Animation fadeOut = new AlphaAnimation(0f, 1f);
        fadeOut.setDuration(4000);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        mFactTextView.startAnimation(fadeOut);

    }
    //Quote objects from xml
    Quote f01 = new Quote(R.drawable.aung1c, R.string.default_quote);
    Quote f02 = new Quote(R.drawable.aung2, R.string.aung2_quote);
    Quote f03 = new Quote(R.drawable.aung3, R.string.aung3_quote);
    Quote f04 = new Quote(R.drawable.maya_bird, R.string.maya1_quote);
    Quote f05 = new Quote(R.drawable.maya2, R.string.maya2_quote);
    Quote f06 = new Quote(R.drawable.amelia3a, R.string.amelia1_quote);
    Quote f07 = new Quote(R.drawable.amelia2, R.string.amelia2_quote);
    Quote f08 = new Quote(R.drawable.amelia1a, R.string.amelia3_quote);
    Quote f09 = new Quote(R.drawable.ada1a, R.string.ada1_quote);
    Quote f10 = new Quote(R.drawable.ada1a, R.string.ada2_quote);
    Quote f11 = new Quote(R.drawable.h3, R.string.helen1_quote);
    Quote f12 = new Quote(R.drawable.fountain, R.string.helen2_quote);
    Quote f13 = new Quote(R.drawable.fpss01, R.string.helen3_quote);
    Quote f14 = new Quote(R.drawable.h3, R.string.helen4_quote);
    Quote f15 = new Quote(R.drawable.fpss02, R.string.helen5_quote);
    Quote f16 = new Quote(R.drawable.me1, R.string.me1_quote);
    Quote f17 = new Quote(R.drawable.elanor1, R.string.elean1_quote);
    Quote f18 = new Quote(R.drawable.elanor2, R.string.elean2_quote);
    Quote f19 = new Quote(R.drawable.elanor3, R.string.elean3_quote);
    Quote f20 = new Quote(R.drawable.malala2, R.string.mala1_quote);
    Quote f21 = new Quote(R.drawable.juana_inez1, R.string.juana1_quote);
    Quote f22 = new Quote(R.drawable.pipeline, R.string.winona1_quote);


    Quote [] quoteArray = new Quote[] {
            f01, f02, f03, f04, f05, f06, f07, f08, f09, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22
    };

    public void shuffleQuotes() {
        Collections.shuffle(Arrays.asList(quoteArray));
    }
}
