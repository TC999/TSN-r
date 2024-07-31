package com.bytedance.pangle.service.p125a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.bytedance.pangle.InterfaceC6091e;
import com.bytedance.pangle.InterfaceC6128g;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.service.InterfaceC6223a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.bytedance.pangle.service.a.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BinderC6224a extends InterfaceC6091e.AbstractBinderC6092a {

    /* renamed from: b */
    private static volatile BinderC6224a f22185b;

    /* renamed from: c */
    private final HashMap<ComponentName, IBinder> f22187c = new HashMap<>();

    /* renamed from: d */
    private final HashMap<ComponentName, C6230b> f22188d = new HashMap<>();

    /* renamed from: e */
    private final C6229a<Intent> f22189e = new C6229a<>();

    /* renamed from: f */
    private final HashMap<ComponentName, InterfaceC6223a> f22190f = new HashMap<>();

    /* renamed from: g */
    private final HashSet<ComponentName> f22191g = new HashSet<>();

    /* renamed from: h */
    private final HashSet<ComponentName> f22192h = new HashSet<>();

    /* renamed from: a */
    private final Handler f22186a = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.pangle.service.a.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6229a<T> extends HashMap<InterfaceC6128g, T> {
        C6229a() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@Nullable Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (obj instanceof InterfaceC6128g) {
                for (InterfaceC6128g interfaceC6128g : keySet()) {
                    try {
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    if (interfaceC6128g.mo36944a() == ((InterfaceC6128g) obj).mo36944a()) {
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
            InterfaceC6128g interfaceC6128g;
            T t = (T) super.remove(obj);
            if (t != null) {
                return t;
            }
            Iterator<InterfaceC6128g> it = keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    interfaceC6128g = null;
                    break;
                }
                interfaceC6128g = it.next();
                try {
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                if (interfaceC6128g.mo36944a() == ((InterfaceC6128g) obj).mo36944a()) {
                    break;
                }
            }
            return (T) super.remove(interfaceC6128g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.pangle.service.a.a$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6230b extends HashSet<InterfaceC6128g> {
        C6230b() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@Nullable Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (obj instanceof InterfaceC6128g) {
                Iterator<InterfaceC6128g> it = iterator();
                while (it.hasNext()) {
                    try {
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    if (it.next().mo36944a() == ((InterfaceC6128g) obj).mo36944a()) {
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
            InterfaceC6128g interfaceC6128g = null;
            Iterator<InterfaceC6128g> it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                InterfaceC6128g next = it.next();
                try {
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                if (next.mo36944a() == ((InterfaceC6128g) obj).mo36944a()) {
                    interfaceC6128g = next;
                    break;
                }
            }
            return super.remove(interfaceC6128g);
        }
    }

    private BinderC6224a() {
    }

    /* renamed from: b */
    public static BinderC6224a m36952b() {
        if (f22185b == null) {
            synchronized (BinderC6224a.class) {
                if (f22185b == null) {
                    f22185b = new BinderC6224a();
                }
            }
        }
        return f22185b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public synchronized ComponentName m36947c(Intent intent, String str) {
        ComponentName component = intent.getComponent();
        if (!this.f22190f.containsKey(component)) {
            InterfaceC6223a m36946d = m36946d(intent, str);
            if (m36946d == null) {
                return component;
            }
            this.f22190f.put(component, m36946d);
            this.f22191g.add(component);
        }
        InterfaceC6223a interfaceC6223a = this.f22190f.get(component);
        if (interfaceC6223a != null) {
            interfaceC6223a.onStartCommand(intent, 0, 0);
        }
        return component;
    }

    /* renamed from: d */
    private static InterfaceC6223a m36946d(Intent intent, String str) {
        InterfaceC6223a m36945e = m36945e(intent, str);
        if (m36945e != null) {
            m36945e.onCreate();
        }
        return m36945e;
    }

    /* renamed from: e */
    private static InterfaceC6223a m36945e(Intent intent, String str) {
        boolean z;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            z = Zeus.loadPlugin(str);
            try {
                InterfaceC6223a interfaceC6223a = (InterfaceC6223a) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
                interfaceC6223a.attach(plugin);
                return interfaceC6223a;
            } catch (Exception e) {
                e = e;
                ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(z)), e);
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    @Override // com.bytedance.pangle.InterfaceC6091e.AbstractBinderC6092a, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.bytedance.pangle.InterfaceC6091e
    /* renamed from: a */
    public final ComponentName mo36957a(final Intent intent, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return m36947c(intent, str);
        }
        this.f22186a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                BinderC6224a.this.m36947c(intent, str);
            }
        });
        return intent.getComponent();
    }

    @Override // com.bytedance.pangle.InterfaceC6091e
    /* renamed from: b */
    public final boolean mo36950b(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            m36952b().m36960a(intent.getComponent());
            return true;
        }
        this.f22186a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                BinderC6224a.m36952b().m36960a(intent.getComponent());
            }
        });
        return true;
    }

    /* renamed from: a */
    public final synchronized boolean m36960a(ComponentName componentName) {
        if (this.f22190f.containsKey(componentName)) {
            this.f22192h.add(componentName);
            return m36951b(componentName);
        }
        return false;
    }

    /* renamed from: b */
    private boolean m36951b(ComponentName componentName) {
        if (!this.f22191g.contains(componentName)) {
            if (this.f22188d.get(componentName) == null) {
                m36948c(componentName);
                return true;
            }
            return false;
        } else if (!this.f22192h.contains(componentName) || this.f22188d.containsKey(componentName)) {
            return false;
        } else {
            m36948c(componentName);
            return true;
        }
    }

    /* renamed from: c */
    private void m36948c(ComponentName componentName) {
        InterfaceC6223a remove = this.f22190f.remove(componentName);
        this.f22192h.remove(componentName);
        this.f22187c.remove(componentName);
        this.f22191g.remove(componentName);
        if (remove != null) {
            remove.onDestroy();
        }
    }

    @Override // com.bytedance.pangle.InterfaceC6091e
    /* renamed from: a */
    public final boolean mo36959a(final Intent intent, final InterfaceC6128g interfaceC6128g, final int i, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return m36958a(intent, interfaceC6128g, str);
        }
        this.f22186a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    BinderC6224a.this.m36958a(intent, interfaceC6128g, str);
                } catch (RemoteException e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized boolean m36958a(Intent intent, InterfaceC6128g interfaceC6128g, String str) {
        ComponentName component = intent.getComponent();
        if (!this.f22190f.containsKey(component)) {
            InterfaceC6223a m36946d = m36946d(intent, str);
            if (m36946d == null) {
                return false;
            }
            this.f22190f.put(component, m36946d);
        }
        InterfaceC6223a interfaceC6223a = this.f22190f.get(component);
        if (!this.f22187c.containsKey(component)) {
            this.f22187c.put(component, interfaceC6223a.onBind(intent));
        }
        IBinder iBinder = this.f22187c.get(component);
        if (iBinder != null) {
            if (this.f22188d.containsKey(component)) {
                if (!this.f22188d.get(component).contains(interfaceC6128g)) {
                    this.f22188d.get(component).add(interfaceC6128g);
                    this.f22189e.put(interfaceC6128g, intent);
                    interfaceC6128g.mo36943a(component, iBinder);
                }
            } else {
                C6230b c6230b = new C6230b();
                c6230b.add(interfaceC6128g);
                this.f22188d.put(component, c6230b);
                this.f22189e.put(interfaceC6128g, intent);
                interfaceC6128g.mo36943a(component, iBinder);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m36949b(InterfaceC6128g interfaceC6128g) {
        for (ComponentName componentName : this.f22188d.keySet()) {
            C6230b c6230b = this.f22188d.get(componentName);
            if (c6230b.contains(interfaceC6128g)) {
                c6230b.remove(interfaceC6128g);
                Intent remove = this.f22189e.remove(interfaceC6128g);
                if (c6230b.size() == 0) {
                    this.f22188d.remove(componentName);
                    InterfaceC6223a interfaceC6223a = this.f22190f.get(componentName);
                    if (interfaceC6223a != null) {
                        interfaceC6223a.onUnbind(remove);
                    }
                }
                m36951b(componentName);
                return;
            }
        }
    }

    @Override // com.bytedance.pangle.InterfaceC6091e
    /* renamed from: a */
    public final void mo36956a(final InterfaceC6128g interfaceC6128g) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            m36949b(interfaceC6128g);
        } else {
            this.f22186a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    BinderC6224a.this.m36949b(interfaceC6128g);
                }
            });
        }
    }
}
