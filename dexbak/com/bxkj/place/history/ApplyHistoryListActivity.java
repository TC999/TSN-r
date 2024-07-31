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
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.place.C4159R;
import com.bxkj.place.history.ApplyHistoryListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;
import p650v.PlaceApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ApplyHistoryListActivity extends BaseActivity {

    /* renamed from: k */
    private int f15864k;

    /* renamed from: l */
    private EmptyRecyclerView f15865l;

    /* renamed from: m */
    private TextView f15866m;

    /* renamed from: n */
    private SmartRefreshLayout f15867n;

    /* renamed from: o */
    private List<Map<String, Object>> f15868o;

    /* renamed from: p */
    private CommonAdapter<Map<String, Object>> f15869p;

    /* renamed from: q */
    private int f15870q = 1;

    /* renamed from: r */
    private int f15871r = 10;

    /* renamed from: s */
    private int f15872s = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.place.history.ApplyHistoryListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4192a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.place.history.ApplyHistoryListActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C4193a extends HttpCallBack {

            /* renamed from: a */
            final /* synthetic */ Map f15874a;

            /* renamed from: b */
            final /* synthetic */ ViewHolder f15875b;

            C4193a(final Map val$holder, final ViewHolder val$stringObjectMap) {
                this.f15874a = val$holder;
                this.f15875b = val$stringObjectMap;
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                this.f15874a.put("status", 2);
                C4192a.this.notifyItemChanged(this.f15875b.m57864f());
            }
        }

        C4192a(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: p */
        public /* synthetic */ void m43014p(final Map stringObjectMap, final ViewHolder holder, View v) {
            new iOSTwoButtonDialog(this.f1721a).setMessage("确定要取消吗？").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.place.history.b
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    ApplyHistoryListActivity.C4192a.this.m43013q(stringObjectMap, holder);
                }
            }).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: q */
        public /* synthetic */ void m43013q(final Map stringObjectMap, final ViewHolder holder) {
            Http.with(this.f1721a).setObservable(((PlaceApiService) Http.getApiService(PlaceApiService.class)).m215f(LoginUser.getLoginUser().getUserId(), JsonParse.getString(stringObjectMap, "fieldPlanDateId"), JsonParse.getString(stringObjectMap, "detailId"), "2")).setDataListener(new C4193a(stringObjectMap, holder));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            int i = C4159R.C4163id.tv_feild_name;
            holder.m57874J(i, "场地名称：" + Tools.m57632O(stringObjectMap, "fieldname"));
            int i2 = C4159R.C4163id.tv_day;
            holder.m57874J(i2, "时间：" + Tools.m57632O(stringObjectMap, "date"));
            int i3 = C4159R.C4163id.tv_time;
            holder.m57874J(i3, Tools.m57632O(stringObjectMap, "starttime") + "-" + Tools.m57632O(stringObjectMap, "stoptime"));
            int i4 = C4159R.C4163id.tv_type;
            holder.m57874J(i4, "状态:" + JsonParse.getString(stringObjectMap, "statusStr"));
            int i5 = C4159R.C4163id.tv_status;
            holder.m57874J(i5, "签到状态:" + JsonParse.getString(stringObjectMap, "signStatusStr"));
            Button button = (Button) holder.m57862h(C4159R.C4163id.bt_cancel);
            String string = JsonParse.getString(stringObjectMap, "isCanCancel");
            String string2 = JsonParse.getString(stringObjectMap, "status");
            if (string.equals("1") && string2.equals("1")) {
                button.setEnabled(true);
                button.setText(ApplyHistoryListActivity.this.f15864k == 2 ? "取消申请" : "取消预约");
            } else {
                button.setEnabled(false);
                button.setText("取消");
            }
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.place.history.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyHistoryListActivity.C4192a.this.m43014p(stringObjectMap, holder, view);
                }
            });
        }
    }

    /* renamed from: com.bxkj.place.history.ApplyHistoryListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4194b implements OnRefreshLoadmoreListener {
        C4194b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            ApplyHistoryListActivity.this.f15870q = 1;
            ApplyHistoryListActivity.this.m43018u0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = ApplyHistoryListActivity.this.f15872s / ApplyHistoryListActivity.this.f15871r;
            int i2 = ApplyHistoryListActivity.this.f15870q;
            if (ApplyHistoryListActivity.this.f15872s % ApplyHistoryListActivity.this.f15871r != 0) {
                i++;
            }
            if (i2 >= i) {
                ApplyHistoryListActivity.this.f15867n.mo2041g();
                ApplyHistoryListActivity.this.m57919h0("没有了");
                return;
            }
            ApplyHistoryListActivity.m43024o0(ApplyHistoryListActivity.this);
            ApplyHistoryListActivity.this.m43018u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.place.history.ApplyHistoryListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4195c extends HttpCallBack {
        C4195c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ApplyHistoryListActivity.this.f15867n.mo2078B();
            ApplyHistoryListActivity.this.f15867n.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyHistoryListActivity.this.f15872s = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            if (ApplyHistoryListActivity.this.f15870q == 1) {
                ApplyHistoryListActivity.this.f15868o = list;
            } else {
                ApplyHistoryListActivity.this.f15868o.addAll(list);
            }
            ApplyHistoryListActivity.this.f15869p.m57836g(ApplyHistoryListActivity.this.f15868o);
        }
    }

    /* renamed from: o0 */
    static /* synthetic */ int m43024o0(ApplyHistoryListActivity applyHistoryListActivity) {
        int i = applyHistoryListActivity.f15870q;
        applyHistoryListActivity.f15870q = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m43018u0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((PlaceApiService) Http.getApiService(PlaceApiService.class)).m217a(LoginUser.getLoginUser().getUserId(), this.f15864k, this.f15870q, this.f15871r)).setDataListener(new C4195c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4159R.C4165layout.pub_recyclerview_with_empty_view;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("appointType")) {
            this.f15864k = getIntent().getIntExtra("appointType", 1);
        }
        setTitle(this.f15864k == 2 ? "我的场馆申请记录" : "我的场馆预约记录");
        this.f15865l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, C4159R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f15865l.setLayoutAnimation(layoutAnimationController);
        C4192a c4192a = new C4192a(this.f1669h, C4159R.C4165layout.item_for_apply_place_list, this.f15868o);
        this.f15869p = c4192a;
        this.f15865l.setAdapter(c4192a);
        this.f15865l.setEmptyView(this.f15866m);
        this.f15867n.mo2019v(new C4194b());
        this.f15867n.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的申请记录");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15865l = (EmptyRecyclerView) findViewById(C4159R.C4163id.recyclerView);
        this.f15867n = (SmartRefreshLayout) findViewById(C4159R.C4163id.refresh);
        this.f15866m = (TextView) findViewById(C4159R.C4163id.tv_emptyView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
