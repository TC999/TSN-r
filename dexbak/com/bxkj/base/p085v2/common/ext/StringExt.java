package com.bxkj.base.p085v2.common.ext;

import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0016\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¨\u0006\u0004"}, m12616d2 = {"", IjkMediaMeta.IJKM_KEY_FORMAT, "", "a", "base_release"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.common.ext.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class StringExt {
    /* renamed from: a */
    public static final long m43820a(@NotNull String str, @Nullable String str2) {
        C14342f0.m8184p(str, "<this>");
        try {
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* renamed from: b */
    public static /* synthetic */ long m43819b(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "yyyy-MM-dd HH:mm:ss";
        }
        return m43820a(str, str2);
    }
}
