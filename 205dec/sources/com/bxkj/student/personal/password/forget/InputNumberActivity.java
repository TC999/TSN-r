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
import com.bxkj.student.common.utils.m;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class InputNumberActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f22188k;

    /* renamed from: l  reason: collision with root package name */
    private Button f22189l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            InputNumberActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22191a;

        b(final String val$number) {
            this.f22191a = val$number;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InputNumberActivity.this.startActivity(new Intent(((BaseActivity) InputNumberActivity.this).f1656h, SelectClassmateActivity.class).putExtra("userNumber", this.f22191a).putExtra("classmate", JSON.toJSONString(JsonParse.getList(data, "data"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        l0();
    }

    private void l0() {
        String trim = this.f22188k.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u8f93\u5165\u8981\u627e\u56de\u5bc6\u7801\u7684\u5b66\u53f7").show();
        } else {
            Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).U0(trim)).setDataListener(new b(trim));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22189l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.password.forget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputNumberActivity.this.k0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427417;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        e0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22188k = (EditText) findViewById(2131231250);
        this.f22189l = (Button) findViewById(2131230988);
        Toolbar toolbar = (Toolbar) findViewById(2131232711);
        ((TextView) findViewById(2131233204)).setText("\u8f93\u5165\u8981\u627e\u56de\u5bc6\u7801\u7684\u5b66\u53f7");
        toolbar.setNavigationIcon(2131165513);
        toolbar.setNavigationOnClickListener(new a());
        try {
            toolbar.getRootView().getRootView().setBackgroundResource(2131558821);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        m.d(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
