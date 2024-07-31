package com.baidu.mobads.sdk.internal.p050a;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.a.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2578d implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ InterfaceC2574a f8518a;

    /* renamed from: b */
    final /* synthetic */ C2576c f8519b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2578d(C2576c c2576c, InterfaceC2574a interfaceC2574a) {
        this.f8519b = c2576c;
        this.f8518a = interfaceC2574a;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || !C2576c.f8509h.equals(iOAdEvent.getType()) || (data = iOAdEvent.getData()) == null || data.isEmpty()) {
            return;
        }
        Object obj = data.get("e_t");
        Object obj2 = data.get("e_n");
        Object obj3 = data.get("e_a");
        if ((obj instanceof String) && (obj2 instanceof String)) {
            data.put("e_r", this.f8518a.handleEvent((String) obj, (String) obj2, obj3 instanceof Object[] ? (Object[]) obj3 : null));
        }
    }
}
