package com.bxkj.student.home.teaching.exam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.evaluateteacher.EvaluateListActivity;
import com.bxkj.student.home.teaching.exam.ExamListActivity;
import com.bxkj.student.home.teaching.exam.record.ExamRecordActivity;
import com.bxkj.student.run.app.face.widget.FaceDetect5ExpActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshListener;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ExamListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f16714k;

    /* renamed from: l */
    private EmptyRecyclerView f16715l;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f16717n;

    /* renamed from: m */
    private List<Map<String, Object>> f16716m = new ArrayList();

    /* renamed from: o */
    private int f16718o = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.ExamListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4443a extends CommonAdapter<Map<String, Object>> {
        C4443a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: p */
        public /* synthetic */ void m42350p(Map map, boolean z, View view) {
            ExamListActivity.this.m42354w0(JsonParse.getString(map, "id"), z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: q */
        public /* synthetic */ void m42349q(Map map, View view) {
            ExamListActivity examListActivity = ExamListActivity.this;
            examListActivity.startActivity(examListActivity.getIntent().setClass(this.f1721a, ExamRecordActivity.class).putExtra("studentChooseLessonId", JsonParse.getString(map, "id")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131232981, JsonParse.getString(stringObjectMap, "term"));
            holder.m57874J(C4215R.C4219id.tv_course_name, JsonParse.getString(stringObjectMap, "courseName"));
            holder.m57874J(C4215R.C4219id.tv_teacher_name, JsonParse.getString(stringObjectMap, "teacherName"));
            holder.m57870N(2131233146, !JsonParse.getString(stringObjectMap, "score").isEmpty());
            holder.m57870N(C4215R.C4219id.bt_evaluate, JsonParse.getBoolean(stringObjectMap, "isExam"));
            holder.m57870N(C4215R.C4219id.tv_arrow_right, JsonParse.getBoolean(stringObjectMap, "isExam"));
            holder.m57874J(2131233146, JsonParse.getString(stringObjectMap, "score"));
            String string = JsonParse.getString(stringObjectMap, "type");
            String str = "0";
            if ("0".equals(string)) {
                str = "正常";
            } else if ("1".equals(string)) {
                str = "保健";
            } else if ("2".equals(string)) {
                str = "特招";
            } else if ("3".equals(string)) {
                str = "出国";
            } else if ("4".equals(string)) {
                str = "服役";
            } else if ("5".equals(string)) {
                str = "休学";
            }
            final boolean z = JsonParse.getBoolean(stringObjectMap, "isShowList");
            holder.m57874J(2131233169, str);
            holder.m57874J(C4215R.C4219id.bt_evaluate, "开始考试");
            holder.m57847w(C4215R.C4219id.bt_evaluate, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamListActivity.C4443a.this.m42350p(stringObjectMap, z, view);
                }
            });
            holder.m57870N(C4215R.C4219id.bt_recorder, z);
            holder.m57847w(C4215R.C4219id.bt_recorder, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamListActivity.C4443a.this.m42349q(stringObjectMap, view);
                }
            });
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.exam.ExamListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4444b implements OnRefreshListener {
        C4444b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            ExamListActivity.this.m42355v0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.ExamListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4445c extends HttpCallBack {
        C4445c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ExamListActivity.this.f16714k.mo2078B();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamListActivity.this.f16716m = (List) data.get("data");
            ExamListActivity.this.f16717n.m57836g(ExamListActivity.this.f16716m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.ExamListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4446d extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ String f16722a;

        /* renamed from: b */
        final /* synthetic */ boolean f16723b;

        /* renamed from: com.bxkj.student.home.teaching.exam.ExamListActivity$d$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4447a implements iOSTwoButtonDialog.RightButtonOnClick {
            C4447a() {
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                ((BaseActivity) ExamListActivity.this).f1669h.startActivity(new Intent(((BaseActivity) ExamListActivity.this).f1669h, EvaluateListActivity.class));
            }
        }

        C4446d(final String val$stuTeacherCurriculumId, final boolean val$isShowList) {
            this.f16722a = val$stuTeacherCurriculumId;
            this.f16723b = val$isShowList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m42347b(View view) {
            ExamListActivity.this.startActivity(new Intent(((BaseActivity) ExamListActivity.this).f1669h, FaceDetect5ExpActivity.class));
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            if (status == 202) {
                new iOSOneButtonDialog(((BaseActivity) ExamListActivity.this).f1669h).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ExamListActivity.C4446d.this.m42347b(view);
                    }
                }).show();
            } else {
                new iOSOneButtonDialog(((BaseActivity) ExamListActivity.this).f1669h).setMessage(msg).show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getBoolean(data, "data")) {
                ExamListActivity examListActivity = ExamListActivity.this;
                examListActivity.startActivity(examListActivity.getIntent().setClass(((BaseActivity) ExamListActivity.this).f1669h, ExamDescriptionActivity.class).putExtra("stuTeacherCurriculumId", this.f16722a).putExtra("isShowList", this.f16723b));
                return;
            }
            new iOSTwoButtonDialog(((BaseActivity) ExamListActivity.this).f1669h).setTitle("提示").setMessage("您还未评价教师，请先去评价教师").setRightButtonOnClickListener(new C4447a()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public void m42355v0() {
        Http.with(this.f1669h).hideLoadingDialog().hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m107h0(LoginUser.getLoginUser().getUserId(), this.f16718o)).setDataListener(new C4445c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public void m42354w0(final String stuTeacherCurriculumId, boolean isShowList) {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m135X(stuTeacherCurriculumId, LoginUser.getLoginUser().getUserId(), this.f16718o)).setDataListener(new C4446d(stuTeacherCurriculumId, isShowList));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return 2131427460;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("onlineType")) {
            this.f16718o = getIntent().getIntExtra("onlineType", 0);
        }
        this.f16715l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f16715l.setLayoutAnimation(layoutAnimationController);
        C4443a c4443a = new C4443a(this.f1669h, C4215R.C4221layout.item_for_evaluate_techaer_list, this.f16716m);
        this.f16717n = c4443a;
        this.f16715l.setAdapter(c4443a);
        this.f16714k.mo2035j(new C4444b());
        this.f16714k.mo2050b0(true);
        this.f16714k.mo2064P(false);
        this.f16715l.setEmptyView(findViewById(2131232952));
        this.f16714k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        if (getIntent().hasExtra("title")) {
            setTitle(getIntent().getStringExtra("title"));
        } else {
            setTitle("考试课程");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16714k = (SmartRefreshLayout) findViewById(2131232482);
        this.f16715l = (EmptyRecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.f16714k.mo2052a0();
    }
}
