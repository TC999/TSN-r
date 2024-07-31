package com.bytedance.pangle.service.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Keep;
import com.bytedance.pangle.InterfaceC6091e;
import com.bytedance.pangle.InterfaceC6128g;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.servermanager.C6219b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@Keep
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ServiceManagerNative {
    private static volatile ServiceManagerNative sInstance;
    private final HashMap<ServiceConnection, InterfaceC6128g> serviceConn2ServiceConn = new HashMap<>();
    public HashMap<IBinder, HashMap<ServiceConnection, HashSet<ComponentName>>> process2ConnAndService = new HashMap<>();
    private HashMap<ServiceConnection, HashSet<ServiceInfo>> conn2Service = new HashMap<>();

    private ServiceManagerNative() {
    }

    public static ServiceManagerNative getInstance() {
        if (sInstance == null) {
            synchronized (ServiceManagerNative.class) {
                if (sInstance == null) {
                    sInstance = new ServiceManagerNative();
                }
            }
        }
        return sInstance;
    }

    public boolean bindServiceNative(Context context, Intent intent, final ServiceConnection serviceConnection, int i, String str) {
        ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (queryServiceFromPlugin == null) {
            return context.bindService(intent, serviceConnection, i);
        }
        if (!this.serviceConn2ServiceConn.containsKey(serviceConnection)) {
            this.serviceConn2ServiceConn.put(serviceConnection, new InterfaceC6128g.AbstractBinderC6129a() { // from class: com.bytedance.pangle.service.client.ServiceManagerNative.1
                @Override // com.bytedance.pangle.InterfaceC6128g
                /* renamed from: a */
                public final void mo36943a(ComponentName componentName, IBinder iBinder) {
                    serviceConnection.onServiceConnected(componentName, iBinder);
                }

                @Override // com.bytedance.pangle.InterfaceC6128g
                /* renamed from: a */
                public final int mo36944a() {
                    return serviceConnection.hashCode();
                }
            });
        }
        if (this.conn2Service.get(serviceConnection) == null) {
            this.conn2Service.put(serviceConnection, new HashSet<>());
        }
        this.conn2Service.get(serviceConnection).add(queryServiceFromPlugin);
        InterfaceC6091e m36963a = C6219b.m36963a(queryServiceFromPlugin.processName);
        IBinder asBinder = m36963a.asBinder();
        HashMap<ServiceConnection, HashSet<ComponentName>> hashMap = this.process2ConnAndService.get(asBinder);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.process2ConnAndService.put(asBinder, hashMap);
        }
        HashSet<ComponentName> hashSet = hashMap.get(serviceConnection);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            hashMap.put(serviceConnection, hashSet);
        }
        hashSet.add(intent.getComponent());
        try {
            return m36963a.mo36959a(intent, this.serviceConn2ServiceConn.get(serviceConnection), i, str);
        } catch (RemoteException e) {
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed!", e);
            return false;
        }
    }

    public ServiceInfo queryServiceFromPlugin(Intent intent, String str) {
        Zeus.loadPlugin(str);
        ComponentName component = intent.getComponent();
        if (component == null) {
            return null;
        }
        return PluginManager.getInstance().getPlugin(str).pluginServices.get(component.getClassName());
    }

    public ComponentName startServiceNative(Context context, Intent intent, String str) {
        ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (queryServiceFromPlugin == null) {
            return context.startService(intent);
        }
        try {
            return C6219b.m36963a(queryServiceFromPlugin.processName).mo36957a(intent, str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean stopServiceNative(Context context, Intent intent, String str) {
        ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (queryServiceFromPlugin == null) {
            return context.stopService(intent);
        }
        try {
            return C6219b.m36963a(queryServiceFromPlugin.processName).mo36950b(intent, str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void unbindServiceNative(ServiceConnection serviceConnection) {
        HashSet<ServiceInfo> hashSet = this.conn2Service.get(serviceConnection);
        if (hashSet != null) {
            Iterator<ServiceInfo> it = hashSet.iterator();
            while (it.hasNext()) {
                try {
                    C6219b.m36963a(it.next().processName).mo36956a(this.serviceConn2ServiceConn.get(serviceConnection));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
