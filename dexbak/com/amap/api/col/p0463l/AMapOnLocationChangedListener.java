package com.amap.api.col.p0463l;

import android.location.Location;
import com.amap.api.maps.LocationSource;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.col.3l.x9 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AMapOnLocationChangedListener implements LocationSource.OnLocationChangedListener {

    /* renamed from: a */
    private IAMapDelegate f5712a;

    /* renamed from: b */
    Location f5713b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AMapOnLocationChangedListener(IAMapDelegate iAMapDelegate) {
        this.f5712a = iAMapDelegate;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(Location location) {
        this.f5713b = location;
        try {
            if (this.f5712a.isMyLocationEnabled()) {
                this.f5712a.showMyLocationOverlay(location);
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapOnLocationChangedListener", "onLocationChanged");
            th.printStackTrace();
        }
    }
}
