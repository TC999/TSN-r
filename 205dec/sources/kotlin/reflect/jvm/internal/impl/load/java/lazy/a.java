package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.p;
import kotlin.r;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import kotlin.reflect.jvm.internal.impl.load.java.b;
import kotlin.reflect.jvm.internal.impl.load.java.v;
import m2.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: context.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {

    /* compiled from: context.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.a$a */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1136a extends Lambda implements d2.a<v> {

        /* renamed from: a */
        final /* synthetic */ h f56745a;

        /* renamed from: b */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.e f56746b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1136a(h hVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            super(0);
            this.f56745a = hVar;
            this.f56746b = eVar;
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final v invoke() {
            return a.g(this.f56745a, this.f56746b.getAnnotations());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: context.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.a<v> {

        /* renamed from: a */
        final /* synthetic */ h f56747a;

        /* renamed from: b */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.annotations.f f56748b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(h hVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar) {
            super(0);
            this.f56747a = hVar;
            this.f56748b = fVar;
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final v invoke() {
            return a.g(this.f56747a, this.f56748b);
        }
    }

    private static final h a(h hVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar, z zVar, int i4, p<v> pVar) {
        l iVar;
        c a4 = hVar.a();
        if (zVar == null) {
            iVar = hVar.f();
        } else {
            iVar = new i(hVar, kVar, zVar, i4);
        }
        return new h(a4, iVar, pVar);
    }

    @NotNull
    public static final h b(@NotNull h hVar, @NotNull l typeParameterResolver) {
        f0.p(hVar, "<this>");
        f0.p(typeParameterResolver, "typeParameterResolver");
        return new h(hVar.a(), typeParameterResolver, hVar.c());
    }

    @NotNull
    public static final h c(@NotNull h hVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.e containingDeclaration, @Nullable z zVar, int i4) {
        p c4;
        f0.p(hVar, "<this>");
        f0.p(containingDeclaration, "containingDeclaration");
        c4 = r.c(LazyThreadSafetyMode.NONE, new C1136a(hVar, containingDeclaration));
        return a(hVar, containingDeclaration, zVar, i4, c4);
    }

    public static /* synthetic */ h d(h hVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, z zVar, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            zVar = null;
        }
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return c(hVar, eVar, zVar, i4);
    }

    @NotNull
    public static final h e(@NotNull h hVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration, @NotNull z typeParameterOwner, int i4) {
        f0.p(hVar, "<this>");
        f0.p(containingDeclaration, "containingDeclaration");
        f0.p(typeParameterOwner, "typeParameterOwner");
        return a(hVar, containingDeclaration, typeParameterOwner, i4, hVar.c());
    }

    public static /* synthetic */ h f(h hVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar, z zVar, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return e(hVar, kVar, zVar, i4);
    }

    @Nullable
    public static final v g(@NotNull h hVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f additionalAnnotations) {
        EnumMap enumMap;
        f0.p(hVar, "<this>");
        f0.p(additionalAnnotations, "additionalAnnotations");
        if (hVar.a().i().b()) {
            return hVar.b();
        }
        ArrayList<kotlin.reflect.jvm.internal.impl.load.java.p> arrayList = new ArrayList();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it = additionalAnnotations.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.load.java.p i4 = i(hVar, it.next());
            if (i4 != null) {
                arrayList.add(i4);
            }
        }
        if (arrayList.isEmpty()) {
            return hVar.b();
        }
        v b4 = hVar.b();
        if (b4 == null) {
            enumMap = new EnumMap(AnnotationQualifierApplicabilityType.class);
        } else {
            enumMap = new EnumMap((EnumMap) b4.b());
        }
        boolean z3 = false;
        for (kotlin.reflect.jvm.internal.impl.load.java.p pVar : arrayList) {
            for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : pVar.e()) {
                enumMap.put((EnumMap) annotationQualifierApplicabilityType, (AnnotationQualifierApplicabilityType) pVar);
                z3 = true;
            }
        }
        return !z3 ? hVar.b() : new v(enumMap);
    }

    @NotNull
    public static final h h(@NotNull h hVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f additionalAnnotations) {
        p c4;
        f0.p(hVar, "<this>");
        f0.p(additionalAnnotations, "additionalAnnotations");
        if (additionalAnnotations.isEmpty()) {
            return hVar;
        }
        c a4 = hVar.a();
        l f4 = hVar.f();
        c4 = r.c(LazyThreadSafetyMode.NONE, new b(hVar, additionalAnnotations));
        return new h(a4, f4, c4);
    }

    private static final kotlin.reflect.jvm.internal.impl.load.java.p i(h hVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        kotlin.reflect.jvm.internal.impl.load.java.b a4 = hVar.a().a();
        kotlin.reflect.jvm.internal.impl.load.java.p l4 = a4.l(cVar);
        if (l4 == null) {
            b.a n4 = a4.n(cVar);
            if (n4 == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a5 = n4.a();
            List<AnnotationQualifierApplicabilityType> b4 = n4.b();
            ReportLevel k4 = a4.k(cVar);
            if (k4 == null) {
                k4 = a4.j(a5);
            }
            if (k4.isIgnore()) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f h4 = hVar.a().r().h(a5, hVar.a().q().c(), false);
            if (h4 == null) {
                return null;
            }
            return new kotlin.reflect.jvm.internal.impl.load.java.p(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f.b(h4, null, k4.isWarning(), 1, null), b4, false, 4, null);
        }
        return l4;
    }

    @NotNull
    public static final h j(@NotNull h hVar, @NotNull c components) {
        f0.p(hVar, "<this>");
        f0.p(components, "components");
        return new h(components, hVar.f(), hVar.c());
    }
}
