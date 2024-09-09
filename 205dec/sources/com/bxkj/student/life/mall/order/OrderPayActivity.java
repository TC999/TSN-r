package com.bxkj.student.life.mall.order;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.text.DecimalFormat;
import java.util.Map;
import q.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class OrderPayActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f21773k;

    /* renamed from: l  reason: collision with root package name */
    private Button f21774l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f21775m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f21776n;

    /* renamed from: o  reason: collision with root package name */
    private CheckBox f21777o;

    /* renamed from: p  reason: collision with root package name */
    private CheckBox f21778p;

    /* renamed from: q  reason: collision with root package name */
    private String f21779q;

    /* renamed from: r  reason: collision with root package name */
    private String f21780r;

    /* renamed from: s  reason: collision with root package name */
    private double f21781s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            JsonParse.getString(data, "appid");
            JsonParse.getString(data, "partnerid");
            JsonParse.getString(data, "prepayid");
            JsonParse.getString(data, "noncestr");
            JsonParse.getString(data, "package");
            JsonParse.getString(data, CampaignEx.JSON_KEY_TIMESTAMP);
            JsonParse.getString(data, "sign");
        }
    }

    private void i0() {
        Http.with(this.f1656h).setObservable(((g) Http.getApiService(g.class)).h(this.f21779q)).setDataListener(new a());
    }

    private void j0() {
        Http.with(this.f1656h).setObservable(((g) Http.getApiService(g.class)).A(this.f21779q)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21774l.setOnClickListener(this);
        this.f21775m.setOnClickListener(this);
        this.f21776n.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427448;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("orderId")) {
            this.f21779q = getIntent().getStringExtra("orderId");
        }
        if (getIntent().hasExtra("orderNo")) {
            this.f21780r = getIntent().getStringExtra("orderNo");
        }
        if (getIntent().hasExtra("payPrice")) {
            this.f21781s = getIntent().getDoubleExtra("payPrice", 100.0d);
        }
        this.f21773k.setText(new DecimalFormat("\uffe50.00").format(this.f21781s));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8ba2\u5355\u652f\u4ed8");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21774l = (Button) findViewById(2131230992);
        this.f21773k = (TextView) findViewById(2131233035);
        this.f21775m = (LinearLayout) findViewById(2131232507);
        this.f21776n = (LinearLayout) findViewById(2131232533);
        this.f21777o = (CheckBox) findViewById(2131231081);
        this.f21778p = (CheckBox) findViewById(2131231088);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        int id = v3.getId();
        if (id == 2131230992) {
            if (this.f21777o.isChecked()) {
                i0();
            } else if (this.f21778p.isChecked()) {
                j0();
            }
        } else if (id == 2131232507) {
            this.f21778p.setChecked(false);
            this.f21777o.setChecked(true);
        } else if (id != 2131232533) {
        } else {
            this.f21777o.setChecked(false);
            this.f21778p.setChecked(true);
        }
    }
}
