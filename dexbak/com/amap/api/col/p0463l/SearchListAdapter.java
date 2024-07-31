package com.amap.api.col.p0463l;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapActivity;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.amap.api.col.3l.o3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class SearchListAdapter extends BaseAdapter {

    /* renamed from: a */
    private List<OfflineMapCity> f4773a = new ArrayList();

    /* renamed from: b */
    private OfflineMapManager f4774b;

    /* renamed from: c */
    private Activity f4775c;

    /* compiled from: SearchListAdapter.java */
    /* renamed from: com.amap.api.col.3l.o3$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class View$OnClickListenerC1867a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ C1868b f4776a;

        /* renamed from: b */
        final /* synthetic */ OfflineMapCity f4777b;

        View$OnClickListenerC1867a(C1868b c1868b, OfflineMapCity offlineMapCity) {
            this.f4776a = c1868b;
            this.f4777b = offlineMapCity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f4776a.f4782d.setVisibility(8);
            this.f4776a.f4781c.setVisibility(0);
            this.f4776a.f4781c.setText("下载中");
            try {
                SearchListAdapter.this.f4774b.downloadByCityName(this.f4777b.getCity());
            } catch (AMapException e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SearchListAdapter.java */
    /* renamed from: com.amap.api.col.3l.o3$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C1868b {

        /* renamed from: a */
        public TextView f4779a;

        /* renamed from: b */
        public TextView f4780b;

        /* renamed from: c */
        public TextView f4781c;

        /* renamed from: d */
        public ImageView f4782d;

        public C1868b() {
        }
    }

    public SearchListAdapter(OfflineMapManager offlineMapManager, OfflineMapActivity offlineMapActivity) {
        this.f4774b = offlineMapManager;
        this.f4775c = offlineMapActivity;
    }

    /* renamed from: b */
    public final void m54401b(List<OfflineMapCity> list) {
        this.f4773a = list;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f4773a.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f4773a.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1868b c1868b;
        int state;
        try {
            OfflineMapCity offlineMapCity = this.f4773a.get(i);
            if (view == null) {
                c1868b = new C1868b();
                view = ServiceUtils.m53597d(this.f4775c, 2130903042);
                c1868b.f4779a = (TextView) view.findViewById(2131165195);
                c1868b.f4780b = (TextView) view.findViewById(2131165199);
                c1868b.f4781c = (TextView) view.findViewById(2131165197);
                c1868b.f4782d = (ImageView) view.findViewById(2131165198);
                view.setTag(c1868b);
            } else {
                c1868b = (C1868b) view.getTag();
            }
            c1868b.f4782d.setOnClickListener(new View$OnClickListenerC1867a(c1868b, offlineMapCity));
            c1868b.f4781c.setVisibility(0);
            c1868b.f4779a.setText(offlineMapCity.getCity());
            double size = offlineMapCity.getSize();
            Double.isNaN(size);
            double d = (int) (((size / 1024.0d) / 1024.0d) * 100.0d);
            Double.isNaN(d);
            double d2 = d / 100.0d;
            c1868b.f4780b.setText(String.valueOf(d2) + " M");
            state = offlineMapCity.getState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (state != -1) {
            if (state == 0 || state == 1) {
                c1868b.f4782d.setVisibility(8);
                c1868b.f4781c.setText("下载中");
            } else if (state == 2) {
                c1868b.f4782d.setVisibility(8);
                c1868b.f4781c.setText("等待下载");
            } else if (state == 3) {
                c1868b.f4782d.setVisibility(8);
                c1868b.f4781c.setText("暂停中");
            } else if (state == 4) {
                c1868b.f4782d.setVisibility(8);
                c1868b.f4781c.setText("已下载");
            } else if (state != 6) {
                switch (state) {
                }
            } else {
                c1868b.f4782d.setVisibility(0);
                c1868b.f4781c.setVisibility(8);
            }
            return view;
        }
        c1868b.f4782d.setVisibility(8);
        c1868b.f4781c.setText("下载失败");
        return view;
    }
}
