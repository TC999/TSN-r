package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.List;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MultiPointOverlayOptions extends BaseOptions implements Cloneable {
    @JBindingInclude
    private BitmapDescriptor bitmapDescriptor;
    @JBindingInclude
    private List<MultiPointItem> multiPointItems;
    @JBindingInclude
    private boolean multiPointItemsUpdated;
    @JBindingInclude
    private float anchorU = 0.5f;
    @JBindingInclude
    private float anchorV = 0.5f;
    @JBindingInclude
    private boolean enable = true;

    public MultiPointOverlayOptions() {
        this.type = "MultiPointOverlayOptions";
    }

    public MultiPointOverlayOptions anchor(float f, float f2) {
        this.anchorU = f;
        this.anchorV = f2;
        return this;
    }

    public float getAnchorU() {
        return this.anchorU;
    }

    public float getAnchorV() {
        return this.anchorV;
    }

    public BitmapDescriptor getIcon() {
        return this.bitmapDescriptor;
    }

    public List<MultiPointItem> getMultiPointItems() {
        return this.multiPointItems;
    }

    public MultiPointOverlayOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.bitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setMultiPointItems(List<MultiPointItem> list) {
        this.multiPointItems = list;
        this.multiPointItemsUpdated = true;
    }

    /* renamed from: clone */
    public MultiPointOverlayOptions m60104clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        MultiPointOverlayOptions multiPointOverlayOptions = new MultiPointOverlayOptions();
        multiPointOverlayOptions.bitmapDescriptor = this.bitmapDescriptor;
        multiPointOverlayOptions.anchorU = this.anchorU;
        multiPointOverlayOptions.anchorV = this.anchorV;
        multiPointOverlayOptions.multiPointItemsUpdated = this.multiPointItemsUpdated;
        multiPointOverlayOptions.multiPointItems = this.multiPointItems;
        multiPointOverlayOptions.enable = this.enable;
        return multiPointOverlayOptions;
    }
}
