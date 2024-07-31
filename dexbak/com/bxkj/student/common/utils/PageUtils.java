package com.bxkj.student.common.utils;

import android.content.Context;
import android.widget.Toast;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import p638r0.RefreshLayout;
import p640rx.Observable;
import p642s0.OnRefreshLoadmoreListener;
import retrofit2.Response;

/* renamed from: com.bxkj.student.common.utils.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PageUtils {

    /* renamed from: a */
    private CommonAdapter<Map<String, Object>> f16226a;

    /* renamed from: b */
    private Context f16227b;

    /* renamed from: c */
    private SmartRefreshLayout f16228c;

    /* renamed from: d */
    private Observable<Response<ResponseBody>> f16229d;

    /* renamed from: e */
    protected int f16230e = 10;

    /* renamed from: f */
    protected int f16231f = 1;

    /* renamed from: g */
    protected int f16232g = 1;

    /* compiled from: PageUtils.java */
    /* renamed from: com.bxkj.student.common.utils.h$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4250a implements OnRefreshLoadmoreListener {

        /* renamed from: a */
        final /* synthetic */ SmartRefreshLayout f16233a;

        C4250a(final SmartRefreshLayout val$refreshLayout) {
            this.f16233a = val$refreshLayout;
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            PageUtils pageUtils = PageUtils.this;
            pageUtils.f16231f = 1;
            pageUtils.m42829d();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            PageUtils pageUtils = PageUtils.this;
            int i = pageUtils.f16232g;
            int i2 = pageUtils.f16230e;
            int i3 = i / i2;
            int i4 = pageUtils.f16231f;
            if (i % i2 != 0) {
                i3++;
            }
            if (i4 >= i3) {
                this.f16233a.mo2041g();
                Toast.makeText(PageUtils.this.f16227b, "没有了", 0).show();
                return;
            }
            pageUtils.f16231f = i4 + 1;
            pageUtils.m42829d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PageUtils.java */
    /* renamed from: com.bxkj.student.common.utils.h$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4251b extends HttpCallBack {
        C4251b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            PageUtils.this.f16228c.mo2078B();
            PageUtils.this.f16228c.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PageUtils.this.f16232g = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            List m57837d = PageUtils.this.f16226a.m57837d();
            if (PageUtils.this.f16231f != 1) {
                m57837d.addAll(list);
                list = m57837d;
            }
            PageUtils.this.f16226a.m57836g(list);
        }
    }

    public PageUtils(Context mContext) {
        this.f16227b = mContext;
    }

    /* renamed from: d */
    public void m42829d() {
        Http.with(this.f16227b).hideLoadingDialog().setObservable(this.f16229d).setDataListener(new C4251b());
    }

    /* renamed from: e */
    public int m42828e() {
        return this.f16231f;
    }

    /* renamed from: f */
    public int m42827f() {
        return this.f16230e;
    }

    /* renamed from: g */
    public PageUtils m42826g(final SmartRefreshLayout refreshLayout) {
        this.f16228c = refreshLayout;
        refreshLayout.mo2019v(new C4250a(refreshLayout));
        return this;
    }

    /* renamed from: h */
    public PageUtils m42825h(CommonAdapter<Map<String, Object>> adapter) {
        this.f16226a = adapter;
        return this;
    }

    /* renamed from: i */
    public PageUtils m42824i(Observable<Response<ResponseBody>> observe) {
        this.f16229d = observe;
        return this;
    }
}
