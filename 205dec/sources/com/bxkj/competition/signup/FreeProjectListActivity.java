package com.bxkj.competition.signup;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class FreeProjectListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f19169k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f19170l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f19171m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f19172n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private int f19173o = 1;

    /* renamed from: p  reason: collision with root package name */
    private int f19174p = 0;

    /* renamed from: q  reason: collision with root package name */
    private int f19175q = 10;

    /* renamed from: r  reason: collision with root package name */
    private MultiItemCommonAdapter<Map<String, Object>> f19176r;

    /* renamed from: s  reason: collision with root package name */
    private String f19177s;

    /* renamed from: t  reason: collision with root package name */
    private StickyDecoration f19178t;

    /* renamed from: u  reason: collision with root package name */
    private String f19179u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements s0.e {
        a() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            FreeProjectListActivity.this.f19174p = 1;
            FreeProjectListActivity.this.D0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = FreeProjectListActivity.this.f19173o / FreeProjectListActivity.this.f19175q;
            int i5 = FreeProjectListActivity.this.f19174p;
            if (FreeProjectListActivity.this.f19173o % FreeProjectListActivity.this.f19175q != 0) {
                i4++;
            }
            if (i5 >= i4) {
                FreeProjectListActivity.this.f19169k.h();
                FreeProjectListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            FreeProjectListActivity.w0(FreeProjectListActivity.this);
            FreeProjectListActivity.this.D0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.a<Map<String, Object>> {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int b(int itemType) {
            return R.layout.item_for_competition_project_list_free;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        /* renamed from: c */
        public int a(int position, Map<String, Object> stringObjectMap) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends MultiItemCommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f19183a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewHolder f19184b;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* renamed from: com.bxkj.competition.signup.FreeProjectListActivity$c$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            class C0210a implements iOSTwoButtonDialog.RightButtonOnClick {
                C0210a() {
                }

                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public void buttonRightOnClick() {
                    a aVar = a.this;
                    c cVar = c.this;
                    FreeProjectListActivity.this.C0(cVar.e(aVar.f19184b));
                }
            }

            a(final int val$holder, final ViewHolder val$operation) {
                this.f19183a = val$holder;
                this.f19184b = val$operation;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                if (this.f19183a == 0) {
                    c cVar = c.this;
                    FreeProjectListActivity.this.B0(cVar.e(this.f19184b));
                    return;
                }
                new iOSTwoButtonDialog(((CommonAdapter) c.this).f1707a).setMessage("\u786e\u5b9a\u8981\u53d6\u6d88\u62a5\u540d\u5417\uff1f").setRightButtonOnClickListener(new C0210a()).show();
            }
        }

        c(Context x02, List x12, cn.bluemobi.dylan.base.adapter.common.recyclerview.a x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: p */
        public void c(final ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, "itemName"));
            int i4 = JsonParse.getInt(stringObjectMap, "operation");
            int i5 = R.id.bt_ok;
            Button button = (Button) holder.h(i5);
            if (i4 == 0) {
                button.setBackground(AppCompatResources.getDrawable(this.f1707a, R.drawable.button_bg));
                button.setEnabled(true);
                holder.J(i5, "\u62a5\u540d");
            } else if (i4 == 1) {
                button.setEnabled(true);
                button.setBackground(AppCompatResources.getDrawable(this.f1707a, R.drawable.button_red));
                button.setBackgroundColor(FreeProjectListActivity.this.getResources().getColor(R.color.color_red));
                holder.J(i5, "\u53d6\u6d88\u62a5\u540d");
            } else if (i4 == 2) {
                button.setBackground(AppCompatResources.getDrawable(this.f1707a, R.drawable.button_bg));
                button.setEnabled(false);
                holder.J(i5, "\u9a73\u56de");
            } else if (i4 == 3) {
                button.setBackground(AppCompatResources.getDrawable(this.f1707a, R.drawable.button_bg));
                button.setEnabled(false);
                holder.J(i5, "\u9662\u7cfb\u901a\u8fc7");
            } else if (i4 == 4) {
                button.setBackground(AppCompatResources.getDrawable(this.f1707a, R.drawable.button_bg));
                button.setEnabled(false);
                holder.J(i5, "\u4f53\u80b2\u90e8\u5ba1\u6838");
            } else if (i4 == 5) {
                button.setBackground(AppCompatResources.getDrawable(this.f1707a, R.drawable.button_bg));
                button.setEnabled(false);
                holder.J(i5, "\u4f53\u80b2\u90e8\u901a\u8fc7");
            } else {
                button.setBackground(AppCompatResources.getDrawable(this.f1707a, R.drawable.button_bg));
                button.setEnabled(false);
                holder.J(i5, JsonParse.getString(stringObjectMap, "status"));
            }
            holder.w(i5, new a(i4, holder));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19187a;

        d(final int val$position) {
            this.f19187a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FreeProjectListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ((Map) FreeProjectListActivity.this.f19176r.getItem(this.f19187a)).put("operation", 1);
            ((Map) FreeProjectListActivity.this.f19176r.getItem(this.f19187a)).put("status", "\u5f85\u5ba1\u6838");
            FreeProjectListActivity.this.f19176r.notifyItemChanged(this.f19187a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19189a;

        e(final int val$position) {
            this.f19189a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FreeProjectListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (!TextUtils.isEmpty(FreeProjectListActivity.this.f19179u)) {
                FreeProjectListActivity.this.f19176r.d().remove(this.f19189a);
                FreeProjectListActivity.this.f19176r.notifyItemRemoved(this.f19189a);
                return;
            }
            ((Map) FreeProjectListActivity.this.f19176r.getItem(this.f19189a)).put("operation", 0);
            ((Map) FreeProjectListActivity.this.f19176r.getItem(this.f19189a)).put("status", "\u672a\u62a5\u540d");
            FreeProjectListActivity.this.f19176r.notifyItemChanged(this.f19189a);
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
            FreeProjectListActivity.this.f19169k.y();
            FreeProjectListActivity.this.f19169k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FreeProjectListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            FreeProjectListActivity.this.f19173o = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("itemDetail");
            if (FreeProjectListActivity.this.f19174p == 1) {
                FreeProjectListActivity.this.f19172n = list;
            } else {
                FreeProjectListActivity.this.f19172n.addAll(list);
            }
            FreeProjectListActivity.this.f19176r.g(FreeProjectListActivity.this.f19172n);
            try {
                FreeProjectListActivity.this.f19170l.removeItemDecoration(FreeProjectListActivity.this.f19178t);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            FreeProjectListActivity.this.f19170l.addItemDecoration(FreeProjectListActivity.this.f19178t);
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
        public void netOnFinish() {
            super.netOnFinish();
            FreeProjectListActivity.this.f19169k.y();
            FreeProjectListActivity.this.f19169k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            FreeProjectListActivity.this.f19173o = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (FreeProjectListActivity.this.f19174p == 1) {
                FreeProjectListActivity.this.f19172n = list;
            } else {
                FreeProjectListActivity.this.f19172n.addAll(list);
            }
            FreeProjectListActivity.this.f19176r.g(FreeProjectListActivity.this.f19172n);
            try {
                FreeProjectListActivity.this.f19170l.removeItemDecoration(FreeProjectListActivity.this.f19178t);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            FreeProjectListActivity.this.f19170l.addItemDecoration(FreeProjectListActivity.this.f19178t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(final int position) {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).h(JsonParse.getString(this.f19176r.getItem(position), "id"), LoginUser.getLoginUser().getUserId())).setDataListener(new d(position));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(final int position) {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).c(JsonParse.getString(this.f19176r.getItem(position), "id"), LoginUser.getLoginUser().getUserId())).setDataListener(new e(position));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).b(this.f19177s, LoginUser.getLoginUser().getUserId())).setDataListener(new f());
    }

    private void E0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).e(this.f19177s, LoginUser.getLoginUser().getUserId())).setDataListener(new g());
    }

    private void F0() {
        b bVar = new b();
        this.f19170l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f19170l.setLayoutAnimation(layoutAnimationController);
        c cVar = new c(this.f1656h, this.f19172n, bVar);
        this.f19176r = cVar;
        this.f19170l.setAdapter(cVar);
        this.f19170l.setEmptyView(findViewById(R.id.tv_emptyView));
        this.f19178t = new StickyDecoration(this.f1656h, this.f19172n);
    }

    private void G0() {
        this.f19169k.n1(new a());
    }

    static /* synthetic */ int w0(FreeProjectListActivity freeProjectListActivity) {
        int i4 = freeProjectListActivity.f19174p;
        freeProjectListActivity.f19174p = i4 + 1;
        return i4;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19171m.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_competition_project_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f19177s = getIntent().getStringExtra("competitionId");
        }
        if (getIntent().hasExtra("from")) {
            this.f19179u = getIntent().getStringExtra("from");
        }
        G0();
        F0();
        this.f19169k.b0(false);
        this.f19169k.O(false);
        if (!TextUtils.isEmpty(this.f19179u)) {
            setTitle("\u6211\u62a5\u540d\u7684\u7ade\u8d5b\u9879\u76ee");
            E0();
            return;
        }
        D0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7ade\u8d5b\u62a5\u540d\u9879\u76ee\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19169k = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.f19170l = (EmptyRecyclerView) findViewById(R.id.recyclerView);
        this.f19171m = (TextView) findViewById(R.id.tv_ok);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
