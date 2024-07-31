package com.bxkj.student.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.MainActivity;
import com.bxkj.student.p094v2.retrofit.RetrofitClient;
import com.orhanobut.logger.C11792j;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import p635q.MainApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SelectSchoolActivity extends BaseActivity {

    /* renamed from: k */
    private List<Map<String, Object>> f19827k;

    /* renamed from: l */
    private RecyclerView f19828l;

    /* renamed from: m */
    private CommonAdapter<Map<String, Object>> f19829m;

    /* renamed from: n */
    private List<Map<String, Object>> f19830n;

    /* renamed from: o */
    private RecyclerView f19831o;

    /* renamed from: p */
    private CommonAdapter<Map<String, Object>> f19832p;

    /* renamed from: q */
    private TextView f19833q;

    /* renamed from: r */
    private iOSTwoButtonDialog f19834r;

    /* renamed from: s */
    private int f19835s = 0;

    /* renamed from: com.bxkj.student.splash.SelectSchoolActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5448a extends CommonAdapter<Map<String, Object>> {
        C5448a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "province_name"));
            holder.m57853q(C4215R.C4219id.f15999iv, holder.m57864f() == SelectSchoolActivity.this.f19835s ? SelectSchoolActivity.this.getResources().getDrawable(2131166073) : null);
        }
    }

    /* renamed from: com.bxkj.student.splash.SelectSchoolActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5449b extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.splash.SelectSchoolActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC5450a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ ViewHolder f19838a;

            /* renamed from: com.bxkj.student.splash.SelectSchoolActivity$b$a$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            class C5451a implements iOSTwoButtonDialog.RightButtonOnClick {
                C5451a() {
                }

                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public void buttonRightOnClick() {
                    try {
                        LoginUser.getLoginUser().setSchoolName(JsonParse.getString((Map) SelectSchoolActivity.this.f19832p.getItem(View$OnClickListenerC5450a.this.f19838a.m57864f()), "school_name"));
                        LoginUser.getLoginUser().setServerUrl(JsonParse.getString((Map) SelectSchoolActivity.this.f19832p.getItem(View$OnClickListenerC5450a.this.f19838a.m57864f()), "school_url"));
                        LoginUser.getLoginUser().setSchoolId(JsonParse.getString((Map) SelectSchoolActivity.this.f19832p.getItem(View$OnClickListenerC5450a.this.f19838a.m57864f()), "school_id"));
                        LoginUser.getLoginUser().setIsOpenEncry(JsonParse.getString((Map) SelectSchoolActivity.this.f19832p.getItem(View$OnClickListenerC5450a.this.f19838a.m57864f()), "isOpenEncry"));
                        LoginUser.getLoginUser().setSysType(JsonParse.getInt((Map) SelectSchoolActivity.this.f19832p.getItem(View$OnClickListenerC5450a.this.f19838a.m57864f()), "sysType"));
                        LoginUser.getLoginUser().setIsOpenKeep(JsonParse.getInt((Map) SelectSchoolActivity.this.f19832p.getItem(View$OnClickListenerC5450a.this.f19838a.m57864f()), "isOpenKeep"));
                        LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
                        LoggedInUser m43634a = c3984b.m43634a();
                        JsonGet jsonGet = JsonGet.f15134a;
                        m43634a.m43669V(jsonGet.m43760t((Map) SelectSchoolActivity.this.f19832p.getItem(View$OnClickListenerC5450a.this.f19838a.m57864f()), "school_name"));
                        c3984b.m43634a().m43670U(jsonGet.m43760t((Map) SelectSchoolActivity.this.f19832p.getItem(View$OnClickListenerC5450a.this.f19838a.m57864f()), "schoolCode"));
                        c3984b.m43634a().m43674Q(jsonGet.m43769k((Map) SelectSchoolActivity.this.f19832p.getItem(View$OnClickListenerC5450a.this.f19838a.m57864f()), "isOpenLive"));
                        c3984b.m43634a().m43673R(jsonGet.m43768l((Map) SelectSchoolActivity.this.f19832p.getItem(View$OnClickListenerC5450a.this.f19838a.m57864f()), "isOpenSQZS", 1));
                        String m43759u = jsonGet.m43759u((Map) SelectSchoolActivity.this.f19832p.getItem(View$OnClickListenerC5450a.this.f19838a.m57864f()), "lan_url", "http://a.sxstczx.com/");
                        if (LoginUser.getLoginUser().getSysType() == 2) {
                            c3984b.m43634a().m43668W(m43759u);
                            RetrofitClient.f20337a.m38889a();
                            c3984b.m43634a().m43682I(jsonGet.m43760t((Map) SelectSchoolActivity.this.f19832p.getItem(View$OnClickListenerC5450a.this.f19838a.m57864f()), "school_url"));
                        } else {
                            Http.changeBaseUrl(LoginUser.getLoginUser().getServerUrl());
                            LoginUser.getLoginUser().setAppId(JsonParse.getString((Map) SelectSchoolActivity.this.f19832p.getItem(View$OnClickListenerC5450a.this.f19838a.m57864f()), "openId"));
                        }
                        ((CommonAdapter) C5449b.this).f1721a.startActivity(new Intent(((CommonAdapter) C5449b.this).f1721a, SplashActivity.class));
                        new HashSet().add(LoginUser.getLoginUser().getSchoolName());
                        SelectSchoolActivity.this.finish();
                    } catch (Exception e) {
                        C11792j.m20470c(e.getMessage());
                    }
                }
            }

            View$OnClickListenerC5450a(final ViewHolder val$holder) {
                this.f19838a = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                iOSTwoButtonDialog title = new iOSTwoButtonDialog(((CommonAdapter) C5449b.this).f1721a).setTitle("提示");
                title.setMessage("确定您要选择" + JsonParse.getString((Map) SelectSchoolActivity.this.f19832p.getItem(this.f19838a.m57864f()), "school_name") + "吗?").setRightButtonOnClickListener(new C5451a()).show();
            }
        }

        C5449b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: p */
        public void mo39408c(final ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "school_name"));
            holder.m57847w(2131233040, new View$OnClickListenerC5450a(holder));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.splash.SelectSchoolActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5452c extends HttpCallBack {
        C5452c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectSchoolActivity.this.f19827k = (List) data.get("data");
            SelectSchoolActivity.this.f19829m.m57836g(SelectSchoolActivity.this.f19827k);
            SelectSchoolActivity.this.m39410v0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.splash.SelectSchoolActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5453d extends HttpCallBack {
        C5453d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectSchoolActivity.this.f19830n = (List) data.get("data");
            SelectSchoolActivity.this.f19832p.m57836g(SelectSchoolActivity.this.f19830n);
        }
    }

    /* renamed from: com.bxkj.student.splash.SelectSchoolActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5454e implements OnItemClickListener {
        C5454e() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            SelectSchoolActivity.this.f19835s = position;
            SelectSchoolActivity.this.f19829m.notifyDataSetChanged();
            SelectSchoolActivity.this.m39410v0();
        }
    }

    /* renamed from: com.bxkj.student.splash.SelectSchoolActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnClickListenerC5455f implements View.OnClickListener {
        View$OnClickListenerC5455f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            LoginUser.getLoginUser().setSchoolName(SelectSchoolActivity.this.getString(2131820604));
            LoginUser.getLoginUser().setServerUrl("https://m.boxkj.com/");
            LoginUser.getLoginUser().setSchoolId("-1");
            Http.changeBaseUrl(LoginUser.getLoginUser().getServerUrl());
            ((BaseActivity) SelectSchoolActivity.this).f1669h.startActivity(new Intent(((BaseActivity) SelectSchoolActivity.this).f1669h, MainActivity.class));
            new HashSet().add(LoginUser.getLoginUser().getSchoolName());
            SelectSchoolActivity.this.finish();
        }
    }

    /* renamed from: t0 */
    private void m39412t0() {
        this.f19831o = (RecyclerView) findViewById(2131232540);
        this.f19828l = (RecyclerView) findViewById(2131232548);
        this.f19833q = (TextView) findViewById(C4215R.C4219id.tv_other);
    }

    /* renamed from: u0 */
    private void m39411u0() {
        Http.with(this.f1669h).setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2264m()).setDataListener(new C5452c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public void m39410v0() {
        Http.with(this.f1669h).setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2253x(JsonParse.getString(this.f19829m.getItem(this.f19835s), "province_id"))).setDataListener(new C5453d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f19829m.m57834k(new C5454e());
        this.f19833q.setOnClickListener(new View$OnClickListenerC5455f());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_school_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f19828l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f19828l.setLayoutAnimation(layoutAnimationController);
        this.f19828l.addItemDecoration(new DividerItemDecoration(this.f1669h, 1));
        C5448a c5448a = new C5448a(this.f1669h, C4215R.C4221layout.item_for_province_list, this.f19827k);
        this.f19829m = c5448a;
        this.f19828l.setAdapter(c5448a);
        this.f19831o.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController2 = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController2.setOrder(0);
        this.f19831o.setLayoutAnimation(layoutAnimationController2);
        C5449b c5449b = new C5449b(this.f1669h, C4215R.C4221layout.item_for_school_list, this.f19830n);
        this.f19832p = c5449b;
        this.f19831o.setAdapter(c5449b);
        m39411u0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        m57926a0(getIntent().hasExtra("isShowBack"));
        setTitle("选择学校");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        m39412t0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        iOSTwoButtonDialog iostwobuttondialog = this.f19834r;
        if (iostwobuttondialog != null && iostwobuttondialog.isShowing()) {
            this.f19834r.dismiss();
        }
        super.onDestroy();
    }
}
