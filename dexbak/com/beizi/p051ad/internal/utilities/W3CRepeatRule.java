package com.beizi.p051ad.internal.utilities;

/* renamed from: com.beizi.ad.internal.utilities.W3CRepeatRule */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class W3CRepeatRule {
    private int[] daysInMonth;
    private int[] daysInWeek;
    private int[] daysInYear;
    private String[] exceptionDates;
    private String expires;
    private String frequency;
    private int interval;
    private int[] monthsInYear;
    private int[] weeksInMonth;

    private void W3CRepeatRule() {
    }

    public int[] getDaysInMonth() {
        return this.daysInMonth;
    }

    public int[] getDaysInWeek() {
        return this.daysInWeek;
    }

    public int[] getDaysInYear() {
        return this.daysInYear;
    }

    public String[] getExceptionDates() {
        return this.exceptionDates;
    }

    public String getExpires() {
        return this.expires;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public int getInterval() {
        return this.interval;
    }

    public int[] getMonthsInYear() {
        return this.monthsInYear;
    }

    public int[] getWeeksInMonth() {
        return this.weeksInMonth;
    }

    public void setDaysInMonth(int[] iArr) {
        this.daysInMonth = iArr;
    }

    public void setDaysInWeek(int[] iArr) {
        this.daysInWeek = iArr;
    }

    public void setDaysInYear(int[] iArr) {
        this.daysInYear = iArr;
    }

    public void setExceptionDates(String[] strArr) {
        this.exceptionDates = strArr;
    }

    public void setExpires(String str) {
        this.expires = str;
    }

    public void setFrequency(String str) {
        this.frequency = str;
    }

    public void setInterval(int i) {
        this.interval = i;
    }

    public void setMonthsInYear(int[] iArr) {
        this.monthsInYear = iArr;
    }

    public void setWeeksInMonth(int[] iArr) {
        this.weeksInMonth = iArr;
    }
}
