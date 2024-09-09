package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.CrossOverlay;
import com.autonavi.base.ae.gmap.gloverlay.AVectorCrossAttr;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface ICrossVectorOverlay {
    void remove();

    void setAttribute(AVectorCrossAttr aVectorCrossAttr);

    int setData(byte[] bArr);

    void setGenerateCrossImageListener(CrossOverlay.GenerateCrossImageListener generateCrossImageListener);

    void setImageMode(boolean z3);

    void setOnCrossVectorUpdateListener(CrossOverlay.OnCrossVectorUpdateListener onCrossVectorUpdateListener);

    void setVisible(boolean z3);
}
