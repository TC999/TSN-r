package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.e;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class m<T extends e> implements l<T> {
    private final Map<String, T> axH = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.l
    /* renamed from: b */
    public synchronized void j(@NonNull T t3) {
        this.axH.put(t3.actionId, t3);
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized List<T> EI() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.axH.size());
        for (Map.Entry<String, T> entry : this.axH.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        int size;
        size = this.axH.size();
        com.kwad.sdk.core.e.c.d("MemReportCache", "size() = " + size);
        return size;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void x(List<T> list) {
        for (T t3 : list) {
            if (t3 != null) {
                this.axH.remove(t3.actionId);
            }
        }
    }
}
