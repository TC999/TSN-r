package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.f0;
import kotlin.collections.p;
import kotlin.collections.x;
import kotlin.collections.z0;
import kotlin.jvm.internal.u;
import kotlin.l0;
import org.jetbrains.annotations.NotNull;

/* compiled from: KotlinTarget.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public enum KotlinTarget {
    CLASS("class", false, 2, null),
    ANNOTATION_CLASS("annotation class", false, 2, null),
    TYPE_PARAMETER("type parameter", false),
    PROPERTY("property", false, 2, null),
    FIELD("field", false, 2, null),
    LOCAL_VARIABLE("local variable", false, 2, null),
    VALUE_PARAMETER("value parameter", false, 2, null),
    CONSTRUCTOR("constructor", false, 2, null),
    FUNCTION("function", false, 2, null),
    PROPERTY_GETTER("getter", false, 2, null),
    PROPERTY_SETTER("setter", false, 2, null),
    TYPE("type usage", false),
    EXPRESSION("expression", false),
    FILE("file", false),
    TYPEALIAS("typealias", false),
    TYPE_PROJECTION("type projection", false),
    STAR_PROJECTION("star projection", false),
    PROPERTY_PARAMETER("property constructor parameter", false),
    CLASS_ONLY("class", false),
    OBJECT("object", false),
    COMPANION_OBJECT("companion object", false),
    INTERFACE("interface", false),
    ENUM_CLASS("enum class", false),
    ENUM_ENTRY("enum entry", false),
    LOCAL_CLASS("local class", false),
    LOCAL_FUNCTION("local function", false),
    MEMBER_FUNCTION("member function", false),
    TOP_LEVEL_FUNCTION("top level function", false),
    MEMBER_PROPERTY("member property", false),
    MEMBER_PROPERTY_WITH_BACKING_FIELD("member property with backing field", false),
    MEMBER_PROPERTY_WITH_DELEGATE("member property with delegate", false),
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("member property without backing field or delegate", false),
    TOP_LEVEL_PROPERTY("top level property", false),
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD("top level property with backing field", false),
    TOP_LEVEL_PROPERTY_WITH_DELEGATE("top level property with delegate", false),
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("top level property without backing field or delegate", false),
    INITIALIZER("initializer", false),
    DESTRUCTURING_DECLARATION("destructuring declaration", false),
    LAMBDA_EXPRESSION("lambda expression", false),
    ANONYMOUS_FUNCTION("anonymous function", false),
    OBJECT_LITERAL("object literal", false);
    
    @NotNull
    private static final Set<KotlinTarget> ALL_TARGET_SET;
    @NotNull
    private static final List<KotlinTarget> ANNOTATION_CLASS_LIST;
    @NotNull
    private static final List<KotlinTarget> CLASS_LIST;
    @NotNull
    private static final List<KotlinTarget> COMPANION_OBJECT_LIST;
    @NotNull
    private static final Set<KotlinTarget> DEFAULT_TARGET_SET;
    @NotNull
    private static final List<KotlinTarget> ENUM_ENTRY_LIST;
    @NotNull
    private static final List<KotlinTarget> ENUM_LIST;
    @NotNull
    private static final List<KotlinTarget> FILE_LIST;
    @NotNull
    private static final List<KotlinTarget> FUNCTION_LIST;
    @NotNull
    private static final List<KotlinTarget> INTERFACE_LIST;
    @NotNull
    private static final List<KotlinTarget> LOCAL_CLASS_LIST;
    @NotNull
    private static final List<KotlinTarget> OBJECT_LIST;
    @NotNull
    private static final List<KotlinTarget> PROPERTY_GETTER_LIST;
    @NotNull
    private static final List<KotlinTarget> PROPERTY_SETTER_LIST;
    @NotNull
    private static final Map<AnnotationUseSiteTarget, KotlinTarget> USE_SITE_MAPPING;
    @NotNull
    private final String description;
    private final boolean isDefault;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final HashMap<String, KotlinTarget> map = new HashMap<>();

    /* compiled from: KotlinTarget.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        Set<KotlinTarget> L5;
        Set<KotlinTarget> Gy;
        List<KotlinTarget> M;
        List<KotlinTarget> M2;
        List<KotlinTarget> M3;
        List<KotlinTarget> M4;
        List<KotlinTarget> M5;
        List<KotlinTarget> M6;
        List<KotlinTarget> M7;
        List<KotlinTarget> M8;
        List<KotlinTarget> l4;
        List<KotlinTarget> l5;
        List<KotlinTarget> l6;
        List<KotlinTarget> l7;
        Map<AnnotationUseSiteTarget, KotlinTarget> W;
        KotlinTarget[] values = values();
        int length = values.length;
        int i4 = 0;
        while (i4 < length) {
            KotlinTarget kotlinTarget = values[i4];
            i4++;
            map.put(kotlinTarget.name(), kotlinTarget);
        }
        KotlinTarget[] values2 = values();
        ArrayList arrayList = new ArrayList();
        int length2 = values2.length;
        int i5 = 0;
        while (i5 < length2) {
            KotlinTarget kotlinTarget2 = values2[i5];
            i5++;
            if (kotlinTarget2.isDefault()) {
                arrayList.add(kotlinTarget2);
            }
        }
        L5 = f0.L5(arrayList);
        DEFAULT_TARGET_SET = L5;
        Gy = p.Gy(values());
        ALL_TARGET_SET = Gy;
        KotlinTarget kotlinTarget3 = CLASS;
        M = CollectionsKt__CollectionsKt.M(ANNOTATION_CLASS, kotlinTarget3);
        ANNOTATION_CLASS_LIST = M;
        M2 = CollectionsKt__CollectionsKt.M(LOCAL_CLASS, kotlinTarget3);
        LOCAL_CLASS_LIST = M2;
        M3 = CollectionsKt__CollectionsKt.M(CLASS_ONLY, kotlinTarget3);
        CLASS_LIST = M3;
        KotlinTarget kotlinTarget4 = OBJECT;
        M4 = CollectionsKt__CollectionsKt.M(COMPANION_OBJECT, kotlinTarget4, kotlinTarget3);
        COMPANION_OBJECT_LIST = M4;
        M5 = CollectionsKt__CollectionsKt.M(kotlinTarget4, kotlinTarget3);
        OBJECT_LIST = M5;
        M6 = CollectionsKt__CollectionsKt.M(INTERFACE, kotlinTarget3);
        INTERFACE_LIST = M6;
        M7 = CollectionsKt__CollectionsKt.M(ENUM_CLASS, kotlinTarget3);
        ENUM_LIST = M7;
        KotlinTarget kotlinTarget5 = PROPERTY;
        KotlinTarget kotlinTarget6 = FIELD;
        M8 = CollectionsKt__CollectionsKt.M(ENUM_ENTRY, kotlinTarget5, kotlinTarget6);
        ENUM_ENTRY_LIST = M8;
        KotlinTarget kotlinTarget7 = PROPERTY_SETTER;
        l4 = x.l(kotlinTarget7);
        PROPERTY_SETTER_LIST = l4;
        KotlinTarget kotlinTarget8 = PROPERTY_GETTER;
        l5 = x.l(kotlinTarget8);
        PROPERTY_GETTER_LIST = l5;
        l6 = x.l(FUNCTION);
        FUNCTION_LIST = l6;
        KotlinTarget kotlinTarget9 = FILE;
        l7 = x.l(kotlinTarget9);
        FILE_LIST = l7;
        AnnotationUseSiteTarget annotationUseSiteTarget = AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER;
        KotlinTarget kotlinTarget10 = VALUE_PARAMETER;
        W = z0.W(l0.a(annotationUseSiteTarget, kotlinTarget10), l0.a(AnnotationUseSiteTarget.FIELD, kotlinTarget6), l0.a(AnnotationUseSiteTarget.PROPERTY, kotlinTarget5), l0.a(AnnotationUseSiteTarget.FILE, kotlinTarget9), l0.a(AnnotationUseSiteTarget.PROPERTY_GETTER, kotlinTarget8), l0.a(AnnotationUseSiteTarget.PROPERTY_SETTER, kotlinTarget7), l0.a(AnnotationUseSiteTarget.RECEIVER, kotlinTarget10), l0.a(AnnotationUseSiteTarget.SETTER_PARAMETER, kotlinTarget10), l0.a(AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, kotlinTarget6));
        USE_SITE_MAPPING = W;
    }

    KotlinTarget(String str, boolean z3) {
        this.description = str;
        this.isDefault = z3;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    /* synthetic */ KotlinTarget(String str, boolean z3, int i4, u uVar) {
        this(str, (i4 & 2) != 0 ? true : z3);
    }
}
