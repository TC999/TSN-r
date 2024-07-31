package com.amap.api.col.p0463l;

import android.os.RemoteException;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* renamed from: com.amap.api.col.3l.q1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class NativeBaseTileOverlay {

    /* renamed from: a */
    private final IAMapDelegate f5099a;

    /* renamed from: b */
    private TileOverlay f5100b;

    /* renamed from: c */
    private TileOverlay f5101c;

    /* renamed from: d */
    private boolean f5102d = false;

    /* renamed from: e */
    private boolean f5103e = false;

    public NativeBaseTileOverlay(IAMapDelegate iAMapDelegate) {
        this.f5099a = iAMapDelegate;
    }

    /* renamed from: b */
    private void m54153b() {
        if (this.f5100b == null) {
            TileOverlayOptions tileProvider = new TileOverlayOptions().tileProvider(new BaseTileProvider(this.f5099a.getMapConfig()));
            tileProvider.memCacheSize(10485760);
            tileProvider.diskCacheSize(20480);
            tileProvider.visible(this.f5102d);
            try {
                this.f5100b = this.f5099a.addTileOverlay(tileProvider);
                this.f5101c = this.f5099a.addTileOverlay(tileProvider);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private void m54152c() {
        boolean m54150e = m54150e();
        if (m54150e) {
            m54153b();
        }
        if (this.f5102d != m54150e) {
            this.f5102d = m54150e;
            TileOverlay tileOverlay = this.f5100b;
            if (tileOverlay != null) {
                tileOverlay.setVisible(m54150e);
            }
        }
    }

    /* renamed from: d */
    private void m54151d() {
        boolean m54149f = m54149f();
        if (m54149f) {
            m54153b();
        }
        if (this.f5103e != m54149f) {
            this.f5103e = m54149f;
            TileOverlay tileOverlay = this.f5101c;
            if (tileOverlay != null) {
                tileOverlay.setVisible(m54149f);
            }
        }
    }

    /* renamed from: e */
    private boolean m54150e() {
        IAMapDelegate iAMapDelegate = this.f5099a;
        if (iAMapDelegate == null) {
            return false;
        }
        return iAMapDelegate.getMapConfig().getMapLanguage().equals("en");
    }

    /* renamed from: f */
    private static boolean m54149f() {
        return MapsInitializer.isLoadWorldGridMap();
    }

    /* renamed from: a */
    public final void m54154a() {
        m54152c();
        m54151d();
    }
}
