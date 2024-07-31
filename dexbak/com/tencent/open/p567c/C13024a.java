package com.tencent.open.p567c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.c.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13024a extends RelativeLayout {

    /* renamed from: a */
    private static final String f37326a = C13024a.class.getName();

    /* renamed from: b */
    private Rect f37327b;

    /* renamed from: c */
    private boolean f37328c;

    /* renamed from: d */
    private InterfaceC13025a f37329d;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.c.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC13025a {
        /* renamed from: a */
        void mo15151a();

        /* renamed from: a */
        void mo15150a(int i);
    }

    public C13024a(Context context) {
        super(context);
        this.f37327b = null;
        this.f37328c = false;
        this.f37329d = null;
        this.f37327b = new Rect();
    }

    /* renamed from: a */
    public void m15154a(InterfaceC13025a interfaceC13025a) {
        this.f37329d = interfaceC13025a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f37327b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f37327b.top) - size;
        InterfaceC13025a interfaceC13025a = this.f37329d;
        if (interfaceC13025a != null && size != 0) {
            if (height > 100) {
                interfaceC13025a.mo15150a((Math.abs(this.f37327b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC13025a.mo15151a();
            }
        }
        super.onMeasure(i, i2);
    }
}
