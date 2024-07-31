package com.kwad.components.core.page.recycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.proxy.C8888e;
import com.kwad.sdk.C9659R;

/* renamed from: com.kwad.components.core.page.recycle.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8845a extends C8888e {

    /* renamed from: Po */
    private RecyclerView f28649Po;

    /* renamed from: Pp */
    private AbstractC8849d f28650Pp;

    /* renamed from: pJ */
    private void m29753pJ() {
        RecyclerView recyclerView = (RecyclerView) findViewById(m29749pN());
        this.f28649Po = recyclerView;
        recyclerView.setItemAnimator(null);
        this.f28649Po.setLayoutManager(m29750pM());
        this.f28650Pp = mo29754a(this.f28649Po);
    }

    /* renamed from: pK */
    private void m29752pK() {
        this.f28649Po.setAdapter(this.f28650Pp);
    }

    /* renamed from: pM */
    private RecyclerView.LayoutManager m29750pM() {
        return new LinearLayoutManager(this.mContext);
    }

    /* renamed from: pN */
    private static int m29749pN() {
        return C9659R.C9662id.ksad_recycler_view;
    }

    /* renamed from: a */
    protected abstract AbstractC8849d mo29754a(RecyclerView recyclerView);

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.kwad.components.core.proxy.C8888e, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        this.f28649Po.clearOnChildAttachStateChangeListeners();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        m29753pJ();
        m29752pK();
    }

    /* renamed from: pL */
    public final RecyclerView m29751pL() {
        return this.f28649Po;
    }
}
