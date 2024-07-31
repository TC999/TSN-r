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
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.utils.StatusUtil;
import com.bxkj.student.common.utils.UniversalItemDecoration;
import com.bxkj.student.personal.login.LoginActivity;
import com.bxkj.student.personal.password.forget.SelectClassmateActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SelectClassmateActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f18909k;

    /* renamed from: l */
    private RecyclerView f18910l;

    /* renamed from: m */
    private Button f18911m;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f18912n;

    /* renamed from: o */
    private List<Map<String, Object>> f18913o = new ArrayList();

    /* renamed from: p */
    private String f18914p;

    /* renamed from: com.bxkj.student.personal.password.forget.SelectClassmateActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnClickListenerC5173a implements View.OnClickListener {
        View$OnClickListenerC5173a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            SelectClassmateActivity.this.finish();
        }
    }

    /* renamed from: com.bxkj.student.personal.password.forget.SelectClassmateActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5174b extends CommonAdapter<Map<String, Object>> {
        C5174b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o */
        public static /* synthetic */ void m40392o(Map map, CompoundButton compoundButton, boolean z) {
            map.put("isChecked", Boolean.valueOf(z));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "userName"));
            holder.m57857m(2131231079, JsonParse.getBoolean(stringObjectMap, "isChecked"));
            ((CheckBox) holder.m57862h(2131231079)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bxkj.student.personal.password.forget.d
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    SelectClassmateActivity.C5174b.m40392o(stringObjectMap, compoundButton, z);
                }
            });
        }
    }

    /* renamed from: com.bxkj.student.personal.password.forget.SelectClassmateActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5175c extends UniversalItemDecoration {
        C5175c() {
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration
        /* renamed from: a */
        public UniversalItemDecoration.AbstractC4246b mo40391a(int position) {
            UniversalItemDecoration.C4245a c4245a = new UniversalItemDecoration.C4245a();
            c4245a.f16215d = Tools.m57620a(1.0f, ((BaseActivity) SelectClassmateActivity.this).f1669h);
            c4245a.f16211f = -1;
            return c4245a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.password.forget.SelectClassmateActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5176d extends HttpCallBack {

        /* renamed from: com.bxkj.student.personal.password.forget.SelectClassmateActivity$d$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5177a extends HttpCallBack {
            C5177a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                SelectClassmateActivity.this.f18913o = JsonParse.getList(data, "data");
                SelectClassmateActivity.this.f18912n.m57836g(SelectClassmateActivity.this.f18913o);
            }
        }

        C5176d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m40389b(View view) {
            AppManager.m57776n().m57780j();
            SelectClassmateActivity.this.startActivity(new Intent(((BaseActivity) SelectClassmateActivity.this).f1669h, LoginActivity.class));
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            if (status == 202) {
                new iOSOneButtonDialog(((BaseActivity) SelectClassmateActivity.this).f1669h).setMessage(msg).show();
                Http.with(((BaseActivity) SelectClassmateActivity.this).f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m140U0(SelectClassmateActivity.this.f18914p)).setDataListener(new C5177a());
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
            new iOSOneButtonDialog(((BaseActivity) SelectClassmateActivity.this).f1669h).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.password.forget.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectClassmateActivity.C5176d.this.m40389b(view);
                }
            }).show();
        }
    }

    /* renamed from: s0 */
    private void m40396s0() {
        String trim = this.f18909k.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请输入身份证号").show();
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> map : this.f18913o) {
            if (JsonParse.getBoolean(map, "isChecked")) {
                String string = JsonParse.getString(map, "userName");
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                sb.append(string);
            }
        }
        Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m160K0(this.f18914p, trim, sb.toString())).setDataListener(new C5176d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ void m40395t0(View view) {
        m40396s0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18911m.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.password.forget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectClassmateActivity.this.m40395t0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_select_classmate;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("userNumber")) {
            this.f18914p = getIntent().getStringExtra("userNumber");
        }
        if (getIntent().hasExtra("classmate")) {
            this.f18913o = JsonParse.jsonToListMap(getIntent().getStringExtra("classmate"));
        }
        this.f18910l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C5174b c5174b = new C5174b(this.f1669h, C4215R.C4221layout.item_for_select_classmate, this.f18913o);
        this.f18912n = c5174b;
        this.f18910l.setAdapter(c5174b);
        this.f18910l.addItemDecoration(new C5175c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        m57922e0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18909k = (EditText) findViewById(C4215R.C4219id.et_idCard);
        this.f18910l = (RecyclerView) findViewById(C4215R.C4219id.rv_classmate);
        this.f18911m = (Button) findViewById(2131230989);
        Toolbar toolbar = (Toolbar) findViewById(C4215R.C4219id.f16009tb);
        ((TextView) findViewById(2131233204)).setText("输入身份证号并选择行政班的同班同学");
        toolbar.setNavigationIcon(2131165513);
        toolbar.setNavigationOnClickListener(new View$OnClickListenerC5173a());
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
