package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class ParticleShapeModule {
    @JBindingExclude
    protected final int TYPE_DEFAULT = -1;
    @JBindingExclude
    protected final int TYPE_SINGLEPOINT = 0;
    @JBindingExclude
    protected final int TYPE_RECT = 1;
    protected int type = -1;
    protected boolean isUseRatio = false;

    public abstract float[] getPoint();

    public boolean isUseRatio() {
        return this.isUseRatio;
    }
}
