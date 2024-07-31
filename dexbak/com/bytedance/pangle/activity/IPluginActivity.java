package com.bytedance.pangle.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.bytedance.pangle.plugin.Plugin;

@Keep
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface IPluginActivity {
    void _requestPermissions(String[] strArr, int i);

    void attachBaseContext(Context context);

    String getPluginPkgName();

    void onCreate(Bundle bundle);

    void setPluginProxyActivity(InterfaceC6062b interfaceC6062b, Plugin plugin);

    void setProxyTheme2Plugin(int i);
}
