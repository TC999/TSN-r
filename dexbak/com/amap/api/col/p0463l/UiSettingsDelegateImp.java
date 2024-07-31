package com.amap.api.col.p0463l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.col.3l.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class UiSettingsDelegateImp implements IUiSettingsDelegate {

    /* renamed from: a */
    private IAMapDelegate f4367a;

    /* renamed from: b */
    private boolean f4368b = true;

    /* renamed from: c */
    private boolean f4369c = true;

    /* renamed from: d */
    private boolean f4370d = true;

    /* renamed from: e */
    private boolean f4371e = false;

    /* renamed from: f */
    private boolean f4372f = true;

    /* renamed from: g */
    private boolean f4373g = true;

    /* renamed from: h */
    private boolean f4374h = true;

    /* renamed from: i */
    private boolean f4375i = false;

    /* renamed from: j */
    private boolean f4376j = true;

    /* renamed from: k */
    private int f4377k = 0;

    /* renamed from: l */
    private int f4378l = 1;

    /* renamed from: m */
    private boolean f4379m = true;

    /* renamed from: n */
    private boolean f4380n = false;

    /* renamed from: o */
    private boolean f4381o = false;

    /* renamed from: p */
    final Handler f4382p = new HandlerC1828a(Looper.getMainLooper());

    /* compiled from: UiSettingsDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.h$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class HandlerC1828a extends Handler {
        HandlerC1828a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message == null || UiSettingsDelegateImp.this.f4367a == null) {
                return;
            }
            try {
                switch (message.what) {
                    case 0:
                        UiSettingsDelegateImp.this.f4367a.showZoomControlsEnabled(UiSettingsDelegateImp.this.f4373g);
                        return;
                    case 1:
                        UiSettingsDelegateImp.this.f4367a.showScaleEnabled(UiSettingsDelegateImp.this.f4375i);
                        return;
                    case 2:
                        UiSettingsDelegateImp.this.f4367a.showCompassEnabled(UiSettingsDelegateImp.this.f4374h);
                        return;
                    case 3:
                        UiSettingsDelegateImp.this.f4367a.showMyLocationButtonEnabled(UiSettingsDelegateImp.this.f4371e);
                        return;
                    case 4:
                        UiSettingsDelegateImp.this.f4367a.showIndoorSwitchControlsEnabled(UiSettingsDelegateImp.this.f4379m);
                        return;
                    case 5:
                        UiSettingsDelegateImp.this.f4367a.showLogoEnabled(UiSettingsDelegateImp.this.f4376j);
                        return;
                    case 6:
                        UiSettingsDelegateImp.this.f4367a.refreshLogo();
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "UiSettingsDelegateImp", "handleMessage");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UiSettingsDelegateImp(IAMapDelegate iAMapDelegate) {
        this.f4367a = iAMapDelegate;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final float getLogoMarginRate(int i) {
        return this.f4367a.getLogoMarginRate(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final int getLogoPosition() throws RemoteException {
        return this.f4377k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final int getZoomPosition() throws RemoteException {
        return this.f4378l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isCompassEnabled() throws RemoteException {
        return this.f4374h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isGestureScaleByMapCenter() throws RemoteException {
        return this.f4381o;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isIndoorSwitchEnabled() throws RemoteException {
        return this.f4379m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isLogoEnable() {
        return this.f4376j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isMyLocationButtonEnabled() throws RemoteException {
        return this.f4371e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isRotateGesturesEnabled() throws RemoteException {
        return this.f4368b;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isScaleControlsEnabled() throws RemoteException {
        return this.f4375i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isScrollGesturesEnabled() throws RemoteException {
        return this.f4369c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isTiltGesturesEnabled() throws RemoteException {
        return this.f4370d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isZoomControlsEnabled() throws RemoteException {
        return this.f4373g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isZoomGesturesEnabled() throws RemoteException {
        return this.f4372f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isZoomInByScreenCenter() {
        return this.f4380n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void requestRefreshLogo() {
        this.f4382p.obtainMessage(6).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setAllGesturesEnabled(boolean z) throws RemoteException {
        setRotateGesturesEnabled(z);
        setTiltGesturesEnabled(z);
        setZoomGesturesEnabled(z);
        setScrollGesturesEnabled(z);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setCompassEnabled(boolean z) throws RemoteException {
        this.f4374h = z;
        this.f4382p.obtainMessage(2).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setGestureScaleByMapCenter(boolean z) throws RemoteException {
        this.f4381o = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setIndoorSwitchEnabled(boolean z) throws RemoteException {
        this.f4379m = z;
        this.f4382p.obtainMessage(4).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoBottomMargin(int i) {
        this.f4367a.setLogoBottomMargin(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoEnable(boolean z) {
        this.f4376j = z;
        this.f4382p.obtainMessage(5).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoLeftMargin(int i) {
        this.f4367a.setLogoLeftMargin(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoMarginRate(int i, float f) {
        this.f4367a.setLogoMarginRate(i, f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoPosition(int i) throws RemoteException {
        this.f4377k = i;
        this.f4367a.setLogoPosition(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setMyLocationButtonEnabled(boolean z) throws RemoteException {
        this.f4371e = z;
        this.f4382p.obtainMessage(3).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setRotateGesturesEnabled(boolean z) throws RemoteException {
        this.f4368b = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setScaleControlsEnabled(boolean z) throws RemoteException {
        this.f4375i = z;
        this.f4382p.obtainMessage(1).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setScrollGesturesEnabled(boolean z) throws RemoteException {
        this.f4369c = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setTiltGesturesEnabled(boolean z) throws RemoteException {
        this.f4370d = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomControlsEnabled(boolean z) throws RemoteException {
        this.f4373g = z;
        this.f4382p.obtainMessage(0).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomGesturesEnabled(boolean z) throws RemoteException {
        this.f4372f = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomInByScreenCenter(boolean z) {
        this.f4380n = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomPosition(int i) throws RemoteException {
        this.f4378l = i;
        this.f4367a.setZoomPosition(i);
    }
}
