package com.kwad.components.offline.api.p341tk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.p341tk.model.StyleTemplate;
import org.json.JSONObject;

/* renamed from: com.kwad.components.offline.api.tk.ITkOfflineCompo */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface ITkOfflineCompo extends IOfflineCompo<ITkOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.tachikoma.TkOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.tachikoma";

    /* renamed from: com.kwad.components.offline.api.tk.ITkOfflineCompo$TKState */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum TKState {
        READY,
        SO_FAIL
    }

    StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i);

    IOfflineCompoTachikomaContext getContext(Context context, String str, int i, int i2, boolean z);

    String getJsBaseDir(Context context, String str);

    TKState getState();

    String getTKVersion();

    void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i, TKDownloadListener tKDownloadListener);

    void onConfigRefresh(Context context, @NonNull JSONObject jSONObject);

    void onDestroy();
}
