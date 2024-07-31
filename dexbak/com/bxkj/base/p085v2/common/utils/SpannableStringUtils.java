package com.bxkj.base.p085v2.common.utils;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.annotation.ColorInt;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, m12616d2 = {"Lcom/bxkj/base/v2/common/utils/r;", "", "", "string", "", "color", "Landroid/text/SpannableString;", "a", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.common.utils.r */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SpannableStringUtils {
    @NotNull

    /* renamed from: a */
    public static final SpannableStringUtils f15142a = new SpannableStringUtils();

    private SpannableStringUtils() {
    }

    @NotNull
    /* renamed from: a */
    public final SpannableString m43737a(@NotNull CharSequence string, @ColorInt int i) {
        C14342f0.m8184p(string, "string");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, string.length(), 33);
        spannableString.setSpan(new StyleSpan(1), 0, string.length(), 33);
        return spannableString;
    }
}
