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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TotalActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f23047k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f23048l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f23049m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f23050n;

    /* renamed from: o  reason: collision with root package name */
    private List<Map<String, Object>> f23051o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f23052p;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.run.punchcard.TotalActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0285a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f23054a;

            View$OnClickListenerC0285a(final Map val$stringObjectMap) {
                this.f23054a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                TotalActivity.this.startActivity(new Intent(((CommonAdapter) a.this).f1707a, RecorderListActivity.class).putExtra("termId", JsonParse.getString(this.f23054a, "sysTermId")));
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131232981, JsonParse.getString(stringObjectMap, "sysTerm"));
            holder.J(2131233146, JsonParse.getDouble(stringObjectMap, "score") + "\u5206");
            holder.J(2131233116, "\u5408\u683c\u6b21\u6570\uff1a" + JsonParse.getString(stringObjectMap, "goodNum"));
            holder.w(2131231055, new View$OnClickListenerC0285a(stringObjectMap));
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

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            new iOSOneButtonDialog(((BaseActivity) TotalActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TotalActivity.this.f23051o = (List) data.get("data");
            TotalActivity.this.f23052p.g(TotalActivity.this.f23051o);
        }
    }

    private void m0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).M0(LoginUser.getLoginUser().getUserId())).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427464;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        TextView textView = this.f23049m;
        textView.setText("\u59d3\u540d\uff1a" + LoginUser.getLoginUser().getRealName() + "\u3000\u5b66\u53f7\uff1a" + LoginUser.getLoginUser().getAccount());
        this.f23048l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f23048l.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, 2131427742, this.f23051o);
        this.f23052p = aVar;
        this.f23048l.setAdapter(aVar);
        this.f23047k.b0(false);
        this.f23047k.O(false);
        this.f23047k.setOverScrollMode(2);
        this.f23048l.setEmptyView(findViewById(2131232952));
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5237\u8138\u8bb0\u5f55");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f23047k = (SmartRefreshLayout) findViewById(2131232482);
        this.f23048l = (EmptyRecyclerView) findViewById(2131232481);
        this.f23049m = (TextView) findViewById(2131233040);
        TextView textView = (TextView) findViewById(2131233048);
        this.f23050n = textView;
        textView.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
