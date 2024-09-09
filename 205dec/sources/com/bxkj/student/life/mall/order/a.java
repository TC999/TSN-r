package com.bxkj.student.life.mall.order;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import java.util.Map;
import q.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: OrderButtonOnClick.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f21797a;

    /* renamed from: b  reason: collision with root package name */
    private String f21798b;

    /* renamed from: c  reason: collision with root package name */
    private String f21799c;

    /* renamed from: d  reason: collision with root package name */
    private String f21800d;

    /* renamed from: e  reason: collision with root package name */
    private String f21801e;

    /* renamed from: f  reason: collision with root package name */
    private String f21802f;

    /* renamed from: g  reason: collision with root package name */
    private String f21803g;

    /* renamed from: h  reason: collision with root package name */
    private e f21804h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: OrderButtonOnClick.java */
    /* renamed from: com.bxkj.student.life.mall.order.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class C0268a implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f21805a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: OrderButtonOnClick.java */
        /* renamed from: com.bxkj.student.life.mall.order.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class C0269a extends HttpCallBack {
            C0269a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                Toast.makeText(a.this.f21797a, "\u8ba2\u5355\u53d6\u6d88\u6210\u529f", 0).show();
                if (a.this.f21804h != null) {
                    a.this.f21804h.a();
                }
            }
        }

        C0268a(final String val$orderId) {
            this.f21805a = val$orderId;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(a.this.f21797a).setObservable(((g) Http.getApiService(g.class)).m(this.f21805a)).setDataListener(new C0269a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: OrderButtonOnClick.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f21808a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: OrderButtonOnClick.java */
        /* renamed from: com.bxkj.student.life.mall.order.a$b$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class C0270a extends HttpCallBack {
            C0270a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                Toast.makeText(a.this.f21797a, "\u8ba2\u5355\u5220\u9664\u6210\u529f", 0).show();
                if (a.this.f21804h != null) {
                    a.this.f21804h.a();
                }
            }
        }

        b(final String val$orderId) {
            this.f21808a = val$orderId;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(a.this.f21797a).setObservable(((g) Http.getApiService(g.class)).l(this.f21808a)).setDataListener(new C0270a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: OrderButtonOnClick.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f21811a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: OrderButtonOnClick.java */
        /* renamed from: com.bxkj.student.life.mall.order.a$c$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class C0271a extends HttpCallBack {
            C0271a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                Toast.makeText(a.this.f21797a, "\u8ba2\u5355\u5ba1\u6838\u4e2d", 0).show();
                if (a.this.f21804h != null) {
                    a.this.f21804h.a();
                }
            }
        }

        c(final String val$orderId) {
            this.f21811a = val$orderId;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(a.this.f21797a).setObservable(((g) Http.getApiService(g.class)).q(this.f21811a)).setDataListener(new C0271a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: OrderButtonOnClick.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f21814a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: OrderButtonOnClick.java */
        /* renamed from: com.bxkj.student.life.mall.order.a$d$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class C0272a extends HttpCallBack {
            C0272a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                Toast.makeText(a.this.f21797a, "\u786e\u8ba4\u6536\u8d27\u6210\u529f", 0).show();
                if (a.this.f21804h != null) {
                    a.this.f21804h.a();
                }
            }
        }

        d(final String val$orderId) {
            this.f21814a = val$orderId;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(a.this.f21797a).setObservable(((g) Http.getApiService(g.class)).b(this.f21814a)).setDataListener(new C0272a());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: OrderButtonOnClick.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface e {
        void a();
    }

    public a(Context mContext) {
        this.f21797a = mContext;
    }

    private void c(final String orderId) {
        new iOSTwoButtonDialog(this.f21797a).setMessage("\u786e\u5b9a\u8981\u7533\u8bf7\u9000\u6b3e\u5417\uff1f").setRightButtonOnClickListener(new c(orderId)).show();
    }

    private void e(final String orderId) {
        new iOSTwoButtonDialog(this.f21797a).setMessage("\u786e\u5b9a\u8981\u53d6\u6d88\u8ba2\u5355\u5417\uff1f").setRightButtonOnClickListener(new C0268a(orderId)).show();
    }

    private void f(final String orderId) {
        new iOSTwoButtonDialog(this.f21797a).setMessage("\u786e\u5b9a\u5df2\u6536\u5230\u8d27\u7269\u5417\uff1f").setRightButtonOnClickListener(new d(orderId)).show();
    }

    private void g(final String orderId) {
        new iOSTwoButtonDialog(this.f21797a).setMessage("\u786e\u5b9a\u8981\u5220\u9664\u8ba2\u5355\u5417\uff1f").setRightButtonOnClickListener(new b(orderId)).show();
    }

    public void d(String text, String orderId, String order_sn, double pay_amount) {
        if (text.equals("\u7acb\u5373\u4ed8\u6b3e")) {
            this.f21797a.startActivity(new Intent(this.f21797a, OrderPayActivity.class).putExtra("orderId", orderId).putExtra("orderNo", order_sn).putExtra("payPrice", pay_amount));
        } else if (text.equals("\u53d6\u6d88\u8ba2\u5355")) {
            e(orderId);
        } else if (text.equals("\u5220\u9664\u8ba2\u5355")) {
            g(orderId);
        } else if (text.equals("\u7533\u8bf7\u9000\u6b3e")) {
            c(orderId);
        } else if (text.equals("\u786e\u8ba4\u6536\u8d27")) {
            f(orderId);
        } else if (text.equals("\u67e5\u770b\u7269\u6d41")) {
            this.f21797a.startActivity(new Intent(this.f21797a, ViewLogisticsActivity.class).putExtra("orderId", orderId).putExtra("shipping_id", this.f21802f).putExtra("invoice_no", this.f21803g));
        } else {
            text.equals("\u7acb\u5373\u8bc4\u4ef7");
        }
    }

    public String h() {
        return this.f21798b;
    }

    public String i() {
        return this.f21801e;
    }

    public String j() {
        return this.f21799c;
    }

    public String k() {
        return this.f21800d;
    }

    public String l() {
        return this.f21803g;
    }

    public String m() {
        return this.f21802f;
    }

    public a n(String goodsId) {
        this.f21798b = goodsId;
        return this;
    }

    public a o(String goodsImage) {
        this.f21801e = goodsImage;
        return this;
    }

    public a p(String goodsName) {
        this.f21799c = goodsName;
        return this;
    }

    public a q(String goodsPrice) {
        this.f21800d = goodsPrice;
        return this;
    }

    public a r(String invoice_no) {
        this.f21803g = invoice_no;
        return this;
    }

    public void s(e refreshOrderListener) {
        this.f21804h = refreshOrderListener;
    }

    public a t(String shipping_id) {
        this.f21802f = shipping_id;
        return this;
    }
}
