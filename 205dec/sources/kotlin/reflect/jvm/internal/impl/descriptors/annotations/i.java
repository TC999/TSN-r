package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.p;
import kotlin.r;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: BuiltInAnnotationDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i implements c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.builtins.h f56245a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.c f56246b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f56247c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final p f56248d;

    /* compiled from: BuiltInAnnotationDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<m0> {
        a() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final m0 invoke() {
            return i.this.f56245a.o(i.this.e()).q();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(@NotNull kotlin.reflect.jvm.internal.impl.builtins.h builtIns, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Map<kotlin.reflect.jvm.internal.impl.name.f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> allValueArguments) {
        p c4;
        f0.p(builtIns, "builtIns");
        f0.p(fqName, "fqName");
        f0.p(allValueArguments, "allValueArguments");
        this.f56245a = builtIns;
        this.f56246b = fqName;
        this.f56247c = allValueArguments;
        c4 = r.c(LazyThreadSafetyMode.PUBLICATION, new a());
        this.f56248d = c4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        return this.f56247c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.c e() {
        return this.f56246b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public v0 getSource() {
        v0 NO_SOURCE = v0.f56634a;
        f0.o(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public e0 getType() {
        Object value = this.f56248d.getValue();
        f0.o(value, "<get-type>(...)");
        return (e0) value;
    }
}
