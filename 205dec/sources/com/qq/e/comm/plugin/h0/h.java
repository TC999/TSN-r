package com.qq.e.comm.plugin.h0;

import android.text.TextUtils;
import android.util.Printer;
import com.qq.e.comm.plugin.h0.g;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class h implements Printer {

    /* renamed from: c  reason: collision with root package name */
    private static final String f44042c = h.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private final g f44043a;

    /* renamed from: b  reason: collision with root package name */
    private final Printer f44044b;

    public h(g gVar, Printer printer) {
        this.f44043a = gVar;
        this.f44044b = printer;
    }

    public void a() {
        for (g.d dVar : this.f44043a.b()) {
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public void b() {
        for (g.d dVar : this.f44043a.b()) {
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    public Printer c() {
        return this.f44044b;
    }

    @Override // android.util.Printer
    public void println(String str) {
        Printer printer = this.f44044b;
        if (printer != null) {
            printer.println(str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.charAt(0) == '>') {
            d1.a(f44042c, "println: Message \u5904\u7406\u524d");
            b();
        } else if (str.charAt(0) == '<') {
            d1.a(f44042c, "println: Message \u5904\u7406\u7ed3\u675f");
            a();
        } else {
            d1.a(f44042c, "println: \u65e0\u6548\u7684\u6d88\u606f");
        }
    }
}
