package com.scrat.personalvault;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;

import com.scrat.lib.databinding.SingleLineItemLeftIconBinding;
import com.scrat.lib.framework.BaseActivity;
import com.scrat.personalvault.data.storage.PwdInfo;
import com.scrat.personalvault.databinding.ActivityMainBinding;
import com.scrat.personalvault.framework.common.BaseRecyclerViewAdapter;
import com.scrat.personalvault.framework.common.BaseRecyclerViewHolder;

import java.util.Arrays;

public class MainActivity extends BaseActivity {

    public static void show(Context context) {
        Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }

    private Adapter adapter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        adapter = new Adapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.content.list.setLayoutManager(layoutManager);
        binding.content.list.setAdapter(adapter);
        adapter.replaceData(Arrays.asList(
                new PwdInfo().setTitle("title").setPassword("pwd"),
                new PwdInfo().setTitle("title").setPassword("pwd")
        ));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

    private static class Adapter extends BaseRecyclerViewAdapter<PwdInfo> {

        @Override
        protected int getLayoutId(int viewType) {
            return R.layout.single_line_item_left_icon;
        }

        @Override
        protected void onBindViewHolder(BaseRecyclerViewHolder holder, int position, PwdInfo pwdInfo) {
            SingleLineItemLeftIconBinding binding = (SingleLineItemLeftIconBinding) holder.getBinding();
            binding.itemTitle.setText(pwdInfo.getTitle());
        }
    }
}
