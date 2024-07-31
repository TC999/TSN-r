package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.report.AbstractC10453e;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.kwad.sdk.core.report.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10463m<T extends AbstractC10453e> implements InterfaceC10462l<T> {
    private final Map<String, T> axH = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.InterfaceC10462l
    /* renamed from: b */
    public synchronized void mo26018j(@NonNull T t) {
        this.axH.put(t.actionId, t);
    }

    @Override // com.kwad.sdk.core.report.InterfaceC10462l
    /* renamed from: EI */
    public final synchronized List<T> mo26020EI() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.axH.size());
        for (Map.Entry<String, T> entry : this.axH.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.core.report.InterfaceC10462l
    public final synchronized long size() {
        int size;
        size = this.axH.size();
        C10331c.m26254d("MemReportCache", "size() = " + size);
        return size;
    }

    @Override // com.kwad.sdk.core.report.InterfaceC10462l
    /* renamed from: x */
    public final synchronized void mo26017x(List<T> list) {
        for (T t : list) {
            if (t != null) {
                this.axH.remove(t.actionId);
            }
        }
    }
}
