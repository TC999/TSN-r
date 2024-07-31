package com.bytedance.pangle.p121f;

import android.os.RemoteException;
import com.bytedance.pangle.InterfaceC6075d;
import com.bytedance.pangle.ZeusPluginStateListener;

/* renamed from: com.bytedance.pangle.f.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6121c extends ZeusPluginStateListener {

    /* renamed from: a */
    final int f22008a;

    /* renamed from: b */
    private final InterfaceC6075d f22009b;

    public C6121c(InterfaceC6075d interfaceC6075d, int i) {
        this.f22009b = interfaceC6075d;
        this.f22008a = i;
    }

    @Override // com.bytedance.pangle.ZeusPluginStateListener
    public final void onStateChangeOnCurThread(String str, int i, Object... objArr) {
        if (i == 5 || i == 7 || i == 6) {
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
            this.f22009b.mo37145a(str, i, str2);
        }
    }
}
