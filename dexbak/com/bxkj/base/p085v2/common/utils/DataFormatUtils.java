package com.bxkj.base.p085v2.common.utils;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0005H\u0007R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\b¨\u0006\f"}, m12616d2 = {"Lcom/bxkj/base/v2/common/utils/d;", "", RtspHeaders.Values.TIME, "", "a", "", "b", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "simpleDateFormat", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.common.utils.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class DataFormatUtils {
    @NotNull

    /* renamed from: a */
    public static final DataFormatUtils f15112a = new DataFormatUtils();
    @NotNull

    /* renamed from: b */
    private static SimpleDateFormat f15113b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private DataFormatUtils() {
    }

    @JvmStatic
    @NotNull
    /* renamed from: a */
    public static final String m43808a(@Nullable Object obj) {
        try {
            String format = f15113b.format(new Date(Long.parseLong(String.valueOf(obj))));
            C14342f0.m8185o(format, "{\n            simpleDate…ng().toLong()))\n        }");
            return format;
        } catch (Exception unused) {
            return "";
        }
    }

    @JvmStatic
    @NotNull
    /* renamed from: b */
    public static final String m43807b(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(new Date(j * 1000));
        C14342f0.m8185o(format, "SimpleDateFormat(\"HH:mm:…format(Date(time * 1000))");
        return format;
    }
}
