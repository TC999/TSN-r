package kotlin.reflect.jvm.internal.impl.load.java.components;

import d2.l;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.j1;
import kotlin.collections.y;
import kotlin.collections.z0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.l0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.w;
import m2.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final d f56694a = new d();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, EnumSet<KotlinTarget>> f56695b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, KotlinRetention> f56696c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JavaAnnotationMapper.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements l<d0, e0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56697a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final e0 invoke(@NotNull d0 module) {
            e0 type;
            String str;
            f0.p(module, "module");
            d1 b4 = kotlin.reflect.jvm.internal.impl.load.java.components.a.b(c.f56688a.d(), module.k().o(j.a.F));
            if (b4 == null) {
                type = w.j("Error: AnnotationTarget[]");
                str = "createErrorType(\"Error: AnnotationTarget[]\")";
            } else {
                type = b4.getType();
                str = "parameterDescriptor?.typ\u2026ror: AnnotationTarget[]\")";
            }
            f0.o(type, str);
            return type;
        }
    }

    static {
        Map<String, EnumSet<KotlinTarget>> W;
        Map<String, KotlinRetention> W2;
        W = z0.W(l0.a("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), l0.a("TYPE", EnumSet.of(KotlinTarget.CLASS, KotlinTarget.FILE)), l0.a("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.ANNOTATION_CLASS)), l0.a("TYPE_PARAMETER", EnumSet.of(KotlinTarget.TYPE_PARAMETER)), l0.a("FIELD", EnumSet.of(KotlinTarget.FIELD)), l0.a("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.LOCAL_VARIABLE)), l0.a("PARAMETER", EnumSet.of(KotlinTarget.VALUE_PARAMETER)), l0.a("CONSTRUCTOR", EnumSet.of(KotlinTarget.CONSTRUCTOR)), l0.a("METHOD", EnumSet.of(KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER)), l0.a("TYPE_USE", EnumSet.of(KotlinTarget.TYPE)));
        f56695b = W;
        W2 = z0.W(l0.a("RUNTIME", KotlinRetention.RUNTIME), l0.a("CLASS", KotlinRetention.BINARY), l0.a("SOURCE", KotlinRetention.SOURCE));
        f56696c = W2;
    }

    private d() {
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> a(@Nullable m2.b bVar) {
        m mVar = bVar instanceof m ? (m) bVar : null;
        if (mVar == null) {
            return null;
        }
        Map<String, KotlinRetention> map = f56696c;
        kotlin.reflect.jvm.internal.impl.name.f e4 = mVar.e();
        KotlinRetention kotlinRetention = map.get(e4 == null ? null : e4.b());
        if (kotlinRetention == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(j.a.H);
        f0.o(m4, "topLevel(StandardNames.F\u2026ames.annotationRetention)");
        kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(kotlinRetention.name());
        f0.o(f4, "identifier(retention.name)");
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.j(m4, f4);
    }

    @NotNull
    public final Set<KotlinTarget> b(@Nullable String str) {
        Set<KotlinTarget> k4;
        EnumSet<KotlinTarget> enumSet = f56695b.get(str);
        if (enumSet == null) {
            k4 = j1.k();
            return k4;
        }
        return enumSet;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> c(@NotNull List<? extends m2.b> arguments) {
        int Z;
        f0.p(arguments, "arguments");
        ArrayList<m> arrayList = new ArrayList();
        for (Object obj : arguments) {
            if (obj instanceof m) {
                arrayList.add(obj);
            }
        }
        ArrayList<KotlinTarget> arrayList2 = new ArrayList();
        for (m mVar : arrayList) {
            d dVar = f56694a;
            kotlin.reflect.jvm.internal.impl.name.f e4 = mVar.e();
            c0.o0(arrayList2, dVar.b(e4 == null ? null : e4.b()));
        }
        Z = y.Z(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(Z);
        for (KotlinTarget kotlinTarget : arrayList2) {
            kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(j.a.G);
            f0.o(m4, "topLevel(StandardNames.FqNames.annotationTarget)");
            kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(kotlinTarget.name());
            f0.o(f4, "identifier(kotlinTarget.name)");
            arrayList3.add(new kotlin.reflect.jvm.internal.impl.resolve.constants.j(m4, f4));
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.b(arrayList3, a.f56697a);
    }
}
