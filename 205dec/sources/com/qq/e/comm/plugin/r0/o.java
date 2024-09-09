package com.qq.e.comm.plugin.r0;

import android.content.Context;
import android.graphics.Movie;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.plugin.util.f1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class o extends f implements View.OnClickListener {

    /* renamed from: j  reason: collision with root package name */
    private final View f45834j;

    /* renamed from: k  reason: collision with root package name */
    private final String f45835k;

    /* renamed from: l  reason: collision with root package name */
    private View.OnClickListener f45836l;

    public o(Context context, String str) {
        this(context, null, str);
    }

    private void a(int i4, int i5, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f1.a(getContext(), 112), f1.a(getContext(), 90));
        layoutParams.topMargin = f1.a(getContext(), i4 - 90);
        layoutParams.leftMargin = f1.a(getContext(), i5);
        viewGroup.addView(this, layoutParams);
        com.qq.e.comm.plugin.b0.b.a().a(this.f45835k, this);
        setVisibility(0);
    }

    public void b(int i4, int i5, ViewGroup viewGroup) {
        if (viewGroup == null || getParent() != null) {
            return;
        }
        a(i5, i4, viewGroup);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.f45836l;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(this.f45834j);
        if (d4 != null) {
            d4.a(motionEvent, true);
        }
        return super.onTouchEvent(motionEvent);
    }

    public o(Context context, View view, String str) {
        super(context);
        this.f45834j = view;
        this.f45835k = str;
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        setOnClickListener(this);
        setVisibility(8);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f45836l = onClickListener;
    }

    @Override // com.qq.e.comm.plugin.r0.f, com.qq.e.comm.plugin.r0.g
    public void a(Movie movie) {
        this.f45714c = movie;
        if (movie != null) {
            this.f45716e = f1.a(getContext(), 112);
            this.f45715d = f1.a(getContext(), 90);
            this.f45719h = this.f45714c.width();
            this.f45720i = this.f45714c.height();
            invalidate();
        }
    }
}
