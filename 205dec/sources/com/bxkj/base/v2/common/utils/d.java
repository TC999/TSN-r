package com.bxkj.base.v2.common.utils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DataFormatUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0005H\u0007R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/bxkj/base/v2/common/utils/d;", "", "time", "", "a", "", "b", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "simpleDateFormat", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final d f18600a = new d();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static SimpleDateFormat f18601b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* compiled from: AndroidDevice.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class a extends Lambda implements d2.l<Byte, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f18602a = new a();

        a() {
            super(1);
        }

        @NotNull
        public final CharSequence a(byte b4) {
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b4)}, 1));
            f0.o(format, "format(this, *args)");
            return format;
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ CharSequence invoke(Byte b4) {
            return a(b4.byteValue());
        }
    }

    /* compiled from: AndroidDevice.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class b extends Lambda implements d2.l<Byte, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f18603a = new b();

        b() {
            super(1);
        }

        @NotNull
        public final CharSequence a(byte b4) {
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b4)}, 1));
            f0.o(format, "format(this, *args)");
            return format;
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ CharSequence invoke(Byte b4) {
            return a(b4.byteValue());
        }
    }

    private d() {
    }

    @JvmStatic
    @NotNull
    public static final String a(@Nullable Object obj) {
        try {
            String format = f18601b.format(new Date(Long.parseLong(String.valueOf(obj))));
            f0.o(format, "{\n            simpleDate\u2026ng().toLong()))\n        }");
            return format;
        } catch (Exception unused) {
            return "";
        }
    }

    @JvmStatic
    @NotNull
    public static final String b(long j4) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(new Date(j4 * 1000));
        f0.o(format, "SimpleDateFormat(\"HH:mm:\u2026format(Date(time * 1000))");
        return format;
    }
}
