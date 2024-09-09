package com.bytedance.pangle.f;

import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.d;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b extends d.a {

    /* renamed from: a  reason: collision with root package name */
    private final ZeusPluginInstallListener f28768a;

    public b(ZeusPluginInstallListener zeusPluginInstallListener) {
        this.f28768a = zeusPluginInstallListener;
    }

    @Override // com.bytedance.pangle.d
    public final void a(String str, int i4, String str2) {
        ZeusPluginInstallListener zeusPluginInstallListener = this.f28768a;
        if (zeusPluginInstallListener != null) {
            zeusPluginInstallListener.onPluginInstall(str, i4, str2);
        }
    }
}
