package com.kwad.sdk.p437i;

import androidx.annotation.WorkerThread;
import com.kwad.sdk.p437i.C10803l;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.C11162c;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.i.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10805m {
    private static final Map<String, C10802k> aJv = new ConcurrentHashMap();
    private static long aJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Jp */
    public static void m24795Jp() {
        long currentTimeMillis = System.currentTimeMillis() - aJw;
        if (aJv.size() <= 0 || currentTimeMillis <= C10796h.m24844Jc().m24838Ji()) {
            return;
        }
        aJw = System.currentTimeMillis();
        final List<C10802k> actionList = getActionList();
        actionList.size();
        C10800j.m24812Jn();
        C10803l.m24800a(actionList, new C10803l.InterfaceC10804a() { // from class: com.kwad.sdk.i.m.1
            @Override // com.kwad.sdk.p437i.C10803l.InterfaceC10804a
            public final void onSuccess() {
                C10800j.m24812Jn();
                C10805m.m24792x(actionList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: a */
    public static synchronized void m24794a(C10799i c10799i, boolean z) {
        synchronized (C10805m.class) {
            Map<String, C10802k> map = aJv;
            if (map.size() > 200) {
                C10800j.logE("LogRequestManger", "enqueueAction fail size limit");
            } else {
                C10802k m24793b = m24793b(c10799i, z);
                map.put(m24793b.actionId, m24793b);
            }
            m24795Jp();
        }
    }

    /* renamed from: b */
    private static C10802k m24793b(C10799i c10799i, boolean z) {
        C11162c.C11163a m23507Oo;
        if (z) {
            m23507Oo = C11162c.C11163a.m23508On();
        } else {
            m23507Oo = C11162c.C11163a.m23507Oo();
        }
        C11162c m23506Op = m23507Oo.m23504b(BusinessType.OTHER).m23503b(SubBusinessType.OTHER).m23493hm("ad_sdk_local_log").m23494hl(c10799i.aJo).m23509A(c10799i.toJson()).m23506Op();
        return new C10802k(m23506Op.m23515Oh(), m23506Op.toString(), c10799i);
    }

    private static synchronized List<C10802k> getActionList() {
        ArrayList arrayList;
        synchronized (C10805m.class) {
            Map<String, C10802k> map = aJv;
            arrayList = new ArrayList(map.size());
            for (Map.Entry<String, C10802k> entry : map.entrySet()) {
                arrayList.add(entry.getValue());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public static synchronized void m24792x(List<C10802k> list) {
        synchronized (C10805m.class) {
            if (list != null) {
                for (C10802k c10802k : list) {
                    aJv.remove(c10802k.actionId);
                }
            }
        }
    }
}
