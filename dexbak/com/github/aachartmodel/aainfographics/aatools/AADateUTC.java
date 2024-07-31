package com.github.aachartmodel.aainfographics.aatools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aatools/AADate;", "", "()V", "AADateUTC", "", "year", "", "month", "day", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: com.github.aachartmodel.aainfographics.aatools.AADate */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AADateUTC {
    public static final AADateUTC INSTANCE = new AADateUTC();

    private AADateUTC() {
    }

    public final long AADateUTC(int i, int i2, int i3) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append('-');
            sb.append(i2);
            sb.append('-');
            sb.append(i3);
            date = simpleDateFormat.parse(sb.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        C14342f0.m8187m(date);
        return date.getTime();
    }
}
