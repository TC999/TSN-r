package com.hp.hpl.sparta;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ParseException extends Exception {
    private Throwable cause_;
    private int lineNumber_;

    public ParseException(String str) {
        super(str);
        this.lineNumber_ = -1;
        this.cause_ = null;
    }

    static String charRepr(int i4) {
        if (i4 == -1) {
            return "EOF";
        }
        return "" + ((char) i4);
    }

    private static String toMessage(String str, int i4, int i5, String str2, String str3) {
        return str + "(" + i4 + "): \n" + str2 + "\nLast character read was '" + charRepr(i5) + "'\n" + str3;
    }

    private static String toString(char[] cArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cArr[0]);
        for (int i4 = 1; i4 < cArr.length; i4++) {
            stringBuffer.append("or " + cArr[i4]);
        }
        return stringBuffer.toString();
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause_;
    }

    public int getLineNumber() {
        return this.lineNumber_;
    }

    public ParseException(String str, Throwable th) {
        super(str + " " + th);
        this.lineNumber_ = -1;
        this.cause_ = th;
    }

    public ParseException(String str, int i4, int i5, String str2, String str3) {
        super(toMessage(str, i4, i5, str2, str3));
        this.cause_ = null;
        this.lineNumber_ = i4;
    }

    public ParseException(n nVar, String str, int i4, int i5, String str2, String str3) {
        this(str, i4, i5, str2, str3);
        nVar.b(str3, str, i4);
    }

    public ParseException(l lVar, String str) {
        this(lVar.h(), lVar.a(), lVar.d(), lVar.g(), lVar.e(), str);
    }

    public ParseException(l lVar, char c4, char c5) {
        this(lVar, "got '" + c4 + "' instead of expected '" + c5 + "'");
    }

    public ParseException(l lVar, char c4, char[] cArr) {
        this(lVar, "got '" + c4 + "' instead of " + toString(cArr));
    }

    public ParseException(l lVar, char c4, String str) {
        this(lVar, "got '" + c4 + "' instead of " + str + " as expected");
    }

    public ParseException(l lVar, String str, String str2) {
        this(lVar, "got \"" + str + "\" instead of \"" + str2 + "\" as expected");
    }

    public ParseException(l lVar, String str, char[] cArr) {
        this(lVar, str, new String(cArr));
    }
}
