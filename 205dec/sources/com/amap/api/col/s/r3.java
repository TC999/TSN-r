package com.amap.api.col.s;

import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: FileNumUpdateStrategy.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class r3 extends v3 {

    /* renamed from: b  reason: collision with root package name */
    private int f10186b;

    /* renamed from: c  reason: collision with root package name */
    private String f10187c;

    public r3(String str, v3 v3Var) {
        super(v3Var);
        this.f10186b = 30;
        this.f10187c = str;
    }

    private static int f(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            g2.o(th, "fus", "gfn");
            return 0;
        }
    }

    @Override // com.amap.api.col.s.v3
    protected final boolean c() {
        return f(this.f10187c) >= this.f10186b;
    }
}
