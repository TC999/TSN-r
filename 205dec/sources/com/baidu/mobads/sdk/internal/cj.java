package com.baidu.mobads.sdk.internal;

import android.content.SharedPreferences;
import android.os.Handler;
import com.baidu.mobads.sdk.internal.cb;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class cj extends i {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ cb.c f12625b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Handler f12626c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ cb f12627d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(cb cbVar, cb.c cVar, Handler handler) {
        this.f12627d = cbVar;
        this.f12625b = cVar;
        this.f12626c = handler;
    }

    @Override // com.baidu.mobads.sdk.internal.i
    protected Object i() {
        bv bvVar;
        SharedPreferences m4;
        try {
            synchronized (cb.class) {
                this.f12627d.b(this.f12625b, this.f12626c);
            }
            m4 = this.f12627d.m();
            SharedPreferences.Editor edit = m4.edit();
            edit.putString("previousProxyVersion", this.f12627d.a());
            edit.apply();
            return null;
        } catch (Throwable th) {
            bvVar = this.f12627d.f12613z;
            bvVar.a("ApkLoader", th);
            return null;
        }
    }
}
