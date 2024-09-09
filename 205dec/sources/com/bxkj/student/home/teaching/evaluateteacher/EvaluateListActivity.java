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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class EvaluateListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f20087k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f20088l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f20089m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20090n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateListActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0231a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f20092a;

            View$OnClickListenerC0231a(final Map val$stringObjectMap) {
                this.f20092a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                EvaluateListActivity evaluateListActivity = EvaluateListActivity.this;
                Map map = this.f20092a;
                evaluateListActivity.q0(map, JsonParse.getString(map, "id"));
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131232981, JsonParse.getString(stringObjectMap, "term"));
            holder.J(2131232921, JsonParse.getString(stringObjectMap, "courseName"));
            holder.J(2131233192, JsonParse.getString(stringObjectMap, "teacherName"));
            holder.N(2131233146, !JsonParse.getString(stringObjectMap, "score").isEmpty());
            holder.N(2131230976, JsonParse.getString(stringObjectMap, "score").isEmpty());
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
            holder.J(2131233169, str);
            holder.w(2131230976, new View$OnClickListenerC0231a(stringObjectMap));
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
            EvaluateListActivity.this.r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f20095a;

        c(final Map val$stringObjectMap) {
            this.f20095a = val$stringObjectMap;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) EvaluateListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            EvaluateListActivity.this.startActivity(new Intent(((BaseActivity) EvaluateListActivity.this).f1656h, EvaluateDescriptionActivity.class).putExtra("stuTeacherCurriculumId", JsonParse.getString(this.f20095a, "id")));
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
            EvaluateListActivity.this.f20087k.y();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            EvaluateListActivity.this.f20089m = (List) data.get("data");
            EvaluateListActivity.this.f20090n.g(EvaluateListActivity.this.f20089m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(final Map<String, Object> stringObjectMap, String stuTeacherCurriculumId) {
        Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).Y0(LoginUser.getLoginUser().getUserId(), stuTeacherCurriculumId)).setDataListener(new c(stringObjectMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((w.a) Http.getApiService(w.a.class)).u0(LoginUser.getLoginUser().getUserId())).setDataListener(new d());
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
        this.f20088l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f20088l.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, 2131427690, this.f20089m);
        this.f20090n = aVar;
        this.f20088l.setAdapter(aVar);
        this.f20087k.m1(new b());
        this.f20087k.b0(true);
        this.f20087k.O(false);
        this.f20088l.setEmptyView(findViewById(2131232952));
        this.f20087k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8bc4\u4ef7\u8bfe\u7a0b\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20087k = (SmartRefreshLayout) findViewById(2131232482);
        this.f20088l = (EmptyRecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.f20087k.a0();
    }
}
