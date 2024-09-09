package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class SizeOverLife {
    @JBindingExclude
    protected final int TYPE_DEFAULT = -1;
    @JBindingExclude
    protected final int TYPE_CURVESIZEOVERLIFE = 0;
    protected int type = -1;
    @JBindingExclude
    public final int DEFAULT_SIZE = 0;

    public abstract float getSizeX(float f4);

    public abstract float getSizeY(float f4);

    public abstract float getSizeZ(float f4);
}
