package com.amap.api.col.p0463l;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.amap.api.maps.AMap;
import com.amap.api.maps.InfoWindowParams;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

/* renamed from: com.amap.api.col.3l.z */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class InfoWindowDelegate {

    /* renamed from: d */
    private View f5797d;

    /* renamed from: e */
    private TextView f5798e;

    /* renamed from: f */
    private TextView f5799f;

    /* renamed from: h */
    Context f5801h;

    /* renamed from: i */
    private IInfoWindowAction f5802i;

    /* renamed from: j */
    private IInfoWindowAction f5803j;

    /* renamed from: k */
    private BaseOverlay f5804k;

    /* renamed from: a */
    AMap.InfoWindowAdapter f5794a = null;

    /* renamed from: b */
    AMap.CommonInfoWindowAdapter f5795b = null;

    /* renamed from: c */
    private boolean f5796c = true;

    /* renamed from: g */
    private Drawable f5800g = null;

    /* renamed from: l */
    private AMap.InfoWindowAdapter f5805l = new C2009a();

    /* renamed from: m */
    private AMap.CommonInfoWindowAdapter f5806m = new C2010b();

    /* compiled from: InfoWindowDelegate.java */
    /* renamed from: com.amap.api.col.3l.z$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C2009a implements AMap.InfoWindowAdapter {
        C2009a() {
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public final View getInfoContents(Marker marker) {
            return null;
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public final View getInfoWindow(Marker marker) {
            try {
                if (InfoWindowDelegate.this.f5800g == null) {
                    InfoWindowDelegate infoWindowDelegate = InfoWindowDelegate.this;
                    infoWindowDelegate.f5800g = NinePatchTool.m54218c(infoWindowDelegate.f5801h, "infowindow_bg.9.png");
                }
                if (InfoWindowDelegate.this.f5797d == null) {
                    InfoWindowDelegate.this.f5797d = new LinearLayout(InfoWindowDelegate.this.f5801h);
                    InfoWindowDelegate.this.f5797d.setBackground(InfoWindowDelegate.this.f5800g);
                    InfoWindowDelegate.this.f5798e = new TextView(InfoWindowDelegate.this.f5801h);
                    InfoWindowDelegate.this.f5798e.setText(marker.getTitle());
                    InfoWindowDelegate.this.f5798e.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    InfoWindowDelegate.this.f5799f = new TextView(InfoWindowDelegate.this.f5801h);
                    InfoWindowDelegate.this.f5799f.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    InfoWindowDelegate.this.f5799f.setText(marker.getSnippet());
                    ((LinearLayout) InfoWindowDelegate.this.f5797d).setOrientation(1);
                    ((LinearLayout) InfoWindowDelegate.this.f5797d).addView(InfoWindowDelegate.this.f5798e);
                    ((LinearLayout) InfoWindowDelegate.this.f5797d).addView(InfoWindowDelegate.this.f5799f);
                }
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            return InfoWindowDelegate.this.f5797d;
        }
    }

    /* compiled from: InfoWindowDelegate.java */
    /* renamed from: com.amap.api.col.3l.z$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C2010b implements AMap.CommonInfoWindowAdapter {

        /* renamed from: a */
        private InfoWindowParams f5808a = null;

        C2010b() {
        }

        @Override // com.amap.api.maps.AMap.CommonInfoWindowAdapter
        public final InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay) {
            try {
                if (this.f5808a == null) {
                    this.f5808a = new InfoWindowParams();
                    if (InfoWindowDelegate.this.f5800g == null) {
                        InfoWindowDelegate infoWindowDelegate = InfoWindowDelegate.this;
                        infoWindowDelegate.f5800g = NinePatchTool.m54218c(infoWindowDelegate.f5801h, "infowindow_bg.9.png");
                    }
                    InfoWindowDelegate.this.f5797d = new LinearLayout(InfoWindowDelegate.this.f5801h);
                    InfoWindowDelegate.this.f5797d.setBackground(InfoWindowDelegate.this.f5800g);
                    InfoWindowDelegate.this.f5798e = new TextView(InfoWindowDelegate.this.f5801h);
                    InfoWindowDelegate.this.f5798e.setText("标题");
                    InfoWindowDelegate.this.f5798e.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    InfoWindowDelegate.this.f5799f = new TextView(InfoWindowDelegate.this.f5801h);
                    InfoWindowDelegate.this.f5799f.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    InfoWindowDelegate.this.f5799f.setText("内容");
                    ((LinearLayout) InfoWindowDelegate.this.f5797d).setOrientation(1);
                    ((LinearLayout) InfoWindowDelegate.this.f5797d).addView(InfoWindowDelegate.this.f5798e);
                    ((LinearLayout) InfoWindowDelegate.this.f5797d).addView(InfoWindowDelegate.this.f5799f);
                    this.f5808a.setInfoWindowType(2);
                    this.f5808a.setInfoWindow(InfoWindowDelegate.this.f5797d);
                }
                return this.f5808a;
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
                return null;
            }
        }
    }

    public InfoWindowDelegate(Context context) {
        this.f5801h = context;
    }

    /* renamed from: g */
    private static void m53372g(View view, BasePointOverlay basePointOverlay) {
        if (view == null || basePointOverlay == null || basePointOverlay.getPosition() == null || !InfoCollectUtils.m54405g()) {
            return;
        }
        String m55720Y = C1732a3.m55720Y(view);
        if (TextUtils.isEmpty(m55720Y)) {
            return;
        }
        InfoCollectUtils.m54411a().m54409c(basePointOverlay.getPosition(), m55720Y, "");
    }

    /* renamed from: t */
    private static boolean m53359t(AMap.InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            return true;
        }
        Marker marker = new Marker(null, new MarkerOptions(), "check");
        return infoWindowAdapter.getInfoWindow(marker) == null && infoWindowAdapter.getInfoContents(marker) == null;
    }

    /* renamed from: y */
    private synchronized IInfoWindowAction m53354y() {
        AMap.InfoWindowAdapter infoWindowAdapter = this.f5794a;
        if (infoWindowAdapter != null) {
            if (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter) {
                return this.f5803j;
            } else if (infoWindowAdapter instanceof AMap.MultiPositionInfoWindowAdapter) {
                return this.f5803j;
            }
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f5795b;
        if (commonInfoWindowAdapter != null && commonInfoWindowAdapter.getInfoWindowParams(null).getInfoWindowType() == 1) {
            return this.f5803j;
        }
        return this.f5802i;
    }

    /* renamed from: d */
    public final View m53375d(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f5794a;
        if (infoWindowAdapter != null) {
            View infoWindow = infoWindowAdapter.getInfoWindow((Marker) basePointOverlay);
            m53372g(infoWindow, basePointOverlay);
            return infoWindow;
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f5795b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            View infoWindow2 = infoWindowParams.getInfoWindow();
            m53372g(infoWindow2, basePointOverlay);
            return infoWindow2;
        }
        InfoWindowParams infoWindowParams2 = this.f5806m.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoWindow();
        }
        return null;
    }

    /* renamed from: f */
    public final BaseOverlay m53373f(MotionEvent motionEvent) {
        IInfoWindowAction m53354y = m53354y();
        if (m53354y == null || !m53354y.onInfoWindowTap(motionEvent)) {
            return null;
        }
        return this.f5804k;
    }

    /* renamed from: h */
    public final synchronized void m53371h(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) {
        this.f5795b = commonInfoWindowAdapter;
        this.f5794a = null;
        if (commonInfoWindowAdapter == null) {
            this.f5795b = this.f5806m;
            this.f5796c = true;
        } else {
            this.f5796c = false;
        }
        IInfoWindowAction iInfoWindowAction = this.f5803j;
        if (iInfoWindowAction != null) {
            iInfoWindowAction.hideInfoWindow();
        }
        IInfoWindowAction iInfoWindowAction2 = this.f5802i;
        if (iInfoWindowAction2 != null) {
            iInfoWindowAction2.hideInfoWindow();
        }
    }

    /* renamed from: i */
    public final synchronized void m53370i(AMap.InfoWindowAdapter infoWindowAdapter) {
        this.f5794a = infoWindowAdapter;
        this.f5795b = null;
        if (m53359t(infoWindowAdapter)) {
            this.f5794a = this.f5805l;
            this.f5796c = true;
        } else {
            this.f5796c = false;
        }
        IInfoWindowAction iInfoWindowAction = this.f5803j;
        if (iInfoWindowAction != null) {
            iInfoWindowAction.hideInfoWindow();
        }
        IInfoWindowAction iInfoWindowAction2 = this.f5802i;
        if (iInfoWindowAction2 != null) {
            iInfoWindowAction2.hideInfoWindow();
        }
    }

    /* renamed from: j */
    public final void m53369j(BaseOverlay baseOverlay) throws RemoteException {
        IInfoWindowAction m53354y = m53354y();
        if (m53354y == null || !(baseOverlay instanceof BasePointOverlay)) {
            return;
        }
        m53354y.showInfoWindow((BasePointOverlay) baseOverlay);
        this.f5804k = baseOverlay;
    }

    /* renamed from: k */
    public final void m53368k(BaseOverlayImp baseOverlayImp) throws RemoteException {
        IInfoWindowAction m53354y = m53354y();
        if (m53354y != null) {
            m53354y.showInfoWindow(baseOverlayImp);
        }
    }

    /* renamed from: l */
    public final void m53367l(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.f5802i = iInfoWindowAction;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.setInfoWindowAdapterManager(this);
            }
        }
    }

    /* renamed from: m */
    public final void m53366m(String str, String str2) {
        TextView textView = this.f5798e;
        if (textView != null) {
            textView.requestLayout();
            this.f5798e.setText(str);
        }
        TextView textView2 = this.f5799f;
        if (textView2 != null) {
            textView2.requestLayout();
            this.f5799f.setText(str2);
        }
        View view = this.f5797d;
        if (view != null) {
            view.requestLayout();
        }
    }

    /* renamed from: n */
    public final synchronized boolean m53365n() {
        return this.f5796c;
    }

    /* renamed from: p */
    public final View m53363p(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f5794a;
        if (infoWindowAdapter != null) {
            View infoContents = infoWindowAdapter.getInfoContents((Marker) basePointOverlay);
            m53372g(infoContents, basePointOverlay);
            return infoContents;
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f5795b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            View infoContents2 = infoWindowParams.getInfoContents();
            m53372g(infoContents2, basePointOverlay);
            return infoContents2;
        }
        InfoWindowParams infoWindowParams2 = this.f5806m.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoContents();
        }
        return null;
    }

    /* renamed from: r */
    public final void m53361r() {
        IInfoWindowAction m53354y = m53354y();
        if (m53354y != null) {
            m53354y.redrawInfoWindow();
        }
    }

    /* renamed from: s */
    public final void m53360s(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.f5803j = iInfoWindowAction;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.setInfoWindowAdapterManager(this);
            }
        }
    }

    /* renamed from: u */
    public final long m53358u(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f5794a;
        if (infoWindowAdapter != null && (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter)) {
            return ((AMap.ImageInfoWindowAdapter) infoWindowAdapter).getInfoWindowUpdateTime();
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f5795b;
        if (commonInfoWindowAdapter == null || (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) == null) {
            return 0L;
        }
        return infoWindowParams.getInfoWindowUpdateTime();
    }

    /* renamed from: w */
    public final void m53356w() {
        IInfoWindowAction m53354y = m53354y();
        if (m53354y != null) {
            m53354y.hideInfoWindow();
        }
    }
}
