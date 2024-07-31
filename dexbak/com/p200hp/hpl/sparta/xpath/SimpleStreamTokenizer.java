package com.p200hp.hpl.sparta.xpath;

import java.io.IOException;
import java.io.Reader;

/* renamed from: com.hp.hpl.sparta.xpath.s */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SimpleStreamTokenizer {

    /* renamed from: j */
    public static final int f23973j = -1;

    /* renamed from: k */
    public static final int f23974k = -2;

    /* renamed from: l */
    public static final int f23975l = -3;

    /* renamed from: m */
    private static final int f23976m = -5;

    /* renamed from: n */
    private static final int f23977n = -6;

    /* renamed from: e */
    private int f23982e;

    /* renamed from: f */
    private final Reader f23983f;

    /* renamed from: a */
    public int f23978a = Integer.MIN_VALUE;

    /* renamed from: b */
    public int f23979b = Integer.MIN_VALUE;

    /* renamed from: c */
    public String f23980c = "";

    /* renamed from: d */
    private final StringBuffer f23981d = new StringBuffer();

    /* renamed from: g */
    private final int[] f23984g = new int[256];

    /* renamed from: h */
    private boolean f23985h = false;

    /* renamed from: i */
    private char f23986i = 0;

    public SimpleStreamTokenizer(Reader reader) throws IOException {
        char c = 0;
        this.f23983f = reader;
        while (true) {
            int[] iArr = this.f23984g;
            if (c >= iArr.length) {
                m35063a();
                return;
            }
            if (('A' <= c && c <= 'Z') || (('a' <= c && c <= 'z') || c == '-')) {
                iArr[c] = -3;
            } else if ('0' <= c && c <= '9') {
                iArr[c] = -2;
            } else if (c >= 0 && c <= ' ') {
                iArr[c] = -5;
            } else {
                iArr[c] = c;
            }
            c = (char) (c + 1);
        }
    }

    /* renamed from: a */
    public int m35063a() throws IOException {
        int read;
        char c;
        char c2;
        boolean z;
        boolean z2;
        int i;
        if (this.f23985h) {
            this.f23985h = false;
            return this.f23978a;
        }
        this.f23978a = this.f23982e;
        do {
            boolean z3 = false;
            do {
                read = this.f23983f.read();
                if (read == -1) {
                    if (this.f23986i != 0) {
                        throw new IOException("Unterminated quote");
                    }
                    c = -1;
                } else {
                    c = this.f23984g[read];
                }
                c2 = this.f23986i;
                z = c2 == 0 && c == -5;
                if (z3 || z) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
            } while (z);
            if (c == 39 || c == 34) {
                if (c2 == 0) {
                    this.f23986i = (char) c;
                } else if (c2 == c) {
                    this.f23986i = (char) 0;
                }
            }
            char c3 = this.f23986i;
            if (c3 != 0) {
                c = c3;
            }
            z2 = z3 || !(((i = this.f23978a) < -1 || i == 39 || i == 34) && i == c);
            if (z2) {
                int i2 = this.f23978a;
                if (i2 == -3) {
                    this.f23980c = this.f23981d.toString();
                    this.f23981d.setLength(0);
                } else if (i2 == -2) {
                    this.f23979b = Integer.parseInt(this.f23981d.toString());
                    this.f23981d.setLength(0);
                } else if (i2 == 34 || i2 == 39) {
                    this.f23980c = this.f23981d.toString().substring(1, this.f23981d.length() - 1);
                    this.f23981d.setLength(0);
                }
                if (c != -5) {
                    this.f23982e = c == -6 ? read : c;
                }
            }
            if (c == -3 || c == -2 || c == 34 || c == 39) {
                this.f23981d.append((char) read);
                continue;
            }
        } while (!z2);
        return this.f23978a;
    }

    /* renamed from: b */
    public void m35062b(char c) {
        this.f23984g[c] = c;
    }

    /* renamed from: c */
    public void m35061c() {
        this.f23985h = true;
    }

    /* renamed from: d */
    public void m35060d(char c, char c2) {
        while (c <= c2) {
            this.f23984g[c] = -3;
            c = (char) (c + 1);
        }
    }

    public String toString() {
        int i = this.f23978a;
        if (i != -3) {
            if (i == -2) {
                return Integer.toString(this.f23979b);
            }
            if (i == -1) {
                return "(EOF)";
            }
            if (i != 34) {
                if (i != 39) {
                    return "'" + ((char) this.f23978a) + "'";
                }
                return "'" + this.f23980c + "'";
            }
        }
        return "\"" + this.f23980c + "\"";
    }
}
