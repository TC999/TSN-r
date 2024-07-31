package com.kwad.sdk.core.imageloader.cache.disc.naming;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class HashCodeFileNameGenerator implements FileNameGenerator {
    @Override // com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator
    public String generate(String str) {
        return String.valueOf(str.hashCode());
    }
}
