package com.kwad.components.offline.api.p341tk;

import android.app.Activity;
import android.view.View;

/* renamed from: com.kwad.components.offline.api.tk.IOfflineTKView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IOfflineTKView {
    void bindActivity(Activity activity);

    Object callJSFunc(String str, String str2, IOfflineTKFunction iOfflineTKFunction);

    View getView();

    boolean onBackPressed();

    void render();

    void setData(Object... objArr);
}
