package com.amap.api.maps.model;

import android.graphics.Bitmap;
import com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay;
import com.autonavi.base.p048ae.gmap.gloverlay.AVectorCrossAttr;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CrossOverlay {
    public static final int UPDATE_TYPE_DATA = 0;

    /* renamed from: a */
    ICrossVectorOverlay f7031a;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface GenerateCrossImageListener {
        void onGenerateComplete(Bitmap bitmap, int i);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnCrossVectorUpdateListener {
        void onUpdate(int i, UpdateItem updateItem);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class UpdateItem {
        public int dataUpdateFlag = -1;
    }

    public CrossOverlay(CrossOverlayOptions crossOverlayOptions, ICrossVectorOverlay iCrossVectorOverlay) {
        this.f7031a = iCrossVectorOverlay;
    }

    public void remove() {
        ICrossVectorOverlay iCrossVectorOverlay = this.f7031a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.remove();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setAttribute(AVectorCrossAttr aVectorCrossAttr) {
        try {
            this.f7031a.setAttribute(aVectorCrossAttr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int setData(byte[] bArr) {
        ICrossVectorOverlay iCrossVectorOverlay;
        if (bArr == null || (iCrossVectorOverlay = this.f7031a) == null) {
            return 0;
        }
        try {
            iCrossVectorOverlay.setData(bArr);
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public void setGenerateCrossImageListener(GenerateCrossImageListener generateCrossImageListener) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f7031a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setGenerateCrossImageListener(generateCrossImageListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setImageMode(boolean z) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f7031a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setImageMode(z);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setOnCrossVectorUpdateListener(OnCrossVectorUpdateListener onCrossVectorUpdateListener) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f7031a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setOnCrossVectorUpdateListener(onCrossVectorUpdateListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setVisible(boolean z) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f7031a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setVisible(z);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
