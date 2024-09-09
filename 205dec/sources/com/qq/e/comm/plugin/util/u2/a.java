package com.qq.e.comm.plugin.util.u2;

import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final String f46616a = getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final String[] f46617b = c();

    /* renamed from: c  reason: collision with root package name */
    private final int f46618c = b();

    /* renamed from: d  reason: collision with root package name */
    private final boolean f46619d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(boolean z3) {
        this.f46619d = z3;
    }

    void a() {
        String[] strArr;
        if (this.f46619d && (strArr = this.f46617b) != null && strArr.length > 0) {
            for (String str : strArr) {
                try {
                    Class.forName(str);
                    d1.a(this.f46616a + "there is a class\uff1a" + str, new Object[0]);
                    a(str);
                } catch (ClassNotFoundException unused) {
                    d1.a(this.f46616a + "there is not\uff1a" + str, new Object[0]);
                }
            }
        }
    }

    protected abstract int b();

    protected abstract String[] c();

    private void a(String str) {
        v.a(this.f46618c, null, null, null, new com.qq.e.comm.plugin.n0.d().a("adapter", str));
    }
}
