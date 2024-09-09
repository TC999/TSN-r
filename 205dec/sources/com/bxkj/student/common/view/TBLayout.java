package com.bxkj.student.common.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TBLayout extends LinearLayout {
    public static final int SCREEN_FOOTER = 12;
    public static final int SCREEN_HEADER = 11;
    private OnPageChangedListener ctListener;
    private View mFooter;
    private View mHeader;
    private int mHeaderHeight;
    private int mLastInterceptY;
    private int mLastY;
    private int mTouchSlop;
    private OnPullListener pullListener;
    private int screen;
    private Scroller scroller;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface OnPageChangedListener {
        void onPageChanged(int stub);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface OnPullListener {
        boolean footerHeadReached(MotionEvent event);

        boolean headerFootReached(MotionEvent event);
    }

    @SuppressLint({"NewApi"})
    public TBLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mTouchSlop = 0;
        this.screen = 11;
        init();
    }

    private void init() {
        this.scroller = new Scroller(getContext());
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void initData() {
        this.mHeader = findViewById(2131232255);
        View findViewById = findViewById(2131232253);
        this.mFooter = findViewById;
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        int measuredHeight = this.mHeader.getMeasuredHeight();
        this.mHeaderHeight = measuredHeight;
        layoutParams.height = measuredHeight;
        this.mFooter.setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.scroller.computeScrollOffset()) {
            scrollTo(this.scroller.getCurrX(), this.scroller.getCurrY());
            postInvalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        OnPullListener onPullListener;
        int y3 = (int) ev.getY();
        int action = ev.getAction();
        if (action == 0) {
            this.mLastY = y3;
            this.mLastInterceptY = y3;
            return false;
        } else if (action == 1) {
            this.mLastInterceptY = 0;
            return false;
        } else if (action != 2) {
            return false;
        } else {
            int i4 = y3 - this.mLastInterceptY;
            int i5 = this.mTouchSlop;
            if (i4 > i5 && this.screen == 12) {
                OnPullListener onPullListener2 = this.pullListener;
                if (onPullListener2 == null || !onPullListener2.footerHeadReached(ev)) {
                    return false;
                }
            } else if (i4 >= (-i5) || this.screen != 11 || (onPullListener = this.pullListener) == null || !onPullListener.headerFootReached(ev)) {
                return false;
            }
            return true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int i4;
        int y3 = (int) event.getY();
        int action = event.getAction();
        if (action == 1) {
            int i5 = this.screen;
            if (i5 != 11) {
                i4 = i5 != 12 ? 0 : (this.mHeaderHeight * 3) / 4;
            } else {
                i4 = this.mHeaderHeight / 4;
            }
            int scrollY = getScrollY();
            if (scrollY > i4) {
                this.scroller.startScroll(0, scrollY, 0, this.mHeaderHeight - scrollY, 150);
                this.screen = 12;
                OnPageChangedListener onPageChangedListener = this.ctListener;
                if (onPageChangedListener != null) {
                    onPageChangedListener.onPageChanged(12);
                }
                postInvalidate();
            } else {
                this.scroller.startScroll(0, scrollY, 0, -scrollY, 150);
                this.screen = 11;
                OnPageChangedListener onPageChangedListener2 = this.ctListener;
                if (onPageChangedListener2 != null) {
                    onPageChangedListener2.onPageChanged(11);
                }
                postInvalidate();
            }
            this.mLastY = 0;
        } else if (action == 2) {
            int i6 = y3 - this.mLastY;
            int i7 = this.screen;
            if (i7 == 11) {
                int i8 = -i6;
                if (i8 < 0) {
                    i8 = 0;
                } else if (i8 > getHeight()) {
                    i8 = getHeight();
                }
                scrollTo(0, i8);
            } else if (i7 == 12 && i6 > 0) {
                scrollTo(0, this.mHeaderHeight - i6);
            }
        }
        return true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus && this.mHeader == null && this.mFooter == null) {
            initData();
        }
    }

    public void setOnContentChangeListener(OnPageChangedListener ler) {
        this.ctListener = ler;
    }

    public void setOnPullListener(OnPullListener listener) {
        this.pullListener = listener;
    }

    public TBLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mTouchSlop = 0;
        this.screen = 11;
        init();
    }

    public TBLayout(Context context) {
        super(context);
        this.mTouchSlop = 0;
        this.screen = 11;
        init();
    }
}
