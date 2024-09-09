package com.bytedance.pangle.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.bytedance.pangle.plugin.Plugin;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IPluginActivity {
    void _requestPermissions(String[] strArr, int i4);

    void attachBaseContext(Context context);

    String getPluginPkgName();

    void onCreate(Bundle bundle);

    void setPluginProxyActivity(b bVar, Plugin plugin);

    void setProxyTheme2Plugin(int i4);
}
