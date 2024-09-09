package io.netty.handler.ssl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
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
                    arrayList = new ArrayList(list.size());
                    iterable = list;
                } else {
                    arrayList = new ArrayList(set.size());
                }
                Iterator<String> it = iterable.iterator();
                while (it.hasNext() && (next = it.next()) != null) {
                    if (set.contains(next)) {
                        arrayList.add(next);
                    }
                }
                return (String[]) arrayList.toArray(new String[0]);
            }
            throw new NullPointerException("supportedCiphers");
        }
        throw new NullPointerException("defaultCiphers");
    }
}
