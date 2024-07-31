package com.bxkj.base.p085v2.common.utils;

import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\u0007"}, m12616d2 = {"Lcom/bxkj/base/v2/common/utils/n;", "", "number", "", "a", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.common.utils.n */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class NumberFormatUtils {
    @NotNull

    /* renamed from: a */
    public static final NumberFormatUtils f15135a = new NumberFormatUtils();

    private NumberFormatUtils() {
    }

    @JvmStatic
    @NotNull
    /* renamed from: a */
    public static final String m43753a(@Nullable Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Double) {
            String format = NumberFormat.getIntegerInstance().format(((Double) obj).doubleValue());
            C14342f0.m8185o(format, "{\n                Number… as Double)\n            }");
            return format;
        }
        return obj.toString();
    }
}
