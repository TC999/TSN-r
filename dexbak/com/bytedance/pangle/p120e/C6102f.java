package com.bytedance.pangle.p120e;

import android.os.SystemClock;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.p119d.C6082d;
import com.bytedance.pangle.p119d.C6083e;
import com.bytedance.pangle.util.C6253i;
import com.bytedance.pangle.util.C6256l;
import java.util.Map;

/* renamed from: com.bytedance.pangle.e.f */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6102f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.pangle.e.f$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC6105a {
        /* renamed from: a */
        boolean mo37184a(String str, int i);
    }

    /* renamed from: a */
    public static void m37186a() {
        if (GlobalParam.getInstance().isCloseBgDex2oat()) {
            return;
        }
        if ((C6253i.m36883e() || C6253i.m36881g() || C6253i.m36886b()) && C6082d.m37217a(Zeus.getAppApplication())) {
            C6083e.m37212a(new Runnable() { // from class: com.bytedance.pangle.e.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    SystemClock.sleep(GlobalParam.getInstance().getDexOptDelayTime());
                    C6102f.m37185b();
                }
            });
        }
    }

    /* renamed from: b */
    public static synchronized void m37185b() {
        InterfaceC6105a interfaceC6105a;
        synchronized (C6102f.class) {
            Map<String, ?> all = C6096b.m37198a(Zeus.getAppApplication()).getAll();
            if (all.size() > 0) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    ZeusLogger.m37081i(ZeusLogger.TAG_LOAD, "fullDex2oat start:" + entry.getKey());
                    if (C6253i.m36881g()) {
                        interfaceC6105a = new C6099e();
                    } else if (C6253i.m36883e()) {
                        interfaceC6105a = new C6098d();
                    } else if (C6253i.m36886b()) {
                        interfaceC6105a = new C6097c();
                    } else {
                        interfaceC6105a = new InterfaceC6105a() { // from class: com.bytedance.pangle.e.f.2
                            @Override // com.bytedance.pangle.p120e.C6102f.InterfaceC6105a
                            /* renamed from: a */
                            public final boolean mo37184a(String str, int i) {
                                return true;
                            }
                        };
                    }
                    if (interfaceC6105a.mo37184a(entry.getKey(), ((Integer) entry.getValue()).intValue())) {
                        C6096b.m37198a(Zeus.getAppApplication()).edit().remove(entry.getKey()).apply();
                        ZeusLogger.m37081i(ZeusLogger.TAG_LOAD, "fullDex2oat success:" + entry.getKey());
                        C6256l.m36869a().m36861b(entry.getKey(), ((Integer) entry.getValue()).intValue(), true);
                        ZeusLogger.m37081i(ZeusLogger.TAG_LOAD, "fullDex2oat markDexOptState:" + entry.getKey());
                    } else {
                        ZeusLogger.m37081i(ZeusLogger.TAG_LOAD, "fullDex2oat failed:" + entry.getKey());
                    }
                }
            }
        }
    }
}
