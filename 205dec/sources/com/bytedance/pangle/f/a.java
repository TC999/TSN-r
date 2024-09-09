package com.bytedance.pangle.f;

import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.c;
import com.bytedance.pangle.d;
import com.bytedance.pangle.i;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends c.a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f28746a;

    public static a b() {
        if (f28746a == null) {
            synchronized (a.class) {
                if (f28746a == null) {
                    f28746a = new a();
                }
            }
        }
        return f28746a;
    }

    @Override // com.bytedance.pangle.c
    public final boolean a(String str) {
        return PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.bytedance.pangle.c
    public final boolean a(String str, String str2) {
        return PluginManager.getInstance().syncInstall(str, new File(str2));
    }

    @Override // com.bytedance.pangle.c
    public final void a(int i4, d dVar) {
        Zeus.registerPluginStateListener(new c(dVar, i4));
    }

    @Override // com.bytedance.pangle.c
    public final void a(int i4) {
        ZeusPluginStateListener zeusPluginStateListener;
        List<ZeusPluginStateListener> list = i.a().f28820b;
        Iterator<ZeusPluginStateListener> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                zeusPluginStateListener = null;
                break;
            }
            zeusPluginStateListener = it.next();
            if ((zeusPluginStateListener instanceof c) && ((c) zeusPluginStateListener).f28769a == i4) {
                break;
            }
        }
        if (zeusPluginStateListener != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    @Override // com.bytedance.pangle.c
    public final int b(String str) {
        return PluginManager.getInstance().getPlugin(str).getVersion();
    }
}
