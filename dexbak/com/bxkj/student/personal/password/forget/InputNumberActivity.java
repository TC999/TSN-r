package com.bxkj.student.personal.password.forget;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.utils.StatusUtil;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class InputNumberActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f18904k;

    /* renamed from: l */
    private Button f18905l;

    /* renamed from: com.bxkj.student.personal.password.forget.InputNumberActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnClickListenerC5171a implements View.OnClickListener {
        View$OnClickListenerC5171a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            InputNumberActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.password.forget.InputNumberActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5172b extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ String f18907a;

        C5172b(final String val$number) {
            this.f18907a = val$number;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InputNumberActivity.this.startActivity(new Intent(((BaseActivity) InputNumberActivity.this).f1669h, SelectClassmateActivity.class).putExtra("userNumber", this.f18907a).putExtra("classmate", JSON.toJSONString(JsonParse.getList(data, "data"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void m40408k0(View view) {
        m40407l0();
    }

    /* renamed from: l0 */
    private void m40407l0() {
        String trim = this.f18904k.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请输入要找回密码的学号").show();
        } else {
            Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m140U0(trim)).setDataListener(new C5172b(trim));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18905l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.password.forget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputNumberActivity.this.m40408k0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_input_number;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        m57922e0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18904k = (EditText) findViewById(C4215R.C4219id.et_account);
        this.f18905l = (Button) findViewById(C4215R.C4219id.bt_next);
        Toolbar toolbar = (Toolbar) findViewById(C4215R.C4219id.f16009tb);
        ((TextView) findViewById(2131233204)).setText("输入要找回密码的学号");
        toolbar.setNavigationIcon(2131165513);
        toolbar.setNavigationOnClickListener(new View$OnClickListenerC5171a());
        try {
            toolbar.getRootView().getRootView().setBackgroundResource(C4215R.mipmap.login_bg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        StatusUtil.m42797d(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
