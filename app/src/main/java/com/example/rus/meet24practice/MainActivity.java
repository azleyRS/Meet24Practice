package com.example.rus.meet24practice;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;
    Button button;
    ImageView imageView3;
    private AnimationDrawable animationDrawable;
    private Animation animation2;

    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    private ObjectAnimator objectAnimator;
    private int position = 1;
    private Scene sceneA;
    private Scene sceneB;
    private Scene sceneC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //drawable animantion
        imageView = findViewById(R.id.imageview);
        imageView.setBackgroundResource(R.drawable.animation);
        animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
        //base animation
        imageView2 = findViewById(R.id.imageview2);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.base);
        imageView2.startAnimation(animation);
        button = findViewById(R.id.start_animation_2_button);
        //base animation code version
        animation2 = new ScaleAnimation(0,
                1,
                0,
                1,
                100, 100);
        animation2.setDuration(3000);
        animation2.setInterpolator(new AccelerateInterpolator());
        imageView3 = findViewById(R.id.imageview3);
        imageView3.startAnimation(animation2);

        imageView4 = findViewById(R.id.valueanimatorimage1);
        imageView5 = findViewById(R.id.valueanimatorimage2);
        imageView6 = findViewById(R.id.valueanimatorimage3);
        imageView7 = findViewById(R.id.valueanimatorimage4);
        imageView8 = findViewById(R.id.valueanimatorimage5);

        final ValueAnimator accelerateInterpolator = ValueAnimator.ofInt(10,100);
        accelerateInterpolator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                imageView4.getLayoutParams().width = (int)accelerateInterpolator.getAnimatedValue();
                imageView4.getLayoutParams().height = (int)accelerateInterpolator.getAnimatedValue();

                imageView4.requestLayout();
            }
        });
        //accelerateInterpolator.setDuration(3000);
        accelerateInterpolator.setInterpolator(new AccelerateInterpolator());
        //accelerateInterpolator.start();

        final ValueAnimator decelerateInterpolator = ValueAnimator.ofInt(10,100);
        decelerateInterpolator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                imageView5.getLayoutParams().width = (int)decelerateInterpolator.getAnimatedValue();
                imageView5.getLayoutParams().height = (int)decelerateInterpolator.getAnimatedValue();
                imageView5.requestLayout();
            }
        });
        //decelerateInterpolator.setDuration(3000);
        decelerateInterpolator.setInterpolator(new DecelerateInterpolator());
       // decelerateInterpolator.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView2.startAnimation(animation);
                imageView3.startAnimation(animation2);
            accelerateInterpolator.start();
            decelerateInterpolator.start();}
        });

        final ValueAnimator accelerateDecelerateInterpolator = ValueAnimator.ofInt(10,100);
        accelerateDecelerateInterpolator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                imageView6.getLayoutParams().width = (int)accelerateDecelerateInterpolator.getAnimatedValue();
                imageView6.getLayoutParams().height = (int)accelerateDecelerateInterpolator.getAnimatedValue();
                imageView6.requestLayout();
            }
        });
        //accelerateDecelerateInterpolator.setDuration(3000);
        accelerateDecelerateInterpolator.setInterpolator(new AccelerateDecelerateInterpolator());
        //accelerateDecelerateInterpolator.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView2.startAnimation(animation);
                imageView3.startAnimation(animation2);
                accelerateInterpolator.start();
                decelerateInterpolator.start();
                accelerateDecelerateInterpolator.start();}
        });

        final ValueAnimator linearInterpolator = ValueAnimator.ofInt(10,100);
        linearInterpolator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                imageView7.getLayoutParams().width = (int)linearInterpolator.getAnimatedValue();
                imageView7.getLayoutParams().height = (int)linearInterpolator.getAnimatedValue();
                imageView7.requestLayout();
            }
        });
        //linearInterpolator.setDuration(3000);
        linearInterpolator.setInterpolator(new LinearInterpolator());
        //linearInterpolator.start();

        final ValueAnimator bounceInterpolator = ValueAnimator.ofInt(10,100);
        bounceInterpolator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                imageView8.getLayoutParams().width = (int)bounceInterpolator.getAnimatedValue();
                imageView8.getLayoutParams().height = (int)bounceInterpolator.getAnimatedValue();
                imageView8.requestLayout();
            }
        });
        //bounceInterpolator.setDuration(3000);
        bounceInterpolator.setInterpolator(new BounceInterpolator());
        //bounceInterpolator.start();


        //AnimatorSet
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(accelerateInterpolator);
        animatorSet.play(decelerateInterpolator);
        animatorSet.play(accelerateDecelerateInterpolator);
        animatorSet.play(linearInterpolator);
        animatorSet.play(bounceInterpolator);
        animatorSet.setDuration(3000);

        animatorSet.start();

        Button button2 = findViewById(R.id.objectanimator_button);
        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(button2,"x",500);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objectAnimator.start();
            }
        });


        //Transition Animation
        ViewGroup sceneRoot = (ViewGroup)findViewById(R.id.root_scene);
        sceneA = Scene.getSceneForLayout(sceneRoot, R.layout.scene_a,this);
        sceneB = Scene.getSceneForLayout(sceneRoot, R.layout.scene_b,this);
        sceneC = Scene.getSceneForLayout(sceneRoot, R.layout.scene_c,this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView2.startAnimation(animation);
                imageView3.startAnimation(animation2);
               animatorSet.start();}

        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        animationDrawable.stop();
    }
    public void goToB(View view){
        TransitionManager.go(sceneB);
    }
    public void goToA(View view){
        TransitionManager.go(sceneA);
    }
    public void goToC(View view){
        TransitionManager.go(sceneC);
    }
}
