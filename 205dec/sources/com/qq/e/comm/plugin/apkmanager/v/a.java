package com.qq.e.comm.plugin.apkmanager.v;

import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.d0.e.d;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements b {
    @Override // com.qq.e.comm.plugin.apkmanager.v.b
    public boolean a(ApkDownloadTask apkDownloadTask) {
        return System.currentTimeMillis() - apkDownloadTask.e() > 259200000;
    }

    @Override // com.qq.e.comm.plugin.apkmanager.v.b
    public boolean b(ApkDownloadTask apkDownloadTask) {
        return com.qq.e.comm.plugin.d0.a.d().c().n() == d.WIFI;
    }
}
