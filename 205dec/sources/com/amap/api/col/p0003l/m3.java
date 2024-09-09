package com.amap.api.col.p0003l;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OfflineDownloadedAdapter.java */
/* renamed from: com.amap.api.col.3l.m3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class m3 extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* renamed from: a  reason: collision with root package name */
    private boolean[] f8325a;

    /* renamed from: b  reason: collision with root package name */
    private Context f8326b;

    /* renamed from: c  reason: collision with root package name */
    private r3 f8327c;

    /* renamed from: d  reason: collision with root package name */
    private List<OfflineMapProvince> f8328d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    List<OfflineMapProvince> f8329e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private t3 f8330f;

    /* renamed from: g  reason: collision with root package name */
    private OfflineMapManager f8331g;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: OfflineDownloadedAdapter.java */
    /* renamed from: com.amap.api.col.3l.m3$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OfflineMapCity f8332a;

        a(OfflineMapCity offlineMapCity) {
            this.f8332a = offlineMapCity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            m3.this.f8330f.j(this.f8332a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: OfflineDownloadedAdapter.java */
    /* renamed from: com.amap.api.col.3l.m3$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public r3 f8334a;

        public b() {
        }
    }

    public m3(Context context, t3 t3Var, OfflineMapManager offlineMapManager, List<OfflineMapProvince> list) {
        this.f8326b = context;
        this.f8330f = t3Var;
        this.f8331g = offlineMapManager;
        if (list != null && list.size() > 0) {
            this.f8328d.clear();
            this.f8328d.addAll(list);
            for (OfflineMapProvince offlineMapProvince : this.f8328d) {
                if (offlineMapProvince != null && offlineMapProvince.getDownloadedCityList().size() > 0) {
                    this.f8329e.add(offlineMapProvince);
                }
            }
        }
        this.f8325a = new boolean[this.f8329e.size()];
    }

    public final void b() {
        for (OfflineMapProvince offlineMapProvince : this.f8328d) {
            if (offlineMapProvince.getDownloadedCityList().size() > 0 && !this.f8329e.contains(offlineMapProvince)) {
                this.f8329e.add(offlineMapProvince);
            }
        }
        this.f8325a = new boolean[this.f8329e.size()];
        notifyDataSetChanged();
    }

    public final void c() {
        try {
            for (int size = this.f8329e.size(); size > 0; size--) {
                OfflineMapProvince offlineMapProvince = this.f8329e.get(size - 1);
                if (offlineMapProvince.getDownloadedCityList().size() == 0) {
                    this.f8329e.remove(offlineMapProvince);
                }
            }
            this.f8325a = new boolean[this.f8329e.size()];
            notifyDataSetChanged();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getChild(int i4, int i5) {
        return this.f8329e.get(i4).getDownloadedCityList().get(i5);
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getChildId(int i4, int i5) {
        return i5;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getChildView(int i4, int i5, boolean z3, View view, ViewGroup viewGroup) {
        b bVar;
        if (view != null) {
            bVar = (b) view.getTag();
        } else {
            bVar = new b();
            r3 r3Var = new r3(this.f8326b, this.f8331g);
            this.f8327c = r3Var;
            r3Var.b(2);
            view = this.f8327c.a();
            bVar.f8334a = this.f8327c;
            view.setTag(bVar);
        }
        OfflineMapProvince offlineMapProvince = this.f8329e.get(i4);
        if (i5 < offlineMapProvince.getDownloadedCityList().size()) {
            OfflineMapCity offlineMapCity = offlineMapProvince.getDownloadedCityList().get(i5);
            bVar.f8334a.e(offlineMapCity);
            view.setOnClickListener(new a(offlineMapCity));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i4) {
        return this.f8329e.get(i4).getDownloadedCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getGroup(int i4) {
        return this.f8329e.get(i4).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        return this.f8329e.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i4) {
        return i4;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getGroupView(int i4, boolean z3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) w3.d(this.f8326b, 2130903043);
        }
        ImageView imageView = (ImageView) view.findViewById(2131165202);
        ((TextView) view.findViewById(2131165201)).setText(this.f8329e.get(i4).getProvinceName());
        if (this.f8325a[i4]) {
            imageView.setImageDrawable(w3.b().getDrawable(2130837509));
        } else {
            imageView.setImageDrawable(w3.b().getDrawable(2130837510));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i4, int i5) {
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public final void onGroupCollapse(int i4) {
        this.f8325a[i4] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public final void onGroupExpand(int i4) {
        this.f8325a[i4] = true;
    }
}
