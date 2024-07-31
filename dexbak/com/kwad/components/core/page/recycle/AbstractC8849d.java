package com.kwad.components.core.page.recycle;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.core.page.recycle.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8849d extends RecyclerView.Adapter<C8848c> {

    /* renamed from: PT */
    private List<Presenter> f28660PT = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public C8848c onCreateViewHolder(ViewGroup viewGroup, int i) {
        C8848c mo29742b = mo29742b(viewGroup, i);
        this.f28660PT.add(mo29742b.mPresenter);
        return mo29742b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C8848c c8848c, int i) {
        c8848c.mPresenter.m24605k(c8848c.f28659Of);
    }

    /* renamed from: b */
    protected abstract C8848c mo29742b(ViewGroup viewGroup, int i);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        m29740pT();
    }

    /* renamed from: pT */
    public final void m29740pT() {
        for (Presenter presenter : this.f28660PT) {
            presenter.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewRecycled(C8848c c8848c) {
        super.onViewRecycled(c8848c);
        c8848c.mPresenter.m24604lW();
    }
}
