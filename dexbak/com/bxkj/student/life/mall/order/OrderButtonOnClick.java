package com.bxkj.student.life.mall.order;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import java.util.Map;
import p635q.MallApiService;

/* renamed from: com.bxkj.student.life.mall.order.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class OrderButtonOnClick {

    /* renamed from: a */
    private Context f18488a;

    /* renamed from: b */
    private String f18489b;

    /* renamed from: c */
    private String f18490c;

    /* renamed from: d */
    private String f18491d;

    /* renamed from: e */
    private String f18492e;

    /* renamed from: f */
    private String f18493f;

    /* renamed from: g */
    private String f18494g;

    /* renamed from: h */
    private InterfaceC5041e f18495h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OrderButtonOnClick.java */
    /* renamed from: com.bxkj.student.life.mall.order.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5033a implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ String f18496a;

        /* compiled from: OrderButtonOnClick.java */
        /* renamed from: com.bxkj.student.life.mall.order.a$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5034a extends HttpCallBack {
            C5034a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                Toast.makeText(OrderButtonOnClick.this.f18488a, "订单取消成功", 0).show();
                if (OrderButtonOnClick.this.f18495h != null) {
                    OrderButtonOnClick.this.f18495h.mo40763a();
                }
            }
        }

        C5033a(final String val$orderId) {
            this.f18496a = val$orderId;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(OrderButtonOnClick.this.f18488a).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2235m(this.f18496a)).setDataListener(new C5034a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OrderButtonOnClick.java */
    /* renamed from: com.bxkj.student.life.mall.order.a$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5035b implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ String f18499a;

        /* compiled from: OrderButtonOnClick.java */
        /* renamed from: com.bxkj.student.life.mall.order.a$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5036a extends HttpCallBack {
            C5036a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                Toast.makeText(OrderButtonOnClick.this.f18488a, "订单删除成功", 0).show();
                if (OrderButtonOnClick.this.f18495h != null) {
                    OrderButtonOnClick.this.f18495h.mo40763a();
                }
            }
        }

        C5035b(final String val$orderId) {
            this.f18499a = val$orderId;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(OrderButtonOnClick.this.f18488a).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2236l(this.f18499a)).setDataListener(new C5036a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OrderButtonOnClick.java */
    /* renamed from: com.bxkj.student.life.mall.order.a$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5037c implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ String f18502a;

        /* compiled from: OrderButtonOnClick.java */
        /* renamed from: com.bxkj.student.life.mall.order.a$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5038a extends HttpCallBack {
            C5038a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                Toast.makeText(OrderButtonOnClick.this.f18488a, "订单审核中", 0).show();
                if (OrderButtonOnClick.this.f18495h != null) {
                    OrderButtonOnClick.this.f18495h.mo40763a();
                }
            }
        }

        C5037c(final String val$orderId) {
            this.f18502a = val$orderId;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(OrderButtonOnClick.this.f18488a).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2231q(this.f18502a)).setDataListener(new C5038a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OrderButtonOnClick.java */
    /* renamed from: com.bxkj.student.life.mall.order.a$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5039d implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ String f18505a;

        /* compiled from: OrderButtonOnClick.java */
        /* renamed from: com.bxkj.student.life.mall.order.a$d$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5040a extends HttpCallBack {
            C5040a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                Toast.makeText(OrderButtonOnClick.this.f18488a, "确认收货成功", 0).show();
                if (OrderButtonOnClick.this.f18495h != null) {
                    OrderButtonOnClick.this.f18495h.mo40763a();
                }
            }
        }

        C5039d(final String val$orderId) {
            this.f18505a = val$orderId;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(OrderButtonOnClick.this.f18488a).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2246b(this.f18505a)).setDataListener(new C5040a());
        }
    }

    /* compiled from: OrderButtonOnClick.java */
    /* renamed from: com.bxkj.student.life.mall.order.a$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC5041e {
        /* renamed from: a */
        void mo40763a();
    }

    public OrderButtonOnClick(Context mContext) {
        this.f18488a = mContext;
    }

    /* renamed from: c */
    private void m40781c(final String orderId) {
        new iOSTwoButtonDialog(this.f18488a).setMessage("确定要申请退款吗？").setRightButtonOnClickListener(new C5037c(orderId)).show();
    }

    /* renamed from: e */
    private void m40779e(final String orderId) {
        new iOSTwoButtonDialog(this.f18488a).setMessage("确定要取消订单吗？").setRightButtonOnClickListener(new C5033a(orderId)).show();
    }

    /* renamed from: f */
    private void m40778f(final String orderId) {
        new iOSTwoButtonDialog(this.f18488a).setMessage("确定已收到货物吗？").setRightButtonOnClickListener(new C5039d(orderId)).show();
    }

    /* renamed from: g */
    private void m40777g(final String orderId) {
        new iOSTwoButtonDialog(this.f18488a).setMessage("确定要删除订单吗？").setRightButtonOnClickListener(new C5035b(orderId)).show();
    }

    /* renamed from: d */
    public void m40780d(String text, String orderId, String order_sn, double pay_amount) {
        if (text.equals("立即付款")) {
            this.f18488a.startActivity(new Intent(this.f18488a, OrderPayActivity.class).putExtra("orderId", orderId).putExtra("orderNo", order_sn).putExtra("payPrice", pay_amount));
        } else if (text.equals("取消订单")) {
            m40779e(orderId);
        } else if (text.equals("删除订单")) {
            m40777g(orderId);
        } else if (text.equals("申请退款")) {
            m40781c(orderId);
        } else if (text.equals("确认收货")) {
            m40778f(orderId);
        } else if (text.equals("查看物流")) {
            this.f18488a.startActivity(new Intent(this.f18488a, ViewLogisticsActivity.class).putExtra("orderId", orderId).putExtra("shipping_id", this.f18493f).putExtra("invoice_no", this.f18494g));
        } else {
            text.equals("立即评价");
        }
    }

    /* renamed from: h */
    public String m40776h() {
        return this.f18489b;
    }

    /* renamed from: i */
    public String m40775i() {
        return this.f18492e;
    }

    /* renamed from: j */
    public String m40774j() {
        return this.f18490c;
    }

    /* renamed from: k */
    public String m40773k() {
        return this.f18491d;
    }

    /* renamed from: l */
    public String m40772l() {
        return this.f18494g;
    }

    /* renamed from: m */
    public String m40771m() {
        return this.f18493f;
    }

    /* renamed from: n */
    public OrderButtonOnClick m40770n(String goodsId) {
        this.f18489b = goodsId;
        return this;
    }

    /* renamed from: o */
    public OrderButtonOnClick m40769o(String goodsImage) {
        this.f18492e = goodsImage;
        return this;
    }

    /* renamed from: p */
    public OrderButtonOnClick m40768p(String goodsName) {
        this.f18490c = goodsName;
        return this;
    }

    /* renamed from: q */
    public OrderButtonOnClick m40767q(String goodsPrice) {
        this.f18491d = goodsPrice;
        return this;
    }

    /* renamed from: r */
    public OrderButtonOnClick m40766r(String invoice_no) {
        this.f18494g = invoice_no;
        return this;
    }

    /* renamed from: s */
    public void m40765s(InterfaceC5041e refreshOrderListener) {
        this.f18495h = refreshOrderListener;
    }

    /* renamed from: t */
    public OrderButtonOnClick m40764t(String shipping_id) {
        this.f18493f = shipping_id;
        return this;
    }
}
