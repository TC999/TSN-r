package javax.mail.internet;

import java.io.PrintStream;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class MailDateFormat extends SimpleDateFormat {
    static boolean debug = false;
    private static final long serialVersionUID = -8148227605210628779L;
    private static TimeZone tz = TimeZone.getTimeZone("GMT");
    private static Calendar cal = new GregorianCalendar(tz);

    public MailDateFormat() {
        super("EEE, d MMM yyyy HH:mm:ss 'XXXXX' (z)", Locale.US);
    }

    private static synchronized Date ourUTC(int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z3) {
        Date time;
        synchronized (MailDateFormat.class) {
            cal.clear();
            cal.setLenient(z3);
            cal.set(1, i4);
            cal.set(2, i5);
            cal.set(5, i6);
            cal.set(11, i7);
            cal.set(12, i8 + i10);
            cal.set(13, i9);
            time = cal.getTime();
        }
        return time;
    }

    private static Date parseDate(char[] cArr, ParsePosition parsePosition, boolean z3) {
        try {
            MailDateParser mailDateParser = new MailDateParser(cArr);
            mailDateParser.skipUntilNumber();
            int parseNumber = mailDateParser.parseNumber();
            if (!mailDateParser.skipIfChar('-')) {
                mailDateParser.skipWhiteSpace();
            }
            int parseMonth = mailDateParser.parseMonth();
            if (!mailDateParser.skipIfChar('-')) {
                mailDateParser.skipWhiteSpace();
            }
            int parseNumber2 = mailDateParser.parseNumber();
            if (parseNumber2 < 50) {
                parseNumber2 += 2000;
            } else if (parseNumber2 < 100) {
                parseNumber2 += 1900;
            }
            mailDateParser.skipWhiteSpace();
            int parseNumber3 = mailDateParser.parseNumber();
            mailDateParser.skipChar(':');
            int parseNumber4 = mailDateParser.parseNumber();
            int i4 = 0;
            int parseNumber5 = mailDateParser.skipIfChar(':') ? mailDateParser.parseNumber() : 0;
            try {
                mailDateParser.skipWhiteSpace();
                i4 = mailDateParser.parseTimeZone();
            } catch (java.text.ParseException unused) {
                if (debug) {
                    PrintStream printStream = System.out;
                    printStream.println("No timezone? : '" + new String(cArr) + "'");
                }
            }
            parsePosition.setIndex(mailDateParser.getIndex());
            return ourUTC(parseNumber2, parseMonth, parseNumber, parseNumber3, parseNumber4, parseNumber5, i4, z3);
        } catch (Exception e4) {
            if (debug) {
                PrintStream printStream2 = System.out;
                printStream2.println("Bad date: '" + new String(cArr) + "'");
                e4.printStackTrace();
            }
            parsePosition.setIndex(1);
            return null;
        }
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        int i4;
        int length = stringBuffer.length();
        super.format(date, stringBuffer, fieldPosition);
        int i5 = length + 25;
        while (stringBuffer.charAt(i5) != 'X') {
            i5++;
        }
        ((SimpleDateFormat) this).calendar.clear();
        ((SimpleDateFormat) this).calendar.setTime(date);
        int i6 = ((SimpleDateFormat) this).calendar.get(15) + ((SimpleDateFormat) this).calendar.get(16);
        if (i6 < 0) {
            i4 = i5 + 1;
            stringBuffer.setCharAt(i5, '-');
            i6 = -i6;
        } else {
            i4 = i5 + 1;
            stringBuffer.setCharAt(i5, '+');
        }
        int i7 = (i6 / 60) / 1000;
        int i8 = i7 / 60;
        int i9 = i7 % 60;
        int i10 = i4 + 1;
        stringBuffer.setCharAt(i4, Character.forDigit(i8 / 10, 10));
        int i11 = i10 + 1;
        stringBuffer.setCharAt(i10, Character.forDigit(i8 % 10, 10));
        stringBuffer.setCharAt(i11, Character.forDigit(i9 / 10, 10));
        stringBuffer.setCharAt(i11 + 1, Character.forDigit(i9 % 10, 10));
        return stringBuffer;
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        return parseDate(str.toCharArray(), parsePosition, isLenient());
    }

    @Override // java.text.DateFormat
    public void setCalendar(Calendar calendar) {
        throw new RuntimeException("Method setCalendar() shouldn't be called");
    }

    @Override // java.text.DateFormat
    public void setNumberFormat(NumberFormat numberFormat) {
        throw new RuntimeException("Method setNumberFormat() shouldn't be called");
    }
}
