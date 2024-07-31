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
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.student.C4215R;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LeaveRecordDetailActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f17750k;

    /* renamed from: l */
    private TextView f17751l;

    /* renamed from: m */
    private TextView f17752m;

    /* renamed from: n */
    private TextView f17753n;

    /* renamed from: o */
    private TextView f17754o;

    /* renamed from: p */
    private TextView f17755p;

    /* renamed from: q */
    private TextView f17756q;

    /* renamed from: r */
    private TextView f17757r;

    /* renamed from: s */
    private MyGridView f17758s;

    /* renamed from: t */
    private String f17759t;

    /* renamed from: u */
    private List<String> f17760u;

    /* renamed from: com.bxkj.student.home.teaching.leave.recorder.LeaveRecordDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4776a extends HttpCallBack {

        /* renamed from: com.bxkj.student.home.teaching.leave.recorder.LeaveRecordDetailActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4777a extends CommonAdapter<String> {
            C4777a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
            /* renamed from: d */
            public void mo40086a(ViewHolder holder, String s) {
                holder.m57851s(C4215R.C4219id.iv_img, s);
            }
        }

        C4776a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LeaveRecordDetailActivity.this.m57932R().setVisibility(0);
            LeaveRecordDetailActivity.this.f17750k.setText(JsonParse.getString(data, "week"));
            LeaveRecordDetailActivity.this.f17751l.setText(JsonParse.getString(data, "teacherCurriculumName"));
            LeaveRecordDetailActivity.this.f17752m.setText(JsonParse.getString(data, "auditorName"));
            LeaveRecordDetailActivity.this.f17753n.setText(JsonParse.getString(data, "applyDate"));
            LeaveRecordDetailActivity.this.f17754o.setText(JsonParse.getString(data, "applyMemo"));
            LeaveRecordDetailActivity.this.f17755p.setText(JsonParse.getString(data, "status"));
            String string = JsonParse.getString(data, "auditDate");
            if (TextUtils.isEmpty(string)) {
                ((View) LeaveRecordDetailActivity.this.f17756q.getParent()).setVisibility(8);
            } else {
                ((View) LeaveRecordDetailActivity.this.f17756q.getParent()).setVisibility(0);
            }
            LeaveRecordDetailActivity.this.f17756q.setText(string);
            String string2 = JsonParse.getString(data, "auditMemo");
            if (TextUtils.isEmpty(string2)) {
                ((View) LeaveRecordDetailActivity.this.f17757r.getParent()).setVisibility(8);
            } else {
                ((View) LeaveRecordDetailActivity.this.f17757r.getParent()).setVisibility(0);
            }
            LeaveRecordDetailActivity.this.f17757r.setText(string2);
            LeaveRecordDetailActivity.this.f17760u = JsonParse.getList(data, "imgs", String.class);
            LeaveRecordDetailActivity.this.f17758s.setAdapter((ListAdapter) new C4777a(((BaseActivity) LeaveRecordDetailActivity.this).f1669h, C4215R.C4221layout.item_for_lost_img, LeaveRecordDetailActivity.this.f17760u));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void m41372v0(AdapterView adapterView, View view, int i, long j) {
        m41371w0((String[]) this.f17760u.toArray(new String[this.f17760u.size()]), i);
    }

    /* renamed from: w0 */
    private void m41371w0(String[] arr, int position) {
        Intent intent = new Intent(this.f1669h, ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.f1869h, arr);
        intent.putExtra(ImagePagerActivity.f1868g, position);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17758s.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.leave.recorder.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                LeaveRecordDetailActivity.this.m41372v0(adapterView, view, i, j);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_leave_record_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m57932R().setVisibility(8);
        if (getIntent().hasExtra("id")) {
            this.f17759t = getIntent().getStringExtra("id");
        }
        Http.with(this.f1669h).setLoadingMessage("加载中...").setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m186B(this.f17759t)).setDataListener(new C4776a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("请假记录详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17750k = (TextView) findViewById(C4215R.C4219id.tv_week);
        this.f17751l = (TextView) findViewById(C4215R.C4219id.tv_lesson);
        this.f17752m = (TextView) findViewById(C4215R.C4219id.tv_teacher);
        this.f17753n = (TextView) findViewById(2131233198);
        this.f17754o = (TextView) findViewById(C4215R.C4219id.tv_reason);
        this.f17755p = (TextView) findViewById(2131233169);
        this.f17756q = (TextView) findViewById(C4215R.C4219id.tv_check_time);
        this.f17757r = (TextView) findViewById(C4215R.C4219id.tv_check_reason);
        this.f17758s = (MyGridView) findViewById(2131231335);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
