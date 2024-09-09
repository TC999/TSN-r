package com.bxkj.student.home.teaching.lesson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ChooseLessonActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private List<Map<String, Object>> f21120k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f21121l;

    /* renamed from: m  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21122m;

    /* renamed from: n  reason: collision with root package name */
    private String f21123n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.teaching.lesson.ChooseLessonActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0242a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f21125a;

            View$OnClickListenerC0242a(final Map val$stringObjectMap) {
                this.f21125a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((CommonAdapter) a.this).f1707a);
                iOSOneButtonDialog oneButtonText = iosonebuttondialog.setTitle(LoginUser.getLoginUser().getXuanZeAfterLabelName() + "\u4ecb\u7ecd").setOneButtonText("\u77e5\u9053\u4e86");
                TextView textView = (TextView) oneButtonText.findViewById(2131232751);
                textView.setVisibility(0);
                textView.setText(Html.fromHtml(JsonParse.getString(this.f21125a, "introduce")));
                oneButtonText.show();
                oneButtonText.setMessageGrivity(3);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f21127a;

            b(final Map val$stringObjectMap) {
                this.f21127a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                ChooseLessonActivity.this.o0(this.f21127a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f21129a;

            c(final Map val$stringObjectMap) {
                this.f21129a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                ChooseLessonActivity.this.o0(this.f21129a);
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.w(2131232938, new View$OnClickListenerC0242a(stringObjectMap));
            holder.w(2131232955, new b(stringObjectMap));
            holder.w(2131233040, new c(stringObjectMap));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            ChooseLessonActivity.this.startActivity(new Intent(((BaseActivity) ChooseLessonActivity.this).f1656h, ChooseTimeActivity.class));
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
            ChooseLessonActivity.this.f21120k = JsonParse.getList(data, "data");
            ChooseLessonActivity.this.f21122m.g(ChooseLessonActivity.this.f21120k);
        }
    }

    private void n0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).v(LoginUser.getLoginUser().getUserId(), this.f21123n)).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(Map<String, Object> stringObjectMap) {
        if (TextUtils.isEmpty(this.f21123n)) {
            startActivity(new Intent(this.f1656h, ChooseTimeActivity.class).putExtra("teachingId", JsonParse.getString(stringObjectMap, "id")));
        } else {
            startActivity(new Intent(this.f1656h, OnLineLessonActivity.class).putExtra("teachingId", JsonParse.getString(stringObjectMap, "id")).putExtra("timeId", this.f21123n));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21122m.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428023;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("timeId")) {
            this.f21123n = getIntent().getStringExtra("timeId");
        }
        this.f21121l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f21121l.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, 2131427714, this.f21120k);
        this.f21122m = aVar;
        this.f21121l.setAdapter(aVar);
        n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u9009\u62e9" + LoginUser.getLoginUser().getXuanZeAfterLabelName());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21121l = (RecyclerView) findViewById(2131232540);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
