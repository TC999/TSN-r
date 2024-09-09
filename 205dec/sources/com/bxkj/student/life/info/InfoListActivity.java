package com.bxkj.student.life.info;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;
import s0.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class InfoListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f21368k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f21369l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f21370m;

    /* renamed from: n  reason: collision with root package name */
    private TabLayout f21371n;

    /* renamed from: s  reason: collision with root package name */
    private List<Map<String, Object>> f21376s;

    /* renamed from: t  reason: collision with root package name */
    private MultiItemCommonAdapter<Map<String, Object>> f21377t;

    /* renamed from: o  reason: collision with root package name */
    private List<Map<String, Object>> f21372o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private int f21373p = 10;

    /* renamed from: q  reason: collision with root package name */
    private int f21374q = 1;

    /* renamed from: r  reason: collision with root package name */
    private int f21375r = 0;

    /* renamed from: u  reason: collision with root package name */
    private boolean f21378u = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements e {
        a() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            InfoListActivity.this.f21374q = 1;
            if (InfoListActivity.this.f21378u) {
                InfoListActivity.this.x0();
            } else {
                InfoListActivity.this.y0();
            }
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = InfoListActivity.this.f21375r / InfoListActivity.this.f21373p;
            int i5 = InfoListActivity.this.f21374q;
            if (InfoListActivity.this.f21375r % InfoListActivity.this.f21373p != 0) {
                i4++;
            }
            if (i5 >= i4) {
                InfoListActivity.this.f21368k.h();
                InfoListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            InfoListActivity.o0(InfoListActivity.this);
            if (InfoListActivity.this.f21378u) {
                InfoListActivity.this.x0();
            } else {
                InfoListActivity.this.y0();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements TabLayout.OnTabSelectedListener {
        b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            InfoListActivity.this.f21378u = true;
            InfoListActivity.this.f21368k.a0();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (InfoListActivity.this.f21368k != null && InfoListActivity.this.f21368k.S()) {
                InfoListActivity.this.f21368k.y();
            }
            if (InfoListActivity.this.f21368k == null || !InfoListActivity.this.f21368k.z()) {
                return;
            }
            InfoListActivity.this.f21368k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InfoListActivity.this.f21376s = JsonParse.getList(data, "typeList");
            InfoListActivity.this.A0();
            InfoListActivity.this.f21375r = JsonParse.getInt(data, "total");
            if (InfoListActivity.this.f21374q == 1) {
                InfoListActivity.this.f21372o.clear();
            }
            InfoListActivity.this.f21372o.addAll(JsonParse.getList(data, "inforList"));
            InfoListActivity.this.f21377t.g(InfoListActivity.this.f21372o);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (InfoListActivity.this.f21368k != null && InfoListActivity.this.f21368k.S()) {
                InfoListActivity.this.f21368k.y();
            }
            if (InfoListActivity.this.f21368k == null || !InfoListActivity.this.f21368k.z()) {
                return;
            }
            InfoListActivity.this.f21368k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InfoListActivity.this.f21375r = JsonParse.getInt(data, "total");
            if (InfoListActivity.this.f21374q == 1) {
                InfoListActivity.this.f21372o.clear();
            }
            InfoListActivity.this.f21372o.addAll(JsonParse.getList(data, "data"));
            InfoListActivity.this.f21377t.g(InfoListActivity.this.f21372o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        this.f21371n.removeAllTabs();
        List<Map<String, Object>> list = this.f21376s;
        if (list == null) {
            return;
        }
        for (Map<String, Object> map : list) {
            TabLayout tabLayout = this.f21371n;
            tabLayout.addTab(tabLayout.newTab().setText(JsonParse.getString(map, "inforType")));
        }
    }

    static /* synthetic */ int o0(InfoListActivity infoListActivity) {
        int i4 = infoListActivity.f21374q;
        infoListActivity.f21374q = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((q.c) Http.getApiService(q.c.class)).b(Integer.valueOf(this.f21373p), Integer.valueOf(this.f21374q), JsonParse.getString(this.f21376s.get(this.f21371n.getSelectedTabPosition()), "id"))).setDataListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((q.c) Http.getApiService(q.c.class)).c(Integer.valueOf(this.f21373p), Integer.valueOf(this.f21374q))).setDataListener(new c());
    }

    private void z0() {
        this.f21368k.n1(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21371n.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427413;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f21369l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        InfoAdapter infoAdapter = new InfoAdapter(this.f1656h, this.f21372o);
        this.f21377t = infoAdapter;
        this.f21369l.setAdapter(infoAdapter);
        this.f21369l.setEmptyView(this.f21370m);
        z0();
        this.f21368k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle(getString(2131820602));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21368k = (SmartRefreshLayout) findViewById(2131232483);
        this.f21369l = (EmptyRecyclerView) findViewById(2131232545);
        this.f21370m = (TextView) findViewById(2131232952);
        this.f21371n = (TabLayout) findViewById(2131232711);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
