package com.bxkj.student.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ObservableHorizontalScrollView extends HorizontalScrollView {
    private ScrollViewListener scrollViewListener;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface ScrollViewListener {
        void onScrollChanged(ObservableHorizontalScrollView scrollView, int x3, int y3, int oldx, int oldy);
    }

    public ObservableHorizontalScrollView(Context context) {
        super(context);
        this.scrollViewListener = null;
    }

    @Override // android.view.View
    protected void onScrollChanged(int x3, int y3, int oldx, int oldy) {
        super.onScrollChanged(x3, y3, oldx, oldy);
        ScrollViewListener scrollViewListener = this.scrollViewListener;
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, x3, y3, oldx, oldy);
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
