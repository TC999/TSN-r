package androidx.core.util;

import android.util.SizeF;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0087\n¨\u0006\u0006"}, m12616d2 = {"component1", "", "Landroid/util/Size;", "", "Landroid/util/SizeF;", "component2", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.core.util.SizeKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Size {
    @RequiresApi(21)
    public static final int component1(@NotNull android.util.Size component1) {
        C14342f0.m8183q(component1, "$this$component1");
        return component1.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(@NotNull android.util.Size component2) {
        C14342f0.m8183q(component2, "$this$component2");
        return component2.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(@NotNull SizeF component1) {
        C14342f0.m8183q(component1, "$this$component1");
        return component1.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(@NotNull SizeF component2) {
        C14342f0.m8183q(component2, "$this$component2");
        return component2.getHeight();
    }
}
