package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.C2594an;
import com.baidu.mobads.sdk.internal.C2645c;
import com.baidu.mobads.sdk.internal.C2704e;
import com.baidu.mobads.sdk.internal.InterfaceC2722s;
import dalvik.system.DexClassLoader;

@Route(path = C2645c.InterfaceC2646a.f8795a)
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdservRemoteLoaderImpl implements InterfaceC2722s {
    @Override // com.baidu.mobads.sdk.internal.InterfaceC2722s
    public void startLoadRemotePhp(double d, C2594an.InterfaceC2596b interfaceC2596b) {
        C2704e.m50418a().m50417a(d, interfaceC2596b);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2722s
    public DexClassLoader getClassLoaderFromJar(String str, String str2, String str3, ClassLoader classLoader) {
        return C2704e.m50418a().m50415a(str, str2, str3, classLoader);
    }
}
