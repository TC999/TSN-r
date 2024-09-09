package com.github.aachartmodel.aainfographics.aatools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AADateUTC.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006\u00a8\u0006\t"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aatools/AADate;", "", "()V", "AADateUTC", "", "year", "", "month", "day", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AADate {
    public static final AADate INSTANCE = new AADate();

    private AADate() {
    }

    public final long AADateUTC(int i4, int i5, int i6) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(i4);
            sb.append('-');
            sb.append(i5);
            sb.append('-');
            sb.append(i6);
            date = simpleDateFormat.parse(sb.toString());
        } catch (ParseException e4) {
            e4.printStackTrace();
            date = null;
        }
        f0.m(date);
        return date.getTime();
    }
}
