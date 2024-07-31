package cn.bluemobi.dylan.base.adapter.common.abslistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import java.util.List;

/* renamed from: cn.bluemobi.dylan.base.adapter.common.abslistview.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class MultiItemCommonAdapter<T> extends CommonAdapter<T> {

    /* renamed from: e */
    protected MultiItemTypeSupport<T> f1720e;

    public MultiItemCommonAdapter(Context context, List<T> list, MultiItemTypeSupport<T> multiItemTypeSupport) {
        super(context, -1, list);
        this.f1720e = multiItemTypeSupport;
        if (multiItemTypeSupport == null) {
            throw new IllegalArgumentException("the mMultiItemTypeSupport can not be null.");
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        MultiItemTypeSupport<T> multiItemTypeSupport = this.f1720e;
        if (multiItemTypeSupport != null) {
            return multiItemTypeSupport.m57841a(i, this.f1717b.get(i));
        }
        return super.getItemViewType(i);
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        MultiItemTypeSupport<T> multiItemTypeSupport = this.f1720e;
        if (multiItemTypeSupport == null) {
            return super.getView(i, view, viewGroup);
        }
        ViewHolder m57869a = ViewHolder.m57869a(this.f1716a, view, viewGroup, multiItemTypeSupport.m57840b(i, getItem(i)));
        m57869a.m57848v(i);
        mo40086a(m57869a, getItem(i));
        return m57869a.m57868b();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        MultiItemTypeSupport<T> multiItemTypeSupport = this.f1720e;
        if (multiItemTypeSupport != null) {
            return multiItemTypeSupport.getViewTypeCount();
        }
        return super.getViewTypeCount();
    }
}
