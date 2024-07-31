package androidx.core.text;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0086\b¨\u0006\u0002"}, m12616d2 = {"htmlEncode", "", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.core.text.StringKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class String {
    @NotNull
    public static final java.lang.String htmlEncode(@NotNull java.lang.String htmlEncode) {
        C14342f0.m8183q(htmlEncode, "$this$htmlEncode");
        java.lang.String htmlEncode2 = TextUtils.htmlEncode(htmlEncode);
        C14342f0.m8192h(htmlEncode2, "TextUtils.htmlEncode(this)");
        return htmlEncode2;
    }
}
