package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import android.content.Context;
import java.util.HashMap;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TncInstanceManager {

    /* renamed from: a */
    private static volatile TncInstanceManager f765a;

    /* renamed from: b */
    private static HashMap<Integer, TNCManager> f766b;

    /* renamed from: c */
    private static HashMap<Integer, AppConfig> f767c;

    private TncInstanceManager() {
        f766b = new HashMap<>();
        f767c = new HashMap<>();
    }

    /* renamed from: a */
    public static synchronized TncInstanceManager m59006a() {
        TncInstanceManager tncInstanceManager;
        synchronized (TncInstanceManager.class) {
            if (f765a == null) {
                synchronized (TncInstanceManager.class) {
                    if (f765a == null) {
                        f765a = new TncInstanceManager();
                    }
                }
            }
            tncInstanceManager = f765a;
        }
        return tncInstanceManager;
    }

    /* renamed from: a */
    public TNCManager m59005a(int i) {
        if (f766b.get(Integer.valueOf(i)) == null) {
            f766b.put(Integer.valueOf(i), new TNCManager(i));
        }
        return f766b.get(Integer.valueOf(i));
    }

    /* renamed from: a */
    public AppConfig m59004a(int i, Context context) {
        if (f767c.get(Integer.valueOf(i)) == null) {
            f767c.put(Integer.valueOf(i), new AppConfig(context, i));
        }
        return f767c.get(Integer.valueOf(i));
    }
}
