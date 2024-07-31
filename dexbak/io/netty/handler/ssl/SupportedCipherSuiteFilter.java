package io.netty.handler.ssl;

import io.netty.util.internal.InternalThreadLocalMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SupportedCipherSuiteFilter implements CipherSuiteFilter {
    public static final SupportedCipherSuiteFilter INSTANCE = new SupportedCipherSuiteFilter();

    private SupportedCipherSuiteFilter() {
    }

    @Override // io.netty.handler.ssl.CipherSuiteFilter
    public String[] filterCipherSuites(Iterable<String> iterable, List<String> list, Set<String> set) {
        ArrayList arrayList;
        String next;
        if (list != null) {
            if (set != null) {
                if (iterable == null) {
                    arrayList = InternalThreadLocalMap.get().arrayList(list.size());
                    iterable = list;
                } else {
                    arrayList = InternalThreadLocalMap.get().arrayList(set.size());
                }
                Iterator<String> it = iterable.iterator();
                while (it.hasNext() && (next = it.next()) != null) {
                    if (set.contains(next)) {
                        arrayList.add(next);
                    }
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            throw new NullPointerException("supportedCiphers");
        }
        throw new NullPointerException("defaultCiphers");
    }
}
