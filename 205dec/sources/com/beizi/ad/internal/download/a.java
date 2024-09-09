package com.beizi.ad.internal.download;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.beizi.ad.R;
import com.beizi.ad.lance.a.i;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BeiZiExpandableListviewAdapter.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a extends BaseExpandableListAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f13758a;

    /* renamed from: b  reason: collision with root package name */
    private List<com.beizi.ad.internal.download.b> f13759b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BeiZiExpandableListviewAdapter.java */
    /* renamed from: com.beizi.ad.internal.download.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class C0124a {

        /* renamed from: a  reason: collision with root package name */
        TextView f13760a;

        /* renamed from: b  reason: collision with root package name */
        BeiZiWebView f13761b;

        public C0124a() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BeiZiExpandableListviewAdapter.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        TextView f13763a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f13764b;

        /* renamed from: c  reason: collision with root package name */
        View f13765c;

        public b() {
        }
    }

    public a(Context context, List<com.beizi.ad.internal.download.b> list) {
        ArrayList arrayList = new ArrayList();
        this.f13759b = arrayList;
        this.f13758a = context;
        arrayList.clear();
        this.f13759b.addAll(list);
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i4, int i5) {
        return this.f13759b.get(i4).c();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i4, int i5) {
        return i5;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i4, int i5, boolean z3, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f13758a).inflate(R.layout.beizi_download_dialog_expand_child_item, (ViewGroup) null);
        C0124a c0124a = new C0124a();
        c0124a.f13760a = (TextView) inflate.findViewById(R.id.beizi_addeci_content_tv);
        c0124a.f13761b = (BeiZiWebView) inflate.findViewById(R.id.beizi_addeci_content_wb);
        inflate.setTag(c0124a);
        if ("text".equals(this.f13759b.get(i4).b())) {
            c0124a.f13760a.setVisibility(0);
            c0124a.f13761b.setVisibility(8);
            c0124a.f13760a.setText(this.f13759b.get(i4).c());
        } else if ("h5".equals(this.f13759b.get(i4).b())) {
            c0124a.f13760a.setVisibility(8);
            c0124a.f13761b.setVisibility(0);
            c0124a.f13761b.loadUrl(this.f13759b.get(i4).c(), i.a());
        }
        return inflate;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i4) {
        return 1;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i4) {
        return this.f13759b.get(i4);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f13759b.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i4) {
        return i4;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i4, boolean z3, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f13758a).inflate(R.layout.beizi_download_dialog_expand_parent_item, (ViewGroup) null);
            bVar = new b();
            bVar.f13763a = (TextView) view.findViewById(R.id.beizi_addep_title_tv);
            bVar.f13764b = (ImageView) view.findViewById(R.id.beizi_addep_fold_iv);
            bVar.f13765c = view.findViewById(R.id.beizi_addep_item_divider_view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f13763a.setText(this.f13759b.get(i4).a());
        if (z3) {
            bVar.f13763a.setTextColor(Color.parseColor("#FF8E15"));
            bVar.f13764b.setBackgroundResource(R.mipmap.beizi_icon_arrow_unfold);
        } else {
            bVar.f13763a.setTextColor(Color.parseColor("#333333"));
            bVar.f13764b.setBackgroundResource(R.mipmap.beizi_icon_arrow_fold);
        }
        if (i4 == 0) {
            bVar.f13765c.setVisibility(8);
        } else {
            bVar.f13765c.setVisibility(0);
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i4, int i5) {
        return false;
    }
}
