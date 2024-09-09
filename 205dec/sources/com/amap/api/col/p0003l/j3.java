package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.col.p0003l.eh;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ZoomControllerView.java */
/* renamed from: com.amap.api.col.3l.j3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class j3 extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f8193a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f8194b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f8195c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f8196d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f8197e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f8198f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f8199g;

    /* renamed from: h  reason: collision with root package name */
    private Bitmap f8200h;

    /* renamed from: i  reason: collision with root package name */
    private Bitmap f8201i;

    /* renamed from: j  reason: collision with root package name */
    private Bitmap f8202j;

    /* renamed from: k  reason: collision with root package name */
    private Bitmap f8203k;

    /* renamed from: l  reason: collision with root package name */
    private Bitmap f8204l;

    /* renamed from: m  reason: collision with root package name */
    private ImageView f8205m;

    /* renamed from: n  reason: collision with root package name */
    private ImageView f8206n;

    /* renamed from: o  reason: collision with root package name */
    private IAMapDelegate f8207o;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: ZoomControllerView.java */
    /* renamed from: com.amap.api.col.3l.j3$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            try {
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (j3.this.f8207o.getZoomLevel() < j3.this.f8207o.getMaxZoomLevel() && j3.this.f8207o.isMaploaded()) {
                if (motionEvent.getAction() == 0) {
                    j3.this.f8205m.setImageBitmap(j3.this.f8197e);
                } else if (motionEvent.getAction() == 1) {
                    j3.this.f8205m.setImageBitmap(j3.this.f8193a);
                    try {
                        j3.this.f8207o.animateCamera(m.a());
                    } catch (RemoteException e4) {
                        u5.p(e4, "ZoomControllerView", "zoomin ontouch");
                        e4.printStackTrace();
                    }
                }
                return false;
            }
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: ZoomControllerView.java */
    /* renamed from: com.amap.api.col.3l.j3$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            try {
            } catch (Throwable th) {
                u5.p(th, "ZoomControllerView", "zoomout ontouch");
                th.printStackTrace();
            }
            if (j3.this.f8207o.getZoomLevel() > j3.this.f8207o.getMinZoomLevel() && j3.this.f8207o.isMaploaded()) {
                if (motionEvent.getAction() == 0) {
                    j3.this.f8206n.setImageBitmap(j3.this.f8198f);
                } else if (motionEvent.getAction() == 1) {
                    j3.this.f8206n.setImageBitmap(j3.this.f8195c);
                    j3.this.f8207o.animateCamera(m.l());
                }
                return false;
            }
            return false;
        }
    }

    public j3(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f8207o = iAMapDelegate;
        try {
            Bitmap l4 = a3.l(context, "zoomin_selected.png");
            this.f8199g = l4;
            this.f8193a = a3.m(l4, fa.f7730a);
            Bitmap l5 = a3.l(context, "zoomin_unselected.png");
            this.f8200h = l5;
            this.f8194b = a3.m(l5, fa.f7730a);
            Bitmap l6 = a3.l(context, "zoomout_selected.png");
            this.f8201i = l6;
            this.f8195c = a3.m(l6, fa.f7730a);
            Bitmap l7 = a3.l(context, "zoomout_unselected.png");
            this.f8202j = l7;
            this.f8196d = a3.m(l7, fa.f7730a);
            Bitmap l8 = a3.l(context, "zoomin_pressed.png");
            this.f8203k = l8;
            this.f8197e = a3.m(l8, fa.f7730a);
            Bitmap l9 = a3.l(context, "zoomout_pressed.png");
            this.f8204l = l9;
            this.f8198f = a3.m(l9, fa.f7730a);
            ImageView imageView = new ImageView(context);
            this.f8205m = imageView;
            imageView.setImageBitmap(this.f8193a);
            this.f8205m.setClickable(true);
            ImageView imageView2 = new ImageView(context);
            this.f8206n = imageView2;
            imageView2.setImageBitmap(this.f8195c);
            this.f8206n.setClickable(true);
            this.f8205m.setOnTouchListener(new a());
            this.f8206n.setOnTouchListener(new b());
            this.f8205m.setPadding(0, 0, 20, -2);
            this.f8206n.setPadding(0, 0, 20, 20);
            setOrientation(1);
            addView(this.f8205m);
            addView(this.f8206n);
        } catch (Throwable th) {
            u5.p(th, "ZoomControllerView", "create");
            th.printStackTrace();
        }
    }

    public final void b() {
        try {
            removeAllViews();
            a3.B(this.f8193a);
            a3.B(this.f8194b);
            a3.B(this.f8195c);
            a3.B(this.f8196d);
            a3.B(this.f8197e);
            a3.B(this.f8198f);
            this.f8193a = null;
            this.f8194b = null;
            this.f8195c = null;
            this.f8196d = null;
            this.f8197e = null;
            this.f8198f = null;
            Bitmap bitmap = this.f8199g;
            if (bitmap != null) {
                a3.B(bitmap);
                this.f8199g = null;
            }
            Bitmap bitmap2 = this.f8200h;
            if (bitmap2 != null) {
                a3.B(bitmap2);
                this.f8200h = null;
            }
            Bitmap bitmap3 = this.f8201i;
            if (bitmap3 != null) {
                a3.B(bitmap3);
                this.f8201i = null;
            }
            Bitmap bitmap4 = this.f8202j;
            if (bitmap4 != null) {
                a3.B(bitmap4);
                this.f8199g = null;
            }
            Bitmap bitmap5 = this.f8203k;
            if (bitmap5 != null) {
                a3.B(bitmap5);
                this.f8203k = null;
            }
            Bitmap bitmap6 = this.f8204l;
            if (bitmap6 != null) {
                a3.B(bitmap6);
                this.f8204l = null;
            }
            this.f8205m = null;
            this.f8206n = null;
        } catch (Throwable th) {
            u5.p(th, "ZoomControllerView", "destory");
            th.printStackTrace();
        }
    }

    public final void c(float f4) {
        try {
            if (f4 < this.f8207o.getMaxZoomLevel() && f4 > this.f8207o.getMinZoomLevel()) {
                this.f8205m.setImageBitmap(this.f8193a);
                this.f8206n.setImageBitmap(this.f8195c);
            } else if (f4 == this.f8207o.getMinZoomLevel()) {
                this.f8206n.setImageBitmap(this.f8196d);
                this.f8205m.setImageBitmap(this.f8193a);
            } else if (f4 == this.f8207o.getMaxZoomLevel()) {
                this.f8205m.setImageBitmap(this.f8194b);
                this.f8206n.setImageBitmap(this.f8195c);
            }
        } catch (Throwable th) {
            u5.p(th, "ZoomControllerView", "setZoomBitmap");
            th.printStackTrace();
        }
    }

    public final void d(int i4) {
        try {
            eh.c cVar = (eh.c) getLayoutParams();
            if (i4 == 1) {
                cVar.f7602e = 16;
            } else if (i4 == 2) {
                cVar.f7602e = 80;
            }
            setLayoutParams(cVar);
        } catch (Throwable th) {
            u5.p(th, "ZoomControllerView", "setZoomPosition");
            th.printStackTrace();
        }
    }

    public final void e(boolean z3) {
        if (z3) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }
}
