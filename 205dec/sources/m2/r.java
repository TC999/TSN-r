package m2;

import java.util.List;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: javaElements.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface r extends q, z {

    /* compiled from: javaElements.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        public static boolean a(@NotNull r rVar) {
            f0.p(rVar, "this");
            return rVar.n() != null;
        }
    }

    boolean K();

    @NotNull
    x getReturnType();

    @NotNull
    List<b0> h();

    @Nullable
    b n();
}
