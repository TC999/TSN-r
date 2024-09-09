package com.bxkj.student.home.teaching.separateexam;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.home.teaching.separateexam.AppointExamListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AppointExamListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f21309k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f21310l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f21311m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f21312n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21313o;

    /* renamed from: p  reason: collision with root package name */
    private String f21314p;

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
        /* renamed from: com.bxkj.student.home.teaching.separateexam.AppointExamListActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class C0248a implements iOSTwoButtonDialog.RightButtonOnClick {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f21316a;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* renamed from: com.bxkj.student.home.teaching.separateexam.AppointExamListActivity$a$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            class C0249a extends HttpCallBack {
                C0249a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    AppointExamListActivity.this.m0();
                }
            }

            C0248a(final Map val$stringObjectMap) {
                this.f21316a = val$stringObjectMap;
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                Http.with(((CommonAdapter) a.this).f1707a).setObservable(((w.a) Http.getApiService(w.a.class)).v1(AppointExamListActivity.this.f21314p, JsonParse.getString(this.f21316a, "id"))).setDataListener(new C0249a());
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(Map map, View view) {
            new iOSTwoButtonDialog(this.f1707a).setMessage("\u786e\u5b9a\u9009\u62e9\uff1f").setRightButtonOnClickListener(new C0248a(map)).show();
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.J(2131232981, JsonParse.getString(stringObjectMap, "sysOrgId"));
            holder.J(2131233012, JsonParse.getString(stringObjectMap, "TeachingId"));
            holder.J(2131233192, JsonParse.getString(stringObjectMap, "teacherId"));
            holder.J(2131233013, JsonParse.getString(stringObjectMap, "teachingCurriculumTotalName"));
            holder.J(2131232841, JsonParse.getString(stringObjectMap, "address"));
            holder.J(2131232851, JsonParse.getString(stringObjectMap, "appointmentTime"));
            holder.J(2131232958, JsonParse.getString(stringObjectMap, "examTime"));
            holder.w(2131231012, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.separateexam.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AppointExamListActivity.a.this.p(stringObjectMap, view);
                }
            });
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
            AppointExamListActivity.this.f21312n = JsonParse.getList(data, "data");
            AppointExamListActivity.this.f21313o.g(AppointExamListActivity.this.f21312n);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428026;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("stuid")) {
            this.f21314p = getIntent().getStringExtra("stuid");
        }
        this.f21310l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427676, this.f21312n);
        this.f21313o = aVar;
        this.f21310l.setAdapter(aVar);
        this.f21310l.setEmptyView(this.f21311m);
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u9884\u7ea6\u8003\u8bd5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21309k = (SmartRefreshLayout) findViewById(2131232482);
        this.f21310l = (EmptyRecyclerView) findViewById(2131232481);
        this.f21311m = (TextView) findViewById(2131232952);
        this.f21309k.b0(false);
        this.f21309k.O(false);
    }

    public void m0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).b0(this.f21314p)).setDataListener(new b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
