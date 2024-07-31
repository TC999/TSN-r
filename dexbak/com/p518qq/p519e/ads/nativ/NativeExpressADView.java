package com.p518qq.p519e.ads.nativ;

import android.content.Context;
import android.widget.FrameLayout;
import com.p518qq.p519e.comm.compliance.DownloadConfirmListener;
import com.p518qq.p519e.comm.p520pi.AdData;
import com.p518qq.p519e.comm.p520pi.LADI;
import com.p518qq.p519e.comm.p520pi.NFBI;

/* renamed from: com.qq.e.ads.nativ.NativeExpressADView */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class NativeExpressADView extends FrameLayout implements DownloadConfirmListener, LADI, NFBI {

    /* renamed from: com.qq.e.ads.nativ.NativeExpressADView$ViewBindStatusListener */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    public NativeExpressADView(Context context) {
        super(context);
    }

    public abstract void destroy();

    public abstract AdData getBoundData();

    public abstract void negativeFeedback();

    public abstract void preloadVideo();

    public abstract void render();

    @Deprecated
    public abstract void setAdSize(ADSize aDSize);

    public abstract void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener);

    public abstract void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener);
}
