package com.aparnyuk.lessons_02;

import android.os.Bundle;
        import android.support.design.widget.NavigationView;
        import android.support.v4.view.GravityCompat;
        import android.support.v4.widget.DrawerLayout;
        import android.support.v7.app.ActionBarDrawerToggle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.Button;
        import android.widget.TextView;

public class ActivityFive extends AppCompatActivity implements  View.OnClickListener {
    TextView tv1, tv2;
    Button btn_blink, btn_bouce, btn_fade_in, btn_fade_out, btn_move, btn_rotate, btn_sequential,
            btn_slide_up, btn_slide_down, btn_together, btn_zoom_in, btn_zoom_out, btn_cross_fade ;
    Animation anima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        this.InitBtn();
    }

    private void InitBtn() {
        tv1 = (TextView) findViewById(R.id.animation_tv);
        tv2 = (TextView) findViewById(R.id.animation_tv2);
        tv1.setVisibility(View.INVISIBLE);

        btn_blink = (Button) findViewById(R.id.btn_blink);
        btn_bouce = (Button) findViewById(R.id.btn_bounce);
        btn_fade_in = (Button) findViewById(R.id.btn_fade_in);
        btn_fade_out = (Button) findViewById(R.id.btn_fade_out);
        btn_move = (Button) findViewById(R.id.btn_move);
        btn_rotate = (Button) findViewById(R.id.btn_rotate);
        btn_sequential = (Button) findViewById(R.id.btn_sequential);
        btn_slide_up = (Button) findViewById(R.id.btn_slide_up);
        btn_slide_down = (Button) findViewById(R.id.btn_slide_down);
        btn_together = (Button) findViewById(R.id.btn_together);
        btn_zoom_in = (Button) findViewById(R.id.btn_zoom_in);
        btn_zoom_out = (Button) findViewById(R.id.btn_zoom_out);
        btn_cross_fade = (Button) findViewById(R.id.btn_cross_fade);

        btn_blink.setOnClickListener(this);
        btn_bouce.setOnClickListener(this);
        btn_fade_in.setOnClickListener(this);
        btn_fade_out.setOnClickListener(this);
        btn_move.setOnClickListener(this);
        btn_rotate.setOnClickListener(this);
        btn_sequential.setOnClickListener(this);
        btn_slide_up.setOnClickListener(this);
        btn_slide_down.setOnClickListener(this);
        btn_together.setOnClickListener(this);
        btn_zoom_in.setOnClickListener(this);
        btn_zoom_out.setOnClickListener(this);
        btn_cross_fade.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        tv1.setVisibility(View.VISIBLE);
        switch (v.getId()) {
            case R.id.btn_blink:
                anima = AnimationUtils.loadAnimation(this, R.anim.blink);
                break;
            case R.id.btn_bounce:
                anima = AnimationUtils.loadAnimation(this, R.anim.bounce);
                break;
            case R.id.btn_cross_fade:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.VISIBLE);
                anima = AnimationUtils.loadAnimation(this,R.anim.fade_out);
                tv2.startAnimation(anima);
                anima = AnimationUtils.loadAnimation(this,R.anim.fade_in);
                break;
            case R.id.btn_fade_in:
                anima = AnimationUtils.loadAnimation(this, R.anim.fade_in);
                break;
            case R.id.btn_fade_out:
                anima = AnimationUtils.loadAnimation(this, R.anim.fade_out);
                break;
            case R.id.btn_move:
                anima = AnimationUtils.loadAnimation(this, R.anim.move);
                break;
            case R.id.btn_rotate:
                anima = AnimationUtils.loadAnimation(this, R.anim.rotate);
                break;
            case R.id.btn_sequential:
                anima = AnimationUtils.loadAnimation(this, R.anim.sequential);
                break;
            case R.id.btn_slide_down:
                anima = AnimationUtils.loadAnimation(this, R.anim.slide_down);
                break;
            case R.id.btn_slide_up:
                anima = AnimationUtils.loadAnimation(this, R.anim.slide_up);
                break;
            case R.id.btn_together:
                anima = AnimationUtils.loadAnimation(this, R.anim.together);
                tv1.setVisibility(View.INVISIBLE);
                break;
            case R.id.btn_zoom_in:
                anima = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
                break;
            case R.id.btn_zoom_out:
                anima = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
                break;

            default:
                break;
        }
        tv1.startAnimation(anima);
        tv1.setVisibility(View.INVISIBLE);
    }


}
