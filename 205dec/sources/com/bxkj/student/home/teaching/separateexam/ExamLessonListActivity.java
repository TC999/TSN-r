package com.bxkj.student.home.teaching.separateexam;

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
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.separateexam.ExamLessonListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ExamLessonListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f21324k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f21325l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f21326m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f21327n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21328o;

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
        public /* synthetic */ void o(Map map, View view) {
            ExamLessonListActivity.this.startActivity(new Intent(this.f1707a, ExamLessonDescriptionActivity.class).putExtra("stuid", JsonParse.getString(map, "stuid")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233014, "\u8bfe\u7a0b\uff1a" + JsonParse.getString(stringObjectMap, "curriculumName"));
            holder.J(2131233192, "\u6559\u5e08\uff1a" + JsonParse.getString(stringObjectMap, "teacherName"));
            holder.w(2131231012, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.separateexam.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamLessonListActivity.a.this.o(stringObjectMap, view);
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
            ExamLessonListActivity.this.f21327n = JsonParse.getList(data, "data");
            ExamLessonListActivity.this.f21328o.g(ExamLessonListActivity.this.f21327n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0() {
        startActivity(new Intent(this.f1656h, MyAppointExamListActivity.class));
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
        this.f21325l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427691, this.f21327n);
        this.f21328o = aVar;
        this.f21325l.setAdapter(aVar);
        this.f21325l.setEmptyView(this.f21326m);
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u9009\u62e9\u7ea6\u8003\u8bfe\u7a0b");
        d0("\u6211\u7684\u7ea6\u8003", new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.separateexam.b
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                ExamLessonListActivity.this.n0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21324k = (SmartRefreshLayout) findViewById(2131232482);
        this.f21325l = (EmptyRecyclerView) findViewById(2131232481);
        this.f21326m = (TextView) findViewById(2131232952);
        this.f21324k.b0(false);
        this.f21324k.O(false);
    }

    public void m0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).H0(LoginUser.getLoginUser().getUserId())).setDataListener(new b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
