package androidx.core.graphics;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Matrix.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003\u001a\u001a\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u001a\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0001H\u0086\b\u00a8\u0006\u0010"}, d2 = {"rotationMatrix", "Landroid/graphics/Matrix;", "degrees", "", "px", "py", "scaleMatrix", "sx", "sy", "translationMatrix", "tx", "ty", "times", "m", "values", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class MatrixKt {
    @NotNull
    public static final Matrix rotationMatrix(float f4, float f5, float f6) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f4, f5, f6);
        return matrix;
    }

    public static /* synthetic */ Matrix rotationMatrix$default(float f4, float f5, float f6, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            f5 = 0.0f;
        }
        if ((i4 & 4) != 0) {
            f6 = 0.0f;
        }
        return rotationMatrix(f4, f5, f6);
    }

    @NotNull
    public static final Matrix scaleMatrix(float f4, float f5) {
        Matrix matrix = new Matrix();
        matrix.setScale(f4, f5);
        return matrix;
    }

    public static /* synthetic */ Matrix scaleMatrix$default(float f4, float f5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            f4 = 1.0f;
        }
        if ((i4 & 2) != 0) {
            f5 = 1.0f;
        }
        return scaleMatrix(f4, f5);
    }

    @NotNull
    public static final Matrix times(@NotNull Matrix times, @NotNull Matrix m4) {
        f0.q(times, "$this$times");
        f0.q(m4, "m");
        Matrix matrix = new Matrix(times);
        matrix.preConcat(m4);
        return matrix;
    }

    @NotNull
    public static final Matrix translationMatrix(float f4, float f5) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f4, f5);
        return matrix;
    }

    public static /* synthetic */ Matrix translationMatrix$default(float f4, float f5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            f4 = 0.0f;
        }
        if ((i4 & 2) != 0) {
            f5 = 0.0f;
        }
        return translationMatrix(f4, f5);
    }

    @NotNull
    public static final float[] values(@NotNull Matrix values) {
        f0.q(values, "$this$values");
        float[] fArr = new float[9];
        values.getValues(fArr);
        return fArr;
    }
}
