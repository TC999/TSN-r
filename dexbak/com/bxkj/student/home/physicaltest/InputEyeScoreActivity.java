package com.bxkj.student.home.physicaltest;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class InputEyeScoreActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f16365k;

    /* renamed from: l */
    private EmptyRecyclerView f16366l;

    /* renamed from: m */
    private TextView f16367m;

    /* renamed from: n */
    private Button f16368n;

    /* renamed from: p */
    private CommonAdapter<Map<String, Object>> f16370p;

    /* renamed from: o */
    private List<Map<String, Object>> f16369o = new ArrayList();

    /* renamed from: q */
    boolean f16371q = true;

    /* renamed from: com.bxkj.student.home.physicaltest.InputEyeScoreActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4325a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.physicaltest.InputEyeScoreActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C4326a implements TextWatcher {

            /* renamed from: a */
            final /* synthetic */ Map f16373a;

            C4326a(final Map val$stringObjectMap) {
                this.f16373a = val$stringObjectMap;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                this.f16373a.put("score", s.toString());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        }

        C4325a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233107, JsonParse.getString(stringObjectMap, "examName"));
            holder.m57874J(C4215R.C4219id.et_score, JsonParse.getString(stringObjectMap, "score"));
            ((EditText) holder.m57862h(C4215R.C4219id.et_score)).addTextChangedListener(new C4326a(stringObjectMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.InputEyeScoreActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4327b extends HttpCallBack {
        C4327b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InputEyeScoreActivity.this.f16369o = JsonParse.getList(data, "data");
            InputEyeScoreActivity.this.f16370p.m57836g(InputEyeScoreActivity.this.f16369o);
            if (InputEyeScoreActivity.this.f16369o.isEmpty()) {
                return;
            }
            InputEyeScoreActivity.this.m57932R().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.InputEyeScoreActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4328c extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ int f16376a;

        C4328c(final int val$finalIndex) {
            this.f16376a = val$finalIndex;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InputEyeScoreActivity.this.m42674o0(this.f16376a + 1);
        }
    }

    /* renamed from: n0 */
    private void m42675n0() {
        this.f16371q = true;
        m42674o0(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public void m42674o0(int index) {
        if (index == this.f16369o.size()) {
            m42673p0();
            if (this.f16371q) {
                return;
            }
            new iOSOneButtonDialog(this.f1669h).setMessage("添加成功").show();
            return;
        }
        Map<String, Object> map = this.f16369o.get(index);
        if (!JsonParse.getString(map, "score").isEmpty()) {
            this.f16371q = false;
            Http.with(this.f1669h).hideSuccessMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m150P0(LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getAccount(), JsonParse.getString(map, "id"), JsonParse.getString(map, "score"))).setDataListener(new C4328c(index));
            return;
        }
        m42674o0(index + 1);
    }

    /* renamed from: p0 */
    private void m42673p0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m184B1(LoginUser.getLoginUser().getUserId())).setDataListener(new C4327b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void m42672q0(View view) {
        m42675n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16368n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.physicaltest.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputEyeScoreActivity.this.m42672q0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_input_eye;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m57932R().setVisibility(8);
        this.f16366l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4325a c4325a = new C4325a(this.f1669h, C4215R.C4221layout.item_for_input_eye, this.f16369o);
        this.f16370p = c4325a;
        this.f16366l.setAdapter(c4325a);
        this.f16366l.setEmptyView(this.f16367m);
        m42673p0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("自助视力");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16365k = (SmartRefreshLayout) findViewById(2131232482);
        this.f16366l = (EmptyRecyclerView) findViewById(2131232481);
        this.f16367m = (TextView) findViewById(2131232952);
        this.f16368n = (Button) findViewById(2131230967);
        this.f16365k.mo2050b0(false);
        this.f16365k.mo2064P(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
