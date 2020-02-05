package com.rom.testpicapp.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rom.testpicapp.R;
import com.rom.testpicapp.net.model.User;

public class UserViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivAvatar;

    private TextView tvUserName;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        ivAvatar = itemView.findViewById(R.id.iv_avatar);
        tvUserName = itemView.findViewById(R.id.tv_user_name);
    }

    public void bindTo(@NonNull User data) {
        Glide.with(itemView.getContext())
                .load(data.getAvatarUrl())
                .into(ivAvatar);

        tvUserName.setText(data.getLogin());
    }

}