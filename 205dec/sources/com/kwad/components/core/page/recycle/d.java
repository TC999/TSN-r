package com.kwad.components.core.page.recycle;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class d extends RecyclerView.Adapter<c> {
    private List<Presenter> PT = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public c onCreateViewHolder(ViewGroup viewGroup, int i4) {
        c b4 = b(viewGroup, i4);
        this.PT.add(b4.mPresenter);
        return b4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(c cVar, int i4) {
        cVar.mPresenter.k(cVar.Of);
    }

    protected abstract c b(ViewGroup viewGroup, int i4);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        pT();
    }

    public final void pT() {
        for (Presenter presenter : this.PT) {
            presenter.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewRecycled(c cVar) {
        super.onViewRecycled(cVar);
        cVar.mPresenter.lW();
    }
}
