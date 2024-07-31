package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class RotationOverLife {
    @JBindingExclude
    protected final int TYPE_DEFAULT = -1;
    @JBindingExclude
    protected final int TYPE_CONSTANTROTATIONOVERLIFE = 0;
    protected int type = -1;

    public abstract float getRotate();
}
