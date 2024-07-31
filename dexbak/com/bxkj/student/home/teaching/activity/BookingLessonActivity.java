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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.lesson.ChooseTimeActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BookingLessonActivity extends BaseActivity {

    /* renamed from: k */
    private List<Map<String, Object>> f16640k = new ArrayList();

    /* renamed from: l */
    private RecyclerView f16641l;

    /* renamed from: m */
    private CommonAdapter<Map<String, Object>> f16642m;

    /* renamed from: n */
    private String f16643n;

    /* renamed from: com.bxkj.student.home.teaching.activity.BookingLessonActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4408a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.teaching.activity.BookingLessonActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4409a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f16645a;

            /* renamed from: com.bxkj.student.home.teaching.activity.BookingLessonActivity$a$a$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            class C4410a extends HttpCallBack {
                C4410a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    BookingLessonActivity.this.finish();
                }
            }

            View$OnClickListenerC4409a(final Map val$stringObjectMap) {
                this.f16645a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Http.with(((CommonAdapter) C4408a.this).f1721a).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m139V(LoginUser.getLoginUser().getUserId(), BookingLessonActivity.this.f16643n, JsonParse.getString(this.f16645a, "currId"))).setDataListener(new C4410a());
            }
        }

        C4408a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "currName"));
            holder.m57870N(2131232938, false);
            holder.m57847w(C4215R.C4219id.tv_enter, new View$OnClickListenerC4409a(stringObjectMap));
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.activity.BookingLessonActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4411b implements OnItemClickListener {
        C4411b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            BookingLessonActivity.this.startActivity(new Intent(((BaseActivity) BookingLessonActivity.this).f1669h, ChooseTimeActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.activity.BookingLessonActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4412c extends HttpCallBack {
        C4412c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BookingLessonActivity.this.f16640k = JsonParse.getList(data, "data");
            BookingLessonActivity.this.f16642m.m57836g(BookingLessonActivity.this.f16640k);
        }
    }

    /* renamed from: n0 */
    private void m42428n0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m178D1(LoginUser.getLoginUser().getUserId(), this.f16643n)).setDataListener(new C4412c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16642m.m57834k(new C4411b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.pub_recycelrview_no_refresh;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("id")) {
            this.f16643n = getIntent().getStringExtra("id");
        }
        this.f16641l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f16641l.setLayoutAnimation(layoutAnimationController);
        C4408a c4408a = new C4408a(this.f1669h, C4215R.C4221layout.item_for_lesson2_list, this.f16640k);
        this.f16642m = c4408a;
        this.f16641l.setAdapter(c4408a);
        m42428n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle(getString(C4215R.C4224string.bind_lesson));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16641l = (RecyclerView) findViewById(2131232540);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
