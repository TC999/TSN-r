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
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.auth.a;
import com.bxkj.base.user.LoginUser;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;
import s0.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MyLostGoodsActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f21444k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f21445l;

    /* renamed from: m  reason: collision with root package name */
    private FloatingActionButton f21446m;

    /* renamed from: n  reason: collision with root package name */
    private FloatingActionButton f21447n;

    /* renamed from: o  reason: collision with root package name */
    private FloatingActionButton f21448o;

    /* renamed from: p  reason: collision with root package name */
    private FloatingActionButton f21449p;

    /* renamed from: q  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21450q;

    /* renamed from: r  reason: collision with root package name */
    private List<Map<String, Object>> f21451r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    private int f21452s = 1;

    /* renamed from: t  reason: collision with root package name */
    private int f21453t = 10;

    /* renamed from: u  reason: collision with root package name */
    private int f21454u = 0;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.life.lost.MyLostGoodsActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class C0255a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
            C0255a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
            /* renamed from: d */
            public void a(ViewHolder holder, String s3) {
                holder.t(2131231436, s3, 2131558617, 2131558617);
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            int color;
            holder.N(2131233169, true);
            holder.J(2131233169, JsonParse.getString(stringObjectMap, "status"));
            holder.J(2131233141, JsonParse.getInt(stringObjectMap, "lostOrFound") == 1 ? "\u4e22" : "\u6361");
            holder.J(2131233004, JsonParse.getString(stringObjectMap, "description"));
            holder.J(2131233198, "\u65f6\u95f4\uff1a" + JsonParse.getString(stringObjectMap, "publishTime"));
            if (JsonParse.getInt(stringObjectMap, "lostOrFound") == 1) {
                color = ContextCompat.getColor(this.f1707a, 2131034198);
            } else {
                color = ContextCompat.getColor(this.f1707a, 2131034489);
            }
            holder.k(2131233141, color);
            GridView gridView = (GridView) holder.h(2131231336);
            gridView.setEnabled(false);
            gridView.setPressed(false);
            gridView.setClickable(false);
            gridView.setAdapter((ListAdapter) new C0255a(this.f1707a, 2131427721, JsonParse.getList(stringObjectMap, "img", String.class)));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements a.g {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f21458a;

            a(final int val$position) {
                this.f21458a = val$position;
            }

            @Override // com.bxkj.base.auth.a.g
            public void a() {
                MyLostGoodsActivity.this.startActivity(new Intent(((BaseActivity) MyLostGoodsActivity.this).f1656h, LostDetailActivity.class).putExtra("noticeId", JsonParse.getString((Map) MyLostGoodsActivity.this.f21450q.getItem(this.f21458a), "id")).putExtra("lostType", JsonParse.getInt((Map) MyLostGoodsActivity.this.f21450q.getItem(this.f21458a), "lostOrFound")));
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, final int position) {
            new com.bxkj.base.auth.a(((BaseActivity) MyLostGoodsActivity.this).f1656h).i(new a(position)).b(MyLostGoodsActivity.this.getSupportFragmentManager(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements e {
        c() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            MyLostGoodsActivity.this.f21452s = 1;
            MyLostGoodsActivity.this.u0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = MyLostGoodsActivity.this.f21454u / MyLostGoodsActivity.this.f21453t;
            int i5 = MyLostGoodsActivity.this.f21452s;
            if (MyLostGoodsActivity.this.f21454u % MyLostGoodsActivity.this.f21453t != 0) {
                i4++;
            }
            if (i5 >= i4) {
                MyLostGoodsActivity.this.f21444k.h();
                MyLostGoodsActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            MyLostGoodsActivity.q0(MyLostGoodsActivity.this);
            MyLostGoodsActivity.this.u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (MyLostGoodsActivity.this.f21444k != null && MyLostGoodsActivity.this.f21444k.S()) {
                MyLostGoodsActivity.this.f21444k.y();
            }
            if (MyLostGoodsActivity.this.f21444k == null || !MyLostGoodsActivity.this.f21444k.z()) {
                return;
            }
            MyLostGoodsActivity.this.f21444k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyLostGoodsActivity.this.f21454u = JsonParse.getInt(data, "total");
            if (MyLostGoodsActivity.this.f21452s == 1) {
                MyLostGoodsActivity.this.f21451r.clear();
            }
            MyLostGoodsActivity.this.f21451r.addAll(JsonParse.getList(data, "data"));
            MyLostGoodsActivity.this.f21450q.notifyDataSetChanged();
        }
    }

    static /* synthetic */ int q0(MyLostGoodsActivity myLostGoodsActivity) {
        int i4 = myLostGoodsActivity.f21452s;
        myLostGoodsActivity.f21452s = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((q.e) Http.getApiService(q.e.class)).j(LoginUser.getLoginUser().getOpenId(), this.f21452s, this.f21453t)).setDataListener(new d());
    }

    private void v0() {
        this.f21444k.n1(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21450q.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427635;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f21445l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f21445l.setLayoutAnimation(layoutAnimationController);
        this.f21445l.addItemDecoration(new DividerItemDecoration(this.f1656h, 1));
        a aVar = new a(this.f1656h, 2131427720, this.f21451r);
        this.f21450q = aVar;
        this.f21445l.setAdapter(aVar);
        this.f21445l.setEmptyView(findViewById(2131232952));
        v0();
        w0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u7684\u53d1\u5e03");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21444k = (SmartRefreshLayout) findViewById(2131232483);
        this.f21445l = (EmptyRecyclerView) findViewById(2131232545);
        this.f21446m = (FloatingActionButton) findViewById(2131231287);
        this.f21447n = (FloatingActionButton) findViewById(2131231288);
        this.f21448o = (FloatingActionButton) findViewById(2131231290);
        this.f21449p = (FloatingActionButton) findViewById(2131231289);
        this.f21446m.setVisibility(8);
        this.f21447n.setVisibility(8);
        this.f21448o.setVisibility(8);
        this.f21449p.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        v3.getId();
    }

    public void w0() {
        this.f21444k.a0();
    }
}
