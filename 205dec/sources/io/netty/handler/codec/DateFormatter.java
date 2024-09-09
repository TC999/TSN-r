package io.netty.handler.codec;

import io.netty.util.AsciiString;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import java.util.BitSet;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class DateFormatter {
    private static final String[] CALENDAR_MONTH_TO_SHORT_NAME;
    private static final String[] DAY_OF_WEEK_TO_SHORT_NAME;
    private static final BitSet DELIMITERS;
    private static final FastThreadLocal<DateFormatter> INSTANCES;
    private final GregorianCalendar cal;
    private int dayOfMonth;
    private boolean dayOfMonthFound;
    private int hours;
    private int minutes;
    private int month;
    private boolean monthFound;
    private final StringBuilder sb;
    private int seconds;
    private boolean timeFound;
    private int year;
    private boolean yearFound;

    static {
        BitSet bitSet = new BitSet();
        DELIMITERS = bitSet;
        bitSet.set(9);
        for (char c4 = ' '; c4 <= '/'; c4 = (char) (c4 + 1)) {
            DELIMITERS.set(c4);
        }
        for (char c5 = ';'; c5 <= '@'; c5 = (char) (c5 + 1)) {
            DELIMITERS.set(c5);
        }
        for (char c6 = '['; c6 <= '`'; c6 = (char) (c6 + 1)) {
            DELIMITERS.set(c6);
        }
        for (char c7 = '{'; c7 <= '~'; c7 = (char) (c7 + 1)) {
            DELIMITERS.set(c7);
        }
        DAY_OF_WEEK_TO_SHORT_NAME = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        CALENDAR_MONTH_TO_SHORT_NAME = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        INSTANCES = new FastThreadLocal<DateFormatter>() { // from class: io.netty.handler.codec.DateFormatter.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public DateFormatter initialValue() {
                return new DateFormatter();
            }
        };
    }

    public static StringBuilder append(Date date, StringBuilder sb) {
        return formatter().append0((Date) ObjectUtil.checkNotNull(date, "date"), (StringBuilder) ObjectUtil.checkNotNull(sb, "sb"));
    }

    private StringBuilder append0(Date date, StringBuilder sb) {
        this.cal.setTime(date);
        sb.append(DAY_OF_WEEK_TO_SHORT_NAME[this.cal.get(7) - 1]);
        sb.append(", ");
        sb.append(this.cal.get(5));
        sb.append(' ');
        sb.append(CALENDAR_MONTH_TO_SHORT_NAME[this.cal.get(2)]);
        sb.append(' ');
        sb.append(this.cal.get(1));
        sb.append(' ');
        appendZeroLeftPadded(this.cal.get(11), sb).append(':');
        appendZeroLeftPadded(this.cal.get(12), sb).append(':');
        StringBuilder appendZeroLeftPadded = appendZeroLeftPadded(this.cal.get(13), sb);
        appendZeroLeftPadded.append(" GMT");
        return appendZeroLeftPadded;
    }

    private static StringBuilder appendZeroLeftPadded(int i4, StringBuilder sb) {
        if (i4 < 10) {
            sb.append('0');
        }
        sb.append(i4);
        return sb;
    }

    private Date computeDate() {
        this.cal.set(5, this.dayOfMonth);
        this.cal.set(2, this.month);
        this.cal.set(1, this.year);
        this.cal.set(11, this.hours);
        this.cal.set(12, this.minutes);
        this.cal.set(13, this.seconds);
        return this.cal.getTime();
    }

    public static String format(Date date) {
        return formatter().format0((Date) ObjectUtil.checkNotNull(date, "date"));
    }

    private String format0(Date date) {
        append0(date, this.sb);
        return this.sb.toString();
    }

    private static DateFormatter formatter() {
        DateFormatter dateFormatter = INSTANCES.get();
        dateFormatter.reset();
        return dateFormatter;
    }

    private static int getNumericalValue(char c4) {
        return c4 - '0';
    }

    private static boolean isDelim(char c4) {
        return DELIMITERS.get(c4);
    }

    private static boolean isDigit(char c4) {
        return c4 >= '0' && c4 <= '9';
    }

    private boolean normalizeAndValidate() {
        int i4 = this.dayOfMonth;
        if (i4 < 1 || i4 > 31 || this.hours > 23 || this.minutes > 59 || this.seconds > 59) {
            return false;
        }
        int i5 = this.year;
        if (i5 >= 70 && i5 <= 99) {
            this.year = i5 + 1900;
        } else if (i5 >= 0 && i5 < 70) {
            this.year = i5 + 2000;
        } else if (i5 < 1601) {
            return false;
        }
        return true;
    }

    private Date parse0(CharSequence charSequence, int i4, int i5) {
        if (parse1(charSequence, i4, i5) && normalizeAndValidate()) {
            return computeDate();
        }
        return null;
    }

    private boolean parse1(CharSequence charSequence, int i4, int i5) {
        int i6 = -1;
        while (i4 < i5) {
            if (isDelim(charSequence.charAt(i4))) {
                if (i6 == -1) {
                    continue;
                } else if (parseToken(charSequence, i6, i4)) {
                    return true;
                } else {
                    i6 = -1;
                }
            } else if (i6 == -1) {
                i6 = i4;
            }
            i4++;
        }
        return i6 != -1 && parseToken(charSequence, i6, charSequence.length());
    }

    public static Date parseHttpDate(CharSequence charSequence) {
        return parseHttpDate(charSequence, 0, charSequence.length());
    }

    private boolean parseToken(CharSequence charSequence, int i4, int i5) {
        if (!this.timeFound) {
            boolean tryParseTime = tryParseTime(charSequence, i4, i5);
            this.timeFound = tryParseTime;
            if (tryParseTime) {
                return this.dayOfMonthFound && this.monthFound && this.yearFound;
            }
        }
        if (!this.dayOfMonthFound) {
            boolean tryParseDayOfMonth = tryParseDayOfMonth(charSequence, i4, i5);
            this.dayOfMonthFound = tryParseDayOfMonth;
            if (tryParseDayOfMonth) {
                return this.timeFound && this.monthFound && this.yearFound;
            }
        }
        if (!this.monthFound) {
            boolean tryParseMonth = tryParseMonth(charSequence, i4, i5);
            this.monthFound = tryParseMonth;
            if (tryParseMonth) {
                return this.timeFound && this.dayOfMonthFound && this.yearFound;
            }
        }
        if (!this.yearFound) {
            this.yearFound = tryParseYear(charSequence, i4, i5);
        }
        return this.timeFound && this.dayOfMonthFound && this.monthFound && this.yearFound;
    }

    private boolean tryParseDayOfMonth(CharSequence charSequence, int i4, int i5) {
        int i6 = i5 - i4;
        if (i6 == 1) {
            char charAt = charSequence.charAt(i4);
            if (isDigit(charAt)) {
                this.dayOfMonth = getNumericalValue(charAt);
                return true;
            }
            return false;
        } else if (i6 == 2) {
            char charAt2 = charSequence.charAt(i4);
            char charAt3 = charSequence.charAt(i4 + 1);
            if (isDigit(charAt2) && isDigit(charAt3)) {
                this.dayOfMonth = (getNumericalValue(charAt2) * 10) + getNumericalValue(charAt3);
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    private boolean tryParseMonth(CharSequence charSequence, int i4, int i5) {
        if (i5 - i4 != 3) {
            return false;
        }
        char lowerCase = AsciiString.toLowerCase(charSequence.charAt(i4));
        char lowerCase2 = AsciiString.toLowerCase(charSequence.charAt(i4 + 1));
        char lowerCase3 = AsciiString.toLowerCase(charSequence.charAt(i4 + 2));
        if (lowerCase == 'j' && lowerCase2 == 'a' && lowerCase3 == 'n') {
            this.month = 0;
        } else if (lowerCase == 'f' && lowerCase2 == 'e' && lowerCase3 == 'b') {
            this.month = 1;
        } else if (lowerCase == 'm' && lowerCase2 == 'a' && lowerCase3 == 'r') {
            this.month = 2;
        } else if (lowerCase == 'a' && lowerCase2 == 'p' && lowerCase3 == 'r') {
            this.month = 3;
        } else if (lowerCase == 'm' && lowerCase2 == 'a' && lowerCase3 == 'y') {
            this.month = 4;
        } else if (lowerCase == 'j' && lowerCase2 == 'u' && lowerCase3 == 'n') {
            this.month = 5;
        } else if (lowerCase == 'j' && lowerCase2 == 'u' && lowerCase3 == 'l') {
            this.month = 6;
        } else if (lowerCase == 'a' && lowerCase2 == 'u' && lowerCase3 == 'g') {
            this.month = 7;
        } else if (lowerCase == 's' && lowerCase2 == 'e' && lowerCase3 == 'p') {
            this.month = 8;
        } else if (lowerCase == 'o' && lowerCase2 == 'c' && lowerCase3 == 't') {
            this.month = 9;
        } else if (lowerCase == 'n' && lowerCase2 == 'o' && lowerCase3 == 'v') {
            this.month = 10;
        } else if (lowerCase != 'd' || lowerCase2 != 'e' || lowerCase3 != 'c') {
            return false;
        } else {
            this.month = 11;
        }
        return true;
    }

    private boolean tryParseTime(CharSequence charSequence, int i4, int i5) {
        int i6 = i5 - i4;
        if (i6 >= 5 && i6 <= 8) {
            int i7 = 0;
            int i8 = 0;
            int i9 = -1;
            int i10 = -1;
            int i11 = 0;
            while (i4 < i5) {
                char charAt = charSequence.charAt(i4);
                if (isDigit(charAt)) {
                    i8 = (i8 * 10) + getNumericalValue(charAt);
                    i7++;
                    if (i7 > 2) {
                        return false;
                    }
                } else if (charAt != ':' || i7 == 0) {
                    return false;
                } else {
                    if (i11 != 0) {
                        if (i11 != 1) {
                            return false;
                        }
                        i10 = i8;
                        i8 = i9;
                    }
                    i11++;
                    i9 = i8;
                    i7 = 0;
                    i8 = 0;
                }
                i4++;
            }
            int i12 = i7 > 0 ? i8 : -1;
            if (i9 >= 0 && i10 >= 0 && i12 >= 0) {
                this.hours = i9;
                this.minutes = i10;
                this.seconds = i12;
                return true;
            }
        }
        return false;
    }

    private boolean tryParseYear(CharSequence charSequence, int i4, int i5) {
        int i6 = i5 - i4;
        if (i6 == 2) {
            char charAt = charSequence.charAt(i4);
            char charAt2 = charSequence.charAt(i4 + 1);
            if (isDigit(charAt) && isDigit(charAt2)) {
                this.year = (getNumericalValue(charAt) * 10) + getNumericalValue(charAt2);
                return true;
            }
            return false;
        } else if (i6 == 4) {
            char charAt3 = charSequence.charAt(i4);
            char charAt4 = charSequence.charAt(i4 + 1);
            char charAt5 = charSequence.charAt(i4 + 2);
            char charAt6 = charSequence.charAt(i4 + 3);
            if (isDigit(charAt3) && isDigit(charAt4) && isDigit(charAt5) && isDigit(charAt6)) {
                this.year = (getNumericalValue(charAt3) * 1000) + (getNumericalValue(charAt4) * 100) + (getNumericalValue(charAt5) * 10) + getNumericalValue(charAt6);
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    public void reset() {
        this.timeFound = false;
        this.hours = -1;
        this.minutes = -1;
        this.seconds = -1;
        this.dayOfMonthFound = false;
        this.dayOfMonth = -1;
        this.monthFound = false;
        this.month = -1;
        this.yearFound = false;
        this.year = -1;
        this.cal.clear();
        this.sb.setLength(0);
    }

    private DateFormatter() {
        this.cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        this.sb = new StringBuilder(29);
        reset();
    }

    public static Date parseHttpDate(CharSequence charSequence, int i4, int i5) {
        int i6 = i5 - i4;
        if (i6 == 0) {
            return null;
        }
        if (i6 >= 0) {
            if (i6 <= 64) {
                return formatter().parse0((CharSequence) ObjectUtil.checkNotNull(charSequence, "txt"), i4, i5);
            }
            throw new IllegalArgumentException("Can't parse more than 64 chars,looks like a user error or a malformed header");
        }
        throw new IllegalArgumentException("Can't have end < start");
    }
}
