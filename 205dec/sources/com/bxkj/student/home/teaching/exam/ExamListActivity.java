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
import com.bxkj.student.home.teaching.evaluateteacher.EvaluateListActivity;
import com.bxkj.student.home.teaching.exam.ExamListActivity;
import com.bxkj.student.home.teaching.exam.record.ExamRecordActivity;
import com.bxkj.student.run.app.face.widget.FaceDetect5ExpActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ExamListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f20104k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f20105l;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20107n;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f20106m = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private int f20108o = 0;

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
        public /* synthetic */ void p(Map map, boolean z3, View view) {
            ExamListActivity.this.w0(JsonParse.getString(map, "id"), z3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(Map map, View view) {
            ExamListActivity examListActivity = ExamListActivity.this;
            examListActivity.startActivity(examListActivity.getIntent().setClass(this.f1707a, ExamRecordActivity.class).putExtra("studentChooseLessonId", JsonParse.getString(map, "id")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131232981, JsonParse.getString(stringObjectMap, "term"));
            holder.J(2131232921, JsonParse.getString(stringObjectMap, "courseName"));
            holder.J(2131233192, JsonParse.getString(stringObjectMap, "teacherName"));
            holder.N(2131233146, !JsonParse.getString(stringObjectMap, "score").isEmpty());
            holder.N(2131230976, JsonParse.getBoolean(stringObjectMap, "isExam"));
            holder.N(2131232854, JsonParse.getBoolean(stringObjectMap, "isExam"));
            holder.J(2131233146, JsonParse.getString(stringObjectMap, "score"));
            String string = JsonParse.getString(stringObjectMap, "type");
            String str = "0";
            if ("0".equals(string)) {
                str = "\u6b63\u5e38";
            } else if ("1".equals(string)) {
                str = "\u4fdd\u5065";
            } else if ("2".equals(string)) {
                str = "\u7279\u62db";
            } else if ("3".equals(string)) {
                str = "\u51fa\u56fd";
            } else if ("4".equals(string)) {
                str = "\u670d\u5f79";
            } else if ("5".equals(string)) {
                str = "\u4f11\u5b66";
            }
            final boolean z3 = JsonParse.getBoolean(stringObjectMap, "isShowList");
            holder.J(2131233169, str);
            holder.J(2131230976, "\u5f00\u59cb\u8003\u8bd5");
            holder.w(2131230976, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamListActivity.a.this.p(stringObjectMap, z3, view);
                }
            });
            holder.N(2131231001, z3);
            holder.w(2131231001, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamListActivity.a.this.q(stringObjectMap, view);
                }
            });
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements s0.d {
        b() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            ExamListActivity.this.v0();
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

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ExamListActivity.this.f20104k.y();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamListActivity.this.f20106m = (List) data.get("data");
            ExamListActivity.this.f20107n.g(ExamListActivity.this.f20106m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f20112a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f20113b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements iOSTwoButtonDialog.RightButtonOnClick {
            a() {
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                ((BaseActivity) ExamListActivity.this).f1656h.startActivity(new Intent(((BaseActivity) ExamListActivity.this).f1656h, EvaluateListActivity.class));
            }
        }

        d(final String val$stuTeacherCurriculumId, final boolean val$isShowList) {
            this.f20112a = val$stuTeacherCurriculumId;
            this.f20113b = val$isShowList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            ExamListActivity.this.startActivity(new Intent(((BaseActivity) ExamListActivity.this).f1656h, FaceDetect5ExpActivity.class));
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            if (status == 202) {
                new iOSOneButtonDialog(((BaseActivity) ExamListActivity.this).f1656h).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ExamListActivity.d.this.b(view);
                    }
                }).show();
            } else {
                new iOSOneButtonDialog(((BaseActivity) ExamListActivity.this).f1656h).setMessage(msg).show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getBoolean(data, "data")) {
                ExamListActivity examListActivity = ExamListActivity.this;
                examListActivity.startActivity(examListActivity.getIntent().setClass(((BaseActivity) ExamListActivity.this).f1656h, ExamDescriptionActivity.class).putExtra("stuTeacherCurriculumId", this.f20112a).putExtra("isShowList", this.f20113b));
                return;
            }
            new iOSTwoButtonDialog(((BaseActivity) ExamListActivity.this).f1656h).setTitle("\u63d0\u793a").setMessage("\u60a8\u8fd8\u672a\u8bc4\u4ef7\u6559\u5e08\uff0c\u8bf7\u5148\u53bb\u8bc4\u4ef7\u6559\u5e08").setRightButtonOnClickListener(new a()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        Http.with(this.f1656h).hideLoadingDialog().hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).h0(LoginUser.getLoginUser().getUserId(), this.f20108o)).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(final String stuTeacherCurriculumId, boolean isShowList) {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).X(stuTeacherCurriculumId, LoginUser.getLoginUser().getUserId(), this.f20108o)).setDataListener(new d(stuTeacherCurriculumId, isShowList));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427460;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("onlineType")) {
            this.f20108o = getIntent().getIntExtra("onlineType", 0);
        }
        this.f20105l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f20105l.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, 2131427690, this.f20106m);
        this.f20107n = aVar;
        this.f20105l.setAdapter(aVar);
        this.f20104k.m1(new b());
        this.f20104k.b0(true);
        this.f20104k.O(false);
        this.f20105l.setEmptyView(findViewById(2131232952));
        this.f20104k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        if (getIntent().hasExtra("title")) {
            setTitle(getIntent().getStringExtra("title"));
        } else {
            setTitle("\u8003\u8bd5\u8bfe\u7a0b");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20104k = (SmartRefreshLayout) findViewById(2131232482);
        this.f20105l = (EmptyRecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.f20104k.a0();
    }
}
