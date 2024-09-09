package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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

    public MultiPointOverlayOptions anchor(float f4, float f5) {
        this.anchorU = f4;
        this.anchorV = f5;
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

    public void setEnable(boolean z3) {
        this.enable = z3;
    }

    public void setMultiPointItems(List<MultiPointItem> list) {
        this.multiPointItems = list;
        this.multiPointItemsUpdated = true;
    }

    /* renamed from: clone */
    public MultiPointOverlayOptions m25clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e4) {
            e4.printStackTrace();
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
