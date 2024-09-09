package com.bytedance.sdk.openadsdk.res.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class TTViewStub extends View {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<View> f36267c;
    private c sr;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.res.layout.c f36268w;
    private Context xv;

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface c {
        void c(TTViewStub tTViewStub, View view);
    }

    public TTViewStub(Context context, com.bytedance.sdk.openadsdk.res.layout.c cVar) {
        super(context);
        this.xv = context;
        this.f36268w = cVar;
        setVisibility(8);
    }

    public View c() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            com.bytedance.sdk.openadsdk.res.layout.c cVar = this.f36268w;
            if (cVar != null) {
                View c4 = cVar.c(this.xv);
                c(c4, (ViewGroup) parent);
                this.f36267c = new WeakReference<>(c4);
                c cVar2 = this.sr;
                if (cVar2 != null) {
                    cVar2.c(this, c4);
                }
                return c4;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(0, 0);
    }

    public void setOnInflateListener(c cVar) {
        this.sr = cVar;
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        WeakReference<View> weakReference = this.f36267c;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(i4);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i4);
        if (i4 == 0 || i4 == 4) {
            c();
        }
    }

    private void c(View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }
}
