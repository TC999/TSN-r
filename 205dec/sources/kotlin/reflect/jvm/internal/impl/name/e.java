package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.f0;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FqNamesUtil.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {

    /* compiled from: FqNamesUtil.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57572a;

        static {
            int[] iArr = new int[i.values().length];
            iArr[i.BEGINNING.ordinal()] = 1;
            iArr[i.AFTER_DOT.ordinal()] = 2;
            iArr[i.MIDDLE.ordinal()] = 3;
            f57572a = iArr;
        }
    }

    @Nullable
    public static final <V> V a(@NotNull c cVar, @NotNull Map<c, ? extends V> values) {
        Object next;
        f0.p(cVar, "<this>");
        f0.p(values, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<c, ? extends V>> it = values.entrySet().iterator();
        while (true) {
            boolean z3 = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<c, ? extends V> next2 = it.next();
            c key = next2.getKey();
            if (!f0.g(cVar, key) && !b(cVar, key)) {
                z3 = false;
            }
            if (z3) {
                linkedHashMap.put(next2.getKey(), next2.getValue());
            }
        }
        if (!(!linkedHashMap.isEmpty())) {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return null;
        }
        Iterator it2 = linkedHashMap.entrySet().iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                int length = g((c) ((Map.Entry) next).getKey(), cVar).b().length();
                do {
                    Object next3 = it2.next();
                    int length2 = g((c) ((Map.Entry) next3).getKey(), cVar).b().length();
                    if (length > length2) {
                        next = next3;
                        length = length2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry == null) {
            return null;
        }
        return (V) entry.getValue();
    }

    public static final boolean b(@NotNull c cVar, @NotNull c packageName) {
        f0.p(cVar, "<this>");
        f0.p(packageName, "packageName");
        return f0.g(f(cVar), packageName);
    }

    private static final boolean c(String str, String str2) {
        boolean u22;
        u22 = w.u2(str, str2, false, 2, null);
        return u22 && str.charAt(str2.length()) == '.';
    }

    public static final boolean d(@NotNull c cVar, @NotNull c packageName) {
        f0.p(cVar, "<this>");
        f0.p(packageName, "packageName");
        if (f0.g(cVar, packageName) || packageName.d()) {
            return true;
        }
        String b4 = cVar.b();
        f0.o(b4, "this.asString()");
        String b5 = packageName.b();
        f0.o(b5, "packageName.asString()");
        return c(b4, b5);
    }

    public static final boolean e(@Nullable String str) {
        if (str == null) {
            return false;
        }
        i iVar = i.BEGINNING;
        int i4 = 0;
        while (i4 < str.length()) {
            char charAt = str.charAt(i4);
            i4++;
            int i5 = a.f57572a[iVar.ordinal()];
            if (i5 == 1 || i5 == 2) {
                if (!Character.isJavaIdentifierPart(charAt)) {
                    return false;
                }
                iVar = i.MIDDLE;
            } else if (i5 != 3) {
                continue;
            } else if (charAt == '.') {
                iVar = i.AFTER_DOT;
            } else if (!Character.isJavaIdentifierPart(charAt)) {
                return false;
            }
        }
        return iVar != i.AFTER_DOT;
    }

    @Nullable
    public static final c f(@NotNull c cVar) {
        f0.p(cVar, "<this>");
        if (cVar.d()) {
            return null;
        }
        return cVar.e();
    }

    @NotNull
    public static final c g(@NotNull c cVar, @NotNull c prefix) {
        f0.p(cVar, "<this>");
        f0.p(prefix, "prefix");
        if (!d(cVar, prefix) || prefix.d()) {
            return cVar;
        }
        if (f0.g(cVar, prefix)) {
            c ROOT = c.f57562c;
            f0.o(ROOT, "ROOT");
            return ROOT;
        }
        String b4 = cVar.b();
        f0.o(b4, "asString()");
        String substring = b4.substring(prefix.b().length() + 1);
        f0.o(substring, "this as java.lang.String).substring(startIndex)");
        return new c(substring);
    }
}
