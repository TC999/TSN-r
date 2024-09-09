package com.kwad.components.offline.api.core.api;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class IOfflineCompoWrapper {
    protected String mOfflinePackageName;

    public IOfflineCompoWrapper(String str) {
        this.mOfflinePackageName = str;
    }

    @Deprecated
    public abstract Context unwrapContextIfNeed(Context context);

    public abstract Context wrapContextIfNeed(@Nullable Context context);

    public abstract Application wrapGetApplication(Context context);

    public abstract LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater);
}
