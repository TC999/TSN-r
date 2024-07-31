package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.CrossOverlay;
import com.autonavi.base.p048ae.gmap.gloverlay.AVectorCrossAttr;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface ICrossVectorOverlay {
    void remove();

    void setAttribute(AVectorCrossAttr aVectorCrossAttr);

    int setData(byte[] bArr);

    void setGenerateCrossImageListener(CrossOverlay.GenerateCrossImageListener generateCrossImageListener);

    void setImageMode(boolean z);

    void setOnCrossVectorUpdateListener(CrossOverlay.OnCrossVectorUpdateListener onCrossVectorUpdateListener);

    void setVisible(boolean z);
}
