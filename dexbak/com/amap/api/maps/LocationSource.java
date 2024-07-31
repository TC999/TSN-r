package com.amap.api.maps;

import android.location.Location;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface LocationSource {

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnLocationChangedListener {
        void onLocationChanged(Location location);
    }

    void activate(OnLocationChangedListener onLocationChangedListener);

    void deactivate();
}
