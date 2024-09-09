package com.qq.e.comm.plugin.util.u2;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f46620a;

    /* renamed from: d  reason: collision with root package name */
    protected String f46623d = getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final int f46621b = a();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Integer> f46622c = b();

    public b(boolean z3) {
        this.f46620a = z3;
    }

    protected abstract int a();

    int a(StackTraceElement[] stackTraceElementArr, String str, int i4) {
        if (!this.f46620a) {
            d1.a(this.f46623d, "control server is off");
            return -1;
        } else if (stackTraceElementArr == null) {
            d1.a(this.f46623d, "elements is null");
            return -1;
        } else {
            String a4 = a(stackTraceElementArr);
            if (TextUtils.isEmpty(a4)) {
                d1.a(this.f46623d, "elements string is null");
                return -1;
            }
            Pair<String, Integer> a5 = a(a4);
            if (a5 != null) {
                a((String) a5.first, a4, str, i4);
                return ((Integer) a5.second).intValue();
            }
            return -1;
        }
    }

    protected abstract Map<String, Integer> b();

    String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                sb.append("\t");
                sb.append(stackTraceElement);
            }
        }
        String sb2 = sb.toString();
        d1.a(this.f46623d, "stack is: " + sb2);
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Pair<String, Integer> a(String str) {
        if (this.f46622c.isEmpty()) {
            return null;
        }
        for (String str2 : this.f46622c.keySet()) {
            if (str.contains(str2)) {
                return new Pair<>(str2, this.f46622c.get(str2));
            }
        }
        return null;
    }

    private void a(String str, String str2, String str3, int i4) {
        com.qq.e.comm.plugin.n0.c cVar = new com.qq.e.comm.plugin.n0.c();
        cVar.c(str3);
        v.a(this.f46621b, cVar, Integer.valueOf(i4), new com.qq.e.comm.plugin.n0.d().a("package", str).a("trace", str2));
    }
}
