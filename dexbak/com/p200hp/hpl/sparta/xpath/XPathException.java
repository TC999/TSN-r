package com.p200hp.hpl.sparta.xpath;

import java.io.IOException;

/* renamed from: com.hp.hpl.sparta.xpath.XPathException */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class XPathException extends Exception {
    private Throwable cause_;

    public XPathException(XPath xPath, String str) {
        super(xPath + " " + str);
        this.cause_ = null;
    }

    private static String toString(SimpleStreamTokenizer simpleStreamTokenizer) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(tokenToString(simpleStreamTokenizer));
            if (simpleStreamTokenizer.f23978a != -1) {
                simpleStreamTokenizer.m35063a();
                stringBuffer.append(tokenToString(simpleStreamTokenizer));
                simpleStreamTokenizer.m35061c();
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            return "(cannot get  info: " + e + ")";
        }
    }

    private static String tokenToString(SimpleStreamTokenizer simpleStreamTokenizer) {
        int i = simpleStreamTokenizer.f23978a;
        if (i != -3) {
            if (i == -2) {
                return simpleStreamTokenizer.f23979b + "";
            } else if (i != -1) {
                return ((char) simpleStreamTokenizer.f23978a) + "";
            } else {
                return "<end of expression>";
            }
        }
        return simpleStreamTokenizer.f23980c;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause_;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XPathException(XPath xPath, String str, SimpleStreamTokenizer simpleStreamTokenizer, String str2) {
        this(xPath, str + " got \"" + toString(simpleStreamTokenizer) + "\" instead of expected " + str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XPathException(XPath xPath, Exception exc) {
        super(xPath + " " + exc);
        this.cause_ = exc;
    }
}
