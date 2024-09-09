package com.bxkj.place.apply;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.collection.ArrayMap;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.place.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ApplyPlaceActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private CardView f19280k;

    /* renamed from: l  reason: collision with root package name */
    private CardView f19281l;

    /* renamed from: m  reason: collision with root package name */
    private EditText f19282m;

    /* renamed from: n  reason: collision with root package name */
    private Button f19283n;

    /* renamed from: o  reason: collision with root package name */
    private String f19284o;

    /* renamed from: p  reason: collision with root package name */
    private String f19285p;

    /* renamed from: q  reason: collision with root package name */
    private int f19286q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f19287r;

    /* renamed from: s  reason: collision with root package name */
    private ListView f19288s;

    /* renamed from: t  reason: collision with root package name */
    private List<Map<String, Object>> f19289t = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f19290u;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.place.apply.ApplyPlaceActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0212a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f19292a;

            View$OnClickListenerC0212a(final Map val$stringObjectMap) {
                this.f19292a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                ApplyPlaceActivity.this.f19289t.remove(this.f19292a);
                a.this.notifyDataSetChanged();
            }
        }

        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d */
        public void a(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, "name"));
            holder.J(R.id.tv_number, JsonParse.getString(stringObjectMap, "userNum"));
            holder.w(R.id.bt_del, new View$OnClickListenerC0212a(stringObjectMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ iOSTwoButtonDialog f19294a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnOtherStatus(int status, String msg) {
                new iOSOneButtonDialog(((BaseActivity) ApplyPlaceActivity.this).f1656h).setMessage(msg).show();
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                b.this.f19294a.dismiss();
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.put("userNum", JsonParse.getString(data, "userNum"));
                arrayMap.put("name", JsonParse.getString(data, "name"));
                arrayMap.put("id", JsonParse.getString(data, "id"));
                ApplyPlaceActivity.this.f19289t.add(arrayMap);
                ApplyPlaceActivity.this.f19290u.notifyDataSetChanged();
            }
        }

        b(final iOSTwoButtonDialog val$iOSTwoButtonDialog) {
            this.f19294a = val$iOSTwoButtonDialog;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            this.f19294a.show();
            EditText editText = (EditText) this.f19294a.findViewById(R.id.et_number);
            String trim = editText.getText().toString().trim();
            if (trim.isEmpty()) {
                ApplyPlaceActivity.this.h0(editText.getHint());
            } else {
                Http.with(((BaseActivity) ApplyPlaceActivity.this).f1656h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((v.b) Http.getApiService(v.b.class)).g(LoginUser.getLoginUser().getUserId(), trim)).setDataListener(new a());
            }
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

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            new iOSOneButtonDialog(((BaseActivity) ApplyPlaceActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ((PlaceListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(PlaceListActivity.class)).E0();
            ApplyPlaceActivity.this.finish();
        }
    }

    private void n0() {
        q0();
    }

    private void o0() {
        this.f19282m = (EditText) findViewById(R.id.et_reason);
        this.f19283n = (Button) findViewById(R.id.bt_commit);
        this.f19280k = (CardView) findViewById(R.id.cv_reason);
        this.f19281l = (CardView) findViewById(R.id.cv_friend);
        this.f19287r = (TextView) findViewById(R.id.tv_add);
        this.f19288s = (ListView) findViewById(R.id.lv);
    }

    private void p0() {
        String trim = this.f19282m.getText().toString().trim();
        StringBuilder sb = new StringBuilder();
        if (this.f19286q == 2) {
            if (trim.isEmpty()) {
                h0("\u8bf7\u8f93\u5165\u7533\u8bf7\u7406\u7531");
                return;
            }
        } else if (this.f19289t.size() == 0) {
            h0("\u8bf7\u8f93\u5165\u968f\u884c\u4eba\u5458");
            return;
        } else {
            for (Map<String, Object> map : this.f19289t) {
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                sb.append(JsonParse.getString(map, "userNum"));
            }
        }
        Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((v.b) Http.getApiService(v.b.class)).i(LoginUser.getLoginUser().getUserId(), this.f19284o, sb.toString(), trim, this.f19286q, "1")).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19287r.setOnClickListener(this);
        this.f19283n.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_apply_place;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("id")) {
            this.f19284o = getIntent().getStringExtra("id");
        }
        if (getIntent().hasExtra("date")) {
            this.f19285p = getIntent().getStringExtra("date");
        }
        if (getIntent().hasExtra("appointType")) {
            this.f19286q = getIntent().getIntExtra("appointType", 1);
        }
        if (this.f19286q == 2) {
            this.f19283n.setText("\u7acb\u5373\u7533\u8bf7");
            setTitle("\u7533\u8bf7\u573a\u5730");
            this.f19280k.setVisibility(0);
            this.f19281l.setVisibility(8);
            return;
        }
        this.f19283n.setText("\u7acb\u5373\u9884\u7ea6");
        setTitle("\u9884\u7ea6\u573a\u5730");
        this.f19280k.setVisibility(8);
        this.f19281l.setVisibility(0);
        a aVar = new a(this.f1656h, R.layout.item_for_add_info, this.f19289t);
        this.f19290u = aVar;
        this.f19288s.setAdapter((ListAdapter) aVar);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7533\u8bf7\u573a\u5730");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        o0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        int id = v3.getId();
        if (id == R.id.tv_add) {
            n0();
        } else if (id == R.id.bt_commit) {
            p0();
        }
    }

    public void q0() {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1656h);
        iostwobuttondialog.setMessage("\u8bf7\u8f93\u5165\u8981\u6dfb\u52a0\u7684\u968f\u884c\u4eba\u5458\u7684\u5b66\u53f7").setCenterCustomView(R.layout.dialog_input_account).setRightButtonOnClickListener(new b(iostwobuttondialog)).show();
    }
}
