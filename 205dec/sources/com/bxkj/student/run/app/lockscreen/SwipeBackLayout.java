package com.bxkj.student.run.app.lockscreen;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.customview.widget.ViewDragHelper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SwipeBackLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewDragHelper f22451a;

    /* renamed from: b  reason: collision with root package name */
    private View f22452b;

    /* renamed from: c  reason: collision with root package name */
    private c f22453c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends ViewDragHelper.Callback {
        a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            if (SwipeBackLayout.this.f22452b.equals(child)) {
                return Math.min(Math.max(left, 0), SwipeBackLayout.this.getWidth());
            }
            return super.clampViewPositionHorizontal(child, left, dx);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View changedView, int left, int top2, int dx, int dy) {
            if (SwipeBackLayout.this.f22452b.equals(changedView)) {
                if (SwipeBackLayout.this.f22452b.getLeft() == SwipeBackLayout.this.getWidth() && SwipeBackLayout.this.f22453c != null) {
                    SwipeBackLayout.this.f22453c.onFinish();
                }
                SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
                swipeBackLayout.setBackgroundColor(Color.argb((int) (((swipeBackLayout.getWidth() - left) / SwipeBackLayout.this.getWidth()) * 160.0f), 0, 0, 0));
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            if (SwipeBackLayout.this.f22452b.equals(releasedChild)) {
                if (SwipeBackLayout.this.f22452b.getLeft() >= SwipeBackLayout.this.getWidth() / 3) {
                    SwipeBackLayout.this.f22451a.settleCapturedViewAt(SwipeBackLayout.this.getWidth(), SwipeBackLayout.this.getTop());
                } else {
                    SwipeBackLayout.this.f22451a.settleCapturedViewAt(0, SwipeBackLayout.this.getTop());
                }
                SwipeBackLayout.this.invalidate();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View child, int pointerId) {
            return SwipeBackLayout.this.f22452b.equals(child);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private Activity f22455a;

        public b(@NonNull Activity activity) {
            this.f22455a = activity;
        }

        @Override // com.bxkj.student.run.app.lockscreen.SwipeBackLayout.c
        public void onFinish() {
            this.f22455a.finish();
            this.f22455a.overridePendingTransition(0, 0);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface c {
        void onFinish();
    }

    public SwipeBackLayout(Context context) {
        super(context);
        d();
    }

    private void d() {
        this.f22451a = ViewDragHelper.create(this, 1.0f, new a());
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f22451a.continueSettling(true)) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            this.f22452b = childAt;
            if (childAt.getBackground() == null) {
                this.f22452b.setBackgroundColor(-1118482);
                return;
            }
            return;
        }
        throw new IllegalStateException("SwipeBackLayout must have only one child.");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.f22451a.shouldInterceptTouchEvent(ev);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent ev) {
        try {
            this.f22451a.processTouchEvent(ev);
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return true;
        }
    }

    public void setSwipeBackListener(c listener) {
        this.f22453c = listener;
    }

    public SwipeBackLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        d();
    }

    public SwipeBackLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        d();
    }

    @TargetApi(21)
    public SwipeBackLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        d();
    }
}
