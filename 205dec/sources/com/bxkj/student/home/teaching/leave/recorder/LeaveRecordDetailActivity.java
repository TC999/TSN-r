package com.bxkj.student.home.teaching.leave.recorder;

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
public class LeaveRecordDetailActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f21088k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f21089l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f21090m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f21091n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f21092o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f21093p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f21094q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f21095r;

    /* renamed from: s  reason: collision with root package name */
    private MyGridView f21096s;

    /* renamed from: t  reason: collision with root package name */
    private String f21097t;

    /* renamed from: u  reason: collision with root package name */
    private List<String> f21098u;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.teaching.leave.recorder.LeaveRecordDetailActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class C0241a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
            C0241a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
            /* renamed from: d */
            public void a(ViewHolder holder, String s3) {
                holder.s(2131231436, s3);
            }
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LeaveRecordDetailActivity.this.R().setVisibility(0);
            LeaveRecordDetailActivity.this.f21088k.setText(JsonParse.getString(data, "week"));
            LeaveRecordDetailActivity.this.f21089l.setText(JsonParse.getString(data, "teacherCurriculumName"));
            LeaveRecordDetailActivity.this.f21090m.setText(JsonParse.getString(data, "auditorName"));
            LeaveRecordDetailActivity.this.f21091n.setText(JsonParse.getString(data, "applyDate"));
            LeaveRecordDetailActivity.this.f21092o.setText(JsonParse.getString(data, "applyMemo"));
            LeaveRecordDetailActivity.this.f21093p.setText(JsonParse.getString(data, "status"));
            String string = JsonParse.getString(data, "auditDate");
            if (TextUtils.isEmpty(string)) {
                ((View) LeaveRecordDetailActivity.this.f21094q.getParent()).setVisibility(8);
            } else {
                ((View) LeaveRecordDetailActivity.this.f21094q.getParent()).setVisibility(0);
            }
            LeaveRecordDetailActivity.this.f21094q.setText(string);
            String string2 = JsonParse.getString(data, "auditMemo");
            if (TextUtils.isEmpty(string2)) {
                ((View) LeaveRecordDetailActivity.this.f21095r.getParent()).setVisibility(8);
            } else {
                ((View) LeaveRecordDetailActivity.this.f21095r.getParent()).setVisibility(0);
            }
            LeaveRecordDetailActivity.this.f21095r.setText(string2);
            LeaveRecordDetailActivity.this.f21098u = JsonParse.getList(data, "imgs", String.class);
            LeaveRecordDetailActivity.this.f21096s.setAdapter((ListAdapter) new C0241a(((BaseActivity) LeaveRecordDetailActivity.this).f1656h, 2131427721, LeaveRecordDetailActivity.this.f21098u));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(AdapterView adapterView, View view, int i4, long j4) {
        w0((String[]) this.f21098u.toArray(new String[this.f21098u.size()]), i4);
    }

    private void w0(String[] arr, int position) {
        Intent intent = new Intent(this.f1656h, ImagePagerActivity.class);
        intent.putExtra("image_urls", arr);
        intent.putExtra("image_index", position);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21096s.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.leave.recorder.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                LeaveRecordDetailActivity.this.v0(adapterView, view, i4, j4);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427429;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        R().setVisibility(8);
        if (getIntent().hasExtra("id")) {
            this.f21097t = getIntent().getStringExtra("id");
        }
        Http.with(this.f1656h).setLoadingMessage("\u52a0\u8f7d\u4e2d...").setObservable(((w.a) Http.getApiService(w.a.class)).B(this.f21097t)).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8bf7\u5047\u8bb0\u5f55\u8be6\u60c5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21088k = (TextView) findViewById(2131233230);
        this.f21089l = (TextView) findViewById(2131233012);
        this.f21090m = (TextView) findViewById(2131233191);
        this.f21091n = (TextView) findViewById(2131233198);
        this.f21092o = (TextView) findViewById(2131233119);
        this.f21093p = (TextView) findViewById(2131233169);
        this.f21094q = (TextView) findViewById(2131232898);
        this.f21095r = (TextView) findViewById(2131232897);
        this.f21096s = (MyGridView) findViewById(2131231335);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
