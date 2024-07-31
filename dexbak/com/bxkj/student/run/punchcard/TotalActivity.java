package com.bxkj.student.run.punchcard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
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
public class TotalActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f19817k;

    /* renamed from: l */
    private EmptyRecyclerView f19818l;

    /* renamed from: m */
    private TextView f19819m;

    /* renamed from: n */
    private TextView f19820n;

    /* renamed from: o */
    private List<Map<String, Object>> f19821o = new ArrayList();

    /* renamed from: p */
    private CommonAdapter<Map<String, Object>> f19822p;

    /* renamed from: com.bxkj.student.run.punchcard.TotalActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5445a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.run.punchcard.TotalActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC5446a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f19824a;

            View$OnClickListenerC5446a(final Map val$stringObjectMap) {
                this.f19824a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                TotalActivity.this.startActivity(new Intent(((CommonAdapter) C5445a.this).f1721a, RecorderListActivity.class).putExtra("termId", JsonParse.getString(this.f19824a, "sysTermId")));
            }
        }

        C5445a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131232981, JsonParse.getString(stringObjectMap, "sysTerm"));
            holder.m57874J(2131233146, JsonParse.getDouble(stringObjectMap, "score") + "分");
            holder.m57874J(2131233116, "合格次数：" + JsonParse.getString(stringObjectMap, "goodNum"));
            holder.m57847w(2131231055, new View$OnClickListenerC5446a(stringObjectMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.punchcard.TotalActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5447b extends HttpCallBack {
        C5447b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            new iOSOneButtonDialog(((BaseActivity) TotalActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TotalActivity.this.f19821o = (List) data.get("data");
            TotalActivity.this.f19822p.m57836g(TotalActivity.this.f19821o);
        }
    }

    /* renamed from: m0 */
    private void m39436m0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m156M0(LoginUser.getLoginUser().getUserId())).setDataListener(new C5447b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_punchcard_total;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        TextView textView = this.f19819m;
        textView.setText("姓名：" + LoginUser.getLoginUser().getRealName() + "\u3000学号：" + LoginUser.getLoginUser().getAccount());
        this.f19818l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f19818l.setLayoutAnimation(layoutAnimationController);
        C5445a c5445a = new C5445a(this.f1669h, C4215R.C4221layout.item_for_punchcard_score_list, this.f19821o);
        this.f19822p = c5445a;
        this.f19818l.setAdapter(c5445a);
        this.f19817k.mo2050b0(false);
        this.f19817k.mo2064P(false);
        this.f19817k.setOverScrollMode(2);
        this.f19818l.setEmptyView(findViewById(2131232952));
        m39436m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("刷脸记录");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19817k = (SmartRefreshLayout) findViewById(2131232482);
        this.f19818l = (EmptyRecyclerView) findViewById(2131232481);
        this.f19819m = (TextView) findViewById(2131233040);
        TextView textView = (TextView) findViewById(C4215R.C4219id.tv_notice);
        this.f19820n = textView;
        textView.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
