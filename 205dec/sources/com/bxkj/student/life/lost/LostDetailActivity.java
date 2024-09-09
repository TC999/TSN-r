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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.user.LoginUser;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LostDetailActivity extends BaseActivity {
    private Map<String, Object> A;
    private List<String> B;
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> C;
    private int D;
    private String E;
    private CommonAdapter<Map<String, Object>> F;
    private String G;

    /* renamed from: k  reason: collision with root package name */
    private TextView f21387k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f21388l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f21389m;

    /* renamed from: n  reason: collision with root package name */
    private MyGridView f21390n;

    /* renamed from: o  reason: collision with root package name */
    private LinearLayout f21391o;

    /* renamed from: p  reason: collision with root package name */
    private EditText f21392p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f21393q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f21394r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f21395s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f21396t;

    /* renamed from: u  reason: collision with root package name */
    private CheckBox f21397u;

    /* renamed from: v  reason: collision with root package name */
    private RecyclerView f21398v;

    /* renamed from: w  reason: collision with root package name */
    private Button f21399w;

    /* renamed from: x  reason: collision with root package name */
    private RelativeLayout f21400x;

    /* renamed from: y  reason: collision with root package name */
    private List<Map<String, Object>> f21401y;

    /* renamed from: z  reason: collision with root package name */
    private String f21402z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d */
        public void a(ViewHolder holder, String s3) {
            holder.t(2131231436, s3, 2131558617, 2131558617);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f21405a;

            a(final String val$question) {
                this.f21405a = val$question;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                LostDetailActivity.this.z0(this.f21405a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class C0252b extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$b$b$a */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            public class a implements View.OnClickListener {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Map f21408a;

                a(final Map val$stringObjectMap) {
                    this.f21408a = val$stringObjectMap;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View v3) {
                    LostDetailActivity.this.A0(JsonParse.getString(this.f21408a, "validateAnswerId"), "1");
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$b$b$b  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            public class View$OnClickListenerC0253b implements View.OnClickListener {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Map f21410a;

                View$OnClickListenerC0253b(final Map val$stringObjectMap) {
                    this.f21410a = val$stringObjectMap;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View v3) {
                    LostDetailActivity.this.A0(JsonParse.getString(this.f21410a, "validateAnswerId"), "0");
                }
            }

            C0252b(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
            /* renamed from: d */
            public void a(ViewHolder holder, final Map<String, Object> stringObjectMap) {
                String string = JsonParse.getString(stringObjectMap, "validateAnswer");
                holder.J(2131232843, JsonParse.getString(stringObjectMap, "validateUser") + ":" + string);
                holder.N(2131231007, "Y".equals(LostDetailActivity.this.G));
                Button button = (Button) holder.h(2131231007);
                Button button2 = (Button) holder.h(2131230974);
                Button button3 = (Button) holder.h(2131231019);
                if ("\u672a\u5ba1\u6838".equals(JsonParse.getString(stringObjectMap, "reviewResult"))) {
                    if ("Y".equals(LostDetailActivity.this.G)) {
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
                } else if ("\u6b63\u786e".equals(JsonParse.getString(stringObjectMap, "reviewResult"))) {
                    button.setEnabled(false);
                    button.setVisibility(0);
                    button2.setVisibility(8);
                    button3.setVisibility(8);
                } else if ("\u9519\u8bef".equals(JsonParse.getString(stringObjectMap, "reviewResult"))) {
                    button2.setEnabled(false);
                    button.setVisibility(8);
                    button2.setVisibility(0);
                    button3.setVisibility(8);
                }
                holder.w(2131231007, new a(stringObjectMap));
                holder.w(2131230974, new View$OnClickListenerC0253b(stringObjectMap));
            }
        }

        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            String string = JsonParse.getString(stringObjectMap, "question");
            holder.J(2131233112, (holder.f() + 1) + "." + string);
            holder.w(2131231006, new a(string));
            ((ListView) holder.h(2131232246)).setAdapter((ListAdapter) new C0252b(this.f1707a, 2131427668, JsonParse.getList(stringObjectMap, "answer")));
            holder.N(2131231006, "N".equals(LostDetailActivity.this.G));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            LostDetailActivity lostDetailActivity = LostDetailActivity.this;
            lostDetailActivity.D0((String[]) lostDetailActivity.B.toArray(new String[LostDetailActivity.this.B.size()]), position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.e f21413a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                MyLostGoodsActivity myLostGoodsActivity = (MyLostGoodsActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(MyLostGoodsActivity.class);
                if (myLostGoodsActivity != null) {
                    myLostGoodsActivity.w0();
                }
                if (LostDetailActivity.this.f21399w.getText().toString().trim().equals("\u5220\u9664")) {
                    LostDetailActivity.this.h0("\u5220\u9664\u6210\u529f");
                    LostGoodsFragment lostGoodsFragment = (LostGoodsFragment) cn.bluemobi.dylan.base.utils.a.n().o(LostGoodsFragment.class);
                    if (lostGoodsFragment != null) {
                        lostGoodsFragment.g0();
                    }
                    LostDetailActivity.this.finish();
                    return;
                }
                LostDetailActivity.this.h0("\u5df2\u5173\u95ed");
                LostDetailActivity.this.y0();
            }
        }

        d(final rx.e val$observable) {
            this.f21413a = val$observable;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(((BaseActivity) LostDetailActivity.this).f1656h).setObservable(this.f21413a).setDataListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LostDetailActivity.this.f21400x.setVisibility(0);
            LostDetailActivity.this.A = data;
            LostDetailActivity.this.B0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ iOSTwoButtonDialog f21417a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21418b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnOtherStatus(int status, String msg) {
                super.netOnOtherStatus(status, msg);
                new iOSOneButtonDialog(((BaseActivity) LostDetailActivity.this).f1656h).setMessage(msg).show();
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                f.this.f21417a.dismiss();
                LostDetailActivity.this.h0("\u5df2\u63d0\u4ea4\u56de\u7b54\uff0c\u7b49\u5f85\u5bf9\u65b9\u5ba1\u6838");
                LostDetailActivity.this.y0();
            }
        }

        f(final iOSTwoButtonDialog val$iOSTwoButtonDialog, final String val$question) {
            this.f21417a = val$iOSTwoButtonDialog;
            this.f21418b = val$question;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            this.f21417a.show();
            String trim = ((EditText) this.f21417a.findViewById(2131231252)).getText().toString().trim();
            if (trim.isEmpty()) {
                LostDetailActivity.this.h0("\u7b54\u6848\u4e0d\u80fd\u4e3a\u7a7a");
            } else {
                Http.with(((BaseActivity) LostDetailActivity.this).f1656h).hideOtherStatusMessage().setObservable(((q.e) Http.getApiService(q.e.class)).f(LostDetailActivity.this.f21402z, LoginUser.getLoginUser().getOpenId(), this.f21418b, trim)).setDataListener(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class g extends HttpCallBack {
        g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) LostDetailActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LostDetailActivity.this.y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(final String validateAnswerId, String isRight) {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((q.e) Http.getApiService(q.e.class)).c(LoginUser.getLoginUser().getOpenId(), validateAnswerId, isRight)).setDataListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        this.f21387k.setText(JsonParse.getString(this.A, "publishTime"));
        this.f21388l.setText(JsonParse.getString(this.A, "goodsTypeName"));
        this.f21389m.setText(JsonParse.getString(this.A, "description"));
        List<String> list = JsonParse.getList(this.A, "img", String.class);
        this.B = list;
        this.C.c(list);
        MyGridView myGridView = this.f21390n;
        List<String> list2 = this.B;
        myGridView.setVisibility((list2 == null || list2.size() <= 0) ? 8 : 0);
        int i4 = JsonParse.getInt(this.A, "isValidate");
        this.G = JsonParse.getString(this.A, "myMotice");
        String string = JsonParse.getString(this.A, "validateCount");
        String string2 = JsonParse.getString(this.A, "afterTime");
        TextView textView = this.f21395s;
        textView.setText("*\u8f93\u5165\u7b54\u6848\u9519\u8bef\u8d85\u8fc7" + string + "\u6b21\uff0c\u9700\u8981" + string2 + "\u4ee5\u540e\u518d\u8bd5");
        if (this.G.equals("Y")) {
            if (i4 == 1) {
                this.f21397u.setVisibility(0);
                this.f21395s.setVisibility(0);
                this.f21397u.setText("\u56de\u7b54\u4e0e\u5931\u7269\u6709\u5173\u7684\u95ee\u9898\uff0c\u624d\u80fd\u67e5\u770b\u6211\u7684\u8054\u7cfb\u65b9\u5f0f");
                List<Map<String, Object>> list3 = JsonParse.getList(this.A, "question");
                this.f21401y = list3;
                this.F.g(list3);
            } else {
                this.f21397u.setVisibility(8);
                this.f21395s.setVisibility(8);
            }
            String string3 = JsonParse.getString(this.A, "status");
            this.f21399w.setVisibility(0);
            if ("0".equals(string3)) {
                this.f21399w.setEnabled(true);
                this.f21399w.setText("\u5220\u9664");
            } else if ("1".equals(string3)) {
                this.f21399w.setEnabled(true);
                this.f21399w.setText("\u5173\u95ed");
            } else if ("2".equals(string3)) {
                this.f21399w.setEnabled(false);
                this.f21399w.setText("\u5ba1\u6838\u4e0d\u901a\u8fc7");
            } else {
                this.f21399w.setEnabled(false);
                this.f21399w.setText("\u5df2\u5173\u95ed");
            }
        } else if (i4 == 1) {
            this.f21397u.setVisibility(0);
            this.f21395s.setVisibility(0);
            List<Map<String, Object>> list4 = JsonParse.getList(this.A, "question");
            this.f21401y = list4;
            this.F.g(list4);
        } else {
            this.f21397u.setVisibility(8);
            this.f21395s.setVisibility(8);
        }
        C0();
    }

    private void C0() {
        String string = JsonParse.getString(this.A, "phone");
        if (TextUtils.isEmpty(string)) {
            ((View) this.f21393q.getParent()).setVisibility(8);
        } else {
            ((View) this.f21393q.getParent()).setVisibility(0);
            this.f21393q.setText(string);
        }
        String string2 = JsonParse.getString(this.A, "wechat");
        if (TextUtils.isEmpty(string2)) {
            ((View) this.f21394r.getParent()).setVisibility(8);
        } else {
            ((View) this.f21394r.getParent()).setVisibility(0);
            this.f21394r.setText(string2);
        }
        String string3 = JsonParse.getString(this.A, "qq");
        if (TextUtils.isEmpty(string3)) {
            ((View) this.f21396t.getParent()).setVisibility(8);
            return;
        }
        ((View) this.f21396t.getParent()).setVisibility(0);
        this.f21396t.setText(string3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(String[] arr, int position) {
        Intent intent = new Intent(this.f1656h, ImagePagerActivity.class);
        intent.putExtra("image_urls", arr);
        intent.putExtra("image_index", position);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    private void x0() {
        rx.e<Response<ResponseBody>> b4;
        if (this.f21399w.getText().toString().trim().equals("\u5220\u9664")) {
            b4 = ((q.e) Http.getApiService(q.e.class)).a(this.f21402z, LoginUser.getLoginUser().getOpenId());
        } else {
            b4 = ((q.e) Http.getApiService(q.e.class)).b(this.f21402z, LoginUser.getLoginUser().getOpenId());
        }
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1656h);
        iostwobuttondialog.setMessage("\u786e\u5b9a\u8981" + this.f21399w.getText().toString().trim() + "\u5417\uff1f").setRightButtonOnClickListener(new d(b4)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        Http.with(this.f1656h).setObservable(((q.e) Http.getApiService(q.e.class)).h(this.f21402z, this.E)).setDataListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(final String question) {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1656h);
        iostwobuttondialog.setTitle("\u56de\u7b54\u95ee\u9898");
        iostwobuttondialog.setMessage(question).setCenterCustomView(2131427601).setRightButtonOnClickListener(new f(iostwobuttondialog, question)).show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21399w.setOnClickListener(this);
        this.f21390n.setOnItemClickListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427432;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (LoginUser.getLoginUser().isAuthorizationInLost()) {
            this.E = LoginUser.getLoginUser().getOpenId();
        }
        if (getIntent().hasExtra("noticeId")) {
            this.f21402z = getIntent().getStringExtra("noticeId");
        }
        if (getIntent().hasExtra("lostType")) {
            int intExtra = getIntent().getIntExtra("lostType", 1);
            this.D = intExtra;
            if (intExtra == 1) {
                setTitle("\u5bfb\u7269\u542f\u793a");
                this.f21397u.setVisibility(8);
                this.f21391o.setVisibility(0);
                this.f21398v.setVisibility(8);
                this.f21395s.setVisibility(8);
            } else {
                setTitle("\u5931\u7269\u62db\u9886");
                this.f21397u.setVisibility(0);
                this.f21398v.setVisibility(0);
                this.f21395s.setVisibility(0);
            }
        }
        a aVar = new a(this.f1656h, 2131427721, this.B);
        this.C = aVar;
        this.f21390n.setAdapter((ListAdapter) aVar);
        this.F = new b(this.f1656h, 2131427744, this.f21401y);
        this.f21398v.setLayoutManager(new LinearLayoutManager(this.f1656h));
        this.f21398v.setAdapter(this.F);
        this.f21398v.addItemDecoration(new DividerItemDecoration(this.f1656h, 1));
        y0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7269\u54c1\u8be6\u60c5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21387k = (TextView) findViewById(2131232926);
        this.f21388l = (TextView) findViewById(2131233211);
        this.f21389m = (TextView) findViewById(2131232938);
        this.f21390n = (MyGridView) findViewById(2131231335);
        this.f21391o = (LinearLayout) findViewById(2131232202);
        this.f21392p = (EditText) findViewById(2131231267);
        this.f21393q = (TextView) findViewById(2131233089);
        this.f21394r = (TextView) findViewById(2131233228);
        this.f21396t = (TextView) findViewById(2131233109);
        this.f21397u = (CheckBox) findViewById(2131231087);
        this.f21398v = (RecyclerView) findViewById(2131232553);
        this.f21399w = (Button) findViewById(2131230965);
        this.f21395s = (TextView) findViewById(2131233048);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131232527);
        this.f21400x = relativeLayout;
        relativeLayout.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != 2131230965) {
            return;
        }
        x0();
    }
}
