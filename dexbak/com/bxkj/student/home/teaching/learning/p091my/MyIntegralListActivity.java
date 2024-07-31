package com.bxkj.student.home.teaching.learning.p091my;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* renamed from: com.bxkj.student.home.teaching.learning.my.MyIntegralListActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MyIntegralListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f17505k;

    /* renamed from: l */
    private EmptyRecyclerView f17506l;

    /* renamed from: m */
    private TextView f17507m;

    /* renamed from: n */
    private List<Map<String, Object>> f17508n = new ArrayList();

    /* renamed from: o */
    private int f17509o = 20;

    /* renamed from: p */
    private int f17510p = 1;

    /* renamed from: q */
    private int f17511q = 0;

    /* renamed from: r */
    private CommonAdapter f17512r;

    /* renamed from: com.bxkj.student.home.teaching.learning.my.MyIntegralListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4692a extends CommonAdapter<Map<String, Object>> {
        C4692a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "title"));
            holder.m57874J(2131233198, JsonParse.getString(stringObjectMap, "integral"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.my.MyIntegralListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4693b implements OnRefreshLoadmoreListener {
        C4693b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            MyIntegralListActivity.this.f17510p = 1;
            MyIntegralListActivity.this.m41606s0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = MyIntegralListActivity.this.f17511q / MyIntegralListActivity.this.f17509o;
            int i2 = MyIntegralListActivity.this.f17510p;
            if (MyIntegralListActivity.this.f17511q % MyIntegralListActivity.this.f17509o != 0) {
                i++;
            }
            if (i2 >= i) {
                MyIntegralListActivity.this.f17505k.mo2041g();
                MyIntegralListActivity.this.m57919h0("没有了");
                return;
            }
            MyIntegralListActivity.m41611n0(MyIntegralListActivity.this);
            MyIntegralListActivity.this.m41606s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.my.MyIntegralListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4694c extends HttpCallBack {
        C4694c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (MyIntegralListActivity.this.f17505k != null && MyIntegralListActivity.this.f17505k.mo2061S()) {
                MyIntegralListActivity.this.f17505k.mo2078B();
            }
            if (MyIntegralListActivity.this.f17505k == null || !MyIntegralListActivity.this.f17505k.mo2015z()) {
                return;
            }
            MyIntegralListActivity.this.f17505k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyIntegralListActivity.this.f17511q = JsonParse.getInt(data, "total");
            if (MyIntegralListActivity.this.f17510p == 1) {
                MyIntegralListActivity.this.f17508n.clear();
            }
            MyIntegralListActivity.this.f17508n.addAll(JsonParse.getList(data, "data"));
            MyIntegralListActivity.this.f17512r.m57836g(MyIntegralListActivity.this.f17508n);
        }
    }

    /* renamed from: n0 */
    static /* synthetic */ int m41611n0(MyIntegralListActivity myIntegralListActivity) {
        int i = myIntegralListActivity.f17510p;
        myIntegralListActivity.f17510p = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public void m41606s0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41637e(LoginUser.getLoginUser().getUserId(), getIntent().getStringExtra("resultType"), Integer.valueOf(this.f17509o), Integer.valueOf(this.f17510p))).setDataListener(new C4694c());
    }

    /* renamed from: t0 */
    private void m41605t0() {
        this.f17505k.mo2019v(new C4693b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return 2131428026;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f17506l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4692a c4692a = new C4692a(this.f1669h, C4215R.C4221layout.item_for_sign_record_list, this.f17508n);
        this.f17512r = c4692a;
        this.f17506l.setAdapter(c4692a);
        this.f17506l.setEmptyView(this.f17507m);
        m41605t0();
        this.f17505k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的积分");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17505k = (SmartRefreshLayout) findViewById(2131232482);
        this.f17506l = (EmptyRecyclerView) findViewById(2131232481);
        this.f17507m = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.f17505k.mo2052a0();
    }
}
