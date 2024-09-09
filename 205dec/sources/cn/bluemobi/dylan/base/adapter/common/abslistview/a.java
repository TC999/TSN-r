package cn.bluemobi.dylan.base.adapter.common.abslistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: CommonAdapter.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class a<T> extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    protected Context f1702a;

    /* renamed from: b  reason: collision with root package name */
    protected List<T> f1703b;

    /* renamed from: c  reason: collision with root package name */
    protected LayoutInflater f1704c;

    /* renamed from: d  reason: collision with root package name */
    private int f1705d;

    public a(Context context, int i4, List<T> list) {
        this.f1702a = context;
        this.f1704c = LayoutInflater.from(context);
        this.f1703b = list;
        this.f1705d = i4;
    }

    public abstract void a(ViewHolder viewHolder, T t3);

    public List<T> b() {
        return this.f1703b;
    }

    public void c(List<T> list) {
        this.f1703b = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.f1703b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i4) {
        return this.f1703b.get(i4);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        ViewHolder a4 = ViewHolder.a(this.f1702a, view, viewGroup, this.f1705d);
        a4.v(i4);
        a(a4, getItem(i4));
        return a4.b();
    }
}
