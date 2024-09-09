package cn.bluemobi.dylan.base.adapter.common.abslistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: MultiItemCommonAdapter.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class b<T> extends a<T> {

    /* renamed from: e  reason: collision with root package name */
    protected c<T> f1706e;

    public b(Context context, List<T> list, c<T> cVar) {
        super(context, -1, list);
        this.f1706e = cVar;
        if (cVar == null) {
            throw new IllegalArgumentException("the mMultiItemTypeSupport can not be null.");
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i4) {
        c<T> cVar = this.f1706e;
        if (cVar != null) {
            return cVar.a(i4, this.f1703b.get(i4));
        }
        return super.getItemViewType(i4);
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a, android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        c<T> cVar = this.f1706e;
        if (cVar == null) {
            return super.getView(i4, view, viewGroup);
        }
        ViewHolder a4 = ViewHolder.a(this.f1702a, view, viewGroup, cVar.b(i4, getItem(i4)));
        a4.v(i4);
        a(a4, getItem(i4));
        return a4.b();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        c<T> cVar = this.f1706e;
        if (cVar != null) {
            return cVar.getViewTypeCount();
        }
        return super.getViewTypeCount();
    }
}
