package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import d2.l;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Canvas.kt */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0002\b\u0003H\u0086\b\u001a:\u0010\t\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0002\b\u0003H\u0086\b\u001aD\u0010\r\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0002\b\u0003H\u0086\b\u001aN\u0010\u000e\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0002\b\u0003H\u0086\b\u001a:\u0010\u000f\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0002\b\u0003H\u0086\b\u001a0\u0010\u0012\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0002\b\u0003H\u0086\b\u001a.\u0010\u0015\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0002\b\u0003H\u0086\b\u001a.\u0010\u0015\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00162\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0002\b\u0003H\u0086\b\u001aF\u0010\u0015\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0002\b\u0003H\u0086\b\u001aF\u0010\u0015\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0002\b\u0003H\u0086\b\u001a.\u0010\u0015\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0002\b\u0003H\u0086\b\u00a8\u0006\u001e"}, d2 = {"Landroid/graphics/Canvas;", "Lkotlin/Function1;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "block", "withSave", "", "x", "y", "withTranslation", "degrees", "pivotX", "pivotY", "withRotation", "withScale", "withSkew", "Landroid/graphics/Matrix;", "matrix", "withMatrix", "Landroid/graphics/Rect;", "clipRect", "withClip", "Landroid/graphics/RectF;", "", "left", "top", "right", "bottom", "Landroid/graphics/Path;", "clipPath", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class CanvasKt {
    public static final void withClip(@NotNull Canvas withClip, @NotNull Rect clipRect, @NotNull l<? super Canvas, f1> block) {
        f0.q(withClip, "$this$withClip");
        f0.q(clipRect, "clipRect");
        f0.q(block, "block");
        int save = withClip.save();
        withClip.clipRect(clipRect);
        try {
            block.invoke(withClip);
        } finally {
            c0.d(1);
            withClip.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withMatrix(@NotNull Canvas withMatrix, @NotNull Matrix matrix, @NotNull l<? super Canvas, f1> block) {
        f0.q(withMatrix, "$this$withMatrix");
        f0.q(matrix, "matrix");
        f0.q(block, "block");
        int save = withMatrix.save();
        withMatrix.concat(matrix);
        try {
            block.invoke(withMatrix);
        } finally {
            c0.d(1);
            withMatrix.restoreToCount(save);
            c0.c(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas withMatrix, Matrix matrix, l block, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            matrix = new Matrix();
        }
        f0.q(withMatrix, "$this$withMatrix");
        f0.q(matrix, "matrix");
        f0.q(block, "block");
        int save = withMatrix.save();
        withMatrix.concat(matrix);
        try {
            block.invoke(withMatrix);
        } finally {
            c0.d(1);
            withMatrix.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withRotation(@NotNull Canvas withRotation, float f4, float f5, float f6, @NotNull l<? super Canvas, f1> block) {
        f0.q(withRotation, "$this$withRotation");
        f0.q(block, "block");
        int save = withRotation.save();
        withRotation.rotate(f4, f5, f6);
        try {
            block.invoke(withRotation);
        } finally {
            c0.d(1);
            withRotation.restoreToCount(save);
            c0.c(1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas withRotation, float f4, float f5, float f6, l block, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            f4 = 0.0f;
        }
        if ((i4 & 2) != 0) {
            f5 = 0.0f;
        }
        if ((i4 & 4) != 0) {
            f6 = 0.0f;
        }
        f0.q(withRotation, "$this$withRotation");
        f0.q(block, "block");
        int save = withRotation.save();
        withRotation.rotate(f4, f5, f6);
        try {
            block.invoke(withRotation);
        } finally {
            c0.d(1);
            withRotation.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withSave(@NotNull Canvas withSave, @NotNull l<? super Canvas, f1> block) {
        f0.q(withSave, "$this$withSave");
        f0.q(block, "block");
        int save = withSave.save();
        try {
            block.invoke(withSave);
        } finally {
            c0.d(1);
            withSave.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withScale(@NotNull Canvas withScale, float f4, float f5, float f6, float f7, @NotNull l<? super Canvas, f1> block) {
        f0.q(withScale, "$this$withScale");
        f0.q(block, "block");
        int save = withScale.save();
        withScale.scale(f4, f5, f6, f7);
        try {
            block.invoke(withScale);
        } finally {
            c0.d(1);
            withScale.restoreToCount(save);
            c0.c(1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas withScale, float f4, float f5, float f6, float f7, l block, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            f4 = 1.0f;
        }
        if ((i4 & 2) != 0) {
            f5 = 1.0f;
        }
        if ((i4 & 4) != 0) {
            f6 = 0.0f;
        }
        if ((i4 & 8) != 0) {
            f7 = 0.0f;
        }
        f0.q(withScale, "$this$withScale");
        f0.q(block, "block");
        int save = withScale.save();
        withScale.scale(f4, f5, f6, f7);
        try {
            block.invoke(withScale);
        } finally {
            c0.d(1);
            withScale.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withSkew(@NotNull Canvas withSkew, float f4, float f5, @NotNull l<? super Canvas, f1> block) {
        f0.q(withSkew, "$this$withSkew");
        f0.q(block, "block");
        int save = withSkew.save();
        withSkew.skew(f4, f5);
        try {
            block.invoke(withSkew);
        } finally {
            c0.d(1);
            withSkew.restoreToCount(save);
            c0.c(1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas withSkew, float f4, float f5, l block, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            f4 = 0.0f;
        }
        if ((i4 & 2) != 0) {
            f5 = 0.0f;
        }
        f0.q(withSkew, "$this$withSkew");
        f0.q(block, "block");
        int save = withSkew.save();
        withSkew.skew(f4, f5);
        try {
            block.invoke(withSkew);
        } finally {
            c0.d(1);
            withSkew.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withTranslation(@NotNull Canvas withTranslation, float f4, float f5, @NotNull l<? super Canvas, f1> block) {
        f0.q(withTranslation, "$this$withTranslation");
        f0.q(block, "block");
        int save = withTranslation.save();
        withTranslation.translate(f4, f5);
        try {
            block.invoke(withTranslation);
        } finally {
            c0.d(1);
            withTranslation.restoreToCount(save);
            c0.c(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas withTranslation, float f4, float f5, l block, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            f4 = 0.0f;
        }
        if ((i4 & 2) != 0) {
            f5 = 0.0f;
        }
        f0.q(withTranslation, "$this$withTranslation");
        f0.q(block, "block");
        int save = withTranslation.save();
        withTranslation.translate(f4, f5);
        try {
            block.invoke(withTranslation);
        } finally {
            c0.d(1);
            withTranslation.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withClip(@NotNull Canvas withClip, @NotNull RectF clipRect, @NotNull l<? super Canvas, f1> block) {
        f0.q(withClip, "$this$withClip");
        f0.q(clipRect, "clipRect");
        f0.q(block, "block");
        int save = withClip.save();
        withClip.clipRect(clipRect);
        try {
            block.invoke(withClip);
        } finally {
            c0.d(1);
            withClip.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withClip(@NotNull Canvas withClip, int i4, int i5, int i6, int i7, @NotNull l<? super Canvas, f1> block) {
        f0.q(withClip, "$this$withClip");
        f0.q(block, "block");
        int save = withClip.save();
        withClip.clipRect(i4, i5, i6, i7);
        try {
            block.invoke(withClip);
        } finally {
            c0.d(1);
            withClip.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withClip(@NotNull Canvas withClip, float f4, float f5, float f6, float f7, @NotNull l<? super Canvas, f1> block) {
        f0.q(withClip, "$this$withClip");
        f0.q(block, "block");
        int save = withClip.save();
        withClip.clipRect(f4, f5, f6, f7);
        try {
            block.invoke(withClip);
        } finally {
            c0.d(1);
            withClip.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withClip(@NotNull Canvas withClip, @NotNull Path clipPath, @NotNull l<? super Canvas, f1> block) {
        f0.q(withClip, "$this$withClip");
        f0.q(clipPath, "clipPath");
        f0.q(block, "block");
        int save = withClip.save();
        withClip.clipPath(clipPath);
        try {
            block.invoke(withClip);
        } finally {
            c0.d(1);
            withClip.restoreToCount(save);
            c0.c(1);
        }
    }
}
