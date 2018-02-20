package com.k.amulyacare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;



public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private ViewFlipper mViewFlipper;
    private Context mContext;

    TextView tv_specialities;
    ImageView iv1,iv2;
    private final GestureDetector detector = new GestureDetector(new Home.SwipeGestureDetector());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tv_specialities=(TextView)findViewById(R.id.specialities);
        iv1=(ImageView)findViewById(R.id.image_1);
        iv2=(ImageView)findViewById(R.id.image_2);
        mContext = this;
        mViewFlipper = (ViewFlipper) this.findViewById(R.id.view_flipper);
        mViewFlipper.setAutoStart(true);
        mViewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });


        tv_specialities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Home.this,Specialities.class);
                startActivity(i);

            }
        });

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Home.this,Treatment.class);
                startActivity(i);


            }
        });

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Home.this,Treatment.class);
                startActivity(i);


            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent it=new Intent(Home.this,Home.class);
            startActivity(it);
            // Handle the camera action
        } else if (id == R.id.nav_aboutus) {
            Intent it=new Intent(Home.this,Aboutus.class);
            startActivity(it);

        } else if (id == R.id.nav_services) {
            Intent it=new Intent(Home.this,Services.class);
            startActivity(it);

        } else if (id == R.id.nav_treatments) {
            Intent it=new Intent(Home.this,Treatment.class);
            startActivity(it);

        } else if (id == R.id.nav_contact) {

            Intent i=new Intent(Home.this,ContactUs.class);
            startActivity(i);


        } else if (id == R.id.nav_consult) {
            Intent it=new Intent(this,Onlineconsultation.class);
            startActivity(it);

        }
        else if (id == R.id.nav_share) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
               // sendIntent.putExtra(Intent.EXTRA_TEXT, p.getName());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void ourSpec(View view) {
        Intent it=new Intent(this,Specialities.class);

        if(view.getId()==R.id.obesity)
        {
            it.putExtra("pos",0);

        }
        else
        if(view.getId()==R.id.stress)
        {
            it.putExtra("pos",1);
        }
        else
        if(view.getId()==R.id.back_pain)
        {
            it.putExtra("pos",2);
        }
        else
        if(view.getId()==R.id.cervical_pain)
        {
            it.putExtra("pos",3);
        }
        else
        if(view.getId()==R.id.arthritis)
        {
            it.putExtra("pos",4);
        } else
        if(view.getId()==R.id.paralysis)
        {
            it.putExtra("pos",5);
        }
        else
        if(view.getId()==R.id.piles)
        {
            it.putExtra("pos",6);
        }


        startActivity(it);

    }

    class SwipeGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                // right to left swipe
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_in));
                    mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_out));
                    mViewFlipper.showNext();
                    return true;
                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.right_in));
                    mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext,R.anim.right_out));
                    mViewFlipper.showPrevious();
                    return true;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }
    }

}
