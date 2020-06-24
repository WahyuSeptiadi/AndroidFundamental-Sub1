package com.wahyu.githubusers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "wahyu";
    CardView cv_Avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView btnBack = findViewById(R.id.btnBack);
        ImageView imgAvatar = findViewById(R.id.avatarValue);
        TextView txtName = findViewById(R.id.nameValue);
        TextView txtUsername = findViewById(R.id.usernameValue);
        TextView txtLocation = findViewById(R.id.locationValue);
        TextView txtCompany = findViewById(R.id.companyValue);
        TextView txtRepository = findViewById(R.id.repositoryValue);
        TextView txtFollower = findViewById(R.id.followerValue);
        TextView txtFollowing = findViewById(R.id.followingValue);

        cv_Avatar = findViewById(R.id.cardAvatar);
        CardView cv_Repository = findViewById(R.id.cardReposit);
        CardView cv_Followers = findViewById(R.id.cardFollower);
        CardView cv_Following = findViewById(R.id.cardFollowing);
        CardView cv_Privacy = findViewById(R.id.cardPrivacy);

        //getDataIntent With Object Parcelable
        User mUser = getIntent().getParcelableExtra(EXTRA_USER);

        //setData
        assert mUser != null;
        imgAvatar.setImageResource(mUser.getAvatar());
        txtName.setText(mUser.getName());
        txtUsername.setText(mUser.getUsername());
        txtLocation.setText(mUser.getLocation());
        txtCompany.setText(mUser.getCompany());
        txtRepository.setText(String.valueOf(mUser.getRepos()));
        txtFollower.setText(String.valueOf(mUser.getFollower()));
        txtFollowing.setText(String.valueOf(mUser.getFollowing()));

        //set Animation
        Animation fade_in1 = AnimationUtils.loadAnimation(DetailActivity.this, android.R.anim.fade_in);
        Animation fade_in2 = AnimationUtils.loadAnimation(DetailActivity.this, R.anim.down_to_up);
        Animation slide_left1 = AnimationUtils.loadAnimation(DetailActivity.this, android.R.anim.slide_in_left);
        Animation slide_left2 = AnimationUtils.loadAnimation(DetailActivity.this, android.R.anim.slide_in_left);
        Animation slide_left3 = AnimationUtils.loadAnimation(DetailActivity.this, android.R.anim.slide_in_left);


        fade_in1.setDuration(1000);
        fade_in2.setDuration(2000);
        slide_left1.setDuration(1000);
        slide_left2.setDuration(1500);
        slide_left3.setDuration(2000);

        imgAvatar.startAnimation(fade_in1);

        cv_Repository.startAnimation(slide_left1);
        cv_Followers.startAnimation(slide_left2);
        cv_Following.setAnimation(slide_left3);
        cv_Privacy.setAnimation(fade_in2);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToHome = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(backToHome);
                finish();
            }
        });
    }

    public void cardShake(View view) {
        Animation shake = AnimationUtils.loadAnimation(DetailActivity.this, R.anim.shake);
        cv_Avatar.startAnimation(shake);
    }
}