package com.qq.e.comm.plugin.dl;

import com.qq.e.comm.plugin.t.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    static int f42441a;

    /* renamed from: b  reason: collision with root package name */
    static final boolean f42442b;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements c.b<Integer> {
        a() {
        }

        @Override // com.qq.e.comm.plugin.t.c.b
        public void a(boolean z3, Integer num, boolean z4, Integer num2) {
            if (!z4 || num2 == null) {
                return;
            }
            h.f42441a = (num.intValue() * 10) + num2.intValue();
        }
    }

    static {
        f42442b = com.qq.e.comm.plugin.t.c.a("evnll", "", 0, com.qq.e.comm.plugin.t.a.b().a(), new a()) == 0;
    }
}
