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
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.orhanobut.logger.C11792j;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class OnLineLessonActivity extends BaseActivity {

    /* renamed from: k */
    private String f17808k;

    /* renamed from: l */
    private String f17809l;

    /* renamed from: m */
    private Spinner f17810m;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f17811n;

    /* renamed from: o */
    private SmartRefreshLayout f17812o;

    /* renamed from: p */
    private RecyclerView f17813p;

    /* renamed from: s */
    private cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter<Map<String, Object>> f17816s;

    /* renamed from: q */
    private List<Map<String, Object>> f17814q = new ArrayList();

    /* renamed from: r */
    private List<Map<String, Object>> f17815r = new ArrayList();

    /* renamed from: t */
    private int f17817t = 0;

    /* renamed from: u */
    protected int f17818u = 10;

    /* renamed from: v */
    protected int f17819v = 1;

    /* renamed from: w */
    protected int f17820w = 1;

    /* renamed from: x */
    String f17821x = null;

    /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4796a extends CommonAdapter<Map<String, Object>> {
        C4796a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4797b extends cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4798a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f17824a;

            /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$b$a$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            class C4799a extends HttpCallBack {
                C4799a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    iOSOneButtonDialog oneButtonText = new iOSOneButtonDialog(((cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter) C4797b.this).f1721a).setTitle("教师介绍").setOneButtonText("知道了");
                    TextView textView = (TextView) oneButtonText.findViewById(2131232751);
                    textView.setVisibility(0);
                    textView.setText(OnLineLessonActivity.this.m41308r0(JsonParse.getString(data, "data")));
                    textView.setLinkTextColor(ContextCompat.getColor(((cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter) C4797b.this).f1721a, 2131034189));
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    oneButtonText.show();
                    oneButtonText.setMessageGrivity(3);
                }
            }

            View$OnClickListenerC4798a(final Map val$stringObjectMap) {
                this.f17824a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Http.with(((cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter) C4797b.this).f1721a).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m101j0(JsonParse.getString(this.f17824a, "teacherId"))).setDataListener(new C4799a());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$b$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4800b implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f17827a;

            /* renamed from: b */
            final /* synthetic */ ViewHolder f17828b;

            /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$b$b$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            class C4801a implements iOSTwoButtonDialog.RightButtonOnClick {
                C4801a() {
                }

                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public void buttonRightOnClick() {
                    View$OnClickListenerC4800b view$OnClickListenerC4800b = View$OnClickListenerC4800b.this;
                    OnLineLessonActivity.this.m41309q0(view$OnClickListenerC4800b.f17828b.m57864f());
                }
            }

            View$OnClickListenerC4800b(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f17827a = val$stringObjectMap;
                this.f17828b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                sb.append("确定要选择该" + LoginUser.getLoginUser().getXuanZeAfterLabelName() + "吗？");
                sb.append(ShellAdbUtils.f33810d);
                sb.append(JsonParse.getString(this.f17827a, "sysTermName"));
                sb.append(ShellAdbUtils.f33810d);
                sb.append(JsonParse.getString(this.f17827a, "sysOrgName"));
                sb.append(ShellAdbUtils.f33810d);
                sb.append(JsonParse.getString(this.f17827a, "sysCampusName"));
                sb.append(ShellAdbUtils.f33810d);
                sb.append(JsonParse.getString(this.f17827a, "teachingSchoolTimeName"));
                sb.append(ShellAdbUtils.f33810d);
                sb.append(JsonParse.getString(this.f17827a, "sysUserName"));
                sb.append(ShellAdbUtils.f33810d);
                sb.append(JsonParse.getString(this.f17827a, "teachingCurriculumName"));
                sb.append(ShellAdbUtils.f33810d);
                sb.append(JsonParse.getString(this.f17827a, "address"));
                new iOSTwoButtonDialog(((cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter) C4797b.this).f1721a).setMessageGrivity(3).setMessage(sb.toString()).setRightButtonOnClickListener(new C4801a()).show();
            }
        }

        C4797b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: q */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv_man, JsonParse.getString(stringObjectMap, "manNum"));
            holder.m57874J(C4215R.C4219id.tv_women, JsonParse.getString(stringObjectMap, "womanNum"));
            holder.m57874J(C4215R.C4219id.tv_blend, JsonParse.getString(stringObjectMap, "blendNum"));
            holder.m57874J(C4215R.C4219id.tv_lesson_name, JsonParse.getString(stringObjectMap, "teachingCurriculumName"));
            holder.m57874J(2131232927, JsonParse.getString(stringObjectMap, "sysTermName"));
            holder.m57874J(2131233198, JsonParse.getString(stringObjectMap, "teachingSchoolTimeName"));
            holder.m57874J(2131232981, JsonParse.getString(stringObjectMap, "sysOrgName"));
            holder.m57874J(2131233211, JsonParse.getString(stringObjectMap, "type"));
            holder.m57874J(C4215R.C4219id.tv_school_area, JsonParse.getString(stringObjectMap, "sysCampusName"));
            holder.m57874J(C4215R.C4219id.tv_week, JsonParse.getString(stringObjectMap, "parameter"));
            holder.m57874J(2131233211, JsonParse.getString(stringObjectMap, "type"));
            holder.m57874J(C4215R.C4219id.tv_feature, JsonParse.getString(stringObjectMap, "feature"));
            holder.m57874J(2131232841, JsonParse.getString(stringObjectMap, "address"));
            holder.m57874J(C4215R.C4219id.tv_teacher, JsonParse.getString(stringObjectMap, "sysUserName") + "(点击查看)");
            String string = JsonParse.getString(stringObjectMap, "canshu");
            holder.m57847w(C4215R.C4219id.tv_teacher, new View$OnClickListenerC4798a(stringObjectMap));
            Button button = (Button) holder.m57862h(2131230989);
            if (string.equals("1")) {
                button.setEnabled(false);
                button.setText(LoginUser.getLoginUser().getXuanZeAfterLabelName() + "已满");
            } else if (string.equals("2")) {
                button.setEnabled(false);
                button.setText("时间已过");
            } else if (string.equals("3")) {
                button.setEnabled(false);
                button.setText("已选择");
            } else {
                button.setEnabled(true);
                button.setText("选择");
                button.setOnClickListener(new View$OnClickListenerC4800b(stringObjectMap, holder));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4802c extends HttpCallBack {
        C4802c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            OnLineLessonActivity.this.f17812o.mo2052a0();
            new iOSOneButtonDialog(((BaseActivity) OnLineLessonActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            OnLineLessonActivity.this.f17812o.mo2052a0();
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4803d implements AdapterView.OnItemSelectedListener {
        C4803d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            OnLineLessonActivity.this.f17817t = position;
            OnLineLessonActivity.this.f17821x = String.valueOf(position);
            OnLineLessonActivity onLineLessonActivity = OnLineLessonActivity.this;
            onLineLessonActivity.f17819v = 1;
            onLineLessonActivity.m41307s0(true);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4804e implements OnRefreshLoadmoreListener {
        C4804e() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            OnLineLessonActivity onLineLessonActivity = OnLineLessonActivity.this;
            onLineLessonActivity.f17821x = null;
            onLineLessonActivity.f17819v = 1;
            onLineLessonActivity.m41307s0(false);
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            OnLineLessonActivity onLineLessonActivity = OnLineLessonActivity.this;
            int i = onLineLessonActivity.f17820w / onLineLessonActivity.f17818u;
            if (Constants.VIA_SHARE_TYPE_PUBLISHVIDEO.equals(LoginUser.getLoginUser().getSchoolId())) {
                OnLineLessonActivity onLineLessonActivity2 = OnLineLessonActivity.this;
                int i2 = onLineLessonActivity2.f17819v;
                if (onLineLessonActivity2.f17820w % onLineLessonActivity2.f17818u != 0) {
                    i++;
                }
                if (i2 >= i) {
                    if (onLineLessonActivity2.f17816s.m57837d() != null && OnLineLessonActivity.this.f17816s.m57837d().size() > 0) {
                        OnLineLessonActivity onLineLessonActivity3 = OnLineLessonActivity.this;
                        onLineLessonActivity3.f17821x = String.valueOf(JsonParse.getInt((Map) onLineLessonActivity3.f17816s.getItem(OnLineLessonActivity.this.f17816s.m57837d().size() - 1), "parameter") + 1);
                    } else {
                        OnLineLessonActivity.this.f17821x = null;
                    }
                } else {
                    onLineLessonActivity2.f17821x = null;
                }
            } else {
                OnLineLessonActivity onLineLessonActivity4 = OnLineLessonActivity.this;
                int i3 = onLineLessonActivity4.f17819v;
                if (onLineLessonActivity4.f17820w % onLineLessonActivity4.f17818u != 0) {
                    i++;
                }
                if (i3 >= i) {
                    onLineLessonActivity4.f17812o.mo2041g();
                    OnLineLessonActivity.this.m57919h0("没有了");
                    return;
                }
            }
            OnLineLessonActivity onLineLessonActivity5 = OnLineLessonActivity.this;
            onLineLessonActivity5.f17819v++;
            onLineLessonActivity5.m41307s0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4805f extends HttpCallBack {
        C4805f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            OnLineLessonActivity.this.f17812o.mo2078B();
            OnLineLessonActivity.this.f17812o.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) OnLineLessonActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            OnLineLessonActivity.this.f17820w = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            List m57837d = OnLineLessonActivity.this.f17816s.m57837d();
            if (OnLineLessonActivity.this.f17819v == 1) {
                m57837d = list;
            } else {
                m57837d.addAll(list);
            }
            if (Constants.VIA_SHARE_TYPE_PUBLISHVIDEO.equals(LoginUser.getLoginUser().getSchoolId()) && list != null && list.size() > 0) {
                OnLineLessonActivity.this.f17810m.setSelection(JsonParse.getInt((Map) list.get(0), "parameter"));
            }
            OnLineLessonActivity.this.f17816s.m57836g(m57837d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4806g extends ClickableSpan {

        /* renamed from: a */
        final /* synthetic */ URLSpan f17835a;

        C4806g(final URLSpan val$urlSpan) {
            this.f17835a = val$urlSpan;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            C11792j.m20466g("URL-click:" + this.f17835a.getURL(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public void m41309q0(final int positon) {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m112f1(LoginUser.getLoginUser().getUserId(), JsonParse.getString(this.f17816s.getItem(positon), "id"))).setDataListener(new C4802c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public CharSequence m41308r0(String html) {
        Spanned fromHtml = Html.fromHtml(html);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
        for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, fromHtml.length(), URLSpan.class)) {
            m41305u0(spannableStringBuilder, uRLSpan);
        }
        return spannableStringBuilder;
    }

    /* renamed from: u0 */
    private void m41305u0(final SpannableStringBuilder clickableHtmlBuilder, final URLSpan urlSpan) {
        clickableHtmlBuilder.setSpan(new C4806g(urlSpan), clickableHtmlBuilder.getSpanStart(urlSpan), clickableHtmlBuilder.getSpanEnd(urlSpan), clickableHtmlBuilder.getSpanFlags(urlSpan));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17810m.setOnItemSelectedListener(new C4803d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_online_lesson;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("teachingId")) {
            this.f17808k = getIntent().getStringExtra("teachingId");
        }
        if (getIntent().hasExtra("timeId")) {
            this.f17809l = getIntent().getStringExtra("timeId");
        }
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "请选择");
        this.f17814q.add(arrayMap);
        for (int i = 1; i < 31; i++) {
            ArrayMap arrayMap2 = new ArrayMap();
            arrayMap2.put("name", "第" + i + "周");
            this.f17814q.add(arrayMap2);
        }
        C4796a c4796a = new C4796a(this.f1669h, 2131427755, this.f17814q);
        this.f17811n = c4796a;
        this.f17810m.setAdapter((SpinnerAdapter) c4796a);
        this.f17813p.setLayoutManager(new LinearLayoutManager(this.f1669h, 1, false));
        C4797b c4797b = new C4797b(this.f1669h, C4215R.C4221layout.item_for_lesson_list, this.f17815r);
        this.f17816s = c4797b;
        this.f17813p.setAdapter(c4797b);
        m41306t0();
        this.f17812o.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("在线选" + LoginUser.getLoginUser().getXuanAfterLabelName());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17810m = (Spinner) findViewById(2131232642);
        this.f17812o = (SmartRefreshLayout) findViewById(2131232483);
        this.f17813p = (RecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* renamed from: s0 */
    public void m41307s0(boolean isShowLoading) {
        Http.with(this.f1669h).hideOtherStatusMessage().setShowLoadingDialog(isShowLoading).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m109g1(LoginUser.getLoginUser().getUserId(), this.f17809l, this.f17821x, this.f17808k, this.f17819v, this.f17818u)).setDataListener(new C4805f());
    }

    /* renamed from: t0 */
    public void m41306t0() {
        if (Constants.VIA_SHARE_TYPE_PUBLISHVIDEO.equals(LoginUser.getLoginUser().getSchoolId())) {
            this.f17810m.setVisibility(0);
            this.f17812o.mo2064P(false);
        } else {
            this.f17810m.setVisibility(8);
        }
        this.f17812o.mo2019v(new C4804e());
    }
}
