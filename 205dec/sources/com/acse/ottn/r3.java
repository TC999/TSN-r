package com.acse.ottn;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class r3 extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    public int f6200a;

    /* renamed from: b  reason: collision with root package name */
    public int f6201b;

    /* renamed from: c  reason: collision with root package name */
    public int f6202c;

    /* renamed from: d  reason: collision with root package name */
    public a f6203d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6204e;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface a {
        void a(int i4);
    }

    public r3(Context context) {
        this(context, null);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (getScrollY() > 300) {
            this.f6204e = true;
        } else {
            this.f6204e = false;
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f6200a = (int) motionEvent.getRawX();
            this.f6201b = (int) motionEvent.getRawY();
        } else if (action == 2) {
            return Math.abs(((int) motionEvent.getRawY()) - this.f6201b) < 10;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setOnScrollListener(a aVar) {
        this.f6203d = aVar;
    }

    public r3(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public r3(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f6204e = false;
        this.f6202c = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @TargetApi(21)
    public r3(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f6204e = false;
        this.f6202c = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
