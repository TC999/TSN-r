package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class VelocityGenerate {
    @JBindingExclude
    protected final int TYPE_DEFAULT = -1;
    @JBindingExclude
    protected final int TYPE_RANDOMVELOCITYBETWEENTWOCONSTANTS = 0;
    protected int type = -1;

    public abstract float getX();

    public abstract float getY();

    public abstract float getZ();
}
