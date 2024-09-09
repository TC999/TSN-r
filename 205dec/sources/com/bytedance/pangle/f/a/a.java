package com.bytedance.pangle.f.a;

import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    int f28747a;

    /* renamed from: b  reason: collision with root package name */
    b f28748b;

    /* renamed from: c  reason: collision with root package name */
    int[] f28749c;

    /* renamed from: i  reason: collision with root package name */
    private boolean f28755i;

    /* renamed from: k  reason: collision with root package name */
    private f f28757k;

    /* renamed from: j  reason: collision with root package name */
    private boolean f28756j = false;

    /* renamed from: l  reason: collision with root package name */
    private final c f28758l = new c();

    /* renamed from: d  reason: collision with root package name */
    int f28750d = 0;

    /* renamed from: e  reason: collision with root package name */
    int f28751e = 1;

    /* renamed from: f  reason: collision with root package name */
    int f28752f = 2;

    /* renamed from: g  reason: collision with root package name */
    int f28753g = 3;

    /* renamed from: h  reason: collision with root package name */
    int f28754h = 4;

    public a() {
        c();
    }

    private int e(int i4) {
        if (this.f28747a == 2) {
            int i5 = i4 * 5;
            if (i5 < this.f28749c.length) {
                return i5;
            }
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i4 + ").");
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    public final void a() {
        if (this.f28756j) {
            this.f28756j = false;
            b bVar = this.f28748b;
            InputStream inputStream = bVar.f28759a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                bVar.a((InputStream) null);
            }
            this.f28757k = null;
            this.f28748b = null;
            c cVar = this.f28758l;
            cVar.f28762b = 0;
            cVar.f28763c = 0;
            c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0108, code lost:
        throw new java.io.IOException("Invalid resource ids size (" + r1 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0221, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r1 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b() {
        /*
            Method dump skipped, instructions count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.f.a.a.b():int");
    }

    public final int c(int i4) {
        return this.f28749c[e(i4) + 4];
    }

    public final String d(int i4) {
        int e4 = e(i4);
        int[] iArr = this.f28749c;
        if (iArr[e4 + 3] == 3) {
            return this.f28757k.a(iArr[e4 + 2]);
        }
        return "";
    }

    private void c() {
        this.f28749c = null;
        this.f28747a = -1;
    }

    public final String a(int i4) {
        int i5 = this.f28749c[e(i4) + 1];
        return i5 == -1 ? "" : this.f28757k.a(i5);
    }

    public final int b(int i4) {
        return this.f28749c[e(i4) + 3];
    }
}
