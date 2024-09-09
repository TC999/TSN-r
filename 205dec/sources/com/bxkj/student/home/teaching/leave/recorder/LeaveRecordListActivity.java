package com.bxkj.student.home.teaching.leave.recorder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LeaveRecordListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EmptyRecyclerView f21101k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f21102l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f21103m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private String f21104n;

    /* renamed from: o  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21105o;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131233230, "\u5468\u6570\uff1a" + JsonParse.getString(stringObjectMap, "week"));
            holder.J(2131233169, "\u72b6\u6001\uff1a" + JsonParse.getString(stringObjectMap, "status"));
            holder.J(2131233191, "\u6559\u5e08\uff1a" + JsonParse.getString(stringObjectMap, "auditorName"));
            holder.J(2131233011, "\u8bfe\u7a0b\uff1a" + JsonParse.getString(stringObjectMap, "teacherCurriculumName"));
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
            LeaveRecordListActivity.this.f21103m = JsonParse.getList(data, "data");
            LeaveRecordListActivity.this.f21105o.g(LeaveRecordListActivity.this.f21103m);
        }
    }

    private void m0() {
        Http.with(this.f1656h).setLoadingMessage("\u52a0\u8f7d\u4e2d...").setObservable(((w.a) Http.getApiService(w.a.class)).S(this.f21104n)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(ViewGroup viewGroup, View view, Object obj, int i4) {
        startActivity(new Intent(this.f1656h, LeaveRecordDetailActivity.class).putExtra("id", JsonParse.getString(this.f21105o.getItem(i4), "id")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21105o.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.teaching.leave.recorder.b
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i4) {
                LeaveRecordListActivity.this.n0(viewGroup, view, obj, i4);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428025;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("id")) {
            this.f21104n = getIntent().getStringExtra("id");
        }
        this.f21101k.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427713, this.f21103m);
        this.f21105o = aVar;
        this.f21101k.setAdapter(aVar);
        this.f21101k.setEmptyView(this.f21102l);
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8bf7\u5047\u8bb0\u5f55\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21101k = (EmptyRecyclerView) findViewById(2131232481);
        this.f21102l = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
