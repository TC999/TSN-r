package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
class TimeSource {
    private static final TimeSource SYSTEM_TIME_SOURCE = new TimeSource(null, null);
    @Nullable
    private final Long fixedTimeMs;
    @Nullable
    private final TimeZone fixedTimeZone;

    private TimeSource(@Nullable Long l4, @Nullable TimeZone timeZone) {
        this.fixedTimeMs = l4;
        this.fixedTimeZone = timeZone;
    }

    static TimeSource fixed(long j4, @Nullable TimeZone timeZone) {
        return new TimeSource(Long.valueOf(j4), timeZone);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TimeSource system() {
        return SYSTEM_TIME_SOURCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Calendar now() {
        return now(this.fixedTimeZone);
    }

    static TimeSource fixed(long j4) {
        return new TimeSource(Long.valueOf(j4), null);
    }

    Calendar now(@Nullable TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l4 = this.fixedTimeMs;
        if (l4 != null) {
            calendar.setTimeInMillis(l4.longValue());
        }
        return calendar;
    }
}
