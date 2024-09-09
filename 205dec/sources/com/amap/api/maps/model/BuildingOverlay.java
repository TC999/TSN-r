package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BuildingOverlay extends BaseOverlay {
    private BuildingOverlayTotalOptions buildingOverlayTotalOptions;
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private BuildingOverlayOptions mDefaultOptions;
    private List<BuildingOverlayOptions> optionList;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @JBindingInclude
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class BuildingOverlayTotalOptions extends BaseOptions {
        public List<BuildingOverlayOptions> allOptionList;
        public boolean isVisible = true;
        private float zIndex = 0.0f;

        public BuildingOverlayTotalOptions() {
            this.type = "BuildingOptions";
        }
    }

    public BuildingOverlay(IGlOverlayLayer iGlOverlayLayer, String str) {
        super(str);
        this.buildingOverlayTotalOptions = new BuildingOverlayTotalOptions();
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.buildingOverlayTotalOptions.allOptionList = new ArrayList();
        try {
            if (this.mDefaultOptions == null) {
                BuildingOverlayOptions buildingOverlayOptions = new BuildingOverlayOptions();
                this.mDefaultOptions = buildingOverlayOptions;
                buildingOverlayOptions.setVisible(true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new LatLng(84.9d, -179.9d));
                arrayList.add(new LatLng(84.9d, 179.9d));
                arrayList.add(new LatLng(-84.9d, 179.9d));
                arrayList.add(new LatLng(-84.9d, -179.9d));
                this.mDefaultOptions.setBuildingLatlngs(arrayList);
                this.mDefaultOptions.setBuildingTopColor(-65536);
                this.mDefaultOptions.setBuildingSideColor(-12303292);
                this.mDefaultOptions.setVisible(true);
                this.mDefaultOptions.setZIndex(1.0f);
                this.buildingOverlayTotalOptions.allOptionList.add(this.mDefaultOptions);
                a(true);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(boolean z3) {
        try {
            synchronized (this) {
                if (z3) {
                    this.buildingOverlayTotalOptions.allOptionList.set(0, this.mDefaultOptions);
                } else {
                    this.buildingOverlayTotalOptions.allOptionList.removeAll(this.optionList);
                    this.buildingOverlayTotalOptions.allOptionList.set(0, this.mDefaultOptions);
                    this.buildingOverlayTotalOptions.allOptionList.addAll(this.optionList);
                }
                IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
                if (iGlOverlayLayer != null) {
                    iGlOverlayLayer.updateOption(this.overlayName, this.buildingOverlayTotalOptions);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void destroy() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable unused) {
        }
    }

    public List<BuildingOverlayOptions> getCustomOptions() {
        return this.optionList;
    }

    public BuildingOverlayOptions getDefaultOptions() {
        return this.mDefaultOptions;
    }

    public String getId() {
        return this.overlayName;
    }

    public float getZIndex() {
        BuildingOverlayTotalOptions buildingOverlayTotalOptions = this.buildingOverlayTotalOptions;
        if (buildingOverlayTotalOptions != null) {
            return buildingOverlayTotalOptions.zIndex;
        }
        return 0.0f;
    }

    public boolean isVisible() {
        BuildingOverlayTotalOptions buildingOverlayTotalOptions = this.buildingOverlayTotalOptions;
        if (buildingOverlayTotalOptions != null) {
            return buildingOverlayTotalOptions.isVisible;
        }
        return false;
    }

    public void setCustomOptions(List<BuildingOverlayOptions> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        synchronized (this) {
            this.optionList = list;
        }
        a(false);
    }

    public void setDefaultOptions(BuildingOverlayOptions buildingOverlayOptions) {
        if (buildingOverlayOptions != null) {
            synchronized (this) {
                this.mDefaultOptions = buildingOverlayOptions;
            }
            a(true);
        }
    }

    public void setVisible(boolean z3) {
        BuildingOverlayTotalOptions buildingOverlayTotalOptions = this.buildingOverlayTotalOptions;
        if (buildingOverlayTotalOptions != null) {
            buildingOverlayTotalOptions.isVisible = z3;
            a();
        }
    }

    public void setZIndex(float f4) {
        BuildingOverlayOptions buildingOverlayOptions = this.mDefaultOptions;
        if (buildingOverlayOptions != null) {
            buildingOverlayOptions.setZIndex(f4);
        }
        BuildingOverlayTotalOptions buildingOverlayTotalOptions = this.buildingOverlayTotalOptions;
        if (buildingOverlayTotalOptions != null) {
            buildingOverlayTotalOptions.zIndex = f4;
            a();
        }
    }

    private void a() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.buildingOverlayTotalOptions);
        } catch (Throwable unused) {
        }
    }
}
