package io.netty.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class DomainMappingBuilder<V> {
    private final DomainNameMappingBuilder<V> builder;

    public DomainMappingBuilder(V v3) {
        this.builder = new DomainNameMappingBuilder<>(v3);
    }

    public DomainMappingBuilder<V> add(String str, V v3) {
        this.builder.add(str, v3);
        return this;
    }

    public DomainNameMapping<V> build() {
        return this.builder.build();
    }

    public DomainMappingBuilder(int i4, V v3) {
        this.builder = new DomainNameMappingBuilder<>(i4, v3);
    }
}
