package com.amap.api.maps.model;

import android.graphics.Point;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BuildingOverlayOptions extends BaseOptions {
    private int[] buildingLatlngsPoints;
    private float zindex;
    private int buildingHeight = -1;
    private int buildingHeightScale = 1;
    private int buildingTopColor = -7829368;
    private int buildingSideColor = -7829368;
    private boolean isVisible = true;
    private List<LatLng> buildingLatlngs = new ArrayList();

    public int getBuildingHeight() {
        return this.buildingHeight;
    }

    public int getBuildingHeightScale() {
        return this.buildingHeightScale;
    }

    public List<LatLng> getBuildingLatlngs() {
        return this.buildingLatlngs;
    }

    public int getBuildingSideColor() {
        return this.buildingSideColor;
    }

    public int getBuildingTopColor() {
        return this.buildingTopColor;
    }

    public synchronized int[] getPoints() {
        List<LatLng> list = this.buildingLatlngs;
        if (list == null || list.size() <= 0) {
            return new int[0];
        }
        int[] iArr = new int[this.buildingLatlngs.size() * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < this.buildingLatlngs.size(); i5++) {
            LatLng latLng = this.buildingLatlngs.get(i5);
            if (latLng != null) {
                Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                int i6 = i4 + 1;
                iArr[i4] = latLongToPixels.x;
                i4 = i6 + 1;
                iArr[i6] = latLongToPixels.y;
            }
        }
        return iArr;
    }

    public float getZIndex() {
        return this.zindex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public BuildingOverlayOptions setBuildingHeight(int i4) {
        this.buildingHeight = i4;
        return this;
    }

    public BuildingOverlayOptions setBuildingHeightScale(int i4) {
        this.buildingHeightScale = i4;
        return this;
    }

    public synchronized BuildingOverlayOptions setBuildingLatlngs(List<LatLng> list) {
        this.buildingLatlngs = list;
        if (list != null && list.size() > 0) {
            this.buildingLatlngsPoints = new int[list.size() * 2];
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                LatLng latLng = list.get(i5);
                Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                int[] iArr = this.buildingLatlngsPoints;
                int i6 = i4 + 1;
                iArr[i4] = latLongToPixels.x;
                i4 = i6 + 1;
                iArr[i6] = latLongToPixels.y;
            }
        }
        return this;
    }

    public BuildingOverlayOptions setBuildingSideColor(int i4) {
        this.buildingSideColor = i4;
        return this;
    }

    public BuildingOverlayOptions setBuildingTopColor(int i4) {
        this.buildingTopColor = i4;
        return this;
    }

    public void setVisible(boolean z3) {
        this.isVisible = z3;
    }

    public void setZIndex(float f4) {
        this.zindex = f4;
    }
}
