package com.bxkj.student.home.physicaltest.p089mc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.student.C4215R;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* renamed from: com.bxkj.student.home.physicaltest.mc.ApplyMCDetailActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ApplyMCDetailActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f16462k;

    /* renamed from: l */
    private TextView f16463l;

    /* renamed from: m */
    private TextView f16464m;

    /* renamed from: n */
    private TextView f16465n;

    /* renamed from: o */
    private TextView f16466o;

    /* renamed from: p */
    private MyGridView f16467p;

    /* renamed from: q */
    private TextView f16468q;

    /* renamed from: r */
    private TextView f16469r;

    /* renamed from: s */
    private TextView f16470s;

    /* renamed from: t */
    private TextView f16471t;

    /* renamed from: u */
    private String f16472u;

    /* renamed from: v */
    private List<String> f16473v;

    /* renamed from: w */
    private CommonAdapter<String> f16474w;

    /* renamed from: com.bxkj.student.home.physicaltest.mc.ApplyMCDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4350a extends CommonAdapter<String> {
        C4350a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, String s) {
            holder.m57851s(C4215R.C4219id.iv_img, s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.mc.ApplyMCDetailActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4351b extends HttpCallBack {
        C4351b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyMCDetailActivity.this.m57932R().setVisibility(0);
            TextView textView = ApplyMCDetailActivity.this.f16462k;
            textView.setText("姓名：" + JsonParse.getString(data, "userName"));
            TextView textView2 = ApplyMCDetailActivity.this.f16463l;
            textView2.setText("学号：" + JsonParse.getString(data, "userNum"));
            TextView textView3 = ApplyMCDetailActivity.this.f16464m;
            textView3.setText("学期：" + JsonParse.getString(data, "year"));
            TextView textView4 = ApplyMCDetailActivity.this.f16465n;
            textView4.setText("类型：" + JsonParse.getString(data, "meaStatusName"));
            TextView textView5 = ApplyMCDetailActivity.this.f16466o;
            textView5.setText("原因：" + JsonParse.getString(data, "applyMemo"));
            TextView textView6 = ApplyMCDetailActivity.this.f16469r;
            textView6.setText("状态：" + JsonParse.getString(data, "status"));
            TextView textView7 = ApplyMCDetailActivity.this.f16468q;
            textView7.setText("时间：" + JsonParse.getString(data, "applyDate"));
            String string = JsonParse.getString(data, "auditMemo");
            if (TextUtils.isEmpty(string)) {
                ApplyMCDetailActivity.this.f16470s.setVisibility(8);
            } else {
                ApplyMCDetailActivity.this.f16470s.setVisibility(0);
                TextView textView8 = ApplyMCDetailActivity.this.f16470s;
                textView8.setText("审批意见：" + string);
            }
            ApplyMCDetailActivity.this.f16473v = JsonParse.getList(data, "imgs", String.class);
            ApplyMCDetailActivity.this.f16474w.m57842c(ApplyMCDetailActivity.this.f16473v);
            if (JsonParse.getInt(data, "statusCode") == 0) {
                ApplyMCDetailActivity.this.f16471t.setVisibility(0);
            } else {
                ApplyMCDetailActivity.this.f16471t.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.mc.ApplyMCDetailActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4352c extends HttpCallBack {
        C4352c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyMCDetailActivity.this.m42587z0();
            ApplyMcListActivity applyMcListActivity = (ApplyMcListActivity) AppManager.m57776n().getActivity(ApplyMcListActivity.class);
            if (applyMcListActivity != null) {
                applyMcListActivity.m42580n0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public /* synthetic */ void m42608A0(AdapterView adapterView, View view, int i, long j) {
        m42605D0((String[]) this.f16473v.toArray(new String[this.f16473v.size()]), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0 */
    public /* synthetic */ void m42606C0(View view) {
        new iOSTwoButtonDialog(this.f1669h).setMessage("确定要取消申请吗？").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.physicaltest.mc.e
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                ApplyMCDetailActivity.this.m42607B0();
            }
        }).show();
    }

    /* renamed from: D0 */
    private void m42605D0(String[] arr, int position) {
        Intent intent = new Intent(this.f1669h, ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.f1869h, arr);
        intent.putExtra(ImagePagerActivity.f1868g, position);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public void m42607B0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m76r1(this.f16472u)).setDataListener(new C4352c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public void m42587z0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m157M(this.f16472u)).setDataListener(new C4351b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16467p.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.physicaltest.mc.d
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                ApplyMCDetailActivity.this.m42608A0(adapterView, view, i, j);
            }
        });
        this.f16471t.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.physicaltest.mc.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyMCDetailActivity.this.m42606C0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_apply_mc_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("meaNonStuApplyId")) {
            this.f16472u = getIntent().getStringExtra("meaNonStuApplyId");
        }
        C4350a c4350a = new C4350a(this.f1669h, C4215R.C4221layout.item_for_lost_img, this.f16473v);
        this.f16474w = c4350a;
        this.f16467p.setAdapter((ListAdapter) c4350a);
        m42587z0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("申请免测详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16462k = (TextView) findViewById(2131233040);
        this.f16463l = (TextView) findViewById(2131233051);
        this.f16464m = (TextView) findViewById(C4215R.C4219id.tv_team);
        this.f16465n = (TextView) findViewById(2131233211);
        this.f16466o = (TextView) findViewById(C4215R.C4219id.tv_reason);
        this.f16467p = (MyGridView) findViewById(C4215R.C4219id.gv_img);
        this.f16468q = (TextView) findViewById(2131233198);
        this.f16469r = (TextView) findViewById(2131233169);
        this.f16470s = (TextView) findViewById(C4215R.C4219id.tv_approval_comments);
        this.f16471t = (TextView) findViewById(2131230959);
        m57932R().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
