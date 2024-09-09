package com.bxkj.student.home.teaching.exam.record;

import android.content.Context;
import android.content.Intent;
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
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.exam.record.ExamRecordActivity;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ExamRecordActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f20274k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f20275l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20276m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f20277n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f20278o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f20279p;

    /* renamed from: q  reason: collision with root package name */
    private EmptyRecyclerView f20280q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f20281r;

    /* renamed from: s  reason: collision with root package name */
    private List<Map<String, Object>> f20282s;

    /* renamed from: t  reason: collision with root package name */
    private String f20283t;

    /* renamed from: u  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20284u;

    /* renamed from: v  reason: collision with root package name */
    private int f20285v = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(ViewHolder viewHolder, Map map) {
            ExamRecordActivity.this.q0(viewHolder.f(), JsonParse.getString(map, "stuId"), JsonParse.getString(map, "identify"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(final ViewHolder viewHolder, final Map map, View view) {
            new iOSTwoButtonDialog(this.f1707a).setMessage("\u786e\u5b9a\u8981\u5220\u9664\u5417\uff1f").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.exam.record.c
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    ExamRecordActivity.a.this.q(viewHolder, map);
                }
            }).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(boolean z3, Map map, View view) {
            if (z3) {
                ExamRecordActivity.this.startActivity(new Intent(this.f1707a, ExamDetailActivity.class).putExtra("stuTeacherCurriculumId", JsonParse.getString(map, "stuId")).putExtra("identify", JsonParse.getString(map, "identify")));
            }
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: p */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233045, (holder.f() + 1) + "");
            holder.J(2131233012, JsonParse.getString(stringObjectMap, "createTime"));
            holder.J(2131233191, JsonParse.getString(stringObjectMap, "teaUser"));
            holder.J(2131233146, JsonParse.getString(stringObjectMap, "score"));
            holder.N(2131230971, JsonParse.getBoolean(stringObjectMap, "isDelete"));
            final boolean z3 = JsonParse.getBoolean(stringObjectMap, "isToView");
            holder.N(2131231390, z3);
            holder.n(2131232217, z3);
            holder.w(2131230971, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.record.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamRecordActivity.a.this.r(holder, stringObjectMap, view);
                }
            });
            holder.w(2131232217, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.record.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamRecordActivity.a.this.s(z3, stringObjectMap, view);
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

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f20287a;

        b(final int val$position) {
            this.f20287a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamRecordActivity.this.f20282s.remove(this.f20287a);
            ExamRecordActivity.this.f20284u.notifyItemRemoved(this.f20287a);
            ExamRecordActivity.this.f20284u.notifyItemRangeChanged(this.f20287a, ExamRecordActivity.this.f20284u.getItemCount());
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
            ExamRecordActivity.this.f20282s = JsonParse.getList(data, "li");
            ExamRecordActivity.this.f20284u.g(ExamRecordActivity.this.f20282s);
            Map<String, Object> map = JsonParse.getMap(data, AdRequestConstant.AD_REQUEST_DEVICE_EXT_AV_KEY);
            TextView textView = ExamRecordActivity.this.f20276m;
            textView.setText("\u8003\u8bd5\u6b21\u6570\uff1a" + JsonParse.getString(map, "total"));
            TextView textView2 = ExamRecordActivity.this.f20277n;
            textView2.setText("\u5e73\u5747\u5206\uff1a" + JsonParse.getString(map, "avg"));
            TextView textView3 = ExamRecordActivity.this.f20278o;
            textView3.setText("\u603b\u6392\u540d\uff1a" + JsonParse.getString(map, "rank"));
            TextView textView4 = ExamRecordActivity.this.f20279p;
            textView4.setText("\u5e74\u7ea7\u6392\u540d\uff1a" + JsonParse.getString(map, "gradeRank"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(int position, String stuId, String identify) {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).d1(stuId, identify)).setDataListener(new b(position));
    }

    private void r0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).d0(this.f20283t, this.f20285v)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427396;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("onlineType")) {
            this.f20285v = getIntent().getIntExtra("onlineType", 0);
        }
        if (getIntent().hasExtra("studentChooseLessonId")) {
            this.f20283t = getIntent().getStringExtra("studentChooseLessonId");
        }
        this.f20280q.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427692, this.f20282s);
        this.f20284u = aVar;
        this.f20280q.setAdapter(aVar);
        this.f20280q.setEmptyView(this.f20281r);
        r0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u67e5\u770b\u8003\u8bd5\u8bb0\u5f55");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20274k = (TextView) findViewById(2131233040);
        this.f20275l = (TextView) findViewById(2131233051);
        this.f20276m = (TextView) findViewById(2131232914);
        this.f20277n = (TextView) findViewById(2131232855);
        this.f20278o = (TextView) findViewById(2131233208);
        this.f20279p = (TextView) findViewById(2131232982);
        this.f20280q = (EmptyRecyclerView) findViewById(2131232481);
        this.f20281r = (TextView) findViewById(2131232952);
        TextView textView = this.f20274k;
        textView.setText("\u59d3\u540d\uff1a" + LoginUser.getLoginUser().getRealName());
        TextView textView2 = this.f20275l;
        textView2.setText("\u5b66\u53f7\uff1a" + LoginUser.getLoginUser().getAccount());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
