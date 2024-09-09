package com.kwad.components.offline.api.tk;

import android.app.Activity;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IOfflineTKView {
    void bindActivity(Activity activity);

    Object callJSFunc(String str, String str2, IOfflineTKFunction iOfflineTKFunction);

    View getView();

    boolean onBackPressed();

    void render();

    void setData(Object... objArr);
}
