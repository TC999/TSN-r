package com.github.aachartmodel.aainfographics.aatools;

import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAJSStringPurer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aatools/AAJSStringPurer;", "", "()V", "pureAnonymousJSFunctionString", "", "JSStr", "pureJavaScriptFunctionString", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAJSStringPurer {
    public static final AAJSStringPurer INSTANCE = new AAJSStringPurer();

    private AAJSStringPurer() {
    }

    @Nullable
    public final String pureAnonymousJSFunctionString(@Nullable String str) {
        return pureJavaScriptFunctionString('(' + str + ')');
    }

    @NotNull
    public final String pureJavaScriptFunctionString(@NotNull String JSStr) {
        String k22;
        String k23;
        String k24;
        String k25;
        String k26;
        String k27;
        String k28;
        String k29;
        String k210;
        String k211;
        f0.p(JSStr, "JSStr");
        k22 = w.k2(JSStr, "'", "\"", false, 4, null);
        k23 = w.k2(k22, "\u0000", "", false, 4, null);
        k24 = w.k2(k23, "\n", "", false, 4, null);
        k25 = w.k2(k24, "\\", "\\\\", false, 4, null);
        k26 = w.k2(k25, "\"", "\\\"", false, 4, null);
        k27 = w.k2(k26, "'", "\\'", false, 4, null);
        k28 = w.k2(k27, "\n", "\\n", false, 4, null);
        k29 = w.k2(k28, "\r", "\\r", false, 4, null);
        k210 = w.k2(k29, "\u2028", "\\u2028", false, 4, null);
        k211 = w.k2(k210, "\u2029", "\\u2029", false, 4, null);
        return k211;
    }
}
