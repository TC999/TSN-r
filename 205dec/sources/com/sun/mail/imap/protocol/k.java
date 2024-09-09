package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.mail.internet.MailDateFormat;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: INTERNALDATE.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class k implements l {

    /* renamed from: c  reason: collision with root package name */
    static final char[] f50554c = {'I', 'N', 'T', 'E', 'R', 'N', 'A', 'L', 'D', 'A', 'T', 'E'};

    /* renamed from: d  reason: collision with root package name */
    private static MailDateFormat f50555d = new MailDateFormat();

    /* renamed from: e  reason: collision with root package name */
    private static SimpleDateFormat f50556e = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss ", Locale.US);

    /* renamed from: a  reason: collision with root package name */
    public int f50557a;

    /* renamed from: b  reason: collision with root package name */
    protected Date f50558b;

    public k(f fVar) throws ParsingException {
        this.f50557a = fVar.E();
        fVar.B();
        String w3 = fVar.w();
        if (w3 != null) {
            try {
                this.f50558b = f50555d.parse(w3);
                return;
            } catch (ParseException unused) {
                throw new ParsingException("INTERNALDATE parse error");
            }
        }
        throw new ParsingException("INTERNALDATE is NIL");
    }

    public static String a(Date date) {
        StringBuffer stringBuffer = new StringBuffer();
        synchronized (f50556e) {
            f50556e.format(date, stringBuffer, new FieldPosition(0));
        }
        int i4 = -date.getTimezoneOffset();
        if (i4 < 0) {
            stringBuffer.append('-');
            i4 = -i4;
        } else {
            stringBuffer.append('+');
        }
        int i5 = i4 / 60;
        int i6 = i4 % 60;
        stringBuffer.append(Character.forDigit(i5 / 10, 10));
        stringBuffer.append(Character.forDigit(i5 % 10, 10));
        stringBuffer.append(Character.forDigit(i6 / 10, 10));
        stringBuffer.append(Character.forDigit(i6 % 10, 10));
        return stringBuffer.toString();
    }

    public Date b() {
        return this.f50558b;
    }
}
