package com.hp.hpl.sparta.xpath;

import java.io.IOException;
import java.io.Reader;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: SimpleStreamTokenizer.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class s {

    /* renamed from: j  reason: collision with root package name */
    public static final int f37456j = -1;

    /* renamed from: k  reason: collision with root package name */
    public static final int f37457k = -2;

    /* renamed from: l  reason: collision with root package name */
    public static final int f37458l = -3;

    /* renamed from: m  reason: collision with root package name */
    private static final int f37459m = -5;

    /* renamed from: n  reason: collision with root package name */
    private static final int f37460n = -6;

    /* renamed from: e  reason: collision with root package name */
    private int f37465e;

    /* renamed from: f  reason: collision with root package name */
    private final Reader f37466f;

    /* renamed from: a  reason: collision with root package name */
    public int f37461a = Integer.MIN_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public int f37462b = Integer.MIN_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public String f37463c = "";

    /* renamed from: d  reason: collision with root package name */
    private final StringBuffer f37464d = new StringBuffer();

    /* renamed from: g  reason: collision with root package name */
    private final int[] f37467g = new int[256];

    /* renamed from: h  reason: collision with root package name */
    private boolean f37468h = false;

    /* renamed from: i  reason: collision with root package name */
    private char f37469i = 0;

    public s(Reader reader) throws IOException {
        char c4 = 0;
        this.f37466f = reader;
        while (true) {
            int[] iArr = this.f37467g;
            if (c4 >= iArr.length) {
                a();
                return;
            }
            if (('A' <= c4 && c4 <= 'Z') || (('a' <= c4 && c4 <= 'z') || c4 == '-')) {
                iArr[c4] = -3;
            } else if ('0' <= c4 && c4 <= '9') {
                iArr[c4] = -2;
            } else if (c4 >= 0 && c4 <= ' ') {
                iArr[c4] = -5;
            } else {
                iArr[c4] = c4;
            }
            c4 = (char) (c4 + 1);
        }
    }

    public int a() throws IOException {
        int read;
        char c4;
        char c5;
        boolean z3;
        boolean z4;
        int i4;
        if (this.f37468h) {
            this.f37468h = false;
            return this.f37461a;
        }
        this.f37461a = this.f37465e;
        do {
            boolean z5 = false;
            do {
                read = this.f37466f.read();
                if (read == -1) {
                    if (this.f37469i != 0) {
                        throw new IOException("Unterminated quote");
                    }
                    c4 = -1;
                } else {
                    c4 = this.f37467g[read];
                }
                c5 = this.f37469i;
                z3 = c5 == 0 && c4 == -5;
                if (z5 || z3) {
                    z5 = true;
                    continue;
                } else {
                    z5 = false;
                    continue;
                }
            } while (z3);
            if (c4 == 39 || c4 == 34) {
                if (c5 == 0) {
                    this.f37469i = (char) c4;
                } else if (c5 == c4) {
                    this.f37469i = (char) 0;
                }
            }
            char c6 = this.f37469i;
            if (c6 != 0) {
                c4 = c6;
            }
            z4 = z5 || !(((i4 = this.f37461a) < -1 || i4 == 39 || i4 == 34) && i4 == c4);
            if (z4) {
                int i5 = this.f37461a;
                if (i5 == -3) {
                    this.f37463c = this.f37464d.toString();
                    this.f37464d.setLength(0);
                } else if (i5 == -2) {
                    this.f37462b = Integer.parseInt(this.f37464d.toString());
                    this.f37464d.setLength(0);
                } else if (i5 == 34 || i5 == 39) {
                    this.f37463c = this.f37464d.toString().substring(1, this.f37464d.length() - 1);
                    this.f37464d.setLength(0);
                }
                if (c4 != -5) {
                    this.f37465e = c4 == -6 ? read : c4;
                }
            }
            if (c4 == -3 || c4 == -2 || c4 == 34 || c4 == 39) {
                this.f37464d.append((char) read);
                continue;
            }
        } while (!z4);
        return this.f37461a;
    }

    public void b(char c4) {
        this.f37467g[c4] = c4;
    }

    public void c() {
        this.f37468h = true;
    }

    public void d(char c4, char c5) {
        while (c4 <= c5) {
            this.f37467g[c4] = -3;
            c4 = (char) (c4 + 1);
        }
    }

    public String toString() {
        int i4 = this.f37461a;
        if (i4 != -3) {
            if (i4 == -2) {
                return Integer.toString(this.f37462b);
            }
            if (i4 == -1) {
                return "(EOF)";
            }
            if (i4 != 34) {
                if (i4 != 39) {
                    return "'" + ((char) this.f37461a) + "'";
                }
                return "'" + this.f37463c + "'";
            }
        }
        return "\"" + this.f37463c + "\"";
    }
}
