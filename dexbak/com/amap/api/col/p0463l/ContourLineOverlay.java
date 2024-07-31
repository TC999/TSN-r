package com.amap.api.col.p0463l;

import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import java.lang.ref.WeakReference;

/* renamed from: com.amap.api.col.3l.l3 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ContourLineOverlay extends BaseOverlay {

    /* renamed from: a */
    private ContourLineOptions f4658a;

    /* renamed from: b */
    private WeakReference<IGlOverlayLayer> f4659b;

    public ContourLineOverlay(IGlOverlayLayer iGlOverlayLayer, ContourLineOptions contourLineOptions, String str) {
        super(str);
        this.f4659b = new WeakReference<>(iGlOverlayLayer);
        this.f4658a = contourLineOptions;
    }
}
