package com.kwad.components.offline.api.p341tk;

import android.content.Context;
import com.kwad.components.offline.api.IOfflineCompoInitConfig;
import com.kwad.components.offline.api.core.soloader.ISoLoader;

/* renamed from: com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface ITkOfflineCompoInitConfig extends IOfflineCompoInitConfig {
    String getSpKeyTkSoLoadTimes();

    String getSpNameSoLoadTimes();

    String getTkJsFileDir(Context context, String str);

    String getTkJsRootDir(Context context);

    String getTkVersion();

    boolean isLocalDebugEnable();

    ISoLoader soLoader();

    boolean useTkLite();

    boolean useTkSoAll();
}
