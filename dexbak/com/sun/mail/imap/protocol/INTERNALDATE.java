package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.mail.internet.MailDateFormat;

/* renamed from: com.sun.mail.imap.protocol.k */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class INTERNALDATE implements Item {

    /* renamed from: c */
    static final char[] f36144c = {'I', 'N', 'T', 'E', 'R', 'N', 'A', 'L', 'D', 'A', 'T', 'E'};

    /* renamed from: d */
    private static MailDateFormat f36145d = new MailDateFormat();

    /* renamed from: e */
    private static SimpleDateFormat f36146e = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss ", Locale.US);

    /* renamed from: a */
    public int f36147a;

    /* renamed from: b */
    protected Date f36148b;

    public INTERNALDATE(FetchResponse fetchResponse) throws ParsingException {
        this.f36147a = fetchResponse.m16121E();
        fetchResponse.m16408B();
        String m16384w = fetchResponse.m16384w();
        if (m16384w != null) {
            try {
                this.f36148b = f36145d.parse(m16384w);
                return;
            } catch (ParseException unused) {
                throw new ParsingException("INTERNALDATE parse error");
            }
        }
        throw new ParsingException("INTERNALDATE is NIL");
    }

    /* renamed from: a */
    public static String m16115a(Date date) {
        StringBuffer stringBuffer = new StringBuffer();
        synchronized (f36146e) {
            f36146e.format(date, stringBuffer, new FieldPosition(0));
        }
        int i = -date.getTimezoneOffset();
        if (i < 0) {
            stringBuffer.append('-');
            i = -i;
        } else {
            stringBuffer.append('+');
        }
        int i2 = i / 60;
        int i3 = i % 60;
        stringBuffer.append(Character.forDigit(i2 / 10, 10));
        stringBuffer.append(Character.forDigit(i2 % 10, 10));
        stringBuffer.append(Character.forDigit(i3 / 10, 10));
        stringBuffer.append(Character.forDigit(i3 % 10, 10));
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public Date m16114b() {
        return this.f36148b;
    }
}
