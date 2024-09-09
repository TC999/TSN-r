package com.amap.api.col.p0003l;

import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ContourLineOverlay.java */
/* renamed from: com.amap.api.col.3l.l3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class l3 extends BaseOverlay {

    /* renamed from: a  reason: collision with root package name */
    private eo f8294a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<IGlOverlayLayer> f8295b;

    public l3(IGlOverlayLayer iGlOverlayLayer, eo eoVar, String str) {
        super(str);
        this.f8295b = new WeakReference<>(iGlOverlayLayer);
        this.f8294a = eoVar;
    }
}
