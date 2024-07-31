package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.internal.C2640by;
import com.umeng.analytics.pro.UMCommonContent;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.bn */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2628bn {

    /* renamed from: a */
    public static final String f8699a = "ContainerFactoryBuilder";

    /* renamed from: e */
    private static IXAdContainerFactory f8700e;

    /* renamed from: c */
    private Context f8702c;

    /* renamed from: d */
    private Class<?> f8703d;

    /* renamed from: b */
    public double f8701b = 0.1d;

    /* renamed from: f */
    private C2634bs f8704f = C2634bs.m50744a();

    public C2628bn(Class<?> cls, Context context) {
        this.f8703d = null;
        this.f8703d = cls;
        this.f8702c = context;
    }

    /* renamed from: a */
    public IXAdContainerFactory m50780a() {
        if (f8700e == null) {
            try {
                f8700e = (IXAdContainerFactory) this.f8703d.getDeclaredConstructor(Context.class).newInstance(this.f8702c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(UMCommonContent.f37830bg, "9.332");
                f8700e.initConfig(jSONObject);
                this.f8701b = f8700e.getRemoteVersion();
                f8700e.onTaskDistribute(C2613ba.f8640a, MobadsPermissionSettings.getPermissionInfo());
                f8700e.initCommonModuleObj(C2721r.m50346a());
            } catch (Throwable th) {
                this.f8704f.m50732b(f8699a, th.getMessage());
                throw new C2640by.C2641a("ContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return f8700e;
    }

    /* renamed from: b */
    public void m50779b() {
        f8700e = null;
    }
}
