package com.bxkj.competition.score.student;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.util.UniversalItemDecoration;
import com.bxkj.base.view.MyOnScrollListener;
import com.bxkj.base.view.ObservableHorizontalScrollView;
import com.bxkj.competition.R;
import com.google.android.material.tabs.TabLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class StudentScoreListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private String f19009k;

    /* renamed from: l  reason: collision with root package name */
    private ObservableHorizontalScrollView f19010l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f19011m;

    /* renamed from: n  reason: collision with root package name */
    private TabLayout f19012n;

    /* renamed from: o  reason: collision with root package name */
    private RecyclerView f19013o;

    /* renamed from: p  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19014p;

    /* renamed from: r  reason: collision with root package name */
    private RecyclerView f19016r;

    /* renamed from: s  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19017s;

    /* renamed from: u  reason: collision with root package name */
    private List<Map<String, Object>> f19019u;

    /* renamed from: q  reason: collision with root package name */
    private List<Map<String, Object>> f19015q = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    private List<Map<String, Object>> f19018t = new ArrayList();

    /* renamed from: v  reason: collision with root package name */
    private final RecyclerView.OnScrollListener f19020v = new k();

    /* renamed from: w  reason: collision with root package name */
    private final RecyclerView.OnScrollListener f19021w = new l();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements RecyclerView.OnItemTouchListener {

        /* renamed from: a  reason: collision with root package name */
        private int f19022a;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e4) {
            if (rv.getScrollState() == 0) {
                onTouchEvent(rv, e4);
                return false;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv, MotionEvent e4) {
            if (e4.getAction() == 0 && StudentScoreListActivity.this.f19016r.getScrollState() == 0) {
                this.f19022a = rv.getScrollY();
                rv.addOnScrollListener(StudentScoreListActivity.this.f19020v);
            } else if (e4.getAction() == 1 && rv.getScrollY() == this.f19022a) {
                rv.removeOnScrollListener(StudentScoreListActivity.this.f19020v);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements RecyclerView.OnItemTouchListener {

        /* renamed from: a  reason: collision with root package name */
        private int f19024a;

        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e4) {
            if (rv.getScrollState() == 0) {
                onTouchEvent(rv, e4);
                return false;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv, MotionEvent e4) {
            if (e4.getAction() == 0 && StudentScoreListActivity.this.f19016r.getScrollState() == 0) {
                this.f19024a = rv.getScrollY();
                rv.addOnScrollListener(StudentScoreListActivity.this.f19021w);
            } else if (e4.getAction() == 1 && rv.getScrollY() == this.f19024a) {
                rv.removeOnScrollListener(StudentScoreListActivity.this.f19021w);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements ObservableHorizontalScrollView.a {
        c() {
        }

        @Override // com.bxkj.base.view.ObservableHorizontalScrollView.a
        public void a(ObservableHorizontalScrollView scrollView, int x3, int y3, int oldx, int oldy) {
            StudentScoreListActivity.this.f19016r.removeOnScrollListener(StudentScoreListActivity.this.f19020v);
            StudentScoreListActivity.this.f19016r.removeOnScrollListener(StudentScoreListActivity.this.f19021w);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends CommonAdapter<Map<String, Object>> {
        d(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_score, JsonParse.getString(stringObjectMap, "name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends CommonAdapter<Map<String, Object>> {
        e(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_score, JsonParse.getString(stringObjectMap, JsonParse.getString((Map) StudentScoreListActivity.this.f19019u.get(holder.f() % StudentScoreListActivity.this.f19019u.size()), DomainCampaignEx.LOOPBACK_KEY)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f extends UniversalItemDecoration {
        f() {
        }

        @Override // com.bxkj.base.util.UniversalItemDecoration
        public UniversalItemDecoration.b a(int position) {
            UniversalItemDecoration.a aVar = new UniversalItemDecoration.a();
            aVar.f18346d = u.a(1.0f, ((BaseActivity) StudentScoreListActivity.this).f1656h);
            aVar.f18342f = R.color.cardDivider;
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class g extends UniversalItemDecoration {
        g() {
        }

        @Override // com.bxkj.base.util.UniversalItemDecoration
        public UniversalItemDecoration.b a(int position) {
            UniversalItemDecoration.a aVar = new UniversalItemDecoration.a();
            int a4 = u.a(1.0f, ((BaseActivity) StudentScoreListActivity.this).f1656h);
            aVar.f18346d = a4;
            aVar.f18344b = a4;
            aVar.f18342f = R.color.cardDivider;
            return aVar;
        }

        public boolean c(int rowNum, int index) {
            return index % rowNum == 0;
        }

        public boolean d(int rowNum, int index) {
            return index % rowNum == rowNum - 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class h extends HttpCallBack {
        h() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) StudentScoreListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i4 = JsonParse.getInt(data, "data");
            for (int i5 = 1; i5 <= i4; i5++) {
                TabLayout tabLayout = StudentScoreListActivity.this.f19012n;
                TabLayout.Tab newTab = StudentScoreListActivity.this.f19012n.newTab();
                tabLayout.addTab(newTab.setText("\u7b2c" + i5 + "\u7ec4"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class i extends HttpCallBack {
        i() {
        }

        private void a() {
            StudentScoreListActivity.this.f19015q.clear();
            StudentScoreListActivity.this.f19014p.g(StudentScoreListActivity.this.f19015q);
            StudentScoreListActivity.this.f19018t.clear();
            StudentScoreListActivity.this.f19017s.g(StudentScoreListActivity.this.f19018t);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            a();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            a();
            new iOSOneButtonDialog(((BaseActivity) StudentScoreListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            StudentScoreListActivity.this.f19015q = JsonParse.getList(data, "data");
            StudentScoreListActivity.this.f19014p.g(StudentScoreListActivity.this.f19015q);
            StudentScoreListActivity.this.f19018t.clear();
            for (Map map : StudentScoreListActivity.this.f19015q) {
                for (Map map2 : StudentScoreListActivity.this.f19019u) {
                    String string = JsonParse.getString(map2, DomainCampaignEx.LOOPBACK_KEY);
                    String string2 = JsonParse.getString(map, string);
                    HashMap hashMap = new HashMap(2);
                    hashMap.put(string, string2);
                    StudentScoreListActivity.this.f19018t.add(hashMap);
                }
            }
            StudentScoreListActivity.this.f19017s.g(StudentScoreListActivity.this.f19018t);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class j implements TabLayout.OnTabSelectedListener {
        j() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            StudentScoreListActivity.this.z0();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class k extends MyOnScrollListener {
        k() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            StudentScoreListActivity.this.f19016r.scrollBy(dx, dy);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class l extends MyOnScrollListener {
        l() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            StudentScoreListActivity.this.f19013o.scrollBy(dx, dy);
        }
    }

    private void A0() {
        this.f19013o.setLayoutManager(new LinearLayoutManager(this.f1656h));
        Context context = this.f1656h;
        int i4 = R.layout.item_score;
        d dVar = new d(context, i4, this.f19015q);
        this.f19014p = dVar;
        this.f19013o.setAdapter(dVar);
        this.f19016r.setLayoutManager(new GridLayoutManager(this.f1656h, this.f19019u.size()));
        e eVar = new e(this.f1656h, i4, this.f19018t);
        this.f19017s = eVar;
        this.f19016r.setAdapter(eVar);
        this.f19013o.addItemDecoration(new f());
        this.f19016r.addItemDecoration(new g());
    }

    private void B0() {
        this.f19019u = new ArrayList();
        new HashMap(2);
        HashMap hashMap = new HashMap(2);
        hashMap.put("name", "\u9053\u6b21");
        hashMap.put(DomainCampaignEx.LOOPBACK_KEY, "passNum");
        this.f19019u.add(hashMap);
        HashMap hashMap2 = new HashMap(2);
        hashMap2.put("name", "\u53f7\u7801\u7c3f");
        hashMap2.put(DomainCampaignEx.LOOPBACK_KEY, "num");
        this.f19019u.add(hashMap2);
        HashMap hashMap3 = new HashMap(2);
        hashMap3.put("name", "\u5355\u4f4d");
        hashMap3.put(DomainCampaignEx.LOOPBACK_KEY, "areaName");
        this.f19019u.add(hashMap3);
        HashMap hashMap4 = new HashMap(2);
        hashMap4.put("name", "\u68c0\u5f55");
        hashMap4.put(DomainCampaignEx.LOOPBACK_KEY, "stateName");
        this.f19019u.add(hashMap4);
        HashMap hashMap5 = new HashMap(2);
        hashMap5.put("name", "\u8d77\u70b9");
        hashMap5.put(DomainCampaignEx.LOOPBACK_KEY, CampaignEx.JSON_NATIVE_VIDEO_START);
        this.f19019u.add(hashMap5);
        HashMap hashMap6 = new HashMap(2);
        hashMap6.put("name", "\u68c0\u67e5");
        hashMap6.put(DomainCampaignEx.LOOPBACK_KEY, "check");
        this.f19019u.add(hashMap6);
        HashMap hashMap7 = new HashMap(2);
        hashMap7.put("name", "\u540d\u6b21");
        hashMap7.put(DomainCampaignEx.LOOPBACK_KEY, "rank");
        this.f19019u.add(hashMap7);
        HashMap hashMap8 = new HashMap(2);
        hashMap8.put("name", "\u6210\u7ee9");
        hashMap8.put(DomainCampaignEx.LOOPBACK_KEY, "time");
        this.f19019u.add(hashMap8);
        HashMap hashMap9 = new HashMap(2);
        hashMap9.put("name", "\u5907\u6ce8");
        hashMap9.put(DomainCampaignEx.LOOPBACK_KEY, "memo");
        this.f19019u.add(hashMap9);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        for (Map<String, Object> map : this.f19019u) {
            View inflate = LayoutInflater.from(this.f1656h).inflate(R.layout.item_score, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_score);
            textView.setText(JsonParse.getString(map, "name"));
            textView.setTag(JsonParse.getString(map, DomainCampaignEx.LOOPBACK_KEY));
            this.f19011m.addView(inflate, layoutParams);
        }
    }

    private void C0() {
        this.f19013o.addOnItemTouchListener(new a());
        this.f19016r.addOnItemTouchListener(new b());
        this.f19010l.setScrollViewListener(new c());
    }

    private void y0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).k(this.f19009k)).setDataListener(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).n(this.f19009k, this.f19012n.getSelectedTabPosition() + 1)).setDataListener(new i());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19012n.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new j());
        C0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_student_score_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("scheduleId")) {
            this.f19009k = getIntent().getStringExtra("scheduleId");
        }
        B0();
        A0();
        y0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u67e5\u770b\u6210\u7ee9");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19012n = (TabLayout) findViewById(R.id.tb_group);
        this.f19011m = (LinearLayout) findViewById(R.id.ll_top);
        this.f19013o = (RecyclerView) findViewById(R.id.rv_student);
        this.f19016r = (RecyclerView) findViewById(R.id.rv_score);
        this.f19010l = (ObservableHorizontalScrollView) findViewById(R.id.sv_room);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
