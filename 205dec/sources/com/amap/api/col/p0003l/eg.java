package com.amap.api.col.p0003l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.LatLng;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: LocationView.java */
/* renamed from: com.amap.api.col.3l.eg  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class eg extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    Bitmap f7562a;

    /* renamed from: b  reason: collision with root package name */
    Bitmap f7563b;

    /* renamed from: c  reason: collision with root package name */
    Bitmap f7564c;

    /* renamed from: d  reason: collision with root package name */
    Bitmap f7565d;

    /* renamed from: e  reason: collision with root package name */
    Bitmap f7566e;

    /* renamed from: f  reason: collision with root package name */
    Bitmap f7567f;

    /* renamed from: g  reason: collision with root package name */
    ImageView f7568g;

    /* renamed from: h  reason: collision with root package name */
    IAMapDelegate f7569h;

    /* renamed from: i  reason: collision with root package name */
    boolean f7570i;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: LocationView.java */
    /* renamed from: com.amap.api.col.3l.eg$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (eg.this.f7570i) {
                if (motionEvent.getAction() == 0) {
                    eg egVar = eg.this;
                    egVar.f7568g.setImageBitmap(egVar.f7563b);
                } else if (motionEvent.getAction() == 1) {
                    try {
                        eg egVar2 = eg.this;
                        egVar2.f7568g.setImageBitmap(egVar2.f7562a);
                        eg.this.f7569h.setMyLocationEnabled(true);
                        Location myLocation = eg.this.f7569h.getMyLocation();
                        if (myLocation == null) {
                            return false;
                        }
                        LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                        eg.this.f7569h.showMyLocationOverlay(myLocation);
                        IAMapDelegate iAMapDelegate = eg.this.f7569h;
                        iAMapDelegate.moveCamera(m.h(latLng, iAMapDelegate.getZoomLevel()));
                    } catch (Throwable th) {
                        u5.p(th, "LocationView", "onTouch");
                        th.printStackTrace();
                    }
                }
                return false;
            }
            return false;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public eg(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f7570i = false;
        this.f7569h = iAMapDelegate;
        try {
            Bitmap l4 = a3.l(context, "location_selected.png");
            this.f7565d = l4;
            this.f7562a = a3.m(l4, fa.f7730a);
            Bitmap l5 = a3.l(context, "location_pressed.png");
            this.f7566e = l5;
            this.f7563b = a3.m(l5, fa.f7730a);
            Bitmap l6 = a3.l(context, "location_unselected.png");
            this.f7567f = l6;
            this.f7564c = a3.m(l6, fa.f7730a);
            ImageView imageView = new ImageView(context);
            this.f7568g = imageView;
            imageView.setImageBitmap(this.f7562a);
            this.f7568g.setClickable(true);
            this.f7568g.setPadding(0, 20, 20, 0);
            this.f7568g.setOnTouchListener(new a());
            addView(this.f7568g);
        } catch (Throwable th) {
            u5.p(th, "LocationView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            Bitmap bitmap = this.f7562a;
            if (bitmap != null) {
                a3.B(bitmap);
            }
            Bitmap bitmap2 = this.f7563b;
            if (bitmap2 != null) {
                a3.B(bitmap2);
            }
            if (this.f7563b != null) {
                a3.B(this.f7564c);
            }
            this.f7562a = null;
            this.f7563b = null;
            this.f7564c = null;
            Bitmap bitmap3 = this.f7565d;
            if (bitmap3 != null) {
                a3.B(bitmap3);
                this.f7565d = null;
            }
            Bitmap bitmap4 = this.f7566e;
            if (bitmap4 != null) {
                a3.B(bitmap4);
                this.f7566e = null;
            }
            Bitmap bitmap5 = this.f7567f;
            if (bitmap5 != null) {
                a3.B(bitmap5);
                this.f7567f = null;
            }
        } catch (Throwable th) {
            u5.p(th, "LocationView", "destroy");
            th.printStackTrace();
        }
    }

    public final void b(boolean z3) {
        this.f7570i = z3;
        try {
            if (z3) {
                this.f7568g.setImageBitmap(this.f7562a);
            } else {
                this.f7568g.setImageBitmap(this.f7564c);
            }
            this.f7568g.invalidate();
        } catch (Throwable th) {
            u5.p(th, "LocationView", "showSelect");
            th.printStackTrace();
        }
    }
}
