package com.github.aachartmodel.aainfographics.aatools;

import com.snail.antifake.deviceid.ShellAdbUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.StringsJVM;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAJSStringPurer.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0007"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aatools/AAJSStringPurer;", "", "()V", "pureAnonymousJSFunctionString", "", "JSStr", "pureJavaScriptFunctionString", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
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
        String m6568k2;
        String m6568k22;
        String m6568k23;
        String m6568k24;
        String m6568k25;
        String m6568k26;
        String m6568k27;
        String m6568k28;
        String m6568k29;
        String m6568k210;
        C14342f0.m8184p(JSStr, "JSStr");
        m6568k2 = StringsJVM.m6568k2(JSStr, "'", "\"", false, 4, null);
        m6568k22 = StringsJVM.m6568k2(m6568k2, "\u0000", "", false, 4, null);
        m6568k23 = StringsJVM.m6568k2(m6568k22, ShellAdbUtils.f33810d, "", false, 4, null);
        m6568k24 = StringsJVM.m6568k2(m6568k23, "\\", "\\\\", false, 4, null);
        m6568k25 = StringsJVM.m6568k2(m6568k24, "\"", "\\\"", false, 4, null);
        m6568k26 = StringsJVM.m6568k2(m6568k25, "'", "\\'", false, 4, null);
        m6568k27 = StringsJVM.m6568k2(m6568k26, ShellAdbUtils.f33810d, "\\n", false, 4, null);
        m6568k28 = StringsJVM.m6568k2(m6568k27, "\r", "\\r", false, 4, null);
        m6568k29 = StringsJVM.m6568k2(m6568k28, "\u2028", "\\u2028", false, 4, null);
        m6568k210 = StringsJVM.m6568k2(m6568k29, "\u2029", "\\u2029", false, 4, null);
        return m6568k210;
    }
}
