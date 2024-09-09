package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import m2.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: resolvers.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface l {

    /* compiled from: resolvers.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements l {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f56935a = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.l
        @Nullable
        public a1 a(@NotNull y javaTypeParameter) {
            f0.p(javaTypeParameter, "javaTypeParameter");
            return null;
        }
    }

    @Nullable
    a1 a(@NotNull y yVar);
}
