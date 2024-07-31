package com.tencent.open.log;

import android.util.Log;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.log.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C13044e extends Tracer {

    /* renamed from: a */
    public static final C13044e f37396a = new C13044e();

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (i == 1) {
            Log.v(str, str2, th);
        } else if (i == 2) {
            Log.d(str, str2, th);
        } else if (i == 4) {
            Log.i(str, str2, th);
        } else if (i == 8) {
            Log.w(str, str2, th);
        } else if (i == 16) {
            Log.e(str, str2, th);
        } else if (i != 32) {
        } else {
            Log.e(str, str2, th);
        }
    }
}
