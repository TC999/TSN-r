package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.x;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.o;
import kotlin.reflect.jvm.internal.impl.load.kotlin.p;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: PackagePartScopeCache.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.kotlin.f f56544a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final g f56545b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentHashMap<kotlin.reflect.jvm.internal.impl.name.b, kotlin.reflect.jvm.internal.impl.resolve.scopes.h> f56546c;

    public a(@NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.f resolver, @NotNull g kotlinClassFinder) {
        f0.p(resolver, "resolver");
        f0.p(kotlinClassFinder, "kotlinClassFinder");
        this.f56544a = resolver;
        this.f56545b = kotlinClassFinder;
        this.f56546c = new ConcurrentHashMap<>();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h a(@NotNull f fileClass) {
        Collection<p> l4;
        List G5;
        f0.p(fileClass, "fileClass");
        ConcurrentHashMap<kotlin.reflect.jvm.internal.impl.name.b, kotlin.reflect.jvm.internal.impl.resolve.scopes.h> concurrentHashMap = this.f56546c;
        kotlin.reflect.jvm.internal.impl.name.b c4 = fileClass.c();
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar = concurrentHashMap.get(c4);
        if (hVar == null) {
            kotlin.reflect.jvm.internal.impl.name.c h4 = fileClass.c().h();
            f0.o(h4, "fileClass.classId.packageFqName");
            if (fileClass.e().c() == KotlinClassHeader.Kind.MULTIFILE_CLASS) {
                List<String> f4 = fileClass.e().f();
                l4 = new ArrayList();
                for (String str : f4) {
                    kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(kotlin.reflect.jvm.internal.impl.resolve.jvm.d.d(str).e());
                    f0.o(m4, "topLevel(JvmClassName.by\u2026velClassMaybeWithDollars)");
                    p a4 = o.a(this.f56545b, m4);
                    if (a4 != null) {
                        l4.add(a4);
                    }
                }
            } else {
                l4 = x.l(fileClass);
            }
            kotlin.reflect.jvm.internal.impl.descriptors.impl.m mVar = new kotlin.reflect.jvm.internal.impl.descriptors.impl.m(this.f56544a.e().p(), h4);
            ArrayList arrayList = new ArrayList();
            for (p pVar : l4) {
                kotlin.reflect.jvm.internal.impl.resolve.scopes.h c5 = this.f56544a.c(mVar, pVar);
                if (c5 != null) {
                    arrayList.add(c5);
                }
            }
            G5 = kotlin.collections.f0.G5(arrayList);
            b.a aVar = kotlin.reflect.jvm.internal.impl.resolve.scopes.b.f57884d;
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h a5 = aVar.a("package " + h4 + " (" + fileClass + ')', G5);
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h putIfAbsent = concurrentHashMap.putIfAbsent(c4, a5);
            hVar = putIfAbsent == null ? a5 : putIfAbsent;
        }
        f0.o(hVar, "cache.getOrPut(fileClass\u2026ileClass)\", scopes)\n    }");
        return hVar;
    }
}
