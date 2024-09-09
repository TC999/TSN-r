package com.bxkj.student.home.teaching.lesson;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.orhanobut.logger.j;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class OnLineLessonActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private String f21146k;

    /* renamed from: l  reason: collision with root package name */
    private String f21147l;

    /* renamed from: m  reason: collision with root package name */
    private Spinner f21148m;

    /* renamed from: n  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f21149n;

    /* renamed from: o  reason: collision with root package name */
    private SmartRefreshLayout f21150o;

    /* renamed from: p  reason: collision with root package name */
    private RecyclerView f21151p;

    /* renamed from: s  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21154s;

    /* renamed from: q  reason: collision with root package name */
    private List<Map<String, Object>> f21152q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private List<Map<String, Object>> f21153r = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    private int f21155t = 0;

    /* renamed from: u  reason: collision with root package name */
    protected int f21156u = 10;

    /* renamed from: v  reason: collision with root package name */
    protected int f21157v = 1;

    /* renamed from: w  reason: collision with root package name */
    protected int f21158w = 1;

    /* renamed from: x  reason: collision with root package name */
    String f21159x = null;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d */
        public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "name"));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f21162a;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$b$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            class C0245a extends HttpCallBack {
                C0245a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    iOSOneButtonDialog oneButtonText = new iOSOneButtonDialog(((CommonAdapter) b.this).f1707a).setTitle("\u6559\u5e08\u4ecb\u7ecd").setOneButtonText("\u77e5\u9053\u4e86");
                    TextView textView = (TextView) oneButtonText.findViewById(2131232751);
                    textView.setVisibility(0);
                    textView.setText(OnLineLessonActivity.this.r0(JsonParse.getString(data, "data")));
                    textView.setLinkTextColor(ContextCompat.getColor(((CommonAdapter) b.this).f1707a, 2131034189));
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    oneButtonText.show();
                    oneButtonText.setMessageGrivity(3);
                }
            }

            a(final Map val$stringObjectMap) {
                this.f21162a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                Http.with(((CommonAdapter) b.this).f1707a).setObservable(((w.a) Http.getApiService(w.a.class)).j0(JsonParse.getString(this.f21162a, "teacherId"))).setDataListener(new C0245a());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0246b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f21165a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewHolder f21166b;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$b$b$a */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            class a implements iOSTwoButtonDialog.RightButtonOnClick {
                a() {
                }

                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public void buttonRightOnClick() {
                    View$OnClickListenerC0246b view$OnClickListenerC0246b = View$OnClickListenerC0246b.this;
                    OnLineLessonActivity.this.q0(view$OnClickListenerC0246b.f21166b.f());
                }
            }

            View$OnClickListenerC0246b(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f21165a = val$stringObjectMap;
                this.f21166b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                StringBuilder sb = new StringBuilder();
                sb.append("\u786e\u5b9a\u8981\u9009\u62e9\u8be5" + LoginUser.getLoginUser().getXuanZeAfterLabelName() + "\u5417\uff1f");
                sb.append("\n");
                sb.append(JsonParse.getString(this.f21165a, "sysTermName"));
                sb.append("\n");
                sb.append(JsonParse.getString(this.f21165a, "sysOrgName"));
                sb.append("\n");
                sb.append(JsonParse.getString(this.f21165a, "sysCampusName"));
                sb.append("\n");
                sb.append(JsonParse.getString(this.f21165a, "teachingSchoolTimeName"));
                sb.append("\n");
                sb.append(JsonParse.getString(this.f21165a, "sysUserName"));
                sb.append("\n");
                sb.append(JsonParse.getString(this.f21165a, "teachingCurriculumName"));
                sb.append("\n");
                sb.append(JsonParse.getString(this.f21165a, "address"));
                new iOSTwoButtonDialog(((CommonAdapter) b.this).f1707a).setMessageGrivity(3).setMessage(sb.toString()).setRightButtonOnClickListener(new a()).show();
            }
        }

        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: q */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233028, JsonParse.getString(stringObjectMap, "manNum"));
            holder.J(2131233233, JsonParse.getString(stringObjectMap, "womanNum"));
            holder.J(2131232882, JsonParse.getString(stringObjectMap, "blendNum"));
            holder.J(2131233014, JsonParse.getString(stringObjectMap, "teachingCurriculumName"));
            holder.J(2131232927, JsonParse.getString(stringObjectMap, "sysTermName"));
            holder.J(2131233198, JsonParse.getString(stringObjectMap, "teachingSchoolTimeName"));
            holder.J(2131232981, JsonParse.getString(stringObjectMap, "sysOrgName"));
            holder.J(2131233211, JsonParse.getString(stringObjectMap, "type"));
            holder.J(2131233143, JsonParse.getString(stringObjectMap, "sysCampusName"));
            holder.J(2131233230, JsonParse.getString(stringObjectMap, "parameter"));
            holder.J(2131233211, JsonParse.getString(stringObjectMap, "type"));
            holder.J(2131232964, JsonParse.getString(stringObjectMap, "feature"));
            holder.J(2131232841, JsonParse.getString(stringObjectMap, "address"));
            holder.J(2131233191, JsonParse.getString(stringObjectMap, "sysUserName") + "(\u70b9\u51fb\u67e5\u770b)");
            String string = JsonParse.getString(stringObjectMap, "canshu");
            holder.w(2131233191, new a(stringObjectMap));
            Button button = (Button) holder.h(2131230989);
            if (string.equals("1")) {
                button.setEnabled(false);
                button.setText(LoginUser.getLoginUser().getXuanZeAfterLabelName() + "\u5df2\u6ee1");
            } else if (string.equals("2")) {
                button.setEnabled(false);
                button.setText("\u65f6\u95f4\u5df2\u8fc7");
            } else if (string.equals("3")) {
                button.setEnabled(false);
                button.setText("\u5df2\u9009\u62e9");
            } else {
                button.setEnabled(true);
                button.setText("\u9009\u62e9");
                button.setOnClickListener(new View$OnClickListenerC0246b(stringObjectMap, holder));
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
            super.netOnOtherStatus(status, msg);
            OnLineLessonActivity.this.f21150o.a0();
            new iOSOneButtonDialog(((BaseActivity) OnLineLessonActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            OnLineLessonActivity.this.f21150o.a0();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            OnLineLessonActivity.this.f21155t = position;
            OnLineLessonActivity.this.f21159x = String.valueOf(position);
            OnLineLessonActivity onLineLessonActivity = OnLineLessonActivity.this;
            onLineLessonActivity.f21157v = 1;
            onLineLessonActivity.s0(true);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e implements s0.e {
        e() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            OnLineLessonActivity onLineLessonActivity = OnLineLessonActivity.this;
            onLineLessonActivity.f21159x = null;
            onLineLessonActivity.f21157v = 1;
            onLineLessonActivity.s0(false);
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            OnLineLessonActivity onLineLessonActivity = OnLineLessonActivity.this;
            int i4 = onLineLessonActivity.f21158w / onLineLessonActivity.f21156u;
            if ("8".equals(LoginUser.getLoginUser().getSchoolId())) {
                OnLineLessonActivity onLineLessonActivity2 = OnLineLessonActivity.this;
                int i5 = onLineLessonActivity2.f21157v;
                if (onLineLessonActivity2.f21158w % onLineLessonActivity2.f21156u != 0) {
                    i4++;
                }
                if (i5 >= i4) {
                    if (onLineLessonActivity2.f21154s.d() != null && OnLineLessonActivity.this.f21154s.d().size() > 0) {
                        OnLineLessonActivity onLineLessonActivity3 = OnLineLessonActivity.this;
                        onLineLessonActivity3.f21159x = String.valueOf(JsonParse.getInt((Map) onLineLessonActivity3.f21154s.getItem(OnLineLessonActivity.this.f21154s.d().size() - 1), "parameter") + 1);
                    } else {
                        OnLineLessonActivity.this.f21159x = null;
                    }
                } else {
                    onLineLessonActivity2.f21159x = null;
                }
            } else {
                OnLineLessonActivity onLineLessonActivity4 = OnLineLessonActivity.this;
                int i6 = onLineLessonActivity4.f21157v;
                if (onLineLessonActivity4.f21158w % onLineLessonActivity4.f21156u != 0) {
                    i4++;
                }
                if (i6 >= i4) {
                    onLineLessonActivity4.f21150o.h();
                    OnLineLessonActivity.this.h0("\u6ca1\u6709\u4e86");
                    return;
                }
            }
            OnLineLessonActivity onLineLessonActivity5 = OnLineLessonActivity.this;
            onLineLessonActivity5.f21157v++;
            onLineLessonActivity5.s0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            OnLineLessonActivity.this.f21150o.y();
            OnLineLessonActivity.this.f21150o.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) OnLineLessonActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            OnLineLessonActivity.this.f21158w = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d4 = OnLineLessonActivity.this.f21154s.d();
            if (OnLineLessonActivity.this.f21157v == 1) {
                d4 = list;
            } else {
                d4.addAll(list);
            }
            if ("8".equals(LoginUser.getLoginUser().getSchoolId()) && list != null && list.size() > 0) {
                OnLineLessonActivity.this.f21148m.setSelection(JsonParse.getInt((Map) list.get(0), "parameter"));
            }
            OnLineLessonActivity.this.f21154s.g(d4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class g extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ URLSpan f21173a;

        g(final URLSpan val$urlSpan) {
            this.f21173a = val$urlSpan;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            j.g("URL-click:" + this.f21173a.getURL(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(final int positon) {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).f1(LoginUser.getLoginUser().getUserId(), JsonParse.getString(this.f21154s.getItem(positon), "id"))).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence r0(String html) {
        Spanned fromHtml = Html.fromHtml(html);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
        for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, fromHtml.length(), URLSpan.class)) {
            u0(spannableStringBuilder, uRLSpan);
        }
        return spannableStringBuilder;
    }

    private void u0(final SpannableStringBuilder clickableHtmlBuilder, final URLSpan urlSpan) {
        clickableHtmlBuilder.setSpan(new g(urlSpan), clickableHtmlBuilder.getSpanStart(urlSpan), clickableHtmlBuilder.getSpanEnd(urlSpan), clickableHtmlBuilder.getSpanFlags(urlSpan));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21148m.setOnItemSelectedListener(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427444;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("teachingId")) {
            this.f21146k = getIntent().getStringExtra("teachingId");
        }
        if (getIntent().hasExtra("timeId")) {
            this.f21147l = getIntent().getStringExtra("timeId");
        }
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "\u8bf7\u9009\u62e9");
        this.f21152q.add(arrayMap);
        for (int i4 = 1; i4 < 31; i4++) {
            ArrayMap arrayMap2 = new ArrayMap();
            arrayMap2.put("name", "\u7b2c" + i4 + "\u5468");
            this.f21152q.add(arrayMap2);
        }
        a aVar = new a(this.f1656h, 2131427755, this.f21152q);
        this.f21149n = aVar;
        this.f21148m.setAdapter((SpinnerAdapter) aVar);
        this.f21151p.setLayoutManager(new LinearLayoutManager(this.f1656h, 1, false));
        b bVar = new b(this.f1656h, 2131427715, this.f21153r);
        this.f21154s = bVar;
        this.f21151p.setAdapter(bVar);
        t0();
        this.f21150o.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5728\u7ebf\u9009" + LoginUser.getLoginUser().getXuanAfterLabelName());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21148m = (Spinner) findViewById(2131232642);
        this.f21150o = (SmartRefreshLayout) findViewById(2131232483);
        this.f21151p = (RecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    public void s0(boolean isShowLoading) {
        Http.with(this.f1656h).hideOtherStatusMessage().setShowLoadingDialog(isShowLoading).setObservable(((w.a) Http.getApiService(w.a.class)).g1(LoginUser.getLoginUser().getUserId(), this.f21147l, this.f21159x, this.f21146k, this.f21157v, this.f21156u)).setDataListener(new f());
    }

    public void t0() {
        if ("8".equals(LoginUser.getLoginUser().getSchoolId())) {
            this.f21148m.setVisibility(0);
            this.f21150o.O(false);
        } else {
            this.f21148m.setVisibility(8);
        }
        this.f21150o.n1(new e());
    }
}
