package com.tencent.open.log;

import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class e extends Tracer {

    /* renamed from: a  reason: collision with root package name */
    public static final e f51796a = new e();

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i4, Thread thread, long j4, String str, String str2, Throwable th) {
        if (i4 == 1) {
            Log.v(str, str2, th);
        } else if (i4 == 2) {
            Log.d(str, str2, th);
        } else if (i4 == 4) {
            Log.i(str, str2, th);
        } else if (i4 == 8) {
            Log.w(str, str2, th);
        } else if (i4 == 16) {
            Log.e(str, str2, th);
        } else if (i4 != 32) {
        } else {
            Log.e(str, str2, th);
        }
    }
}
