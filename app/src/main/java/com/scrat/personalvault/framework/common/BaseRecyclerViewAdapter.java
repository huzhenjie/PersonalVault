package com.scrat.personalvault.framework.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder> {

    protected final List<T> list;

    public BaseRecyclerViewAdapter() {
        list = new ArrayList<>();
    }

    protected abstract int getLayoutId(int viewType);

    @NonNull
    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return BaseRecyclerViewHolder.newInstance(parent, viewType, getLayoutId(viewType));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerViewHolder holder, int position) {
        T t = getItem(position);
        if (t != null) {
            onBindViewHolder(holder, position, t);
        }
    }

    protected void onBindViewHolder(BaseRecyclerViewHolder holder, int position, T t) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void replaceData(List<T> list) {
        this.list.clear();
        if (list != null) {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void appendData(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void appendData(T t) {
        if (t == null) {
            return;
        }

        list.add(t);
        notifyDataSetChanged();
    }

    public void insertData(int index, List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.list.addAll(index, list);
        notifyDataSetChanged();
    }

    public void insertData(int index, T t) {
        if (t == null) {
            return;
        }
        list.add(index, t);
        notifyDataSetChanged();
    }

    public T getItem(int pos) {
        return list.get(pos);
    }
}
