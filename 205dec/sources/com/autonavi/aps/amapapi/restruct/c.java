package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CellAgeEstimator.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c extends a<d> {
    public c(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* bridge */ /* synthetic */ void a(d dVar, long j4) {
        a2(dVar, j4);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* synthetic */ String b(d dVar) {
        return a(dVar);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* synthetic */ int c(d dVar) {
        return b2(dVar);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* synthetic */ long d(d dVar) {
        return c2(dVar);
    }

    private static String a(d dVar) {
        return dVar == null ? "" : dVar.b();
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static int b2(d dVar) {
        if (dVar == null) {
            return 99;
        }
        return dVar.f11816s;
    }

    /* renamed from: c  reason: avoid collision after fix types in other method */
    private static long c2(d dVar) {
        if (dVar == null) {
            return 0L;
        }
        return dVar.f11817t;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(d dVar, long j4) {
        if (dVar != null) {
            dVar.f11817t = j4;
        }
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final long b() {
        return com.autonavi.aps.amapapi.config.a.f11736g;
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final long c() {
        return com.autonavi.aps.amapapi.config.a.f11737h;
    }
}
