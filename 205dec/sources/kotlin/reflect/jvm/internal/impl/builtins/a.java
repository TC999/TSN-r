package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ServiceLoader;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.p;
import kotlin.r;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.storage.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: BuiltInsLoader.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final C1120a f56017a = C1120a.f56018a;

    /* compiled from: BuiltInsLoader.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1120a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ C1120a f56018a = new C1120a();
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private static final p<a> f56019b;

        /* compiled from: BuiltInsLoader.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1121a extends Lambda implements d2.a<a> {

            /* renamed from: a  reason: collision with root package name */
            public static final C1121a f56020a = new C1121a();

            C1121a() {
                super(0);
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final a invoke() {
                Object p22;
                ServiceLoader implementations = ServiceLoader.load(a.class, a.class.getClassLoader());
                f0.o(implementations, "implementations");
                p22 = kotlin.collections.f0.p2(implementations);
                a aVar = (a) p22;
                if (aVar != null) {
                    return aVar;
                }
                throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
            }
        }

        static {
            p<a> c4;
            c4 = r.c(LazyThreadSafetyMode.PUBLICATION, C1121a.f56020a);
            f56019b = c4;
        }

        private C1120a() {
        }

        @NotNull
        public final a a() {
            return f56019b.getValue();
        }
    }

    @NotNull
    h0 a(@NotNull n nVar, @NotNull d0 d0Var, @NotNull Iterable<? extends h2.b> iterable, @NotNull h2.c cVar, @NotNull h2.a aVar, boolean z3);
}
