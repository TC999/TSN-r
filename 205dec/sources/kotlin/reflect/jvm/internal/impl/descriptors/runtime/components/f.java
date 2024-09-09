package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.p;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectKotlinClass.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f implements p {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final a f56550c = new a(null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f56551a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final KotlinClassHeader f56552b;

    /* compiled from: ReflectKotlinClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @Nullable
        public final f a(@NotNull Class<?> klass) {
            f0.p(klass, "klass");
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.a aVar = new kotlin.reflect.jvm.internal.impl.load.kotlin.header.a();
            c.f56548a.b(klass, aVar);
            KotlinClassHeader l4 = aVar.l();
            if (l4 == null) {
                return null;
            }
            return new f(klass, l4, null);
        }
    }

    private f(Class<?> cls, KotlinClassHeader kotlinClassHeader) {
        this.f56551a = cls;
        this.f56552b = kotlinClassHeader;
    }

    public /* synthetic */ f(Class cls, KotlinClassHeader kotlinClassHeader, u uVar) {
        this(cls, kotlinClassHeader);
    }

    @NotNull
    public final Class<?> a() {
        return this.f56551a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.b c() {
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(this.f56551a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p
    public void d(@NotNull p.d visitor, @Nullable byte[] bArr) {
        f0.p(visitor, "visitor");
        c.f56548a.i(this.f56551a, visitor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p
    @NotNull
    public KotlinClassHeader e() {
        return this.f56552b;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof f) && f0.g(this.f56551a, ((f) obj).f56551a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p
    public void f(@NotNull p.c visitor, @Nullable byte[] bArr) {
        f0.p(visitor, "visitor");
        c.f56548a.b(this.f56551a, visitor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p
    @NotNull
    public String getLocation() {
        String j22;
        String name = this.f56551a.getName();
        f0.o(name, "klass.name");
        j22 = w.j2(name, '.', '/', false, 4, null);
        return f0.C(j22, ".class");
    }

    public int hashCode() {
        return this.f56551a.hashCode();
    }

    @NotNull
    public String toString() {
        return f.class.getName() + ": " + this.f56551a;
    }
}
