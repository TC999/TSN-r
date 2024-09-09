package com.amap.api.col.p0003l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: UiSettingsDelegateImp.java */
/* renamed from: com.amap.api.col.3l.h  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h implements IUiSettingsDelegate {

    /* renamed from: a  reason: collision with root package name */
    private IAMapDelegate f7936a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7937b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7938c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7939d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7940e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7941f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7942g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7943h = true;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7944i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7945j = true;

    /* renamed from: k  reason: collision with root package name */
    private int f7946k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f7947l = 1;

    /* renamed from: m  reason: collision with root package name */
    private boolean f7948m = true;

    /* renamed from: n  reason: collision with root package name */
    private boolean f7949n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f7950o = false;

    /* renamed from: p  reason: collision with root package name */
    final Handler f7951p = new a(Looper.getMainLooper());

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: UiSettingsDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.h$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message == null || h.this.f7936a == null) {
                return;
            }
            try {
                switch (message.what) {
                    case 0:
                        h.this.f7936a.showZoomControlsEnabled(h.this.f7942g);
                        return;
                    case 1:
                        h.this.f7936a.showScaleEnabled(h.this.f7944i);
                        return;
                    case 2:
                        h.this.f7936a.showCompassEnabled(h.this.f7943h);
                        return;
                    case 3:
                        h.this.f7936a.showMyLocationButtonEnabled(h.this.f7940e);
                        return;
                    case 4:
                        h.this.f7936a.showIndoorSwitchControlsEnabled(h.this.f7948m);
                        return;
                    case 5:
                        h.this.f7936a.showLogoEnabled(h.this.f7945j);
                        return;
                    case 6:
                        h.this.f7936a.refreshLogo();
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                u5.p(th, "UiSettingsDelegateImp", "handleMessage");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(IAMapDelegate iAMapDelegate) {
        this.f7936a = iAMapDelegate;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final float getLogoMarginRate(int i4) {
        return this.f7936a.getLogoMarginRate(i4);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final int getLogoPosition() throws RemoteException {
        return this.f7946k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final int getZoomPosition() throws RemoteException {
        return this.f7947l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isCompassEnabled() throws RemoteException {
        return this.f7943h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isGestureScaleByMapCenter() throws RemoteException {
        return this.f7950o;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isIndoorSwitchEnabled() throws RemoteException {
        return this.f7948m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isLogoEnable() {
        return this.f7945j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isMyLocationButtonEnabled() throws RemoteException {
        return this.f7940e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isRotateGesturesEnabled() throws RemoteException {
        return this.f7937b;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isScaleControlsEnabled() throws RemoteException {
        return this.f7944i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isScrollGesturesEnabled() throws RemoteException {
        return this.f7938c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isTiltGesturesEnabled() throws RemoteException {
        return this.f7939d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isZoomControlsEnabled() throws RemoteException {
        return this.f7942g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isZoomGesturesEnabled() throws RemoteException {
        return this.f7941f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isZoomInByScreenCenter() {
        return this.f7949n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void requestRefreshLogo() {
        this.f7951p.obtainMessage(6).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setAllGesturesEnabled(boolean z3) throws RemoteException {
        setRotateGesturesEnabled(z3);
        setTiltGesturesEnabled(z3);
        setZoomGesturesEnabled(z3);
        setScrollGesturesEnabled(z3);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setCompassEnabled(boolean z3) throws RemoteException {
        this.f7943h = z3;
        this.f7951p.obtainMessage(2).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setGestureScaleByMapCenter(boolean z3) throws RemoteException {
        this.f7950o = z3;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setIndoorSwitchEnabled(boolean z3) throws RemoteException {
        this.f7948m = z3;
        this.f7951p.obtainMessage(4).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoBottomMargin(int i4) {
        this.f7936a.setLogoBottomMargin(i4);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoEnable(boolean z3) {
        this.f7945j = z3;
        this.f7951p.obtainMessage(5).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoLeftMargin(int i4) {
        this.f7936a.setLogoLeftMargin(i4);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoMarginRate(int i4, float f4) {
        this.f7936a.setLogoMarginRate(i4, f4);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoPosition(int i4) throws RemoteException {
        this.f7946k = i4;
        this.f7936a.setLogoPosition(i4);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setMyLocationButtonEnabled(boolean z3) throws RemoteException {
        this.f7940e = z3;
        this.f7951p.obtainMessage(3).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setRotateGesturesEnabled(boolean z3) throws RemoteException {
        this.f7937b = z3;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setScaleControlsEnabled(boolean z3) throws RemoteException {
        this.f7944i = z3;
        this.f7951p.obtainMessage(1).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setScrollGesturesEnabled(boolean z3) throws RemoteException {
        this.f7938c = z3;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setTiltGesturesEnabled(boolean z3) throws RemoteException {
        this.f7939d = z3;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomControlsEnabled(boolean z3) throws RemoteException {
        this.f7942g = z3;
        this.f7951p.obtainMessage(0).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomGesturesEnabled(boolean z3) throws RemoteException {
        this.f7941f = z3;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomInByScreenCenter(boolean z3) {
        this.f7949n = z3;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomPosition(int i4) throws RemoteException {
        this.f7947l = i4;
        this.f7936a.setZoomPosition(i4);
    }
}
