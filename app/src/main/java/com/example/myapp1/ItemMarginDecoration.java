package com.example.myapp1;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class ItemMarginDecoration extends RecyclerView.ItemDecoration{
    private final int margin;

    public ItemMarginDecoration(int margin) {
        this.margin = margin;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = margin;
        outRect.left = margin;
        outRect.right = margin;

        // Add top margin only for the first item to avoid double margins between items
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = margin;
        } else {
            outRect.top = 0;
        }
    }

}
