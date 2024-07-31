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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LeaveRecordListActivity extends BaseActivity {

    /* renamed from: k */
    private EmptyRecyclerView f17763k;

    /* renamed from: l */
    private TextView f17764l;

    /* renamed from: m */
    private List<Map<String, Object>> f17765m = new ArrayList();

    /* renamed from: n */
    private String f17766n;

    /* renamed from: o */
    private CommonAdapter<Map<String, Object>> f17767o;

    /* renamed from: com.bxkj.student.home.teaching.leave.recorder.LeaveRecordListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4778a extends CommonAdapter<Map<String, Object>> {
        C4778a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv_week, "周数：" + JsonParse.getString(stringObjectMap, "week"));
            holder.m57874J(2131233169, "状态：" + JsonParse.getString(stringObjectMap, "status"));
            holder.m57874J(C4215R.C4219id.tv_teacher, "教师：" + JsonParse.getString(stringObjectMap, "auditorName"));
            holder.m57874J(C4215R.C4219id.tv_lessen_name, "课程：" + JsonParse.getString(stringObjectMap, "teacherCurriculumName"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.leave.recorder.LeaveRecordListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4779b extends HttpCallBack {
        C4779b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LeaveRecordListActivity.this.f17765m = JsonParse.getList(data, "data");
            LeaveRecordListActivity.this.f17767o.m57836g(LeaveRecordListActivity.this.f17765m);
        }
    }

    /* renamed from: m0 */
    private void m41365m0() {
        Http.with(this.f1669h).setLoadingMessage("加载中...").setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m145S(this.f17766n)).setDataListener(new C4779b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ void m41364n0(ViewGroup viewGroup, View view, Object obj, int i) {
        startActivity(new Intent(this.f1669h, LeaveRecordDetailActivity.class).putExtra("id", JsonParse.getString(this.f17767o.getItem(i), "id")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17767o.m57834k(new OnItemClickListener() { // from class: com.bxkj.student.home.teaching.leave.recorder.b
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
            /* renamed from: a */
            public final void mo39403a(ViewGroup viewGroup, View view, Object obj, int i) {
                LeaveRecordListActivity.this.m41364n0(viewGroup, view, obj, i);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return 2131428025;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("id")) {
            this.f17766n = getIntent().getStringExtra("id");
        }
        this.f17763k.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4778a c4778a = new C4778a(this.f1669h, C4215R.C4221layout.item_for_leave_record, this.f17765m);
        this.f17767o = c4778a;
        this.f17763k.setAdapter(c4778a);
        this.f17763k.setEmptyView(this.f17764l);
        m41365m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("请假记录列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17763k = (EmptyRecyclerView) findViewById(2131232481);
        this.f17764l = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
