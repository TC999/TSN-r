package com.amap.api.col.p0463l;

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
import com.amap.api.offlineservice.ServiceModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.amap.api.col.3l.t3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class OfflineMapPage extends ServiceModule implements TextWatcher, View.OnTouchListener, AbsListView.OnScrollListener, OfflineMapManager.OfflineLoadedListener, OfflineMapManager.OfflineMapDownloadListener {

    /* renamed from: b */
    private ImageView f5344b;

    /* renamed from: c */
    private RelativeLayout f5345c;

    /* renamed from: d */
    private DownLoadExpandListView f5346d;

    /* renamed from: e */
    private ListView f5347e;

    /* renamed from: f */
    private ExpandableListView f5348f;

    /* renamed from: g */
    private ImageView f5349g;

    /* renamed from: h */
    private ImageView f5350h;

    /* renamed from: i */
    private AutoCompleteTextView f5351i;

    /* renamed from: j */
    private RelativeLayout f5352j;

    /* renamed from: k */
    private RelativeLayout f5353k;

    /* renamed from: l */
    private ImageView f5354l;

    /* renamed from: m */
    private ImageView f5355m;

    /* renamed from: n */
    private RelativeLayout f5356n;

    /* renamed from: p */
    private OfflineListAdapter f5358p;

    /* renamed from: r */
    private OfflineDownloadedAdapter f5360r;

    /* renamed from: s */
    private SearchListAdapter f5361s;

    /* renamed from: x */
    private BottomDialog f5366x;

    /* renamed from: o */
    private List<OfflineMapProvince> f5357o = new ArrayList();

    /* renamed from: q */
    private OfflineMapManager f5359q = null;

    /* renamed from: t */
    private boolean f5362t = true;

    /* renamed from: u */
    private boolean f5363u = true;

    /* renamed from: v */
    private int f5364v = -1;

    /* renamed from: w */
    private long f5365w = 0;

    /* renamed from: y */
    private boolean f5367y = true;

    /* compiled from: OfflineMapPage.java */
    /* renamed from: com.amap.api.col.3l.t3$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class View$OnClickListenerC1945a implements View.OnClickListener {
        View$OnClickListenerC1945a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                OfflineMapPage.this.f5351i.setText("");
                OfflineMapPage.this.f5354l.setVisibility(8);
                OfflineMapPage.this.m53886k(false);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) OfflineMapPage.this.f5355m.getLayoutParams();
                layoutParams.leftMargin = OfflineMapPage.this.m51969a(95.0f);
                OfflineMapPage.this.f5355m.setLayoutParams(layoutParams);
                OfflineMapPage.this.f5351i.setPadding(OfflineMapPage.this.m51969a(105.0f), 0, 0, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: OfflineMapPage.java */
    /* renamed from: com.amap.api.col.3l.t3$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1946b implements Comparator<OfflineMapCity> {
        C1946b() {
        }

        /* renamed from: a */
        private static int m53878a(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
            char[] charArray = offlineMapCity.getJianpin().toCharArray();
            char[] charArray2 = offlineMapCity2.getJianpin().toCharArray();
            return (charArray[0] >= charArray2[0] && charArray[1] >= charArray2[1]) ? 0 : 1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
            return m53878a(offlineMapCity, offlineMapCity2);
        }
    }

    /* renamed from: n */
    private void m53883n() {
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f5355m.getLayoutParams();
            layoutParams.leftMargin = m51969a(18.0f);
            this.f5355m.setLayoutParams(layoutParams);
            this.f5351i.setPadding(m51969a(30.0f), 0, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: o */
    private void m53882o() {
        m53880q();
        SearchListAdapter searchListAdapter = new SearchListAdapter(this.f5359q, this.f7160a);
        this.f5361s = searchListAdapter;
        this.f5347e.setAdapter((ListAdapter) searchListAdapter);
    }

    /* renamed from: p */
    private void m53881p() {
        OfflineDownloadedAdapter offlineDownloadedAdapter = new OfflineDownloadedAdapter(this.f7160a, this, this.f5359q, this.f5357o);
        this.f5360r = offlineDownloadedAdapter;
        this.f5346d.setAdapter(offlineDownloadedAdapter);
        this.f5360r.notifyDataSetChanged();
    }

    /* renamed from: q */
    private void m53880q() {
        ArrayList<OfflineMapProvince> offlineMapProvinceList = this.f5359q.getOfflineMapProvinceList();
        this.f5357o.clear();
        this.f5357o.add(null);
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList2 = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList3 = new ArrayList<>();
        for (int i = 0; i < offlineMapProvinceList.size(); i++) {
            OfflineMapProvince offlineMapProvince = offlineMapProvinceList.get(i);
            if (offlineMapProvince.getCityList().size() != 1) {
                this.f5357o.add(i + 1, offlineMapProvince);
            } else {
                String provinceName = offlineMapProvince.getProvinceName();
                if (provinceName.contains("香港")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("澳门")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("全国概要图")) {
                    arrayList3.addAll(0, offlineMapProvince.getCityList());
                } else {
                    arrayList3.addAll(offlineMapProvince.getCityList());
                }
            }
        }
        OfflineMapProvince offlineMapProvince2 = new OfflineMapProvince();
        offlineMapProvince2.setProvinceName("基本功能包+直辖市");
        offlineMapProvince2.setCityList(arrayList3);
        this.f5357o.set(0, offlineMapProvince2);
        OfflineMapProvince offlineMapProvince3 = new OfflineMapProvince();
        offlineMapProvince3.setProvinceName("直辖市");
        offlineMapProvince3.setCityList(arrayList);
        OfflineMapProvince offlineMapProvince4 = new OfflineMapProvince();
        offlineMapProvince4.setProvinceName("港澳");
        offlineMapProvince4.setCityList(arrayList2);
        this.f5357o.add(offlineMapProvince4);
    }

    /* renamed from: r */
    private void m53879r() {
        AutoCompleteTextView autoCompleteTextView = this.f5351i;
        if (autoCompleteTextView == null || !autoCompleteTextView.isFocused()) {
            return;
        }
        this.f5351i.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) this.f7160a.getSystemService("input_method");
        if (inputMethodManager != null ? inputMethodManager.isActive() : false) {
            inputMethodManager.hideSoftInputFromWindow(this.f5351i.getWindowToken(), 2);
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // com.amap.api.offlineservice.ServiceModule
    /* renamed from: c */
    public final void mo51967c(View view) {
        try {
            int id = view.getId();
            if (id == 2131165205) {
                this.f7160a.closeScr();
            } else if (id == 2131165184) {
                if (this.f5363u) {
                    this.f5346d.setVisibility(8);
                    this.f5349g.setBackgroundResource(2130837508);
                    this.f5363u = false;
                    return;
                }
                this.f5346d.setVisibility(0);
                this.f5349g.setBackgroundResource(2130837504);
                this.f5363u = true;
            } else if (id == 2131165189) {
                if (this.f5362t) {
                    this.f5358p.m54443c();
                    this.f5350h.setBackgroundResource(2130837508);
                    this.f5362t = false;
                    return;
                }
                this.f5358p.m54445a();
                this.f5350h.setBackgroundResource(2130837504);
                this.f5362t = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.offlineservice.ServiceModule
    /* renamed from: e */
    public final void mo51965e() {
        View m53597d = ServiceUtils.m53597d(this.f7160a, 2130903040);
        DownLoadExpandListView downLoadExpandListView = (DownLoadExpandListView) m53597d.findViewById(2131165187);
        this.f5346d = downLoadExpandListView;
        downLoadExpandListView.setOnTouchListener(this);
        this.f5352j = (RelativeLayout) m53597d.findViewById(2131165184);
        this.f5349g = (ImageView) m53597d.findViewById(2131165186);
        this.f5352j.setOnClickListener(this.f7160a);
        this.f5353k = (RelativeLayout) m53597d.findViewById(2131165189);
        this.f5350h = (ImageView) m53597d.findViewById(2131165190);
        this.f5353k.setOnClickListener(this.f7160a);
        this.f5356n = (RelativeLayout) m53597d.findViewById(2131165188);
        ImageView imageView = (ImageView) this.f5345c.findViewById(2131165205);
        this.f5344b = imageView;
        imageView.setOnClickListener(this.f7160a);
        this.f5355m = (ImageView) this.f5345c.findViewById(2131165207);
        ImageView imageView2 = (ImageView) this.f5345c.findViewById(2131165209);
        this.f5354l = imageView2;
        imageView2.setOnClickListener(new View$OnClickListenerC1945a());
        this.f5345c.findViewById(2131165210).setOnTouchListener(this);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.f5345c.findViewById(2131165208);
        this.f5351i = autoCompleteTextView;
        autoCompleteTextView.addTextChangedListener(this);
        this.f5351i.setOnTouchListener(this);
        this.f5347e = (ListView) this.f5345c.findViewById(2131165212);
        ExpandableListView expandableListView = (ExpandableListView) this.f5345c.findViewById(2131165211);
        this.f5348f = expandableListView;
        expandableListView.addHeaderView(m53597d);
        this.f5348f.setOnTouchListener(this);
        this.f5348f.setOnScrollListener(this);
        try {
            OfflineMapManager offlineMapManager = new OfflineMapManager(this.f7160a, this);
            this.f5359q = offlineMapManager;
            offlineMapManager.setOnOfflineLoadedListener(this);
        } catch (Exception e) {
            Log.e("OfflineMapPage", "e=".concat(String.valueOf(e)));
        }
        m53880q();
        OfflineListAdapter offlineListAdapter = new OfflineListAdapter(this.f5357o, this.f5359q, this.f7160a);
        this.f5358p = offlineListAdapter;
        this.f5348f.setAdapter(offlineListAdapter);
        this.f5348f.setOnGroupCollapseListener(this.f5358p);
        this.f5348f.setOnGroupExpandListener(this.f5358p);
        this.f5348f.setGroupIndicator(null);
        if (this.f5362t) {
            this.f5350h.setBackgroundResource(2130837504);
            this.f5348f.setVisibility(0);
        } else {
            this.f5350h.setBackgroundResource(2130837508);
            this.f5348f.setVisibility(8);
        }
        if (this.f5363u) {
            this.f5349g.setBackgroundResource(2130837504);
            this.f5346d.setVisibility(0);
            return;
        }
        this.f5349g.setBackgroundResource(2130837508);
        this.f5346d.setVisibility(8);
    }

    @Override // com.amap.api.offlineservice.ServiceModule
    /* renamed from: f */
    public final boolean mo51964f() {
        try {
            if (this.f5347e.getVisibility() == 0) {
                this.f5351i.setText("");
                this.f5354l.setVisibility(8);
                m53886k(false);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.mo51964f();
    }

    @Override // com.amap.api.offlineservice.ServiceModule
    /* renamed from: g */
    public final RelativeLayout mo51963g() {
        if (this.f5345c == null) {
            this.f5345c = (RelativeLayout) ServiceUtils.m53597d(this.f7160a, 2130903044);
        }
        return this.f5345c;
    }

    @Override // com.amap.api.offlineservice.ServiceModule
    /* renamed from: h */
    public final void mo51962h() {
        this.f5359q.destroy();
    }

    /* renamed from: j */
    public final void m53887j(OfflineMapCity offlineMapCity) {
        try {
            if (this.f5366x == null) {
                this.f5366x = new BottomDialog(this.f7160a, this.f5359q);
            }
            this.f5366x.m54211c(offlineMapCity.getState(), offlineMapCity.getCity());
            this.f5366x.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    public final void m53886k(boolean z) {
        if (z) {
            this.f5352j.setVisibility(8);
            this.f5353k.setVisibility(8);
            this.f5346d.setVisibility(8);
            this.f5348f.setVisibility(8);
            this.f5356n.setVisibility(8);
            this.f5347e.setVisibility(0);
            return;
        }
        this.f5352j.setVisibility(0);
        this.f5353k.setVisibility(0);
        this.f5356n.setVisibility(0);
        this.f5346d.setVisibility(this.f5363u ? 0 : 8);
        this.f5348f.setVisibility(this.f5362t ? 0 : 8);
        this.f5347e.setVisibility(8);
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onCheckUpdate(boolean z, String str) {
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onDownload(int i, int i2, String str) {
        if (i == 101) {
            try {
                Toast.makeText(this.f7160a, "网络异常", 0).show();
                this.f5359q.pause();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (i == 2) {
            this.f5360r.m54529b();
        }
        if (this.f5364v != i) {
            OfflineListAdapter offlineListAdapter = this.f5358p;
            if (offlineListAdapter != null) {
                offlineListAdapter.notifyDataSetChanged();
            }
            OfflineDownloadedAdapter offlineDownloadedAdapter = this.f5360r;
            if (offlineDownloadedAdapter != null) {
                offlineDownloadedAdapter.notifyDataSetChanged();
            }
            SearchListAdapter searchListAdapter = this.f5361s;
            if (searchListAdapter != null) {
                searchListAdapter.notifyDataSetChanged();
            }
            this.f5364v = i;
        } else if (System.currentTimeMillis() - this.f5365w > 1200) {
            if (this.f5367y) {
                this.f5360r.notifyDataSetChanged();
            }
            this.f5365w = System.currentTimeMillis();
        }
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onRemove(boolean z, String str, String str2) {
        OfflineDownloadedAdapter offlineDownloadedAdapter = this.f5360r;
        if (offlineDownloadedAdapter != null) {
            offlineDownloadedAdapter.m54528c();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.f5367y = false;
        } else {
            this.f5367y = true;
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            m53886k(false);
            this.f5354l.setVisibility(8);
            return;
        }
        this.f5354l.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        List<OfflineMapProvince> list = this.f5357o;
        if (list != null && list.size() > 0) {
            ArrayList<OfflineMapCity> arrayList2 = new ArrayList();
            for (OfflineMapProvince offlineMapProvince : this.f5357o) {
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
            m53886k(true);
            Collections.sort(arrayList, new C1946b());
            SearchListAdapter searchListAdapter = this.f5361s;
            if (searchListAdapter != null) {
                searchListAdapter.m54401b(arrayList);
                this.f5361s.notifyDataSetChanged();
                return;
            }
            return;
        }
        Toast.makeText(this.f7160a, "未找到相关城市", 0).show();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        m53879r();
        if (view.getId() == 2131165208) {
            m53883n();
            return false;
        }
        return false;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineLoadedListener
    public final void onVerifyComplete() {
        m53882o();
        m53881p();
    }
}
