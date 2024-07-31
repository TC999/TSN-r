package com.amap.api.col.p0463l;

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

/* renamed from: com.amap.api.col.3l.m3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class OfflineDownloadedAdapter extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* renamed from: a */
    private boolean[] f4665a;

    /* renamed from: b */
    private Context f4666b;

    /* renamed from: c */
    private OfflineChild f4667c;

    /* renamed from: d */
    private List<OfflineMapProvince> f4668d = new ArrayList();

    /* renamed from: e */
    List<OfflineMapProvince> f4669e = new ArrayList();

    /* renamed from: f */
    private OfflineMapPage f4670f;

    /* renamed from: g */
    private OfflineMapManager f4671g;

    /* compiled from: OfflineDownloadedAdapter.java */
    /* renamed from: com.amap.api.col.3l.m3$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class View$OnClickListenerC1850a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ OfflineMapCity f4672a;

        View$OnClickListenerC1850a(OfflineMapCity offlineMapCity) {
            this.f4672a = offlineMapCity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            OfflineDownloadedAdapter.this.f4670f.m53887j(this.f4672a);
        }
    }

    /* compiled from: OfflineDownloadedAdapter.java */
    /* renamed from: com.amap.api.col.3l.m3$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C1851b {

        /* renamed from: a */
        public OfflineChild f4674a;

        public C1851b() {
        }
    }

    public OfflineDownloadedAdapter(Context context, OfflineMapPage offlineMapPage, OfflineMapManager offlineMapManager, List<OfflineMapProvince> list) {
        this.f4666b = context;
        this.f4670f = offlineMapPage;
        this.f4671g = offlineMapManager;
        if (list != null && list.size() > 0) {
            this.f4668d.clear();
            this.f4668d.addAll(list);
            for (OfflineMapProvince offlineMapProvince : this.f4668d) {
                if (offlineMapProvince != null && offlineMapProvince.getDownloadedCityList().size() > 0) {
                    this.f4669e.add(offlineMapProvince);
                }
            }
        }
        this.f4665a = new boolean[this.f4669e.size()];
    }

    /* renamed from: b */
    public final void m54529b() {
        for (OfflineMapProvince offlineMapProvince : this.f4668d) {
            if (offlineMapProvince.getDownloadedCityList().size() > 0 && !this.f4669e.contains(offlineMapProvince)) {
                this.f4669e.add(offlineMapProvince);
            }
        }
        this.f4665a = new boolean[this.f4669e.size()];
        notifyDataSetChanged();
    }

    /* renamed from: c */
    public final void m54528c() {
        try {
            for (int size = this.f4669e.size(); size > 0; size--) {
                OfflineMapProvince offlineMapProvince = this.f4669e.get(size - 1);
                if (offlineMapProvince.getDownloadedCityList().size() == 0) {
                    this.f4669e.remove(offlineMapProvince);
                }
            }
            this.f4665a = new boolean[this.f4669e.size()];
            notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getChild(int i, int i2) {
        return this.f4669e.get(i).getDownloadedCityList().get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C1851b c1851b;
        if (view != null) {
            c1851b = (C1851b) view.getTag();
        } else {
            c1851b = new C1851b();
            OfflineChild offlineChild = new OfflineChild(this.f4666b, this.f4671g);
            this.f4667c = offlineChild;
            offlineChild.m54060b(2);
            view = this.f4667c.m54061a();
            c1851b.f4674a = this.f4667c;
            view.setTag(c1851b);
        }
        OfflineMapProvince offlineMapProvince = this.f4669e.get(i);
        if (i2 < offlineMapProvince.getDownloadedCityList().size()) {
            OfflineMapCity offlineMapCity = offlineMapProvince.getDownloadedCityList().get(i2);
            c1851b.f4674a.m54057e(offlineMapCity);
            view.setOnClickListener(new View$OnClickListenerC1850a(offlineMapCity));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i) {
        return this.f4669e.get(i).getDownloadedCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getGroup(int i) {
        return this.f4669e.get(i).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        return this.f4669e.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) ServiceUtils.m53597d(this.f4666b, 2130903043);
        }
        ImageView imageView = (ImageView) view.findViewById(2131165202);
        ((TextView) view.findViewById(2131165201)).setText(this.f4669e.get(i).getProvinceName());
        if (this.f4665a[i]) {
            imageView.setImageDrawable(ServiceUtils.m53599b().getDrawable(2130837509));
        } else {
            imageView.setImageDrawable(ServiceUtils.m53599b().getDrawable(2130837510));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public final void onGroupCollapse(int i) {
        this.f4665a[i] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public final void onGroupExpand(int i) {
        this.f4665a[i] = true;
    }
}
