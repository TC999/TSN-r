package com.kwad.components.offline.p343c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.p304n.p305a.p309d.InterfaceC8701c;
import com.kwad.components.offline.api.p341tk.IOfflineCompoTachikomaContext;
import com.kwad.components.offline.api.p341tk.ITkOfflineCompo;
import com.kwad.components.offline.api.p341tk.TKDownloadListener;
import com.kwad.components.offline.api.p341tk.model.StyleTemplate;
import com.kwad.components.offline.p343c.p344a.C9413i;
import com.kwad.sdk.components.InterfaceC9876q;
import org.json.JSONObject;

/* renamed from: com.kwad.components.offline.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9415b implements InterfaceC8701c {
    private final ITkOfflineCompo acS;

    public C9415b(@NonNull ITkOfflineCompo iTkOfflineCompo) {
        this.acS = iTkOfflineCompo;
    }

    @Override // com.kwad.components.core.p304n.p305a.p309d.InterfaceC8701c
    /* renamed from: a */
    public final InterfaceC9876q mo28841a(Context context, String str, int i, int i2, boolean z) {
        IOfflineCompoTachikomaContext context2 = this.acS.getContext(context, str, i, i2, z);
        if (context2 == null) {
            return null;
        }
        return new C9413i(context2);
    }

    @Override // com.kwad.components.core.p304n.p305a.p309d.InterfaceC8701c
    public final StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i) {
        return this.acS.checkStyleTemplateById(context, str, str2, str3, i);
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final Class<C9415b> getComponentsType() {
        return C9415b.class;
    }

    @Override // com.kwad.components.core.p304n.p305a.p309d.InterfaceC8701c
    public final String getJsBaseDir(Context context, String str) {
        return this.acS.getJsBaseDir(context, str);
    }

    @Override // com.kwad.components.core.p304n.p305a.p309d.InterfaceC8701c
    public final ITkOfflineCompo.TKState getState() {
        return this.acS.getState();
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.core.p304n.p305a.p309d.InterfaceC8701c
    public final void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i, TKDownloadListener tKDownloadListener) {
        this.acS.loadTkFileByTemplateId(context, str, str2, str3, i, tKDownloadListener);
    }

    public final void onConfigRefresh(Context context, @NonNull JSONObject jSONObject) {
        this.acS.onConfigRefresh(context, jSONObject);
    }

    @Override // com.kwad.components.core.p304n.p305a.p309d.InterfaceC8701c
    public final void onDestroy() {
        this.acS.onDestroy();
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final int priority() {
        return this.acS.priority();
    }
}
