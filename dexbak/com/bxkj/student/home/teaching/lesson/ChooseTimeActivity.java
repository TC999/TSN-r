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
import com.bxkj.student.C4215R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ChooseTimeActivity extends BaseActivity {

    /* renamed from: k */
    private List<Map<String, Object>> f17795k = new ArrayList();

    /* renamed from: l */
    private RecyclerView f17796l;

    /* renamed from: m */
    private CommonAdapter<Map<String, Object>> f17797m;

    /* renamed from: n */
    private String f17798n;

    /* renamed from: com.bxkj.student.home.teaching.lesson.ChooseTimeActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4790a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.teaching.lesson.ChooseTimeActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4791a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f17800a;

            View$OnClickListenerC4791a(final Map val$stringObjectMap) {
                this.f17800a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TextUtils.isEmpty(ChooseTimeActivity.this.f17798n)) {
                    ChooseTimeActivity.this.startActivity(new Intent(((CommonAdapter) C4790a.this).f1721a, ChooseLessonActivity.class).putExtra("timeId", JsonParse.getString(this.f17800a, "id")));
                } else {
                    ChooseTimeActivity.this.startActivity(new Intent(((CommonAdapter) C4790a.this).f1721a, OnLineLessonActivity.class).putExtra("timeId", JsonParse.getString(this.f17800a, "id")).putExtra("teachingId", ChooseTimeActivity.this.f17798n));
                }
            }
        }

        C4790a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.m57847w(2131233040, new View$OnClickListenerC4791a(stringObjectMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.lesson.ChooseTimeActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4792b extends HttpCallBack {
        C4792b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ChooseTimeActivity.this.f17795k = JsonParse.getList(data, "data");
            ChooseTimeActivity.this.f17797m.m57836g(ChooseTimeActivity.this.f17795k);
        }
    }

    /* renamed from: m0 */
    private void m41333m0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m92m0(LoginUser.getLoginUser().getUserId(), this.f17798n)).setDataListener(new C4792b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.pub_recycelrview_no_refresh;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("teachingId")) {
            this.f17798n = getIntent().getStringExtra("teachingId");
        }
        this.f17796l.setLayoutManager(new GridLayoutManager(this.f1669h, 3));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f17796l.setLayoutAnimation(layoutAnimationController);
        C4790a c4790a = new C4790a(this.f1669h, C4215R.C4221layout.item_for_choose_time_list, this.f17795k);
        this.f17797m = c4790a;
        this.f17796l.setAdapter(c4790a);
        m41333m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("选择上课时间");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17796l = (RecyclerView) findViewById(2131232540);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
