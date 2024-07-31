package com.bytedance.pangle.activity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.pangle.plugin.Plugin;

/* renamed from: com.bytedance.pangle.activity.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface InterfaceC6062b {
    void finish();

    Application getApplication();

    Context getBaseContext();

    Intent getIntent();

    Plugin getPlugin();

    String getPluginPkgName();

    void setPlugin(Plugin plugin);

    void setTargetActivity(IPluginActivity iPluginActivity);

    void zeusSuperAttachBaseContext(Context context);

    void zeusSuperOnCreate(Bundle bundle);

    void zeusSuperSetTheme(int i);
}
