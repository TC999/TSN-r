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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ChooseLessonActivity extends BaseActivity {

    /* renamed from: k */
    private List<Map<String, Object>> f17782k = new ArrayList();

    /* renamed from: l */
    private RecyclerView f17783l;

    /* renamed from: m */
    private CommonAdapter<Map<String, Object>> f17784m;

    /* renamed from: n */
    private String f17785n;

    /* renamed from: com.bxkj.student.home.teaching.lesson.ChooseLessonActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4784a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.teaching.lesson.ChooseLessonActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4785a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f17787a;

            View$OnClickListenerC4785a(final Map val$stringObjectMap) {
                this.f17787a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((CommonAdapter) C4784a.this).f1721a);
                iOSOneButtonDialog oneButtonText = iosonebuttondialog.setTitle(LoginUser.getLoginUser().getXuanZeAfterLabelName() + "介绍").setOneButtonText("知道了");
                TextView textView = (TextView) oneButtonText.findViewById(2131232751);
                textView.setVisibility(0);
                textView.setText(Html.fromHtml(JsonParse.getString(this.f17787a, "introduce")));
                oneButtonText.show();
                oneButtonText.setMessageGrivity(3);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.teaching.lesson.ChooseLessonActivity$a$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4786b implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f17789a;

            View$OnClickListenerC4786b(final Map val$stringObjectMap) {
                this.f17789a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ChooseLessonActivity.this.m41340o0(this.f17789a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.teaching.lesson.ChooseLessonActivity$a$c */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4787c implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f17791a;

            View$OnClickListenerC4787c(final Map val$stringObjectMap) {
                this.f17791a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ChooseLessonActivity.this.m41340o0(this.f17791a);
            }
        }

        C4784a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.m57847w(2131232938, new View$OnClickListenerC4785a(stringObjectMap));
            holder.m57847w(C4215R.C4219id.tv_enter, new View$OnClickListenerC4786b(stringObjectMap));
            holder.m57847w(2131233040, new View$OnClickListenerC4787c(stringObjectMap));
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.lesson.ChooseLessonActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4788b implements OnItemClickListener {
        C4788b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            ChooseLessonActivity.this.startActivity(new Intent(((BaseActivity) ChooseLessonActivity.this).f1669h, ChooseTimeActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.lesson.ChooseLessonActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4789c extends HttpCallBack {
        C4789c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ChooseLessonActivity.this.f17782k = JsonParse.getList(data, "data");
            ChooseLessonActivity.this.f17784m.m57836g(ChooseLessonActivity.this.f17782k);
        }
    }

    /* renamed from: n0 */
    private void m41341n0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m66v(LoginUser.getLoginUser().getUserId(), this.f17785n)).setDataListener(new C4789c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public void m41340o0(Map<String, Object> stringObjectMap) {
        if (TextUtils.isEmpty(this.f17785n)) {
            startActivity(new Intent(this.f1669h, ChooseTimeActivity.class).putExtra("teachingId", JsonParse.getString(stringObjectMap, "id")));
        } else {
            startActivity(new Intent(this.f1669h, OnLineLessonActivity.class).putExtra("teachingId", JsonParse.getString(stringObjectMap, "id")).putExtra("timeId", this.f17785n));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17784m.m57834k(new C4788b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.pub_recycelrview_no_refresh;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("timeId")) {
            this.f17785n = getIntent().getStringExtra("timeId");
        }
        this.f17783l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f17783l.setLayoutAnimation(layoutAnimationController);
        C4784a c4784a = new C4784a(this.f1669h, C4215R.C4221layout.item_for_lesson2_list, this.f17782k);
        this.f17784m = c4784a;
        this.f17783l.setAdapter(c4784a);
        m41341n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("选择" + LoginUser.getLoginUser().getXuanZeAfterLabelName());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17783l = (RecyclerView) findViewById(2131232540);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
