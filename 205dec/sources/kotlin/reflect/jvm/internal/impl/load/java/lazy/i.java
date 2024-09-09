package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.m;
import m2.y;
import m2.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: resolvers.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i implements l {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final h f56928a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.k f56929b;

    /* renamed from: c  reason: collision with root package name */
    private final int f56930c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Map<y, Integer> f56931d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.h<y, m> f56932e;

    /* compiled from: resolvers.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.l<y, m> {
        a() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final m invoke(@NotNull y typeParameter) {
            f0.p(typeParameter, "typeParameter");
            Integer num = (Integer) i.this.f56931d.get(typeParameter);
            if (num == null) {
                return null;
            }
            i iVar = i.this;
            return new m(kotlin.reflect.jvm.internal.impl.load.java.lazy.a.h(kotlin.reflect.jvm.internal.impl.load.java.lazy.a.b(iVar.f56928a, iVar), iVar.f56929b.getAnnotations()), typeParameter, iVar.f56930c + num.intValue(), iVar.f56929b);
        }
    }

    public i(@NotNull h c4, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration, @NotNull z typeParameterOwner, int i4) {
        f0.p(c4, "c");
        f0.p(containingDeclaration, "containingDeclaration");
        f0.p(typeParameterOwner, "typeParameterOwner");
        this.f56928a = c4;
        this.f56929b = containingDeclaration;
        this.f56930c = i4;
        this.f56931d = kotlin.reflect.jvm.internal.impl.utils.a.d(typeParameterOwner.getTypeParameters());
        this.f56932e = c4.e().e(new a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.l
    @Nullable
    public a1 a(@NotNull y javaTypeParameter) {
        f0.p(javaTypeParameter, "javaTypeParameter");
        m invoke = this.f56932e.invoke(javaTypeParameter);
        return invoke == null ? this.f56928a.f().a(javaTypeParameter) : invoke;
    }
}
