package cn.bluemobi.dylan.base.adapter.common.recyclerview.support;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class SectionAdapter<T> extends MultiItemCommonAdapter<T> {

    /* renamed from: l */
    private static final int f1742l = 0;

    /* renamed from: h */
    private SectionSupport f1743h;

    /* renamed from: i */
    private LinkedHashMap<String, Integer> f1744i;

    /* renamed from: j */
    private InterfaceC1125a<T> f1745j;

    /* renamed from: k */
    final RecyclerView.AdapterDataObserver f1746k;

    /* renamed from: cn.bluemobi.dylan.base.adapter.common.recyclerview.support.SectionAdapter$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C1126a extends RecyclerView.AdapterDataObserver {
        C1126a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            SectionAdapter.this.m57823p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.bluemobi.dylan.base.adapter.common.recyclerview.support.SectionAdapter$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1127b implements InterfaceC1125a<T> {
        C1127b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a
        /* renamed from: a */
        public int mo40465a(int i, T t) {
            SectionAdapter.this.m57822q(i);
            return !SectionAdapter.this.f1744i.values().contains(Integer.valueOf(i));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a
        /* renamed from: b */
        public int mo40464b(int i) {
            return i == 0 ? SectionAdapter.this.f1743h.m57820a() : ((CommonAdapter) SectionAdapter.this).f1722b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.bluemobi.dylan.base.adapter.common.recyclerview.support.SectionAdapter$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1128c implements InterfaceC1125a<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC1125a f1749a;

        C1128c(InterfaceC1125a interfaceC1125a) {
            this.f1749a = interfaceC1125a;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a
        /* renamed from: a */
        public int mo40465a(int i, T t) {
            int m57822q = SectionAdapter.this.m57822q(i);
            if (SectionAdapter.this.f1744i.values().contains(Integer.valueOf(i))) {
                return 0;
            }
            return this.f1749a.mo40465a(m57822q, t);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a
        /* renamed from: b */
        public int mo40464b(int i) {
            if (i == 0) {
                return SectionAdapter.this.f1743h.m57820a();
            }
            return this.f1749a.mo40464b(i);
        }
    }

    public SectionAdapter(Context context, int i, List<T> list, SectionSupport sectionSupport) {
        this(context, i, null, list, sectionSupport);
    }

    /* renamed from: r */
    private void m57821r(int i, InterfaceC1125a interfaceC1125a) {
        if (i != -1) {
            this.f1745j = new C1127b();
        } else if (interfaceC1125a != null) {
            this.f1745j = new C1128c(interfaceC1125a);
        } else {
            throw new RuntimeException("layoutId or MultiItemTypeSupport must set one.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    /* renamed from: e */
    public int mo57829e(RecyclerView.ViewHolder viewHolder) {
        return m57822q(viewHolder.getAdapterPosition());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    /* renamed from: f */
    public boolean mo57828f(int i) {
        if (i == 0) {
            return false;
        }
        return super.mo57828f(i);
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return super.getItemCount() + this.f1744i.size();
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.f1741g.mo40465a(i, null);
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        int m57822q = m57822q(i);
        if (viewHolder.getItemViewType() == 0) {
            viewHolder.m57874J(this.f1743h.m57818c(), this.f1743h.m57819b(this.f1723c.get(m57822q)));
        } else {
            super.onBindViewHolder(viewHolder, m57822q);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        unregisterAdapterDataObserver(this.f1746k);
    }

    /* renamed from: p */
    public void m57823p() {
        int size = this.f1723c.size();
        this.f1744i.clear();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            String m57819b = this.f1743h.m57819b(this.f1723c.get(i2));
            if (!this.f1744i.containsKey(m57819b)) {
                this.f1744i.put(m57819b, Integer.valueOf(i2 + i));
                i++;
            }
        }
    }

    /* renamed from: q */
    public int m57822q(int i) {
        int i2 = 0;
        for (Map.Entry<String, Integer> entry : this.f1744i.entrySet()) {
            if (entry.getValue().intValue() < i) {
                i2++;
            }
        }
        return i - i2;
    }

    public SectionAdapter(Context context, InterfaceC1125a interfaceC1125a, List<T> list, SectionSupport sectionSupport) {
        this(context, -1, interfaceC1125a, list, sectionSupport);
    }

    public SectionAdapter(Context context, int i, InterfaceC1125a interfaceC1125a, List<T> list, SectionSupport sectionSupport) {
        super(context, list, null);
        C1126a c1126a = new C1126a();
        this.f1746k = c1126a;
        this.f1722b = i;
        m57821r(i, interfaceC1125a);
        this.f1741g = this.f1745j;
        this.f1743h = sectionSupport;
        this.f1744i = new LinkedHashMap<>();
        m57823p();
        registerAdapterDataObserver(c1126a);
    }
}
