package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: DefaultBuiltIns.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e extends h {
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public static final a f56023i = new a(null);
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private static final e f56024j = new e(false, 1, null);

    /* compiled from: DefaultBuiltIns.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @NotNull
        public final e a() {
            return e.f56024j;
        }
    }

    public e() {
        this(false, 1, null);
    }

    public e(boolean z3) {
        super(new kotlin.reflect.jvm.internal.impl.storage.f("DefaultBuiltIns"));
        if (z3) {
            f(false);
        }
    }

    @NotNull
    public static final e E0() {
        return f56023i.a();
    }

    public /* synthetic */ e(boolean z3, int i4, u uVar) {
        this((i4 & 1) != 0 ? true : z3);
    }
}
