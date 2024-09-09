package com.sun.mail.imap.protocol;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Writer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BASE64MailboxEncoder.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f50481e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', ','};

    /* renamed from: a  reason: collision with root package name */
    protected byte[] f50482a = new byte[4];

    /* renamed from: b  reason: collision with root package name */
    protected int f50483b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f50484c = false;

    /* renamed from: d  reason: collision with root package name */
    protected Writer f50485d;

    public b(Writer writer) {
        this.f50485d = writer;
    }

    public static String a(String str) {
        char[] charArray = str.toCharArray();
        CharArrayWriter charArrayWriter = new CharArrayWriter(charArray.length);
        b bVar = null;
        boolean z3 = false;
        for (char c4 : charArray) {
            if (c4 < ' ' || c4 > '~') {
                if (bVar == null) {
                    bVar = new b(charArrayWriter);
                    z3 = true;
                }
                bVar.d(c4);
            } else {
                if (bVar != null) {
                    bVar.c();
                }
                if (c4 == '&') {
                    charArrayWriter.write(38);
                    charArrayWriter.write(45);
                    z3 = true;
                } else {
                    charArrayWriter.write(c4);
                }
            }
        }
        if (bVar != null) {
            bVar.c();
        }
        return z3 ? charArrayWriter.toString() : str;
    }

    protected void b() throws IOException {
        int i4 = this.f50483b;
        if (i4 == 1) {
            byte b4 = this.f50482a[0];
            Writer writer = this.f50485d;
            char[] cArr = f50481e;
            writer.write(cArr[(b4 >>> 2) & 63]);
            this.f50485d.write(cArr[((b4 << 4) & 48) + 0]);
        } else if (i4 == 2) {
            byte[] bArr = this.f50482a;
            byte b5 = bArr[0];
            byte b6 = bArr[1];
            Writer writer2 = this.f50485d;
            char[] cArr2 = f50481e;
            writer2.write(cArr2[(b5 >>> 2) & 63]);
            this.f50485d.write(cArr2[((b5 << 4) & 48) + ((b6 >>> 4) & 15)]);
            this.f50485d.write(cArr2[((b6 << 2) & 60) + 0]);
        } else {
            byte[] bArr2 = this.f50482a;
            byte b7 = bArr2[0];
            byte b8 = bArr2[1];
            byte b9 = bArr2[2];
            Writer writer3 = this.f50485d;
            char[] cArr3 = f50481e;
            writer3.write(cArr3[(b7 >>> 2) & 63]);
            this.f50485d.write(cArr3[((b7 << 4) & 48) + ((b8 >>> 4) & 15)]);
            this.f50485d.write(cArr3[((b8 << 2) & 60) + ((b9 >>> 6) & 3)]);
            this.f50485d.write(cArr3[b9 & 63]);
            if (this.f50483b == 4) {
                byte[] bArr3 = this.f50482a;
                bArr3[0] = bArr3[3];
            }
        }
    }

    public void c() {
        try {
            if (this.f50483b > 0) {
                b();
                this.f50483b = 0;
            }
            if (this.f50484c) {
                this.f50485d.write(45);
                this.f50484c = false;
            }
        } catch (IOException unused) {
        }
    }

    public void d(int i4) {
        try {
            if (!this.f50484c) {
                this.f50484c = true;
                this.f50485d.write(38);
            }
            byte[] bArr = this.f50482a;
            int i5 = this.f50483b;
            int i6 = i5 + 1;
            this.f50483b = i6;
            bArr[i5] = (byte) (i4 >> 8);
            int i7 = i6 + 1;
            this.f50483b = i7;
            bArr[i6] = (byte) (i4 & 255);
            if (i7 >= 3) {
                b();
                this.f50483b -= 3;
            }
        } catch (IOException unused) {
        }
    }
}
