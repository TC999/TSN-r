package com.kwad.components.core.l;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a extends com.kwad.sdk.mvp.a {
    public List<com.kwad.components.core.l.a.a> Ms = new ArrayList();
    @NonNull
    private final b<?> Mt;
    @NonNull
    public final Context mContext;
    @NonNull
    public final View mRootView;

    public a(b<?> bVar) {
        this.Mt = bVar;
        this.mContext = bVar.mContext;
        this.mRootView = bVar.mRootView;
    }

    @Deprecated
    public final Activity getActivity() {
        return this.Mt.getActivity();
    }

    public final void hp() {
        this.Mt.finish();
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.Ms.clear();
    }
}
