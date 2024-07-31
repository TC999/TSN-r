package com.bxkj.competition.signup;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.C4017R;
import com.bxkj.competition.CompeApiService;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class FreeProjectListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f15639k;

    /* renamed from: l */
    private EmptyRecyclerView f15640l;

    /* renamed from: m */
    private TextView f15641m;

    /* renamed from: n */
    private List<Map<String, Object>> f15642n = new ArrayList();

    /* renamed from: o */
    private int f15643o = 1;

    /* renamed from: p */
    private int f15644p = 0;

    /* renamed from: q */
    private int f15645q = 10;

    /* renamed from: r */
    private MultiItemCommonAdapter<Map<String, Object>> f15646r;

    /* renamed from: s */
    private String f15647s;

    /* renamed from: t */
    private StickyDecoration f15648t;

    /* renamed from: u */
    private String f15649u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.FreeProjectListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4112a implements OnRefreshLoadmoreListener {
        C4112a() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            FreeProjectListActivity.this.f15644p = 1;
            FreeProjectListActivity.this.m43188D0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = FreeProjectListActivity.this.f15643o / FreeProjectListActivity.this.f15645q;
            int i2 = FreeProjectListActivity.this.f15644p;
            if (FreeProjectListActivity.this.f15643o % FreeProjectListActivity.this.f15645q != 0) {
                i++;
            }
            if (i2 >= i) {
                FreeProjectListActivity.this.f15639k.mo2041g();
                FreeProjectListActivity.this.m57919h0("没有了");
                return;
            }
            FreeProjectListActivity.m43170w0(FreeProjectListActivity.this);
            FreeProjectListActivity.this.m43188D0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.FreeProjectListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4113b implements InterfaceC1125a<Map<String, Object>> {
        C4113b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a
        /* renamed from: b */
        public int mo40464b(int itemType) {
            return C4017R.C4023layout.item_for_competition_project_list_free;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a
        /* renamed from: c */
        public int mo40465a(int position, Map<String, Object> stringObjectMap) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.FreeProjectListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4114c extends MultiItemCommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.competition.signup.FreeProjectListActivity$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4115a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ int f15653a;

            /* renamed from: b */
            final /* synthetic */ ViewHolder f15654b;

            /* renamed from: com.bxkj.competition.signup.FreeProjectListActivity$c$a$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            class C4116a implements iOSTwoButtonDialog.RightButtonOnClick {
                C4116a() {
                }

                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public void buttonRightOnClick() {
                    View$OnClickListenerC4115a view$OnClickListenerC4115a = View$OnClickListenerC4115a.this;
                    C4114c c4114c = C4114c.this;
                    FreeProjectListActivity.this.m43189C0(c4114c.mo57829e(view$OnClickListenerC4115a.f15654b));
                }
            }

            View$OnClickListenerC4115a(final int val$holder, final ViewHolder val$operation) {
                this.f15653a = val$holder;
                this.f15654b = val$operation;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (this.f15653a == 0) {
                    C4114c c4114c = C4114c.this;
                    FreeProjectListActivity.this.m43190B0(c4114c.mo57829e(this.f15654b));
                    return;
                }
                new iOSTwoButtonDialog(((CommonAdapter) C4114c.this).f1721a).setMessage("确定要取消报名吗？").setRightButtonOnClickListener(new C4116a()).show();
            }
        }

        C4114c(Context x0, List x1, InterfaceC1125a x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: p */
        public void mo39408c(final ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(C4017R.C4021id.tv_name, JsonParse.getString(stringObjectMap, "itemName"));
            int i = JsonParse.getInt(stringObjectMap, "operation");
            int i2 = C4017R.C4021id.bt_ok;
            Button button = (Button) holder.m57862h(i2);
            if (i == 0) {
                button.setBackground(AppCompatResources.getDrawable(this.f1721a, C4017R.C4020drawable.button_bg));
                button.setEnabled(true);
                holder.m57874J(i2, "报名");
            } else if (i == 1) {
                button.setEnabled(true);
                button.setBackground(AppCompatResources.getDrawable(this.f1721a, C4017R.C4020drawable.button_red));
                button.setBackgroundColor(FreeProjectListActivity.this.getResources().getColor(C4017R.C4019color.color_red));
                holder.m57874J(i2, "取消报名");
            } else if (i == 2) {
                button.setBackground(AppCompatResources.getDrawable(this.f1721a, C4017R.C4020drawable.button_bg));
                button.setEnabled(false);
                holder.m57874J(i2, "驳回");
            } else if (i == 3) {
                button.setBackground(AppCompatResources.getDrawable(this.f1721a, C4017R.C4020drawable.button_bg));
                button.setEnabled(false);
                holder.m57874J(i2, "院系通过");
            } else if (i == 4) {
                button.setBackground(AppCompatResources.getDrawable(this.f1721a, C4017R.C4020drawable.button_bg));
                button.setEnabled(false);
                holder.m57874J(i2, "体育部审核");
            } else if (i == 5) {
                button.setBackground(AppCompatResources.getDrawable(this.f1721a, C4017R.C4020drawable.button_bg));
                button.setEnabled(false);
                holder.m57874J(i2, "体育部通过");
            } else {
                button.setBackground(AppCompatResources.getDrawable(this.f1721a, C4017R.C4020drawable.button_bg));
                button.setEnabled(false);
                holder.m57874J(i2, JsonParse.getString(stringObjectMap, "status"));
            }
            holder.m57847w(i2, new View$OnClickListenerC4115a(i, holder));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.FreeProjectListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4117d extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ int f15657a;

        C4117d(final int val$position) {
            this.f15657a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FreeProjectListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ((Map) FreeProjectListActivity.this.f15646r.getItem(this.f15657a)).put("operation", 1);
            ((Map) FreeProjectListActivity.this.f15646r.getItem(this.f15657a)).put("status", "待审核");
            FreeProjectListActivity.this.f15646r.notifyItemChanged(this.f15657a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.FreeProjectListActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4118e extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ int f15659a;

        C4118e(final int val$position) {
            this.f15659a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FreeProjectListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (!TextUtils.isEmpty(FreeProjectListActivity.this.f15649u)) {
                FreeProjectListActivity.this.f15646r.m57837d().remove(this.f15659a);
                FreeProjectListActivity.this.f15646r.notifyItemRemoved(this.f15659a);
                return;
            }
            ((Map) FreeProjectListActivity.this.f15646r.getItem(this.f15659a)).put("operation", 0);
            ((Map) FreeProjectListActivity.this.f15646r.getItem(this.f15659a)).put("status", "未报名");
            FreeProjectListActivity.this.f15646r.notifyItemChanged(this.f15659a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.FreeProjectListActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4119f extends HttpCallBack {
        C4119f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            FreeProjectListActivity.this.f15639k.mo2078B();
            FreeProjectListActivity.this.f15639k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FreeProjectListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            FreeProjectListActivity.this.f15643o = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("itemDetail");
            if (FreeProjectListActivity.this.f15644p == 1) {
                FreeProjectListActivity.this.f15642n = list;
            } else {
                FreeProjectListActivity.this.f15642n.addAll(list);
            }
            FreeProjectListActivity.this.f15646r.m57836g(FreeProjectListActivity.this.f15642n);
            try {
                FreeProjectListActivity.this.f15640l.removeItemDecoration(FreeProjectListActivity.this.f15648t);
            } catch (Exception e) {
                e.printStackTrace();
            }
            FreeProjectListActivity.this.f15640l.addItemDecoration(FreeProjectListActivity.this.f15648t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.FreeProjectListActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4120g extends HttpCallBack {
        C4120g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            FreeProjectListActivity.this.f15639k.mo2078B();
            FreeProjectListActivity.this.f15639k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            FreeProjectListActivity.this.f15643o = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            if (FreeProjectListActivity.this.f15644p == 1) {
                FreeProjectListActivity.this.f15642n = list;
            } else {
                FreeProjectListActivity.this.f15642n.addAll(list);
            }
            FreeProjectListActivity.this.f15646r.m57836g(FreeProjectListActivity.this.f15642n);
            try {
                FreeProjectListActivity.this.f15640l.removeItemDecoration(FreeProjectListActivity.this.f15648t);
            } catch (Exception e) {
                e.printStackTrace();
            }
            FreeProjectListActivity.this.f15640l.addItemDecoration(FreeProjectListActivity.this.f15648t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public void m43190B0(final int position) {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43449h(JsonParse.getString(this.f15646r.getItem(position), "id"), LoginUser.getLoginUser().getUserId())).setDataListener(new C4117d(position));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0 */
    public void m43189C0(final int position) {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43454c(JsonParse.getString(this.f15646r.getItem(position), "id"), LoginUser.getLoginUser().getUserId())).setDataListener(new C4118e(position));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public void m43188D0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43455b(this.f15647s, LoginUser.getLoginUser().getUserId())).setDataListener(new C4119f());
    }

    /* renamed from: E0 */
    private void m43187E0() {
        Http.with(this.f1669h).setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43452e(this.f15647s, LoginUser.getLoginUser().getUserId())).setDataListener(new C4120g());
    }

    /* renamed from: F0 */
    private void m43186F0() {
        C4113b c4113b = new C4113b();
        this.f15640l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, C4017R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f15640l.setLayoutAnimation(layoutAnimationController);
        C4114c c4114c = new C4114c(this.f1669h, this.f15642n, c4113b);
        this.f15646r = c4114c;
        this.f15640l.setAdapter(c4114c);
        this.f15640l.setEmptyView(findViewById(C4017R.C4021id.tv_emptyView));
        this.f15648t = new StickyDecoration(this.f1669h, this.f15642n);
    }

    /* renamed from: G0 */
    private void m43185G0() {
        this.f15639k.mo2019v(new C4112a());
    }

    /* renamed from: w0 */
    static /* synthetic */ int m43170w0(FreeProjectListActivity freeProjectListActivity) {
        int i = freeProjectListActivity.f15644p;
        freeProjectListActivity.f15644p = i + 1;
        return i;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15641m.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4017R.C4023layout.ac_competition_project_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f15647s = getIntent().getStringExtra("competitionId");
        }
        if (getIntent().hasExtra(Constants.FROM)) {
            this.f15649u = getIntent().getStringExtra(Constants.FROM);
        }
        m43185G0();
        m43186F0();
        this.f15639k.mo2050b0(false);
        this.f15639k.mo2064P(false);
        if (!TextUtils.isEmpty(this.f15649u)) {
            setTitle("我报名的竞赛项目");
            m43187E0();
            return;
        }
        m43188D0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("竞赛报名项目列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15639k = (SmartRefreshLayout) findViewById(C4017R.C4021id.refresh);
        this.f15640l = (EmptyRecyclerView) findViewById(C4017R.C4021id.recyclerView);
        this.f15641m = (TextView) findViewById(C4017R.C4021id.tv_ok);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
