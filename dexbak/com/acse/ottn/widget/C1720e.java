package com.acse.ottn.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/* renamed from: com.acse.ottn.widget.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1720e extends ScrollView {

    /* renamed from: a */
    private int f3422a;

    /* renamed from: b */
    private int f3423b;

    /* renamed from: c */
    private int f3424c;

    /* renamed from: d */
    private InterfaceC1721a f3425d;

    /* renamed from: e */
    private boolean f3426e;

    /* renamed from: com.acse.ottn.widget.e$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1721a {
        /* renamed from: a */
        void m55844a(int i);
    }

    public C1720e(Context context) {
        this(context, null);
    }

    public C1720e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1720e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3426e = false;
        this.f3424c = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @TargetApi(21)
    public C1720e(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3426e = false;
        this.f3424c = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        this.f3426e = getScrollY() > 300;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f3422a = (int) motionEvent.getRawX();
            this.f3423b = (int) motionEvent.getRawY();
        } else if (action == 2) {
            return Math.abs(((int) motionEvent.getRawY()) - this.f3423b) < 10;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setOnScrollListener(InterfaceC1721a interfaceC1721a) {
        this.f3425d = interfaceC1721a;
    }
}
