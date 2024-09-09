package com.bytedance.sdk.component.xv.c;

import java.io.IOException;
import java.util.zip.Inflater;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class k implements fz {

    /* renamed from: c  reason: collision with root package name */
    private final ux f30688c;
    private boolean sr;

    /* renamed from: w  reason: collision with root package name */
    private final Inflater f30689w;
    private int xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ux uxVar, Inflater inflater) {
        if (uxVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f30688c = uxVar;
            this.f30689w = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    private void xv() throws IOException {
        int i4 = this.xv;
        if (i4 == 0) {
            return;
        }
        int remaining = i4 - this.f30689w.getRemaining();
        this.xv -= remaining;
        this.f30688c.ev(remaining);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
        xv();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (r1.f30706w != r1.xv) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
        r7.f30700c = r1.w();
        com.bytedance.sdk.component.xv.c.fp.c(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        return -1;
     */
    @Override // com.bytedance.sdk.component.xv.c.fz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long c(com.bytedance.sdk.component.xv.c.xv r7, long r8) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 < 0) goto L7a
            boolean r2 = r6.sr
            if (r2 != 0) goto L72
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 != 0) goto Lf
            return r0
        Lf:
            boolean r0 = r6.w()
            r1 = 1
            com.bytedance.sdk.component.xv.c.ys r1 = r7.ux(r1)     // Catch: java.util.zip.DataFormatException -> L6b
            int r2 = r1.xv     // Catch: java.util.zip.DataFormatException -> L6b
            int r2 = 8192 - r2
            long r2 = (long) r2     // Catch: java.util.zip.DataFormatException -> L6b
            long r2 = java.lang.Math.min(r8, r2)     // Catch: java.util.zip.DataFormatException -> L6b
            int r3 = (int) r2     // Catch: java.util.zip.DataFormatException -> L6b
            java.util.zip.Inflater r2 = r6.f30689w     // Catch: java.util.zip.DataFormatException -> L6b
            byte[] r4 = r1.f30703c     // Catch: java.util.zip.DataFormatException -> L6b
            int r5 = r1.xv     // Catch: java.util.zip.DataFormatException -> L6b
            int r2 = r2.inflate(r4, r5, r3)     // Catch: java.util.zip.DataFormatException -> L6b
            if (r2 <= 0) goto L3a
            int r8 = r1.xv     // Catch: java.util.zip.DataFormatException -> L6b
            int r8 = r8 + r2
            r1.xv = r8     // Catch: java.util.zip.DataFormatException -> L6b
            long r8 = r7.f30701w     // Catch: java.util.zip.DataFormatException -> L6b
            long r0 = (long) r2     // Catch: java.util.zip.DataFormatException -> L6b
            long r8 = r8 + r0
            r7.f30701w = r8     // Catch: java.util.zip.DataFormatException -> L6b
            return r0
        L3a:
            java.util.zip.Inflater r2 = r6.f30689w     // Catch: java.util.zip.DataFormatException -> L6b
            boolean r2 = r2.finished()     // Catch: java.util.zip.DataFormatException -> L6b
            if (r2 != 0) goto L56
            java.util.zip.Inflater r2 = r6.f30689w     // Catch: java.util.zip.DataFormatException -> L6b
            boolean r2 = r2.needsDictionary()     // Catch: java.util.zip.DataFormatException -> L6b
            if (r2 == 0) goto L4b
            goto L56
        L4b:
            if (r0 != 0) goto L4e
            goto Lf
        L4e:
            java.io.EOFException r7 = new java.io.EOFException     // Catch: java.util.zip.DataFormatException -> L6b
            java.lang.String r8 = "source exhausted prematurely"
            r7.<init>(r8)     // Catch: java.util.zip.DataFormatException -> L6b
            throw r7     // Catch: java.util.zip.DataFormatException -> L6b
        L56:
            r6.xv()     // Catch: java.util.zip.DataFormatException -> L6b
            int r8 = r1.f30706w     // Catch: java.util.zip.DataFormatException -> L6b
            int r9 = r1.xv     // Catch: java.util.zip.DataFormatException -> L6b
            if (r8 != r9) goto L68
            com.bytedance.sdk.component.xv.c.ys r8 = r1.w()     // Catch: java.util.zip.DataFormatException -> L6b
            r7.f30700c = r8     // Catch: java.util.zip.DataFormatException -> L6b
            com.bytedance.sdk.component.xv.c.fp.c(r1)     // Catch: java.util.zip.DataFormatException -> L6b
        L68:
            r7 = -1
            return r7
        L6b:
            r7 = move-exception
            java.io.IOException r8 = new java.io.IOException
            r8.<init>(r7)
            throw r8
        L72:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "closed"
            r7.<init>(r8)
            throw r7
        L7a:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "byteCount < 0: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            goto L92
        L91:
            throw r7
        L92:
            goto L91
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.xv.c.k.c(com.bytedance.sdk.component.xv.c.xv, long):long");
    }

    @Override // com.bytedance.sdk.component.xv.c.fz, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.sr) {
            return;
        }
        this.f30689w.end();
        this.sr = true;
        this.f30688c.close();
    }

    public final boolean w() throws IOException {
        if (this.f30689w.needsInput()) {
            xv();
            if (this.f30689w.getRemaining() == 0) {
                if (this.f30688c.ux()) {
                    return true;
                }
                ys ysVar = this.f30688c.xv().f30700c;
                int i4 = ysVar.xv;
                int i5 = ysVar.f30706w;
                int i6 = i4 - i5;
                this.xv = i6;
                this.f30689w.setInput(ysVar.f30703c, i5, i6);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.xv.c.fz
    public u c() {
        return this.f30688c.c();
    }
}
