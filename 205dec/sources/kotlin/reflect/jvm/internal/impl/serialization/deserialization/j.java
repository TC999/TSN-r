package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: DeserializationConfiguration.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface j {

    /* compiled from: DeserializationConfiguration.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements j {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f58137a = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.j
        public boolean a() {
            return b.b(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.j
        public boolean b() {
            return b.e(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.j
        public boolean c() {
            return b.f(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.j
        public boolean d() {
            return b.a(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.j
        public boolean e() {
            return b.d(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.j
        public boolean f() {
            return b.c(this);
        }
    }

    /* compiled from: DeserializationConfiguration.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        public static boolean a(@NotNull j jVar) {
            f0.p(jVar, "this");
            return false;
        }

        public static boolean b(@NotNull j jVar) {
            f0.p(jVar, "this");
            return false;
        }

        public static boolean c(@NotNull j jVar) {
            f0.p(jVar, "this");
            return false;
        }

        public static boolean d(@NotNull j jVar) {
            f0.p(jVar, "this");
            return false;
        }

        public static boolean e(@NotNull j jVar) {
            f0.p(jVar, "this");
            return false;
        }

        public static boolean f(@NotNull j jVar) {
            f0.p(jVar, "this");
            return true;
        }
    }

    boolean a();

    boolean b();

    boolean c();

    boolean d();

    boolean e();

    boolean f();
}
