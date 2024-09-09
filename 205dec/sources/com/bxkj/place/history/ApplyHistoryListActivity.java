package com.bxkj.place.history;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.place.R;
import com.bxkj.place.history.ApplyHistoryListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import r0.h;
import s0.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ApplyHistoryListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private int f19343k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f19344l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f19345m;

    /* renamed from: n  reason: collision with root package name */
    private SmartRefreshLayout f19346n;

    /* renamed from: o  reason: collision with root package name */
    private List<Map<String, Object>> f19347o;

    /* renamed from: p  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19348p;

    /* renamed from: q  reason: collision with root package name */
    private int f19349q = 1;

    /* renamed from: r  reason: collision with root package name */
    private int f19350r = 10;

    /* renamed from: s  reason: collision with root package name */
    private int f19351s = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.place.history.ApplyHistoryListActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class C0213a extends HttpCallBack {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f19353a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewHolder f19354b;

            C0213a(final Map val$holder, final ViewHolder val$stringObjectMap) {
                this.f19353a = val$holder;
                this.f19354b = val$stringObjectMap;
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                this.f19353a.put("status", 2);
                a.this.notifyItemChanged(this.f19354b.f());
            }
        }

        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(final Map stringObjectMap, final ViewHolder holder, View v3) {
            new iOSTwoButtonDialog(this.f1707a).setMessage("\u786e\u5b9a\u8981\u53d6\u6d88\u5417\uff1f").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.place.history.b
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    ApplyHistoryListActivity.a.this.q(stringObjectMap, holder);
                }
            }).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(final Map stringObjectMap, final ViewHolder holder) {
            Http.with(this.f1707a).setObservable(((v.b) Http.getApiService(v.b.class)).f(LoginUser.getLoginUser().getUserId(), JsonParse.getString(stringObjectMap, "fieldPlanDateId"), JsonParse.getString(stringObjectMap, "detailId"), "2")).setDataListener(new C0213a(stringObjectMap, holder));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            int i4 = R.id.tv_feild_name;
            holder.J(i4, "\u573a\u5730\u540d\u79f0\uff1a" + u.O(stringObjectMap, "fieldname"));
            int i5 = R.id.tv_day;
            holder.J(i5, "\u65f6\u95f4\uff1a" + u.O(stringObjectMap, "date"));
            int i6 = R.id.tv_time;
            holder.J(i6, u.O(stringObjectMap, "starttime") + "-" + u.O(stringObjectMap, "stoptime"));
            int i7 = R.id.tv_type;
            holder.J(i7, "\u72b6\u6001:" + JsonParse.getString(stringObjectMap, "statusStr"));
            int i8 = R.id.tv_status;
            holder.J(i8, "\u7b7e\u5230\u72b6\u6001:" + JsonParse.getString(stringObjectMap, "signStatusStr"));
            Button button = (Button) holder.h(R.id.bt_cancel);
            String string = JsonParse.getString(stringObjectMap, "isCanCancel");
            String string2 = JsonParse.getString(stringObjectMap, "status");
            if (string.equals("1") && string2.equals("1")) {
                button.setEnabled(true);
                button.setText(ApplyHistoryListActivity.this.f19343k == 2 ? "\u53d6\u6d88\u7533\u8bf7" : "\u53d6\u6d88\u9884\u7ea6");
            } else {
                button.setEnabled(false);
                button.setText("\u53d6\u6d88");
            }
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.place.history.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyHistoryListActivity.a.this.p(stringObjectMap, holder, view);
                }
            });
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements e {
        b() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            ApplyHistoryListActivity.this.f19349q = 1;
            ApplyHistoryListActivity.this.u0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = ApplyHistoryListActivity.this.f19351s / ApplyHistoryListActivity.this.f19350r;
            int i5 = ApplyHistoryListActivity.this.f19349q;
            if (ApplyHistoryListActivity.this.f19351s % ApplyHistoryListActivity.this.f19350r != 0) {
                i4++;
            }
            if (i5 >= i4) {
                ApplyHistoryListActivity.this.f19346n.h();
                ApplyHistoryListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            ApplyHistoryListActivity.o0(ApplyHistoryListActivity.this);
            ApplyHistoryListActivity.this.u0();
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

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ApplyHistoryListActivity.this.f19346n.y();
            ApplyHistoryListActivity.this.f19346n.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyHistoryListActivity.this.f19351s = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (ApplyHistoryListActivity.this.f19349q == 1) {
                ApplyHistoryListActivity.this.f19347o = list;
            } else {
                ApplyHistoryListActivity.this.f19347o.addAll(list);
            }
            ApplyHistoryListActivity.this.f19348p.g(ApplyHistoryListActivity.this.f19347o);
        }
    }

    static /* synthetic */ int o0(ApplyHistoryListActivity applyHistoryListActivity) {
        int i4 = applyHistoryListActivity.f19349q;
        applyHistoryListActivity.f19349q = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((v.b) Http.getApiService(v.b.class)).a(LoginUser.getLoginUser().getUserId(), this.f19343k, this.f19349q, this.f19350r)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.pub_recyclerview_with_empty_view;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("appointType")) {
            this.f19343k = getIntent().getIntExtra("appointType", 1);
        }
        setTitle(this.f19343k == 2 ? "\u6211\u7684\u573a\u9986\u7533\u8bf7\u8bb0\u5f55" : "\u6211\u7684\u573a\u9986\u9884\u7ea6\u8bb0\u5f55");
        this.f19344l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f19344l.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, R.layout.item_for_apply_place_list, this.f19347o);
        this.f19348p = aVar;
        this.f19344l.setAdapter(aVar);
        this.f19344l.setEmptyView(this.f19345m);
        this.f19346n.n1(new b());
        this.f19346n.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u7684\u7533\u8bf7\u8bb0\u5f55");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19344l = (EmptyRecyclerView) findViewById(R.id.recyclerView);
        this.f19346n = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.f19345m = (TextView) findViewById(R.id.tv_emptyView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
