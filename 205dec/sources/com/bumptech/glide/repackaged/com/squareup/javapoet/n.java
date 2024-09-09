package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Modifier;

/* compiled from: Util.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
final class n {

    /* renamed from: a  reason: collision with root package name */
    static final Modifier f17876a;

    static {
        Modifier modifier;
        try {
            modifier = Modifier.valueOf("DEFAULT");
        } catch (IllegalArgumentException unused) {
            modifier = null;
        }
        f17876a = modifier;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(char c4) {
        if (c4 != '\f') {
            if (c4 != '\r') {
                if (c4 != '\"') {
                    if (c4 != '\'') {
                        if (c4 != '\\') {
                            switch (c4) {
                                case '\b':
                                    return "\\b";
                                case '\t':
                                    return "\\t";
                                case '\n':
                                    return "\\n";
                                default:
                                    return Character.isISOControl(c4) ? String.format("\\u%04x", Integer.valueOf(c4)) : Character.toString(c4);
                            }
                        }
                        return "\\\\";
                    }
                    return "\\'";
                }
                return "\"";
            }
            return "\\r";
        }
        return "\\f";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z3, String str, Object... objArr) {
        if (!z3) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T c(T t3, String str, Object... objArr) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(boolean z3, String str, Object... objArr) {
        if (!z3) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(Collection<Modifier> collection) {
        Modifier modifier = f17876a;
        return modifier != null && collection.contains(modifier);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<T> f(Collection<T> collection) {
        return Collections.unmodifiableList(new ArrayList(collection));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map<K, V> g(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map<K, List<V>> h(Map<K, List<V>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                linkedHashMap.put(entry.getKey(), f(entry.getValue()));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Set<T> i(Collection<T> collection) {
        return Collections.unmodifiableSet(new LinkedHashSet(collection));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j(String str, List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i4 = 1; i4 < list.size(); i4++) {
            sb.append(str);
            sb.append(list.get(i4));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(Set<Modifier> set, Modifier... modifierArr) {
        int i4 = 0;
        for (Modifier modifier : modifierArr) {
            if ((modifier != null || f17876a != null) && set.contains(modifier)) {
                i4++;
            }
        }
        b(i4 == 1, "modifiers %s must contain one of %s", set, Arrays.toString(modifierArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append('\"');
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '\'') {
                sb.append("'");
            } else if (charAt == '\"') {
                sb.append("\\\"");
            } else {
                sb.append(a(charAt));
                if (charAt == '\n' && i4 + 1 < str.length()) {
                    sb.append("\"\n");
                    sb.append(str2);
                    sb.append(str2);
                    sb.append("+ \"");
                }
            }
        }
        sb.append('\"');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Set<T> m(Set<T> set, Set<T> set2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(set);
        linkedHashSet.addAll(set2);
        return linkedHashSet;
    }
}
