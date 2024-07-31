package io.netty.handler.ssl;

import java.util.List;
import java.util.Set;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface CipherSuiteFilter {
    String[] filterCipherSuites(Iterable<String> iterable, List<String> list, Set<String> set);
}
