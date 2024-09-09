package com.bxkj.base.v2.common.utils;

import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: NumberFormatUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/bxkj/base/v2/common/utils/n;", "", "number", "", "a", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class n {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final n f18627a = new n();

    private n() {
    }

    @JvmStatic
    @NotNull
    public static final String a(@Nullable Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Double) {
            String format = NumberFormat.getIntegerInstance().format(((Double) obj).doubleValue());
            f0.o(format, "{\n                Number\u2026 as Double)\n            }");
            return format;
        }
        return obj.toString();
    }
}
