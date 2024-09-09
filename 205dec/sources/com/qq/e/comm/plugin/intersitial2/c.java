package com.qq.e.comm.plugin.intersitial2;

import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.intersitial2.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c implements ADListener {

    /* renamed from: a  reason: collision with root package name */
    private final ADListener f44430a;

    /* renamed from: b  reason: collision with root package name */
    private final f.s f44431b;

    public c(ADListener aDListener, f.s sVar) {
        this.f44430a = aDListener;
        this.f44431b = sVar;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        int type;
        if (this.f44430a == null || aDEvent == null || (type = aDEvent.getType()) == 100) {
            return;
        }
        if (type == 103) {
            this.f44430a.onADEvent(aDEvent);
            f.s sVar = this.f44431b;
            if (sVar != null) {
                sVar.a(false);
            }
        } else if (type == 106) {
            this.f44430a.onADEvent(aDEvent);
        } else if (type != 107) {
            this.f44430a.onADEvent(aDEvent);
        } else {
            Integer num = (Integer) com.qq.e.comm.plugin.b.a.a(aDEvent, Integer.class);
            if (num == null || num.intValue() == 5002) {
                return;
            }
            this.f44430a.onADEvent(new ADEvent(101, num));
        }
    }
}
