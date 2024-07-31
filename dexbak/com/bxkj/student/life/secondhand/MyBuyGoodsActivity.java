package com.bxkj.student.life.secondhand;

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
import p635q.SecondHandApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MyBuyGoodsActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f18532k;

    /* renamed from: l */
    private EmptyRecyclerView f18533l;

    /* renamed from: m */
    private FloatingActionButton f18534m;

    /* renamed from: n */
    private FloatingActionButton f18535n;

    /* renamed from: o */
    private FloatingActionButton f18536o;

    /* renamed from: p */
    private FloatingActionButton f18537p;

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f18538q;

    /* renamed from: r */
    private List<Map<String, Object>> f18539r = new ArrayList();

    /* renamed from: s */
    private int f18540s = 1;

    /* renamed from: t */
    private int f18541t = 10;

    /* renamed from: u */
    private int f18542u = 0;

    /* renamed from: com.bxkj.student.life.secondhand.MyBuyGoodsActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5047a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.secondhand.MyBuyGoodsActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C5048a extends cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter<String> {
            C5048a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
            /* renamed from: d */
            public void mo40086a(ViewHolder holder, String s) {
                holder.m57850t(C4215R.C4219id.iv_img, s, 2131558617, 2131558617);
            }
        }

        C5047a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            int color;
            holder.m57870N(2131233169, true);
            holder.m57874J(2131233169, JsonParse.getString(stringObjectMap, "status"));
            holder.m57874J(2131233004, JsonParse.getString(stringObjectMap, SocialConstants.PARAM_COMMENT));
            holder.m57874J(2131233198, "时间：" + JsonParse.getString(stringObjectMap, "publishTime"));
            holder.m57874J(C4215R.C4219id.tv_buy_type, JsonParse.getInt(stringObjectMap, "buyOrSell") == 1 ? "卖" : "买");
            if (JsonParse.getInt(stringObjectMap, "buyOrSell") == 1) {
                color = ContextCompat.getColor(this.f1721a, 2131034177);
            } else {
                color = ContextCompat.getColor(this.f1721a, 2131034172);
            }
            holder.m57859k(C4215R.C4219id.tv_buy_type, color);
            GridView gridView = (GridView) holder.m57862h(C4215R.C4219id.gv_img);
            gridView.setEnabled(false);
            gridView.setPressed(false);
            gridView.setClickable(false);
            gridView.setAdapter((ListAdapter) new C5048a(this.f1721a, C4215R.C4221layout.item_for_lost_img, JsonParse.getList(stringObjectMap, SocialConstants.PARAM_IMG_URL, String.class)));
        }
    }

    /* renamed from: com.bxkj.student.life.secondhand.MyBuyGoodsActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5049b implements OnItemClickListener {

        /* renamed from: com.bxkj.student.life.secondhand.MyBuyGoodsActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5050a implements AuthorizationUtils.InterfaceC3827g {

            /* renamed from: a */
            final /* synthetic */ int f18546a;

            C5050a(final int val$position) {
                this.f18546a = val$position;
            }

            @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
            /* renamed from: a */
            public void mo40697a() {
                MyBuyGoodsActivity.this.startActivity(new Intent(((BaseActivity) MyBuyGoodsActivity.this).f1669h, BuyDetailActivity.class).putExtra("noticeId", JsonParse.getString((Map) MyBuyGoodsActivity.this.f18538q.getItem(this.f18546a), "id")).putExtra("buyType", JsonParse.getInt((Map) MyBuyGoodsActivity.this.f18538q.getItem(this.f18546a), "buyOrSell")));
            }
        }

        C5049b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, final int position) {
            new AuthorizationUtils(((BaseActivity) MyBuyGoodsActivity.this).f1669h).m44322i(new C5050a(position)).m44329b(MyBuyGoodsActivity.this.getSupportFragmentManager(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.secondhand.MyBuyGoodsActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5051c implements OnRefreshLoadmoreListener {
        C5051c() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            MyBuyGoodsActivity.this.f18540s = 1;
            MyBuyGoodsActivity.this.m40736u0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = MyBuyGoodsActivity.this.f18542u / MyBuyGoodsActivity.this.f18541t;
            int i2 = MyBuyGoodsActivity.this.f18540s;
            if (MyBuyGoodsActivity.this.f18542u % MyBuyGoodsActivity.this.f18541t != 0) {
                i++;
            }
            if (i2 >= i) {
                MyBuyGoodsActivity.this.f18532k.mo2041g();
                MyBuyGoodsActivity.this.m57919h0("没有了");
                return;
            }
            MyBuyGoodsActivity.m40740q0(MyBuyGoodsActivity.this);
            MyBuyGoodsActivity.this.m40736u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.secondhand.MyBuyGoodsActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5052d extends HttpCallBack {
        C5052d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (MyBuyGoodsActivity.this.f18532k != null && MyBuyGoodsActivity.this.f18532k.mo2061S()) {
                MyBuyGoodsActivity.this.f18532k.mo2078B();
            }
            if (MyBuyGoodsActivity.this.f18532k == null || !MyBuyGoodsActivity.this.f18532k.mo2015z()) {
                return;
            }
            MyBuyGoodsActivity.this.f18532k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyBuyGoodsActivity.this.f18542u = JsonParse.getInt(data, "total");
            if (MyBuyGoodsActivity.this.f18540s == 1) {
                MyBuyGoodsActivity.this.f18539r.clear();
            }
            MyBuyGoodsActivity.this.f18539r.addAll(JsonParse.getList(data, "data"));
            MyBuyGoodsActivity.this.f18538q.notifyDataSetChanged();
        }
    }

    /* renamed from: q0 */
    static /* synthetic */ int m40740q0(MyBuyGoodsActivity myBuyGoodsActivity) {
        int i = myBuyGoodsActivity.f18540s;
        myBuyGoodsActivity.f18540s = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m40736u0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((SecondHandApiService) Http.getApiService(SecondHandApiService.class)).m2197c(LoginUser.getLoginUser().getOpenId(), this.f18540s, this.f18541t)).setDataListener(new C5052d());
    }

    /* renamed from: v0 */
    private void m40735v0() {
        this.f18532k.mo2019v(new C5051c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18538q.m57834k(new C5049b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.fm_lost_goods_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f18533l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f18533l.setLayoutAnimation(layoutAnimationController);
        this.f18533l.addItemDecoration(new DividerItemDecoration(this.f1669h, 1));
        C5047a c5047a = new C5047a(this.f1669h, C4215R.C4221layout.item_for_sencond_hand, this.f18539r);
        this.f18538q = c5047a;
        this.f18533l.setAdapter(c5047a);
        this.f18533l.setEmptyView(findViewById(2131232952));
        m40735v0();
        m40734w0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的发布");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18532k = (SmartRefreshLayout) findViewById(2131232483);
        this.f18533l = (EmptyRecyclerView) findViewById(C4215R.C4219id.rv_goods_list);
        this.f18534m = (FloatingActionButton) findViewById(2131231287);
        this.f18535n = (FloatingActionButton) findViewById(C4215R.C4219id.fab_lost);
        this.f18536o = (FloatingActionButton) findViewById(C4215R.C4219id.fab_pick);
        this.f18537p = (FloatingActionButton) findViewById(C4215R.C4219id.fab_my);
        this.f18534m.setVisibility(8);
        this.f18535n.setVisibility(8);
        this.f18536o.setVisibility(8);
        this.f18537p.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        v.getId();
    }

    /* renamed from: w0 */
    public void m40734w0() {
        this.f18532k.mo2052a0();
    }
}
