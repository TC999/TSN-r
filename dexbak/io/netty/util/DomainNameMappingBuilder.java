package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class DomainNameMappingBuilder<V> {
    private final V defaultValue;
    private final Map<String, V> map;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static final class ImmutableDomainNameMapping<V> extends DomainNameMapping<V> {
        private static final int REPR_CONST_PART_LENGTH = 46;
        private static final String REPR_HEADER = "ImmutableDomainNameMapping(default: ";
        private static final String REPR_MAP_CLOSING = "})";
        private static final String REPR_MAP_OPENING = ", map: {";
        private final String[] domainNamePatterns;
        private final Map<String, V> map;
        private final V[] values;

        private StringBuilder appendMapping(StringBuilder sb, int i) {
            return appendMapping(sb, this.domainNamePatterns[i], this.values[i].toString());
        }

        private static int estimateBufferSize(int i, int i2, int i3) {
            int i4 = REPR_CONST_PART_LENGTH + i;
            double d = i3 * i2;
            Double.isNaN(d);
            return i4 + ((int) (d * 1.1d));
        }

        @Override // io.netty.util.DomainNameMapping
        @Deprecated
        public DomainNameMapping<V> add(String str, V v) {
            throw new UnsupportedOperationException("Immutable DomainNameMapping does not support modification after initial creation");
        }

        @Override // io.netty.util.DomainNameMapping
        public Map<String, V> asMap() {
            return this.map;
        }

        @Override // io.netty.util.DomainNameMapping
        public String toString() {
            String obj = this.defaultValue.toString();
            String[] strArr = this.domainNamePatterns;
            int length = strArr.length;
            if (length == 0) {
                return REPR_HEADER + obj + REPR_MAP_OPENING + REPR_MAP_CLOSING;
            }
            String str = strArr[0];
            String obj2 = this.values[0].toString();
            StringBuilder sb = new StringBuilder(estimateBufferSize(obj.length(), length, str.length() + obj2.length() + 3));
            sb.append(REPR_HEADER);
            sb.append(obj);
            sb.append(REPR_MAP_OPENING);
            appendMapping(sb, str, obj2);
            for (int i = 1; i < length; i++) {
                sb.append(", ");
                appendMapping(sb, i);
            }
            sb.append(REPR_MAP_CLOSING);
            return sb.toString();
        }

        private ImmutableDomainNameMapping(V v, Map<String, V> map) {
            super((Map) null, v);
            Set<Map.Entry<String, V>> entrySet = map.entrySet();
            int size = entrySet.size();
            this.domainNamePatterns = new String[size];
            this.values = (V[]) new Object[size];
            LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
            int i = 0;
            for (Map.Entry<String, V> entry : entrySet) {
                String normalizeHostname = DomainNameMapping.normalizeHostname(entry.getKey());
                V value = entry.getValue();
                this.domainNamePatterns[i] = normalizeHostname;
                this.values[i] = value;
                linkedHashMap.put(normalizeHostname, value);
                i++;
            }
            this.map = Collections.unmodifiableMap(linkedHashMap);
        }

        private static StringBuilder appendMapping(StringBuilder sb, String str, String str2) {
            sb.append(str);
            sb.append('=');
            sb.append(str2);
            return sb;
        }

        @Override // io.netty.util.DomainNameMapping, io.netty.util.Mapping
        public V map(String str) {
            if (str != null) {
                String normalizeHostname = DomainNameMapping.normalizeHostname(str);
                int length = this.domainNamePatterns.length;
                for (int i = 0; i < length; i++) {
                    if (DomainNameMapping.matches(this.domainNamePatterns[i], normalizeHostname)) {
                        return this.values[i];
                    }
                }
            }
            return this.defaultValue;
        }
    }

    public DomainNameMappingBuilder(V v) {
        this(4, v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DomainNameMappingBuilder<V> add(String str, V v) {
        this.map.put(ObjectUtil.checkNotNull(str, "hostname"), ObjectUtil.checkNotNull(v, "output"));
        return this;
    }

    public DomainNameMapping<V> build() {
        return new ImmutableDomainNameMapping(this.defaultValue, this.map);
    }

    public DomainNameMappingBuilder(int i, V v) {
        this.defaultValue = (V) ObjectUtil.checkNotNull(v, "defaultValue");
        this.map = new LinkedHashMap(i);
    }
}
