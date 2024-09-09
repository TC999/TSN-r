package com.amap.api.col.p0003l;

import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: FileNumUpdateStrategy.java */
/* renamed from: com.amap.api.col.3l.r7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class r7 extends w7 {

    /* renamed from: b  reason: collision with root package name */
    private int f8913b;

    /* renamed from: c  reason: collision with root package name */
    private String f8914c;

    public r7(String str, w7 w7Var) {
        super(w7Var);
        this.f8913b = 30;
        this.f8914c = str;
    }

    private static int f(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            u5.p(th, "fus", "gfn");
            return 0;
        }
    }

    @Override // com.amap.api.col.p0003l.w7
    protected final boolean d() {
        return f(this.f8914c) >= this.f8913b;
    }
}
