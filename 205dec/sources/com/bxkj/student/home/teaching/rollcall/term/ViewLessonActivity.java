package com.bxkj.student.home.teaching.rollcall.term;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.rollcall.SignActivity;
import com.bxkj.student.home.teaching.rollcall.term.ViewLessonActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import r0.h;
import retrofit2.Response;
import s0.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ViewLessonActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f21283k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f21284l;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21286n;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f21285m = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    protected int f21287o = 10;

    /* renamed from: p  reason: collision with root package name */
    protected int f21288p = 1;

    /* renamed from: q  reason: collision with root package name */
    protected int f21289q = 1;

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
            ViewLessonActivity.this.startActivity(new Intent(this.f1707a, SignActivity.class).putExtra("id", JsonParse.getString(map, "id")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233014, JsonParse.getString(stringObjectMap, "teacherCurriculumTeachingCurriculumName"));
            holder.J(2131232927, JsonParse.getString(stringObjectMap, "teacherCurriculumSysTermName"));
            holder.J(2131233198, JsonParse.getString(stringObjectMap, "teacherCurriculumTeachingSchoolTimeName"));
            holder.J(2131232981, JsonParse.getString(stringObjectMap, "teacherCurriculumSysOrgName"));
            holder.J(2131233143, JsonParse.getString(stringObjectMap, "teacherCurriculumSysCampusName"));
            holder.J(2131233230, "\u7b2c" + JsonParse.getString(stringObjectMap, "parameter") + "\u5468");
            holder.J(2131233211, JsonParse.getString(stringObjectMap, "teacherCurriculumType"));
            holder.J(2131232964, JsonParse.getString(stringObjectMap, "teacherCurriculumFeature"));
            holder.J(2131233191, "\u6559\u5e08\uff1a" + JsonParse.getString(stringObjectMap, "teacherCurriculumSysUserName"));
            holder.N(2131232841, TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "address")) ^ true);
            holder.J(2131232841, JsonParse.getString(stringObjectMap, "address"));
            holder.N(2131230989, false);
            holder.N(2131230998, false);
            holder.N(2131230961, true);
            holder.J(2131230961, "\u4e0a\u8bfe\u7b7e\u5230");
            holder.w(2131230961, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.term.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewLessonActivity.a.this.o(stringObjectMap, view);
                }
            });
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f21291a;

        b(final int val$position) {
            this.f21291a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.f21286n.d().remove(this.f21291a);
            ViewLessonActivity.this.f21286n.notifyItemRemoved(this.f21291a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements e {
        c() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            viewLessonActivity.f21288p = 1;
            viewLessonActivity.m0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            int i4 = viewLessonActivity.f21289q;
            int i5 = viewLessonActivity.f21287o;
            int i6 = i4 / i5;
            int i7 = viewLessonActivity.f21288p;
            if (i4 % i5 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                viewLessonActivity.f21283k.h();
                Toast.makeText(((BaseActivity) ViewLessonActivity.this).f1656h, "\u6ca1\u6709\u4e86", 0).show();
                return;
            }
            viewLessonActivity.f21288p = i7 + 1;
            viewLessonActivity.m0();
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
            ViewLessonActivity.this.f21283k.y();
            ViewLessonActivity.this.f21283k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.f21289q = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d4 = ViewLessonActivity.this.f21286n.d();
            if (ViewLessonActivity.this.f21288p != 1) {
                d4.addAll(list);
                list = d4;
            }
            ViewLessonActivity.this.f21286n.g(list);
        }
    }

    private void l0(final int position) {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).w1(JsonParse.getString(this.f21286n.getItem(position), "id"))).setDataListener(new b(position));
    }

    private rx.e<Response<ResponseBody>> n0() {
        return ((w.a) Http.getApiService(w.a.class)).Q0(LoginUser.getLoginUser().getUserId(), getIntent().getStringExtra("id"));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427444;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f21283k.O(false);
        this.f21284l.setLayoutManager(new LinearLayoutManager(this.f1656h, 1, false));
        a aVar = new a(this.f1656h, 2131427715, this.f21285m);
        this.f21286n = aVar;
        this.f21284l.setAdapter(aVar);
        o0();
        this.f21283k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4e0a\u8bfe\u7b7e\u5230-\u67e5\u770b" + LoginUser.getLoginUser().getViewAfterLabelName());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        ((Spinner) findViewById(2131232642)).setVisibility(8);
        this.f21283k = (SmartRefreshLayout) findViewById(2131232483);
        this.f21284l = (RecyclerView) findViewById(2131232481);
    }

    public void m0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(n0()).setDataListener(new d());
    }

    public void o0() {
        this.f21283k.n1(new c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
