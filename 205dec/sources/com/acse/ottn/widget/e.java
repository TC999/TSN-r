package com.acse.ottn.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class e extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private int f6969a;

    /* renamed from: b  reason: collision with root package name */
    private int f6970b;

    /* renamed from: c  reason: collision with root package name */
    private int f6971c;

    /* renamed from: d  reason: collision with root package name */
    private a f6972d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6973e;

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface a {
        void a(int i4);
    }

    public e(Context context) {
        this(context, null);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f6973e = false;
        this.f6971c = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @TargetApi(21)
    public e(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f6973e = false;
        this.f6971c = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        this.f6973e = getScrollY() > 300;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f6969a = (int) motionEvent.getRawX();
            this.f6970b = (int) motionEvent.getRawY();
        } else if (action == 2) {
            return Math.abs(((int) motionEvent.getRawY()) - this.f6970b) < 10;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setOnScrollListener(a aVar) {
        this.f6972d = aVar;
    }
}
