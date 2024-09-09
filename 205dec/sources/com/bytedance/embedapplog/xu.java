package com.bytedance.embedapplog;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xu implements IDataObserver {

    /* renamed from: c  reason: collision with root package name */
    private static volatile xu f26841c;

    /* renamed from: w  reason: collision with root package name */
    private final CopyOnWriteArraySet<IDataObserver> f26842w = new CopyOnWriteArraySet<>();

    private xu() {
    }

    public static xu c() {
        if (f26841c == null) {
            synchronized (xu.class) {
                if (f26841c == null) {
                    f26841c = new xu();
                }
            }
        }
        return f26841c;
    }

    @Override // com.bytedance.embedapplog.IDataObserver
    public void onIdLoaded(String str, String str2, String str3) {
        Iterator<IDataObserver> it = this.f26842w.iterator();
        while (it.hasNext()) {
            it.next().onIdLoaded(str, str2, str3);
        }
    }

    @Override // com.bytedance.embedapplog.IDataObserver
    public void onRemoteAbConfigGet(boolean z3, JSONObject jSONObject) {
        Iterator<IDataObserver> it = this.f26842w.iterator();
        while (it.hasNext()) {
            it.next().onRemoteAbConfigGet(z3, jSONObject);
        }
    }

    @Override // com.bytedance.embedapplog.IDataObserver
    public void onRemoteConfigGet(boolean z3, JSONObject jSONObject) {
        Iterator<IDataObserver> it = this.f26842w.iterator();
        while (it.hasNext()) {
            it.next().onRemoteConfigGet(z3, jSONObject);
        }
    }

    @Override // com.bytedance.embedapplog.IDataObserver
    public void onRemoteIdGet(boolean z3, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<IDataObserver> it = this.f26842w.iterator();
        while (it.hasNext()) {
            it.next().onRemoteIdGet(z3, str, str2, str3, str4, str5, str6);
        }
    }
}
