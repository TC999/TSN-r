package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: modifierChecks.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f58463a;

    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends c {
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final a f58464b = new a();

        private a() {
            super(false, null);
        }
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends c {
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final String f58465b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull String error) {
            super(false, null);
            f0.p(error, "error");
            this.f58465b = error;
        }
    }

    /* compiled from: modifierChecks.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.util.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1187c extends c {
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final C1187c f58466b = new C1187c();

        private C1187c() {
            super(true, null);
        }
    }

    private c(boolean z3) {
        this.f58463a = z3;
    }

    public /* synthetic */ c(boolean z3, u uVar) {
        this(z3);
    }

    public final boolean a() {
        return this.f58463a;
    }
}
