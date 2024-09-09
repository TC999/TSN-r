package cn.bluemobi.dylan.base.adapter.common.recyclerview;

import android.content.Context;
import android.view.ViewGroup;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class MultiItemCommonAdapter<T> extends CommonAdapter<T> {

    /* renamed from: g  reason: collision with root package name */
    protected a<T> f1727g;

    public MultiItemCommonAdapter(Context context, List<T> list, a<T> aVar) {
        super(context, -1, list);
        this.f1727g = aVar;
        if (aVar == null) {
            throw new IllegalArgumentException("the mMultiItemTypeSupport can not be null.");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        a<T> aVar = this.f1727g;
        if (aVar != null) {
            return aVar.a(i4, this.f1709c.get(i4));
        }
        return super.getItemViewType(i4);
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        a<T> aVar = this.f1727g;
        if (aVar == null) {
            return super.onCreateViewHolder(viewGroup, i4);
        }
        ViewHolder a4 = ViewHolder.a(this.f1707a, null, viewGroup, aVar.b(i4));
        j(viewGroup, a4, i4);
        return a4;
    }
}
