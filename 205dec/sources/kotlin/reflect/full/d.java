package kotlin.reflect.full;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import d2.l;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.x;
import kotlin.collections.y;
import kotlin.collections.z0;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.KParameter;
import kotlin.reflect.i;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.j;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.f1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.utils.b;
import kotlin.reflect.jvm.internal.u;
import kotlin.reflect.o;
import kotlin.reflect.p;
import kotlin.reflect.q;
import kotlin.reflect.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KClasses.kt */
@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000b\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u00002\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0007\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u00002\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0007\u001a-\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0005*\u00020\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0004\b\b\u0010\t\u001a/\u0010\n\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0005*\u00020\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0004\b\n\u0010\t\u001a#\u0010\u000b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0005*\u00020\u0006*\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0007\u00a2\u0006\u0004\b\u000b\u0010\f\"6\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r\"\b\b\u0000\u0010\u0005*\u00020\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\"(\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0013\u0010\u0014\"$\u0010\u0019\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0017\u0010\f\"\"\u0010\u001e\u001a\u00020\u001a*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001b\u0010\u001c\",\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u001f*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b#\u0010\u0011\u001a\u0004\b!\u0010\"\",\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001f*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b&\u0010\u0011\u001a\u0004\b%\u0010\"\",\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001f*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b)\u0010\u0011\u001a\u0004\b(\u0010\"\",\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001f*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b,\u0010\u0011\u001a\u0004\b+\u0010\"\",\u00100\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001f*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b/\u0010\u0011\u001a\u0004\b.\u0010\"\",\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001f*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b2\u0010\u0011\u001a\u0004\b1\u0010\"\",\u00106\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001f*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b5\u0010\u0011\u001a\u0004\b4\u0010\"\",\u00109\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001f*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b8\u0010\u0011\u001a\u0004\b7\u0010\"\",\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001f*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b<\u0010\u0011\u001a\u0004\b;\u0010\"\">\u0010A\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030>0\u001f\"\b\b\u0000\u0010\u0005*\u00020\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b@\u0010\u0011\u001a\u0004\b?\u0010\"\"B\u0010E\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0002\b\u00030B0\u001f\"\b\b\u0000\u0010\u0005*\u00020\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bD\u0010\u0011\u001a\u0004\bC\u0010\"\">\u0010H\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030>0\u001f\"\b\b\u0000\u0010\u0005*\u00020\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bG\u0010\u0011\u001a\u0004\bF\u0010\"\"B\u0010K\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0002\b\u00030B0\u001f\"\b\b\u0000\u0010\u0005*\u00020\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bJ\u0010\u0011\u001a\u0004\bI\u0010\"\"\u001c\u0010O\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030L8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bM\u0010N\"\u001c\u0010Q\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030L8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bP\u0010N\",\u0010V\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000R*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bU\u0010\u0011\u001a\u0004\bS\u0010T\"(\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001f*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bX\u0010\u0011\u001a\u0004\bW\u0010\"\",\u0010\\\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u001f*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b[\u0010\u0011\u001a\u0004\bZ\u0010\"\u00a8\u0006]"}, d2 = {"Lkotlin/reflect/d;", "base", "", "S", "derived", "T", "", "value", "a", "(Lkotlin/reflect/d;Ljava/lang/Object;)Ljava/lang/Object;", "U", "b", "(Lkotlin/reflect/d;)Ljava/lang/Object;", "Lkotlin/reflect/i;", "I", "(Lkotlin/reflect/d;)Lkotlin/reflect/i;", "getPrimaryConstructor$annotations", "(Lkotlin/reflect/d;)V", "primaryConstructor", "g", "(Lkotlin/reflect/d;)Lkotlin/reflect/d;", "getCompanionObject$annotations", "companionObject", "i", "getCompanionObjectInstance$annotations", "companionObjectInstance", "Lkotlin/reflect/r;", "w", "(Lkotlin/reflect/d;)Lkotlin/reflect/r;", "getDefaultType$annotations", "defaultType", "", "Lkotlin/reflect/c;", "u", "(Lkotlin/reflect/d;)Ljava/util/Collection;", "getDeclaredMembers$annotations", "declaredMembers", "y", "getFunctions$annotations", "functions", "K", "getStaticFunctions$annotations", "staticFunctions", "E", "getMemberFunctions$annotations", "memberFunctions", "A", "getMemberExtensionFunctions$annotations", "memberExtensionFunctions", "k", "getDeclaredFunctions$annotations", "declaredFunctions", CampaignEx.JSON_KEY_AD_Q, "getDeclaredMemberFunctions$annotations", "declaredMemberFunctions", "m", "getDeclaredMemberExtensionFunctions$annotations", "declaredMemberExtensionFunctions", "Lkotlin/reflect/o;", "M", "getStaticProperties$annotations", "staticProperties", "Lkotlin/reflect/p;", "G", "getMemberProperties$annotations", "memberProperties", "Lkotlin/reflect/q;", "C", "getMemberExtensionProperties$annotations", "memberExtensionProperties", "s", "getDeclaredMemberProperties$annotations", "declaredMemberProperties", "o", "getDeclaredMemberExtensionProperties$annotations", "declaredMemberExtensionProperties", "Lkotlin/reflect/jvm/internal/f;", "Q", "(Lkotlin/reflect/jvm/internal/f;)Z", "isExtension", "R", "isNotExtension", "", "O", "(Lkotlin/reflect/d;)Ljava/util/List;", "getSuperclasses$annotations", "superclasses", "e", "getAllSupertypes$annotations", "allSupertypes", "c", "getAllSuperclasses$annotations", "allSuperclasses", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "KClasses")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KClasses.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001d\n\u0002\u0010\u001c\n\u0002\b\u0002\u0010\u0005\u001a$\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000 \u0001*\u0010\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u00000\u00040\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/reflect/r;", "kotlin.jvm.PlatformType", "current", "", "", "b", "(Lkotlin/reflect/r;)Ljava/lang/Iterable;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<N> implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public static final a<N> f55851a = new a<>();

        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        @NotNull
        /* renamed from: b */
        public final Iterable<r> a(r rVar) {
            int Z;
            kotlin.reflect.g a4 = rVar.a();
            kotlin.reflect.d dVar = a4 instanceof kotlin.reflect.d ? (kotlin.reflect.d) a4 : null;
            if (dVar != null) {
                List<r> j4 = dVar.j();
                if (rVar.getArguments().isEmpty()) {
                    return j4;
                }
                f1 f4 = f1.f(((u) rVar).getType());
                Z = y.Z(j4, 10);
                ArrayList arrayList = new ArrayList(Z);
                for (r rVar2 : j4) {
                    e0 p3 = f4.p(((u) rVar2).getType(), Variance.INVARIANT);
                    if (p3 != null) {
                        arrayList.add(new u(p3, null, 2, null));
                    } else {
                        throw new KotlinReflectionInternalError("Type substitution failed: " + rVar2 + " (" + rVar + ')');
                    }
                }
                return arrayList;
            }
            throw new KotlinReflectionInternalError(f0.C("Supertype not a class: ", rVar));
        }
    }

    /* compiled from: KClasses.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"kotlin/reflect/full/d$b", "Lkotlin/reflect/jvm/internal/impl/utils/b$f;", "Lkotlin/reflect/r;", "current", "", "f", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends b.f<r, r> {
        b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.AbstractC1189b, kotlin.reflect.jvm.internal.impl.utils.b.e
        /* renamed from: f */
        public boolean c(@NotNull r current) {
            f0.p(current, "current");
            ((LinkedList) this.f58534a).add(current);
            return true;
        }
    }

    /* compiled from: KClasses.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/reflect/Type;", "a", "()Ljava/lang/reflect/Type;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<Type> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.d<?> f55852a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlin.reflect.d<?> dVar) {
            super(0);
            this.f55852a = dVar;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Type invoke() {
            return ((h) this.f55852a).d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KClasses.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/reflect/d;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lkotlin/reflect/d;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e extends Lambda implements l<kotlin.reflect.d<?>, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.d<?> f55854a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(kotlin.reflect.d<?> dVar) {
            super(1);
            this.f55854a = dVar;
        }

        @Override // d2.l
        /* renamed from: a */
        public final Boolean invoke(kotlin.reflect.d<?> dVar) {
            return Boolean.valueOf(f0.g(dVar, this.f55854a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KClasses.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class f implements b.d {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ l f55855a;

        f(l lVar) {
            this.f55855a = lVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        public final /* synthetic */ Iterable a(Object obj) {
            return (Iterable) this.f55855a.invoke(obj);
        }
    }

    @NotNull
    public static final Collection<i<?>> A(@NotNull kotlin.reflect.d<?> dVar) {
        f0.p(dVar, "<this>");
        Collection<kotlin.reflect.jvm.internal.f<?>> h4 = ((h.a) ((h) dVar).X().invoke()).h();
        ArrayList arrayList = new ArrayList();
        for (Object obj : h4) {
            kotlin.reflect.jvm.internal.f fVar = (kotlin.reflect.jvm.internal.f) obj;
            if (Q(fVar) && (fVar instanceof i)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void B(kotlin.reflect.d dVar) {
    }

    @NotNull
    public static final <T> Collection<q<T, ?, ?>> C(@NotNull kotlin.reflect.d<T> dVar) {
        f0.p(dVar, "<this>");
        Collection<kotlin.reflect.jvm.internal.f<?>> h4 = ((h) dVar).X().invoke().h();
        ArrayList arrayList = new ArrayList();
        for (T t3 : h4) {
            kotlin.reflect.jvm.internal.f fVar = (kotlin.reflect.jvm.internal.f) t3;
            if (Q(fVar) && (fVar instanceof q)) {
                arrayList.add(t3);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void D(kotlin.reflect.d dVar) {
    }

    @NotNull
    public static final Collection<i<?>> E(@NotNull kotlin.reflect.d<?> dVar) {
        f0.p(dVar, "<this>");
        Collection<kotlin.reflect.jvm.internal.f<?>> h4 = ((h.a) ((h) dVar).X().invoke()).h();
        ArrayList arrayList = new ArrayList();
        for (Object obj : h4) {
            kotlin.reflect.jvm.internal.f fVar = (kotlin.reflect.jvm.internal.f) obj;
            if (R(fVar) && (fVar instanceof i)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void F(kotlin.reflect.d dVar) {
    }

    @NotNull
    public static final <T> Collection<p<T, ?>> G(@NotNull kotlin.reflect.d<T> dVar) {
        f0.p(dVar, "<this>");
        Collection<kotlin.reflect.jvm.internal.f<?>> h4 = ((h) dVar).X().invoke().h();
        ArrayList arrayList = new ArrayList();
        for (T t3 : h4) {
            kotlin.reflect.jvm.internal.f fVar = (kotlin.reflect.jvm.internal.f) t3;
            if (R(fVar) && (fVar instanceof p)) {
                arrayList.add(t3);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void H(kotlin.reflect.d dVar) {
    }

    @Nullable
    public static final <T> i<T> I(@NotNull kotlin.reflect.d<T> dVar) {
        T t3;
        f0.p(dVar, "<this>");
        Iterator<T> it = ((h) dVar).g().iterator();
        while (true) {
            if (!it.hasNext()) {
                t3 = null;
                break;
            }
            t3 = it.next();
            if (((j) ((kotlin.reflect.jvm.internal.j) ((i) t3)).I()).b0()) {
                break;
            }
        }
        return (i) t3;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void J(kotlin.reflect.d dVar) {
    }

    @NotNull
    public static final Collection<i<?>> K(@NotNull kotlin.reflect.d<?> dVar) {
        f0.p(dVar, "<this>");
        Collection<kotlin.reflect.jvm.internal.f<?>> i4 = ((h.a) ((h) dVar).X().invoke()).i();
        ArrayList arrayList = new ArrayList();
        for (Object obj : i4) {
            if (obj instanceof i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void L(kotlin.reflect.d dVar) {
    }

    @NotNull
    public static final Collection<o<?>> M(@NotNull kotlin.reflect.d<?> dVar) {
        f0.p(dVar, "<this>");
        Collection<kotlin.reflect.jvm.internal.f<?>> i4 = ((h.a) ((h) dVar).X().invoke()).i();
        ArrayList arrayList = new ArrayList();
        for (Object obj : i4) {
            kotlin.reflect.jvm.internal.f fVar = (kotlin.reflect.jvm.internal.f) obj;
            if (R(fVar) && (fVar instanceof o)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void N(kotlin.reflect.d dVar) {
    }

    @NotNull
    public static final List<kotlin.reflect.d<?>> O(@NotNull kotlin.reflect.d<?> dVar) {
        f0.p(dVar, "<this>");
        List<r> j4 = dVar.j();
        ArrayList arrayList = new ArrayList();
        for (r rVar : j4) {
            kotlin.reflect.g a4 = rVar.a();
            kotlin.reflect.d dVar2 = a4 instanceof kotlin.reflect.d ? (kotlin.reflect.d) a4 : null;
            if (dVar2 != null) {
                arrayList.add(dVar2);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void P(kotlin.reflect.d dVar) {
    }

    private static final boolean Q(kotlin.reflect.jvm.internal.f<?> fVar) {
        return fVar.I().Q() != null;
    }

    private static final boolean R(kotlin.reflect.jvm.internal.f<?> fVar) {
        return !Q(fVar);
    }

    @SinceKotlin(version = "1.1")
    public static final boolean S(@NotNull kotlin.reflect.d<?> dVar, @NotNull kotlin.reflect.d<?> base) {
        List l4;
        f0.p(dVar, "<this>");
        f0.p(base, "base");
        if (!f0.g(dVar, base)) {
            l4 = x.l(dVar);
            Boolean e4 = kotlin.reflect.jvm.internal.impl.utils.b.e(l4, new f(new PropertyReference1() { // from class: kotlin.reflect.full.d.d
                @Override // kotlin.reflect.p
                @Nullable
                public Object get(@Nullable Object obj) {
                    return d.O((kotlin.reflect.d) obj);
                }

                @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
                @NotNull
                public String getName() {
                    return "superclasses";
                }

                @Override // kotlin.jvm.internal.CallableReference
                @NotNull
                public kotlin.reflect.h getOwner() {
                    return n0.h(d.class, "kotlin-reflection");
                }

                @Override // kotlin.jvm.internal.CallableReference
                @NotNull
                public String getSignature() {
                    return "getSuperclasses(Lkotlin/reflect/KClass;)Ljava/util/List;";
                }
            }), new e(base));
            f0.o(e4, "base: KClass<*>): Boolea\u2026erclasses) { it == base }");
            if (!e4.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static final boolean T(@NotNull kotlin.reflect.d<?> dVar, @NotNull kotlin.reflect.d<?> derived) {
        f0.p(dVar, "<this>");
        f0.p(derived, "derived");
        return S(derived, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final <T> T U(@NotNull kotlin.reflect.d<T> dVar, @Nullable Object obj) {
        f0.p(dVar, "<this>");
        if (dVar.C(obj)) {
            if (obj != 0) {
                return obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.safeCast");
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T> T a(@NotNull kotlin.reflect.d<T> dVar, @Nullable Object obj) {
        f0.p(dVar, "<this>");
        if (dVar.C(obj)) {
            if (obj != 0) {
                return obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.cast");
        }
        throw new TypeCastException(f0.C("Value cannot be cast to ", dVar.D()));
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T> T b(@NotNull kotlin.reflect.d<T> dVar) {
        Map<KParameter, ? extends Object> z3;
        boolean z4;
        f0.p(dVar, "<this>");
        Iterator<T> it = dVar.g().iterator();
        i iVar = null;
        i iVar2 = null;
        boolean z5 = false;
        while (true) {
            if (it.hasNext()) {
                T next = it.next();
                List<KParameter> parameters = ((i) next).getParameters();
                if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                    for (KParameter kParameter : parameters) {
                        if (!kParameter.w()) {
                            z4 = false;
                            break;
                        }
                    }
                }
                z4 = true;
                if (z4) {
                    if (z5) {
                        break;
                    }
                    iVar2 = next;
                    z5 = true;
                }
            } else if (z5) {
                iVar = iVar2;
            }
        }
        i iVar3 = iVar;
        if (iVar3 != null) {
            z3 = z0.z();
            return (T) iVar3.callBy(z3);
        }
        throw new IllegalArgumentException(f0.C("Class should have a single no-arg constructor: ", dVar));
    }

    @NotNull
    public static final Collection<kotlin.reflect.d<?>> c(@NotNull kotlin.reflect.d<?> dVar) {
        int Z;
        f0.p(dVar, "<this>");
        Collection<r> e4 = e(dVar);
        Z = y.Z(e4, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (r rVar : e4) {
            kotlin.reflect.g a4 = rVar.a();
            kotlin.reflect.d dVar2 = a4 instanceof kotlin.reflect.d ? (kotlin.reflect.d) a4 : null;
            if (dVar2 == null) {
                throw new KotlinReflectionInternalError(f0.C("Supertype not a class: ", rVar));
            }
            arrayList.add(dVar2);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void d(kotlin.reflect.d dVar) {
    }

    @NotNull
    public static final Collection<r> e(@NotNull kotlin.reflect.d<?> dVar) {
        f0.p(dVar, "<this>");
        Object c4 = kotlin.reflect.jvm.internal.impl.utils.b.c(dVar.j(), a.f55851a, new b.h(), new b());
        f0.o(c4, "dfs(\n        supertypes,\u2026        }\n        }\n    )");
        return (Collection) c4;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void f(kotlin.reflect.d dVar) {
    }

    @Nullable
    public static final kotlin.reflect.d<?> g(@NotNull kotlin.reflect.d<?> dVar) {
        Object obj;
        f0.p(dVar, "<this>");
        Iterator<T> it = dVar.z().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((h) ((kotlin.reflect.d) obj)).e().a0()) {
                break;
            }
        }
        return (kotlin.reflect.d) obj;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void h(kotlin.reflect.d dVar) {
    }

    @Nullable
    public static final Object i(@NotNull kotlin.reflect.d<?> dVar) {
        f0.p(dVar, "<this>");
        kotlin.reflect.d<?> g4 = g(dVar);
        if (g4 == null) {
            return null;
        }
        return g4.A();
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void j(kotlin.reflect.d dVar) {
    }

    @NotNull
    public static final Collection<i<?>> k(@NotNull kotlin.reflect.d<?> dVar) {
        f0.p(dVar, "<this>");
        Collection<kotlin.reflect.jvm.internal.f<?>> l4 = ((h.a) ((h) dVar).X().invoke()).l();
        ArrayList arrayList = new ArrayList();
        for (Object obj : l4) {
            if (obj instanceof i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void l(kotlin.reflect.d dVar) {
    }

    @NotNull
    public static final Collection<i<?>> m(@NotNull kotlin.reflect.d<?> dVar) {
        f0.p(dVar, "<this>");
        Collection<kotlin.reflect.jvm.internal.f<?>> m4 = ((h.a) ((h) dVar).X().invoke()).m();
        ArrayList arrayList = new ArrayList();
        for (Object obj : m4) {
            kotlin.reflect.jvm.internal.f fVar = (kotlin.reflect.jvm.internal.f) obj;
            if (Q(fVar) && (fVar instanceof i)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void n(kotlin.reflect.d dVar) {
    }

    @NotNull
    public static final <T> Collection<q<T, ?, ?>> o(@NotNull kotlin.reflect.d<T> dVar) {
        f0.p(dVar, "<this>");
        Collection<kotlin.reflect.jvm.internal.f<?>> m4 = ((h) dVar).X().invoke().m();
        ArrayList arrayList = new ArrayList();
        for (T t3 : m4) {
            kotlin.reflect.jvm.internal.f fVar = (kotlin.reflect.jvm.internal.f) t3;
            if (Q(fVar) && (fVar instanceof q)) {
                arrayList.add(t3);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void p(kotlin.reflect.d dVar) {
    }

    @NotNull
    public static final Collection<i<?>> q(@NotNull kotlin.reflect.d<?> dVar) {
        f0.p(dVar, "<this>");
        Collection<kotlin.reflect.jvm.internal.f<?>> m4 = ((h.a) ((h) dVar).X().invoke()).m();
        ArrayList arrayList = new ArrayList();
        for (Object obj : m4) {
            kotlin.reflect.jvm.internal.f fVar = (kotlin.reflect.jvm.internal.f) obj;
            if (R(fVar) && (fVar instanceof i)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void r(kotlin.reflect.d dVar) {
    }

    @NotNull
    public static final <T> Collection<p<T, ?>> s(@NotNull kotlin.reflect.d<T> dVar) {
        f0.p(dVar, "<this>");
        Collection<kotlin.reflect.jvm.internal.f<?>> m4 = ((h) dVar).X().invoke().m();
        ArrayList arrayList = new ArrayList();
        for (T t3 : m4) {
            kotlin.reflect.jvm.internal.f fVar = (kotlin.reflect.jvm.internal.f) t3;
            if (R(fVar) && (fVar instanceof p)) {
                arrayList.add(t3);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void t(kotlin.reflect.d dVar) {
    }

    @NotNull
    public static final Collection<kotlin.reflect.c<?>> u(@NotNull kotlin.reflect.d<?> dVar) {
        f0.p(dVar, "<this>");
        return ((h.a) ((h) dVar).X().invoke()).l();
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void v(kotlin.reflect.d dVar) {
    }

    @NotNull
    public static final r w(@NotNull kotlin.reflect.d<?> dVar) {
        f0.p(dVar, "<this>");
        m0 q3 = ((h) dVar).e().q();
        f0.o(q3, "this as KClassImpl<*>).descriptor.defaultType");
        return new u(q3, new c(dVar));
    }

    @Deprecated(message = "This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void x(kotlin.reflect.d dVar) {
    }

    @NotNull
    public static final Collection<i<?>> y(@NotNull kotlin.reflect.d<?> dVar) {
        f0.p(dVar, "<this>");
        Collection<kotlin.reflect.c<?>> q3 = dVar.q();
        ArrayList arrayList = new ArrayList();
        for (Object obj : q3) {
            if (obj instanceof i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void z(kotlin.reflect.d dVar) {
    }
}
