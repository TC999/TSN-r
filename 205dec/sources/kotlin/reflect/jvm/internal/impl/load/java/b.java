package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AnnotationTypeQualifierResolver.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final u f56666a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.h<kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f56667b;

    /* compiled from: AnnotationTypeQualifierResolver.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c f56668a;

        /* renamed from: b  reason: collision with root package name */
        private final int f56669b;

        public a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c typeQualifier, int i4) {
            f0.p(typeQualifier, "typeQualifier");
            this.f56668a = typeQualifier;
            this.f56669b = i4;
        }

        private final boolean c(AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
            return ((1 << annotationQualifierApplicabilityType.ordinal()) & this.f56669b) != 0;
        }

        private final boolean d(AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
            if (c(annotationQualifierApplicabilityType)) {
                return true;
            }
            return c(AnnotationQualifierApplicabilityType.TYPE_USE) && annotationQualifierApplicabilityType != AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a() {
            return this.f56668a;
        }

        @NotNull
        public final List<AnnotationQualifierApplicabilityType> b() {
            AnnotationQualifierApplicabilityType[] values = AnnotationQualifierApplicabilityType.values();
            ArrayList arrayList = new ArrayList();
            int length = values.length;
            int i4 = 0;
            while (i4 < length) {
                AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = values[i4];
                i4++;
                if (d(annotationQualifierApplicabilityType)) {
                    arrayList.add(annotationQualifierApplicabilityType);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnnotationTypeQualifierResolver.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1133b extends Lambda implements d2.p<kotlin.reflect.jvm.internal.impl.resolve.constants.j, AnnotationQualifierApplicabilityType, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final C1133b f56670a = new C1133b();

        C1133b() {
            super(2);
        }

        @Override // d2.p
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.j mapConstantToQualifierApplicabilityTypes, @NotNull AnnotationQualifierApplicabilityType it) {
            f0.p(mapConstantToQualifierApplicabilityTypes, "$this$mapConstantToQualifierApplicabilityTypes");
            f0.p(it, "it");
            return Boolean.valueOf(f0.g(mapConstantToQualifierApplicabilityTypes.b().getIdentifier(), it.getJavaTarget()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnnotationTypeQualifierResolver.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.p<kotlin.reflect.jvm.internal.impl.resolve.constants.j, AnnotationQualifierApplicabilityType, Boolean> {
        c() {
            super(2);
        }

        @Override // d2.p
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.j mapConstantToQualifierApplicabilityTypes, @NotNull AnnotationQualifierApplicabilityType it) {
            f0.p(mapConstantToQualifierApplicabilityTypes, "$this$mapConstantToQualifierApplicabilityTypes");
            f0.p(it, "it");
            return Boolean.valueOf(b.this.p(it.getJavaTarget()).contains(mapConstantToQualifierApplicabilityTypes.b().getIdentifier()));
        }
    }

    /* compiled from: AnnotationTypeQualifierResolver.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    /* synthetic */ class d extends FunctionReference implements d2.l<kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> {
        d(Object obj) {
            super(1, obj);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: d */
        public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c invoke(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d p02) {
            f0.p(p02, "p0");
            return ((b) this.receiver).c(p02);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "computeTypeQualifierNickname";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return n0.d(b.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
        }
    }

    public b(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull u javaTypeEnhancementState) {
        f0.p(storageManager, "storageManager");
        f0.p(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.f56666a = javaTypeEnhancementState;
        this.f56667b = storageManager.e(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c c(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar.getAnnotations().i(kotlin.reflect.jvm.internal.impl.load.java.a.g())) {
            for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar : dVar.getAnnotations()) {
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.c m4 = m(cVar);
                if (m4 != null) {
                    return m4;
                }
            }
            return null;
        }
        return null;
    }

    private final List<AnnotationQualifierApplicabilityType> d(kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar, d2.p<? super kotlin.reflect.jvm.internal.impl.resolve.constants.j, ? super AnnotationQualifierApplicabilityType, Boolean> pVar) {
        List<AnnotationQualifierApplicabilityType> F;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
        List<AnnotationQualifierApplicabilityType> N;
        if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.b) {
            ArrayList arrayList = new ArrayList();
            for (kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar2 : ((kotlin.reflect.jvm.internal.impl.resolve.constants.b) gVar).a()) {
                kotlin.collections.c0.o0(arrayList, d(gVar2, pVar));
            }
            return arrayList;
        } else if (!(gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.j)) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        } else {
            AnnotationQualifierApplicabilityType[] values = AnnotationQualifierApplicabilityType.values();
            int i4 = 0;
            int length = values.length;
            while (true) {
                if (i4 >= length) {
                    annotationQualifierApplicabilityType = null;
                    break;
                }
                annotationQualifierApplicabilityType = values[i4];
                i4++;
                if (pVar.invoke(gVar, annotationQualifierApplicabilityType).booleanValue()) {
                    break;
                }
            }
            N = CollectionsKt__CollectionsKt.N(annotationQualifierApplicabilityType);
            return N;
        }
    }

    private final List<AnnotationQualifierApplicabilityType> e(kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar) {
        return d(gVar, C1133b.f56670a);
    }

    private final List<AnnotationQualifierApplicabilityType> f(kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar) {
        return d(gVar, new c());
    }

    private final ReportLevel g(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c b4 = dVar.getAnnotations().b(kotlin.reflect.jvm.internal.impl.load.java.a.d());
        kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> b5 = b4 == null ? null : kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.b(b4);
        kotlin.reflect.jvm.internal.impl.resolve.constants.j jVar = b5 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.j ? (kotlin.reflect.jvm.internal.impl.resolve.constants.j) b5 : null;
        if (jVar == null) {
            return null;
        }
        ReportLevel b6 = this.f56666a.d().b();
        if (b6 == null) {
            String b7 = jVar.b().b();
            int hashCode = b7.hashCode();
            if (hashCode == -2137067054) {
                if (b7.equals("IGNORE")) {
                    return ReportLevel.IGNORE;
                }
                return null;
            } else if (hashCode == -1838656823) {
                if (b7.equals("STRICT")) {
                    return ReportLevel.STRICT;
                }
                return null;
            } else if (hashCode == 2656902 && b7.equals("WARN")) {
                return ReportLevel.WARN;
            } else {
                return null;
            }
        }
        return b6;
    }

    private final ReportLevel i(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        kotlin.reflect.jvm.internal.impl.name.c e4 = cVar.e();
        if (e4 != null && kotlin.reflect.jvm.internal.impl.load.java.a.c().containsKey(e4)) {
            return this.f56666a.c().invoke(e4);
        }
        return j(cVar);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c o(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar.i() != ClassKind.ANNOTATION_CLASS) {
            return null;
        }
        return this.f56667b.invoke(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> p(String str) {
        int Z;
        Set<KotlinTarget> b4 = kotlin.reflect.jvm.internal.impl.load.java.components.d.f56694a.b(str);
        Z = kotlin.collections.y.Z(b4, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (KotlinTarget kotlinTarget : b4) {
            arrayList.add(kotlinTarget.name());
        }
        return arrayList;
    }

    @Nullable
    public final a h(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c annotationDescriptor) {
        f0.p(annotationDescriptor, "annotationDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.d f4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f(annotationDescriptor);
        if (f4 == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations = f4.getAnnotations();
        kotlin.reflect.jvm.internal.impl.name.c TARGET_ANNOTATION = y.f57108d;
        f0.o(TARGET_ANNOTATION, "TARGET_ANNOTATION");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c b4 = annotations.b(TARGET_ANNOTATION);
        if (b4 == null) {
            return null;
        }
        Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a4 = b4.a();
        ArrayList<AnnotationQualifierApplicabilityType> arrayList = new ArrayList();
        for (Map.Entry<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> entry : a4.entrySet()) {
            kotlin.collections.c0.o0(arrayList, f(entry.getValue()));
        }
        int i4 = 0;
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : arrayList) {
            i4 |= 1 << annotationQualifierApplicabilityType.ordinal();
        }
        return new a(annotationDescriptor, i4);
    }

    @NotNull
    public final ReportLevel j(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c annotationDescriptor) {
        f0.p(annotationDescriptor, "annotationDescriptor");
        ReportLevel k4 = k(annotationDescriptor);
        return k4 == null ? this.f56666a.d().a() : k4;
    }

    @Nullable
    public final ReportLevel k(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c annotationDescriptor) {
        f0.p(annotationDescriptor, "annotationDescriptor");
        ReportLevel reportLevel = this.f56666a.d().c().get(annotationDescriptor.e());
        if (reportLevel == null) {
            kotlin.reflect.jvm.internal.impl.descriptors.d f4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f(annotationDescriptor);
            if (f4 == null) {
                return null;
            }
            return g(f4);
        }
        return reportLevel;
    }

    @Nullable
    public final p l(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c annotationDescriptor) {
        p pVar;
        f0.p(annotationDescriptor, "annotationDescriptor");
        if (this.f56666a.b() || (pVar = kotlin.reflect.jvm.internal.impl.load.java.a.a().get(annotationDescriptor.e())) == null) {
            return null;
        }
        ReportLevel i4 = i(annotationDescriptor);
        if (!(i4 != ReportLevel.IGNORE)) {
            i4 = null;
        }
        if (i4 == null) {
            return null;
        }
        return p.b(pVar, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f.b(pVar.d(), null, i4.isWarning(), 1, null), null, false, 6, null);
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c m(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c annotationDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.d f4;
        boolean b4;
        f0.p(annotationDescriptor, "annotationDescriptor");
        if (this.f56666a.d().d() || (f4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f(annotationDescriptor)) == null) {
            return null;
        }
        b4 = kotlin.reflect.jvm.internal.impl.load.java.c.b(f4);
        return b4 ? annotationDescriptor : o(f4);
    }

    @Nullable
    public final a n(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c annotationDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar;
        boolean z3;
        List<AnnotationQualifierApplicabilityType> F;
        f0.p(annotationDescriptor, "annotationDescriptor");
        if (this.f56666a.d().d()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d f4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f(annotationDescriptor);
        if (f4 == null || !f4.getAnnotations().i(kotlin.reflect.jvm.internal.impl.load.java.a.e())) {
            f4 = null;
        }
        if (f4 == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d f5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f(annotationDescriptor);
        f0.m(f5);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c b4 = f5.getAnnotations().b(kotlin.reflect.jvm.internal.impl.load.java.a.e());
        f0.m(b4);
        Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a4 = b4.a();
        ArrayList<AnnotationQualifierApplicabilityType> arrayList = new ArrayList();
        for (Map.Entry<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> entry : a4.entrySet()) {
            kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> value = entry.getValue();
            if (f0.g(entry.getKey(), y.f57107c)) {
                F = e(value);
            } else {
                F = CollectionsKt__CollectionsKt.F();
            }
            kotlin.collections.c0.o0(arrayList, F);
        }
        int i4 = 0;
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : arrayList) {
            i4 |= 1 << annotationQualifierApplicabilityType.ordinal();
        }
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it = f4.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                cVar = null;
                break;
            }
            cVar = it.next();
            if (m(cVar) != null) {
                z3 = true;
                continue;
            } else {
                z3 = false;
                continue;
            }
            if (z3) {
                break;
            }
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar2 = cVar;
        if (cVar2 == null) {
            return null;
        }
        return new a(cVar2, i4);
    }
}
