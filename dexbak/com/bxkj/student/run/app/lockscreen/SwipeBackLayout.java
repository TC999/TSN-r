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

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SwipeBackLayout extends FrameLayout {

    /* renamed from: a */
    private ViewDragHelper f19214a;

    /* renamed from: b */
    private View f19215b;

    /* renamed from: c */
    private InterfaceC5270c f19216c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.lockscreen.SwipeBackLayout$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5268a extends ViewDragHelper.Callback {
        C5268a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            if (SwipeBackLayout.this.f19215b.equals(child)) {
                return Math.min(Math.max(left, 0), SwipeBackLayout.this.getWidth());
            }
            return super.clampViewPositionHorizontal(child, left, dx);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View changedView, int left, int top2, int dx, int dy) {
            if (SwipeBackLayout.this.f19215b.equals(changedView)) {
                if (SwipeBackLayout.this.f19215b.getLeft() == SwipeBackLayout.this.getWidth() && SwipeBackLayout.this.f19216c != null) {
                    SwipeBackLayout.this.f19216c.onFinish();
                }
                SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
                swipeBackLayout.setBackgroundColor(Color.argb((int) (((swipeBackLayout.getWidth() - left) / SwipeBackLayout.this.getWidth()) * 160.0f), 0, 0, 0));
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            if (SwipeBackLayout.this.f19215b.equals(releasedChild)) {
                if (SwipeBackLayout.this.f19215b.getLeft() >= SwipeBackLayout.this.getWidth() / 3) {
                    SwipeBackLayout.this.f19214a.settleCapturedViewAt(SwipeBackLayout.this.getWidth(), SwipeBackLayout.this.getTop());
                } else {
                    SwipeBackLayout.this.f19214a.settleCapturedViewAt(0, SwipeBackLayout.this.getTop());
                }
                SwipeBackLayout.this.invalidate();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View child, int pointerId) {
            return SwipeBackLayout.this.f19215b.equals(child);
        }
    }

    /* renamed from: com.bxkj.student.run.app.lockscreen.SwipeBackLayout$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C5269b implements InterfaceC5270c {

        /* renamed from: a */
        private Activity f19218a;

        public C5269b(@NonNull Activity activity) {
            this.f19218a = activity;
        }

        @Override // com.bxkj.student.run.app.lockscreen.SwipeBackLayout.InterfaceC5270c
        public void onFinish() {
            this.f19218a.finish();
            this.f19218a.overridePendingTransition(0, 0);
        }
    }

    /* renamed from: com.bxkj.student.run.app.lockscreen.SwipeBackLayout$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC5270c {
        void onFinish();
    }

    public SwipeBackLayout(Context context) {
        super(context);
        m39948d();
    }

    /* renamed from: d */
    private void m39948d() {
        this.f19214a = ViewDragHelper.create(this, 1.0f, new C5268a());
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f19214a.continueSettling(true)) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            this.f19215b = childAt;
            if (childAt.getBackground() == null) {
                this.f19215b.setBackgroundColor(-1118482);
                return;
            }
            return;
        }
        throw new IllegalStateException("SwipeBackLayout must have only one child.");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.f19214a.shouldInterceptTouchEvent(ev);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent ev) {
        try {
            this.f19214a.processTouchEvent(ev);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public void setSwipeBackListener(InterfaceC5270c listener) {
        this.f19216c = listener;
    }

    public SwipeBackLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        m39948d();
    }

    public SwipeBackLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        m39948d();
    }

    @TargetApi(21)
    public SwipeBackLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        m39948d();
    }
}
