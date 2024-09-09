package com.bxkj.student.life.mall.address;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import java.util.Map;
import q.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AddAddressActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f21627k;

    /* renamed from: l  reason: collision with root package name */
    private EditText f21628l;

    /* renamed from: m  reason: collision with root package name */
    private EditText f21629m;

    /* renamed from: n  reason: collision with root package name */
    private EditText f21630n;

    /* renamed from: o  reason: collision with root package name */
    private Button f21631o;

    /* renamed from: p  reason: collision with root package name */
    private String f21632p;

    /* renamed from: q  reason: collision with root package name */
    private String f21633q;

    /* renamed from: r  reason: collision with root package name */
    private String f21634r;

    /* renamed from: s  reason: collision with root package name */
    private String f21635s;

    /* renamed from: t  reason: collision with root package name */
    private String f21636t;

    /* renamed from: u  reason: collision with root package name */
    private String f21637u;

    /* renamed from: v  reason: collision with root package name */
    private String f21638v;

    /* renamed from: w  reason: collision with root package name */
    private final int f21639w = 170;

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
            MyAddressListActivity myAddressListActivity = (MyAddressListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(MyAddressListActivity.class);
            if (myAddressListActivity != null) {
                myAddressListActivity.w0();
            }
            if (TextUtils.isEmpty(AddAddressActivity.this.f21632p)) {
                AddAddressActivity.this.h0("\u6dfb\u52a0\u6210\u529f");
            } else {
                AddAddressActivity.this.h0("\u4fee\u6539\u6210\u529f");
            }
            AddAddressActivity.this.finish();
        }
    }

    private void j0() {
        String trim = this.f21627k.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            h0(this.f21627k.getHint());
            return;
        }
        String trim2 = this.f21628l.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            h0(this.f21628l.getHint());
        } else if (trim2.length() < 11) {
            h0("\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u624b\u673a\u53f7\u7801");
        } else if (TextUtils.isEmpty(this.f21629m.getText().toString().trim())) {
            h0(this.f21629m.getHint());
        } else {
            String trim3 = this.f21630n.getText().toString().trim();
            if (TextUtils.isEmpty(trim3)) {
                h0(this.f21630n.getHint());
            } else {
                Http.with(this.f1656h).setObservable(((g) Http.getApiService(g.class)).o(this.f21632p, LoginUser.getLoginUser().getOpenId(), this.f21637u, trim3, trim, trim2)).setDataListener(new a());
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21629m.setOnClickListener(this);
        this.f21631o.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427357;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("addressId")) {
            this.f21632p = getIntent().getStringExtra("addressId");
            setTitle("\u7f16\u8f91\u6536\u8d27\u5730\u5740");
        } else {
            setTitle("\u6dfb\u52a0\u6536\u8d27\u5730\u5740");
        }
        if (getIntent().hasExtra("name")) {
            this.f21627k.setText(getIntent().getStringExtra("name"));
        }
        if (getIntent().hasExtra("phone")) {
            this.f21628l.setText(getIntent().getStringExtra("phone"));
        }
        if (getIntent().hasExtra("city")) {
            this.f21629m.setText(getIntent().getStringExtra("city"));
        }
        if (getIntent().hasExtra("areaId")) {
            this.f21637u = getIntent().getStringExtra("areaId");
        }
        if (getIntent().hasExtra("address")) {
            this.f21630n.setText(getIntent().getStringExtra("address"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6dfb\u52a0\u6536\u8d27\u5730\u5740");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21629m = (EditText) findViewById(2131231253);
        this.f21627k = (EditText) findViewById(2131231260);
        this.f21628l = (EditText) findViewById(2131231266);
        this.f21629m = (EditText) findViewById(2131231253);
        this.f21630n = (EditText) findViewById(2131231251);
        this.f21631o = (Button) findViewById(2131230950);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && data != null && requestCode == 170) {
            this.f21633q = data.getStringExtra("provinceId");
            this.f21634r = data.getStringExtra("provinceName");
            this.f21635s = data.getStringExtra("cityId");
            this.f21636t = data.getStringExtra("cityName");
            this.f21637u = data.getStringExtra("areaId");
            this.f21638v = data.getStringExtra("areaName");
            EditText editText = this.f21629m;
            editText.setText(this.f21634r + this.f21636t + this.f21638v);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        int id = v3.getId();
        if (id == 2131230950) {
            j0();
        } else if (id != 2131231253) {
        } else {
            startActivityForResult(new Intent(this.f1656h, ChooseCityActivity.class), 170);
        }
    }
}
