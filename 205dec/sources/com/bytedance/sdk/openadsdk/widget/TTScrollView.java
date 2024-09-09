package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.a;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class TTScrollView extends ScrollView {

    /* renamed from: c  reason: collision with root package name */
    private int f36388c;
    private boolean sr;

    /* renamed from: w  reason: collision with root package name */
    private boolean f36389w;
    private c xv;

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface c {
        void c(boolean z3);
    }

    public TTScrollView(Context context) {
        super(context);
        this.f36389w = false;
        this.sr = false;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        if (this.f36389w) {
            return;
        }
        try {
            this.f36389w = true;
            View childAt = ((ViewGroup) getChildAt(0)).getChildAt(1);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = getHeight();
            childAt.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            a.f("TTScrollView", "onLayout error" + th.toString());
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i4, int i5, boolean z3, boolean z4) {
        super.onOverScrolled(i4, i5, z3, z4);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f36388c = getChildAt(0).getMeasuredHeight();
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.widget.TTScrollView.3
            @Override // java.lang.Runnable
            public void run() {
                TTScrollView tTScrollView = TTScrollView.this;
                tTScrollView.smoothScrollTo(0, tTScrollView.f36388c);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
        if (getScrollY() == 0) goto L9;
     */
    @Override // android.widget.ScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r1 = 1
            if (r0 != r1) goto L46
            int r0 = r4.getScrollY()
            int r2 = r4.f36388c
            if (r0 >= r2) goto L46
            int r0 = r4.getScrollY()
            int r2 = r4.f36388c
            int r2 = r2 / 2
            r3 = 0
            if (r0 <= r2) goto L24
            com.bytedance.sdk.openadsdk.widget.TTScrollView$1 r0 = new com.bytedance.sdk.openadsdk.widget.TTScrollView$1
            r0.<init>()
            r4.post(r0)
        L22:
            r1 = 0
            goto L39
        L24:
            int r0 = r4.getScrollY()
            if (r0 <= 0) goto L33
            com.bytedance.sdk.openadsdk.widget.TTScrollView$2 r0 = new com.bytedance.sdk.openadsdk.widget.TTScrollView$2
            r0.<init>()
            r4.post(r0)
            goto L39
        L33:
            int r0 = r4.getScrollY()
            if (r0 != 0) goto L22
        L39:
            com.bytedance.sdk.openadsdk.widget.TTScrollView$c r0 = r4.xv
            if (r0 == 0) goto L44
            boolean r2 = r4.sr
            if (r1 == r2) goto L44
            r0.c(r1)
        L44:
            r4.sr = r1
        L46:
            boolean r5 = super.onTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.widget.TTScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setListener(c cVar) {
        this.xv = cVar;
    }

    public boolean c() {
        return this.sr;
    }
}
