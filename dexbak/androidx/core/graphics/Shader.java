package androidx.core.graphics;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086\b¨\u0006\u0007"}, m12616d2 = {"Landroid/graphics/Shader;", "Lkotlin/Function1;", "Landroid/graphics/Matrix;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "block", "transform", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.graphics.ShaderKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Shader {
    public static final void transform(@NotNull android.graphics.Shader transform, @NotNull InterfaceC15280l<? super Matrix, Unit> block) {
        C14342f0.m8183q(transform, "$this$transform");
        C14342f0.m8183q(block, "block");
        Matrix matrix = new Matrix();
        transform.getLocalMatrix(matrix);
        block.invoke(matrix);
        transform.setLocalMatrix(matrix);
    }
}
