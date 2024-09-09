package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ResponseInputStream.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class i {

    /* renamed from: b  reason: collision with root package name */
    private static final int f50303b = 256;

    /* renamed from: c  reason: collision with root package name */
    private static final int f50304c = 262144;

    /* renamed from: d  reason: collision with root package name */
    private static final int f50305d = 16;

    /* renamed from: a  reason: collision with root package name */
    private BufferedInputStream f50306a;

    public i(InputStream inputStream) {
        this.f50306a = new BufferedInputStream(inputStream, 2048);
    }

    public d a() throws IOException {
        return b(null);
    }

    public d b(d dVar) throws IOException {
        if (dVar == null) {
            dVar = new d(new byte[128], 0, 128);
        }
        byte[] a4 = dVar.a();
        int i4 = 0;
        while (true) {
            boolean z3 = false;
            int i5 = 0;
            while (!z3 && (i5 = this.f50306a.read()) != -1) {
                if (i5 == 10 && i4 > 0 && a4[i4 - 1] == 13) {
                    z3 = true;
                }
                if (i4 >= a4.length) {
                    int length = a4.length;
                    if (length > 262144) {
                        length = 262144;
                    }
                    dVar.e(length);
                    a4 = dVar.a();
                }
                a4[i4] = (byte) i5;
                i4++;
            }
            if (i5 == -1) {
                throw new IOException();
            }
            if (i4 < 5) {
                break;
            }
            int i6 = i4 - 3;
            if (a4[i6] != 125) {
                break;
            }
            int i7 = i4 - 4;
            while (i7 >= 0 && a4[i7] != 123) {
                i7--;
            }
            if (i7 < 0) {
                break;
            }
            try {
                int parseInt = ASCIIUtility.parseInt(a4, i7 + 1, i6);
                if (parseInt > 0) {
                    int length2 = a4.length - i4;
                    int i8 = parseInt + 16;
                    if (i8 > length2) {
                        int i9 = i8 - length2;
                        if (256 > i9) {
                            i9 = 256;
                        }
                        dVar.e(i9);
                        a4 = dVar.a();
                    }
                    while (parseInt > 0) {
                        int read = this.f50306a.read(a4, i4, parseInt);
                        parseInt -= read;
                        i4 += read;
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        dVar.f(i4);
        return dVar;
    }
}
