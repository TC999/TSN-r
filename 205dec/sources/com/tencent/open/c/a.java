package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f51726a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private Rect f51727b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f51728c;

    /* renamed from: d  reason: collision with root package name */
    private InterfaceC1043a f51729d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface InterfaceC1043a {
        void a();

        void a(int i4);
    }

    public a(Context context) {
        super(context);
        this.f51727b = null;
        this.f51728c = false;
        this.f51729d = null;
        this.f51727b = new Rect();
    }

    public void a(InterfaceC1043a interfaceC1043a) {
        this.f51729d = interfaceC1043a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        int size = View.MeasureSpec.getSize(i5);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f51727b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f51727b.top) - size;
        InterfaceC1043a interfaceC1043a = this.f51729d;
        if (interfaceC1043a != null && size != 0) {
            if (height > 100) {
                interfaceC1043a.a((Math.abs(this.f51727b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC1043a.a();
            }
        }
        super.onMeasure(i4, i5);
    }
}
