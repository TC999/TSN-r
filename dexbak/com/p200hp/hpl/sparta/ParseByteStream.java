package com.p200hp.hpl.sparta;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.hp.hpl.sparta.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ParseByteStream implements InterfaceC7048o {

    /* renamed from: c */
    private ParseCharStream f23895c;

    public ParseByteStream(String str, InputStream inputStream, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, IOException {
        ParseLog parseLog2 = parseLog == null ? InterfaceC7048o.f23940a : parseLog;
        if (inputStream.markSupported()) {
            inputStream.mark(InterfaceC7048o.f23941b);
            byte[] bArr = new byte[4];
            String m35224g = str2 == null ? m35224g(str, bArr, inputStream.read(bArr), parseLog2) : str2;
            try {
                inputStream.reset();
                try {
                    this.f23895c = new ParseCharStream(str, new InputStreamReader(inputStream, m35225e(m35224g)), parseLog2, m35224g, parseHandler);
                    return;
                } catch (IOException unused) {
                    parseLog2.mo35147a("Problem reading with assumed encoding of " + m35224g + " so restarting with euc-jp", str, 1);
                    inputStream.reset();
                    try {
                        this.f23895c = new ParseCharStream(str, new InputStreamReader(inputStream, m35225e("euc-jp")), parseLog2, (String) null, parseHandler);
                        return;
                    } catch (UnsupportedEncodingException unused2) {
                        throw new ParseException(parseLog2, str, 1, 0, "euc-jp", "\"euc-jp\" is not a supported encoding");
                    }
                }
            } catch (EncodingMismatchException e) {
                String declaredEncoding = e.getDeclaredEncoding();
                parseLog2.mo35147a("Encoding declaration of " + declaredEncoding + " is different that assumed " + m35224g + " so restarting the parsing with the new encoding", str, 1);
                inputStream.reset();
                try {
                    this.f23895c = new ParseCharStream(str, new InputStreamReader(inputStream, m35225e(declaredEncoding)), parseLog2, (String) null, parseHandler);
                    return;
                } catch (UnsupportedEncodingException unused3) {
                    throw new ParseException(parseLog2, str, 1, 0, declaredEncoding, "\"" + declaredEncoding + "\" is not a supported encoding");
                }
            }
        }
        throw new Error("Precondition violation: the InputStream passed to ParseByteStream must support mark");
    }

    /* renamed from: b */
    private static boolean m35227b(byte[] bArr, int i) {
        return bArr[0] == ((byte) (i >>> 24)) && bArr[1] == ((byte) ((i >>> 16) & 255)) && bArr[2] == ((byte) ((i >>> 8) & 255)) && bArr[3] == ((byte) (i & 255));
    }

    /* renamed from: c */
    private static boolean m35226c(byte[] bArr, short s) {
        return bArr[0] == ((byte) (s >>> 8)) && bArr[1] == ((byte) (s & 255));
    }

    /* renamed from: e */
    private static String m35225e(String str) {
        return str.toLowerCase().equals("utf8") ? "UTF-8" : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b8  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m35224g(java.lang.String r5, byte[] r6, int r7, com.p200hp.hpl.sparta.ParseLog r8) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p200hp.hpl.sparta.ParseByteStream.m35224g(java.lang.String, byte[], int, com.hp.hpl.sparta.n):java.lang.String");
    }

    /* renamed from: h */
    private static String m35223h(byte b) {
        String hexString = Integer.toHexString(b);
        int length = hexString.length();
        if (length != 1) {
            return length != 2 ? hexString.substring(hexString.length() - 2) : hexString;
        }
        return "0" + hexString;
    }

    @Override // com.p200hp.hpl.sparta.InterfaceC7048o
    /* renamed from: a */
    public String mo35144a() {
        return this.f23895c.mo35144a();
    }

    @Override // com.p200hp.hpl.sparta.InterfaceC7048o
    /* renamed from: d */
    public int mo35143d() {
        return this.f23895c.mo35143d();
    }

    @Override // com.p200hp.hpl.sparta.InterfaceC7048o
    public String toString() {
        return this.f23895c.toString();
    }
}
