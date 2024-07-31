package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.RequiresApi;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f¨\u0006\f"}, m12616d2 = {"and", "Landroid/graphics/Path;", "p", "flatten", "", "Landroidx/core/graphics/PathSegment;", "error", "", "minus", "or", "plus", "xor", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.core.graphics.PathKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Path {
    @RequiresApi(19)
    @NotNull
    public static final android.graphics.Path and(@NotNull android.graphics.Path and, @NotNull android.graphics.Path p) {
        C14342f0.m8183q(and, "$this$and");
        C14342f0.m8183q(p, "p");
        android.graphics.Path path = new android.graphics.Path();
        path.op(and, p, Path.Op.INTERSECT);
        return path;
    }

    @RequiresApi(26)
    @NotNull
    public static final Iterable<PathSegment> flatten(@NotNull android.graphics.Path flatten, float f) {
        C14342f0.m8183q(flatten, "$this$flatten");
        Collection<PathSegment> flatten2 = PathUtils.flatten(flatten, f);
        C14342f0.m8192h(flatten2, "PathUtils.flatten(this, error)");
        return flatten2;
    }

    public static /* synthetic */ Iterable flatten$default(android.graphics.Path path, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.5f;
        }
        return flatten(path, f);
    }

    @RequiresApi(19)
    @NotNull
    public static final android.graphics.Path minus(@NotNull android.graphics.Path minus, @NotNull android.graphics.Path p) {
        C14342f0.m8183q(minus, "$this$minus");
        C14342f0.m8183q(p, "p");
        android.graphics.Path path = new android.graphics.Path(minus);
        path.op(p, Path.Op.DIFFERENCE);
        return path;
    }

    @RequiresApi(19)
    @NotNull
    /* renamed from: or */
    public static final android.graphics.Path m60029or(@NotNull android.graphics.Path or, @NotNull android.graphics.Path p) {
        C14342f0.m8183q(or, "$this$or");
        C14342f0.m8183q(p, "p");
        android.graphics.Path path = new android.graphics.Path(or);
        path.op(p, Path.Op.UNION);
        return path;
    }

    @RequiresApi(19)
    @NotNull
    public static final android.graphics.Path plus(@NotNull android.graphics.Path plus, @NotNull android.graphics.Path p) {
        C14342f0.m8183q(plus, "$this$plus");
        C14342f0.m8183q(p, "p");
        android.graphics.Path path = new android.graphics.Path(plus);
        path.op(p, Path.Op.UNION);
        return path;
    }

    @RequiresApi(19)
    @NotNull
    public static final android.graphics.Path xor(@NotNull android.graphics.Path xor, @NotNull android.graphics.Path p) {
        C14342f0.m8183q(xor, "$this$xor");
        C14342f0.m8183q(p, "p");
        android.graphics.Path path = new android.graphics.Path(xor);
        path.op(p, Path.Op.XOR);
        return path;
    }
}
