package com.p518qq.p519e.comm.p520pi;

import com.p518qq.p519e.ads.nativ.ADSize;
import com.p518qq.p519e.comm.adevent.ADListener;

/* renamed from: com.qq.e.comm.pi.NEADVI */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface NEADVI extends LADI {
    void destroy();

    void preloadVideo();

    void render();

    void reportAdNegative();

    void setAdListener(ADListener aDListener);

    void setAdSize(ADSize aDSize);
}
