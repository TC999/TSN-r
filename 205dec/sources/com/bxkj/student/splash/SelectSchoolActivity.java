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
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.base.v2.data.a;
import com.bxkj.student.MainActivity;
import com.orhanobut.logger.j;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SelectSchoolActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private List<Map<String, Object>> f23057k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f23058l;

    /* renamed from: m  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f23059m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f23060n;

    /* renamed from: o  reason: collision with root package name */
    private RecyclerView f23061o;

    /* renamed from: p  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f23062p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f23063q;

    /* renamed from: r  reason: collision with root package name */
    private iOSTwoButtonDialog f23064r;

    /* renamed from: s  reason: collision with root package name */
    private int f23065s = 0;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "province_name"));
            holder.q(2131231382, holder.f() == SelectSchoolActivity.this.f23065s ? SelectSchoolActivity.this.getResources().getDrawable(2131166073) : null);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ViewHolder f23068a;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* renamed from: com.bxkj.student.splash.SelectSchoolActivity$b$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            class C0286a implements iOSTwoButtonDialog.RightButtonOnClick {
                C0286a() {
                }

                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public void buttonRightOnClick() {
                    try {
                        LoginUser.getLoginUser().setSchoolName(JsonParse.getString((Map) SelectSchoolActivity.this.f23062p.getItem(a.this.f23068a.f()), "school_name"));
                        LoginUser.getLoginUser().setServerUrl(JsonParse.getString((Map) SelectSchoolActivity.this.f23062p.getItem(a.this.f23068a.f()), "school_url"));
                        LoginUser.getLoginUser().setSchoolId(JsonParse.getString((Map) SelectSchoolActivity.this.f23062p.getItem(a.this.f23068a.f()), "school_id"));
                        LoginUser.getLoginUser().setIsOpenEncry(JsonParse.getString((Map) SelectSchoolActivity.this.f23062p.getItem(a.this.f23068a.f()), "isOpenEncry"));
                        LoginUser.getLoginUser().setSysType(JsonParse.getInt((Map) SelectSchoolActivity.this.f23062p.getItem(a.this.f23068a.f()), "sysType"));
                        LoginUser.getLoginUser().setIsOpenKeep(JsonParse.getInt((Map) SelectSchoolActivity.this.f23062p.getItem(a.this.f23068a.f()), "isOpenKeep"));
                        a.b bVar = com.bxkj.base.v2.data.a.b;
                        com.bxkj.base.v2.data.a a4 = bVar.a();
                        l lVar = l.f18624a;
                        a4.V(lVar.t((Map) SelectSchoolActivity.this.f23062p.getItem(a.this.f23068a.f()), "school_name"));
                        bVar.a().U(lVar.t((Map) SelectSchoolActivity.this.f23062p.getItem(a.this.f23068a.f()), "schoolCode"));
                        bVar.a().Q(lVar.k((Map) SelectSchoolActivity.this.f23062p.getItem(a.this.f23068a.f()), "isOpenLive"));
                        bVar.a().R(lVar.l((Map) SelectSchoolActivity.this.f23062p.getItem(a.this.f23068a.f()), "isOpenSQZS", 1));
                        String u3 = lVar.u((Map) SelectSchoolActivity.this.f23062p.getItem(a.this.f23068a.f()), "lan_url", "http://a.sxstczx.com/");
                        if (LoginUser.getLoginUser().getSysType() == 2) {
                            bVar.a().W(u3);
                            com.bxkj.student.v2.retrofit.b.f23700a.a();
                            bVar.a().I(lVar.t((Map) SelectSchoolActivity.this.f23062p.getItem(a.this.f23068a.f()), "school_url"));
                        } else {
                            Http.changeBaseUrl(LoginUser.getLoginUser().getServerUrl());
                            LoginUser.getLoginUser().setAppId(JsonParse.getString((Map) SelectSchoolActivity.this.f23062p.getItem(a.this.f23068a.f()), "openId"));
                        }
                        ((CommonAdapter) b.this).f1707a.startActivity(new Intent(((CommonAdapter) b.this).f1707a, SplashActivity.class));
                        new HashSet().add(LoginUser.getLoginUser().getSchoolName());
                        SelectSchoolActivity.this.finish();
                    } catch (Exception e4) {
                        j.c(e4.getMessage());
                    }
                }
            }

            a(final ViewHolder val$holder) {
                this.f23068a = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                iOSTwoButtonDialog title = new iOSTwoButtonDialog(((CommonAdapter) b.this).f1707a).setTitle("\u63d0\u793a");
                title.setMessage("\u786e\u5b9a\u60a8\u8981\u9009\u62e9" + JsonParse.getString((Map) SelectSchoolActivity.this.f23062p.getItem(this.f23068a.f()), "school_name") + "\u5417?").setRightButtonOnClickListener(new C0286a()).show();
            }
        }

        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: p */
        public void c(final ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "school_name"));
            holder.w(2131233040, new a(holder));
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
            SelectSchoolActivity.this.f23057k = (List) data.get("data");
            SelectSchoolActivity.this.f23059m.g(SelectSchoolActivity.this.f23057k);
            SelectSchoolActivity.this.v0();
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

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectSchoolActivity.this.f23060n = (List) data.get("data");
            SelectSchoolActivity.this.f23062p.g(SelectSchoolActivity.this.f23060n);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class e implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        e() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            SelectSchoolActivity.this.f23065s = position;
            SelectSchoolActivity.this.f23059m.notifyDataSetChanged();
            SelectSchoolActivity.this.v0();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            LoginUser.getLoginUser().setSchoolName(SelectSchoolActivity.this.getString(2131820604));
            LoginUser.getLoginUser().setServerUrl("https://m.boxkj.com/");
            LoginUser.getLoginUser().setSchoolId("-1");
            Http.changeBaseUrl(LoginUser.getLoginUser().getServerUrl());
            ((BaseActivity) SelectSchoolActivity.this).f1656h.startActivity(new Intent(((BaseActivity) SelectSchoolActivity.this).f1656h, MainActivity.class));
            new HashSet().add(LoginUser.getLoginUser().getSchoolName());
            SelectSchoolActivity.this.finish();
        }
    }

    private void t0() {
        this.f23061o = (RecyclerView) findViewById(2131232540);
        this.f23058l = (RecyclerView) findViewById(2131232548);
        this.f23063q = (TextView) findViewById(2131233060);
    }

    private void u0() {
        Http.with(this.f1656h).setObservable(((q.f) Http.getApiService(q.f.class)).m()).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        Http.with(this.f1656h).setObservable(((q.f) Http.getApiService(q.f.class)).x(JsonParse.getString(this.f23059m.getItem(this.f23065s), "province_id"))).setDataListener(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f23059m.k(new e());
        this.f23063q.setOnClickListener(new f());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427484;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f23058l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f23058l.setLayoutAnimation(layoutAnimationController);
        this.f23058l.addItemDecoration(new DividerItemDecoration(this.f1656h, 1));
        a aVar = new a(this.f1656h, 2131427740, this.f23057k);
        this.f23059m = aVar;
        this.f23058l.setAdapter(aVar);
        this.f23061o.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController2 = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController2.setOrder(0);
        this.f23061o.setLayoutAnimation(layoutAnimationController2);
        b bVar = new b(this.f1656h, 2131427756, this.f23060n);
        this.f23062p = bVar;
        this.f23061o.setAdapter(bVar);
        u0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        a0(getIntent().hasExtra("isShowBack"));
        setTitle("\u9009\u62e9\u5b66\u6821");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        t0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        iOSTwoButtonDialog iostwobuttondialog = this.f23064r;
        if (iostwobuttondialog != null && iostwobuttondialog.isShowing()) {
            this.f23064r.dismiss();
        }
        super.onDestroy();
    }
}
