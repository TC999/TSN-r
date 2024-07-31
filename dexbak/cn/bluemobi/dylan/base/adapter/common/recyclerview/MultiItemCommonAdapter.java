package cn.bluemobi.dylan.base.adapter.common.recyclerview;

import android.content.Context;
import android.view.ViewGroup;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class MultiItemCommonAdapter<T> extends CommonAdapter<T> {

    /* renamed from: g */
    protected InterfaceC1125a<T> f1741g;

    public MultiItemCommonAdapter(Context context, List<T> list, InterfaceC1125a<T> interfaceC1125a) {
        super(context, -1, list);
        this.f1741g = interfaceC1125a;
        if (interfaceC1125a == null) {
            throw new IllegalArgumentException("the mMultiItemTypeSupport can not be null.");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterfaceC1125a<T> interfaceC1125a = this.f1741g;
        if (interfaceC1125a != null) {
            return interfaceC1125a.mo40465a(i, this.f1723c.get(i));
        }
        return super.getItemViewType(i);
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterfaceC1125a<T> interfaceC1125a = this.f1741g;
        if (interfaceC1125a == null) {
            return super.onCreateViewHolder(viewGroup, i);
        }
        ViewHolder m57869a = ViewHolder.m57869a(this.f1721a, null, viewGroup, interfaceC1125a.mo40464b(i));
        m57835j(viewGroup, m57869a, i);
        return m57869a;
    }
}
