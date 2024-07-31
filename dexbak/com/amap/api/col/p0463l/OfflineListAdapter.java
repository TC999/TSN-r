package com.amap.api.col.p0463l;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.List;

/* renamed from: com.amap.api.col.3l.n3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class OfflineListAdapter extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* renamed from: a */
    private boolean[] f4743a;

    /* renamed from: b */
    private int f4744b = -1;

    /* renamed from: c */
    private List<OfflineMapProvince> f4745c;

    /* renamed from: d */
    private OfflineMapManager f4746d;

    /* renamed from: e */
    private Context f4747e;

    /* compiled from: OfflineListAdapter.java */
    /* renamed from: com.amap.api.col.3l.n3$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C1864a {

        /* renamed from: a */
        public OfflineChild f4748a;

        public C1864a() {
        }
    }

    public OfflineListAdapter(List<OfflineMapProvince> list, OfflineMapManager offlineMapManager, Context context) {
        this.f4745c = list;
        this.f4746d = offlineMapManager;
        this.f4747e = context;
        this.f4743a = new boolean[list.size()];
    }

    /* renamed from: b */
    private boolean m54444b(int i) {
        return (i == 0 || i == getGroupCount() - 1) ? false : true;
    }

    /* renamed from: a */
    public final void m54445a() {
        this.f4744b = -1;
        notifyDataSetChanged();
    }

    /* renamed from: c */
    public final void m54443c() {
        this.f4744b = 0;
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getChild(int i, int i2) {
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C1864a c1864a;
        if (view != null) {
            c1864a = (C1864a) view.getTag();
        } else {
            c1864a = new C1864a();
            OfflineChild offlineChild = new OfflineChild(this.f4747e, this.f4746d);
            offlineChild.m54060b(1);
            View m54061a = offlineChild.m54061a();
            c1864a.f4748a = offlineChild;
            m54061a.setTag(c1864a);
            view = m54061a;
        }
        c1864a.f4748a.m54057e(this.f4745c.get(i).getCityList().get(i2));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i) {
        if (m54444b(i)) {
            return this.f4745c.get(i).getCityList().size();
        }
        return this.f4745c.get(i).getCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getGroup(int i) {
        return this.f4745c.get(i).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        int i = this.f4744b;
        return i == -1 ? this.f4745c.size() : i;
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) ServiceUtils.m53597d(this.f4747e, 2130903043);
        }
        ImageView imageView = (ImageView) view.findViewById(2131165202);
        ((TextView) view.findViewById(2131165201)).setText(this.f4745c.get(i).getProvinceName());
        if (this.f4743a[i]) {
            imageView.setImageDrawable(ServiceUtils.m53599b().getDrawable(2130837509));
        } else {
            imageView.setImageDrawable(ServiceUtils.m53599b().getDrawable(2130837510));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public final void onGroupCollapse(int i) {
        this.f4743a[i] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public final void onGroupExpand(int i) {
        this.f4743a[i] = true;
    }
}
