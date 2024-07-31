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
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.place.C4159R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p650v.PlaceApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ApplyPlaceActivity extends BaseActivity {

    /* renamed from: k */
    private CardView f15798k;

    /* renamed from: l */
    private CardView f15799l;

    /* renamed from: m */
    private EditText f15800m;

    /* renamed from: n */
    private Button f15801n;

    /* renamed from: o */
    private String f15802o;

    /* renamed from: p */
    private String f15803p;

    /* renamed from: q */
    private int f15804q;

    /* renamed from: r */
    private TextView f15805r;

    /* renamed from: s */
    private ListView f15806s;

    /* renamed from: t */
    private List<Map<String, Object>> f15807t = new ArrayList();

    /* renamed from: u */
    private CommonAdapter<Map<String, Object>> f15808u;

    /* renamed from: com.bxkj.place.apply.ApplyPlaceActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4171a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.place.apply.ApplyPlaceActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4172a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f15810a;

            View$OnClickListenerC4172a(final Map val$stringObjectMap) {
                this.f15810a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ApplyPlaceActivity.this.f15807t.remove(this.f15810a);
                C4171a.this.notifyDataSetChanged();
            }
        }

        C4171a(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(C4159R.C4163id.tv_name, JsonParse.getString(stringObjectMap, "name"));
            holder.m57874J(C4159R.C4163id.tv_number, JsonParse.getString(stringObjectMap, "userNum"));
            holder.m57847w(C4159R.C4163id.bt_del, new View$OnClickListenerC4172a(stringObjectMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.place.apply.ApplyPlaceActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4173b implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ iOSTwoButtonDialog f15812a;

        /* renamed from: com.bxkj.place.apply.ApplyPlaceActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4174a extends HttpCallBack {
            C4174a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnOtherStatus(int status, String msg) {
                new iOSOneButtonDialog(((BaseActivity) ApplyPlaceActivity.this).f1669h).setMessage(msg).show();
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                C4173b.this.f15812a.dismiss();
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.put("userNum", JsonParse.getString(data, "userNum"));
                arrayMap.put("name", JsonParse.getString(data, "name"));
                arrayMap.put("id", JsonParse.getString(data, "id"));
                ApplyPlaceActivity.this.f15807t.add(arrayMap);
                ApplyPlaceActivity.this.f15808u.notifyDataSetChanged();
            }
        }

        C4173b(final iOSTwoButtonDialog val$iOSTwoButtonDialog) {
            this.f15812a = val$iOSTwoButtonDialog;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            this.f15812a.show();
            EditText editText = (EditText) this.f15812a.findViewById(C4159R.C4163id.et_number);
            String trim = editText.getText().toString().trim();
            if (trim.isEmpty()) {
                ApplyPlaceActivity.this.m57919h0(editText.getHint());
            } else {
                Http.with(((BaseActivity) ApplyPlaceActivity.this).f1669h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((PlaceApiService) Http.getApiService(PlaceApiService.class)).m214g(LoginUser.getLoginUser().getUserId(), trim)).setDataListener(new C4174a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.place.apply.ApplyPlaceActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4175c extends HttpCallBack {
        C4175c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            new iOSOneButtonDialog(((BaseActivity) ApplyPlaceActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ((PlaceListActivity) AppManager.m57776n().getActivity(PlaceListActivity.class)).m43070E0();
            ApplyPlaceActivity.this.finish();
        }
    }

    /* renamed from: n0 */
    private void m43079n0() {
        m43076q0();
    }

    /* renamed from: o0 */
    private void m43078o0() {
        this.f15800m = (EditText) findViewById(C4159R.C4163id.et_reason);
        this.f15801n = (Button) findViewById(C4159R.C4163id.bt_commit);
        this.f15798k = (CardView) findViewById(C4159R.C4163id.cv_reason);
        this.f15799l = (CardView) findViewById(C4159R.C4163id.cv_friend);
        this.f15805r = (TextView) findViewById(C4159R.C4163id.tv_add);
        this.f15806s = (ListView) findViewById(C4159R.C4163id.f15771lv);
    }

    /* renamed from: p0 */
    private void m43077p0() {
        String trim = this.f15800m.getText().toString().trim();
        StringBuilder sb = new StringBuilder();
        if (this.f15804q == 2) {
            if (trim.isEmpty()) {
                m57919h0("请输入申请理由");
                return;
            }
        } else if (this.f15807t.size() == 0) {
            m57919h0("请输入随行人员");
            return;
        } else {
            for (Map<String, Object> map : this.f15807t) {
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                sb.append(JsonParse.getString(map, "userNum"));
            }
        }
        Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((PlaceApiService) Http.getApiService(PlaceApiService.class)).m212i(LoginUser.getLoginUser().getUserId(), this.f15802o, sb.toString(), trim, this.f15804q, "1")).setDataListener(new C4175c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15805r.setOnClickListener(this);
        this.f15801n.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4159R.C4165layout.ac_apply_place;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("id")) {
            this.f15802o = getIntent().getStringExtra("id");
        }
        if (getIntent().hasExtra("date")) {
            this.f15803p = getIntent().getStringExtra("date");
        }
        if (getIntent().hasExtra("appointType")) {
            this.f15804q = getIntent().getIntExtra("appointType", 1);
        }
        if (this.f15804q == 2) {
            this.f15801n.setText("立即申请");
            setTitle("申请场地");
            this.f15798k.setVisibility(0);
            this.f15799l.setVisibility(8);
            return;
        }
        this.f15801n.setText("立即预约");
        setTitle("预约场地");
        this.f15798k.setVisibility(8);
        this.f15799l.setVisibility(0);
        C4171a c4171a = new C4171a(this.f1669h, C4159R.C4165layout.item_for_add_info, this.f15807t);
        this.f15808u = c4171a;
        this.f15806s.setAdapter((ListAdapter) c4171a);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("申请场地");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        m43078o0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == C4159R.C4163id.tv_add) {
            m43079n0();
        } else if (id == C4159R.C4163id.bt_commit) {
            m43077p0();
        }
    }

    /* renamed from: q0 */
    public void m43076q0() {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1669h);
        iostwobuttondialog.setMessage("请输入要添加的随行人员的学号").setCenterCustomView(C4159R.C4165layout.dialog_input_account).setRightButtonOnClickListener(new C4173b(iostwobuttondialog)).show();
    }
}
