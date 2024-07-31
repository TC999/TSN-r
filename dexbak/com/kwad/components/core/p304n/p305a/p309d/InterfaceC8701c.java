package com.kwad.components.core.p304n.p305a.p309d;

import android.content.Context;
import com.kwad.components.offline.api.p341tk.ITkOfflineCompo;
import com.kwad.components.offline.api.p341tk.TKDownloadListener;
import com.kwad.components.offline.api.p341tk.model.StyleTemplate;
import com.kwad.sdk.components.InterfaceC9848a;
import com.kwad.sdk.components.InterfaceC9876q;

/* renamed from: com.kwad.components.core.n.a.d.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC8701c extends InterfaceC9848a {
    /* renamed from: a */
    InterfaceC9876q mo28841a(Context context, String str, int i, int i2, boolean z);

    StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i);

    String getJsBaseDir(Context context, String str);

    ITkOfflineCompo.TKState getState();

    void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i, TKDownloadListener tKDownloadListener);

    void onDestroy();
}
