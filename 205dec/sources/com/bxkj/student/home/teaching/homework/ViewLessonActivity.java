package com.bxkj.student.home.teaching.homework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.homework.ViewLessonActivity;
import com.bxkj.student.home.teaching.homework.question.list.QuestionListActivity;
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
    private SmartRefreshLayout f20333k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f20334l;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20336n;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f20335m = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    protected int f20337o = 10;

    /* renamed from: p  reason: collision with root package name */
    protected int f20338p = 1;

    /* renamed from: q  reason: collision with root package name */
    protected int f20339q = 1;

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
        /* renamed from: com.bxkj.student.home.teaching.homework.ViewLessonActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0233a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f20341a;

            View$OnClickListenerC0233a(final Map val$stringObjectMap) {
                this.f20341a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                ViewLessonActivity.this.startActivity(new Intent(((CommonAdapter) a.this).f1707a, QuestionListActivity.class).putExtra("teacherCurriculumId", JsonParse.getString(this.f20341a, "id")));
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(Map map, View view) {
            ViewLessonActivity.this.q0(JsonParse.getString(map, "classimg"));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233014, JsonParse.getString(stringObjectMap, "teacherCurriculumTeachingCurriculumName"));
            holder.J(2131232927, JsonParse.getString(stringObjectMap, "teacherCurriculumSysTermName"));
            holder.J(2131233198, JsonParse.getString(stringObjectMap, "teacherCurriculumTeachingSchoolTimeName"));
            holder.J(2131232981, JsonParse.getString(stringObjectMap, "teacherCurriculumSysOrgName"));
            holder.J(2131233143, JsonParse.getString(stringObjectMap, "teacherCurriculumSysCampusName"));
            holder.J(2131233211, JsonParse.getString(stringObjectMap, "teacherCurriculumType"));
            holder.J(2131232964, JsonParse.getString(stringObjectMap, "teacherCurriculumFeature"));
            holder.J(2131233191, "\u6559\u5e08\uff1a" + JsonParse.getString(stringObjectMap, "teacherCurriculumSysUserName"));
            holder.N(2131232841, TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "address")) ^ true);
            holder.J(2131232841, JsonParse.getString(stringObjectMap, "address"));
            ((Button) holder.h(2131230989)).setText("\u8bfe\u540e\u4f5c\u4e1a");
            holder.N(2131230998, true);
            holder.w(2131230998, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewLessonActivity.a.this.p(stringObjectMap, view);
                }
            });
            holder.w(2131230989, new View$OnClickListenerC0233a(stringObjectMap));
            holder.N(2131230998, false);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f20343a;

        b(final int val$position) {
            this.f20343a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.f20336n.d().remove(this.f20343a);
            ViewLessonActivity.this.f20336n.notifyItemRemoved(this.f20343a);
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
            viewLessonActivity.f20338p = 1;
            viewLessonActivity.n0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            int i4 = viewLessonActivity.f20339q;
            int i5 = viewLessonActivity.f20337o;
            int i6 = i4 / i5;
            int i7 = viewLessonActivity.f20338p;
            if (i4 % i5 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                viewLessonActivity.f20333k.h();
                Toast.makeText(((BaseActivity) ViewLessonActivity.this).f1656h, "\u6ca1\u6709\u4e86", 0).show();
                return;
            }
            viewLessonActivity.f20338p = i7 + 1;
            viewLessonActivity.n0();
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
            ViewLessonActivity.this.f20333k.y();
            ViewLessonActivity.this.f20333k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.f20339q = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d4 = ViewLessonActivity.this.f20336n.d();
            if (ViewLessonActivity.this.f20338p != 1) {
                d4.addAll(list);
                list = d4;
            }
            ViewLessonActivity.this.f20336n.g(list);
        }
    }

    private void m0(final int position) {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).w1(JsonParse.getString(this.f20336n.getItem(position), "id"))).setDataListener(new b(position));
    }

    private rx.e<Response<ResponseBody>> o0() {
        return ((w.a) Http.getApiService(w.a.class)).Q0(LoginUser.getLoginUser().getUserId(), getIntent().getStringExtra("id"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(String url) {
        Intent intent = new Intent(this.f1656h, ImagePagerActivity.class);
        intent.putExtra("image_urls", new String[]{url});
        intent.putExtra("image_index", 1);
        intent.putExtra("is_show_save_button", true);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427439;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f20333k.O(false);
        this.f20334l.setLayoutManager(new LinearLayoutManager(this.f1656h, 1, false));
        a aVar = new a(this.f1656h, 2131427715, this.f20335m);
        this.f20336n = aVar;
        this.f20334l.setAdapter(aVar);
        p0();
        this.f20333k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8bfe\u540e\u4f5c\u4e1a-\u67e5\u770b" + LoginUser.getLoginUser().getViewAfterLabelName());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        ((Spinner) findViewById(2131232642)).setVisibility(8);
        this.f20333k = (SmartRefreshLayout) findViewById(2131232483);
        this.f20334l = (RecyclerView) findViewById(2131232481);
    }

    public void n0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(o0()).setDataListener(new d());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    public void p0() {
        this.f20333k.n1(new c());
    }
}
