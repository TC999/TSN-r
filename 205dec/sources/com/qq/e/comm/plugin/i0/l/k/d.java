package com.qq.e.comm.plugin.i0.l.k;

import java.io.IOException;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class d extends com.qq.e.comm.plugin.i0.l.k.a {

    /* renamed from: e  reason: collision with root package name */
    private final long f44341e;

    /* renamed from: f  reason: collision with root package name */
    private final int f44342f;

    /* renamed from: g  reason: collision with root package name */
    private final String f44343g;

    /* renamed from: h  reason: collision with root package name */
    private final com.qq.e.comm.plugin.i0.l.k.b f44344h;

    /* renamed from: i  reason: collision with root package name */
    private final byte[] f44345i;

    /* renamed from: j  reason: collision with root package name */
    private int f44346j;

    /* renamed from: k  reason: collision with root package name */
    private int f44347k;

    /* renamed from: l  reason: collision with root package name */
    private List<h> f44348l;

    /* renamed from: m  reason: collision with root package name */
    private List<h> f44349m;

    /* renamed from: n  reason: collision with root package name */
    private List<h> f44350n;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private int f44351a;

        /* renamed from: b  reason: collision with root package name */
        private String f44352b;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private final String f44353a;

        /* renamed from: b  reason: collision with root package name */
        private final int f44354b;

        /* renamed from: c  reason: collision with root package name */
        private final int f44355c;

        /* renamed from: d  reason: collision with root package name */
        private int f44356d;

        /* renamed from: e  reason: collision with root package name */
        private final List<h> f44357e;

        private c(String str, int i4, int i5) {
            this.f44353a = str;
            this.f44354b = i4;
            this.f44355c = i5;
            this.f44356d = 0;
            this.f44357e = new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(h hVar) {
            if (hVar != null) {
                this.f44357e.add(hVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, int i4, com.qq.e.comm.plugin.i0.l.k.b bVar, byte[] bArr) throws IOException {
        if (bArr != null && bArr.length != 0) {
            this.f44343g = str;
            this.f44342f = i4;
            this.f44344h = bVar;
            this.f44345i = bArr;
            this.f44341e = new Date().getTime() / 1000;
            b();
            return;
        }
        throw new IOException("response data is empty");
    }

    private void a(c cVar) throws IOException {
        int i4 = cVar.f44355c;
        for (int i5 = cVar.f44354b; i5 > 0; i5--) {
            b a4 = a(i4);
            if (a4 != null) {
                int i6 = i4 + a4.f44351a;
                short b4 = b(i6);
                int i7 = i6 + 2;
                short b5 = b(i7);
                int i8 = i7 + 2;
                int c4 = c(i8);
                int i9 = i8 + 4;
                short b6 = b(i9);
                int i10 = i9 + 2;
                String a5 = a(b4, i10, b6);
                if (b5 == 1 && (b4 == 5 || b4 == this.f44344h.a())) {
                    cVar.a(new h(a5, b4, c4, this.f44341e, this.f44342f, this.f44343g));
                }
                i4 = i10 + b6;
            } else {
                throw new IOException("read " + cVar.f44353a + " error");
            }
        }
        cVar.f44356d = i4 - cVar.f44355c;
    }

    private void b() throws IOException {
        if (this.f44345i.length >= 12) {
            c();
            int d4 = d();
            c cVar = new c("answer", b(6), d4);
            a(cVar);
            this.f44348l = cVar.f44357e;
            int i4 = d4 + cVar.f44356d;
            c cVar2 = new c("authority", b(8), i4);
            a(cVar2);
            this.f44349m = cVar2.f44357e;
            c cVar3 = new c("additional", b(10), i4 + cVar2.f44356d);
            a(cVar3);
            this.f44350n = cVar3.f44357e;
            return;
        }
        throw new IOException("response data too small");
    }

    private void c() throws IOException {
        short b4 = b(0);
        this.f44320a = b4;
        if (b4 == this.f44344h.f44320a) {
            int d4 = d(2);
            if ((d(2) & 128) != 0) {
                this.f44321b = (d4 >> 3) & 7;
                this.f44346j = (d4 >> 2) & 1;
                this.f44322c = d4 & 1;
                int d5 = d(3);
                this.f44323d = (d5 >> 7) & 1;
                this.f44347k = d5 & 15;
                return;
            }
            throw new IOException("not a response data");
        }
        throw new IOException("question id error");
    }

    private int d() throws IOException {
        int i4 = 12;
        for (int b4 = b(4); b4 > 0; b4--) {
            b a4 = a(i4);
            if (a4 != null) {
                i4 += a4.f44351a + 4;
            } else {
                throw new IOException("read Question error");
            }
        }
        return i4;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "{messageId:%d, rd:%d, ra:%d, aa:%d, rCode:%d, server:%s, request:%s, answerArray:%s, authorityArray:%s, additionalArray:%s}", Short.valueOf(this.f44320a), Integer.valueOf(this.f44322c), Integer.valueOf(this.f44323d), Integer.valueOf(this.f44346j), Integer.valueOf(this.f44347k), this.f44343g, this.f44344h, this.f44348l, this.f44349m, this.f44350n);
    }

    private int d(int i4) throws IOException {
        byte[] bArr = this.f44345i;
        if (i4 < bArr.length) {
            return bArr[i4] & 255;
        }
        throw new IOException("read response data out of range");
    }

    private short b(int i4) throws IOException {
        int i5 = i4 + 1;
        byte[] bArr = this.f44345i;
        if (i5 < bArr.length) {
            return (short) (((bArr[i4] & 255) << 8) + (bArr[i5] & 255));
        }
        throw new IOException("read response data out of range");
    }

    private int c(int i4) throws IOException {
        int i5 = i4 + 3;
        byte[] bArr = this.f44345i;
        if (i5 < bArr.length) {
            return ((bArr[i4] & 255) << 24) + ((bArr[i4 + 1] & 255) << 16) + ((bArr[i4 + 2] & 255) << 8) + (bArr[i5] & 255);
        }
        throw new IOException("read response data out of range");
    }

    private b a(int i4) throws IOException {
        StringBuilder sb = new StringBuilder();
        b bVar = new b();
        int i5 = 128;
        int i6 = i4;
        do {
            int d4 = d(i6);
            int i7 = d4 & 192;
            if (i7 == 192) {
                if (bVar.f44351a < 1) {
                    bVar.f44351a = (i6 + 2) - i4;
                }
                i6 = d(i6 + 1) | ((d4 & 63) << 8);
            } else if (i7 > 0) {
                return null;
            } else {
                i6++;
                if (d4 > 0) {
                    if (sb.length() > 0) {
                        sb.append(".");
                    }
                    int i8 = i6 + d4;
                    sb.append(IDN.toUnicode(new String(Arrays.copyOfRange(this.f44345i, i6, i8))));
                    i6 = i8;
                }
            }
            if (d4 <= 0) {
                break;
            }
            i5--;
        } while (i5 > 0);
        bVar.f44352b = sb.toString();
        if (bVar.f44351a < 1) {
            bVar.f44351a = i6 - i4;
        }
        return bVar;
    }

    private String a(int i4, int i5, int i6) throws IOException {
        if (i4 != 1) {
            if (i4 != 5) {
                if (i4 != 16) {
                    if (i4 == 28 && i6 == 16) {
                        StringBuilder sb = new StringBuilder();
                        int i7 = 0;
                        while (i7 < 16) {
                            sb.append(i7 > 0 ? ":" : "");
                            int i8 = i5 + i7;
                            sb.append(d(i8));
                            sb.append(d(i8 + 1));
                            i7 += 2;
                        }
                        return sb.toString();
                    }
                } else if (i6 > 0) {
                    int i9 = i6 + i5;
                    byte[] bArr = this.f44345i;
                    if (i9 < bArr.length) {
                        return IDN.toUnicode(new String(Arrays.copyOfRange(bArr, i5, i9)));
                    }
                }
            } else if (i6 > 1) {
                return a(i5).f44352b;
            }
        } else if (i6 == 4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(d(i5));
            for (int i10 = 1; i10 < 4; i10++) {
                sb2.append(".");
                sb2.append(d(i5 + i10));
            }
            return sb2.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<h> a() {
        return this.f44348l;
    }
}
