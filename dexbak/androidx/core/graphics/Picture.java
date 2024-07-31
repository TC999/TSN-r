package androidx.core.graphics;

import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\b¨\u0006\n"}, m12616d2 = {"Landroid/graphics/Picture;", "", "width", "height", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "block", "record", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.graphics.PictureKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Picture {
    @NotNull
    public static final android.graphics.Picture record(@NotNull android.graphics.Picture record, int i, int i2, @NotNull InterfaceC15280l<? super Canvas, Unit> block) {
        C14342f0.m8183q(record, "$this$record");
        C14342f0.m8183q(block, "block");
        Canvas c = record.beginRecording(i, i2);
        try {
            C14342f0.m8192h(c, "c");
            block.invoke(c);
            return record;
        } finally {
            InlineMarker.m8228d(1);
            record.endRecording();
            InlineMarker.m8229c(1);
        }
    }
}
