package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.e;
import com.baidu.mobads.sdk.internal.s;
import dalvik.system.DexClassLoader;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@Route(path = "remote_adserv")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AdservRemoteLoaderImpl implements s {
    @Override // com.baidu.mobads.sdk.internal.s
    public void startLoadRemotePhp(double d4, an.b bVar) {
        e.a().a(d4, bVar);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public DexClassLoader getClassLoaderFromJar(String str, String str2, String str3, ClassLoader classLoader) {
        return e.a().a(str, str2, str3, classLoader);
    }
}
