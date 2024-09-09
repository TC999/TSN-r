package com.amap.api.col.p0003l;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OfflineListAdapter.java */
/* renamed from: com.amap.api.col.3l.n3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class n3 extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* renamed from: a  reason: collision with root package name */
    private boolean[] f8378a;

    /* renamed from: b  reason: collision with root package name */
    private int f8379b = -1;

    /* renamed from: c  reason: collision with root package name */
    private List<OfflineMapProvince> f8380c;

    /* renamed from: d  reason: collision with root package name */
    private OfflineMapManager f8381d;

    /* renamed from: e  reason: collision with root package name */
    private Context f8382e;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: OfflineListAdapter.java */
    /* renamed from: com.amap.api.col.3l.n3$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public r3 f8383a;

        public a() {
        }
    }

    public n3(List<OfflineMapProvince> list, OfflineMapManager offlineMapManager, Context context) {
        this.f8380c = list;
        this.f8381d = offlineMapManager;
        this.f8382e = context;
        this.f8378a = new boolean[list.size()];
    }

    private boolean b(int i4) {
        return (i4 == 0 || i4 == getGroupCount() - 1) ? false : true;
    }

    public final void a() {
        this.f8379b = -1;
        notifyDataSetChanged();
    }

    public final void c() {
        this.f8379b = 0;
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getChild(int i4, int i5) {
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getChildId(int i4, int i5) {
        return i5;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getChildView(int i4, int i5, boolean z3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            aVar = new a();
            r3 r3Var = new r3(this.f8382e, this.f8381d);
            r3Var.b(1);
            View a4 = r3Var.a();
            aVar.f8383a = r3Var;
            a4.setTag(aVar);
            view = a4;
        }
        aVar.f8383a.e(this.f8380c.get(i4).getCityList().get(i5));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i4) {
        if (b(i4)) {
            return this.f8380c.get(i4).getCityList().size();
        }
        return this.f8380c.get(i4).getCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getGroup(int i4) {
        return this.f8380c.get(i4).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        int i4 = this.f8379b;
        return i4 == -1 ? this.f8380c.size() : i4;
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i4) {
        return i4;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getGroupView(int i4, boolean z3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) w3.d(this.f8382e, 2130903043);
        }
        ImageView imageView = (ImageView) view.findViewById(2131165202);
        ((TextView) view.findViewById(2131165201)).setText(this.f8380c.get(i4).getProvinceName());
        if (this.f8378a[i4]) {
            imageView.setImageDrawable(w3.b().getDrawable(2130837509));
        } else {
            imageView.setImageDrawable(w3.b().getDrawable(2130837510));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i4, int i5) {
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public final void onGroupCollapse(int i4) {
        this.f8378a[i4] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public final void onGroupExpand(int i4) {
        this.f8378a[i4] = true;
    }
}
