package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.internal.cb;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class bq {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12518a = "ContainerFactoryBuilder";

    /* renamed from: e  reason: collision with root package name */
    private static IXAdContainerFactory f12519e;

    /* renamed from: c  reason: collision with root package name */
    private Context f12521c;

    /* renamed from: d  reason: collision with root package name */
    private Class<?> f12522d;

    /* renamed from: b  reason: collision with root package name */
    public double f12520b = 0.1d;

    /* renamed from: f  reason: collision with root package name */
    private bv f12523f = bv.a();

    public bq(Class<?> cls, Context context) {
        this.f12522d = null;
        this.f12522d = cls;
        this.f12521c = context;
    }

    public IXAdContainerFactory a() {
        if (f12519e == null) {
            try {
                f12519e = (IXAdContainerFactory) this.f12522d.getDeclaredConstructor(Context.class).newInstance(this.f12521c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("p_ver", "9.35");
                f12519e.initConfig(jSONObject);
                this.f12520b = f12519e.getRemoteVersion();
                f12519e.onTaskDistribute("permission_module", MobadsPermissionSettings.getPermissionInfo());
                f12519e.initCommonModuleObj(r.a());
            } catch (Throwable th) {
                this.f12523f.b("ContainerFactoryBuilder", th.getMessage());
                throw new cb.a("ContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return f12519e;
    }

    public void b() {
        f12519e = null;
    }
}
