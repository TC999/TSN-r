package com.bytedance.pangle.p121f;

import com.bytedance.pangle.C6159i;
import com.bytedance.pangle.InterfaceC6069c;
import com.bytedance.pangle.InterfaceC6075d;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.bytedance.pangle.f.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BinderC6113a extends InterfaceC6069c.AbstractBinderC6070a {

    /* renamed from: a */
    private static volatile BinderC6113a f21985a;

    /* renamed from: b */
    public static BinderC6113a m37167b() {
        if (f21985a == null) {
            synchronized (BinderC6113a.class) {
                if (f21985a == null) {
                    f21985a = new BinderC6113a();
                }
            }
        }
        return f21985a;
    }

    @Override // com.bytedance.pangle.InterfaceC6069c
    /* renamed from: a */
    public final boolean mo37169a(String str) {
        return PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.bytedance.pangle.InterfaceC6069c
    /* renamed from: a */
    public final boolean mo37168a(String str, String str2) {
        return PluginManager.getInstance().syncInstall(str, new File(str2));
    }

    @Override // com.bytedance.pangle.InterfaceC6069c
    /* renamed from: a */
    public final void mo37170a(int i, InterfaceC6075d interfaceC6075d) {
        Zeus.registerPluginStateListener(new C6121c(interfaceC6075d, i));
    }

    @Override // com.bytedance.pangle.InterfaceC6069c
    /* renamed from: a */
    public final void mo37171a(int i) {
        ZeusPluginStateListener zeusPluginStateListener;
        List<ZeusPluginStateListener> list = C6159i.m37090a().f22059b;
        Iterator<ZeusPluginStateListener> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                zeusPluginStateListener = null;
                break;
            }
            zeusPluginStateListener = it.next();
            if ((zeusPluginStateListener instanceof C6121c) && ((C6121c) zeusPluginStateListener).f22008a == i) {
                break;
            }
        }
        if (zeusPluginStateListener != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    @Override // com.bytedance.pangle.InterfaceC6069c
    /* renamed from: b */
    public final int mo37166b(String str) {
        return PluginManager.getInstance().getPlugin(str).getVersion();
    }
}
