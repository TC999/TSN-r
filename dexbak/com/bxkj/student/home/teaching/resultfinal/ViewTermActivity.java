package com.bxkj.student.home.teaching.resultfinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ViewTermActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f17883k;

    /* renamed from: l */
    private RecyclerView f17884l;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f17886n;

    /* renamed from: m */
    private List<Map<String, Object>> f17885m = new ArrayList();

    /* renamed from: o */
    protected int f17887o = 10;

    /* renamed from: p */
    protected int f17888p = 1;

    /* renamed from: q */
    protected int f17889q = 1;

    /* renamed from: com.bxkj.student.home.teaching.resultfinal.ViewTermActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4824a extends CommonAdapter<Map<String, Object>> {
        C4824a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131232927, "学期：" + JsonParse.getString(stringObjectMap, "sysTermName"));
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "sysUserName"));
            holder.m57874J(2131233045, JsonParse.getString(stringObjectMap, "sysUserUserNum"));
            holder.m57874J(2131233169, JsonParse.getString(stringObjectMap, "type"));
            holder.m57874J(2131233146, JsonParse.getString(stringObjectMap, "score"));
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.resultfinal.ViewTermActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4825b implements OnItemClickListener {
        C4825b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            ViewTermActivity.this.startActivity(new Intent(((BaseActivity) ViewTermActivity.this).f1669h, AllScoreForTeamActivity.class).putExtra("stuName", JsonParse.getString((Map) ViewTermActivity.this.f17886n.getItem(position), "sysUserName")).putExtra("stuNum", JsonParse.getString((Map) ViewTermActivity.this.f17886n.getItem(position), "sysUserUserNum")).putExtra("stuTeamScoreId", JsonParse.getString((Map) ViewTermActivity.this.f17886n.getItem(position), "id")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.resultfinal.ViewTermActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4826c implements OnRefreshLoadmoreListener {
        C4826c() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            viewTermActivity.f17888p = 1;
            viewTermActivity.m41262m0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            int i = viewTermActivity.f17889q;
            int i2 = viewTermActivity.f17887o;
            int i3 = i / i2;
            int i4 = viewTermActivity.f17888p;
            if (i % i2 != 0) {
                i3++;
            }
            if (i4 >= i3) {
                viewTermActivity.f17883k.mo2041g();
                Toast.makeText(((BaseActivity) ViewTermActivity.this).f1669h, "没有了", 0).show();
                return;
            }
            viewTermActivity.f17888p = i4 + 1;
            viewTermActivity.m41262m0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.resultfinal.ViewTermActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4827d extends HttpCallBack {
        C4827d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ViewTermActivity.this.f17883k.mo2078B();
            ViewTermActivity.this.f17883k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewTermActivity.this.f17889q = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            List m57837d = ViewTermActivity.this.f17886n.m57837d();
            if (ViewTermActivity.this.f17888p != 1) {
                m57837d.addAll(list);
                list = m57837d;
            }
            ViewTermActivity.this.f17886n.m57836g(list);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17886n.m57834k(new C4825b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return 2131427460;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f17884l.setLayoutManager(new LinearLayoutManager(this.f1669h, 1, false));
        C4824a c4824a = new C4824a(this.f1669h, C4215R.C4221layout.item_for_term_score_list, this.f17885m);
        this.f17886n = c4824a;
        this.f17884l.setAdapter(c4824a);
        m41261n0();
        this.f17883k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("查看学期总分");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17883k = (SmartRefreshLayout) findViewById(2131232482);
        this.f17884l = (RecyclerView) findViewById(2131232481);
    }

    /* renamed from: m0 */
    public void m41262m0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m80q0(LoginUser.getLoginUser().getUserId(), this.f17888p, this.f17887o)).setDataListener(new C4827d());
    }

    /* renamed from: n0 */
    public void m41261n0() {
        this.f17883k.mo2019v(new C4826c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
