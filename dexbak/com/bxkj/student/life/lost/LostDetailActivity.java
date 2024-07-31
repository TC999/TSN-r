package com.bxkj.student.life.lost;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.tencent.open.SocialConstants;
import com.tencent.p562mm.opensdk.constants.ConstantsAPI;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import p635q.LostApiService;
import p640rx.Observable;
import retrofit2.Response;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LostDetailActivity extends BaseActivity {

    /* renamed from: A */
    private Map<String, Object> f18049A;

    /* renamed from: B */
    private List<String> f18050B;

    /* renamed from: C */
    private CommonAdapter<String> f18051C;

    /* renamed from: D */
    private int f18052D;

    /* renamed from: E */
    private String f18053E;

    /* renamed from: F */
    private cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter<Map<String, Object>> f18054F;

    /* renamed from: G */
    private String f18055G;

    /* renamed from: k */
    private TextView f18056k;

    /* renamed from: l */
    private TextView f18057l;

    /* renamed from: m */
    private TextView f18058m;

    /* renamed from: n */
    private MyGridView f18059n;

    /* renamed from: o */
    private LinearLayout f18060o;

    /* renamed from: p */
    private EditText f18061p;

    /* renamed from: q */
    private TextView f18062q;

    /* renamed from: r */
    private TextView f18063r;

    /* renamed from: s */
    private TextView f18064s;

    /* renamed from: t */
    private TextView f18065t;

    /* renamed from: u */
    private CheckBox f18066u;

    /* renamed from: v */
    private RecyclerView f18067v;

    /* renamed from: w */
    private Button f18068w;

    /* renamed from: x */
    private RelativeLayout f18069x;

    /* renamed from: y */
    private List<Map<String, Object>> f18070y;

    /* renamed from: z */
    private String f18071z;

    /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4891a extends CommonAdapter<String> {
        C4891a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, String s) {
            holder.m57850t(C4215R.C4219id.iv_img, s, 2131558617, 2131558617);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4892b extends cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4893a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ String f18074a;

            View$OnClickListenerC4893a(final String val$question) {
                this.f18074a = val$question;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LostDetailActivity.this.m41072z0(this.f18074a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$b$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C4894b extends CommonAdapter<Map<String, Object>> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$b$b$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            public class View$OnClickListenerC4895a implements View.OnClickListener {

                /* renamed from: a */
                final /* synthetic */ Map f18077a;

                View$OnClickListenerC4895a(final Map val$stringObjectMap) {
                    this.f18077a = val$stringObjectMap;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    LostDetailActivity.this.m41093A0(JsonParse.getString(this.f18077a, "validateAnswerId"), "1");
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$b$b$b */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            public class View$OnClickListenerC4896b implements View.OnClickListener {

                /* renamed from: a */
                final /* synthetic */ Map f18079a;

                View$OnClickListenerC4896b(final Map val$stringObjectMap) {
                    this.f18079a = val$stringObjectMap;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    LostDetailActivity.this.m41093A0(JsonParse.getString(this.f18079a, "validateAnswerId"), "0");
                }
            }

            C4894b(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
            /* renamed from: d */
            public void mo40086a(ViewHolder holder, final Map<String, Object> stringObjectMap) {
                String string = JsonParse.getString(stringObjectMap, "validateAnswer");
                holder.m57874J(C4215R.C4219id.tv_answer, JsonParse.getString(stringObjectMap, "validateUser") + ":" + string);
                holder.m57870N(C4215R.C4219id.bt_right, "Y".equals(LostDetailActivity.this.f18055G));
                Button button = (Button) holder.m57862h(C4215R.C4219id.bt_right);
                Button button2 = (Button) holder.m57862h(C4215R.C4219id.bt_error);
                Button button3 = (Button) holder.m57862h(C4215R.C4219id.bt_wait);
                if ("未审核".equals(JsonParse.getString(stringObjectMap, "reviewResult"))) {
                    if ("Y".equals(LostDetailActivity.this.f18055G)) {
                        button3.setVisibility(8);
                        button.setVisibility(0);
                        button2.setVisibility(0);
                        button.setEnabled(true);
                        button2.setEnabled(true);
                    } else {
                        button3.setVisibility(0);
                        button.setVisibility(8);
                        button2.setVisibility(8);
                        button.setEnabled(false);
                        button2.setEnabled(false);
                    }
                } else if ("正确".equals(JsonParse.getString(stringObjectMap, "reviewResult"))) {
                    button.setEnabled(false);
                    button.setVisibility(0);
                    button2.setVisibility(8);
                    button3.setVisibility(8);
                } else if ("错误".equals(JsonParse.getString(stringObjectMap, "reviewResult"))) {
                    button2.setEnabled(false);
                    button.setVisibility(8);
                    button2.setVisibility(0);
                    button3.setVisibility(8);
                }
                holder.m57847w(C4215R.C4219id.bt_right, new View$OnClickListenerC4895a(stringObjectMap));
                holder.m57847w(C4215R.C4219id.bt_error, new View$OnClickListenerC4896b(stringObjectMap));
            }
        }

        C4892b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            String string = JsonParse.getString(stringObjectMap, "question");
            holder.m57874J(C4215R.C4219id.tv_question, (holder.m57864f() + 1) + "." + string);
            holder.m57847w(C4215R.C4219id.bt_response, new View$OnClickListenerC4893a(string));
            ((ListView) holder.m57862h(C4215R.C4219id.lv_answer)).setAdapter((ListAdapter) new C4894b(this.f1721a, C4215R.C4221layout.item_for_answer_list, JsonParse.getList(stringObjectMap, "answer")));
            holder.m57870N(C4215R.C4219id.bt_response, "N".equals(LostDetailActivity.this.f18055G));
        }
    }

    /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4897c implements AdapterView.OnItemClickListener {
        C4897c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            LostDetailActivity lostDetailActivity = LostDetailActivity.this;
            lostDetailActivity.m41090D0((String[]) lostDetailActivity.f18050B.toArray(new String[LostDetailActivity.this.f18050B.size()]), position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4898d implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ Observable f18082a;

        /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$d$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4899a extends HttpCallBack {
            C4899a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                MyLostGoodsActivity myLostGoodsActivity = (MyLostGoodsActivity) AppManager.m57776n().getActivity(MyLostGoodsActivity.class);
                if (myLostGoodsActivity != null) {
                    myLostGoodsActivity.m41031w0();
                }
                if (LostDetailActivity.this.f18068w.getText().toString().trim().equals("删除")) {
                    LostDetailActivity.this.m57919h0("删除成功");
                    LostGoodsFragment lostGoodsFragment = (LostGoodsFragment) AppManager.m57776n().m57775o(LostGoodsFragment.class);
                    if (lostGoodsFragment != null) {
                        lostGoodsFragment.m41049g0();
                    }
                    LostDetailActivity.this.finish();
                    return;
                }
                LostDetailActivity.this.m57919h0("已关闭");
                LostDetailActivity.this.m41073y0();
            }
        }

        C4898d(final Observable val$observable) {
            this.f18082a = val$observable;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(((BaseActivity) LostDetailActivity.this).f1669h).setObservable(this.f18082a).setDataListener(new C4899a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4900e extends HttpCallBack {
        C4900e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LostDetailActivity.this.f18069x.setVisibility(0);
            LostDetailActivity.this.f18049A = data;
            LostDetailActivity.this.m41092B0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4901f implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ iOSTwoButtonDialog f18086a;

        /* renamed from: b */
        final /* synthetic */ String f18087b;

        /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$f$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4902a extends HttpCallBack {
            C4902a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnOtherStatus(int status, String msg) {
                super.netOnOtherStatus(status, msg);
                new iOSOneButtonDialog(((BaseActivity) LostDetailActivity.this).f1669h).setMessage(msg).show();
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                C4901f.this.f18086a.dismiss();
                LostDetailActivity.this.m57919h0("已提交回答，等待对方审核");
                LostDetailActivity.this.m41073y0();
            }
        }

        C4901f(final iOSTwoButtonDialog val$iOSTwoButtonDialog, final String val$question) {
            this.f18086a = val$iOSTwoButtonDialog;
            this.f18087b = val$question;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            this.f18086a.show();
            String trim = ((EditText) this.f18086a.findViewById(C4215R.C4219id.et_answer)).getText().toString().trim();
            if (trim.isEmpty()) {
                LostDetailActivity.this.m57919h0("答案不能为空");
            } else {
                Http.with(((BaseActivity) LostDetailActivity.this).f1669h).hideOtherStatusMessage().setObservable(((LostApiService) Http.getApiService(LostApiService.class)).m2282f(LostDetailActivity.this.f18071z, LoginUser.getLoginUser().getOpenId(), this.f18087b, trim)).setDataListener(new C4902a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4903g extends HttpCallBack {
        C4903g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) LostDetailActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LostDetailActivity.this.m41073y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public void m41093A0(final String validateAnswerId, String isRight) {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((LostApiService) Http.getApiService(LostApiService.class)).m2285c(LoginUser.getLoginUser().getOpenId(), validateAnswerId, isRight)).setDataListener(new C4903g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public void m41092B0() {
        this.f18056k.setText(JsonParse.getString(this.f18049A, "publishTime"));
        this.f18057l.setText(JsonParse.getString(this.f18049A, "goodsTypeName"));
        this.f18058m.setText(JsonParse.getString(this.f18049A, SocialConstants.PARAM_COMMENT));
        List<String> list = JsonParse.getList(this.f18049A, SocialConstants.PARAM_IMG_URL, String.class);
        this.f18050B = list;
        this.f18051C.m57842c(list);
        MyGridView myGridView = this.f18059n;
        List<String> list2 = this.f18050B;
        myGridView.setVisibility((list2 == null || list2.size() <= 0) ? 8 : 0);
        int i = JsonParse.getInt(this.f18049A, "isValidate");
        this.f18055G = JsonParse.getString(this.f18049A, "myMotice");
        String string = JsonParse.getString(this.f18049A, "validateCount");
        String string2 = JsonParse.getString(this.f18049A, "afterTime");
        TextView textView = this.f18064s;
        textView.setText("*输入答案错误超过" + string + "次，需要" + string2 + "以后再试");
        if (this.f18055G.equals("Y")) {
            if (i == 1) {
                this.f18066u.setVisibility(0);
                this.f18064s.setVisibility(0);
                this.f18066u.setText("回答与失物有关的问题，才能查看我的联系方式");
                List<Map<String, Object>> list3 = JsonParse.getList(this.f18049A, "question");
                this.f18070y = list3;
                this.f18054F.m57836g(list3);
            } else {
                this.f18066u.setVisibility(8);
                this.f18064s.setVisibility(8);
            }
            String string3 = JsonParse.getString(this.f18049A, "status");
            this.f18068w.setVisibility(0);
            if ("0".equals(string3)) {
                this.f18068w.setEnabled(true);
                this.f18068w.setText("删除");
            } else if ("1".equals(string3)) {
                this.f18068w.setEnabled(true);
                this.f18068w.setText("关闭");
            } else if ("2".equals(string3)) {
                this.f18068w.setEnabled(false);
                this.f18068w.setText("审核不通过");
            } else {
                this.f18068w.setEnabled(false);
                this.f18068w.setText("已关闭");
            }
        } else if (i == 1) {
            this.f18066u.setVisibility(0);
            this.f18064s.setVisibility(0);
            List<Map<String, Object>> list4 = JsonParse.getList(this.f18049A, "question");
            this.f18070y = list4;
            this.f18054F.m57836g(list4);
        } else {
            this.f18066u.setVisibility(8);
            this.f18064s.setVisibility(8);
        }
        m41091C0();
    }

    /* renamed from: C0 */
    private void m41091C0() {
        String string = JsonParse.getString(this.f18049A, "phone");
        if (TextUtils.isEmpty(string)) {
            ((View) this.f18062q.getParent()).setVisibility(8);
        } else {
            ((View) this.f18062q.getParent()).setVisibility(0);
            this.f18062q.setText(string);
        }
        String string2 = JsonParse.getString(this.f18049A, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE);
        if (TextUtils.isEmpty(string2)) {
            ((View) this.f18063r.getParent()).setVisibility(8);
        } else {
            ((View) this.f18063r.getParent()).setVisibility(0);
            this.f18063r.setText(string2);
        }
        String string3 = JsonParse.getString(this.f18049A, "qq");
        if (TextUtils.isEmpty(string3)) {
            ((View) this.f18065t.getParent()).setVisibility(8);
            return;
        }
        ((View) this.f18065t.getParent()).setVisibility(0);
        this.f18065t.setText(string3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public void m41090D0(String[] arr, int position) {
        Intent intent = new Intent(this.f1669h, ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.f1869h, arr);
        intent.putExtra(ImagePagerActivity.f1868g, position);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    /* renamed from: x0 */
    private void m41074x0() {
        Observable<Response<ResponseBody>> m2286b;
        if (this.f18068w.getText().toString().trim().equals("删除")) {
            m2286b = ((LostApiService) Http.getApiService(LostApiService.class)).m2287a(this.f18071z, LoginUser.getLoginUser().getOpenId());
        } else {
            m2286b = ((LostApiService) Http.getApiService(LostApiService.class)).m2286b(this.f18071z, LoginUser.getLoginUser().getOpenId());
        }
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1669h);
        iostwobuttondialog.setMessage("确定要" + this.f18068w.getText().toString().trim() + "吗？").setRightButtonOnClickListener(new C4898d(m2286b)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public void m41073y0() {
        Http.with(this.f1669h).setObservable(((LostApiService) Http.getApiService(LostApiService.class)).m2280h(this.f18071z, this.f18053E)).setDataListener(new C4900e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public void m41072z0(final String question) {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1669h);
        iostwobuttondialog.setTitle("回答问题");
        iostwobuttondialog.setMessage(question).setCenterCustomView(C4215R.C4221layout.dialog_response).setRightButtonOnClickListener(new C4901f(iostwobuttondialog, question)).show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18068w.setOnClickListener(this);
        this.f18059n.setOnItemClickListener(new C4897c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_lost_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (LoginUser.getLoginUser().isAuthorizationInLost()) {
            this.f18053E = LoginUser.getLoginUser().getOpenId();
        }
        if (getIntent().hasExtra("noticeId")) {
            this.f18071z = getIntent().getStringExtra("noticeId");
        }
        if (getIntent().hasExtra("lostType")) {
            int intExtra = getIntent().getIntExtra("lostType", 1);
            this.f18052D = intExtra;
            if (intExtra == 1) {
                setTitle("寻物启示");
                this.f18066u.setVisibility(8);
                this.f18060o.setVisibility(0);
                this.f18067v.setVisibility(8);
                this.f18064s.setVisibility(8);
            } else {
                setTitle("失物招领");
                this.f18066u.setVisibility(0);
                this.f18067v.setVisibility(0);
                this.f18064s.setVisibility(0);
            }
        }
        C4891a c4891a = new C4891a(this.f1669h, C4215R.C4221layout.item_for_lost_img, this.f18050B);
        this.f18051C = c4891a;
        this.f18059n.setAdapter((ListAdapter) c4891a);
        this.f18054F = new C4892b(this.f1669h, C4215R.C4221layout.item_for_question_list, this.f18070y);
        this.f18067v.setLayoutManager(new LinearLayoutManager(this.f1669h));
        this.f18067v.setAdapter(this.f18054F);
        this.f18067v.addItemDecoration(new DividerItemDecoration(this.f1669h, 1));
        m41073y0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("物品详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18056k = (TextView) findViewById(2131232926);
        this.f18057l = (TextView) findViewById(2131233211);
        this.f18058m = (TextView) findViewById(2131232938);
        this.f18059n = (MyGridView) findViewById(2131231335);
        this.f18060o = (LinearLayout) findViewById(C4215R.C4219id.ll_link);
        this.f18061p = (EditText) findViewById(C4215R.C4219id.et_price);
        this.f18062q = (TextView) findViewById(2131233089);
        this.f18063r = (TextView) findViewById(C4215R.C4219id.tv_wechat);
        this.f18065t = (TextView) findViewById(C4215R.C4219id.tv_qq);
        this.f18066u = (CheckBox) findViewById(C4215R.C4219id.cb_show_question);
        this.f18067v = (RecyclerView) findViewById(C4215R.C4219id.rv_question_answer);
        this.f18068w = (Button) findViewById(C4215R.C4219id.bt_close);
        this.f18064s = (TextView) findViewById(C4215R.C4219id.tv_notice);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131232527);
        this.f18069x = relativeLayout;
        relativeLayout.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131230965) {
            return;
        }
        m41074x0();
    }
}
