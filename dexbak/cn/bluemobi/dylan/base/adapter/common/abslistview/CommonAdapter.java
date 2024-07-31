package cn.bluemobi.dylan.base.adapter.common.abslistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import java.util.List;

/* renamed from: cn.bluemobi.dylan.base.adapter.common.abslistview.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class CommonAdapter<T> extends BaseAdapter {

    /* renamed from: a */
    protected Context f1716a;

    /* renamed from: b */
    protected List<T> f1717b;

    /* renamed from: c */
    protected LayoutInflater f1718c;

    /* renamed from: d */
    private int f1719d;

    public CommonAdapter(Context context, int i, List<T> list) {
        this.f1716a = context;
        this.f1718c = LayoutInflater.from(context);
        this.f1717b = list;
        this.f1719d = i;
    }

    /* renamed from: a */
    public abstract void mo40086a(ViewHolder viewHolder, T t);

    /* renamed from: b */
    public List<T> m57843b() {
        return this.f1717b;
    }

    /* renamed from: c */
    public void m57842c(List<T> list) {
        this.f1717b = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.f1717b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        return this.f1717b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder m57869a = ViewHolder.m57869a(this.f1716a, view, viewGroup, this.f1719d);
        m57869a.m57848v(i);
        mo40086a(m57869a, getItem(i));
        return m57869a.m57868b();
    }
}
