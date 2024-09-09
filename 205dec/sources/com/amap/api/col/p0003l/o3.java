package com.amap.api.col.p0003l;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SearchListAdapter.java */
/* renamed from: com.amap.api.col.3l.o3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class o3 extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<OfflineMapCity> f8443a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private OfflineMapManager f8444b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f8445c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: SearchListAdapter.java */
    /* renamed from: com.amap.api.col.3l.o3$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f8446a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OfflineMapCity f8447b;

        a(b bVar, OfflineMapCity offlineMapCity) {
            this.f8446a = bVar;
            this.f8447b = offlineMapCity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8446a.f8452d.setVisibility(8);
            this.f8446a.f8451c.setVisibility(0);
            this.f8446a.f8451c.setText("\u4e0b\u8f7d\u4e2d");
            try {
                o3.this.f8444b.downloadByCityName(this.f8447b.getCity());
            } catch (AMapException e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: SearchListAdapter.java */
    /* renamed from: com.amap.api.col.3l.o3$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f8449a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f8450b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f8451c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f8452d;

        public b() {
        }
    }

    public o3(OfflineMapManager offlineMapManager, OfflineMapActivity offlineMapActivity) {
        this.f8444b = offlineMapManager;
        this.f8445c = offlineMapActivity;
    }

    public final void b(List<OfflineMapCity> list) {
        this.f8443a = list;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f8443a.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i4) {
        return this.f8443a.get(i4);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        b bVar;
        int state;
        try {
            OfflineMapCity offlineMapCity = this.f8443a.get(i4);
            if (view == null) {
                bVar = new b();
                view = w3.d(this.f8445c, 2130903042);
                bVar.f8449a = (TextView) view.findViewById(2131165195);
                bVar.f8450b = (TextView) view.findViewById(2131165199);
                bVar.f8451c = (TextView) view.findViewById(2131165197);
                bVar.f8452d = (ImageView) view.findViewById(2131165198);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.f8452d.setOnClickListener(new a(bVar, offlineMapCity));
            bVar.f8451c.setVisibility(0);
            bVar.f8449a.setText(offlineMapCity.getCity());
            double size = offlineMapCity.getSize();
            Double.isNaN(size);
            double d4 = (int) (((size / 1024.0d) / 1024.0d) * 100.0d);
            Double.isNaN(d4);
            double d5 = d4 / 100.0d;
            bVar.f8450b.setText(String.valueOf(d5) + " M");
            state = offlineMapCity.getState();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (state != -1) {
            if (state == 0 || state == 1) {
                bVar.f8452d.setVisibility(8);
                bVar.f8451c.setText("\u4e0b\u8f7d\u4e2d");
            } else if (state == 2) {
                bVar.f8452d.setVisibility(8);
                bVar.f8451c.setText("\u7b49\u5f85\u4e0b\u8f7d");
            } else if (state == 3) {
                bVar.f8452d.setVisibility(8);
                bVar.f8451c.setText("\u6682\u505c\u4e2d");
            } else if (state == 4) {
                bVar.f8452d.setVisibility(8);
                bVar.f8451c.setText("\u5df2\u4e0b\u8f7d");
            } else if (state != 6) {
                switch (state) {
                }
            } else {
                bVar.f8452d.setVisibility(0);
                bVar.f8451c.setVisibility(8);
            }
            return view;
        }
        bVar.f8452d.setVisibility(8);
        bVar.f8451c.setText("\u4e0b\u8f7d\u5931\u8d25");
        return view;
    }
}
