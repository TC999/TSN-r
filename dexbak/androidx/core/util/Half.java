package androidx.core.util;

import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, m12616d2 = {"toHalf", "Landroid/util/Half;", "", "", "", "", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.core.util.HalfKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Half {
    @RequiresApi(26)
    @NotNull
    public static final android.util.Half toHalf(short s) {
        android.util.Half valueOf = android.util.Half.valueOf(s);
        C14342f0.m8192h(valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final android.util.Half toHalf(float f) {
        android.util.Half valueOf = android.util.Half.valueOf(f);
        C14342f0.m8192h(valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final android.util.Half toHalf(@NotNull String toHalf) {
        C14342f0.m8183q(toHalf, "$this$toHalf");
        android.util.Half valueOf = android.util.Half.valueOf(toHalf);
        C14342f0.m8192h(valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final android.util.Half toHalf(double d) {
        android.util.Half valueOf = android.util.Half.valueOf((float) d);
        C14342f0.m8192h(valueOf, "Half.valueOf(this)");
        return valueOf;
    }
}
