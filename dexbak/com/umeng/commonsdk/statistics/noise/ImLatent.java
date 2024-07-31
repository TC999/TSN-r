package com.umeng.commonsdk.statistics.noise;

import android.content.Context;
import com.kuaishou.weapon.p205p0.C7193bi;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.commonsdk.statistics.BusinessWrapperConfig;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.StoreHelper;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.OnImprintChangedListener;
import com.umeng.commonsdk.statistics.internal.StatTracer;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ImLatent implements OnImprintChangedListener {
    private static ImLatent instanse;
    private Context context;
    private StatTracer statTracer;
    private StoreHelper storeHelper;
    private final int _DEFAULT_HOURS = 360;
    private final int _DEFAULT_MIN_HOURS = 36;
    private final int _DEFAULT_MIN_LATENT = 1;
    private final int _DEFAULT_MAX_LATENT = 1800;
    private final long _ONE_HOURS_IN_MS = C7193bi.f24584s;
    private final long _360HOURS_IN_MS = 1296000000;
    private final long _36HOURS_IN_MS = 129600000;
    private final int LATENT_MAX = 1800000;
    private final int LATENT_WINDOW = 10;
    private long latentHour = 1296000000;
    private int latentWindow = 10;
    private long mDelay = 0;
    private long mElapsed = 0;
    private boolean mLatentActivite = false;
    private Object mLatentLock = new Object();

    private ImLatent(Context context, StatTracer statTracer) {
        this.context = context;
        this.storeHelper = StoreHelper.m13749a(context);
        this.statTracer = statTracer;
    }

    public static synchronized ImLatent getService(Context context, StatTracer statTracer) {
        ImLatent imLatent;
        synchronized (ImLatent.class) {
            if (instanse == null) {
                ImLatent imLatent2 = new ImLatent(context, statTracer);
                instanse = imLatent2;
                imLatent2.onImprintChanged(ImprintHandler.getImprintService(context).m13729c());
            }
            imLatent = instanse;
        }
        return imLatent;
    }

    public long getDelayTime() {
        long j;
        synchronized (this.mLatentLock) {
            j = this.mDelay;
        }
        return j;
    }

    public long getElapsedTime() {
        return this.mElapsed;
    }

    public boolean isLatentActivite() {
        boolean z;
        synchronized (this.mLatentLock) {
            z = this.mLatentActivite;
        }
        return z;
    }

    public void latentDeactivite() {
        synchronized (this.mLatentLock) {
            this.mLatentActivite = false;
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.OnImprintChangedListener
    public void onImprintChanged(ImprintHandler.C13252a c13252a) {
        int intValue = Integer.valueOf(c13252a.m13721a("latent_hours", String.valueOf(360))).intValue();
        this.latentHour = (intValue > 36 ? intValue : 360) * C7193bi.f24584s;
        int intValue2 = Integer.valueOf(c13252a.m13721a(UMCommonContent.f37792aV, "0")).intValue();
        intValue2 = (intValue2 < 1 || intValue2 > 1800) ? 0 : 0;
        if (intValue2 == 0) {
            int i = BusinessWrapperConfig.f38916c;
            if (i > 0 && i <= 1800000) {
                this.latentWindow = i;
                return;
            } else {
                this.latentWindow = 10;
                return;
            }
        }
        this.latentWindow = intValue2;
    }

    public boolean shouldStartLatency() {
        if (this.storeHelper.m13745c() || this.statTracer.isFirstRequest()) {
            return false;
        }
        synchronized (this.mLatentLock) {
            if (this.mLatentActivite) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.statTracer.getLastReqTime();
            if (currentTimeMillis > this.latentHour) {
                String signature = Envelope.getSignature(this.context);
                synchronized (this.mLatentLock) {
                    this.mDelay = DataHelper.random(this.latentWindow, signature);
                    this.mElapsed = currentTimeMillis;
                    this.mLatentActivite = true;
                }
                return true;
            } else if (currentTimeMillis > 129600000) {
                synchronized (this.mLatentLock) {
                    this.mDelay = 0L;
                    this.mElapsed = currentTimeMillis;
                    this.mLatentActivite = true;
                }
                return true;
            } else {
                return false;
            }
        }
    }
}
