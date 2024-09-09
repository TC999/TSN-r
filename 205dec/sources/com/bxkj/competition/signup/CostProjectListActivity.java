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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.R;
import com.bxkj.competition.signup.pay.CompetitionPayActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CostProjectListActivity extends BaseActivity {
    private int A;
    private double C;
    private double D;
    private int E;
    private StringBuilder F;

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f19145k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f19146l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f19147m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f19148n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f19149o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f19150p;

    /* renamed from: q  reason: collision with root package name */
    private CheckBox f19151q;

    /* renamed from: r  reason: collision with root package name */
    private LinearLayout f19152r;

    /* renamed from: w  reason: collision with root package name */
    private MultiItemCommonAdapter<Map<String, Object>> f19157w;

    /* renamed from: x  reason: collision with root package name */
    private String f19158x;

    /* renamed from: y  reason: collision with root package name */
    private StickyDecoration f19159y;

    /* renamed from: z  reason: collision with root package name */
    private String f19160z;

    /* renamed from: s  reason: collision with root package name */
    private List<Map<String, Object>> f19153s = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    private int f19154t = 1;

    /* renamed from: u  reason: collision with root package name */
    private int f19155u = 0;

    /* renamed from: v  reason: collision with root package name */
    private int f19156v = 10;
    private double B = 0.0d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements s0.e {
        a() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            CostProjectListActivity.this.f19155u = 1;
            CostProjectListActivity.this.F0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = CostProjectListActivity.this.f19154t / CostProjectListActivity.this.f19156v;
            int i5 = CostProjectListActivity.this.f19155u;
            if (CostProjectListActivity.this.f19154t % CostProjectListActivity.this.f19156v != 0) {
                i4++;
            }
            if (i5 >= i4) {
                CostProjectListActivity.this.f19145k.h();
                CostProjectListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            CostProjectListActivity.v0(CostProjectListActivity.this);
            CostProjectListActivity.this.F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.a<Map<String, Object>> {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int b(int itemType) {
            return R.layout.item_for_competition_cost;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        /* renamed from: c */
        public int a(int position, Map<String, Object> stringObjectMap) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends MultiItemCommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class a implements CompoundButton.OnCheckedChangeListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f19164a;

            a(final Map val$stringObjectMap) {
                this.f19164a = val$stringObjectMap;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean b4) {
                this.f19164a.put("isChecked", Boolean.valueOf(b4));
                CostProjectListActivity.this.H0();
            }
        }

        c(Context x02, List x12, cn.bluemobi.dylan.base.adapter.common.recyclerview.a x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, "itemName"));
            int i4 = JsonParse.getInt(stringObjectMap, "operation");
            CheckBox checkBox = (CheckBox) holder.h(R.id.cb);
            if (TextUtils.isEmpty(CostProjectListActivity.this.f19160z)) {
                int i5 = R.id.tv_price;
                holder.N(i5, CostProjectListActivity.this.A == 1);
                checkBox.setChecked(JsonParse.getBoolean(stringObjectMap, "isChecked"));
                checkBox.setOnCheckedChangeListener(new a(stringObjectMap));
                checkBox.setChecked(i4 != 0);
                checkBox.setEnabled(i4 == 0);
                holder.J(i5, "\uffe5" + JsonParse.getMoney(stringObjectMap, "itemEntryFee"));
            } else if (i4 == 1) {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.J(R.id.tv_price, "\u5f85\u5ba1\u6838");
            } else if (i4 == 2) {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.J(R.id.tv_price, "\u9a73\u56de");
            } else if (i4 == 3) {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.J(R.id.tv_price, "\u9662\u7cfb\u901a\u8fc7");
            } else if (i4 == 4) {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.J(R.id.tv_price, "\u4f53\u80b2\u90e8\u5ba1\u6838");
            } else if (i4 == 5) {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.J(R.id.tv_price, "\u4f53\u80b2\u90e8\u901a\u8fc7");
            } else {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.J(R.id.tv_price, JsonParse.getString(stringObjectMap, "status"));
            }
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
            CostProjectListActivity.this.f19145k.y();
            CostProjectListActivity.this.f19145k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CostProjectListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CostProjectListActivity.this.A = JsonParse.getInt(data, "signupType");
            CostProjectListActivity.this.f19154t = Integer.parseInt(u.O(data, "total"));
            if (CostProjectListActivity.this.A == 2) {
                TextView textView = CostProjectListActivity.this.f19149o;
                textView.setText("\uffe5" + JsonParse.getMoney(data, "competitionEntryFee"));
            }
            CostProjectListActivity.this.C = JsonParse.getDouble(data, "competitionEntryFee");
            CostProjectListActivity.this.B = JsonParse.getDouble(data, "insuranceFee");
            TextView textView2 = CostProjectListActivity.this.f19150p;
            textView2.setText("\uffe5" + JsonParse.getMoney(data, "insuranceFee"));
            List list = (List) data.get("itemDetail");
            if (CostProjectListActivity.this.f19155u == 1) {
                CostProjectListActivity.this.f19153s = list;
            } else {
                CostProjectListActivity.this.f19153s.addAll(list);
            }
            CostProjectListActivity.this.f19157w.g(CostProjectListActivity.this.f19153s);
            try {
                CostProjectListActivity.this.f19146l.removeItemDecoration(CostProjectListActivity.this.f19159y);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            CostProjectListActivity.this.f19146l.addItemDecoration(CostProjectListActivity.this.f19159y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            CostProjectListActivity.this.f19145k.y();
            CostProjectListActivity.this.f19145k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CostProjectListActivity.this.f19154t = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (CostProjectListActivity.this.f19155u == 1) {
                CostProjectListActivity.this.f19153s = list;
            } else {
                CostProjectListActivity.this.f19153s.addAll(list);
            }
            CostProjectListActivity.this.f19157w.g(CostProjectListActivity.this.f19153s);
            try {
                CostProjectListActivity.this.f19146l.removeItemDecoration(CostProjectListActivity.this.f19159y);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            CostProjectListActivity.this.f19146l.addItemDecoration(CostProjectListActivity.this.f19159y);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class f implements CompoundButton.OnCheckedChangeListener {
        f() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean b4) {
            CostProjectListActivity.this.H0();
        }
    }

    private void E0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).b(this.f19158x, LoginUser.getLoginUser().getUserId())).setDataListener(new d());
    }

    private void G0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).e(this.f19158x, LoginUser.getLoginUser().getUserId())).setDataListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        new BigDecimal(1.0d);
        this.E = 0;
        this.F = new StringBuilder();
        double d4 = 0.0d;
        for (Map<String, Object> map : this.f19153s) {
            if (JsonParse.getBoolean(map, "isChecked")) {
                this.E++;
                d4 += new BigDecimal(JsonParse.getDouble(map, "itemEntryFee")).setScale(2, 4).doubleValue();
                if (!TextUtils.isEmpty(this.F)) {
                    this.F.append(",");
                }
                this.F.append(JsonParse.getString(map, "id"));
            }
        }
        this.f19148n.setText("\u5171" + this.E + "\u9879\u5408\u8ba1\uff1a");
        if (this.A == 2) {
            d4 = this.C;
        }
        double d5 = this.f19151q.isChecked() ? this.B : 0.0d;
        this.f19149o.setText("\uffe5" + new DecimalFormat("0.00").format(d4));
        this.D = new BigDecimal(d4).setScale(2, 4).doubleValue() + new BigDecimal(d5).setScale(2, 4).doubleValue();
        this.f19147m.setText("\u786e\u8ba4\u62a5\u540d(\uffe5" + new DecimalFormat("0.00").format(new BigDecimal(this.D).setScale(2, 4).doubleValue()) + ")");
    }

    private void I0() {
        b bVar = new b();
        this.f19146l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f19146l.setLayoutAnimation(layoutAnimationController);
        c cVar = new c(this.f1656h, this.f19153s, bVar);
        this.f19157w = cVar;
        this.f19146l.setAdapter(cVar);
        this.f19146l.setEmptyView(findViewById(R.id.tv_emptyView));
        this.f19159y = new StickyDecoration(this.f1656h, this.f19153s);
    }

    private void J0() {
        this.f19145k.n1(new a());
    }

    static /* synthetic */ int v0(CostProjectListActivity costProjectListActivity) {
        int i4 = costProjectListActivity.f19155u;
        costProjectListActivity.f19155u = i4 + 1;
        return i4;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19147m.setOnClickListener(this);
        this.f19151q.setOnCheckedChangeListener(new f());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_competition_project_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f19158x = getIntent().getStringExtra("competitionId");
        }
        if (getIntent().hasExtra("from")) {
            this.f19160z = getIntent().getStringExtra("from");
        }
        J0();
        I0();
        this.f19145k.b0(false);
        this.f19145k.O(false);
        if (!TextUtils.isEmpty(this.f19160z)) {
            setTitle("\u6211\u62a5\u540d\u7684\u7ade\u8d5b\u9879\u76ee");
            this.f19152r.setVisibility(8);
            G0();
            return;
        }
        F0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7ade\u8d5b\u62a5\u540d\u9879\u76ee\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19145k = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.f19146l = (EmptyRecyclerView) findViewById(R.id.recyclerView);
        this.f19147m = (TextView) findViewById(R.id.tv_ok);
        this.f19148n = (TextView) findViewById(R.id.tv_count);
        this.f19149o = (TextView) findViewById(R.id.tv_price);
        this.f19150p = (TextView) findViewById(R.id.tv_bx_price);
        this.f19151q = (CheckBox) findViewById(R.id.cb_insurance);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_bottom);
        this.f19152r = linearLayout;
        linearLayout.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() == R.id.tv_ok) {
            if (TextUtils.isEmpty(this.F)) {
                h0("\u8bf7\u9009\u62e9\u9879\u76ee");
            } else {
                startActivity(new Intent(this.f1656h, CompetitionPayActivity.class).putExtra("competitionId", this.f19158x).putExtra("itemIds", this.F.toString().trim()).putExtra("insuranceFee", this.f19151q.isChecked() ? this.B : 0.0d).putExtra("competitionFee", this.C).putExtra("totalPrice", this.D).putExtra("payPrize", this.D));
            }
        }
    }
}
