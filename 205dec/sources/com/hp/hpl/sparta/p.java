package com.hp.hpl.sparta;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: Parser.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class p {
    public static e a(String str) throws ParseException, IOException {
        return i(str.toCharArray());
    }

    public static e b(String str, InputStream inputStream) throws ParseException, IOException {
        a aVar = new a();
        new k(str, inputStream, null, null, aVar);
        return aVar.f();
    }

    public static e c(String str, InputStream inputStream, n nVar) throws ParseException, IOException {
        a aVar = new a();
        new k(str, inputStream, nVar, null, aVar);
        return aVar.f();
    }

    public static e d(String str, InputStream inputStream, n nVar, String str2) throws ParseException, IOException {
        a aVar = new a();
        new k(str, inputStream, nVar, str2, aVar);
        return aVar.f();
    }

    public static e e(String str, Reader reader) throws ParseException, IOException {
        a aVar = new a();
        new l(str, reader, (n) null, (String) null, aVar);
        return aVar.f();
    }

    public static e f(String str, Reader reader, n nVar) throws ParseException, IOException {
        a aVar = new a();
        new l(str, reader, nVar, (String) null, aVar);
        return aVar.f();
    }

    public static e g(String str, Reader reader, n nVar, String str2) throws ParseException, EncodingMismatchException, IOException {
        a aVar = new a();
        new l(str, reader, nVar, str2, aVar);
        return aVar.f();
    }

    public static e h(byte[] bArr) throws ParseException, IOException {
        a aVar = new a();
        new k("file:anonymous-string", new ByteArrayInputStream(bArr), null, null, aVar);
        return aVar.f();
    }

    public static e i(char[] cArr) throws ParseException, IOException {
        a aVar = new a();
        new l("file:anonymous-string", cArr, (n) null, (String) null, aVar);
        return aVar.f();
    }

    public static void j(String str, m mVar) throws ParseException, IOException {
        r(str.toCharArray(), mVar);
    }

    public static void k(String str, InputStream inputStream, m mVar) throws ParseException, IOException {
        new k(str, inputStream, null, null, mVar);
    }

    public static void l(String str, InputStream inputStream, n nVar, m mVar) throws ParseException, IOException {
        new k(str, inputStream, nVar, null, mVar);
    }

    public static void m(String str, InputStream inputStream, n nVar, String str2, m mVar) throws ParseException, IOException {
        new k(str, inputStream, nVar, str2, mVar);
    }

    public static void n(String str, Reader reader, m mVar) throws ParseException, IOException {
        new l(str, reader, (n) null, (String) null, mVar);
    }

    public static void o(String str, Reader reader, n nVar, m mVar) throws ParseException, IOException {
        new l(str, reader, nVar, (String) null, mVar);
    }

    public static void p(String str, Reader reader, n nVar, String str2, m mVar) throws ParseException, EncodingMismatchException, IOException {
        new l(str, reader, nVar, str2, mVar);
    }

    public static void q(byte[] bArr, m mVar) throws ParseException, IOException {
        new k("file:anonymous-string", new ByteArrayInputStream(bArr), null, null, mVar);
    }

    public static void r(char[] cArr, m mVar) throws ParseException, IOException {
        new l("file:anonymous-string", cArr, (n) null, (String) null, mVar);
    }
}
