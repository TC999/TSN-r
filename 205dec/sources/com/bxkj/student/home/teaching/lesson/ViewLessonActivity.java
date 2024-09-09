package com.bxkj.student.home.teaching.lesson;

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
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.m;
import com.bxkj.student.home.teaching.lesson.ViewLessonActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import r0.h;
import retrofit2.Response;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ViewLessonActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f21175k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f21176l;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21178n;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f21177m = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    protected int f21179o = 10;

    /* renamed from: p  reason: collision with root package name */
    protected int f21180p = 1;

    /* renamed from: q  reason: collision with root package name */
    protected int f21181q = 1;

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
        public /* synthetic */ void r(ViewHolder viewHolder) {
            ViewLessonActivity.this.m0(viewHolder.getAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(Button button, final ViewHolder viewHolder, View view) {
            if (button.getText().toString().trim().equals("\u53d6\u6d88")) {
                new iOSTwoButtonDialog(this.f1707a).setMessage("\u786e\u5b9a\u8981\u53d6\u6d88\u5417\uff1f").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.lesson.g
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        ViewLessonActivity.a.this.r(viewHolder);
                    }
                }).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(String str, View view) {
            if (TextUtils.isEmpty(str)) {
                new iOSOneButtonDialog(this.f1707a).setMessage("\u6559\u5e08\u672a\u4e0a\u4f20\u4e8c\u7ef4\u7801").show();
            } else {
                m.a(this.f1707a, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(String str, float f4, View view) {
            ViewLessonActivity.this.startActivity(new Intent(this.f1707a, CertificateActivity.class).putExtra("lessonName", str).putExtra("score", f4));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: q */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            final String string = JsonParse.getString(stringObjectMap, "teacherCurriculumTeachingCurriculumName");
            holder.J(2131233014, string);
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
            String string2 = JsonParse.getString(stringObjectMap, "canshu");
            final Button button = (Button) holder.h(2131230989);
            if (string2.equals("0")) {
                button.setEnabled(true);
                button.setText("\u53d6\u6d88");
                button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.lesson.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ViewLessonActivity.a.this.s(button, holder, view);
                    }
                });
            } else {
                button.setEnabled(false);
                button.setText("\u4e0d\u53ef\u53d6\u6d88");
            }
            final String string3 = JsonParse.getString(stringObjectMap, "classimg");
            holder.N(2131230998, true);
            holder.w(2131230998, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.lesson.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewLessonActivity.a.this.t(string3, view);
                }
            });
            final float f4 = JsonParse.getFloat(stringObjectMap, "scores");
            holder.N(2131230961, (LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("85") || LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("2") || LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("85") || LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("131")) && f4 >= 60.0f);
            holder.w(2131230961, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.lesson.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewLessonActivity.a.this.u(string, f4, view);
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
        final /* synthetic */ int f21183a;

        b(final int val$position) {
            this.f21183a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.f21178n.d().remove(this.f21183a);
            ViewLessonActivity.this.f21178n.notifyItemRemoved(this.f21183a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements s0.e {
        c() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            viewLessonActivity.f21180p = 1;
            viewLessonActivity.n0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            int i4 = viewLessonActivity.f21181q;
            int i5 = viewLessonActivity.f21179o;
            int i6 = i4 / i5;
            int i7 = viewLessonActivity.f21180p;
            if (i4 % i5 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                viewLessonActivity.f21175k.h();
                Toast.makeText(((BaseActivity) ViewLessonActivity.this).f1656h, "\u6ca1\u6709\u4e86", 0).show();
                return;
            }
            viewLessonActivity.f21180p = i7 + 1;
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
            ViewLessonActivity.this.f21175k.y();
            ViewLessonActivity.this.f21175k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.f21181q = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d4 = ViewLessonActivity.this.f21178n.d();
            if (ViewLessonActivity.this.f21180p != 1) {
                d4.addAll(list);
                list = d4;
            }
            ViewLessonActivity.this.f21178n.g(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(final int position) {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).w1(JsonParse.getString(this.f21178n.getItem(position), "id"))).setDataListener(new b(position));
    }

    private rx.e<Response<ResponseBody>> o0() {
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
        this.f21175k.O(false);
        this.f21176l.setLayoutManager(new LinearLayoutManager(this.f1656h, 1, false));
        a aVar = new a(this.f1656h, 2131427715, this.f21177m);
        this.f21178n = aVar;
        this.f21176l.setAdapter(aVar);
        p0();
        this.f21175k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u67e5\u770b" + LoginUser.getLoginUser().getViewAfterLabelName());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        ((Spinner) findViewById(2131232642)).setVisibility(8);
        this.f21175k = (SmartRefreshLayout) findViewById(2131232483);
        this.f21176l = (RecyclerView) findViewById(2131232481);
    }

    public void n0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(o0()).setDataListener(new d());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    public void p0() {
        this.f21175k.n1(new c());
    }
}
