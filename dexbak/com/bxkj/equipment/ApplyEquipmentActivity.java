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
import com.bxkj.base.util.DropDownSpinnerDialog;
import com.bxkj.equipment.view.NumberButton;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ApplyEquipmentActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f15699k;

    /* renamed from: l */
    private TextView f15700l;

    /* renamed from: m */
    private NumberButton f15701m;

    /* renamed from: n */
    private TextView f15702n;

    /* renamed from: o */
    private TextView f15703o;

    /* renamed from: p */
    private EditText f15704p;

    /* renamed from: q */
    private Button f15705q;

    /* renamed from: r */
    private String f15706r;

    /* renamed from: s */
    private String f15707s;

    /* renamed from: t */
    private String f15708t;

    /* renamed from: u */
    private int f15709u = 0;

    /* renamed from: com.bxkj.equipment.ApplyEquipmentActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4130a implements NumberButton.InterfaceC4158a {
        C4130a() {
        }

        @Override // com.bxkj.equipment.view.NumberButton.InterfaceC4158a
        public void onNumberChanged(int number) {
        }

        @Override // com.bxkj.equipment.view.NumberButton.InterfaceC4158a
        public void onWarningForBuyMax(int max) {
        }

        @Override // com.bxkj.equipment.view.NumberButton.InterfaceC4158a
        public void onWarningForInventory(int inventory) {
            new iOSOneButtonDialog(((BaseActivity) ApplyEquipmentActivity.this).f1669h).setMessage("库存不足").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.equipment.ApplyEquipmentActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4131b extends HttpCallBack {
        C4131b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyEquipmentActivity.this.finish();
            ApplyEquipmentActivity.this.m57919h0("申请成功");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.equipment.ApplyEquipmentActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4132c extends HttpCallBack {
        C4132c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyEquipmentActivity.this.finish();
            ApplyEquipmentActivity.this.m57919h0("申请成功");
        }
    }

    /* renamed from: q0 */
    private void m43125q0() {
        if (TextUtils.isEmpty(this.f15706r)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请选择校区").show();
        } else if (TextUtils.isEmpty(this.f15707s)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请选择器材").show();
        } else {
            String trim = this.f15702n.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                new iOSOneButtonDialog(this.f1669h).setMessage(this.f15702n.getHint()).show();
                return;
            }
            String trim2 = this.f15703o.getText().toString().trim();
            if (TextUtils.isEmpty(trim2)) {
                new iOSOneButtonDialog(this.f1669h).setMessage(this.f15703o.getHint()).show();
                return;
            }
            String trim3 = this.f15704p.getText().toString().trim();
            if (TextUtils.isEmpty(trim3)) {
                new iOSOneButtonDialog(this.f1669h).setMessage(this.f15704p.getHint()).show();
            } else if (LoginUser.getLoginUser().getUserType() == 1) {
                Http.with(this.f1669h).setObservable(((EquipmentApiService) Http.getApiService(EquipmentApiService.class)).m43095f(LoginUser.getLoginUser().getUserId(), this.f15706r, this.f15707s, trim3, Integer.valueOf(this.f15701m.getNumber()), trim, trim2, "0", null)).setDataListener(new C4131b());
            } else {
                Http.with(this.f1669h).setObservable(((EquipmentApiService) Http.getApiService(EquipmentApiService.class)).m43097d(this.f15708t, this.f15709u, this.f15707s, trim3, Integer.valueOf(this.f15701m.getNumber()), trim, trim2, "0", null)).setDataListener(new C4132c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ void m43124r0(View v) {
        new DropDownSpinnerDialog(this.f1669h).m44081j(this.f15700l, "请选择校区", ((EquipmentApiService) Http.getApiService(EquipmentApiService.class)).m43099b(), new DropDownSpinnerDialog.InterfaceC3904c() { // from class: com.bxkj.equipment.f
            @Override // com.bxkj.base.util.DropDownSpinnerDialog.InterfaceC3904c
            /* renamed from: a */
            public final void mo41979a(String str, String str2, Map map) {
                ApplyEquipmentActivity.this.m43119w0(str, str2, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void m43123s0(View v) {
        if (TextUtils.isEmpty(this.f15706r)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请先选择校区").show();
        } else {
            new DropDownSpinnerDialog(this.f1669h).m44081j(this.f15699k, "请选择器材", ((EquipmentApiService) Http.getApiService(EquipmentApiService.class)).m43098c(this.f15706r), new DropDownSpinnerDialog.InterfaceC3904c() { // from class: com.bxkj.equipment.g
                @Override // com.bxkj.base.util.DropDownSpinnerDialog.InterfaceC3904c
                /* renamed from: a */
                public final void mo41979a(String str, String str2, Map map) {
                    ApplyEquipmentActivity.this.m43118x0(str, str2, map);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ void m43122t0(View v) {
        new DropDownSpinnerDialog(this.f1669h).m44083h(this.f15702n, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void m43121u0(View v) {
        new DropDownSpinnerDialog(this.f1669h).m44083h(this.f15703o, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void m43120v0(View v) {
        m43125q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void m43119w0(String id, String name, Map selectMapData) {
        this.f15706r = id;
        this.f15699k.setText("");
        this.f15707s = "";
        this.f15701m.m43090e(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ void m43118x0(String id, String name, Map selectMapData) {
        this.f15707s = id;
        int i = JsonParse.getInt(selectMapData, RewardPlus.AMOUNT);
        if (this.f15701m.getNumber() > i) {
            this.f15701m.m43090e(i);
        }
        this.f15701m.m43089f(i);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15700l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyEquipmentActivity.this.m43124r0(view);
            }
        });
        this.f15699k.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyEquipmentActivity.this.m43123s0(view);
            }
        });
        this.f15702n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyEquipmentActivity.this.m43122t0(view);
            }
        });
        this.f15703o.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyEquipmentActivity.this.m43121u0(view);
            }
        });
        this.f15701m.m43088g(new C4130a());
        this.f15705q.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyEquipmentActivity.this.m43120v0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4133R.C4139layout.ac_apply_equipment;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("teacherCurriculumId")) {
            this.f15708t = getIntent().getStringExtra("teacherCurriculumId");
        }
        if (getIntent().hasExtra("week")) {
            this.f15709u = getIntent().getIntExtra("week", 0);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("借用器材");
        m57921f0(getResources().getColor(C4133R.C4135color.colorWhite));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15700l = (TextView) findViewById(C4133R.C4137id.tv_campus);
        this.f15699k = (TextView) findViewById(C4133R.C4137id.tv_name);
        this.f15701m = (NumberButton) findViewById(C4133R.C4137id.number_button);
        this.f15702n = (TextView) findViewById(C4133R.C4137id.tv_receive_date);
        this.f15703o = (TextView) findViewById(C4133R.C4137id.tv_return_date);
        this.f15704p = (EditText) findViewById(C4133R.C4137id.et_reason);
        this.f15705q = (Button) findViewById(C4133R.C4137id.bt_commit);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
