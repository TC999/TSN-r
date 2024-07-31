package com.bytedance.pangle.p121f.p122a;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bytedance.pangle.f.a.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
final class C6114a {

    /* renamed from: a */
    int f21986a;

    /* renamed from: b */
    C6115b f21987b;

    /* renamed from: c */
    int[] f21988c;

    /* renamed from: i */
    private boolean f21994i;

    /* renamed from: k */
    private C6119f f21996k;

    /* renamed from: j */
    private boolean f21995j = false;

    /* renamed from: l */
    private final C6116c f21997l = new C6116c();

    /* renamed from: d */
    int f21989d = 0;

    /* renamed from: e */
    int f21990e = 1;

    /* renamed from: f */
    int f21991f = 2;

    /* renamed from: g */
    int f21992g = 3;

    /* renamed from: h */
    int f21993h = 4;

    public C6114a() {
        m37161c();
    }

    /* renamed from: e */
    private int m37158e(int i) {
        if (this.f21986a == 2) {
            int i2 = i * 5;
            if (i2 < this.f21988c.length) {
                return i2;
            }
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    /* renamed from: a */
    public final void m37165a() {
        if (this.f21995j) {
            this.f21995j = false;
            C6115b c6115b = this.f21987b;
            InputStream inputStream = c6115b.f21998a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                c6115b.m37155a((InputStream) null);
            }
            this.f21996k = null;
            this.f21987b = null;
            C6116c c6116c = this.f21997l;
            c6116c.f22001b = 0;
            c6116c.f22002c = 0;
            m37161c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0108, code lost:
        throw new java.io.IOException("Invalid resource ids size (" + r1 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0221, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r1 + ").");
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m37163b() {
        /*
            Method dump skipped, instructions count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.p121f.p122a.C6114a.m37163b():int");
    }

    /* renamed from: c */
    public final int m37160c(int i) {
        return this.f21988c[m37158e(i) + 4];
    }

    /* renamed from: d */
    public final String m37159d(int i) {
        int m37158e = m37158e(i);
        int[] iArr = this.f21988c;
        if (iArr[m37158e + 3] == 3) {
            return this.f21996k.m37147a(iArr[m37158e + 2]);
        }
        return "";
    }

    /* renamed from: c */
    private void m37161c() {
        this.f21988c = null;
        this.f21986a = -1;
    }

    /* renamed from: a */
    public final String m37164a(int i) {
        int i2 = this.f21988c[m37158e(i) + 1];
        return i2 == -1 ? "" : this.f21996k.m37147a(i2);
    }

    /* renamed from: b */
    public final int m37162b(int i) {
        return this.f21988c[m37158e(i) + 3];
    }
}
