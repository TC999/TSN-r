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
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.util.UniversalItemDecoration;
import com.bxkj.base.view.MyOnScrollListener;
import com.bxkj.base.view.ObservableHorizontalScrollView;
import com.bxkj.competition.C4017R;
import com.bxkj.competition.CompeApiService;
import com.bxkj.competition.score.teacher.ScoreMenu;
import com.google.android.material.tabs.TabLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class StudentScoreListActivity extends BaseActivity {

    /* renamed from: k */
    private String f15465k;

    /* renamed from: l */
    private ObservableHorizontalScrollView f15466l;

    /* renamed from: m */
    private LinearLayout f15467m;

    /* renamed from: n */
    private TabLayout f15468n;

    /* renamed from: o */
    private RecyclerView f15469o;

    /* renamed from: p */
    private CommonAdapter<Map<String, Object>> f15470p;

    /* renamed from: r */
    private RecyclerView f15472r;

    /* renamed from: s */
    private CommonAdapter<Map<String, Object>> f15473s;

    /* renamed from: u */
    private List<Map<String, Object>> f15475u;

    /* renamed from: q */
    private List<Map<String, Object>> f15471q = new ArrayList();

    /* renamed from: t */
    private List<Map<String, Object>> f15474t = new ArrayList();

    /* renamed from: v */
    private final RecyclerView.OnScrollListener f15476v = new C4069k();

    /* renamed from: w */
    private final RecyclerView.OnScrollListener f15477w = new C4070l();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.student.StudentScoreListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4059a implements RecyclerView.OnItemTouchListener {

        /* renamed from: a */
        private int f15478a;

        C4059a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            if (rv.getScrollState() == 0) {
                onTouchEvent(rv, e);
                return false;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            if (e.getAction() == 0 && StudentScoreListActivity.this.f15472r.getScrollState() == 0) {
                this.f15478a = rv.getScrollY();
                rv.addOnScrollListener(StudentScoreListActivity.this.f15476v);
            } else if (e.getAction() == 1 && rv.getScrollY() == this.f15478a) {
                rv.removeOnScrollListener(StudentScoreListActivity.this.f15476v);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.student.StudentScoreListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4060b implements RecyclerView.OnItemTouchListener {

        /* renamed from: a */
        private int f15480a;

        C4060b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            if (rv.getScrollState() == 0) {
                onTouchEvent(rv, e);
                return false;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            if (e.getAction() == 0 && StudentScoreListActivity.this.f15472r.getScrollState() == 0) {
                this.f15480a = rv.getScrollY();
                rv.addOnScrollListener(StudentScoreListActivity.this.f15477w);
            } else if (e.getAction() == 1 && rv.getScrollY() == this.f15480a) {
                rv.removeOnScrollListener(StudentScoreListActivity.this.f15477w);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.student.StudentScoreListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4061c implements ObservableHorizontalScrollView.InterfaceC3997a {
        C4061c() {
        }

        @Override // com.bxkj.base.view.ObservableHorizontalScrollView.InterfaceC3997a
        /* renamed from: a */
        public void mo43031a(ObservableHorizontalScrollView scrollView, int x, int y, int oldx, int oldy) {
            StudentScoreListActivity.this.f15472r.removeOnScrollListener(StudentScoreListActivity.this.f15476v);
            StudentScoreListActivity.this.f15472r.removeOnScrollListener(StudentScoreListActivity.this.f15477w);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.student.StudentScoreListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4062d extends CommonAdapter<Map<String, Object>> {
        C4062d(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(C4017R.C4021id.tv_score, JsonParse.getString(stringObjectMap, "name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.student.StudentScoreListActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4063e extends CommonAdapter<Map<String, Object>> {
        C4063e(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(C4017R.C4021id.tv_score, JsonParse.getString(stringObjectMap, JsonParse.getString((Map) StudentScoreListActivity.this.f15475u.get(holder.m57864f() % StudentScoreListActivity.this.f15475u.size()), DomainCampaignEx.LOOPBACK_KEY)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.student.StudentScoreListActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4064f extends UniversalItemDecoration {
        C4064f() {
        }

        @Override // com.bxkj.base.util.UniversalItemDecoration
        /* renamed from: a */
        public UniversalItemDecoration.AbstractC3891b mo43302a(int position) {
            UniversalItemDecoration.C3890a c3890a = new UniversalItemDecoration.C3890a();
            c3890a.f14862d = Tools.m57620a(1.0f, ((BaseActivity) StudentScoreListActivity.this).f1669h);
            c3890a.f14858f = C4017R.C4019color.cardDivider;
            return c3890a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.student.StudentScoreListActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4065g extends UniversalItemDecoration {
        C4065g() {
        }

        @Override // com.bxkj.base.util.UniversalItemDecoration
        /* renamed from: a */
        public UniversalItemDecoration.AbstractC3891b mo43302a(int position) {
            UniversalItemDecoration.C3890a c3890a = new UniversalItemDecoration.C3890a();
            int m57620a = Tools.m57620a(1.0f, ((BaseActivity) StudentScoreListActivity.this).f1669h);
            c3890a.f14862d = m57620a;
            c3890a.f14860b = m57620a;
            c3890a.f14858f = C4017R.C4019color.cardDivider;
            return c3890a;
        }

        /* renamed from: c */
        public boolean m43301c(int rowNum, int index) {
            return index % rowNum == 0;
        }

        /* renamed from: d */
        public boolean m43300d(int rowNum, int index) {
            return index % rowNum == rowNum - 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.student.StudentScoreListActivity$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4066h extends HttpCallBack {
        C4066h() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) StudentScoreListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i = JsonParse.getInt(data, "data");
            for (int i2 = 1; i2 <= i; i2++) {
                TabLayout tabLayout = StudentScoreListActivity.this.f15468n;
                TabLayout.Tab newTab = StudentScoreListActivity.this.f15468n.newTab();
                tabLayout.addTab(newTab.setText("第" + i2 + "组"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.student.StudentScoreListActivity$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4067i extends HttpCallBack {
        C4067i() {
        }

        /* renamed from: a */
        private void m43299a() {
            StudentScoreListActivity.this.f15471q.clear();
            StudentScoreListActivity.this.f15470p.m57836g(StudentScoreListActivity.this.f15471q);
            StudentScoreListActivity.this.f15474t.clear();
            StudentScoreListActivity.this.f15473s.m57836g(StudentScoreListActivity.this.f15474t);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            m43299a();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            m43299a();
            new iOSOneButtonDialog(((BaseActivity) StudentScoreListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            StudentScoreListActivity.this.f15471q = JsonParse.getList(data, "data");
            StudentScoreListActivity.this.f15470p.m57836g(StudentScoreListActivity.this.f15471q);
            StudentScoreListActivity.this.f15474t.clear();
            for (Map map : StudentScoreListActivity.this.f15471q) {
                for (Map map2 : StudentScoreListActivity.this.f15475u) {
                    String string = JsonParse.getString(map2, DomainCampaignEx.LOOPBACK_KEY);
                    String string2 = JsonParse.getString(map, string);
                    HashMap hashMap = new HashMap(2);
                    hashMap.put(string, string2);
                    StudentScoreListActivity.this.f15474t.add(hashMap);
                }
            }
            StudentScoreListActivity.this.f15473s.m57836g(StudentScoreListActivity.this.f15474t);
        }
    }

    /* renamed from: com.bxkj.competition.score.student.StudentScoreListActivity$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4068j implements TabLayout.OnTabSelectedListener {
        C4068j() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            StudentScoreListActivity.this.m43305z0();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* renamed from: com.bxkj.competition.score.student.StudentScoreListActivity$k */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4069k extends MyOnScrollListener {
        C4069k() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            StudentScoreListActivity.this.f15472r.scrollBy(dx, dy);
        }
    }

    /* renamed from: com.bxkj.competition.score.student.StudentScoreListActivity$l */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4070l extends MyOnScrollListener {
        C4070l() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            StudentScoreListActivity.this.f15469o.scrollBy(dx, dy);
        }
    }

    /* renamed from: A0 */
    private void m43325A0() {
        this.f15469o.setLayoutManager(new LinearLayoutManager(this.f1669h));
        Context context = this.f1669h;
        int i = C4017R.C4023layout.item_score;
        C4062d c4062d = new C4062d(context, i, this.f15471q);
        this.f15470p = c4062d;
        this.f15469o.setAdapter(c4062d);
        this.f15472r.setLayoutManager(new GridLayoutManager(this.f1669h, this.f15475u.size()));
        C4063e c4063e = new C4063e(this.f1669h, i, this.f15474t);
        this.f15473s = c4063e;
        this.f15472r.setAdapter(c4063e);
        this.f15469o.addItemDecoration(new C4064f());
        this.f15472r.addItemDecoration(new C4065g());
    }

    /* renamed from: B0 */
    private void m43324B0() {
        this.f15475u = new ArrayList();
        new HashMap(2);
        HashMap hashMap = new HashMap(2);
        hashMap.put("name", "道次");
        hashMap.put(DomainCampaignEx.LOOPBACK_KEY, "passNum");
        this.f15475u.add(hashMap);
        HashMap hashMap2 = new HashMap(2);
        hashMap2.put("name", "号码簿");
        hashMap2.put(DomainCampaignEx.LOOPBACK_KEY, "num");
        this.f15475u.add(hashMap2);
        HashMap hashMap3 = new HashMap(2);
        hashMap3.put("name", "单位");
        hashMap3.put(DomainCampaignEx.LOOPBACK_KEY, "areaName");
        this.f15475u.add(hashMap3);
        HashMap hashMap4 = new HashMap(2);
        hashMap4.put("name", "检录");
        hashMap4.put(DomainCampaignEx.LOOPBACK_KEY, "stateName");
        this.f15475u.add(hashMap4);
        HashMap hashMap5 = new HashMap(2);
        hashMap5.put("name", ScoreMenu.START);
        hashMap5.put(DomainCampaignEx.LOOPBACK_KEY, CampaignEx.JSON_NATIVE_VIDEO_START);
        this.f15475u.add(hashMap5);
        HashMap hashMap6 = new HashMap(2);
        hashMap6.put("name", ScoreMenu.CHECK);
        hashMap6.put(DomainCampaignEx.LOOPBACK_KEY, "check");
        this.f15475u.add(hashMap6);
        HashMap hashMap7 = new HashMap(2);
        hashMap7.put("name", ScoreMenu.RANK);
        hashMap7.put(DomainCampaignEx.LOOPBACK_KEY, "rank");
        this.f15475u.add(hashMap7);
        HashMap hashMap8 = new HashMap(2);
        hashMap8.put("name", "成绩");
        hashMap8.put(DomainCampaignEx.LOOPBACK_KEY, RtspHeaders.Values.TIME);
        this.f15475u.add(hashMap8);
        HashMap hashMap9 = new HashMap(2);
        hashMap9.put("name", "备注");
        hashMap9.put(DomainCampaignEx.LOOPBACK_KEY, "memo");
        this.f15475u.add(hashMap9);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        for (Map<String, Object> map : this.f15475u) {
            View inflate = LayoutInflater.from(this.f1669h).inflate(C4017R.C4023layout.item_score, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(C4017R.C4021id.tv_score);
            textView.setText(JsonParse.getString(map, "name"));
            textView.setTag(JsonParse.getString(map, DomainCampaignEx.LOOPBACK_KEY));
            this.f15467m.addView(inflate, layoutParams);
        }
    }

    /* renamed from: C0 */
    private void m43323C0() {
        this.f15469o.addOnItemTouchListener(new C4059a());
        this.f15472r.addOnItemTouchListener(new C4060b());
        this.f15466l.setScrollViewListener(new C4061c());
    }

    /* renamed from: y0 */
    private void m43306y0() {
        Http.with(this.f1669h).setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43446k(this.f15465k)).setDataListener(new C4066h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public void m43305z0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43443n(this.f15465k, this.f15468n.getSelectedTabPosition() + 1)).setDataListener(new C4067i());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15468n.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new C4068j());
        m43323C0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4017R.C4023layout.ac_student_score_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("scheduleId")) {
            this.f15465k = getIntent().getStringExtra("scheduleId");
        }
        m43324B0();
        m43325A0();
        m43306y0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("查看成绩");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15468n = (TabLayout) findViewById(C4017R.C4021id.tb_group);
        this.f15467m = (LinearLayout) findViewById(C4017R.C4021id.ll_top);
        this.f15469o = (RecyclerView) findViewById(C4017R.C4021id.rv_student);
        this.f15472r = (RecyclerView) findViewById(C4017R.C4021id.rv_score);
        this.f15466l = (ObservableHorizontalScrollView) findViewById(C4017R.C4021id.sv_room);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
