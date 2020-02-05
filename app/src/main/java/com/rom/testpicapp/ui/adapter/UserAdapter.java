package com.rom.testpicapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rom.testpicapp.R;
import com.rom.testpicapp.net.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<User> items = new ArrayList<>();

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        if (items.isEmpty()) {
            return;
        }

        holder.bindTo(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void update(List<User> items) {
        this.items = items;
        notifyDataSetChanged();
    }

}