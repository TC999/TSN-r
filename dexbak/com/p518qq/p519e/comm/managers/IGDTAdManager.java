package com.p518qq.p519e.comm.managers;

import com.p518qq.p519e.ads.dfa.GDTAppDialogClickListener;
import com.p518qq.p519e.comm.managers.devtool.DevTools;
import java.util.Map;

/* renamed from: com.qq.e.comm.managers.IGDTAdManager */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface IGDTAdManager {
    String getBuyerId(Map<String, Object> map);

    DevTools getDevTools();

    String getSDKInfo(String str);

    int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener);
}
