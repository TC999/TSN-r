package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DomainNameMapping<V> implements Mapping<String, V> {
    final V defaultValue;
    private final Map<String, V> map;
    private final Map<String, V> unmodifiableMap;

    @Deprecated
    public DomainNameMapping(V v3) {
        this(4, v3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean matches(String str, String str2) {
        if (str.startsWith("*.")) {
            return str.regionMatches(2, str2, 0, str2.length()) || StringUtil.commonSuffixOfLength(str2, str, str.length() - 1);
        }
        return str.equals(str2);
    }

    private static boolean needsNormalization(String str) {
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (str.charAt(i4) > '\u007f') {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String normalizeHostname(String str) {
        if (needsNormalization(str)) {
            str = IDN.toASCII(str, 1);
        }
        return str.toLowerCase(Locale.US);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public DomainNameMapping<V> add(String str, V v3) {
        this.map.put(normalizeHostname((String) ObjectUtil.checkNotNull(str, "hostname")), ObjectUtil.checkNotNull(v3, "output"));
        return this;
    }

    public Map<String, V> asMap() {
        return this.unmodifiableMap;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(default: " + this.defaultValue + ", map: " + this.map + ')';
    }

    @Deprecated
    public DomainNameMapping(int i4, V v3) {
        this(new LinkedHashMap(i4), v3);
    }

    @Override // io.netty.util.Mapping
    public V map(String str) {
        if (str != null) {
            String normalizeHostname = normalizeHostname(str);
            for (Map.Entry<String, V> entry : this.map.entrySet()) {
                if (matches(entry.getKey(), normalizeHostname)) {
                    return entry.getValue();
                }
            }
        }
        return this.defaultValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DomainNameMapping(Map<String, V> map, V v3) {
        this.defaultValue = (V) ObjectUtil.checkNotNull(v3, "defaultValue");
        this.map = map;
        this.unmodifiableMap = map != null ? Collections.unmodifiableMap(map) : null;
    }
}
