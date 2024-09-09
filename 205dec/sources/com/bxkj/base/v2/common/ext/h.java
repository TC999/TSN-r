package com.bxkj.base.v2.common.ext;

import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: StringExt.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0016\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\u0004"}, d2 = {"", "format", "", "a", "base_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class h {
    public static final long a(@NotNull String str, @Nullable String str2) {
        f0.p(str, "<this>");
        try {
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static /* synthetic */ long b(String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str2 = "yyyy-MM-dd HH:mm:ss";
        }
        return a(str, str2);
    }
}
