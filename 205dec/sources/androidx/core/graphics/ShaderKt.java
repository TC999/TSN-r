package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import d2.l;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Shader.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004H\u0086\b\u00a8\u0006\u0007"}, d2 = {"Landroid/graphics/Shader;", "Lkotlin/Function1;", "Landroid/graphics/Matrix;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "block", "transform", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ShaderKt {
    public static final void transform(@NotNull Shader transform, @NotNull l<? super Matrix, f1> block) {
        f0.q(transform, "$this$transform");
        f0.q(block, "block");
        Matrix matrix = new Matrix();
        transform.getLocalMatrix(matrix);
        block.invoke(matrix);
        transform.setLocalMatrix(matrix);
    }
}
