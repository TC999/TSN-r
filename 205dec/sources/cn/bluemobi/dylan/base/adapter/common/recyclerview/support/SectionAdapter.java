package cn.bluemobi.dylan.base.adapter.common.recyclerview.support;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class SectionAdapter<T> extends MultiItemCommonAdapter<T> {

    /* renamed from: l  reason: collision with root package name */
    private static final int f1728l = 0;

    /* renamed from: h  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.recyclerview.support.a f1729h;

    /* renamed from: i  reason: collision with root package name */
    private LinkedHashMap<String, Integer> f1730i;

    /* renamed from: j  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.recyclerview.a<T> f1731j;

    /* renamed from: k  reason: collision with root package name */
    final RecyclerView.AdapterDataObserver f1732k;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class a extends RecyclerView.AdapterDataObserver {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            SectionAdapter.this.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.a<T> {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int a(int i4, T t3) {
            SectionAdapter.this.q(i4);
            return !SectionAdapter.this.f1730i.values().contains(Integer.valueOf(i4));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int b(int i4) {
            return i4 == 0 ? SectionAdapter.this.f1729h.a() : ((CommonAdapter) SectionAdapter.this).f1708b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements cn.bluemobi.dylan.base.adapter.common.recyclerview.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ cn.bluemobi.dylan.base.adapter.common.recyclerview.a f1735a;

        c(cn.bluemobi.dylan.base.adapter.common.recyclerview.a aVar) {
            this.f1735a = aVar;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int a(int i4, T t3) {
            int q3 = SectionAdapter.this.q(i4);
            if (SectionAdapter.this.f1730i.values().contains(Integer.valueOf(i4))) {
                return 0;
            }
            return this.f1735a.a(q3, t3);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int b(int i4) {
            if (i4 == 0) {
                return SectionAdapter.this.f1729h.a();
            }
            return this.f1735a.b(i4);
        }
    }

    public SectionAdapter(Context context, int i4, List<T> list, cn.bluemobi.dylan.base.adapter.common.recyclerview.support.a aVar) {
        this(context, i4, null, list, aVar);
    }

    private void r(int i4, cn.bluemobi.dylan.base.adapter.common.recyclerview.a aVar) {
        if (i4 != -1) {
            this.f1731j = new b();
        } else if (aVar != null) {
            this.f1731j = new c(aVar);
        } else {
            throw new RuntimeException("layoutId or MultiItemTypeSupport must set one.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    public int e(RecyclerView.ViewHolder viewHolder) {
        return q(viewHolder.getAdapterPosition());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    public boolean f(int i4) {
        if (i4 == 0) {
            return false;
        }
        return super.f(i4);
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return super.getItemCount() + this.f1730i.size();
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        return this.f1727g.a(i4, null);
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onBindViewHolder(ViewHolder viewHolder, int i4) {
        int q3 = q(i4);
        if (viewHolder.getItemViewType() == 0) {
            viewHolder.J(this.f1729h.c(), this.f1729h.b(this.f1709c.get(q3)));
        } else {
            super.onBindViewHolder(viewHolder, q3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        unregisterAdapterDataObserver(this.f1732k);
    }

    public void p() {
        int size = this.f1709c.size();
        this.f1730i.clear();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            String b4 = this.f1729h.b(this.f1709c.get(i5));
            if (!this.f1730i.containsKey(b4)) {
                this.f1730i.put(b4, Integer.valueOf(i5 + i4));
                i4++;
            }
        }
    }

    public int q(int i4) {
        int i5 = 0;
        for (Map.Entry<String, Integer> entry : this.f1730i.entrySet()) {
            if (entry.getValue().intValue() < i4) {
                i5++;
            }
        }
        return i4 - i5;
    }

    public SectionAdapter(Context context, cn.bluemobi.dylan.base.adapter.common.recyclerview.a aVar, List<T> list, cn.bluemobi.dylan.base.adapter.common.recyclerview.support.a aVar2) {
        this(context, -1, aVar, list, aVar2);
    }

    public SectionAdapter(Context context, int i4, cn.bluemobi.dylan.base.adapter.common.recyclerview.a aVar, List<T> list, cn.bluemobi.dylan.base.adapter.common.recyclerview.support.a aVar2) {
        super(context, list, null);
        a aVar3 = new a();
        this.f1732k = aVar3;
        this.f1708b = i4;
        r(i4, aVar);
        this.f1727g = this.f1731j;
        this.f1729h = aVar2;
        this.f1730i = new LinkedHashMap<>();
        p();
        registerAdapterDataObserver(aVar3);
    }
}
