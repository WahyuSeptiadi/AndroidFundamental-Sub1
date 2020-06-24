package com.wahyu.githubusers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private UserAdapter adapter;

    private User mUser;

    private String[] dataName, dataUsername, dataLocation, dataCompany;
    private String[] dataRepository, dataFollower, dataFollowing;
    private TypedArray dataAvatar;

    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        adapter = new UserAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){
                    case 0 :
                        sendData(0);
                        break;
                    case 1 :
                        sendData(1);
                        break;
                    case 2 :
                        sendData(2);
                        break;
                    case 3 :
                        sendData(3);
                        break;
                    case 4 :
                        sendData(4);
                        break;
                    case 5 :
                        sendData(5);
                        break;
                    case 6 :
                        sendData(6);
                        break;
                    case 7 :
                        sendData(7);
                        break;
                    case 8 :
                        sendData(8);
                        break;
                    case 9 :
                        sendData(9);
                        break;
                }
//                Toast.makeText(MainActivity.this, "nilai i = "+i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare() {
        dataAvatar = getResources().obtainTypedArray(R.array.avatar);
        dataName = getResources().getStringArray(R.array.name);
        dataCompany = getResources().getStringArray(R.array.company);
        dataLocation = getResources().getStringArray(R.array.location);
        dataUsername = getResources().getStringArray(R.array.username);
        dataRepository = getResources().getStringArray(R.array.repository);
        dataFollower = getResources().getStringArray(R.array.followers);
        dataFollowing = getResources().getStringArray(R.array.following);
    }

    private void addItem() {
        users = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            mUser = new User();
            mUser.setAvatar(dataAvatar.getResourceId(i, -1));
            mUser.setName(dataName[i]);
            mUser.setCompany(dataCompany[i]);
            mUser.setLocation(dataLocation[i]);
            mUser.setUsername(dataUsername[i]);
            mUser.setRepos(Integer.parseInt(dataRepository[i]));
            mUser.setFollower(Integer.parseInt(dataFollower[i]));
            mUser.setFollowing(Integer.parseInt(dataFollowing[i]));

            users.add(mUser);
        }
        adapter.setUsers(users);
    }

    private void sendData(int i){
        mUser = new User();
        mUser.setAvatar(users.get(i).getAvatar());
        mUser.setName(users.get(i).getName());
        mUser.setCompany(users.get(i).getCompany());
        mUser.setLocation(users.get(i).getLocation());
        mUser.setUsername(users.get(i).getUsername());
        mUser.setRepos(users.get(i).getRepos());
        mUser.setFollower(users.get(i).getFollower());
        mUser.setFollowing(users.get(i).getFollowing());

        Intent toDetail = new Intent(MainActivity.this, DetailActivity.class);
        toDetail.putExtra(DetailActivity.EXTRA_USER, mUser);
        startActivity(toDetail);

    }
}