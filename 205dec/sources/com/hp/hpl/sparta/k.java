package com.hp.hpl.sparta;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: ParseByteStream.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class k implements o {

    /* renamed from: c  reason: collision with root package name */
    private l f37397c;

    public k(String str, InputStream inputStream, n nVar, String str2, m mVar) throws ParseException, IOException {
        n nVar2 = nVar == null ? o.f37423a : nVar;
        if (inputStream.markSupported()) {
            inputStream.mark(o.f37424b);
            byte[] bArr = new byte[4];
            String g4 = str2 == null ? g(str, bArr, inputStream.read(bArr), nVar2) : str2;
            try {
                inputStream.reset();
                try {
                    this.f37397c = new l(str, new InputStreamReader(inputStream, e(g4)), nVar2, g4, mVar);
                    return;
                } catch (IOException unused) {
                    nVar2.a("Problem reading with assumed encoding of " + g4 + " so restarting with euc-jp", str, 1);
                    inputStream.reset();
                    try {
                        this.f37397c = new l(str, new InputStreamReader(inputStream, e("euc-jp")), nVar2, (String) null, mVar);
                        return;
                    } catch (UnsupportedEncodingException unused2) {
                        throw new ParseException(nVar2, str, 1, 0, "euc-jp", "\"euc-jp\" is not a supported encoding");
                    }
                }
            } catch (EncodingMismatchException e4) {
                String declaredEncoding = e4.getDeclaredEncoding();
                nVar2.a("Encoding declaration of " + declaredEncoding + " is different that assumed " + g4 + " so restarting the parsing with the new encoding", str, 1);
                inputStream.reset();
                try {
                    this.f37397c = new l(str, new InputStreamReader(inputStream, e(declaredEncoding)), nVar2, (String) null, mVar);
                    return;
                } catch (UnsupportedEncodingException unused3) {
                    throw new ParseException(nVar2, str, 1, 0, declaredEncoding, "\"" + declaredEncoding + "\" is not a supported encoding");
                }
            }
        }
        throw new Error("Precondition violation: the InputStream passed to ParseByteStream must support mark");
    }

    private static boolean b(byte[] bArr, int i4) {
        return bArr[0] == ((byte) (i4 >>> 24)) && bArr[1] == ((byte) ((i4 >>> 16) & 255)) && bArr[2] == ((byte) ((i4 >>> 8) & 255)) && bArr[3] == ((byte) (i4 & 255));
    }

    private static boolean c(byte[] bArr, short s3) {
        return bArr[0] == ((byte) (s3 >>> 8)) && bArr[1] == ((byte) (s3 & 255));
    }

    private static String e(String str) {
        return str.toLowerCase().equals("utf8") ? "UTF-8" : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String g(java.lang.String r5, byte[] r6, int r7, com.hp.hpl.sparta.n r8) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.k.g(java.lang.String, byte[], int, com.hp.hpl.sparta.n):java.lang.String");
    }

    private static String h(byte b4) {
        String hexString = Integer.toHexString(b4);
        int length = hexString.length();
        if (length != 1) {
            return length != 2 ? hexString.substring(hexString.length() - 2) : hexString;
        }
        return "0" + hexString;
    }

    @Override // com.hp.hpl.sparta.o
    public String a() {
        return this.f37397c.a();
    }

    @Override // com.hp.hpl.sparta.o
    public int d() {
        return this.f37397c.d();
    }

    @Override // com.hp.hpl.sparta.o
    public String toString() {
        return this.f37397c.toString();
    }
}
