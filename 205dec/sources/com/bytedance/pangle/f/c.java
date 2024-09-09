package com.bytedance.pangle.f;

import android.os.RemoteException;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.d;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c extends ZeusPluginStateListener {

    /* renamed from: a  reason: collision with root package name */
    final int f28769a;

    /* renamed from: b  reason: collision with root package name */
    private final d f28770b;

    public c(d dVar, int i4) {
        this.f28770b = dVar;
        this.f28769a = i4;
    }

    @Override // com.bytedance.pangle.ZeusPluginStateListener
    public final void onStateChangeOnCurThread(String str, int i4, Object... objArr) {
        if (i4 == 5 || i4 == 7 || i4 == 6) {
            String str2 = "";
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        str2 = String.valueOf(objArr[0]);
                    }
                } catch (RemoteException unused) {
                    return;
                }
            }
            this.f28770b.a(str, i4, str2);
        }
    }
}
