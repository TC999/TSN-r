package com.qq.e.dl.k;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Object, g> f47027a = new ConcurrentHashMap(20);

    public static g a(Object obj) {
        if (JSONObject.NULL.equals(obj)) {
            return null;
        }
        g gVar = f47027a.get(obj);
        if (gVar != null) {
            return gVar.a();
        }
        if (obj instanceof String) {
            gVar = d((String) obj);
        }
        if (obj instanceof JSONArray) {
            gVar = d(obj.toString());
        }
        if (gVar == null) {
            gVar = new j(obj);
        }
        f47027a.put(obj, gVar);
        return gVar;
    }

    public static c b(Object obj) {
        g gVar = f47027a.get(obj);
        if (gVar instanceof c) {
            return (c) gVar;
        }
        if (gVar != null) {
            return null;
        }
        if (obj instanceof String) {
            gVar = d((String) obj);
        } else if (obj instanceof JSONArray) {
            gVar = d(obj.toString());
        }
        if (gVar != null) {
            f47027a.put(obj, gVar);
        }
        return (c) gVar;
    }

    public static j c(Object obj) {
        if (JSONObject.NULL.equals(obj)) {
            return new h();
        }
        if (!(obj instanceof String) && !(obj instanceof Number)) {
            return new j(obj);
        }
        g gVar = f47027a.get(obj);
        if (gVar instanceof j) {
            return (j) gVar;
        }
        j jVar = new j(obj);
        f47027a.put(obj, jVar);
        return jVar;
    }

    private static g d(String str) {
        if (a(str)) {
            List<String> c4 = c(str);
            if (c4.isEmpty()) {
                return null;
            }
            if (c4.size() == 1) {
                return e(str);
            }
            ArrayList arrayList = new ArrayList();
            for (String str2 : c4) {
                g e4 = e(str2);
                if (e4 == null) {
                    return null;
                }
                arrayList.add(e4);
            }
            return new b(arrayList);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
        if (r8 != ';') goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.qq.e.dl.k.g e(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.dl.k.l.e(java.lang.String):com.qq.e.dl.k.g");
    }

    private static List<String> c(String str) {
        int i4;
        int i5;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i6 = 0;
        boolean z3 = false;
        int i7 = 0;
        int i8 = 0;
        while (i6 < length) {
            char charAt = str.charAt(i6);
            if (charAt == '$' && (i5 = i6 + 1) < length && str.charAt(i5) == '{' && !z3) {
                int indexOf = str.indexOf(125, i6 + 2);
                if (indexOf != -1) {
                    if (sb.length() > 0) {
                        arrayList.add(sb.toString());
                        sb.setLength(0);
                    }
                    arrayList.add(str.substring(i6, indexOf + 1));
                    i6 = indexOf;
                } else {
                    sb.append(charAt);
                }
            } else if (charAt == ';' && (i4 = i6 + 1) < length && str.charAt(i4) == '{') {
                if (sb.length() > 0) {
                    arrayList.add(str.substring(i8, i6));
                    sb.setLength(0);
                }
                sb.append(charAt);
                i8 = i6;
                z3 = true;
            } else if (charAt == '{' && z3) {
                i7++;
                sb.append(charAt);
            } else if (charAt == '}' && z3 && i7 > 1) {
                i7--;
                sb.append(charAt);
            } else if (charAt == '}' && z3 && i7 == 1) {
                i7--;
                sb.append(charAt);
                if (sb.length() > 0) {
                    arrayList.add(str.substring(i8, i6 + 1));
                    sb.setLength(0);
                }
                z3 = false;
            } else {
                sb.append(charAt);
            }
            i6++;
        }
        if (sb.length() > 0) {
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    private static e b(String str) {
        if (str == null) {
            return null;
        }
        g gVar = f47027a.get(str);
        if (gVar instanceof e) {
            return (e) gVar;
        }
        e eVar = new e(str);
        f47027a.put(str, eVar);
        return eVar;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("${") || str.contains(";{");
    }
}
