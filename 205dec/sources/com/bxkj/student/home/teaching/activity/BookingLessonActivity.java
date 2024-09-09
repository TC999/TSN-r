package com.bxkj.student.home.teaching.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.lesson.ChooseTimeActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class BookingLessonActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private List<Map<String, Object>> f20030k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f20031l;

    /* renamed from: m  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20032m;

    /* renamed from: n  reason: collision with root package name */
    private String f20033n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.teaching.activity.BookingLessonActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0228a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f20035a;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* renamed from: com.bxkj.student.home.teaching.activity.BookingLessonActivity$a$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            class C0229a extends HttpCallBack {
                C0229a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    BookingLessonActivity.this.finish();
                }
            }

            View$OnClickListenerC0228a(final Map val$stringObjectMap) {
                this.f20035a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                Http.with(((CommonAdapter) a.this).f1707a).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).V(LoginUser.getLoginUser().getUserId(), BookingLessonActivity.this.f20033n, JsonParse.getString(this.f20035a, "currId"))).setDataListener(new C0229a());
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "currName"));
            holder.N(2131232938, false);
            holder.w(2131232955, new View$OnClickListenerC0228a(stringObjectMap));
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
            BookingLessonActivity.this.startActivity(new Intent(((BaseActivity) BookingLessonActivity.this).f1656h, ChooseTimeActivity.class));
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
            BookingLessonActivity.this.f20030k = JsonParse.getList(data, "data");
            BookingLessonActivity.this.f20032m.g(BookingLessonActivity.this.f20030k);
        }
    }

    private void n0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).D1(LoginUser.getLoginUser().getUserId(), this.f20033n)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20032m.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428023;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("id")) {
            this.f20033n = getIntent().getStringExtra("id");
        }
        this.f20031l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f20031l.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, 2131427714, this.f20030k);
        this.f20032m = aVar;
        this.f20031l.setAdapter(aVar);
        n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle(getString(2131820627));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20031l = (RecyclerView) findViewById(2131232540);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
