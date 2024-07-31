package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.service.p125a.BinderC6224a;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.bytedance.pangle.receiver.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6197c {

    /* renamed from: d */
    private static C6197c f22128d;

    /* renamed from: a */
    public final Map<String, C6198a> f22129a = new ConcurrentHashMap();

    /* renamed from: b */
    public final Map<PluginBroadcastReceiver, BroadcastReceiver> f22130b = new ConcurrentHashMap();

    /* renamed from: c */
    public final Set<Integer> f22131c = new CopyOnWriteArraySet();

    /* renamed from: com.bytedance.pangle.receiver.c$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6198a {

        /* renamed from: a */
        public String f22132a;

        /* renamed from: b */
        public final Set<PluginBroadcastReceiver> f22133b = new CopyOnWriteArraySet();

        /* renamed from: a */
        public final void m37013a(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                this.f22133b.add(pluginBroadcastReceiver);
            }
        }

        /* renamed from: a */
        public final void m37014a(Context context, Intent intent) {
            Set<PluginBroadcastReceiver> set = this.f22133b;
            if (set == null || set.size() <= 0) {
                return;
            }
            for (PluginBroadcastReceiver pluginBroadcastReceiver : this.f22133b) {
                if (pluginBroadcastReceiver != null) {
                    try {
                        pluginBroadcastReceiver.onReceive(context, intent);
                    } catch (Throwable th) {
                        String action = intent != null ? intent.getAction() : "";
                        ZeusLogger.m37076w(ZeusLogger.TAG_RECEIVER, "plugin-receiver->action:" + action + "[exception]:", th);
                    }
                }
            }
        }
    }

    private C6197c() {
    }

    /* renamed from: a */
    public static C6197c m37017a() {
        if (f22128d == null) {
            synchronized (BinderC6224a.class) {
                if (f22128d == null) {
                    f22128d = new C6197c();
                }
            }
        }
        return f22128d;
    }

    /* renamed from: a */
    public final void m37015a(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return;
        }
        Iterator<String> actionsIterator = intentFilter.actionsIterator();
        while (actionsIterator.hasNext()) {
            String next = actionsIterator.next();
            if (next != null) {
                C6198a c6198a = this.f22129a.get(next);
                if (c6198a != null) {
                    c6198a.m37013a(pluginBroadcastReceiver);
                } else {
                    C6198a c6198a2 = new C6198a();
                    c6198a2.f22132a = next;
                    c6198a2.m37013a(pluginBroadcastReceiver);
                    this.f22129a.put(next, c6198a2);
                }
            }
        }
    }

    /* renamed from: a */
    public final void m37016a(Context context, Intent intent) {
        C6198a value;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        Map<String, C6198a> map = this.f22129a;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, C6198a> entry : this.f22129a.entrySet()) {
            if (action.equals(entry.getKey()) && (value = entry.getValue()) != null) {
                value.m37014a(context, intent);
            }
        }
    }
}
