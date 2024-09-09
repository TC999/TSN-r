package com.amap.api.col.p0003l;

import android.os.RemoteException;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NativeBaseTileOverlay.java */
/* renamed from: com.amap.api.col.3l.q1  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class q1 {

    /* renamed from: a  reason: collision with root package name */
    private final IAMapDelegate f8822a;

    /* renamed from: b  reason: collision with root package name */
    private TileOverlay f8823b;

    /* renamed from: c  reason: collision with root package name */
    private TileOverlay f8824c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8825d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8826e = false;

    public q1(IAMapDelegate iAMapDelegate) {
        this.f8822a = iAMapDelegate;
    }

    private void b() {
        if (this.f8823b == null) {
            TileOverlayOptions tileProvider = new TileOverlayOptions().tileProvider(new i2(this.f8822a.getMapConfig()));
            tileProvider.memCacheSize(10485760);
            tileProvider.diskCacheSize(20480);
            tileProvider.visible(this.f8825d);
            try {
                this.f8823b = this.f8822a.addTileOverlay(tileProvider);
                this.f8824c = this.f8822a.addTileOverlay(tileProvider);
            } catch (RemoteException e4) {
                e4.printStackTrace();
            }
        }
    }

    private void c() {
        boolean e4 = e();
        if (e4) {
            b();
        }
        if (this.f8825d != e4) {
            this.f8825d = e4;
            TileOverlay tileOverlay = this.f8823b;
            if (tileOverlay != null) {
                tileOverlay.setVisible(e4);
            }
        }
    }

    private void d() {
        boolean f4 = f();
        if (f4) {
            b();
        }
        if (this.f8826e != f4) {
            this.f8826e = f4;
            TileOverlay tileOverlay = this.f8824c;
            if (tileOverlay != null) {
                tileOverlay.setVisible(f4);
            }
        }
    }

    private boolean e() {
        IAMapDelegate iAMapDelegate = this.f8822a;
        if (iAMapDelegate == null) {
            return false;
        }
        return iAMapDelegate.getMapConfig().getMapLanguage().equals("en");
    }

    private static boolean f() {
        return MapsInitializer.isLoadWorldGridMap();
    }

    public final void a() {
        c();
        d();
    }
}
