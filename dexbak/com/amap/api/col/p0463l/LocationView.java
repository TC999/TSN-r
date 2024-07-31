package com.amap.api.col.p0463l;

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

/* renamed from: com.amap.api.col.3l.eg */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class LocationView extends LinearLayout {

    /* renamed from: a */
    Bitmap f3984a;

    /* renamed from: b */
    Bitmap f3985b;

    /* renamed from: c */
    Bitmap f3986c;

    /* renamed from: d */
    Bitmap f3987d;

    /* renamed from: e */
    Bitmap f3988e;

    /* renamed from: f */
    Bitmap f3989f;

    /* renamed from: g */
    ImageView f3990g;

    /* renamed from: h */
    IAMapDelegate f3991h;

    /* renamed from: i */
    boolean f3992i;

    /* compiled from: LocationView.java */
    /* renamed from: com.amap.api.col.3l.eg$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class View$OnTouchListenerC1790a implements View.OnTouchListener {
        View$OnTouchListenerC1790a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (LocationView.this.f3992i) {
                if (motionEvent.getAction() == 0) {
                    LocationView locationView = LocationView.this;
                    locationView.f3990g.setImageBitmap(locationView.f3985b);
                } else if (motionEvent.getAction() == 1) {
                    try {
                        LocationView locationView2 = LocationView.this;
                        locationView2.f3990g.setImageBitmap(locationView2.f3984a);
                        LocationView.this.f3991h.setMyLocationEnabled(true);
                        Location myLocation = LocationView.this.f3991h.getMyLocation();
                        if (myLocation == null) {
                            return false;
                        }
                        LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                        LocationView.this.f3991h.showMyLocationOverlay(myLocation);
                        IAMapDelegate iAMapDelegate = LocationView.this.f3991h;
                        iAMapDelegate.moveCamera(CameraUpdateFactoryDelegate.m54547h(latLng, iAMapDelegate.getZoomLevel()));
                    } catch (Throwable th) {
                        SDKLogHandler.m53863p(th, "LocationView", "onTouch");
                        th.printStackTrace();
                    }
                }
                return false;
            }
            return false;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public LocationView(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f3992i = false;
        this.f3991h = iAMapDelegate;
        try {
            Bitmap m55698l = C1732a3.m55698l(context, "location_selected.png");
            this.f3987d = m55698l;
            this.f3984a = C1732a3.m55697m(m55698l, ConfigableConst.f3941a);
            Bitmap m55698l2 = C1732a3.m55698l(context, "location_pressed.png");
            this.f3988e = m55698l2;
            this.f3985b = C1732a3.m55697m(m55698l2, ConfigableConst.f3941a);
            Bitmap m55698l3 = C1732a3.m55698l(context, "location_unselected.png");
            this.f3989f = m55698l3;
            this.f3986c = C1732a3.m55697m(m55698l3, ConfigableConst.f3941a);
            ImageView imageView = new ImageView(context);
            this.f3990g = imageView;
            imageView.setImageBitmap(this.f3984a);
            this.f3990g.setClickable(true);
            this.f3990g.setPadding(0, 20, 20, 0);
            this.f3990g.setOnTouchListener(new View$OnTouchListenerC1790a());
            addView(this.f3990g);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "LocationView", "create");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m55153a() {
        try {
            removeAllViews();
            Bitmap bitmap = this.f3984a;
            if (bitmap != null) {
                C1732a3.m55743B(bitmap);
            }
            Bitmap bitmap2 = this.f3985b;
            if (bitmap2 != null) {
                C1732a3.m55743B(bitmap2);
            }
            if (this.f3985b != null) {
                C1732a3.m55743B(this.f3986c);
            }
            this.f3984a = null;
            this.f3985b = null;
            this.f3986c = null;
            Bitmap bitmap3 = this.f3987d;
            if (bitmap3 != null) {
                C1732a3.m55743B(bitmap3);
                this.f3987d = null;
            }
            Bitmap bitmap4 = this.f3988e;
            if (bitmap4 != null) {
                C1732a3.m55743B(bitmap4);
                this.f3988e = null;
            }
            Bitmap bitmap5 = this.f3989f;
            if (bitmap5 != null) {
                C1732a3.m55743B(bitmap5);
                this.f3989f = null;
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "LocationView", "destroy");
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public final void m55152b(boolean z) {
        this.f3992i = z;
        try {
            if (z) {
                this.f3990g.setImageBitmap(this.f3984a);
            } else {
                this.f3990g.setImageBitmap(this.f3986c);
            }
            this.f3990g.invalidate();
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "LocationView", "showSelect");
            th.printStackTrace();
        }
    }
}
