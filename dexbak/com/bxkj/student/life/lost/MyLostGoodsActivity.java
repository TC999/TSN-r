package com.bxkj.student.life.lost;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.auth.AuthorizationUtils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p635q.LostApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MyLostGoodsActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f18113k;

    /* renamed from: l */
    private EmptyRecyclerView f18114l;

    /* renamed from: m */
    private FloatingActionButton f18115m;

    /* renamed from: n */
    private FloatingActionButton f18116n;

    /* renamed from: o */
    private FloatingActionButton f18117o;

    /* renamed from: p */
    private FloatingActionButton f18118p;

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f18119q;

    /* renamed from: r */
    private List<Map<String, Object>> f18120r = new ArrayList();

    /* renamed from: s */
    private int f18121s = 1;

    /* renamed from: t */
    private int f18122t = 10;

    /* renamed from: u */
    private int f18123u = 0;

    /* renamed from: com.bxkj.student.life.lost.MyLostGoodsActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4913a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.lost.MyLostGoodsActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C4914a extends cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter<String> {
            C4914a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
            /* renamed from: d */
            public void mo40086a(ViewHolder holder, String s) {
                holder.m57850t(C4215R.C4219id.iv_img, s, 2131558617, 2131558617);
            }
        }

        C4913a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            int color;
            holder.m57870N(2131233169, true);
            holder.m57874J(2131233169, JsonParse.getString(stringObjectMap, "status"));
            holder.m57874J(C4215R.C4219id.tv_sale_empty, JsonParse.getInt(stringObjectMap, "lostOrFound") == 1 ? "丢" : "捡");
            holder.m57874J(2131233004, JsonParse.getString(stringObjectMap, SocialConstants.PARAM_COMMENT));
            holder.m57874J(2131233198, "时间：" + JsonParse.getString(stringObjectMap, "publishTime"));
            if (JsonParse.getInt(stringObjectMap, "lostOrFound") == 1) {
                color = ContextCompat.getColor(this.f1721a, 2131034198);
            } else {
                color = ContextCompat.getColor(this.f1721a, 2131034489);
            }
            holder.m57859k(C4215R.C4219id.tv_sale_empty, color);
            GridView gridView = (GridView) holder.m57862h(C4215R.C4219id.gv_img);
            gridView.setEnabled(false);
            gridView.setPressed(false);
            gridView.setClickable(false);
            gridView.setAdapter((ListAdapter) new C4914a(this.f1721a, C4215R.C4221layout.item_for_lost_img, JsonParse.getList(stringObjectMap, SocialConstants.PARAM_IMG_URL, String.class)));
        }
    }

    /* renamed from: com.bxkj.student.life.lost.MyLostGoodsActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4915b implements OnItemClickListener {

        /* renamed from: com.bxkj.student.life.lost.MyLostGoodsActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4916a implements AuthorizationUtils.InterfaceC3827g {

            /* renamed from: a */
            final /* synthetic */ int f18127a;

            C4916a(final int val$position) {
                this.f18127a = val$position;
            }

            @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
            /* renamed from: a */
            public void mo40697a() {
                MyLostGoodsActivity.this.startActivity(new Intent(((BaseActivity) MyLostGoodsActivity.this).f1669h, LostDetailActivity.class).putExtra("noticeId", JsonParse.getString((Map) MyLostGoodsActivity.this.f18119q.getItem(this.f18127a), "id")).putExtra("lostType", JsonParse.getInt((Map) MyLostGoodsActivity.this.f18119q.getItem(this.f18127a), "lostOrFound")));
            }
        }

        C4915b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, final int position) {
            new AuthorizationUtils(((BaseActivity) MyLostGoodsActivity.this).f1669h).m44322i(new C4916a(position)).m44329b(MyLostGoodsActivity.this.getSupportFragmentManager(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.lost.MyLostGoodsActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4917c implements OnRefreshLoadmoreListener {
        C4917c() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            MyLostGoodsActivity.this.f18121s = 1;
            MyLostGoodsActivity.this.m41033u0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = MyLostGoodsActivity.this.f18123u / MyLostGoodsActivity.this.f18122t;
            int i2 = MyLostGoodsActivity.this.f18121s;
            if (MyLostGoodsActivity.this.f18123u % MyLostGoodsActivity.this.f18122t != 0) {
                i++;
            }
            if (i2 >= i) {
                MyLostGoodsActivity.this.f18113k.mo2041g();
                MyLostGoodsActivity.this.m57919h0("没有了");
                return;
            }
            MyLostGoodsActivity.m41037q0(MyLostGoodsActivity.this);
            MyLostGoodsActivity.this.m41033u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.lost.MyLostGoodsActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4918d extends HttpCallBack {
        C4918d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (MyLostGoodsActivity.this.f18113k != null && MyLostGoodsActivity.this.f18113k.mo2061S()) {
                MyLostGoodsActivity.this.f18113k.mo2078B();
            }
            if (MyLostGoodsActivity.this.f18113k == null || !MyLostGoodsActivity.this.f18113k.mo2015z()) {
                return;
            }
            MyLostGoodsActivity.this.f18113k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyLostGoodsActivity.this.f18123u = JsonParse.getInt(data, "total");
            if (MyLostGoodsActivity.this.f18121s == 1) {
                MyLostGoodsActivity.this.f18120r.clear();
            }
            MyLostGoodsActivity.this.f18120r.addAll(JsonParse.getList(data, "data"));
            MyLostGoodsActivity.this.f18119q.notifyDataSetChanged();
        }
    }

    /* renamed from: q0 */
    static /* synthetic */ int m41037q0(MyLostGoodsActivity myLostGoodsActivity) {
        int i = myLostGoodsActivity.f18121s;
        myLostGoodsActivity.f18121s = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m41033u0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((LostApiService) Http.getApiService(LostApiService.class)).m2278j(LoginUser.getLoginUser().getOpenId(), this.f18121s, this.f18122t)).setDataListener(new C4918d());
    }

    /* renamed from: v0 */
    private void m41032v0() {
        this.f18113k.mo2019v(new C4917c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18119q.m57834k(new C4915b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.fm_lost_goods_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f18114l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f18114l.setLayoutAnimation(layoutAnimationController);
        this.f18114l.addItemDecoration(new DividerItemDecoration(this.f1669h, 1));
        C4913a c4913a = new C4913a(this.f1669h, C4215R.C4221layout.item_for_lost_good, this.f18120r);
        this.f18119q = c4913a;
        this.f18114l.setAdapter(c4913a);
        this.f18114l.setEmptyView(findViewById(2131232952));
        m41032v0();
        m41031w0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的发布");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18113k = (SmartRefreshLayout) findViewById(2131232483);
        this.f18114l = (EmptyRecyclerView) findViewById(C4215R.C4219id.rv_goods_list);
        this.f18115m = (FloatingActionButton) findViewById(2131231287);
        this.f18116n = (FloatingActionButton) findViewById(C4215R.C4219id.fab_lost);
        this.f18117o = (FloatingActionButton) findViewById(C4215R.C4219id.fab_pick);
        this.f18118p = (FloatingActionButton) findViewById(C4215R.C4219id.fab_my);
        this.f18115m.setVisibility(8);
        this.f18116n.setVisibility(8);
        this.f18117o.setVisibility(8);
        this.f18118p.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        v.getId();
    }

    /* renamed from: w0 */
    public void m41031w0() {
        this.f18113k.mo2052a0();
    }
}
