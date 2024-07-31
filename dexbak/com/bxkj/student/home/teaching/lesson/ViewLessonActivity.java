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
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.C3906m;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.lesson.ViewLessonActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import p638r0.RefreshLayout;
import p640rx.Observable;
import p642s0.OnRefreshLoadmoreListener;
import p653w.InterfaceC16236a;
import retrofit2.Response;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ViewLessonActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f17837k;

    /* renamed from: l */
    private RecyclerView f17838l;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f17840n;

    /* renamed from: m */
    private List<Map<String, Object>> f17839m = new ArrayList();

    /* renamed from: o */
    protected int f17841o = 10;

    /* renamed from: p */
    protected int f17842p = 1;

    /* renamed from: q */
    protected int f17843q = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.lesson.ViewLessonActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4807a extends CommonAdapter<Map<String, Object>> {
        C4807a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: r */
        public /* synthetic */ void m41285r(ViewHolder viewHolder) {
            ViewLessonActivity.this.m41294m0(viewHolder.getAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: s */
        public /* synthetic */ void m41284s(Button button, final ViewHolder viewHolder, View view) {
            if (button.getText().toString().trim().equals("取消")) {
                new iOSTwoButtonDialog(this.f1721a).setMessage("确定要取消吗？").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.lesson.g
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        ViewLessonActivity.C4807a.this.m41285r(viewHolder);
                    }
                }).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: t */
        public /* synthetic */ void m41283t(String str, View view) {
            if (TextUtils.isEmpty(str)) {
                new iOSOneButtonDialog(this.f1721a).setMessage("教师未上传二维码").show();
            } else {
                C3906m.m44069a(this.f1721a, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: u */
        public /* synthetic */ void m41282u(String str, float f, View view) {
            ViewLessonActivity.this.startActivity(new Intent(this.f1721a, CertificateActivity.class).putExtra("lessonName", str).putExtra("score", f));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: q */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            final String string = JsonParse.getString(stringObjectMap, "teacherCurriculumTeachingCurriculumName");
            holder.m57874J(C4215R.C4219id.tv_lesson_name, string);
            holder.m57874J(2131232927, JsonParse.getString(stringObjectMap, "teacherCurriculumSysTermName"));
            holder.m57874J(2131233198, JsonParse.getString(stringObjectMap, "teacherCurriculumTeachingSchoolTimeName"));
            holder.m57874J(2131232981, JsonParse.getString(stringObjectMap, "teacherCurriculumSysOrgName"));
            holder.m57874J(C4215R.C4219id.tv_school_area, JsonParse.getString(stringObjectMap, "teacherCurriculumSysCampusName"));
            holder.m57874J(C4215R.C4219id.tv_week, "第" + JsonParse.getString(stringObjectMap, "parameter") + "周");
            holder.m57874J(2131233211, JsonParse.getString(stringObjectMap, "teacherCurriculumType"));
            holder.m57874J(C4215R.C4219id.tv_feature, JsonParse.getString(stringObjectMap, "teacherCurriculumFeature"));
            holder.m57874J(C4215R.C4219id.tv_teacher, "教师：" + JsonParse.getString(stringObjectMap, "teacherCurriculumSysUserName"));
            holder.m57870N(2131232841, TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "address")) ^ true);
            holder.m57874J(2131232841, JsonParse.getString(stringObjectMap, "address"));
            String string2 = JsonParse.getString(stringObjectMap, "canshu");
            final Button button = (Button) holder.m57862h(2131230989);
            if (string2.equals("0")) {
                button.setEnabled(true);
                button.setText("取消");
                button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.lesson.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ViewLessonActivity.C4807a.this.m41284s(button, holder, view);
                    }
                });
            } else {
                button.setEnabled(false);
                button.setText("不可取消");
            }
            final String string3 = JsonParse.getString(stringObjectMap, "classimg");
            holder.m57870N(C4215R.C4219id.bt_qrcode, true);
            holder.m57847w(C4215R.C4219id.bt_qrcode, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.lesson.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewLessonActivity.C4807a.this.m41283t(string3, view);
                }
            });
            final float f = JsonParse.getFloat(stringObjectMap, "scores");
            holder.m57870N(C4215R.C4219id.bt_certificate, (LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("85") || LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("2") || LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("85") || LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("131")) && f >= 60.0f);
            holder.m57847w(C4215R.C4219id.bt_certificate, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.lesson.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewLessonActivity.C4807a.this.m41282u(string, f, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.lesson.ViewLessonActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4808b extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ int f17845a;

        C4808b(final int val$position) {
            this.f17845a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.f17840n.m57837d().remove(this.f17845a);
            ViewLessonActivity.this.f17840n.notifyItemRemoved(this.f17845a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.lesson.ViewLessonActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4809c implements OnRefreshLoadmoreListener {
        C4809c() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            viewLessonActivity.f17842p = 1;
            viewLessonActivity.m41293n0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            int i = viewLessonActivity.f17843q;
            int i2 = viewLessonActivity.f17841o;
            int i3 = i / i2;
            int i4 = viewLessonActivity.f17842p;
            if (i % i2 != 0) {
                i3++;
            }
            if (i4 >= i3) {
                viewLessonActivity.f17837k.mo2041g();
                Toast.makeText(((BaseActivity) ViewLessonActivity.this).f1669h, "没有了", 0).show();
                return;
            }
            viewLessonActivity.f17842p = i4 + 1;
            viewLessonActivity.m41293n0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.lesson.ViewLessonActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4810d extends HttpCallBack {
        C4810d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ViewLessonActivity.this.f17837k.mo2078B();
            ViewLessonActivity.this.f17837k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.f17843q = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            List m57837d = ViewLessonActivity.this.f17840n.m57837d();
            if (ViewLessonActivity.this.f17842p != 1) {
                m57837d.addAll(list);
                list = m57837d;
            }
            ViewLessonActivity.this.f17840n.m57836g(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public void m41294m0(final int position) {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m61w1(JsonParse.getString(this.f17840n.getItem(position), "id"))).setDataListener(new C4808b(position));
    }

    /* renamed from: o0 */
    private Observable<Response<ResponseBody>> m41292o0() {
        return ((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m148Q0(LoginUser.getLoginUser().getUserId(), getIntent().getStringExtra("id"));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_online_lesson;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f17837k.mo2064P(false);
        this.f17838l.setLayoutManager(new LinearLayoutManager(this.f1669h, 1, false));
        C4807a c4807a = new C4807a(this.f1669h, C4215R.C4221layout.item_for_lesson_list, this.f17839m);
        this.f17840n = c4807a;
        this.f17838l.setAdapter(c4807a);
        m41291p0();
        this.f17837k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("查看" + LoginUser.getLoginUser().getViewAfterLabelName());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        ((Spinner) findViewById(2131232642)).setVisibility(8);
        this.f17837k = (SmartRefreshLayout) findViewById(2131232483);
        this.f17838l = (RecyclerView) findViewById(2131232481);
    }

    /* renamed from: n0 */
    public void m41293n0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(m41292o0()).setDataListener(new C4810d());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* renamed from: p0 */
    public void m41291p0() {
        this.f17837k.mo2019v(new C4809c());
    }
}
