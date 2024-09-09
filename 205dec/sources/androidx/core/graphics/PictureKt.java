package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import d2.l;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Picture.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u0007H\u0086\b\u00a8\u0006\n"}, d2 = {"Landroid/graphics/Picture;", "", "width", "height", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "block", "record", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class PictureKt {
    @NotNull
    public static final Picture record(@NotNull Picture record, int i4, int i5, @NotNull l<? super Canvas, f1> block) {
        f0.q(record, "$this$record");
        f0.q(block, "block");
        Canvas c4 = record.beginRecording(i4, i5);
        try {
            f0.h(c4, "c");
            block.invoke(c4);
            return record;
        } finally {
            c0.d(1);
            record.endRecording();
            c0.c(1);
        }
    }
}
