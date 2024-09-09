package com.qq.e.comm.plugin.q;

import com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle;
import com.qq.e.comm.plugin.g0.y;
import com.qq.e.comm.plugin.util.d1;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements IDynamicScriptLifecycle {

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.dynamic.b f45357a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.n0.c f45358b;

    private a(com.qq.e.comm.dynamic.b bVar, com.qq.e.comm.plugin.g0.e eVar, y yVar) {
        this.f45357a = bVar;
        this.f45358b = com.qq.e.comm.plugin.n0.c.a(eVar, yVar);
    }

    private Object a(String str) {
        com.qq.e.comm.dynamic.b bVar = this.f45357a;
        if (bVar != null) {
            try {
                return bVar.b(str);
            } catch (Throwable th) {
                d1.a("DynamicScript-LifeCycle", "safeEvaluate script error", th);
                i.a(str, this.f45358b, th);
                return null;
            }
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle
    public void onAppBackground() {
        h.b().a("GDTLifeCycle", "onAppBackground", new Object[0]).d().a("event_onAppBackground", new Object[0]).c().a(this.f45357a, this.f45358b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle
    public void onAppForeground() {
        h.b().a("GDTLifeCycle", "onAppForeground", new Object[0]).d().a("event_onAppForeground", new Object[0]).c().a(this.f45357a, this.f45358b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle
    public void onBindData(JSONObject jSONObject) {
        a(e.a("GDTLifeCycle.onBindData", jSONObject));
    }

    @Override // com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle
    public void onViewCreate() {
        h.b().a("GDTLifeCycle", "onViewCreate", new Object[0]).d().a("event_onViewCreate", new Object[0]).c().a(this.f45357a, this.f45358b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle
    public void onViewDestroy() {
        h.b().a("GDTLifeCycle", "onViewDestroy", new Object[0]).d().a("event_onViewDestroy", new Object[0]).c().a(this.f45357a, this.f45358b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle
    public void onStartAnimation(String str) {
        a(e.a("GDTLifeCycle.onStartAnimation", str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(com.qq.e.comm.dynamic.b bVar, com.qq.e.comm.plugin.g0.e eVar, y yVar) {
        if (bVar != null) {
            try {
                Object b4 = bVar.b("(typeof(GDTLifeCycle)=='undefined' || GDTLifeCycle== null)&&(typeof(GDTEventBus)=='undefined' || GDTEventBus== null)");
                if (b4 != null && !((Boolean) b4).booleanValue()) {
                    return new a(bVar, eVar, yVar);
                }
                return null;
            } catch (Throwable th) {
                d1.a("DynamicScript-LifeCycle", "safeEvaluate script error", th);
                i.a("typeof(GDTLifeCycle)=='undefined' || GDTLifeCycle== null", com.qq.e.comm.plugin.n0.c.a(eVar, yVar), th);
            }
        }
        return null;
    }
}
