package com.bxkj.equipment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.i;
import com.bxkj.equipment.view.NumberButton;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ApplyEquipmentActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f19229k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f19230l;

    /* renamed from: m  reason: collision with root package name */
    private NumberButton f19231m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f19232n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f19233o;

    /* renamed from: p  reason: collision with root package name */
    private EditText f19234p;

    /* renamed from: q  reason: collision with root package name */
    private Button f19235q;

    /* renamed from: r  reason: collision with root package name */
    private String f19236r;

    /* renamed from: s  reason: collision with root package name */
    private String f19237s;

    /* renamed from: t  reason: collision with root package name */
    private String f19238t;

    /* renamed from: u  reason: collision with root package name */
    private int f19239u = 0;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements NumberButton.a {
        a() {
        }

        @Override // com.bxkj.equipment.view.NumberButton.a
        public void onNumberChanged(int number) {
        }

        @Override // com.bxkj.equipment.view.NumberButton.a
        public void onWarningForBuyMax(int max) {
        }

        @Override // com.bxkj.equipment.view.NumberButton.a
        public void onWarningForInventory(int inventory) {
            new iOSOneButtonDialog(((BaseActivity) ApplyEquipmentActivity.this).f1656h).setMessage("\u5e93\u5b58\u4e0d\u8db3").show();
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
            ApplyEquipmentActivity.this.finish();
            ApplyEquipmentActivity.this.h0("\u7533\u8bf7\u6210\u529f");
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
            ApplyEquipmentActivity.this.finish();
            ApplyEquipmentActivity.this.h0("\u7533\u8bf7\u6210\u529f");
        }
    }

    private void q0() {
        if (TextUtils.isEmpty(this.f19236r)) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u9009\u62e9\u6821\u533a").show();
        } else if (TextUtils.isEmpty(this.f19237s)) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u9009\u62e9\u5668\u6750").show();
        } else {
            String trim = this.f19232n.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                new iOSOneButtonDialog(this.f1656h).setMessage(this.f19232n.getHint()).show();
                return;
            }
            String trim2 = this.f19233o.getText().toString().trim();
            if (TextUtils.isEmpty(trim2)) {
                new iOSOneButtonDialog(this.f1656h).setMessage(this.f19233o.getHint()).show();
                return;
            }
            String trim3 = this.f19234p.getText().toString().trim();
            if (TextUtils.isEmpty(trim3)) {
                new iOSOneButtonDialog(this.f1656h).setMessage(this.f19234p.getHint()).show();
            } else if (LoginUser.getLoginUser().getUserType() == 1) {
                Http.with(this.f1656h).setObservable(((i) Http.getApiService(i.class)).f(LoginUser.getLoginUser().getUserId(), this.f19236r, this.f19237s, trim3, Integer.valueOf(this.f19231m.getNumber()), trim, trim2, "0", null)).setDataListener(new b());
            } else {
                Http.with(this.f1656h).setObservable(((i) Http.getApiService(i.class)).d(this.f19238t, this.f19239u, this.f19237s, trim3, Integer.valueOf(this.f19231m.getNumber()), trim, trim2, "0", null)).setDataListener(new c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(View v3) {
        new com.bxkj.base.util.i(this.f1656h).j(this.f19230l, "\u8bf7\u9009\u62e9\u6821\u533a", ((i) Http.getApiService(i.class)).b(), new i.c() { // from class: com.bxkj.equipment.f
            @Override // com.bxkj.base.util.i.c
            public final void a(String str, String str2, Map map) {
                ApplyEquipmentActivity.this.w0(str, str2, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(View v3) {
        if (TextUtils.isEmpty(this.f19236r)) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u5148\u9009\u62e9\u6821\u533a").show();
        } else {
            new com.bxkj.base.util.i(this.f1656h).j(this.f19229k, "\u8bf7\u9009\u62e9\u5668\u6750", ((i) Http.getApiService(i.class)).c(this.f19236r), new i.c() { // from class: com.bxkj.equipment.g
                @Override // com.bxkj.base.util.i.c
                public final void a(String str, String str2, Map map) {
                    ApplyEquipmentActivity.this.x0(str, str2, map);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(View v3) {
        new com.bxkj.base.util.i(this.f1656h).h(this.f19232n, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(View v3) {
        new com.bxkj.base.util.i(this.f1656h).h(this.f19233o, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(View v3) {
        q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(String id, String name, Map selectMapData) {
        this.f19236r = id;
        this.f19229k.setText("");
        this.f19237s = "";
        this.f19231m.e(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(String id, String name, Map selectMapData) {
        this.f19237s = id;
        int i4 = JsonParse.getInt(selectMapData, RewardPlus.AMOUNT);
        if (this.f19231m.getNumber() > i4) {
            this.f19231m.e(i4);
        }
        this.f19231m.f(i4);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19230l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyEquipmentActivity.this.r0(view);
            }
        });
        this.f19229k.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyEquipmentActivity.this.s0(view);
            }
        });
        this.f19232n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyEquipmentActivity.this.t0(view);
            }
        });
        this.f19233o.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyEquipmentActivity.this.u0(view);
            }
        });
        this.f19231m.g(new a());
        this.f19235q.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyEquipmentActivity.this.v0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_apply_equipment;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("teacherCurriculumId")) {
            this.f19238t = getIntent().getStringExtra("teacherCurriculumId");
        }
        if (getIntent().hasExtra("week")) {
            this.f19239u = getIntent().getIntExtra("week", 0);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u501f\u7528\u5668\u6750");
        f0(getResources().getColor(R.color.colorWhite));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19230l = (TextView) findViewById(R.id.tv_campus);
        this.f19229k = (TextView) findViewById(R.id.tv_name);
        this.f19231m = (NumberButton) findViewById(R.id.number_button);
        this.f19232n = (TextView) findViewById(R.id.tv_receive_date);
        this.f19233o = (TextView) findViewById(R.id.tv_return_date);
        this.f19234p = (EditText) findViewById(R.id.et_reason);
        this.f19235q = (Button) findViewById(R.id.bt_commit);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
