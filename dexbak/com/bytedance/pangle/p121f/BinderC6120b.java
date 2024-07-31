package com.bytedance.pangle.p121f;

import com.bytedance.pangle.InterfaceC6075d;
import com.bytedance.pangle.ZeusPluginInstallListener;

/* renamed from: com.bytedance.pangle.f.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class BinderC6120b extends InterfaceC6075d.AbstractBinderC6076a {

    /* renamed from: a */
    private final ZeusPluginInstallListener f22007a;

    public BinderC6120b(ZeusPluginInstallListener zeusPluginInstallListener) {
        this.f22007a = zeusPluginInstallListener;
    }

    @Override // com.bytedance.pangle.InterfaceC6075d
    /* renamed from: a */
    public final void mo37145a(String str, int i, String str2) {
        ZeusPluginInstallListener zeusPluginInstallListener = this.f22007a;
        if (zeusPluginInstallListener != null) {
            zeusPluginInstallListener.onPluginInstall(str, i, str2);
        }
    }
}
