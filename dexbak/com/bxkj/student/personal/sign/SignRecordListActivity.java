package com.bxkj.student.personal.sign;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
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
import com.bxkj.student.life.mall.order.OrderButtonOnClick;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p635q.MainApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SignRecordListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f18931k;

    /* renamed from: l */
    private EmptyRecyclerView f18932l;

    /* renamed from: n */
    private int f18934n;

    /* renamed from: o */
    private CommonAdapter<Map<String, Object>> f18935o;

    /* renamed from: p */
    private OrderButtonOnClick f18936p;

    /* renamed from: m */
    private List<Map<String, Object>> f18933m = new ArrayList();

    /* renamed from: q */
    private int f18937q = 1;

    /* renamed from: r */
    private int f18938r = 15;

    /* renamed from: s */
    private int f18939s = 0;

    /* renamed from: com.bxkj.student.personal.sign.SignRecordListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5186a extends CommonAdapter<Map<String, Object>> {
        C5186a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, "积分+" + JsonParse.getString(stringObjectMap, "integral"));
            holder.m57874J(2131233198, JsonParse.getString(stringObjectMap, "integralDate"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.sign.SignRecordListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5187b implements OnRefreshLoadmoreListener {
        C5187b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            SignRecordListActivity.this.f18937q = 1;
            SignRecordListActivity.this.m40373s0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = SignRecordListActivity.this.f18939s / SignRecordListActivity.this.f18938r;
            int i2 = SignRecordListActivity.this.f18937q;
            if (SignRecordListActivity.this.f18939s % SignRecordListActivity.this.f18938r != 0) {
                i++;
            }
            if (i2 >= i) {
                SignRecordListActivity.this.f18931k.mo2041g();
                SignRecordListActivity.this.m57919h0("没有了");
                return;
            }
            SignRecordListActivity.m40378n0(SignRecordListActivity.this);
            SignRecordListActivity.this.m40373s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.sign.SignRecordListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5188c extends HttpCallBack {
        C5188c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (SignRecordListActivity.this.f18931k != null && SignRecordListActivity.this.f18931k.mo2061S()) {
                SignRecordListActivity.this.f18931k.mo2078B();
            }
            if (SignRecordListActivity.this.f18931k == null || !SignRecordListActivity.this.f18931k.mo2015z()) {
                return;
            }
            SignRecordListActivity.this.f18931k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SignRecordListActivity.this.f18939s = JsonParse.getInt(data, "total");
            if (SignRecordListActivity.this.f18937q == 1) {
                SignRecordListActivity.this.f18933m.clear();
            }
            SignRecordListActivity.this.f18933m.addAll(JsonParse.getList(data, "data"));
            SignRecordListActivity.this.f18935o.notifyDataSetChanged();
        }
    }

    /* renamed from: n0 */
    static /* synthetic */ int m40378n0(SignRecordListActivity signRecordListActivity) {
        int i = signRecordListActivity.f18937q;
        signRecordListActivity.f18937q = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public void m40373s0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2254w(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getAccount(), this.f18937q, this.f18938r)).setDataListener(new C5188c());
    }

    /* renamed from: t0 */
    private void m40372t0() {
        this.f18931k.mo2019v(new C5187b());
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
        this.f18932l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C5186a c5186a = new C5186a(this.f1669h, C4215R.C4221layout.item_for_sign_record_list, this.f18933m);
        this.f18935o = c5186a;
        this.f18932l.setAdapter(c5186a);
        this.f18932l.setEmptyView(findViewById(2131232952));
        m40372t0();
        this.f18931k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("签到记录");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18931k = (SmartRefreshLayout) findViewById(2131232482);
        this.f18932l = (EmptyRecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
