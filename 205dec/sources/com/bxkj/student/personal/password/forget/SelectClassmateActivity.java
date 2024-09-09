package com.bxkj.student.personal.password.forget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.common.utils.UniversalItemDecoration;
import com.bxkj.student.common.utils.m;
import com.bxkj.student.personal.login.LoginActivity;
import com.bxkj.student.personal.password.forget.SelectClassmateActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SelectClassmateActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f22193k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f22194l;

    /* renamed from: m  reason: collision with root package name */
    private Button f22195m;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f22196n;

    /* renamed from: o  reason: collision with root package name */
    private List<Map<String, Object>> f22197o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private String f22198p;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            SelectClassmateActivity.this.finish();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void o(Map map, CompoundButton compoundButton, boolean z3) {
            map.put("isChecked", Boolean.valueOf(z3));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "userName"));
            holder.m(2131231079, JsonParse.getBoolean(stringObjectMap, "isChecked"));
            ((CheckBox) holder.h(2131231079)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bxkj.student.personal.password.forget.d
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                    SelectClassmateActivity.b.o(stringObjectMap, compoundButton, z3);
                }
            });
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c extends UniversalItemDecoration {
        c() {
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration
        public UniversalItemDecoration.b a(int position) {
            UniversalItemDecoration.a aVar = new UniversalItemDecoration.a();
            aVar.f19614d = u.a(1.0f, ((BaseActivity) SelectClassmateActivity.this).f1656h);
            aVar.f19610f = -1;
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                SelectClassmateActivity.this.f22197o = JsonParse.getList(data, "data");
                SelectClassmateActivity.this.f22196n.g(SelectClassmateActivity.this.f22197o);
            }
        }

        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            cn.bluemobi.dylan.base.utils.a.n().j();
            SelectClassmateActivity.this.startActivity(new Intent(((BaseActivity) SelectClassmateActivity.this).f1656h, LoginActivity.class));
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            if (status == 202) {
                new iOSOneButtonDialog(((BaseActivity) SelectClassmateActivity.this).f1656h).setMessage(msg).show();
                Http.with(((BaseActivity) SelectClassmateActivity.this).f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).U0(SelectClassmateActivity.this.f22198p)).setDataListener(new a());
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
            new iOSOneButtonDialog(((BaseActivity) SelectClassmateActivity.this).f1656h).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.password.forget.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectClassmateActivity.d.this.b(view);
                }
            }).show();
        }
    }

    private void s0() {
        String trim = this.f22193k.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u8f93\u5165\u8eab\u4efd\u8bc1\u53f7").show();
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> map : this.f22197o) {
            if (JsonParse.getBoolean(map, "isChecked")) {
                String string = JsonParse.getString(map, "userName");
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                sb.append(string);
            }
        }
        Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).K0(this.f22198p, trim, sb.toString())).setDataListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(View view) {
        s0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22195m.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.password.forget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectClassmateActivity.this.t0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427489;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("userNumber")) {
            this.f22198p = getIntent().getStringExtra("userNumber");
        }
        if (getIntent().hasExtra("classmate")) {
            this.f22197o = JsonParse.jsonToListMap(getIntent().getStringExtra("classmate"));
        }
        this.f22194l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        b bVar = new b(this.f1656h, 2131427758, this.f22197o);
        this.f22196n = bVar;
        this.f22194l.setAdapter(bVar);
        this.f22194l.addItemDecoration(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        e0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22193k = (EditText) findViewById(2131231259);
        this.f22194l = (RecyclerView) findViewById(2131232544);
        this.f22195m = (Button) findViewById(2131230989);
        Toolbar toolbar = (Toolbar) findViewById(2131232711);
        ((TextView) findViewById(2131233204)).setText("\u8f93\u5165\u8eab\u4efd\u8bc1\u53f7\u5e76\u9009\u62e9\u884c\u653f\u73ed\u7684\u540c\u73ed\u540c\u5b66");
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
