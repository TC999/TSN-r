package com.kwad.sdk.core.imageloader.cache.disc.naming;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class HashCodeFileNameGenerator implements FileNameGenerator {
    @Override // com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator
    public String generate(String str) {
        return String.valueOf(str.hashCode());
    }
}
