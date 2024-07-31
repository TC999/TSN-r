package com.kwad.components.core.proxy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p330s.C8942g;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.p443m.p444a.C10860a;
import com.kwad.sdk.p443m.p444a.InterfaceC10861b;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.components.core.proxy.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8888e extends KsFragment implements InterfaceC10861b {

    /* renamed from: QU */
    protected ViewGroup f28747QU;

    /* renamed from: lD */
    protected ViewGroup f28748lD;
    private final C10860a mBackPressDelete = new C10860a();
    protected Context mContext;

    public final <T extends View> T findViewById(int i) {
        ViewGroup viewGroup = this.f28748lD;
        if (viewGroup != null) {
            return (T) viewGroup.findViewById(i);
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    /* renamed from: lN */
    protected ViewGroup mo29672lN() {
        return null;
    }

    public boolean onBackPressed() {
        return this.mBackPressDelete.onBackPressed();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
            this.mContext = C10887l.wrapContextIfNeed(getActivity());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        this.f28747QU = viewGroup;
        if (this.f28748lD == null) {
            ViewGroup mo29672lN = mo29672lN();
            this.f28748lD = mo29672lN;
            if (mo29672lN == null && mo29671pc() != 0) {
                this.f28748lD = (ViewGroup) from.inflate(mo29671pc(), viewGroup, false);
            }
        }
        return this.f28748lD;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (getHost() != null) {
            C8942g.destroyFragment(this.mContext, getView());
        }
    }

    /* renamed from: pc */
    protected int mo29671pc() {
        return 0;
    }
}
