package com.bxkj.student.common.utils;

import android.content.Context;
import android.widget.Toast;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: PageUtils.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19628a;

    /* renamed from: b  reason: collision with root package name */
    private Context f19629b;

    /* renamed from: c  reason: collision with root package name */
    private SmartRefreshLayout f19630c;

    /* renamed from: d  reason: collision with root package name */
    private rx.e<Response<ResponseBody>> f19631d;

    /* renamed from: e  reason: collision with root package name */
    protected int f19632e = 10;

    /* renamed from: f  reason: collision with root package name */
    protected int f19633f = 1;

    /* renamed from: g  reason: collision with root package name */
    protected int f19634g = 1;

    /* compiled from: PageUtils.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements s0.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SmartRefreshLayout f19635a;

        a(final SmartRefreshLayout val$refreshLayout) {
            this.f19635a = val$refreshLayout;
        }

        @Override // s0.d
        public void q(r0.h refreshlayout) {
            h hVar = h.this;
            hVar.f19633f = 1;
            hVar.d();
        }

        @Override // s0.b
        public void s(r0.h refreshlayout) {
            h hVar = h.this;
            int i4 = hVar.f19634g;
            int i5 = hVar.f19632e;
            int i6 = i4 / i5;
            int i7 = hVar.f19633f;
            if (i4 % i5 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                this.f19635a.h();
                Toast.makeText(h.this.f19629b, "\u6ca1\u6709\u4e86", 0).show();
                return;
            }
            hVar.f19633f = i7 + 1;
            hVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PageUtils.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            h.this.f19630c.y();
            h.this.f19630c.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            h.this.f19634g = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d4 = h.this.f19628a.d();
            if (h.this.f19633f != 1) {
                d4.addAll(list);
                list = d4;
            }
            h.this.f19628a.g(list);
        }
    }

    public h(Context mContext) {
        this.f19629b = mContext;
    }

    public void d() {
        Http.with(this.f19629b).hideLoadingDialog().setObservable(this.f19631d).setDataListener(new b());
    }

    public int e() {
        return this.f19633f;
    }

    public int f() {
        return this.f19632e;
    }

    public h g(final SmartRefreshLayout refreshLayout) {
        this.f19630c = refreshLayout;
        refreshLayout.n1(new a(refreshLayout));
        return this;
    }

    public h h(CommonAdapter<Map<String, Object>> adapter) {
        this.f19628a = adapter;
        return this;
    }

    public h i(rx.e<Response<ResponseBody>> observe) {
        this.f19631d = observe;
        return this;
    }
}
