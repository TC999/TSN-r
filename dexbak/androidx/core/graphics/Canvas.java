package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.beizi.fusion.widget.ScrollClickView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\u0086\b\u001a:\u0010\t\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\u0086\b\u001aD\u0010\r\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\u0086\b\u001aN\u0010\u000e\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\u0086\b\u001a:\u0010\u000f\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\u0086\b\u001a0\u0010\u0012\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\u0086\b\u001a.\u0010\u0015\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\u0086\b\u001a.\u0010\u0015\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00162\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\u0086\b\u001aF\u0010\u0015\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\u0086\b\u001aF\u0010\u0015\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\u0086\b\u001a.\u0010\u0015\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\u0086\b¨\u0006\u001e"}, m12616d2 = {"Landroid/graphics/Canvas;", "Lkotlin/Function1;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "block", "withSave", "", "x", "y", "withTranslation", "degrees", "pivotX", "pivotY", "withRotation", "withScale", "withSkew", "Landroid/graphics/Matrix;", "matrix", "withMatrix", "Landroid/graphics/Rect;", "clipRect", "withClip", "Landroid/graphics/RectF;", "", ScrollClickView.DIR_LEFT, "top", ScrollClickView.DIR_RIGHT, "bottom", "Landroid/graphics/Path;", "clipPath", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.graphics.CanvasKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Canvas {
    public static final void withClip(@NotNull android.graphics.Canvas withClip, @NotNull Rect clipRect, @NotNull InterfaceC15280l<? super android.graphics.Canvas, Unit> block) {
        C14342f0.m8183q(withClip, "$this$withClip");
        C14342f0.m8183q(clipRect, "clipRect");
        C14342f0.m8183q(block, "block");
        int save = withClip.save();
        withClip.clipRect(clipRect);
        try {
            block.invoke(withClip);
        } finally {
            InlineMarker.m8228d(1);
            withClip.restoreToCount(save);
            InlineMarker.m8229c(1);
        }
    }

    public static final void withMatrix(@NotNull android.graphics.Canvas withMatrix, @NotNull Matrix matrix, @NotNull InterfaceC15280l<? super android.graphics.Canvas, Unit> block) {
        C14342f0.m8183q(withMatrix, "$this$withMatrix");
        C14342f0.m8183q(matrix, "matrix");
        C14342f0.m8183q(block, "block");
        int save = withMatrix.save();
        withMatrix.concat(matrix);
        try {
            block.invoke(withMatrix);
        } finally {
            InlineMarker.m8228d(1);
            withMatrix.restoreToCount(save);
            InlineMarker.m8229c(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(android.graphics.Canvas withMatrix, Matrix matrix, InterfaceC15280l block, int i, Object obj) {
        if ((i & 1) != 0) {
            matrix = new Matrix();
        }
        C14342f0.m8183q(withMatrix, "$this$withMatrix");
        C14342f0.m8183q(matrix, "matrix");
        C14342f0.m8183q(block, "block");
        int save = withMatrix.save();
        withMatrix.concat(matrix);
        try {
            block.invoke(withMatrix);
        } finally {
            InlineMarker.m8228d(1);
            withMatrix.restoreToCount(save);
            InlineMarker.m8229c(1);
        }
    }

    public static final void withRotation(@NotNull android.graphics.Canvas withRotation, float f, float f2, float f3, @NotNull InterfaceC15280l<? super android.graphics.Canvas, Unit> block) {
        C14342f0.m8183q(withRotation, "$this$withRotation");
        C14342f0.m8183q(block, "block");
        int save = withRotation.save();
        withRotation.rotate(f, f2, f3);
        try {
            block.invoke(withRotation);
        } finally {
            InlineMarker.m8228d(1);
            withRotation.restoreToCount(save);
            InlineMarker.m8229c(1);
        }
    }

    public static /* synthetic */ void withRotation$default(android.graphics.Canvas withRotation, float f, float f2, float f3, InterfaceC15280l block, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        C14342f0.m8183q(withRotation, "$this$withRotation");
        C14342f0.m8183q(block, "block");
        int save = withRotation.save();
        withRotation.rotate(f, f2, f3);
        try {
            block.invoke(withRotation);
        } finally {
            InlineMarker.m8228d(1);
            withRotation.restoreToCount(save);
            InlineMarker.m8229c(1);
        }
    }

    public static final void withSave(@NotNull android.graphics.Canvas withSave, @NotNull InterfaceC15280l<? super android.graphics.Canvas, Unit> block) {
        C14342f0.m8183q(withSave, "$this$withSave");
        C14342f0.m8183q(block, "block");
        int save = withSave.save();
        try {
            block.invoke(withSave);
        } finally {
            InlineMarker.m8228d(1);
            withSave.restoreToCount(save);
            InlineMarker.m8229c(1);
        }
    }

    public static final void withScale(@NotNull android.graphics.Canvas withScale, float f, float f2, float f3, float f4, @NotNull InterfaceC15280l<? super android.graphics.Canvas, Unit> block) {
        C14342f0.m8183q(withScale, "$this$withScale");
        C14342f0.m8183q(block, "block");
        int save = withScale.save();
        withScale.scale(f, f2, f3, f4);
        try {
            block.invoke(withScale);
        } finally {
            InlineMarker.m8228d(1);
            withScale.restoreToCount(save);
            InlineMarker.m8229c(1);
        }
    }

    public static /* synthetic */ void withScale$default(android.graphics.Canvas withScale, float f, float f2, float f3, float f4, InterfaceC15280l block, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        C14342f0.m8183q(withScale, "$this$withScale");
        C14342f0.m8183q(block, "block");
        int save = withScale.save();
        withScale.scale(f, f2, f3, f4);
        try {
            block.invoke(withScale);
        } finally {
            InlineMarker.m8228d(1);
            withScale.restoreToCount(save);
            InlineMarker.m8229c(1);
        }
    }

    public static final void withSkew(@NotNull android.graphics.Canvas withSkew, float f, float f2, @NotNull InterfaceC15280l<? super android.graphics.Canvas, Unit> block) {
        C14342f0.m8183q(withSkew, "$this$withSkew");
        C14342f0.m8183q(block, "block");
        int save = withSkew.save();
        withSkew.skew(f, f2);
        try {
            block.invoke(withSkew);
        } finally {
            InlineMarker.m8228d(1);
            withSkew.restoreToCount(save);
            InlineMarker.m8229c(1);
        }
    }

    public static /* synthetic */ void withSkew$default(android.graphics.Canvas withSkew, float f, float f2, InterfaceC15280l block, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        C14342f0.m8183q(withSkew, "$this$withSkew");
        C14342f0.m8183q(block, "block");
        int save = withSkew.save();
        withSkew.skew(f, f2);
        try {
            block.invoke(withSkew);
        } finally {
            InlineMarker.m8228d(1);
            withSkew.restoreToCount(save);
            InlineMarker.m8229c(1);
        }
    }

    public static final void withTranslation(@NotNull android.graphics.Canvas withTranslation, float f, float f2, @NotNull InterfaceC15280l<? super android.graphics.Canvas, Unit> block) {
        C14342f0.m8183q(withTranslation, "$this$withTranslation");
        C14342f0.m8183q(block, "block");
        int save = withTranslation.save();
        withTranslation.translate(f, f2);
        try {
            block.invoke(withTranslation);
        } finally {
            InlineMarker.m8228d(1);
            withTranslation.restoreToCount(save);
            InlineMarker.m8229c(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(android.graphics.Canvas withTranslation, float f, float f2, InterfaceC15280l block, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        C14342f0.m8183q(withTranslation, "$this$withTranslation");
        C14342f0.m8183q(block, "block");
        int save = withTranslation.save();
        withTranslation.translate(f, f2);
        try {
            block.invoke(withTranslation);
        } finally {
            InlineMarker.m8228d(1);
            withTranslation.restoreToCount(save);
            InlineMarker.m8229c(1);
        }
    }

    public static final void withClip(@NotNull android.graphics.Canvas withClip, @NotNull RectF clipRect, @NotNull InterfaceC15280l<? super android.graphics.Canvas, Unit> block) {
        C14342f0.m8183q(withClip, "$this$withClip");
        C14342f0.m8183q(clipRect, "clipRect");
        C14342f0.m8183q(block, "block");
        int save = withClip.save();
        withClip.clipRect(clipRect);
        try {
            block.invoke(withClip);
        } finally {
            InlineMarker.m8228d(1);
            withClip.restoreToCount(save);
            InlineMarker.m8229c(1);
        }
    }

    public static final void withClip(@NotNull android.graphics.Canvas withClip, int i, int i2, int i3, int i4, @NotNull InterfaceC15280l<? super android.graphics.Canvas, Unit> block) {
        C14342f0.m8183q(withClip, "$this$withClip");
        C14342f0.m8183q(block, "block");
        int save = withClip.save();
        withClip.clipRect(i, i2, i3, i4);
        try {
            block.invoke(withClip);
        } finally {
            InlineMarker.m8228d(1);
            withClip.restoreToCount(save);
            InlineMarker.m8229c(1);
        }
    }

    public static final void withClip(@NotNull android.graphics.Canvas withClip, float f, float f2, float f3, float f4, @NotNull InterfaceC15280l<? super android.graphics.Canvas, Unit> block) {
        C14342f0.m8183q(withClip, "$this$withClip");
        C14342f0.m8183q(block, "block");
        int save = withClip.save();
        withClip.clipRect(f, f2, f3, f4);
        try {
            block.invoke(withClip);
        } finally {
            InlineMarker.m8228d(1);
            withClip.restoreToCount(save);
            InlineMarker.m8229c(1);
        }
    }

    public static final void withClip(@NotNull android.graphics.Canvas withClip, @NotNull Path clipPath, @NotNull InterfaceC15280l<? super android.graphics.Canvas, Unit> block) {
        C14342f0.m8183q(withClip, "$this$withClip");
        C14342f0.m8183q(clipPath, "clipPath");
        C14342f0.m8183q(block, "block");
        int save = withClip.save();
        withClip.clipPath(clipPath);
        try {
            block.invoke(withClip);
        } finally {
            InlineMarker.m8228d(1);
            withClip.restoreToCount(save);
            InlineMarker.m8229c(1);
        }
    }
}
