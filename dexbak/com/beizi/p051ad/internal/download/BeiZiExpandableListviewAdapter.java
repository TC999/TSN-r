package com.beizi.p051ad.internal.download;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mobads.sdk.internal.C2573a;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.lance.p062a.HeaderUtil;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.beizi.ad.internal.download.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiExpandableListviewAdapter extends BaseExpandableListAdapter {

    /* renamed from: a */
    private Context f10080a;

    /* renamed from: b */
    private List<ExpandableGroupBean> f10081b;

    /* compiled from: BeiZiExpandableListviewAdapter.java */
    /* renamed from: com.beizi.ad.internal.download.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2880a {

        /* renamed from: a */
        TextView f10082a;

        /* renamed from: b */
        BeiZiWebView f10083b;

        public C2880a() {
        }
    }

    /* compiled from: BeiZiExpandableListviewAdapter.java */
    /* renamed from: com.beizi.ad.internal.download.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2881b {

        /* renamed from: a */
        TextView f10085a;

        /* renamed from: b */
        ImageView f10086b;

        /* renamed from: c */
        View f10087c;

        public C2881b() {
        }
    }

    public BeiZiExpandableListviewAdapter(Context context, List<ExpandableGroupBean> list) {
        ArrayList arrayList = new ArrayList();
        this.f10081b = arrayList;
        this.f10080a = context;
        arrayList.clear();
        this.f10081b.addAll(list);
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return this.f10081b.get(i).m49521c();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f10080a).inflate(C2750R.C2754layout.beizi_download_dialog_expand_child_item, (ViewGroup) null);
        C2880a c2880a = new C2880a();
        c2880a.f10082a = (TextView) inflate.findViewById(C2750R.C2753id.beizi_addeci_content_tv);
        c2880a.f10083b = (BeiZiWebView) inflate.findViewById(C2750R.C2753id.beizi_addeci_content_wb);
        inflate.setTag(c2880a);
        if (C2573a.f8443b.equals(this.f10081b.get(i).m49523b())) {
            c2880a.f10082a.setVisibility(0);
            c2880a.f10083b.setVisibility(8);
            c2880a.f10082a.setText(this.f10081b.get(i).m49521c());
        } else if ("h5".equals(this.f10081b.get(i).m49523b())) {
            c2880a.f10082a.setVisibility(8);
            c2880a.f10083b.setVisibility(0);
            c2880a.f10083b.loadUrl(this.f10081b.get(i).m49521c(), HeaderUtil.m49052a());
        }
        return inflate;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f10081b.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f10081b.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C2881b c2881b;
        if (view == null) {
            view = LayoutInflater.from(this.f10080a).inflate(C2750R.C2754layout.beizi_download_dialog_expand_parent_item, (ViewGroup) null);
            c2881b = new C2881b();
            c2881b.f10085a = (TextView) view.findViewById(C2750R.C2753id.beizi_addep_title_tv);
            c2881b.f10086b = (ImageView) view.findViewById(C2750R.C2753id.beizi_addep_fold_iv);
            c2881b.f10087c = view.findViewById(C2750R.C2753id.beizi_addep_item_divider_view);
            view.setTag(c2881b);
        } else {
            c2881b = (C2881b) view.getTag();
        }
        c2881b.f10085a.setText(this.f10081b.get(i).m49525a());
        if (z) {
            c2881b.f10085a.setTextColor(Color.parseColor("#FF8E15"));
            c2881b.f10086b.setBackgroundResource(C2750R.mipmap.beizi_icon_arrow_unfold);
        } else {
            c2881b.f10085a.setTextColor(Color.parseColor("#333333"));
            c2881b.f10086b.setBackgroundResource(C2750R.mipmap.beizi_icon_arrow_fold);
        }
        if (i == 0) {
            c2881b.f10087c.setVisibility(8);
        } else {
            c2881b.f10087c.setVisibility(0);
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return false;
    }
}
