package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import org.jetbrains.annotations.NotNull;

/* compiled from: PackageViewDescriptorFactory.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface a0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f56301a = a.f56302a;

    /* compiled from: PackageViewDescriptorFactory.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f56302a = new a();
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private static final kotlin.reflect.jvm.internal.impl.descriptors.c0<a0> f56303b = new kotlin.reflect.jvm.internal.impl.descriptors.c0<>("PackageViewDescriptorFactory");

        private a() {
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.descriptors.c0<a0> a() {
            return f56303b;
        }
    }

    /* compiled from: PackageViewDescriptorFactory.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b implements a0 {
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final b f56304b = new b();

        private b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a0
        @NotNull
        public kotlin.reflect.jvm.internal.impl.descriptors.l0 a(@NotNull x module, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager) {
            kotlin.jvm.internal.f0.p(module, "module");
            kotlin.jvm.internal.f0.p(fqName, "fqName");
            kotlin.jvm.internal.f0.p(storageManager, "storageManager");
            return new r(module, fqName, storageManager);
        }
    }

    @NotNull
    kotlin.reflect.jvm.internal.impl.descriptors.l0 a(@NotNull x xVar, @NotNull kotlin.reflect.jvm.internal.impl.name.c cVar, @NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar);
}
