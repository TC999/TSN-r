package com.kwad.components.core.p301l;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.p301l.p302a.InterfaceC8689a;
import com.kwad.sdk.mvp.AbstractC10868a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.core.l.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8688a extends AbstractC10868a {

    /* renamed from: Ms */
    public List<InterfaceC8689a> f28358Ms = new ArrayList();
    @NonNull

    /* renamed from: Mt */
    private final AbstractC8691b<?> f28359Mt;
    @NonNull
    public final Context mContext;
    @NonNull
    public final View mRootView;

    public C8688a(AbstractC8691b<?> abstractC8691b) {
        this.f28359Mt = abstractC8691b;
        this.mContext = abstractC8691b.mContext;
        this.mRootView = abstractC8691b.mRootView;
    }

    @Deprecated
    public final Activity getActivity() {
        return this.f28359Mt.getActivity();
    }

    /* renamed from: hp */
    public final void m30013hp() {
        this.f28359Mt.finish();
    }

    @Override // com.kwad.sdk.mvp.AbstractC10868a
    public void release() {
        this.f28358Ms.clear();
    }
}
