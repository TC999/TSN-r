package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: LazyScopeAdapter.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g extends kotlin.reflect.jvm.internal.impl.resolve.scopes.a {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<h> f57925b;

    /* compiled from: LazyScopeAdapter.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<h> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.a<h> f57926a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(d2.a<? extends h> aVar) {
            super(0);
            this.f57926a = aVar;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final h invoke() {
            h invoke = this.f57926a.invoke();
            return invoke instanceof kotlin.reflect.jvm.internal.impl.resolve.scopes.a ? ((kotlin.reflect.jvm.internal.impl.resolve.scopes.a) invoke).i() : invoke;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public g(@NotNull d2.a<? extends h> getScope) {
        this(null, getScope, 1, null);
        f0.p(getScope, "getScope");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ g(kotlin.reflect.jvm.internal.impl.storage.n r1, d2.a r2, int r3, kotlin.jvm.internal.u r4) {
        /*
            r0 = this;
            r3 = r3 & 1
            if (r3 == 0) goto Lb
            kotlin.reflect.jvm.internal.impl.storage.n r1 = kotlin.reflect.jvm.internal.impl.storage.f.f58216e
            java.lang.String r3 = "NO_LOCKS"
            kotlin.jvm.internal.f0.o(r1, r3)
        Lb:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.scopes.g.<init>(kotlin.reflect.jvm.internal.impl.storage.n, d2.a, int, kotlin.jvm.internal.u):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.a
    @NotNull
    protected h j() {
        return this.f57925b.invoke();
    }

    @JvmOverloads
    public g(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull d2.a<? extends h> getScope) {
        f0.p(storageManager, "storageManager");
        f0.p(getScope, "getScope");
        this.f57925b = storageManager.g(new a(getScope));
    }
}
