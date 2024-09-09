package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {

    /* renamed from: d  reason: collision with root package name */
    private static c f28889d;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f28890a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<PluginBroadcastReceiver, BroadcastReceiver> f28891b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Set<Integer> f28892c = new CopyOnWriteArraySet();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f28893a;

        /* renamed from: b  reason: collision with root package name */
        public final Set<PluginBroadcastReceiver> f28894b = new CopyOnWriteArraySet();

        public final void a(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                this.f28894b.add(pluginBroadcastReceiver);
            }
        }

        public final void a(Context context, Intent intent) {
            Set<PluginBroadcastReceiver> set = this.f28894b;
            if (set == null || set.size() <= 0) {
                return;
            }
            for (PluginBroadcastReceiver pluginBroadcastReceiver : this.f28894b) {
                if (pluginBroadcastReceiver != null) {
                    try {
                        pluginBroadcastReceiver.onReceive(context, intent);
                    } catch (Throwable th) {
                        String action = intent != null ? intent.getAction() : "";
                        ZeusLogger.w("Zeus/receiver_pangle", "plugin-receiver->action:" + action + "[exception]:", th);
                    }
                }
            }
        }
    }

    private c() {
    }

    public static c a() {
        if (f28889d == null) {
            synchronized (com.bytedance.pangle.service.a.a.class) {
                if (f28889d == null) {
                    f28889d = new c();
                }
            }
        }
        return f28889d;
    }

    public final void a(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return;
        }
        Iterator<String> actionsIterator = intentFilter.actionsIterator();
        while (actionsIterator.hasNext()) {
            String next = actionsIterator.next();
            if (next != null) {
                a aVar = this.f28890a.get(next);
                if (aVar != null) {
                    aVar.a(pluginBroadcastReceiver);
                } else {
                    a aVar2 = new a();
                    aVar2.f28893a = next;
                    aVar2.a(pluginBroadcastReceiver);
                    this.f28890a.put(next, aVar2);
                }
            }
        }
    }

    public final void a(Context context, Intent intent) {
        a value;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        Map<String, a> map = this.f28890a;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, a> entry : this.f28890a.entrySet()) {
            if (action.equals(entry.getKey()) && (value = entry.getValue()) != null) {
                value.a(context, intent);
            }
        }
    }
}
