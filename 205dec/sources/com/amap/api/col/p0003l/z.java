package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.InfoWindowParams;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: InfoWindowDelegate.java */
/* renamed from: com.amap.api.col.3l.z  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class z {

    /* renamed from: d  reason: collision with root package name */
    private View f9562d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f9563e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f9564f;

    /* renamed from: h  reason: collision with root package name */
    Context f9566h;

    /* renamed from: i  reason: collision with root package name */
    private IInfoWindowAction f9567i;

    /* renamed from: j  reason: collision with root package name */
    private IInfoWindowAction f9568j;

    /* renamed from: k  reason: collision with root package name */
    private BaseOverlay f9569k;

    /* renamed from: a  reason: collision with root package name */
    AMap.InfoWindowAdapter f9559a = null;

    /* renamed from: b  reason: collision with root package name */
    AMap.CommonInfoWindowAdapter f9560b = null;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9561c = true;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f9565g = null;

    /* renamed from: l  reason: collision with root package name */
    private AMap.InfoWindowAdapter f9570l = new a();

    /* renamed from: m  reason: collision with root package name */
    private AMap.CommonInfoWindowAdapter f9571m = new b();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: InfoWindowDelegate.java */
    /* renamed from: com.amap.api.col.3l.z$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements AMap.InfoWindowAdapter {
        a() {
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public final View getInfoContents(Marker marker) {
            return null;
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public final View getInfoWindow(Marker marker) {
            try {
                if (z.this.f9565g == null) {
                    z zVar = z.this;
                    zVar.f9565g = p2.c(zVar.f9566h, "infowindow_bg.9.png");
                }
                if (z.this.f9562d == null) {
                    z.this.f9562d = new LinearLayout(z.this.f9566h);
                    z.this.f9562d.setBackground(z.this.f9565g);
                    z.this.f9563e = new TextView(z.this.f9566h);
                    z.this.f9563e.setText(marker.getTitle());
                    z.this.f9563e.setTextColor(-16777216);
                    z.this.f9564f = new TextView(z.this.f9566h);
                    z.this.f9564f.setTextColor(-16777216);
                    z.this.f9564f.setText(marker.getSnippet());
                    ((LinearLayout) z.this.f9562d).setOrientation(1);
                    ((LinearLayout) z.this.f9562d).addView(z.this.f9563e);
                    ((LinearLayout) z.this.f9562d).addView(z.this.f9564f);
                }
            } catch (Throwable th) {
                u5.p(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            return z.this.f9562d;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: InfoWindowDelegate.java */
    /* renamed from: com.amap.api.col.3l.z$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements AMap.CommonInfoWindowAdapter {

        /* renamed from: a  reason: collision with root package name */
        private InfoWindowParams f9573a = null;

        b() {
        }

        @Override // com.amap.api.maps.AMap.CommonInfoWindowAdapter
        public final InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay) {
            try {
                if (this.f9573a == null) {
                    this.f9573a = new InfoWindowParams();
                    if (z.this.f9565g == null) {
                        z zVar = z.this;
                        zVar.f9565g = p2.c(zVar.f9566h, "infowindow_bg.9.png");
                    }
                    z.this.f9562d = new LinearLayout(z.this.f9566h);
                    z.this.f9562d.setBackground(z.this.f9565g);
                    z.this.f9563e = new TextView(z.this.f9566h);
                    z.this.f9563e.setText("\u6807\u9898");
                    z.this.f9563e.setTextColor(-16777216);
                    z.this.f9564f = new TextView(z.this.f9566h);
                    z.this.f9564f.setTextColor(-16777216);
                    z.this.f9564f.setText("\u5185\u5bb9");
                    ((LinearLayout) z.this.f9562d).setOrientation(1);
                    ((LinearLayout) z.this.f9562d).addView(z.this.f9563e);
                    ((LinearLayout) z.this.f9562d).addView(z.this.f9564f);
                    this.f9573a.setInfoWindowType(2);
                    this.f9573a.setInfoWindow(z.this.f9562d);
                }
                return this.f9573a;
            } catch (Throwable th) {
                u5.p(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
                return null;
            }
        }
    }

    public z(Context context) {
        this.f9566h = context;
    }

    private static void g(View view, BasePointOverlay basePointOverlay) {
        if (view == null || basePointOverlay == null || basePointOverlay.getPosition() == null || !o2.g()) {
            return;
        }
        String Y = a3.Y(view);
        if (TextUtils.isEmpty(Y)) {
            return;
        }
        o2.a().c(basePointOverlay.getPosition(), Y, "");
    }

    private static boolean t(AMap.InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            return true;
        }
        Marker marker = new Marker(null, new MarkerOptions(), "check");
        return infoWindowAdapter.getInfoWindow(marker) == null && infoWindowAdapter.getInfoContents(marker) == null;
    }

    private synchronized IInfoWindowAction y() {
        AMap.InfoWindowAdapter infoWindowAdapter = this.f9559a;
        if (infoWindowAdapter != null) {
            if (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter) {
                return this.f9568j;
            } else if (infoWindowAdapter instanceof AMap.MultiPositionInfoWindowAdapter) {
                return this.f9568j;
            }
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f9560b;
        if (commonInfoWindowAdapter != null && commonInfoWindowAdapter.getInfoWindowParams(null).getInfoWindowType() == 1) {
            return this.f9568j;
        }
        return this.f9567i;
    }

    public final View d(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f9559a;
        if (infoWindowAdapter != null) {
            View infoWindow = infoWindowAdapter.getInfoWindow((Marker) basePointOverlay);
            g(infoWindow, basePointOverlay);
            return infoWindow;
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f9560b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            View infoWindow2 = infoWindowParams.getInfoWindow();
            g(infoWindow2, basePointOverlay);
            return infoWindow2;
        }
        InfoWindowParams infoWindowParams2 = this.f9571m.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoWindow();
        }
        return null;
    }

    public final BaseOverlay f(MotionEvent motionEvent) {
        IInfoWindowAction y3 = y();
        if (y3 == null || !y3.onInfoWindowTap(motionEvent)) {
            return null;
        }
        return this.f9569k;
    }

    public final synchronized void h(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) {
        this.f9560b = commonInfoWindowAdapter;
        this.f9559a = null;
        if (commonInfoWindowAdapter == null) {
            this.f9560b = this.f9571m;
            this.f9561c = true;
        } else {
            this.f9561c = false;
        }
        IInfoWindowAction iInfoWindowAction = this.f9568j;
        if (iInfoWindowAction != null) {
            iInfoWindowAction.hideInfoWindow();
        }
        IInfoWindowAction iInfoWindowAction2 = this.f9567i;
        if (iInfoWindowAction2 != null) {
            iInfoWindowAction2.hideInfoWindow();
        }
    }

    public final synchronized void i(AMap.InfoWindowAdapter infoWindowAdapter) {
        this.f9559a = infoWindowAdapter;
        this.f9560b = null;
        if (t(infoWindowAdapter)) {
            this.f9559a = this.f9570l;
            this.f9561c = true;
        } else {
            this.f9561c = false;
        }
        IInfoWindowAction iInfoWindowAction = this.f9568j;
        if (iInfoWindowAction != null) {
            iInfoWindowAction.hideInfoWindow();
        }
        IInfoWindowAction iInfoWindowAction2 = this.f9567i;
        if (iInfoWindowAction2 != null) {
            iInfoWindowAction2.hideInfoWindow();
        }
    }

    public final void j(BaseOverlay baseOverlay) throws RemoteException {
        IInfoWindowAction y3 = y();
        if (y3 == null || !(baseOverlay instanceof BasePointOverlay)) {
            return;
        }
        y3.showInfoWindow((BasePointOverlay) baseOverlay);
        this.f9569k = baseOverlay;
    }

    public final void k(BaseOverlayImp baseOverlayImp) throws RemoteException {
        IInfoWindowAction y3 = y();
        if (y3 != null) {
            y3.showInfoWindow(baseOverlayImp);
        }
    }

    public final void l(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.f9567i = iInfoWindowAction;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.setInfoWindowAdapterManager(this);
            }
        }
    }

    public final void m(String str, String str2) {
        TextView textView = this.f9563e;
        if (textView != null) {
            textView.requestLayout();
            this.f9563e.setText(str);
        }
        TextView textView2 = this.f9564f;
        if (textView2 != null) {
            textView2.requestLayout();
            this.f9564f.setText(str2);
        }
        View view = this.f9562d;
        if (view != null) {
            view.requestLayout();
        }
    }

    public final synchronized boolean n() {
        return this.f9561c;
    }

    public final View p(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f9559a;
        if (infoWindowAdapter != null) {
            View infoContents = infoWindowAdapter.getInfoContents((Marker) basePointOverlay);
            g(infoContents, basePointOverlay);
            return infoContents;
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f9560b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            View infoContents2 = infoWindowParams.getInfoContents();
            g(infoContents2, basePointOverlay);
            return infoContents2;
        }
        InfoWindowParams infoWindowParams2 = this.f9571m.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoContents();
        }
        return null;
    }

    public final void r() {
        IInfoWindowAction y3 = y();
        if (y3 != null) {
            y3.redrawInfoWindow();
        }
    }

    public final void s(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.f9568j = iInfoWindowAction;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.setInfoWindowAdapterManager(this);
            }
        }
    }

    public final long u(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f9559a;
        if (infoWindowAdapter != null && (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter)) {
            return ((AMap.ImageInfoWindowAdapter) infoWindowAdapter).getInfoWindowUpdateTime();
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f9560b;
        if (commonInfoWindowAdapter == null || (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) == null) {
            return 0L;
        }
        return infoWindowParams.getInfoWindowUpdateTime();
    }

    public final void w() {
        IInfoWindowAction y3 = y();
        if (y3 != null) {
            y3.hideInfoWindow();
        }
    }
}
