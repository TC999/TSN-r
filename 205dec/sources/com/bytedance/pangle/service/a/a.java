package com.bytedance.pangle.service.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.e;
import com.bytedance.pangle.g;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends e.a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f28946c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<ComponentName, IBinder> f28949d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<ComponentName, b> f28950e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final C0433a<Intent> f28951f = new C0433a<>();

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<ComponentName, com.bytedance.pangle.service.a> f28952g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final HashSet<ComponentName> f28953h = new HashSet<>();

    /* renamed from: i  reason: collision with root package name */
    private final HashSet<ComponentName> f28954i = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    public final List<Runnable> f28948b = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public final Handler f28947a = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* renamed from: com.bytedance.pangle.service.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class C0433a<T> extends HashMap<g, T> {
        C0433a() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@Nullable Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (obj instanceof g) {
                for (g gVar : keySet()) {
                    try {
                    } catch (RemoteException e4) {
                        e4.printStackTrace();
                    }
                    if (gVar.a() == ((g) obj).a()) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public final T remove(@Nullable Object obj) {
            g gVar;
            T t3 = (T) super.remove(obj);
            if (t3 != null) {
                return t3;
            }
            Iterator<g> it = keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    gVar = null;
                    break;
                }
                gVar = it.next();
                try {
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
                if (gVar.a() == ((g) obj).a()) {
                    break;
                }
            }
            return (T) super.remove(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class b extends HashSet<g> {
        b() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@Nullable Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (obj instanceof g) {
                Iterator<g> it = iterator();
                while (it.hasNext()) {
                    try {
                    } catch (RemoteException e4) {
                        e4.printStackTrace();
                    }
                    if (it.next().a() == ((g) obj).a()) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@Nullable Object obj) {
            if (super.remove(obj)) {
                return true;
            }
            g gVar = null;
            Iterator<g> it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g next = it.next();
                try {
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
                if (next.a() == ((g) obj).a()) {
                    gVar = next;
                    break;
                }
            }
            return super.remove(gVar);
        }
    }

    private a() {
    }

    public static a b() {
        if (f28946c == null) {
            synchronized (a.class) {
                if (f28946c == null) {
                    f28946c = new a();
                }
            }
        }
        return f28946c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ComponentName c(Intent intent, String str) {
        ComponentName component = intent.getComponent();
        if (!this.f28952g.containsKey(component)) {
            com.bytedance.pangle.service.a d4 = d(intent, str);
            if (d4 == null) {
                return component;
            }
            this.f28952g.put(component, d4);
            this.f28953h.add(component);
        }
        com.bytedance.pangle.service.a aVar = this.f28952g.get(component);
        if (aVar != null) {
            aVar.onStartCommand(intent, 0, 0);
        }
        return component;
    }

    private static com.bytedance.pangle.service.a d(Intent intent, String str) {
        com.bytedance.pangle.service.a e4 = e(intent, str);
        if (e4 != null) {
            e4.onCreate();
        }
        return e4;
    }

    private static com.bytedance.pangle.service.a e(Intent intent, String str) {
        boolean z3;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            z3 = Zeus.loadPlugin(str);
            try {
                com.bytedance.pangle.service.a aVar = (com.bytedance.pangle.service.a) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
                aVar.attach(plugin);
                return aVar;
            } catch (Exception e4) {
                e = e4;
                ZeusLogger.errReport("Zeus/service_pangle", "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(z3)), e);
                return null;
            }
        } catch (Exception e5) {
            e = e5;
            z3 = false;
        }
    }

    @Override // com.bytedance.pangle.e.a, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.bytedance.pangle.e
    public final ComponentName a(final Intent intent, final String str) {
        if (Zeus.hasInit()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return c(intent, str);
            }
            this.f28947a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.c(intent, str);
                }
            });
        } else {
            this.f28948b.add(new Runnable() { // from class: com.bytedance.pangle.service.a.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.c(intent, str);
                }
            });
        }
        return intent.getComponent();
    }

    @Override // com.bytedance.pangle.e
    public final boolean b(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b().a(intent.getComponent());
            return true;
        }
        this.f28947a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.3
            @Override // java.lang.Runnable
            public final void run() {
                a.b().a(intent.getComponent());
            }
        });
        return true;
    }

    private boolean b(ComponentName componentName) {
        if (!this.f28953h.contains(componentName)) {
            if (this.f28950e.get(componentName) == null) {
                c(componentName);
                return true;
            }
            return false;
        } else if (!this.f28954i.contains(componentName) || this.f28950e.containsKey(componentName)) {
            return false;
        } else {
            c(componentName);
            return true;
        }
    }

    private void c(ComponentName componentName) {
        com.bytedance.pangle.service.a remove = this.f28952g.remove(componentName);
        this.f28954i.remove(componentName);
        this.f28949d.remove(componentName);
        this.f28953h.remove(componentName);
        if (remove != null) {
            remove.onDestroy();
        }
    }

    public final synchronized boolean a(ComponentName componentName) {
        if (this.f28952g.containsKey(componentName)) {
            this.f28954i.add(componentName);
            return b(componentName);
        }
        return false;
    }

    @Override // com.bytedance.pangle.e
    public final boolean a(final Intent intent, final g gVar, final int i4, final String str) {
        if (Zeus.hasInit()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return a(intent, gVar, str);
            }
            this.f28947a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        a.this.a(intent, gVar, str);
                    } catch (RemoteException e4) {
                        ZeusLogger.errReport("Zeus/service_pangle", "bindService failed", e4);
                    }
                }
            });
            return true;
        }
        this.f28948b.add(new Runnable() { // from class: com.bytedance.pangle.service.a.a.5
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.a(intent, gVar, str);
                } catch (RemoteException e4) {
                    ZeusLogger.errReport("Zeus/service_pangle", "pending bindService failed", e4);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(g gVar) {
        for (ComponentName componentName : this.f28950e.keySet()) {
            b bVar = this.f28950e.get(componentName);
            if (bVar.contains(gVar)) {
                bVar.remove(gVar);
                Intent remove = this.f28951f.remove(gVar);
                if (bVar.size() == 0) {
                    this.f28950e.remove(componentName);
                    com.bytedance.pangle.service.a aVar = this.f28952g.get(componentName);
                    if (aVar != null) {
                        aVar.onUnbind(remove);
                    }
                }
                b(componentName);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(Intent intent, g gVar, String str) {
        ComponentName component = intent.getComponent();
        if (!this.f28952g.containsKey(component)) {
            com.bytedance.pangle.service.a d4 = d(intent, str);
            if (d4 == null) {
                return false;
            }
            this.f28952g.put(component, d4);
        }
        com.bytedance.pangle.service.a aVar = this.f28952g.get(component);
        if (!this.f28949d.containsKey(component)) {
            this.f28949d.put(component, aVar.onBind(intent));
        }
        IBinder iBinder = this.f28949d.get(component);
        if (iBinder != null) {
            if (this.f28950e.containsKey(component)) {
                if (!this.f28950e.get(component).contains(gVar)) {
                    this.f28950e.get(component).add(gVar);
                    this.f28951f.put(gVar, intent);
                    gVar.a(component, iBinder);
                }
            } else {
                b bVar = new b();
                bVar.add(gVar);
                this.f28950e.put(component, bVar);
                this.f28951f.put(gVar, intent);
                gVar.a(component, iBinder);
            }
        }
        return true;
    }

    @Override // com.bytedance.pangle.e
    public final void a(final g gVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(gVar);
        } else {
            this.f28947a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.6
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.b(gVar);
                }
            });
        }
    }
}
