package m2;

import java.util.Collection;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: javaElements.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface a extends l {

    /* compiled from: javaElements.kt */
    /* renamed from: m2.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1230a {
        public static boolean a(@NotNull a aVar) {
            f0.p(aVar, "this");
            return false;
        }

        public static boolean b(@NotNull a aVar) {
            f0.p(aVar, "this");
            return false;
        }
    }

    boolean D();

    @Nullable
    kotlin.reflect.jvm.internal.impl.name.b c();

    boolean d();

    @NotNull
    Collection<b> getArguments();

    @Nullable
    g t();
}
