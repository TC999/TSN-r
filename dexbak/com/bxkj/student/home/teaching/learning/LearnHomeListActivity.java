package com.bxkj.student.home.teaching.learning;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.p091my.MyLearnActivity;
import com.bxkj.student.home.teaching.learning.p091my.RefuseQuestionListActivity;
import com.bxkj.student.home.teaching.learning.question.list.QuestionListActivity;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LearnHomeListActivity extends BaseActivity {

    /* renamed from: B */
    private LearnHomeListAdapter f17161B;

    /* renamed from: k */
    private SmartRefreshLayout f17163k;

    /* renamed from: l */
    private EmptyRecyclerView f17164l;

    /* renamed from: m */
    private LinearLayout f17165m;

    /* renamed from: n */
    private CardView f17166n;

    /* renamed from: o */
    private TextView f17167o;

    /* renamed from: p */
    private TextView f17168p;

    /* renamed from: q */
    private TextView f17169q;

    /* renamed from: r */
    private ProgressBar f17170r;

    /* renamed from: s */
    private TextView f17171s;

    /* renamed from: t */
    private Button f17172t;

    /* renamed from: u */
    private Button f17173u;

    /* renamed from: v */
    private ImageView f17174v;

    /* renamed from: w */
    private List<List<Map<String, Object>>> f17175w = new ArrayList();

    /* renamed from: x */
    private List<Map<String, Object>> f17176x = new ArrayList();

    /* renamed from: y */
    private int f17177y = 10;

    /* renamed from: z */
    private int f17178z = 1;

    /* renamed from: A */
    private int f17160A = 0;

    /* renamed from: C */
    private final int f17162C = 170;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.LearnHomeListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4581a extends HttpCallBack {
        C4581a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LearnHomeListActivity.this.m57932R().setVisibility(0);
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            if (list.isEmpty()) {
                LearnHomeListActivity.this.m41948W0(data);
                LearnHomeListActivity.this.f17174v.setVisibility(8);
                return;
            }
            LearnHomeListActivity.this.m41947X0(list);
            LearnHomeListActivity.this.f17174v.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.LearnHomeListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4582b extends HttpCallBack {
        C4582b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m41926c() {
            LearnHomeListActivity.this.startActivity(new Intent(((BaseActivity) LearnHomeListActivity.this).f1669h, MyLearnActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void m41925d() {
            LearnHomeListActivity.this.startActivity(new Intent(((BaseActivity) LearnHomeListActivity.this).f1669h, RefuseQuestionListActivity.class));
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getInt(data, "data") > 0) {
                LearnHomeListActivity.this.m57925b0(C4215R.mipmap.my_write_rad_dot, new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.home.teaching.learning.h
                    @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
                    public final void onClick() {
                        LearnHomeListActivity.C4582b.this.m41926c();
                    }
                });
                LearnHomeListActivity.this.invalidateOptionsMenu();
                new iOSTwoButtonDialog(((BaseActivity) LearnHomeListActivity.this).f1669h).setMessage("您有教师批改后不合格题目，请到个人学习中心处理").setLeftButtonText("稍后再说").setRightButtonText("现在处理").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.i
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        LearnHomeListActivity.C4582b.this.m41925d();
                    }
                }).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.LearnHomeListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4583c extends HttpCallBack {
        C4583c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m41922c() {
            LearnHomeListActivity.this.startActivity(new Intent(((BaseActivity) LearnHomeListActivity.this).f1669h, MyLearnActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void m41921d() {
            LearnHomeListActivity.this.startActivity(new Intent(((BaseActivity) LearnHomeListActivity.this).f1669h, MyLearnActivity.class));
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getInt(data, "data") > 0) {
                LearnHomeListActivity.this.m57925b0(C4215R.mipmap.my_write_rad_dot, new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.home.teaching.learning.k
                    @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
                    public final void onClick() {
                        LearnHomeListActivity.C4583c.this.m41922c();
                    }
                });
            } else {
                LearnHomeListActivity.this.m57925b0(2131558869, new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.home.teaching.learning.j
                    @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
                    public final void onClick() {
                        LearnHomeListActivity.C4583c.this.m41921d();
                    }
                });
            }
            LearnHomeListActivity.this.invalidateOptionsMenu();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.LearnHomeListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4584d extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ String f17182a;

        C4584d(final String val$pId) {
            this.f17182a = val$pId;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LearnHomeListActivity.this.m57932R().setVisibility(0);
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            if (list.isEmpty()) {
                data.put("id", this.f17182a);
                LearnHomeListActivity.this.m41948W0(data);
                return;
            }
            LearnHomeListActivity.this.m41947X0(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.LearnHomeListActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4585e extends HttpCallBack {
        C4585e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getInt(data, "data") == 1) {
                LearnHomeListActivity.this.f17173u.setText("已完成本章节学习");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.LearnHomeListActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4586f implements TabLayout.OnTabSelectedListener {

        /* renamed from: a */
        final /* synthetic */ TabLayout f17185a;

        C4586f(final TabLayout val$tb) {
            this.f17185a = val$tb;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            LearnHomeListActivity.this.f17166n.setVisibility(8);
            LearnHomeListActivity.this.f17176x.clear();
            LearnHomeListActivity.this.f17161B.m57836g(LearnHomeListActivity.this.f17176x);
            int indexOfChild = LearnHomeListActivity.this.f17165m.indexOfChild(this.f17185a);
            while (LearnHomeListActivity.this.f17175w.size() > indexOfChild + 1) {
                int size = LearnHomeListActivity.this.f17175w.size() - 1;
                LearnHomeListActivity.this.f17175w.remove(size);
                LearnHomeListActivity.this.f17165m.removeViewAt(size);
            }
            LearnHomeListActivity.this.m41957N0(JsonParse.getString((Map) ((List) LearnHomeListActivity.this.f17175w.get(indexOfChild)).get(this.f17185a.getSelectedTabPosition()), "id"));
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.learning.LearnHomeListActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4587g implements OnRefreshLoadmoreListener {
        C4587g() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            LearnHomeListActivity.this.f17178z = 1;
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = LearnHomeListActivity.this.f17160A / LearnHomeListActivity.this.f17177y;
            int i2 = LearnHomeListActivity.this.f17178z;
            if (LearnHomeListActivity.this.f17160A % LearnHomeListActivity.this.f17177y != 0) {
                i++;
            }
            if (i2 >= i) {
                LearnHomeListActivity.this.f17163k.mo2041g();
                LearnHomeListActivity.this.m57919h0("没有了");
                return;
            }
            LearnHomeListActivity.m41970A0(LearnHomeListActivity.this);
        }
    }

    /* renamed from: A0 */
    static /* synthetic */ int m41970A0(LearnHomeListActivity learnHomeListActivity) {
        int i = learnHomeListActivity.f17178z;
        learnHomeListActivity.f17178z = i + 1;
        return i;
    }

    /* renamed from: L0 */
    private void m41959L0() {
        for (int i = 0; i < this.f17165m.getChildCount(); i++) {
            TabLayout tabLayout = (TabLayout) this.f17165m.getChildAt(i);
            tabLayout.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new C4586f(tabLayout));
        }
    }

    /* renamed from: M0 */
    private void m41958M0() {
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41633i()).setDataListener(new C4581a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public void m41957N0(String pId) {
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41634h(pId)).setDataListener(new C4584d(pId));
    }

    /* renamed from: O0 */
    private void m41956O0() {
        Http.with(this.f1669h).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41625q()).setDataListener(new C4582b());
    }

    /* renamed from: P0 */
    private void m41955P0() {
        this.f17163k.mo2019v(new C4587g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0 */
    public /* synthetic */ void m41954Q0(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        m41959L0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0 */
    public /* synthetic */ void m41953R0(View view) {
        List<List<Map<String, Object>>> list = this.f17175w;
        if (list == null || list.size() == 0) {
            return;
        }
        startActivityForResult(new Intent(this.f1669h, LearningCategoryActivity.class).putExtra("list", new ArrayList(this.f17175w.get(0))), 170);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S0 */
    public /* synthetic */ void m41952S0(View view) {
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41627o(this.f17173u.getTag().toString())).setDataListener(new C4585e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T0 */
    public /* synthetic */ void m41951T0(View view) {
        startActivity(new Intent(this.f1669h, QuestionListActivity.class).putExtra("type", 2).putExtra("resourceId", this.f17172t.getTag().toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0 */
    public /* synthetic */ void m41950U0() {
        startActivity(new Intent(this.f1669h, MyLearnActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0 */
    public void m41948W0(Map<String, Object> data) {
        List<Map<String, Object>> list = JsonParse.getList(data, "articles");
        this.f17176x = list;
        if (!list.isEmpty()) {
            this.f17166n.setVisibility(0);
            this.f17161B.m57836g(this.f17176x);
            TextView textView = this.f17167o;
            textView.setText("当前章节积分：" + JsonParse.getString(data, "leafTotalScore"));
            TextView textView2 = this.f17168p;
            textView2.setText("总积分：" + JsonParse.getString(data, "sumIntegral"));
            TextView textView3 = this.f17169q;
            textView3.setText("目标积分：" + JsonParse.getString(data, "desIntegral"));
            int i = JsonParse.getInt(data, "completedAmount");
            int i2 = JsonParse.getInt(data, "totalAmount");
            this.f17170r.setMax(i2);
            this.f17170r.setProgress(i);
            TextView textView4 = this.f17171s;
            textView4.setText(i + "/" + i2);
            if (JsonParse.getInt(data, "hasQuestion") == 1) {
                this.f17172t.setVisibility(0);
                this.f17172t.setTag(JsonParse.getString(data, "id"));
            } else {
                this.f17172t.setVisibility(8);
            }
            if (JsonParse.getInt(data, "showButton") == 1) {
                this.f17173u.setVisibility(0);
                this.f17173u.setTag(JsonParse.getString(data, "id"));
                if (JsonParse.getInt(data, "competedType") == 1) {
                    this.f17173u.setText("已完成本章节学习");
                    return;
                }
                this.f17173u.setText("结束本章节学习");
                this.f17173u.setVisibility(0);
                this.f17173u.setTag(JsonParse.getString(data, "id"));
                return;
            }
            this.f17173u.setVisibility(8);
            return;
        }
        this.f17166n.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X0 */
    public void m41947X0(List<Map<String, Object>> dataList) {
        if (dataList == null || dataList.size() == 0) {
            return;
        }
        Map<String, Object> map = dataList.get(0);
        this.f17175w.add(dataList);
        TabLayout tabLayout = (TabLayout) LayoutInflater.from(this.f1669h).inflate(C4215R.C4221layout.item_for_list_tab, (ViewGroup) null);
        for (Map<String, Object> map2 : dataList) {
            tabLayout.addTab(tabLayout.newTab().setText(JsonParse.getString(map2, "typeName")));
        }
        this.f17165m.addView(tabLayout);
        int i = JsonParse.getInt(map, "isLeaf");
        List<Map<String, Object>> list = JsonParse.getList(map, "childNode");
        if (i == 0 && list != null && list.size() > 0) {
            m41947X0(list);
        } else {
            m41948W0(map);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17165m.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bxkj.student.home.teaching.learning.f
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                LearnHomeListActivity.this.m41954Q0(view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
        this.f17174v.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LearnHomeListActivity.this.m41953R0(view);
            }
        });
        this.f17173u.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LearnHomeListActivity.this.m41952S0(view);
            }
        });
        this.f17172t.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LearnHomeListActivity.this.m41951T0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_learning_home_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f17164l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LearnHomeListAdapter learnHomeListAdapter = new LearnHomeListAdapter(this.f1669h, this.f17176x);
        this.f17161B = learnHomeListAdapter;
        this.f17164l.setAdapter(learnHomeListAdapter);
        this.f17164l.setEmptyView(findViewById(2131232952));
        m57932R().setVisibility(8);
        m41958M0();
        m41956O0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("在线学习");
        m57925b0(2131558869, new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.home.teaching.learning.g
            @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
            public final void onClick() {
                LearnHomeListActivity.this.m41950U0();
            }
        });
        invalidateOptionsMenu();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17165m = (LinearLayout) findViewById(C4215R.C4219id.ll_menus);
        this.f17163k = (SmartRefreshLayout) findViewById(2131232483);
        this.f17164l = (EmptyRecyclerView) findViewById(C4215R.C4219id.rv_goods_list);
        this.f17166n = (CardView) findViewById(C4215R.C4219id.card_bottom);
        this.f17167o = (TextView) findViewById(C4215R.C4219id.tv_current_score);
        this.f17168p = (TextView) findViewById(C4215R.C4219id.tv_total_score);
        this.f17169q = (TextView) findViewById(C4215R.C4219id.tv_target_score);
        this.f17170r = (ProgressBar) findViewById(C4215R.C4219id.pb_process);
        this.f17171s = (TextView) findViewById(C4215R.C4219id.tv_process);
        this.f17172t = (Button) findViewById(C4215R.C4219id.bt_question);
        this.f17173u = (Button) findViewById(C4215R.C4219id.bt_finish);
        this.f17174v = (ImageView) findViewById(C4215R.C4219id.iv_more);
    }

    /* renamed from: V0 */
    public void m41949V0() {
        List<List<Map<String, Object>>> list = this.f17175w;
        if (list == null || list.size() <= 0 || this.f17165m.getChildCount() <= 0) {
            return;
        }
        int size = this.f17175w.size() - 1;
        List<Map<String, Object>> list2 = this.f17175w.get(size);
        TabLayout tabLayout = (TabLayout) this.f17165m.getChildAt(size);
        if (list2 == null || list2.size() <= 0 || tabLayout == null) {
            return;
        }
        m41957N0(JsonParse.getString(list2.get(tabLayout.getSelectedTabPosition()), "id"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && resultCode == -1 && requestCode == 170) {
            ((TabLayout) this.f17165m.getChildAt(0)).getTabAt(data.getIntExtra("index", 0)).select();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        Http.with(this.f1669h).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41625q()).setDataListener(new C4583c());
    }
}
