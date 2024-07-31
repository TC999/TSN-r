package com.amap.api.col.p0463l;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.col.p0463l.MapOverlayViewGroup;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.col.3l.j3 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ZoomControllerView extends LinearLayout {

    /* renamed from: a */
    private Bitmap f4549a;

    /* renamed from: b */
    private Bitmap f4550b;

    /* renamed from: c */
    private Bitmap f4551c;

    /* renamed from: d */
    private Bitmap f4552d;

    /* renamed from: e */
    private Bitmap f4553e;

    /* renamed from: f */
    private Bitmap f4554f;

    /* renamed from: g */
    private Bitmap f4555g;

    /* renamed from: h */
    private Bitmap f4556h;

    /* renamed from: i */
    private Bitmap f4557i;

    /* renamed from: j */
    private Bitmap f4558j;

    /* renamed from: k */
    private Bitmap f4559k;

    /* renamed from: l */
    private Bitmap f4560l;

    /* renamed from: m */
    private ImageView f4561m;

    /* renamed from: n */
    private ImageView f4562n;

    /* renamed from: o */
    private IAMapDelegate f4563o;

    /* compiled from: ZoomControllerView.java */
    /* renamed from: com.amap.api.col.3l.j3$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class View$OnTouchListenerC1844a implements View.OnTouchListener {
        View$OnTouchListenerC1844a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            try {
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (ZoomControllerView.this.f4563o.getZoomLevel() < ZoomControllerView.this.f4563o.getMaxZoomLevel() && ZoomControllerView.this.f4563o.isMaploaded()) {
                if (motionEvent.getAction() == 0) {
                    ZoomControllerView.this.f4561m.setImageBitmap(ZoomControllerView.this.f4553e);
                } else if (motionEvent.getAction() == 1) {
                    ZoomControllerView.this.f4561m.setImageBitmap(ZoomControllerView.this.f4549a);
                    try {
                        ZoomControllerView.this.f4563o.animateCamera(CameraUpdateFactoryDelegate.m54554a());
                    } catch (RemoteException e) {
                        SDKLogHandler.m53863p(e, "ZoomControllerView", "zoomin ontouch");
                        e.printStackTrace();
                    }
                }
                return false;
            }
            return false;
        }
    }

    /* compiled from: ZoomControllerView.java */
    /* renamed from: com.amap.api.col.3l.j3$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class View$OnTouchListenerC1845b implements View.OnTouchListener {
        View$OnTouchListenerC1845b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            try {
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "ZoomControllerView", "zoomout ontouch");
                th.printStackTrace();
            }
            if (ZoomControllerView.this.f4563o.getZoomLevel() > ZoomControllerView.this.f4563o.getMinZoomLevel() && ZoomControllerView.this.f4563o.isMaploaded()) {
                if (motionEvent.getAction() == 0) {
                    ZoomControllerView.this.f4562n.setImageBitmap(ZoomControllerView.this.f4554f);
                } else if (motionEvent.getAction() == 1) {
                    ZoomControllerView.this.f4562n.setImageBitmap(ZoomControllerView.this.f4551c);
                    ZoomControllerView.this.f4563o.animateCamera(CameraUpdateFactoryDelegate.m54543l());
                }
                return false;
            }
            return false;
        }
    }

    public ZoomControllerView(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f4563o = iAMapDelegate;
        try {
            Bitmap m55698l = C1732a3.m55698l(context, "zoomin_selected.png");
            this.f4555g = m55698l;
            this.f4549a = C1732a3.m55697m(m55698l, ConfigableConst.f3941a);
            Bitmap m55698l2 = C1732a3.m55698l(context, "zoomin_unselected.png");
            this.f4556h = m55698l2;
            this.f4550b = C1732a3.m55697m(m55698l2, ConfigableConst.f3941a);
            Bitmap m55698l3 = C1732a3.m55698l(context, "zoomout_selected.png");
            this.f4557i = m55698l3;
            this.f4551c = C1732a3.m55697m(m55698l3, ConfigableConst.f3941a);
            Bitmap m55698l4 = C1732a3.m55698l(context, "zoomout_unselected.png");
            this.f4558j = m55698l4;
            this.f4552d = C1732a3.m55697m(m55698l4, ConfigableConst.f3941a);
            Bitmap m55698l5 = C1732a3.m55698l(context, "zoomin_pressed.png");
            this.f4559k = m55698l5;
            this.f4553e = C1732a3.m55697m(m55698l5, ConfigableConst.f3941a);
            Bitmap m55698l6 = C1732a3.m55698l(context, "zoomout_pressed.png");
            this.f4560l = m55698l6;
            this.f4554f = C1732a3.m55697m(m55698l6, ConfigableConst.f3941a);
            ImageView imageView = new ImageView(context);
            this.f4561m = imageView;
            imageView.setImageBitmap(this.f4549a);
            this.f4561m.setClickable(true);
            ImageView imageView2 = new ImageView(context);
            this.f4562n = imageView2;
            imageView2.setImageBitmap(this.f4551c);
            this.f4562n.setClickable(true);
            this.f4561m.setOnTouchListener(new View$OnTouchListenerC1844a());
            this.f4562n.setOnTouchListener(new View$OnTouchListenerC1845b());
            this.f4561m.setPadding(0, 0, 20, -2);
            this.f4562n.setPadding(0, 0, 20, 20);
            setOrientation(1);
            addView(this.f4561m);
            addView(this.f4562n);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "ZoomControllerView", "create");
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public final void m54683b() {
        try {
            removeAllViews();
            C1732a3.m55743B(this.f4549a);
            C1732a3.m55743B(this.f4550b);
            C1732a3.m55743B(this.f4551c);
            C1732a3.m55743B(this.f4552d);
            C1732a3.m55743B(this.f4553e);
            C1732a3.m55743B(this.f4554f);
            this.f4549a = null;
            this.f4550b = null;
            this.f4551c = null;
            this.f4552d = null;
            this.f4553e = null;
            this.f4554f = null;
            Bitmap bitmap = this.f4555g;
            if (bitmap != null) {
                C1732a3.m55743B(bitmap);
                this.f4555g = null;
            }
            Bitmap bitmap2 = this.f4556h;
            if (bitmap2 != null) {
                C1732a3.m55743B(bitmap2);
                this.f4556h = null;
            }
            Bitmap bitmap3 = this.f4557i;
            if (bitmap3 != null) {
                C1732a3.m55743B(bitmap3);
                this.f4557i = null;
            }
            Bitmap bitmap4 = this.f4558j;
            if (bitmap4 != null) {
                C1732a3.m55743B(bitmap4);
                this.f4555g = null;
            }
            Bitmap bitmap5 = this.f4559k;
            if (bitmap5 != null) {
                C1732a3.m55743B(bitmap5);
                this.f4559k = null;
            }
            Bitmap bitmap6 = this.f4560l;
            if (bitmap6 != null) {
                C1732a3.m55743B(bitmap6);
                this.f4560l = null;
            }
            this.f4561m = null;
            this.f4562n = null;
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "ZoomControllerView", "destory");
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    public final void m54682c(float f) {
        try {
            if (f < this.f4563o.getMaxZoomLevel() && f > this.f4563o.getMinZoomLevel()) {
                this.f4561m.setImageBitmap(this.f4549a);
                this.f4562n.setImageBitmap(this.f4551c);
            } else if (f == this.f4563o.getMinZoomLevel()) {
                this.f4562n.setImageBitmap(this.f4552d);
                this.f4561m.setImageBitmap(this.f4549a);
            } else if (f == this.f4563o.getMaxZoomLevel()) {
                this.f4561m.setImageBitmap(this.f4550b);
                this.f4562n.setImageBitmap(this.f4551c);
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "ZoomControllerView", "setZoomBitmap");
            th.printStackTrace();
        }
    }

    /* renamed from: d */
    public final void m54681d(int i) {
        try {
            MapOverlayViewGroup.C1796c c1796c = (MapOverlayViewGroup.C1796c) getLayoutParams();
            if (i == 1) {
                c1796c.f4024e = 16;
            } else if (i == 2) {
                c1796c.f4024e = 80;
            }
            setLayoutParams(c1796c);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "ZoomControllerView", "setZoomPosition");
            th.printStackTrace();
        }
    }

    /* renamed from: e */
    public final void m54680e(boolean z) {
        if (z) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }
}
