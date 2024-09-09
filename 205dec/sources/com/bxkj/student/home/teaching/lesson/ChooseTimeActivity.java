package com.bxkj.student.home.teaching.lesson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
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
public class ChooseTimeActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private List<Map<String, Object>> f21133k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f21134l;

    /* renamed from: m  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21135m;

    /* renamed from: n  reason: collision with root package name */
    private String f21136n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.teaching.lesson.ChooseTimeActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0243a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f21138a;

            View$OnClickListenerC0243a(final Map val$stringObjectMap) {
                this.f21138a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                if (TextUtils.isEmpty(ChooseTimeActivity.this.f21136n)) {
                    ChooseTimeActivity.this.startActivity(new Intent(((CommonAdapter) a.this).f1707a, ChooseLessonActivity.class).putExtra("timeId", JsonParse.getString(this.f21138a, "id")));
                } else {
                    ChooseTimeActivity.this.startActivity(new Intent(((CommonAdapter) a.this).f1707a, OnLineLessonActivity.class).putExtra("timeId", JsonParse.getString(this.f21138a, "id")).putExtra("teachingId", ChooseTimeActivity.this.f21136n));
                }
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.w(2131233040, new View$OnClickListenerC0243a(stringObjectMap));
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
            ChooseTimeActivity.this.f21133k = JsonParse.getList(data, "data");
            ChooseTimeActivity.this.f21135m.g(ChooseTimeActivity.this.f21133k);
        }
    }

    private void m0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).m0(LoginUser.getLoginUser().getUserId(), this.f21136n)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428023;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("teachingId")) {
            this.f21136n = getIntent().getStringExtra("teachingId");
        }
        this.f21134l.setLayoutManager(new GridLayoutManager(this.f1656h, 3));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f21134l.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, 2131427677, this.f21133k);
        this.f21135m = aVar;
        this.f21134l.setAdapter(aVar);
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u9009\u62e9\u4e0a\u8bfe\u65f6\u95f4");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21134l = (RecyclerView) findViewById(2131232540);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
