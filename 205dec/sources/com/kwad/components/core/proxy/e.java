package com.kwad.components.core.proxy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class e extends KsFragment implements com.kwad.sdk.m.a.b {
    protected ViewGroup QU;
    protected ViewGroup lD;
    private final com.kwad.sdk.m.a.a mBackPressDelete = new com.kwad.sdk.m.a.a();
    protected Context mContext;

    public final <T extends View> T findViewById(int i4) {
        ViewGroup viewGroup = this.lD;
        if (viewGroup != null) {
            return (T) viewGroup.findViewById(i4);
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    protected ViewGroup lN() {
        return null;
    }

    public boolean onBackPressed() {
        return this.mBackPressDelete.onBackPressed();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
            this.mContext = l.wrapContextIfNeed(getActivity());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        this.QU = viewGroup;
        if (this.lD == null) {
            ViewGroup lN = lN();
            this.lD = lN;
            if (lN == null && pc() != 0) {
                this.lD = (ViewGroup) from.inflate(pc(), viewGroup, false);
            }
        }
        return this.lD;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (getHost() != null) {
            com.kwad.components.core.s.g.destroyFragment(this.mContext, getView());
        }
    }

    protected int pc() {
        return 0;
    }
}
