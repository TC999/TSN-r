package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import h2.c;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: JvmBuiltInsCustomizer.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class b extends kotlin.reflect.jvm.internal.impl.builtins.h {
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public static final a f56157i = new a(null);
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.builtins.h f56158j = new b();

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.builtins.h a() {
            return b.f56158j;
        }
    }

    private b() {
        super(new kotlin.reflect.jvm.internal.impl.storage.f("FallbackBuiltIns"));
        f(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.builtins.h
    @NotNull
    /* renamed from: E0 */
    public c.a M() {
        return c.a.f54735a;
    }
}
