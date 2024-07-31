package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import com.autonavi.aps.amapapi.config.Const;

/* renamed from: com.autonavi.aps.amapapi.restruct.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CellAgeEstimator extends AgeEstimator<Cgi> {
    public CellAgeEstimator(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    /* renamed from: a */
    final /* bridge */ /* synthetic */ void mo51506a(Cgi cgi, long j) {
        m51582a(cgi, j);
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    /* renamed from: b */
    public final /* synthetic */ String mo51503b(Cgi cgi) {
        return m51583a(cgi);
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    /* renamed from: c */
    final /* synthetic */ int mo51500c(Cgi cgi) {
        return m51581b(cgi);
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    /* renamed from: d */
    final /* synthetic */ long mo51499d(Cgi cgi) {
        return m51580c(cgi);
    }

    /* renamed from: a */
    private static String m51583a(Cgi cgi) {
        return cgi == null ? "" : cgi.m51578b();
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static int m51581b(Cgi cgi) {
        if (cgi == null) {
            return 99;
        }
        return cgi.f8139s;
    }

    /* renamed from: c  reason: avoid collision after fix types in other method */
    private static long m51580c(Cgi cgi) {
        if (cgi == null) {
            return 0L;
        }
        return cgi.f8140t;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m51582a(Cgi cgi, long j) {
        if (cgi != null) {
            cgi.f8140t = j;
        }
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    /* renamed from: b */
    final long mo51505b() {
        return Const.f8059g;
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    /* renamed from: c */
    final long mo51502c() {
        return Const.f8060h;
    }
}
