package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0003l.k9;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: WifiAgeEstimator.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i extends a<k9> {
    public i(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* bridge */ /* synthetic */ void a(k9 k9Var, long j4) {
        a2(k9Var, j4);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* synthetic */ String b(k9 k9Var) {
        return a(k9Var);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* synthetic */ int c(k9 k9Var) {
        return b2(k9Var);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* synthetic */ long d(k9 k9Var) {
        return c2(k9Var);
    }

    private static String a(k9 k9Var) {
        return k9Var == null ? "" : k9Var.b();
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static int b2(k9 k9Var) {
        if (k9Var == null) {
            return -113;
        }
        return k9Var.f8255c;
    }

    /* renamed from: c  reason: avoid collision after fix types in other method */
    private static long c2(k9 k9Var) {
        if (k9Var == null) {
            return 0L;
        }
        return k9Var.f8258f;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(k9 k9Var, long j4) {
        if (k9Var != null) {
            k9Var.f8258f = j4;
        }
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final long b() {
        return com.autonavi.aps.amapapi.config.a.f11734e;
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final long c() {
        return com.autonavi.aps.amapapi.config.a.f11735f;
    }
}
