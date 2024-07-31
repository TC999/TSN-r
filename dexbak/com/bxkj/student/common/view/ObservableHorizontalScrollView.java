package com.bxkj.student.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ObservableHorizontalScrollView extends HorizontalScrollView {
    private ScrollViewListener scrollViewListener;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface ScrollViewListener {
        void onScrollChanged(ObservableHorizontalScrollView scrollView, int x, int y, int oldx, int oldy);
    }

    public ObservableHorizontalScrollView(Context context) {
        super(context);
        this.scrollViewListener = null;
    }

    @Override // android.view.View
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        ScrollViewListener scrollViewListener = this.scrollViewListener;
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
        }
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.scrollViewListener = null;
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.scrollViewListener = null;
    }
}
