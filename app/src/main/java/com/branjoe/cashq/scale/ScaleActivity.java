package com.branjoe.cashq.scale;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.branjoe.cashq.R;
import com.leochuan.ScrollHelper;
import com.leochuan.ViewPagerLayoutManager;

public abstract class ScaleActivity<V extends ViewPagerLayoutManager>
        extends AppCompatActivity {
    private RecyclerView recyclerView;
    private V viewPagerLayoutManager;

    protected abstract V createLayoutManager();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        setContentView(R.layout.activity_lock_screen);
        recyclerView = findViewById(R.id.recycler);
        viewPagerLayoutManager = createLayoutManager();
        Display display = getWindowManager().getDefaultDisplay();

        DataAdapter dataAdapter = new DataAdapter(this, display.getWidth());
        dataAdapter.setOnItemClickListener(new DataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Toast.makeText(v.getContext(), "go url:" + pos, Toast.LENGTH_SHORT).show();
                ScrollHelper.smoothScrollToTargetView(recyclerView, v);
            }
        });
        recyclerView.setAdapter(dataAdapter);
        recyclerView.setLayoutManager(viewPagerLayoutManager);
    }

    public V getViewPagerLayoutManager() {
        return viewPagerLayoutManager;
    }


    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}