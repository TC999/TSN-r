package kotlin.jvm.internal;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.daimajia.numberprogressbar.BuildConfig;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C14372l0;
import kotlin.ExceptionsH;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Tuples;
import kotlin.collections.C14236x;
import kotlin.collections.C14239y0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsJVM;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.C14579x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p612k1.JvmClassMapping;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15270b;
import p617l1.InterfaceC15271c;
import p617l1.InterfaceC15272d;
import p617l1.InterfaceC15273e;
import p617l1.InterfaceC15274f;
import p617l1.InterfaceC15275g;
import p617l1.InterfaceC15276h;
import p617l1.InterfaceC15277i;
import p617l1.InterfaceC15278j;
import p617l1.InterfaceC15279k;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15281m;
import p617l1.InterfaceC15282n;
import p617l1.InterfaceC15283o;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;
import p617l1.InterfaceC15286r;
import p617l1.InterfaceC15287s;
import p617l1.InterfaceC15288t;
import p617l1.InterfaceC15289u;
import p617l1.InterfaceC15290v;
import p617l1.InterfaceC15291w;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0010B\u0013\u0012\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u000f¢\u0006\u0004\bU\u0010VJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0017J\u0013\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001e\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u001e\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u001cR \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001e0\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR\u001e\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001cR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010*\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R \u0010/\u001a\b\u0012\u0004\u0012\u00020+0#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b-\u0010.\u001a\u0004\b,\u0010&R \u00103\u001a\b\u0012\u0004\u0012\u0002000#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b2\u0010.\u001a\u0004\b1\u0010&R(\u00106\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b5\u0010.\u001a\u0004\b4\u0010&R\u001c\u0010;\u001a\u0004\u0018\u0001078VX\u0097\u0004¢\u0006\f\u0012\u0004\b:\u0010.\u001a\u0004\b8\u00109R\u001a\u0010<\u001a\u00020\u00078VX\u0097\u0004¢\u0006\f\u0012\u0004\b>\u0010.\u001a\u0004\b<\u0010=R\u001a\u0010?\u001a\u00020\u00078VX\u0097\u0004¢\u0006\f\u0012\u0004\b@\u0010.\u001a\u0004\b?\u0010=R\u001a\u0010A\u001a\u00020\u00078VX\u0097\u0004¢\u0006\f\u0012\u0004\bB\u0010.\u001a\u0004\bA\u0010=R\u001a\u0010E\u001a\u00020\u00078VX\u0097\u0004¢\u0006\f\u0012\u0004\bD\u0010.\u001a\u0004\bC\u0010=R\u001a\u0010H\u001a\u00020\u00078VX\u0097\u0004¢\u0006\f\u0012\u0004\bG\u0010.\u001a\u0004\bF\u0010=R\u001a\u0010K\u001a\u00020\u00078VX\u0097\u0004¢\u0006\f\u0012\u0004\bJ\u0010.\u001a\u0004\bI\u0010=R\u001a\u0010N\u001a\u00020\u00078VX\u0097\u0004¢\u0006\f\u0012\u0004\bM\u0010.\u001a\u0004\bL\u0010=R\u001a\u0010Q\u001a\u00020\u00078VX\u0097\u0004¢\u0006\f\u0012\u0004\bP\u0010.\u001a\u0004\bO\u0010=R\u001a\u0010T\u001a\u00020\u00078VX\u0097\u0004¢\u0006\f\u0012\u0004\bS\u0010.\u001a\u0004\bR\u0010=¨\u0006W"}, m12616d2 = {"Lkotlin/jvm/internal/s;", "Lkotlin/reflect/d;", "", "Lkotlin/jvm/internal/r;", "", "C", DomainCampaignEx.LOOPBACK_VALUE, "", "p", AdnName.OTHER, "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", CampaignEx.JSON_KEY_AD_Q, "()Ljava/lang/Class;", "jClass", "u", "()Ljava/lang/String;", "simpleName", "r", "qualifiedName", "", "Lkotlin/reflect/c;", "()Ljava/util/Collection;", "members", "Lkotlin/reflect/i;", "d", "constructors", "c", "nestedClasses", "", "", "getAnnotations", "()Ljava/util/List;", "annotations", "j", "()Ljava/lang/Object;", "objectInstance", "Lkotlin/reflect/s;", "getTypeParameters", "getTypeParameters$annotations", "()V", "typeParameters", "Lkotlin/reflect/r;", "v", "getSupertypes$annotations", "supertypes", "g", "getSealedSubclasses$annotations", "sealedSubclasses", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "visibility", "isFinal", "()Z", "isFinal$annotations", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "m", "isSealed$annotations", "isSealed", "y", "isData$annotations", "isData", "h", "isInner$annotations", "isInner", C7304t.f25048d, "isCompanion$annotations", "isCompanion", "s", "isFun$annotations", "isFun", UMCommonContent.f37782aL, "isValue$annotations", "isValue", "<init>", "(Ljava/lang/Class;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.s */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {

    /* renamed from: b */
    private static final Map<Class<? extends Function<?>>, Integer> f41183b;

    /* renamed from: c */
    private static final HashMap<String, String> f41184c;

    /* renamed from: d */
    private static final HashMap<String, String> f41185d;

    /* renamed from: e */
    private static final HashMap<String, String> f41186e;

    /* renamed from: f */
    private static final Map<String, String> f41187f;
    @NotNull

    /* renamed from: g */
    public static final C14360a f41188g = new C14360a(null);
    @NotNull

    /* renamed from: a */
    private final Class<?> f41189a;

    /* compiled from: ClassReference.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002R,\u0010\r\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0002\u0012\u0004\u0012\u00020\f0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR0\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R0\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R0\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000e¨\u0006\u0018"}, m12616d2 = {"Lkotlin/jvm/internal/s$a;", "", "Ljava/lang/Class;", "jClass", "", "b", "a", DomainCampaignEx.LOOPBACK_VALUE, "", "c", "", "Lkotlin/j;", "", "FUNCTION_CLASSES", "Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "classFqNames", "Ljava/util/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.jvm.internal.s$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14360a {
        private C14360a() {
        }

        @Nullable
        /* renamed from: a */
        public final String m8046a(@NotNull Class<?> jClass) {
            String str;
            C14342f0.m8184p(jClass, "jClass");
            String str2 = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (jClass.isArray()) {
                Class<?> componentType = jClass.getComponentType();
                C14342f0.m8185o(componentType, "componentType");
                if (componentType.isPrimitive() && (str = (String) ClassReference.f41186e.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                return str2 != null ? str2 : "kotlin.Array";
            }
            String str3 = (String) ClassReference.f41186e.get(jClass.getName());
            return str3 != null ? str3 : jClass.getCanonicalName();
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
            if (r1 != null) goto L12;
         */
        @org.jetbrains.annotations.Nullable
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String m8045b(@org.jetbrains.annotations.NotNull java.lang.Class<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "jClass"
                kotlin.jvm.internal.C14342f0.m8184p(r8, r0)
                boolean r0 = r8.isAnonymousClass()
                java.lang.String r1 = "Array"
                r2 = 0
                if (r0 == 0) goto L11
            Le:
                r1 = r2
                goto Lc1
            L11:
                boolean r0 = r8.isLocalClass()
                if (r0 == 0) goto L73
                java.lang.String r0 = r8.getSimpleName()
                java.lang.reflect.Method r1 = r8.getEnclosingMethod()
                java.lang.String r3 = "$"
                r4 = 2
                java.lang.String r5 = "name"
                if (r1 == 0) goto L43
                kotlin.jvm.internal.C14342f0.m8185o(r0, r5)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r1 = r1.getName()
                r6.append(r1)
                r6.append(r3)
                java.lang.String r1 = r6.toString()
                java.lang.String r1 = kotlin.text.C14573n.m6749p5(r0, r1, r2, r4, r2)
                if (r1 == 0) goto L43
                goto L66
            L43:
                java.lang.reflect.Constructor r8 = r8.getEnclosingConstructor()
                if (r8 == 0) goto L65
                kotlin.jvm.internal.C14342f0.m8185o(r0, r5)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r8 = r8.getName()
                r1.append(r8)
                r1.append(r3)
                java.lang.String r8 = r1.toString()
                java.lang.String r8 = kotlin.text.C14573n.m6749p5(r0, r8, r2, r4, r2)
                r1 = r8
                goto L66
            L65:
                r1 = r2
            L66:
                if (r1 == 0) goto L69
                goto Lc1
            L69:
                kotlin.jvm.internal.C14342f0.m8185o(r0, r5)
                r8 = 36
                java.lang.String r1 = kotlin.text.C14573n.m6751o5(r0, r8, r2, r4, r2)
                goto Lc1
            L73:
                boolean r0 = r8.isArray()
                if (r0 == 0) goto Lab
                java.lang.Class r8 = r8.getComponentType()
                java.lang.String r0 = "componentType"
                kotlin.jvm.internal.C14342f0.m8185o(r8, r0)
                boolean r0 = r8.isPrimitive()
                if (r0 == 0) goto La7
                java.util.Map r0 = kotlin.jvm.internal.ClassReference.m8063B()
                java.lang.String r8 = r8.getName()
                java.lang.Object r8 = r0.get(r8)
                java.lang.String r8 = (java.lang.String) r8
                if (r8 == 0) goto La7
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r8)
                r0.append(r1)
                java.lang.String r2 = r0.toString()
            La7:
                if (r2 == 0) goto Lc1
                goto Le
            Lab:
                java.util.Map r0 = kotlin.jvm.internal.ClassReference.m8063B()
                java.lang.String r1 = r8.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto Lbd
                goto Lc1
            Lbd:
                java.lang.String r1 = r8.getSimpleName()
            Lc1:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.ClassReference.C14360a.m8045b(java.lang.Class):java.lang.String");
        }

        /* renamed from: c */
        public final boolean m8044c(@Nullable Object obj, @NotNull Class<?> jClass) {
            C14342f0.m8184p(jClass, "jClass");
            Map map = ClassReference.f41183b;
            if (map != null) {
                Integer num = (Integer) map.get(jClass);
                if (num != null) {
                    return TypeIntrinsics.m8039B(obj, num.intValue());
                }
                if (jClass.isPrimitive()) {
                    jClass = JvmClassMapping.m12624e(JvmClassMapping.m12622g(jClass));
                }
                return jClass.isInstance(obj);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        }

        public /* synthetic */ C14360a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List m12471L;
        int m8957Y;
        Map<Class<? extends Function<?>>, Integer> m8931B0;
        int m8944j;
        String m6393s5;
        String m6393s52;
        int i = 0;
        m12471L = CollectionsKt__CollectionsKt.m12471L(InterfaceC15269a.class, InterfaceC15280l.class, InterfaceC15284p.class, InterfaceC15285q.class, InterfaceC15286r.class, InterfaceC15287s.class, InterfaceC15288t.class, InterfaceC15289u.class, InterfaceC15290v.class, InterfaceC15291w.class, InterfaceC15270b.class, InterfaceC15271c.class, InterfaceC15272d.class, InterfaceC15273e.class, InterfaceC15274f.class, InterfaceC15275g.class, InterfaceC15276h.class, InterfaceC15277i.class, InterfaceC15278j.class, InterfaceC15279k.class, InterfaceC15281m.class, InterfaceC15282n.class, InterfaceC15283o.class);
        m8957Y = C14236x.m8957Y(m12471L, 10);
        ArrayList arrayList = new ArrayList(m8957Y);
        for (Object obj : m12471L) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.m12460W();
            }
            arrayList.add(C14372l0.m7952a((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        m8931B0 = C14239y0.m8931B0(arrayList);
        f41183b = m8931B0;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f41184c = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f41185d = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        C14342f0.m8185o(values, "primitiveFqNames.values");
        for (String kotlinName : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            C14342f0.m8185o(kotlinName, "kotlinName");
            m6393s52 = C14579x.m6393s5(kotlinName, '.', null, 2, null);
            sb.append(m6393s52);
            sb.append("CompanionObject");
            Tuples m7952a = C14372l0.m7952a(sb.toString(), kotlinName + ".Companion");
            hashMap3.put(m7952a.getFirst(), m7952a.getSecond());
        }
        for (Map.Entry<Class<? extends Function<?>>, Integer> entry : f41183b.entrySet()) {
            int intValue = entry.getValue().intValue();
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + intValue);
        }
        f41186e = hashMap3;
        m8944j = MapsJVM.m8944j(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(m8944j);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            m6393s5 = C14579x.m6393s5((String) entry2.getValue(), '.', null, 2, null);
            linkedHashMap.put(key, m6393s5);
        }
        f41187f = linkedHashMap;
    }

    public ClassReference(@NotNull Class<?> jClass) {
        C14342f0.m8184p(jClass, "jClass");
        this.f41189a = jClass;
    }

    /* renamed from: C */
    private final Void m8062C() {
        throw new KotlinReflectionNotSupportedError();
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: D */
    public static /* synthetic */ void m8061D() {
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: E */
    public static /* synthetic */ void m8060E() {
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: F */
    public static /* synthetic */ void m8059F() {
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: G */
    public static /* synthetic */ void m8058G() {
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: H */
    public static /* synthetic */ void m8057H() {
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: I */
    public static /* synthetic */ void m8056I() {
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: J */
    public static /* synthetic */ void m8055J() {
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: K */
    public static /* synthetic */ void m8054K() {
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: L */
    public static /* synthetic */ void m8053L() {
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: M */
    public static /* synthetic */ void m8052M() {
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: N */
    public static /* synthetic */ void m8051N() {
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: O */
    public static /* synthetic */ void m8050O() {
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: P */
    public static /* synthetic */ void m8049P() {
    }

    @Override // kotlin.reflect.KClass, kotlin.reflect.KDeclarationContainer
    @NotNull
    /* renamed from: a */
    public Collection<KCallable<?>> mo7329a() {
        m8062C();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    /* renamed from: c */
    public Collection<KClass<?>> mo7359c() {
        m8062C();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    /* renamed from: d */
    public Collection<KFunction<Object>> mo7358d() {
        m8062C();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ClassReference) && C14342f0.m8193g(JvmClassMapping.m12624e(this), JvmClassMapping.m12624e((KClass) obj));
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    /* renamed from: g */
    public List<KClass<? extends Object>> mo7357g() {
        m8062C();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        m8062C();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        m8062C();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public KVisibility getVisibility() {
        m8062C();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KClass
    /* renamed from: h */
    public boolean mo7356h() {
        m8062C();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMapping.m12624e(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        m8062C();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        m8062C();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        m8062C();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    /* renamed from: j */
    public Object mo7355j() {
        m8062C();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KClass
    /* renamed from: l */
    public boolean mo7354l() {
        m8062C();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KClass
    /* renamed from: m */
    public boolean mo7353m() {
        m8062C();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KClass
    @SinceKotlin(version = "1.1")
    /* renamed from: p */
    public boolean mo7352p(@Nullable Object obj) {
        return f41188g.m8044c(obj, mo8048q());
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    @NotNull
    /* renamed from: q */
    public Class<?> mo8048q() {
        return this.f41189a;
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    /* renamed from: r */
    public String mo7351r() {
        return f41188g.m8046a(mo8048q());
    }

    @Override // kotlin.reflect.KClass
    /* renamed from: s */
    public boolean mo7350s() {
        m8062C();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KClass
    /* renamed from: t */
    public boolean mo7349t() {
        m8062C();
        throw new ExceptionsH();
    }

    @NotNull
    public String toString() {
        return mo8048q().toString() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    /* renamed from: u */
    public String mo7348u() {
        return f41188g.m8045b(mo8048q());
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    /* renamed from: v */
    public List<KType> mo7347v() {
        m8062C();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KClass
    /* renamed from: y */
    public boolean mo7346y() {
        m8062C();
        throw new ExceptionsH();
    }
}
