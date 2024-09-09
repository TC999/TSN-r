package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.collections.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaNullabilityAnnotationSettings.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface a0<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f56663a = a.f56664a;

    /* compiled from: JavaNullabilityAnnotationSettings.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f56664a = new a();
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private static final a0 f56665b;

        static {
            Map z3;
            z3 = z0.z();
            f56665b = new b0(z3);
        }

        private a() {
        }

        @NotNull
        public final a0 a() {
            return f56665b;
        }
    }

    @Nullable
    T a(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);
}
