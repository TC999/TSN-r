package com.bxkj.competition.signup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.C4017R;
import com.bxkj.competition.CompeApiService;
import com.bxkj.competition.signup.pay.CompetitionPayActivity;
import com.github.mikephil.charting.utils.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tencent.connect.common.Constants;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CostProjectListActivity extends BaseActivity {

    /* renamed from: A */
    private int f15609A;

    /* renamed from: C */
    private double f15611C;

    /* renamed from: D */
    private double f15612D;

    /* renamed from: E */
    private int f15613E;

    /* renamed from: F */
    private StringBuilder f15614F;

    /* renamed from: k */
    private SmartRefreshLayout f15615k;

    /* renamed from: l */
    private EmptyRecyclerView f15616l;

    /* renamed from: m */
    private TextView f15617m;

    /* renamed from: n */
    private TextView f15618n;

    /* renamed from: o */
    private TextView f15619o;

    /* renamed from: p */
    private TextView f15620p;

    /* renamed from: q */
    private CheckBox f15621q;

    /* renamed from: r */
    private LinearLayout f15622r;

    /* renamed from: w */
    private MultiItemCommonAdapter<Map<String, Object>> f15627w;

    /* renamed from: x */
    private String f15628x;

    /* renamed from: y */
    private StickyDecoration f15629y;

    /* renamed from: z */
    private String f15630z;

    /* renamed from: s */
    private List<Map<String, Object>> f15623s = new ArrayList();

    /* renamed from: t */
    private int f15624t = 1;

    /* renamed from: u */
    private int f15625u = 0;

    /* renamed from: v */
    private int f15626v = 10;

    /* renamed from: B */
    private double f15610B = Utils.DOUBLE_EPSILON;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.CostProjectListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4105a implements OnRefreshLoadmoreListener {
        C4105a() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            CostProjectListActivity.this.f15625u = 1;
            CostProjectListActivity.this.m43216F0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = CostProjectListActivity.this.f15624t / CostProjectListActivity.this.f15626v;
            int i2 = CostProjectListActivity.this.f15625u;
            if (CostProjectListActivity.this.f15624t % CostProjectListActivity.this.f15626v != 0) {
                i++;
            }
            if (i2 >= i) {
                CostProjectListActivity.this.f15615k.mo2041g();
                CostProjectListActivity.this.m57919h0("没有了");
                return;
            }
            CostProjectListActivity.m43198v0(CostProjectListActivity.this);
            CostProjectListActivity.this.m43216F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.CostProjectListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4106b implements InterfaceC1125a<Map<String, Object>> {
        C4106b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a
        /* renamed from: b */
        public int mo40464b(int itemType) {
            return C4017R.C4023layout.item_for_competition_cost;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a
        /* renamed from: c */
        public int mo40465a(int position, Map<String, Object> stringObjectMap) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.CostProjectListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4107c extends MultiItemCommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.competition.signup.CostProjectListActivity$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C4108a implements CompoundButton.OnCheckedChangeListener {

            /* renamed from: a */
            final /* synthetic */ Map f15634a;

            C4108a(final Map val$stringObjectMap) {
                this.f15634a = val$stringObjectMap;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                this.f15634a.put("isChecked", Boolean.valueOf(b));
                CostProjectListActivity.this.m43214H0();
            }
        }

        C4107c(Context x0, List x1, InterfaceC1125a x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(C4017R.C4021id.tv_name, JsonParse.getString(stringObjectMap, "itemName"));
            int i = JsonParse.getInt(stringObjectMap, "operation");
            CheckBox checkBox = (CheckBox) holder.m57862h(C4017R.C4021id.f15340cb);
            if (TextUtils.isEmpty(CostProjectListActivity.this.f15630z)) {
                int i2 = C4017R.C4021id.tv_price;
                holder.m57870N(i2, CostProjectListActivity.this.f15609A == 1);
                checkBox.setChecked(JsonParse.getBoolean(stringObjectMap, "isChecked"));
                checkBox.setOnCheckedChangeListener(new C4108a(stringObjectMap));
                checkBox.setChecked(i != 0);
                checkBox.setEnabled(i == 0);
                holder.m57874J(i2, "￥" + JsonParse.getMoney(stringObjectMap, "itemEntryFee"));
            } else if (i == 1) {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.m57874J(C4017R.C4021id.tv_price, "待审核");
            } else if (i == 2) {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.m57874J(C4017R.C4021id.tv_price, "驳回");
            } else if (i == 3) {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.m57874J(C4017R.C4021id.tv_price, "院系通过");
            } else if (i == 4) {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.m57874J(C4017R.C4021id.tv_price, "体育部审核");
            } else if (i == 5) {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.m57874J(C4017R.C4021id.tv_price, "体育部通过");
            } else {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.m57874J(C4017R.C4021id.tv_price, JsonParse.getString(stringObjectMap, "status"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.CostProjectListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4109d extends HttpCallBack {
        C4109d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            CostProjectListActivity.this.f15615k.mo2078B();
            CostProjectListActivity.this.f15615k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CostProjectListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CostProjectListActivity.this.f15609A = JsonParse.getInt(data, "signupType");
            CostProjectListActivity.this.f15624t = Integer.parseInt(Tools.m57632O(data, "total"));
            if (CostProjectListActivity.this.f15609A == 2) {
                TextView textView = CostProjectListActivity.this.f15619o;
                textView.setText("￥" + JsonParse.getMoney(data, "competitionEntryFee"));
            }
            CostProjectListActivity.this.f15611C = JsonParse.getDouble(data, "competitionEntryFee");
            CostProjectListActivity.this.f15610B = JsonParse.getDouble(data, "insuranceFee");
            TextView textView2 = CostProjectListActivity.this.f15620p;
            textView2.setText("￥" + JsonParse.getMoney(data, "insuranceFee"));
            List list = (List) data.get("itemDetail");
            if (CostProjectListActivity.this.f15625u == 1) {
                CostProjectListActivity.this.f15623s = list;
            } else {
                CostProjectListActivity.this.f15623s.addAll(list);
            }
            CostProjectListActivity.this.f15627w.m57836g(CostProjectListActivity.this.f15623s);
            try {
                CostProjectListActivity.this.f15616l.removeItemDecoration(CostProjectListActivity.this.f15629y);
            } catch (Exception e) {
                e.printStackTrace();
            }
            CostProjectListActivity.this.f15616l.addItemDecoration(CostProjectListActivity.this.f15629y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.CostProjectListActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4110e extends HttpCallBack {
        C4110e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            CostProjectListActivity.this.f15615k.mo2078B();
            CostProjectListActivity.this.f15615k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CostProjectListActivity.this.f15624t = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            if (CostProjectListActivity.this.f15625u == 1) {
                CostProjectListActivity.this.f15623s = list;
            } else {
                CostProjectListActivity.this.f15623s.addAll(list);
            }
            CostProjectListActivity.this.f15627w.m57836g(CostProjectListActivity.this.f15623s);
            try {
                CostProjectListActivity.this.f15616l.removeItemDecoration(CostProjectListActivity.this.f15629y);
            } catch (Exception e) {
                e.printStackTrace();
            }
            CostProjectListActivity.this.f15616l.addItemDecoration(CostProjectListActivity.this.f15629y);
        }
    }

    /* renamed from: com.bxkj.competition.signup.CostProjectListActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4111f implements CompoundButton.OnCheckedChangeListener {
        C4111f() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            CostProjectListActivity.this.m43214H0();
        }
    }

    /* renamed from: E0 */
    private void m43217E0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public void m43216F0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43455b(this.f15628x, LoginUser.getLoginUser().getUserId())).setDataListener(new C4109d());
    }

    /* renamed from: G0 */
    private void m43215G0() {
        Http.with(this.f1669h).setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43452e(this.f15628x, LoginUser.getLoginUser().getUserId())).setDataListener(new C4110e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public void m43214H0() {
        new BigDecimal(1.0d);
        this.f15613E = 0;
        this.f15614F = new StringBuilder();
        double d = Utils.DOUBLE_EPSILON;
        double d2 = 0.0d;
        for (Map<String, Object> map : this.f15623s) {
            if (JsonParse.getBoolean(map, "isChecked")) {
                this.f15613E++;
                d2 += new BigDecimal(JsonParse.getDouble(map, "itemEntryFee")).setScale(2, 4).doubleValue();
                if (!TextUtils.isEmpty(this.f15614F)) {
                    this.f15614F.append(",");
                }
                this.f15614F.append(JsonParse.getString(map, "id"));
            }
        }
        this.f15618n.setText("共" + this.f15613E + "项合计：");
        if (this.f15609A == 2) {
            d2 = this.f15611C;
        }
        if (this.f15621q.isChecked()) {
            d = this.f15610B;
        }
        this.f15619o.setText("￥" + new DecimalFormat("0.00").format(d2));
        this.f15612D = new BigDecimal(d2).setScale(2, 4).doubleValue() + new BigDecimal(d).setScale(2, 4).doubleValue();
        this.f15617m.setText("确认报名(￥" + new DecimalFormat("0.00").format(new BigDecimal(this.f15612D).setScale(2, 4).doubleValue()) + ")");
    }

    /* renamed from: I0 */
    private void m43213I0() {
        C4106b c4106b = new C4106b();
        this.f15616l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, C4017R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f15616l.setLayoutAnimation(layoutAnimationController);
        C4107c c4107c = new C4107c(this.f1669h, this.f15623s, c4106b);
        this.f15627w = c4107c;
        this.f15616l.setAdapter(c4107c);
        this.f15616l.setEmptyView(findViewById(C4017R.C4021id.tv_emptyView));
        this.f15629y = new StickyDecoration(this.f1669h, this.f15623s);
    }

    /* renamed from: J0 */
    private void m43212J0() {
        this.f15615k.mo2019v(new C4105a());
    }

    /* renamed from: v0 */
    static /* synthetic */ int m43198v0(CostProjectListActivity costProjectListActivity) {
        int i = costProjectListActivity.f15625u;
        costProjectListActivity.f15625u = i + 1;
        return i;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15617m.setOnClickListener(this);
        this.f15621q.setOnCheckedChangeListener(new C4111f());
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
            this.f15628x = getIntent().getStringExtra("competitionId");
        }
        if (getIntent().hasExtra(Constants.FROM)) {
            this.f15630z = getIntent().getStringExtra(Constants.FROM);
        }
        m43212J0();
        m43213I0();
        this.f15615k.mo2050b0(false);
        this.f15615k.mo2064P(false);
        if (!TextUtils.isEmpty(this.f15630z)) {
            setTitle("我报名的竞赛项目");
            this.f15622r.setVisibility(8);
            m43215G0();
            return;
        }
        m43216F0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("竞赛报名项目列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15615k = (SmartRefreshLayout) findViewById(C4017R.C4021id.refresh);
        this.f15616l = (EmptyRecyclerView) findViewById(C4017R.C4021id.recyclerView);
        this.f15617m = (TextView) findViewById(C4017R.C4021id.tv_ok);
        this.f15618n = (TextView) findViewById(C4017R.C4021id.tv_count);
        this.f15619o = (TextView) findViewById(C4017R.C4021id.tv_price);
        this.f15620p = (TextView) findViewById(C4017R.C4021id.tv_bx_price);
        this.f15621q = (CheckBox) findViewById(C4017R.C4021id.cb_insurance);
        LinearLayout linearLayout = (LinearLayout) findViewById(C4017R.C4021id.ll_bottom);
        this.f15622r = linearLayout;
        linearLayout.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == C4017R.C4021id.tv_ok) {
            if (TextUtils.isEmpty(this.f15614F)) {
                m57919h0("请选择项目");
            } else {
                startActivity(new Intent(this.f1669h, CompetitionPayActivity.class).putExtra("competitionId", this.f15628x).putExtra("itemIds", this.f15614F.toString().trim()).putExtra("insuranceFee", this.f15621q.isChecked() ? this.f15610B : Utils.DOUBLE_EPSILON).putExtra("competitionFee", this.f15611C).putExtra("totalPrice", this.f15612D).putExtra("payPrize", this.f15612D));
            }
        }
    }
}
