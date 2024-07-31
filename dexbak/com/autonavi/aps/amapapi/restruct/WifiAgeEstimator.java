package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0463l.AmapWifi;
import com.autonavi.aps.amapapi.config.Const;

/* renamed from: com.autonavi.aps.amapapi.restruct.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class WifiAgeEstimator extends AgeEstimator<AmapWifi> {
    public WifiAgeEstimator(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    /* renamed from: a */
    final /* bridge */ /* synthetic */ void mo51506a(AmapWifi amapWifi, long j) {
        m51507a(amapWifi, j);
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    /* renamed from: b */
    public final /* synthetic */ String mo51503b(AmapWifi amapWifi) {
        return m51508a(amapWifi);
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    /* renamed from: c */
    final /* synthetic */ int mo51500c(AmapWifi amapWifi) {
        return m51504b(amapWifi);
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    /* renamed from: d */
    final /* synthetic */ long mo51499d(AmapWifi amapWifi) {
        return m51501c(amapWifi);
    }

    /* renamed from: a */
    private static String m51508a(AmapWifi amapWifi) {
        return amapWifi == null ? "" : amapWifi.m54647b();
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static int m51504b(AmapWifi amapWifi) {
        if (amapWifi == null) {
            return -113;
        }
        return amapWifi.f4586c;
    }

    /* renamed from: c  reason: avoid collision after fix types in other method */
    private static long m51501c(AmapWifi amapWifi) {
        if (amapWifi == null) {
            return 0L;
        }
        return amapWifi.f4589f;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m51507a(AmapWifi amapWifi, long j) {
        if (amapWifi != null) {
            amapWifi.f4589f = j;
        }
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    /* renamed from: b */
    final long mo51505b() {
        return Const.f8057e;
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    /* renamed from: c */
    final long mo51502c() {
        return Const.f8058f;
    }
}
