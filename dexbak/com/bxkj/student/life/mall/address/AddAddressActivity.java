package com.bxkj.student.life.mall.address;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import java.util.Map;
import p635q.MallApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AddAddressActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f18312k;

    /* renamed from: l */
    private EditText f18313l;

    /* renamed from: m */
    private EditText f18314m;

    /* renamed from: n */
    private EditText f18315n;

    /* renamed from: o */
    private Button f18316o;

    /* renamed from: p */
    private String f18317p;

    /* renamed from: q */
    private String f18318q;

    /* renamed from: r */
    private String f18319r;

    /* renamed from: s */
    private String f18320s;

    /* renamed from: t */
    private String f18321t;

    /* renamed from: u */
    private String f18322u;

    /* renamed from: v */
    private String f18323v;

    /* renamed from: w */
    private final int f18324w = 170;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.address.AddAddressActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4985a extends HttpCallBack {
        C4985a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyAddressListActivity myAddressListActivity = (MyAddressListActivity) AppManager.m57776n().getActivity(MyAddressListActivity.class);
            if (myAddressListActivity != null) {
                myAddressListActivity.m40855w0();
            }
            if (TextUtils.isEmpty(AddAddressActivity.this.f18317p)) {
                AddAddressActivity.this.m57919h0("添加成功");
            } else {
                AddAddressActivity.this.m57919h0("修改成功");
            }
            AddAddressActivity.this.finish();
        }
    }

    /* renamed from: j0 */
    private void m40890j0() {
        String trim = this.f18312k.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            m57919h0(this.f18312k.getHint());
            return;
        }
        String trim2 = this.f18313l.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            m57919h0(this.f18313l.getHint());
        } else if (trim2.length() < 11) {
            m57919h0("请输入正确的手机号码");
        } else if (TextUtils.isEmpty(this.f18314m.getText().toString().trim())) {
            m57919h0(this.f18314m.getHint());
        } else {
            String trim3 = this.f18315n.getText().toString().trim();
            if (TextUtils.isEmpty(trim3)) {
                m57919h0(this.f18315n.getHint());
            } else {
                Http.with(this.f1669h).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2233o(this.f18317p, LoginUser.getLoginUser().getOpenId(), this.f18322u, trim3, trim, trim2)).setDataListener(new C4985a());
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18314m.setOnClickListener(this);
        this.f18316o.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_add_address;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("addressId")) {
            this.f18317p = getIntent().getStringExtra("addressId");
            setTitle("编辑收货地址");
        } else {
            setTitle("添加收货地址");
        }
        if (getIntent().hasExtra("name")) {
            this.f18312k.setText(getIntent().getStringExtra("name"));
        }
        if (getIntent().hasExtra("phone")) {
            this.f18313l.setText(getIntent().getStringExtra("phone"));
        }
        if (getIntent().hasExtra(DistrictSearchQuery.KEYWORDS_CITY)) {
            this.f18314m.setText(getIntent().getStringExtra(DistrictSearchQuery.KEYWORDS_CITY));
        }
        if (getIntent().hasExtra("areaId")) {
            this.f18322u = getIntent().getStringExtra("areaId");
        }
        if (getIntent().hasExtra("address")) {
            this.f18315n.setText(getIntent().getStringExtra("address"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("添加收货地址");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18314m = (EditText) findViewById(C4215R.C4219id.et_city);
        this.f18312k = (EditText) findViewById(C4215R.C4219id.et_name);
        this.f18313l = (EditText) findViewById(2131231266);
        this.f18314m = (EditText) findViewById(C4215R.C4219id.et_city);
        this.f18315n = (EditText) findViewById(C4215R.C4219id.et_address);
        this.f18316o = (Button) findViewById(2131230950);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && data != null && requestCode == 170) {
            this.f18318q = data.getStringExtra("provinceId");
            this.f18319r = data.getStringExtra("provinceName");
            this.f18320s = data.getStringExtra("cityId");
            this.f18321t = data.getStringExtra("cityName");
            this.f18322u = data.getStringExtra("areaId");
            this.f18323v = data.getStringExtra("areaName");
            EditText editText = this.f18314m;
            editText.setText(this.f18319r + this.f18321t + this.f18323v);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == 2131230950) {
            m40890j0();
        } else if (id != 2131231253) {
        } else {
            startActivityForResult(new Intent(this.f1669h, ChooseCityActivity.class), 170);
        }
    }
}
