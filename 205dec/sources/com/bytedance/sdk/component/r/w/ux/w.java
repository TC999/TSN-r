package com.bytedance.sdk.component.r.w.ux;

import java.util.UUID;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class w implements Comparable<w>, Runnable {

    /* renamed from: c  reason: collision with root package name */
    private int f30108c = 5;

    /* renamed from: w  reason: collision with root package name */
    private String f30109w = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
    private String xv;

    public w(String str) {
        this.xv = str;
    }

    public void c(int i4) {
        this.f30108c = i4;
    }

    public int c() {
        return this.f30108c;
    }

    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(w wVar) {
        if (c() < wVar.c()) {
            return 1;
        }
        return c() >= wVar.c() ? -1 : 0;
    }
}
