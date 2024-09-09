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
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.my.MyLearnActivity;
import com.bxkj.student.home.teaching.learning.my.RefuseQuestionListActivity;
import com.bxkj.student.home.teaching.learning.question.list.QuestionListActivity;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LearnHomeListActivity extends BaseActivity {
    private LearnHomeListAdapter B;

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f20518k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f20519l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f20520m;

    /* renamed from: n  reason: collision with root package name */
    private CardView f20521n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f20522o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f20523p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f20524q;

    /* renamed from: r  reason: collision with root package name */
    private ProgressBar f20525r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f20526s;

    /* renamed from: t  reason: collision with root package name */
    private Button f20527t;

    /* renamed from: u  reason: collision with root package name */
    private Button f20528u;

    /* renamed from: v  reason: collision with root package name */
    private ImageView f20529v;

    /* renamed from: w  reason: collision with root package name */
    private List<List<Map<String, Object>>> f20530w = new ArrayList();

    /* renamed from: x  reason: collision with root package name */
    private List<Map<String, Object>> f20531x = new ArrayList();

    /* renamed from: y  reason: collision with root package name */
    private int f20532y = 10;

    /* renamed from: z  reason: collision with root package name */
    private int f20533z = 1;
    private int A = 0;
    private final int C = 170;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LearnHomeListActivity.this.R().setVisibility(0);
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            if (list.isEmpty()) {
                LearnHomeListActivity.this.W0(data);
                LearnHomeListActivity.this.f20529v.setVisibility(8);
                return;
            }
            LearnHomeListActivity.this.X0(list);
            LearnHomeListActivity.this.f20529v.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            LearnHomeListActivity.this.startActivity(new Intent(((BaseActivity) LearnHomeListActivity.this).f1656h, MyLearnActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            LearnHomeListActivity.this.startActivity(new Intent(((BaseActivity) LearnHomeListActivity.this).f1656h, RefuseQuestionListActivity.class));
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getInt(data, "data") > 0) {
                LearnHomeListActivity.this.b0(2131558870, new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.learning.h
                    @Override // cn.bluemobi.dylan.base.BaseActivity.c
                    public final void onClick() {
                        LearnHomeListActivity.b.this.c();
                    }
                });
                LearnHomeListActivity.this.invalidateOptionsMenu();
                new iOSTwoButtonDialog(((BaseActivity) LearnHomeListActivity.this).f1656h).setMessage("\u60a8\u6709\u6559\u5e08\u6279\u6539\u540e\u4e0d\u5408\u683c\u9898\u76ee\uff0c\u8bf7\u5230\u4e2a\u4eba\u5b66\u4e60\u4e2d\u5fc3\u5904\u7406").setLeftButtonText("\u7a0d\u540e\u518d\u8bf4").setRightButtonText("\u73b0\u5728\u5904\u7406").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.i
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        LearnHomeListActivity.b.this.d();
                    }
                }).show();
            }
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

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            LearnHomeListActivity.this.startActivity(new Intent(((BaseActivity) LearnHomeListActivity.this).f1656h, MyLearnActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            LearnHomeListActivity.this.startActivity(new Intent(((BaseActivity) LearnHomeListActivity.this).f1656h, MyLearnActivity.class));
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getInt(data, "data") > 0) {
                LearnHomeListActivity.this.b0(2131558870, new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.learning.k
                    @Override // cn.bluemobi.dylan.base.BaseActivity.c
                    public final void onClick() {
                        LearnHomeListActivity.c.this.c();
                    }
                });
            } else {
                LearnHomeListActivity.this.b0(2131558869, new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.learning.j
                    @Override // cn.bluemobi.dylan.base.BaseActivity.c
                    public final void onClick() {
                        LearnHomeListActivity.c.this.d();
                    }
                });
            }
            LearnHomeListActivity.this.invalidateOptionsMenu();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f20537a;

        d(final String val$pId) {
            this.f20537a = val$pId;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LearnHomeListActivity.this.R().setVisibility(0);
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            if (list.isEmpty()) {
                data.put("id", this.f20537a);
                LearnHomeListActivity.this.W0(data);
                return;
            }
            LearnHomeListActivity.this.X0(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getInt(data, "data") == 1) {
                LearnHomeListActivity.this.f20528u.setText("\u5df2\u5b8c\u6210\u672c\u7ae0\u8282\u5b66\u4e60");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f implements TabLayout.OnTabSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TabLayout f20540a;

        f(final TabLayout val$tb) {
            this.f20540a = val$tb;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            LearnHomeListActivity.this.f20521n.setVisibility(8);
            LearnHomeListActivity.this.f20531x.clear();
            LearnHomeListActivity.this.B.g(LearnHomeListActivity.this.f20531x);
            int indexOfChild = LearnHomeListActivity.this.f20520m.indexOfChild(this.f20540a);
            while (LearnHomeListActivity.this.f20530w.size() > indexOfChild + 1) {
                int size = LearnHomeListActivity.this.f20530w.size() - 1;
                LearnHomeListActivity.this.f20530w.remove(size);
                LearnHomeListActivity.this.f20520m.removeViewAt(size);
            }
            LearnHomeListActivity.this.N0(JsonParse.getString((Map) ((List) LearnHomeListActivity.this.f20530w.get(indexOfChild)).get(this.f20540a.getSelectedTabPosition()), "id"));
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class g implements s0.e {
        g() {
        }

        @Override // s0.d
        public void q(r0.h refreshlayout) {
            LearnHomeListActivity.this.f20533z = 1;
        }

        @Override // s0.b
        public void s(r0.h refreshlayout) {
            int i4 = LearnHomeListActivity.this.A / LearnHomeListActivity.this.f20532y;
            int i5 = LearnHomeListActivity.this.f20533z;
            if (LearnHomeListActivity.this.A % LearnHomeListActivity.this.f20532y != 0) {
                i4++;
            }
            if (i5 >= i4) {
                LearnHomeListActivity.this.f20518k.h();
                LearnHomeListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            LearnHomeListActivity.A0(LearnHomeListActivity.this);
        }
    }

    static /* synthetic */ int A0(LearnHomeListActivity learnHomeListActivity) {
        int i4 = learnHomeListActivity.f20533z;
        learnHomeListActivity.f20533z = i4 + 1;
        return i4;
    }

    private void L0() {
        for (int i4 = 0; i4 < this.f20520m.getChildCount(); i4++) {
            TabLayout tabLayout = (TabLayout) this.f20520m.getChildAt(i4);
            tabLayout.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new f(tabLayout));
        }
    }

    private void M0() {
        Http.with(this.f1656h).setObservable(((m) Http.getApiService(m.class)).i()).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(String pId) {
        Http.with(this.f1656h).setObservable(((m) Http.getApiService(m.class)).h(pId)).setDataListener(new d(pId));
    }

    private void O0() {
        Http.with(this.f1656h).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((m) Http.getApiService(m.class)).q()).setDataListener(new b());
    }

    private void P0() {
        this.f20518k.n1(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        L0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(View view) {
        List<List<Map<String, Object>>> list = this.f20530w;
        if (list == null || list.size() == 0) {
            return;
        }
        startActivityForResult(new Intent(this.f1656h, LearningCategoryActivity.class).putExtra("list", new ArrayList(this.f20530w.get(0))), 170);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(View view) {
        Http.with(this.f1656h).setObservable(((m) Http.getApiService(m.class)).o(this.f20528u.getTag().toString())).setDataListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(View view) {
        startActivity(new Intent(this.f1656h, QuestionListActivity.class).putExtra("type", 2).putExtra("resourceId", this.f20527t.getTag().toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0() {
        startActivity(new Intent(this.f1656h, MyLearnActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(Map<String, Object> data) {
        List<Map<String, Object>> list = JsonParse.getList(data, "articles");
        this.f20531x = list;
        if (!list.isEmpty()) {
            this.f20521n.setVisibility(0);
            this.B.g(this.f20531x);
            TextView textView = this.f20522o;
            textView.setText("\u5f53\u524d\u7ae0\u8282\u79ef\u5206\uff1a" + JsonParse.getString(data, "leafTotalScore"));
            TextView textView2 = this.f20523p;
            textView2.setText("\u603b\u79ef\u5206\uff1a" + JsonParse.getString(data, "sumIntegral"));
            TextView textView3 = this.f20524q;
            textView3.setText("\u76ee\u6807\u79ef\u5206\uff1a" + JsonParse.getString(data, "desIntegral"));
            int i4 = JsonParse.getInt(data, "completedAmount");
            int i5 = JsonParse.getInt(data, "totalAmount");
            this.f20525r.setMax(i5);
            this.f20525r.setProgress(i4);
            TextView textView4 = this.f20526s;
            textView4.setText(i4 + TTPathConst.sSeparator + i5);
            if (JsonParse.getInt(data, "hasQuestion") == 1) {
                this.f20527t.setVisibility(0);
                this.f20527t.setTag(JsonParse.getString(data, "id"));
            } else {
                this.f20527t.setVisibility(8);
            }
            if (JsonParse.getInt(data, "showButton") == 1) {
                this.f20528u.setVisibility(0);
                this.f20528u.setTag(JsonParse.getString(data, "id"));
                if (JsonParse.getInt(data, "competedType") == 1) {
                    this.f20528u.setText("\u5df2\u5b8c\u6210\u672c\u7ae0\u8282\u5b66\u4e60");
                    return;
                }
                this.f20528u.setText("\u7ed3\u675f\u672c\u7ae0\u8282\u5b66\u4e60");
                this.f20528u.setVisibility(0);
                this.f20528u.setTag(JsonParse.getString(data, "id"));
                return;
            }
            this.f20528u.setVisibility(8);
            return;
        }
        this.f20521n.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(List<Map<String, Object>> dataList) {
        if (dataList == null || dataList.size() == 0) {
            return;
        }
        Map<String, Object> map = dataList.get(0);
        this.f20530w.add(dataList);
        TabLayout tabLayout = (TabLayout) LayoutInflater.from(this.f1656h).inflate(2131427718, (ViewGroup) null);
        for (Map<String, Object> map2 : dataList) {
            tabLayout.addTab(tabLayout.newTab().setText(JsonParse.getString(map2, "typeName")));
        }
        this.f20520m.addView(tabLayout);
        int i4 = JsonParse.getInt(map, "isLeaf");
        List<Map<String, Object>> list = JsonParse.getList(map, "childNode");
        if (i4 == 0 && list != null && list.size() > 0) {
            X0(list);
        } else {
            W0(map);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20520m.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bxkj.student.home.teaching.learning.f
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                LearnHomeListActivity.this.Q0(view, i4, i5, i6, i7, i8, i9, i10, i11);
            }
        });
        this.f20529v.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LearnHomeListActivity.this.R0(view);
            }
        });
        this.f20528u.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LearnHomeListActivity.this.S0(view);
            }
        });
        this.f20527t.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LearnHomeListActivity.this.T0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427426;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f20519l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LearnHomeListAdapter learnHomeListAdapter = new LearnHomeListAdapter(this.f1656h, this.f20531x);
        this.B = learnHomeListAdapter;
        this.f20519l.setAdapter(learnHomeListAdapter);
        this.f20519l.setEmptyView(findViewById(2131232952));
        R().setVisibility(8);
        M0();
        O0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5728\u7ebf\u5b66\u4e60");
        b0(2131558869, new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.learning.g
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                LearnHomeListActivity.this.U0();
            }
        });
        invalidateOptionsMenu();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20520m = (LinearLayout) findViewById(2131232203);
        this.f20518k = (SmartRefreshLayout) findViewById(2131232483);
        this.f20519l = (EmptyRecyclerView) findViewById(2131232545);
        this.f20521n = (CardView) findViewById(2131231060);
        this.f20522o = (TextView) findViewById(2131232923);
        this.f20523p = (TextView) findViewById(2131233209);
        this.f20524q = (TextView) findViewById(2131233190);
        this.f20525r = (ProgressBar) findViewById(2131232447);
        this.f20526s = (TextView) findViewById(2131233105);
        this.f20527t = (Button) findViewById(2131230999);
        this.f20528u = (Button) findViewById(2131230978);
        this.f20529v = (ImageView) findViewById(2131231456);
    }

    public void V0() {
        List<List<Map<String, Object>>> list = this.f20530w;
        if (list == null || list.size() <= 0 || this.f20520m.getChildCount() <= 0) {
            return;
        }
        int size = this.f20530w.size() - 1;
        List<Map<String, Object>> list2 = this.f20530w.get(size);
        TabLayout tabLayout = (TabLayout) this.f20520m.getChildAt(size);
        if (list2 == null || list2.size() <= 0 || tabLayout == null) {
            return;
        }
        N0(JsonParse.getString(list2.get(tabLayout.getSelectedTabPosition()), "id"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && resultCode == -1 && requestCode == 170) {
            ((TabLayout) this.f20520m.getChildAt(0)).getTabAt(data.getIntExtra("index", 0)).select();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        Http.with(this.f1656h).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((m) Http.getApiService(m.class)).q()).setDataListener(new c());
    }
}
