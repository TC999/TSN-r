package com.tencent.open.log;

import android.text.format.Time;
import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f51799a = new g();

    public final String a(int i4) {
        return i4 != 1 ? i4 != 2 ? i4 != 4 ? i4 != 8 ? i4 != 16 ? i4 != 32 ? "-" : "A" : "E" : "W" : "I" : "D" : "V";
    }

    public String a(int i4, Thread thread, long j4, String str, String str2, Throwable th) {
        long j5 = j4 % 1000;
        Time time = new Time();
        time.set(j4);
        StringBuilder sb = new StringBuilder();
        sb.append(a(i4));
        sb.append('/');
        sb.append(time.format("%Y-%m-%d %H:%M:%S"));
        sb.append('.');
        if (j5 < 10) {
            sb.append("00");
        } else if (j5 < 100) {
            sb.append('0');
        }
        sb.append(j5);
        sb.append(' ');
        sb.append('[');
        if (thread == null) {
            sb.append("N/A");
        } else {
            sb.append(thread.getName());
        }
        sb.append(']');
        sb.append('[');
        sb.append(str);
        sb.append(']');
        sb.append(' ');
        sb.append(str2);
        sb.append('\n');
        if (th != null) {
            sb.append("* Exception : \n");
            sb.append(Log.getStackTraceString(th));
            sb.append('\n');
        }
        return sb.toString();
    }
}
