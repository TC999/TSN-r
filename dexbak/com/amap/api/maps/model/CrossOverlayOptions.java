package com.amap.api.maps.model;

import android.graphics.Bitmap;
import com.autonavi.base.p048ae.gmap.gloverlay.AVectorCrossAttr;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CrossOverlayOptions {

    /* renamed from: a */
    AVectorCrossAttr f7032a = null;
    private Bitmap bitmapDescriptor = null;

    public AVectorCrossAttr getAttribute() {
        return this.f7032a;
    }

    public Bitmap getRes() {
        return this.bitmapDescriptor;
    }

    public CrossOverlayOptions setAttribute(AVectorCrossAttr aVectorCrossAttr) {
        this.f7032a = aVectorCrossAttr;
        return this;
    }

    public CrossOverlayOptions setRes(Bitmap bitmap) {
        this.bitmapDescriptor = bitmap;
        return this;
    }
}
