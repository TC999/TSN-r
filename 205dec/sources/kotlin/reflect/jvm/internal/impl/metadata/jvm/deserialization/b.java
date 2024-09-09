package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.f0;
import kotlin.jvm.JvmStatic;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClassMapperLite.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f57525a = new b();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final String f57526b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, String> f57527c;

    static {
        List M;
        String X2;
        List M2;
        List<String> M3;
        List<String> M4;
        List<String> M5;
        M = CollectionsKt__CollectionsKt.M('k', 'o', 't', 'l', 'i', 'n');
        X2 = f0.X2(M, "", null, null, 0, null, null, 62, null);
        f57526b = X2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        M2 = CollectionsKt__CollectionsKt.M("Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int c4 = kotlin.internal.c.c(0, M2.size() - 1, 2);
        if (c4 >= 0) {
            int i4 = 0;
            while (true) {
                int i5 = i4 + 2;
                StringBuilder sb = new StringBuilder();
                String str = f57526b;
                sb.append(str);
                sb.append('/');
                sb.append((String) M2.get(i4));
                int i6 = i4 + 1;
                linkedHashMap.put(sb.toString(), M2.get(i6));
                linkedHashMap.put(str + '/' + ((String) M2.get(i4)) + "Array", kotlin.jvm.internal.f0.C("[", M2.get(i6)));
                if (i4 == c4) {
                    break;
                }
                i4 = i5;
            }
        }
        linkedHashMap.put(kotlin.jvm.internal.f0.C(f57526b, "/Unit"), "V");
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        M3 = CollectionsKt__CollectionsKt.M("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum");
        for (String str2 : M3) {
            a(linkedHashMap, str2, kotlin.jvm.internal.f0.C("java/lang/", str2));
        }
        M4 = CollectionsKt__CollectionsKt.M("Iterator", "Collection", "List", "Set", "Map", "ListIterator");
        for (String str3 : M4) {
            a(linkedHashMap, kotlin.jvm.internal.f0.C("collections/", str3), kotlin.jvm.internal.f0.C("java/util/", str3));
            a(linkedHashMap, kotlin.jvm.internal.f0.C("collections/Mutable", str3), kotlin.jvm.internal.f0.C("java/util/", str3));
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i7 = 0; i7 < 23; i7++) {
            String C = kotlin.jvm.internal.f0.C("Function", Integer.valueOf(i7));
            StringBuilder sb2 = new StringBuilder();
            String str4 = f57526b;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i7);
            a(linkedHashMap, C, sb2.toString());
            a(linkedHashMap, kotlin.jvm.internal.f0.C("reflect/KFunction", Integer.valueOf(i7)), kotlin.jvm.internal.f0.C(str4, "/reflect/KFunction"));
        }
        M5 = CollectionsKt__CollectionsKt.M("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum");
        for (String str5 : M5) {
            a(linkedHashMap, kotlin.jvm.internal.f0.C(str5, ".Companion"), f57526b + "/jvm/internal/" + str5 + "CompanionObject");
        }
        f57527c = linkedHashMap;
    }

    private b() {
    }

    private static final void a(Map<String, String> map, String str, String str2) {
        map.put(f57526b + '/' + str, 'L' + str2 + ';');
    }

    @JvmStatic
    @NotNull
    public static final String b(@NotNull String classId) {
        String j22;
        kotlin.jvm.internal.f0.p(classId, "classId");
        String str = f57527c.get(classId);
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append('L');
            j22 = w.j2(classId, '.', '$', false, 4, null);
            sb.append(j22);
            sb.append(';');
            return sb.toString();
        }
        return str;
    }
}
