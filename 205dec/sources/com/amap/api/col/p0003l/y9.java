package com.amap.api.col.p0003l;

import android.location.Location;
import com.amap.api.maps.LocationSource;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AMapOnLocationChangedListener.java */
/* renamed from: com.amap.api.col.3l.y9  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class y9 implements LocationSource.OnLocationChangedListener {

    /* renamed from: a  reason: collision with root package name */
    private IAMapDelegate f9554a;

    /* renamed from: b  reason: collision with root package name */
    Location f9555b;

    /* compiled from: AmapDelegateListenerManager.java */
    /* renamed from: com.amap.api.col.3l.y9$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public List<T> f9556a = Collections.synchronizedList(new ArrayList());

        /* renamed from: b  reason: collision with root package name */
        public T f9557b = null;

        public a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y9(IAMapDelegate iAMapDelegate) {
        this.f9554a = iAMapDelegate;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(Location location) {
        this.f9555b = location;
        try {
            if (this.f9554a.isMyLocationEnabled()) {
                this.f9554a.showMyLocationOverlay(location);
            }
        } catch (Throwable th) {
            u5.p(th, "AMapOnLocationChangedListener", "onLocationChanged");
            th.printStackTrace();
        }
    }
}
