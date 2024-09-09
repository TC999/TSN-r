package com.amap.api.col.p0003l;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.amap.api.maps.offlinemap.DownLoadExpandListView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OfflineMapPage.java */
/* renamed from: com.amap.api.col.3l.t3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class t3 extends com.amap.api.offlineservice.a implements TextWatcher, View.OnTouchListener, AbsListView.OnScrollListener, OfflineMapManager.OfflineLoadedListener, OfflineMapManager.OfflineMapDownloadListener {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f8987b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f8988c;

    /* renamed from: d  reason: collision with root package name */
    private DownLoadExpandListView f8989d;

    /* renamed from: e  reason: collision with root package name */
    private ListView f8990e;

    /* renamed from: f  reason: collision with root package name */
    private ExpandableListView f8991f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f8992g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f8993h;

    /* renamed from: i  reason: collision with root package name */
    private AutoCompleteTextView f8994i;

    /* renamed from: j  reason: collision with root package name */
    private RelativeLayout f8995j;

    /* renamed from: k  reason: collision with root package name */
    private RelativeLayout f8996k;

    /* renamed from: l  reason: collision with root package name */
    private ImageView f8997l;

    /* renamed from: m  reason: collision with root package name */
    private ImageView f8998m;

    /* renamed from: n  reason: collision with root package name */
    private RelativeLayout f8999n;

    /* renamed from: p  reason: collision with root package name */
    private n3 f9001p;

    /* renamed from: r  reason: collision with root package name */
    private m3 f9003r;

    /* renamed from: s  reason: collision with root package name */
    private o3 f9004s;

    /* renamed from: x  reason: collision with root package name */
    private p3 f9009x;

    /* renamed from: o  reason: collision with root package name */
    private List<OfflineMapProvince> f9000o = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private OfflineMapManager f9002q = null;

    /* renamed from: t  reason: collision with root package name */
    private boolean f9005t = true;

    /* renamed from: u  reason: collision with root package name */
    private boolean f9006u = true;

    /* renamed from: v  reason: collision with root package name */
    private int f9007v = -1;

    /* renamed from: w  reason: collision with root package name */
    private long f9008w = 0;

    /* renamed from: y  reason: collision with root package name */
    private boolean f9010y = true;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: OfflineMapPage.java */
    /* renamed from: com.amap.api.col.3l.t3$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                t3.this.f8994i.setText("");
                t3.this.f8997l.setVisibility(8);
                t3.this.k(false);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) t3.this.f8998m.getLayoutParams();
                layoutParams.leftMargin = t3.this.a(95.0f);
                t3.this.f8998m.setLayoutParams(layoutParams);
                t3.this.f8994i.setPadding(t3.this.a(105.0f), 0, 0, 0);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: OfflineMapPage.java */
    /* renamed from: com.amap.api.col.3l.t3$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements Comparator<OfflineMapCity> {
        b() {
        }

        private static int a(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
            char[] charArray = offlineMapCity.getJianpin().toCharArray();
            char[] charArray2 = offlineMapCity2.getJianpin().toCharArray();
            return (charArray[0] >= charArray2[0] && charArray[1] >= charArray2[1]) ? 0 : 1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
            return a(offlineMapCity, offlineMapCity2);
        }
    }

    private void n() {
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f8998m.getLayoutParams();
            layoutParams.leftMargin = a(18.0f);
            this.f8998m.setLayoutParams(layoutParams);
            this.f8994i.setPadding(a(30.0f), 0, 0, 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void o() {
        q();
        o3 o3Var = new o3(this.f9002q, this.f10858a);
        this.f9004s = o3Var;
        this.f8990e.setAdapter((ListAdapter) o3Var);
    }

    private void p() {
        m3 m3Var = new m3(this.f10858a, this, this.f9002q, this.f9000o);
        this.f9003r = m3Var;
        this.f8989d.setAdapter(m3Var);
        this.f9003r.notifyDataSetChanged();
    }

    private void q() {
        ArrayList<OfflineMapProvince> offlineMapProvinceList = this.f9002q.getOfflineMapProvinceList();
        this.f9000o.clear();
        this.f9000o.add(null);
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList2 = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList3 = new ArrayList<>();
        for (int i4 = 0; i4 < offlineMapProvinceList.size(); i4++) {
            OfflineMapProvince offlineMapProvince = offlineMapProvinceList.get(i4);
            if (offlineMapProvince.getCityList().size() != 1) {
                this.f9000o.add(i4 + 1, offlineMapProvince);
            } else {
                String provinceName = offlineMapProvince.getProvinceName();
                if (provinceName.contains("\u9999\u6e2f")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("\u6fb3\u95e8")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("\u5168\u56fd\u6982\u8981\u56fe")) {
                    arrayList3.addAll(0, offlineMapProvince.getCityList());
                } else {
                    arrayList3.addAll(offlineMapProvince.getCityList());
                }
            }
        }
        OfflineMapProvince offlineMapProvince2 = new OfflineMapProvince();
        offlineMapProvince2.setProvinceName("\u57fa\u672c\u529f\u80fd\u5305+\u76f4\u8f96\u5e02");
        offlineMapProvince2.setCityList(arrayList3);
        this.f9000o.set(0, offlineMapProvince2);
        OfflineMapProvince offlineMapProvince3 = new OfflineMapProvince();
        offlineMapProvince3.setProvinceName("\u76f4\u8f96\u5e02");
        offlineMapProvince3.setCityList(arrayList);
        OfflineMapProvince offlineMapProvince4 = new OfflineMapProvince();
        offlineMapProvince4.setProvinceName("\u6e2f\u6fb3");
        offlineMapProvince4.setCityList(arrayList2);
        this.f9000o.add(offlineMapProvince4);
    }

    private void r() {
        AutoCompleteTextView autoCompleteTextView = this.f8994i;
        if (autoCompleteTextView == null || !autoCompleteTextView.isFocused()) {
            return;
        }
        this.f8994i.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) this.f10858a.getSystemService("input_method");
        if (inputMethodManager != null ? inputMethodManager.isActive() : false) {
            inputMethodManager.hideSoftInputFromWindow(this.f8994i.getWindowToken(), 2);
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
    }

    @Override // com.amap.api.offlineservice.a
    public final void c(View view) {
        try {
            int id = view.getId();
            if (id == 2131165205) {
                this.f10858a.closeScr();
            } else if (id == 2131165184) {
                if (this.f9006u) {
                    this.f8989d.setVisibility(8);
                    this.f8992g.setBackgroundResource(2130837508);
                    this.f9006u = false;
                    return;
                }
                this.f8989d.setVisibility(0);
                this.f8992g.setBackgroundResource(2130837504);
                this.f9006u = true;
            } else if (id == 2131165189) {
                if (this.f9005t) {
                    this.f9001p.c();
                    this.f8993h.setBackgroundResource(2130837508);
                    this.f9005t = false;
                    return;
                }
                this.f9001p.a();
                this.f8993h.setBackgroundResource(2130837504);
                this.f9005t = true;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.amap.api.offlineservice.a
    public final void e() {
        View d4 = w3.d(this.f10858a, 2130903040);
        DownLoadExpandListView downLoadExpandListView = (DownLoadExpandListView) d4.findViewById(2131165187);
        this.f8989d = downLoadExpandListView;
        downLoadExpandListView.setOnTouchListener(this);
        this.f8995j = (RelativeLayout) d4.findViewById(2131165184);
        this.f8992g = (ImageView) d4.findViewById(2131165186);
        this.f8995j.setOnClickListener(this.f10858a);
        this.f8996k = (RelativeLayout) d4.findViewById(2131165189);
        this.f8993h = (ImageView) d4.findViewById(2131165190);
        this.f8996k.setOnClickListener(this.f10858a);
        this.f8999n = (RelativeLayout) d4.findViewById(2131165188);
        ImageView imageView = (ImageView) this.f8988c.findViewById(2131165205);
        this.f8987b = imageView;
        imageView.setOnClickListener(this.f10858a);
        this.f8998m = (ImageView) this.f8988c.findViewById(2131165207);
        ImageView imageView2 = (ImageView) this.f8988c.findViewById(2131165209);
        this.f8997l = imageView2;
        imageView2.setOnClickListener(new a());
        this.f8988c.findViewById(2131165210).setOnTouchListener(this);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.f8988c.findViewById(2131165208);
        this.f8994i = autoCompleteTextView;
        autoCompleteTextView.addTextChangedListener(this);
        this.f8994i.setOnTouchListener(this);
        this.f8990e = (ListView) this.f8988c.findViewById(2131165212);
        ExpandableListView expandableListView = (ExpandableListView) this.f8988c.findViewById(2131165211);
        this.f8991f = expandableListView;
        expandableListView.addHeaderView(d4);
        this.f8991f.setOnTouchListener(this);
        this.f8991f.setOnScrollListener(this);
        try {
            OfflineMapManager offlineMapManager = new OfflineMapManager(this.f10858a, this);
            this.f9002q = offlineMapManager;
            offlineMapManager.setOnOfflineLoadedListener(this);
        } catch (Exception e4) {
            Log.e("OfflineMapPage", "e=".concat(String.valueOf(e4)));
        }
        q();
        n3 n3Var = new n3(this.f9000o, this.f9002q, this.f10858a);
        this.f9001p = n3Var;
        this.f8991f.setAdapter(n3Var);
        this.f8991f.setOnGroupCollapseListener(this.f9001p);
        this.f8991f.setOnGroupExpandListener(this.f9001p);
        this.f8991f.setGroupIndicator(null);
        if (this.f9005t) {
            this.f8993h.setBackgroundResource(2130837504);
            this.f8991f.setVisibility(0);
        } else {
            this.f8993h.setBackgroundResource(2130837508);
            this.f8991f.setVisibility(8);
        }
        if (this.f9006u) {
            this.f8992g.setBackgroundResource(2130837504);
            this.f8989d.setVisibility(0);
            return;
        }
        this.f8992g.setBackgroundResource(2130837508);
        this.f8989d.setVisibility(8);
    }

    @Override // com.amap.api.offlineservice.a
    public final boolean f() {
        try {
            if (this.f8990e.getVisibility() == 0) {
                this.f8994i.setText("");
                this.f8997l.setVisibility(8);
                k(false);
                return false;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return super.f();
    }

    @Override // com.amap.api.offlineservice.a
    public final RelativeLayout g() {
        if (this.f8988c == null) {
            this.f8988c = (RelativeLayout) w3.d(this.f10858a, 2130903044);
        }
        return this.f8988c;
    }

    @Override // com.amap.api.offlineservice.a
    public final void h() {
        this.f9002q.destroy();
    }

    public final void j(OfflineMapCity offlineMapCity) {
        try {
            if (this.f9009x == null) {
                this.f9009x = new p3(this.f10858a, this.f9002q);
            }
            this.f9009x.c(offlineMapCity.getState(), offlineMapCity.getCity());
            this.f9009x.show();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void k(boolean z3) {
        if (z3) {
            this.f8995j.setVisibility(8);
            this.f8996k.setVisibility(8);
            this.f8989d.setVisibility(8);
            this.f8991f.setVisibility(8);
            this.f8999n.setVisibility(8);
            this.f8990e.setVisibility(0);
            return;
        }
        this.f8995j.setVisibility(0);
        this.f8996k.setVisibility(0);
        this.f8999n.setVisibility(0);
        this.f8989d.setVisibility(this.f9006u ? 0 : 8);
        this.f8991f.setVisibility(this.f9005t ? 0 : 8);
        this.f8990e.setVisibility(8);
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onCheckUpdate(boolean z3, String str) {
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onDownload(int i4, int i5, String str) {
        if (i4 == 101) {
            try {
                Toast.makeText(this.f10858a, "\u7f51\u7edc\u5f02\u5e38", 0).show();
                this.f9002q.pause();
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        if (i4 == 2) {
            this.f9003r.b();
        }
        if (this.f9007v != i4) {
            n3 n3Var = this.f9001p;
            if (n3Var != null) {
                n3Var.notifyDataSetChanged();
            }
            m3 m3Var = this.f9003r;
            if (m3Var != null) {
                m3Var.notifyDataSetChanged();
            }
            o3 o3Var = this.f9004s;
            if (o3Var != null) {
                o3Var.notifyDataSetChanged();
            }
            this.f9007v = i4;
        } else if (System.currentTimeMillis() - this.f9008w > 1200) {
            if (this.f9010y) {
                this.f9003r.notifyDataSetChanged();
            }
            this.f9008w = System.currentTimeMillis();
        }
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onRemove(boolean z3, String str, String str2) {
        m3 m3Var = this.f9003r;
        if (m3Var != null) {
            m3Var.c();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i4, int i5, int i6) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i4) {
        if (i4 == 2) {
            this.f9010y = false;
        } else {
            this.f9010y = true;
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        if (TextUtils.isEmpty(charSequence)) {
            k(false);
            this.f8997l.setVisibility(8);
            return;
        }
        this.f8997l.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        List<OfflineMapProvince> list = this.f9000o;
        if (list != null && list.size() > 0) {
            ArrayList<OfflineMapCity> arrayList2 = new ArrayList();
            for (OfflineMapProvince offlineMapProvince : this.f9000o) {
                arrayList2.addAll(offlineMapProvince.getCityList());
            }
            for (OfflineMapCity offlineMapCity : arrayList2) {
                String city = offlineMapCity.getCity();
                String pinyin = offlineMapCity.getPinyin();
                String jianpin = offlineMapCity.getJianpin();
                if (charSequence.length() == 1) {
                    if (jianpin.startsWith(String.valueOf(charSequence))) {
                        arrayList.add(offlineMapCity);
                    }
                } else if (jianpin.startsWith(String.valueOf(charSequence)) || pinyin.startsWith(String.valueOf(charSequence)) || city.startsWith(String.valueOf(charSequence))) {
                    arrayList.add(offlineMapCity);
                }
            }
        }
        if (arrayList.size() > 0) {
            k(true);
            Collections.sort(arrayList, new b());
            o3 o3Var = this.f9004s;
            if (o3Var != null) {
                o3Var.b(arrayList);
                this.f9004s.notifyDataSetChanged();
                return;
            }
            return;
        }
        Toast.makeText(this.f10858a, "\u672a\u627e\u5230\u76f8\u5173\u57ce\u5e02", 0).show();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        r();
        if (view.getId() == 2131165208) {
            n();
            return false;
        }
        return false;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineLoadedListener
    public final void onVerifyComplete() {
        o();
        p();
    }
}
