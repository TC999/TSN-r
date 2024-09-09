package com.amap.api.maps.model;

import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class MVTTileOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private MVTTileOverlayOptions mMVTTileOverlayOptions;

    public MVTTileOverlay(IGlOverlayLayer iGlOverlayLayer, MVTTileOverlayOptions mVTTileOverlayOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.mMVTTileOverlayOptions = mVTTileOverlayOptions;
        if (mVTTileOverlayOptions != null) {
            mVTTileOverlayOptions.getTileProviderInner().init(iGlOverlayLayer, str);
        }
    }

    public final float getZIndex() {
        return this.mMVTTileOverlayOptions.getZIndex();
    }

    public final void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public final void setVisible(boolean z3) {
        this.mMVTTileOverlayOptions.setVisible(z3);
        updateOption();
    }

    public final void setZIndex(float f4) {
        this.mMVTTileOverlayOptions.setZIndex(f4);
        updateOption();
    }

    protected final void updateOption() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.mMVTTileOverlayOptions);
        } catch (Throwable unused) {
        }
    }

    public final boolean visible() {
        return this.mMVTTileOverlayOptions.visible();
    }
}
