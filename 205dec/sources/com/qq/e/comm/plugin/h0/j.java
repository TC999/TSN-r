package com.qq.e.comm.plugin.h0;

import android.text.TextUtils;
import com.qq.e.comm.plugin.n0.v;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class j {

    /* renamed from: a  reason: collision with root package name */
    private boolean f44047a = true;

    public void a(boolean z3) {
        this.f44047a = z3;
    }

    public void a(Thread thread) {
        StackTraceElement[] stackTrace = thread.getStackTrace();
        int length = stackTrace.length - 1;
        if (this.f44047a) {
            while (length >= 0) {
                String stackTraceElement = stackTrace[length].toString();
                if (stackTraceElement.startsWith("com.qq.e") || stackTraceElement.startsWith("com.tencent.ams") || stackTraceElement.startsWith("com.tencent.gatherer")) {
                    length = Math.min(length + 1, stackTrace.length - 1);
                    break;
                }
                length--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 <= length; i4++) {
            sb.append(stackTrace[i4].toString());
            sb.append("\r\n");
        }
        a(sb.toString());
    }

    private void a(String str) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        int i4 = !TextUtils.isEmpty(str) ? 1 : 0;
        if (i4 != 0) {
            dVar.a("msg", str);
        }
        com.qq.e.comm.plugin.n0.e eVar = new com.qq.e.comm.plugin.n0.e(9130010);
        eVar.d(i4 ^ 1);
        eVar.a(dVar);
        v.a(eVar);
    }
}
