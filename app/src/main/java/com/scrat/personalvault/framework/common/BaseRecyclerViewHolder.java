package com.scrat.personalvault.framework.common;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {
    public static BaseRecyclerViewHolder newInstance(ViewDataBinding binding) {
        return new BaseRecyclerViewHolder(binding);
    }

    public static BaseRecyclerViewHolder newInstance(ViewGroup parent, int viewType, int layoutId) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        return new BaseRecyclerViewHolder(binding);
    }

    private ViewDataBinding binding;

    public BaseRecyclerViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(int variableId, Object obj) {
        binding.setVariable(variableId, obj);
        binding.executePendingBindings();
    }

    public ViewDataBinding getBinding() {
        return binding;
    }
}
