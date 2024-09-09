package com.bxkj.student.home.physicaltest.mc;

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
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ApplyMCDetailActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f19852k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f19853l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f19854m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f19855n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f19856o;

    /* renamed from: p  reason: collision with root package name */
    private MyGridView f19857p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f19858q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f19859r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f19860s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f19861t;

    /* renamed from: u  reason: collision with root package name */
    private String f19862u;

    /* renamed from: v  reason: collision with root package name */
    private List<String> f19863v;

    /* renamed from: w  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> f19864w;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d */
        public void a(ViewHolder holder, String s3) {
            holder.s(2131231436, s3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyMCDetailActivity.this.R().setVisibility(0);
            TextView textView = ApplyMCDetailActivity.this.f19852k;
            textView.setText("\u59d3\u540d\uff1a" + JsonParse.getString(data, "userName"));
            TextView textView2 = ApplyMCDetailActivity.this.f19853l;
            textView2.setText("\u5b66\u53f7\uff1a" + JsonParse.getString(data, "userNum"));
            TextView textView3 = ApplyMCDetailActivity.this.f19854m;
            textView3.setText("\u5b66\u671f\uff1a" + JsonParse.getString(data, "year"));
            TextView textView4 = ApplyMCDetailActivity.this.f19855n;
            textView4.setText("\u7c7b\u578b\uff1a" + JsonParse.getString(data, "meaStatusName"));
            TextView textView5 = ApplyMCDetailActivity.this.f19856o;
            textView5.setText("\u539f\u56e0\uff1a" + JsonParse.getString(data, "applyMemo"));
            TextView textView6 = ApplyMCDetailActivity.this.f19859r;
            textView6.setText("\u72b6\u6001\uff1a" + JsonParse.getString(data, "status"));
            TextView textView7 = ApplyMCDetailActivity.this.f19858q;
            textView7.setText("\u65f6\u95f4\uff1a" + JsonParse.getString(data, "applyDate"));
            String string = JsonParse.getString(data, "auditMemo");
            if (TextUtils.isEmpty(string)) {
                ApplyMCDetailActivity.this.f19860s.setVisibility(8);
            } else {
                ApplyMCDetailActivity.this.f19860s.setVisibility(0);
                TextView textView8 = ApplyMCDetailActivity.this.f19860s;
                textView8.setText("\u5ba1\u6279\u610f\u89c1\uff1a" + string);
            }
            ApplyMCDetailActivity.this.f19863v = JsonParse.getList(data, "imgs", String.class);
            ApplyMCDetailActivity.this.f19864w.c(ApplyMCDetailActivity.this.f19863v);
            if (JsonParse.getInt(data, "statusCode") == 0) {
                ApplyMCDetailActivity.this.f19861t.setVisibility(0);
            } else {
                ApplyMCDetailActivity.this.f19861t.setVisibility(8);
            }
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

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyMCDetailActivity.this.z0();
            ApplyMcListActivity applyMcListActivity = (ApplyMcListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(ApplyMcListActivity.class);
            if (applyMcListActivity != null) {
                applyMcListActivity.n0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(AdapterView adapterView, View view, int i4, long j4) {
        D0((String[]) this.f19863v.toArray(new String[this.f19863v.size()]), i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(View view) {
        new iOSTwoButtonDialog(this.f1656h).setMessage("\u786e\u5b9a\u8981\u53d6\u6d88\u7533\u8bf7\u5417\uff1f").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.physicaltest.mc.e
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                ApplyMCDetailActivity.this.B0();
            }
        }).show();
    }

    private void D0(String[] arr, int position) {
        Intent intent = new Intent(this.f1656h, ImagePagerActivity.class);
        intent.putExtra("image_urls", arr);
        intent.putExtra("image_index", position);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public void B0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).r1(this.f19862u)).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).M(this.f19862u)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19857p.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.physicaltest.mc.d
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                ApplyMCDetailActivity.this.A0(adapterView, view, i4, j4);
            }
        });
        this.f19861t.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.physicaltest.mc.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyMCDetailActivity.this.C0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427365;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("meaNonStuApplyId")) {
            this.f19862u = getIntent().getStringExtra("meaNonStuApplyId");
        }
        a aVar = new a(this.f1656h, 2131427721, this.f19863v);
        this.f19864w = aVar;
        this.f19857p.setAdapter((ListAdapter) aVar);
        z0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7533\u8bf7\u514d\u6d4b\u8be6\u60c5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19852k = (TextView) findViewById(2131233040);
        this.f19853l = (TextView) findViewById(2131233051);
        this.f19854m = (TextView) findViewById(2131233194);
        this.f19855n = (TextView) findViewById(2131233211);
        this.f19856o = (TextView) findViewById(2131233119);
        this.f19857p = (MyGridView) findViewById(2131231336);
        this.f19858q = (TextView) findViewById(2131233198);
        this.f19859r = (TextView) findViewById(2131233169);
        this.f19860s = (TextView) findViewById(2131232853);
        this.f19861t = (TextView) findViewById(2131230959);
        R().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
