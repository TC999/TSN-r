package com.bxkj.student.home.teaching.evaluateteacher;

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
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshListener;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class EvaluateListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f16697k;

    /* renamed from: l */
    private EmptyRecyclerView f16698l;

    /* renamed from: m */
    private List<Map<String, Object>> f16699m = new ArrayList();

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f16700n;

    /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4435a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateListActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4436a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f16702a;

            View$OnClickListenerC4436a(final Map val$stringObjectMap) {
                this.f16702a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EvaluateListActivity evaluateListActivity = EvaluateListActivity.this;
                Map map = this.f16702a;
                evaluateListActivity.m42379q0(map, JsonParse.getString(map, "id"));
            }
        }

        C4435a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131232981, JsonParse.getString(stringObjectMap, "term"));
            holder.m57874J(C4215R.C4219id.tv_course_name, JsonParse.getString(stringObjectMap, "courseName"));
            holder.m57874J(C4215R.C4219id.tv_teacher_name, JsonParse.getString(stringObjectMap, "teacherName"));
            holder.m57870N(2131233146, !JsonParse.getString(stringObjectMap, "score").isEmpty());
            holder.m57870N(C4215R.C4219id.bt_evaluate, JsonParse.getString(stringObjectMap, "score").isEmpty());
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
            holder.m57874J(2131233169, str);
            holder.m57847w(C4215R.C4219id.bt_evaluate, new View$OnClickListenerC4436a(stringObjectMap));
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4437b implements OnRefreshListener {
        C4437b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            EvaluateListActivity.this.m42378r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4438c extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ Map f16705a;

        C4438c(final Map val$stringObjectMap) {
            this.f16705a = val$stringObjectMap;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) EvaluateListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            EvaluateListActivity.this.startActivity(new Intent(((BaseActivity) EvaluateListActivity.this).f1669h, EvaluateDescriptionActivity.class).putExtra("stuTeacherCurriculumId", JsonParse.getString(this.f16705a, "id")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4439d extends HttpCallBack {
        C4439d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            EvaluateListActivity.this.f16697k.mo2078B();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            EvaluateListActivity.this.f16699m = (List) data.get("data");
            EvaluateListActivity.this.f16700n.m57836g(EvaluateListActivity.this.f16699m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public void m42379q0(final Map<String, Object> stringObjectMap, String stuTeacherCurriculumId) {
        Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m132Y0(LoginUser.getLoginUser().getUserId(), stuTeacherCurriculumId)).setDataListener(new C4438c(stringObjectMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public void m42378r0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m68u0(LoginUser.getLoginUser().getUserId())).setDataListener(new C4439d());
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
        this.f16698l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f16698l.setLayoutAnimation(layoutAnimationController);
        C4435a c4435a = new C4435a(this.f1669h, C4215R.C4221layout.item_for_evaluate_techaer_list, this.f16699m);
        this.f16700n = c4435a;
        this.f16698l.setAdapter(c4435a);
        this.f16697k.mo2035j(new C4437b());
        this.f16697k.mo2050b0(true);
        this.f16697k.mo2064P(false);
        this.f16698l.setEmptyView(findViewById(2131232952));
        this.f16697k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("评价课程列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16697k = (SmartRefreshLayout) findViewById(2131232482);
        this.f16698l = (EmptyRecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.f16697k.mo2052a0();
    }
}
