package com.wahyu.githubusers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wahyu_septiadi on 22, June 2020.
 * Visit My GitHub --> https://github.com/WahyuSeptiadi
 */

class UserAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<User> users = new ArrayList<>();

    UserAdapter(Context context) {
        this.context = context;
    }

    void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_users, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        //set Animation itemView
        Animation animation;
        animation = AnimationUtils.loadAnimation(context, R.anim.shake);
        animation.setDuration(200);
        itemView.startAnimation(animation);

        User user = (User) getItem(position);
        viewHolder.bind(user);

        return itemView;
    }

    private static class ViewHolder {
        private TextView txtName, txtCompany;
        private ImageView imgAvatar;
        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtCompany = view.findViewById(R.id.txt_company);
            imgAvatar = view.findViewById(R.id.img_avatar);
        }
        void bind(User user) {
            txtName.setText(user.getName());
            txtCompany.setText(user.getCompany());
            imgAvatar.setImageResource(user.getAvatar());
        }
    }
}
