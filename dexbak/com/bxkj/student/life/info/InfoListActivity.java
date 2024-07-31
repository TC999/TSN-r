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
import com.bxkj.student.C4215R;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p635q.InfoApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class InfoListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f18030k;

    /* renamed from: l */
    private EmptyRecyclerView f18031l;

    /* renamed from: m */
    private TextView f18032m;

    /* renamed from: n */
    private TabLayout f18033n;

    /* renamed from: s */
    private List<Map<String, Object>> f18038s;

    /* renamed from: t */
    private MultiItemCommonAdapter<Map<String, Object>> f18039t;

    /* renamed from: o */
    private List<Map<String, Object>> f18034o = new ArrayList();

    /* renamed from: p */
    private int f18035p = 10;

    /* renamed from: q */
    private int f18036q = 1;

    /* renamed from: r */
    private int f18037r = 0;

    /* renamed from: u */
    private boolean f18040u = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.info.InfoListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4886a implements OnRefreshLoadmoreListener {
        C4886a() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            InfoListActivity.this.f18036q = 1;
            if (InfoListActivity.this.f18040u) {
                InfoListActivity.this.m41099x0();
            } else {
                InfoListActivity.this.m41098y0();
            }
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = InfoListActivity.this.f18037r / InfoListActivity.this.f18035p;
            int i2 = InfoListActivity.this.f18036q;
            if (InfoListActivity.this.f18037r % InfoListActivity.this.f18035p != 0) {
                i++;
            }
            if (i2 >= i) {
                InfoListActivity.this.f18030k.mo2041g();
                InfoListActivity.this.m57919h0("没有了");
                return;
            }
            InfoListActivity.m41108o0(InfoListActivity.this);
            if (InfoListActivity.this.f18040u) {
                InfoListActivity.this.m41099x0();
            } else {
                InfoListActivity.this.m41098y0();
            }
        }
    }

    /* renamed from: com.bxkj.student.life.info.InfoListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4887b implements TabLayout.OnTabSelectedListener {
        C4887b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            InfoListActivity.this.f18040u = true;
            InfoListActivity.this.f18030k.mo2052a0();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.info.InfoListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4888c extends HttpCallBack {
        C4888c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (InfoListActivity.this.f18030k != null && InfoListActivity.this.f18030k.mo2061S()) {
                InfoListActivity.this.f18030k.mo2078B();
            }
            if (InfoListActivity.this.f18030k == null || !InfoListActivity.this.f18030k.mo2015z()) {
                return;
            }
            InfoListActivity.this.f18030k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InfoListActivity.this.f18038s = JsonParse.getList(data, "typeList");
            InfoListActivity.this.m41115A0();
            InfoListActivity.this.f18037r = JsonParse.getInt(data, "total");
            if (InfoListActivity.this.f18036q == 1) {
                InfoListActivity.this.f18034o.clear();
            }
            InfoListActivity.this.f18034o.addAll(JsonParse.getList(data, "inforList"));
            InfoListActivity.this.f18039t.m57836g(InfoListActivity.this.f18034o);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.info.InfoListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4889d extends HttpCallBack {
        C4889d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (InfoListActivity.this.f18030k != null && InfoListActivity.this.f18030k.mo2061S()) {
                InfoListActivity.this.f18030k.mo2078B();
            }
            if (InfoListActivity.this.f18030k == null || !InfoListActivity.this.f18030k.mo2015z()) {
                return;
            }
            InfoListActivity.this.f18030k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InfoListActivity.this.f18037r = JsonParse.getInt(data, "total");
            if (InfoListActivity.this.f18036q == 1) {
                InfoListActivity.this.f18034o.clear();
            }
            InfoListActivity.this.f18034o.addAll(JsonParse.getList(data, "data"));
            InfoListActivity.this.f18039t.m57836g(InfoListActivity.this.f18034o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public void m41115A0() {
        this.f18033n.removeAllTabs();
        List<Map<String, Object>> list = this.f18038s;
        if (list == null) {
            return;
        }
        for (Map<String, Object> map : list) {
            TabLayout tabLayout = this.f18033n;
            tabLayout.addTab(tabLayout.newTab().setText(JsonParse.getString(map, "inforType")));
        }
    }

    /* renamed from: o0 */
    static /* synthetic */ int m41108o0(InfoListActivity infoListActivity) {
        int i = infoListActivity.f18036q;
        infoListActivity.f18036q = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public void m41099x0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((InfoApiService) Http.getApiService(InfoApiService.class)).m2303b(Integer.valueOf(this.f18035p), Integer.valueOf(this.f18036q), JsonParse.getString(this.f18038s.get(this.f18033n.getSelectedTabPosition()), "id"))).setDataListener(new C4889d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public void m41098y0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((InfoApiService) Http.getApiService(InfoApiService.class)).m2302c(Integer.valueOf(this.f18035p), Integer.valueOf(this.f18036q))).setDataListener(new C4888c());
    }

    /* renamed from: z0 */
    private void m41097z0() {
        this.f18030k.mo2019v(new C4886a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18033n.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new C4887b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_info_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f18031l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        InfoAdapter infoAdapter = new InfoAdapter(this.f1669h, this.f18034o);
        this.f18039t = infoAdapter;
        this.f18031l.setAdapter(infoAdapter);
        this.f18031l.setEmptyView(this.f18032m);
        m41097z0();
        this.f18030k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle(getString(C4215R.C4224string.app_info));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18030k = (SmartRefreshLayout) findViewById(2131232483);
        this.f18031l = (EmptyRecyclerView) findViewById(C4215R.C4219id.rv_goods_list);
        this.f18032m = (TextView) findViewById(2131232952);
        this.f18033n = (TabLayout) findViewById(C4215R.C4219id.f16009tb);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
