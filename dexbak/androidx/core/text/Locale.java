package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m12616d2 = {"layoutDirection", "", "Ljava/util/Locale;", "getLayoutDirection", "(Ljava/util/Locale;)I", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.core.text.LocaleKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Locale {
    @RequiresApi(17)
    public static final int getLayoutDirection(@NotNull java.util.Locale layoutDirection) {
        C14342f0.m8183q(layoutDirection, "$this$layoutDirection");
        return TextUtils.getLayoutDirectionFromLocale(layoutDirection);
    }
}
