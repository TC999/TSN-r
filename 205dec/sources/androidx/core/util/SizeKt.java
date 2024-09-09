package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Size.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0087\n\u00a8\u0006\u0006"}, d2 = {"component1", "", "Landroid/util/Size;", "", "Landroid/util/SizeF;", "component2", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(@NotNull Size component1) {
        f0.q(component1, "$this$component1");
        return component1.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(@NotNull Size component2) {
        f0.q(component2, "$this$component2");
        return component2.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(@NotNull SizeF component1) {
        f0.q(component1, "$this$component1");
        return component1.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(@NotNull SizeF component2) {
        f0.q(component2, "$this$component2");
        return component2.getHeight();
    }
}
