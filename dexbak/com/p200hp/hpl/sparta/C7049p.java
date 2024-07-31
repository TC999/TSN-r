package com.p200hp.hpl.sparta;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* compiled from: Parser.java */
/* renamed from: com.hp.hpl.sparta.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7049p {
    /* renamed from: a */
    public static Document m35142a(String str) throws ParseException, IOException {
        return m35134i(str.toCharArray());
    }

    /* renamed from: b */
    public static Document m35141b(String str, InputStream inputStream) throws ParseException, IOException {
        BuildDocument buildDocument = new BuildDocument();
        new ParseByteStream(str, inputStream, null, null, buildDocument);
        return buildDocument.mo35271f();
    }

    /* renamed from: c */
    public static Document m35140c(String str, InputStream inputStream, ParseLog parseLog) throws ParseException, IOException {
        BuildDocument buildDocument = new BuildDocument();
        new ParseByteStream(str, inputStream, parseLog, null, buildDocument);
        return buildDocument.mo35271f();
    }

    /* renamed from: d */
    public static Document m35139d(String str, InputStream inputStream, ParseLog parseLog, String str2) throws ParseException, IOException {
        BuildDocument buildDocument = new BuildDocument();
        new ParseByteStream(str, inputStream, parseLog, str2, buildDocument);
        return buildDocument.mo35271f();
    }

    /* renamed from: e */
    public static Document m35138e(String str, Reader reader) throws ParseException, IOException {
        BuildDocument buildDocument = new BuildDocument();
        new ParseCharStream(str, reader, (ParseLog) null, (String) null, buildDocument);
        return buildDocument.mo35271f();
    }

    /* renamed from: f */
    public static Document m35137f(String str, Reader reader, ParseLog parseLog) throws ParseException, IOException {
        BuildDocument buildDocument = new BuildDocument();
        new ParseCharStream(str, reader, parseLog, (String) null, buildDocument);
        return buildDocument.mo35271f();
    }

    /* renamed from: g */
    public static Document m35136g(String str, Reader reader, ParseLog parseLog, String str2) throws ParseException, EncodingMismatchException, IOException {
        BuildDocument buildDocument = new BuildDocument();
        new ParseCharStream(str, reader, parseLog, str2, buildDocument);
        return buildDocument.mo35271f();
    }

    /* renamed from: h */
    public static Document m35135h(byte[] bArr) throws ParseException, IOException {
        BuildDocument buildDocument = new BuildDocument();
        new ParseByteStream("file:anonymous-string", new ByteArrayInputStream(bArr), null, null, buildDocument);
        return buildDocument.mo35271f();
    }

    /* renamed from: i */
    public static Document m35134i(char[] cArr) throws ParseException, IOException {
        BuildDocument buildDocument = new BuildDocument();
        new ParseCharStream("file:anonymous-string", cArr, (ParseLog) null, (String) null, buildDocument);
        return buildDocument.mo35271f();
    }

    /* renamed from: j */
    public static void m35133j(String str, ParseHandler parseHandler) throws ParseException, IOException {
        m35125r(str.toCharArray(), parseHandler);
    }

    /* renamed from: k */
    public static void m35132k(String str, InputStream inputStream, ParseHandler parseHandler) throws ParseException, IOException {
        new ParseByteStream(str, inputStream, null, null, parseHandler);
    }

    /* renamed from: l */
    public static void m35131l(String str, InputStream inputStream, ParseLog parseLog, ParseHandler parseHandler) throws ParseException, IOException {
        new ParseByteStream(str, inputStream, parseLog, null, parseHandler);
    }

    /* renamed from: m */
    public static void m35130m(String str, InputStream inputStream, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, IOException {
        new ParseByteStream(str, inputStream, parseLog, str2, parseHandler);
    }

    /* renamed from: n */
    public static void m35129n(String str, Reader reader, ParseHandler parseHandler) throws ParseException, IOException {
        new ParseCharStream(str, reader, (ParseLog) null, (String) null, parseHandler);
    }

    /* renamed from: o */
    public static void m35128o(String str, Reader reader, ParseLog parseLog, ParseHandler parseHandler) throws ParseException, IOException {
        new ParseCharStream(str, reader, parseLog, (String) null, parseHandler);
    }

    /* renamed from: p */
    public static void m35127p(String str, Reader reader, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        new ParseCharStream(str, reader, parseLog, str2, parseHandler);
    }

    /* renamed from: q */
    public static void m35126q(byte[] bArr, ParseHandler parseHandler) throws ParseException, IOException {
        new ParseByteStream("file:anonymous-string", new ByteArrayInputStream(bArr), null, null, parseHandler);
    }

    /* renamed from: r */
    public static void m35125r(char[] cArr, ParseHandler parseHandler) throws ParseException, IOException {
        new ParseCharStream("file:anonymous-string", cArr, (ParseLog) null, (String) null, parseHandler);
    }
}
