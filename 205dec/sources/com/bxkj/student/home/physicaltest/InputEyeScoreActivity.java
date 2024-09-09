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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class InputEyeScoreActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f19755k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f19756l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f19757m;

    /* renamed from: n  reason: collision with root package name */
    private Button f19758n;

    /* renamed from: p  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19760p;

    /* renamed from: o  reason: collision with root package name */
    private List<Map<String, Object>> f19759o = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    boolean f19761q = true;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.physicaltest.InputEyeScoreActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class C0221a implements TextWatcher {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f19763a;

            C0221a(final Map val$stringObjectMap) {
                this.f19763a = val$stringObjectMap;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s3) {
                this.f19763a.put("score", s3.toString());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s3, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s3, int start, int before, int count) {
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131233107, JsonParse.getString(stringObjectMap, "examName"));
            holder.J(2131231274, JsonParse.getString(stringObjectMap, "score"));
            ((EditText) holder.h(2131231274)).addTextChangedListener(new C0221a(stringObjectMap));
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
            InputEyeScoreActivity.this.f19759o = JsonParse.getList(data, "data");
            InputEyeScoreActivity.this.f19760p.g(InputEyeScoreActivity.this.f19759o);
            if (InputEyeScoreActivity.this.f19759o.isEmpty()) {
                return;
            }
            InputEyeScoreActivity.this.R().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19766a;

        c(final int val$finalIndex) {
            this.f19766a = val$finalIndex;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InputEyeScoreActivity.this.o0(this.f19766a + 1);
        }
    }

    private void n0() {
        this.f19761q = true;
        o0(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(int index) {
        if (index == this.f19759o.size()) {
            p0();
            if (this.f19761q) {
                return;
            }
            new iOSOneButtonDialog(this.f1656h).setMessage("\u6dfb\u52a0\u6210\u529f").show();
            return;
        }
        Map<String, Object> map = this.f19759o.get(index);
        if (!JsonParse.getString(map, "score").isEmpty()) {
            this.f19761q = false;
            Http.with(this.f1656h).hideSuccessMessage().setObservable(((w.a) Http.getApiService(w.a.class)).P0(LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getAccount(), JsonParse.getString(map, "id"), JsonParse.getString(map, "score"))).setDataListener(new c(index));
            return;
        }
        o0(index + 1);
    }

    private void p0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).B1(LoginUser.getLoginUser().getUserId())).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(View view) {
        n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19758n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.physicaltest.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputEyeScoreActivity.this.q0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427415;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        R().setVisibility(8);
        this.f19756l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427706, this.f19759o);
        this.f19760p = aVar;
        this.f19756l.setAdapter(aVar);
        this.f19756l.setEmptyView(this.f19757m);
        p0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u81ea\u52a9\u89c6\u529b");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19755k = (SmartRefreshLayout) findViewById(2131232482);
        this.f19756l = (EmptyRecyclerView) findViewById(2131232481);
        this.f19757m = (TextView) findViewById(2131232952);
        this.f19758n = (Button) findViewById(2131230967);
        this.f19755k.b0(false);
        this.f19755k.O(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
