package com.bxkj.base.p085v2.common.ext;

import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¨\u0006\u0003"}, m12616d2 = {"", "", "a", "base_release"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.common.ext.f */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class LongExt {
    @NotNull
    /* renamed from: a */
    public static final String m43844a(long j) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(Long.valueOf(j));
        C14342f0.m8185o(format, "SimpleDateFormat(\"yyyy-M…ocale.CHINA).format(this)");
        return format;
    }
}
