package com.hp.hpl.sparta.xpath;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class XPathException extends Exception {
    private Throwable cause_;

    public XPathException(c0 c0Var, String str) {
        super(c0Var + " " + str);
        this.cause_ = null;
    }

    private static String toString(s sVar) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(tokenToString(sVar));
            if (sVar.f37461a != -1) {
                sVar.a();
                stringBuffer.append(tokenToString(sVar));
                sVar.c();
            }
            return stringBuffer.toString();
        } catch (IOException e4) {
            return "(cannot get  info: " + e4 + ")";
        }
    }

    private static String tokenToString(s sVar) {
        int i4 = sVar.f37461a;
        if (i4 != -3) {
            if (i4 == -2) {
                return sVar.f37462b + "";
            } else if (i4 != -1) {
                return ((char) sVar.f37461a) + "";
            } else {
                return "<end of expression>";
            }
        }
        return sVar.f37463c;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause_;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XPathException(c0 c0Var, String str, s sVar, String str2) {
        this(c0Var, str + " got \"" + toString(sVar) + "\" instead of expected " + str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XPathException(c0 c0Var, Exception exc) {
        super(c0Var + " " + exc);
        this.cause_ = exc;
    }
}
