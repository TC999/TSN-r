package com.bxkj.equipment.history;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.equipment.R;
import com.bxkj.equipment.history.RecordListActivity;
import com.bxkj.equipment.i;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import r0.h;
import retrofit2.Response;
import s0.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RecordListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EmptyRecyclerView f19254k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f19255l;

    /* renamed from: m  reason: collision with root package name */
    private SmartRefreshLayout f19256m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f19257n;

    /* renamed from: o  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19258o;

    /* renamed from: p  reason: collision with root package name */
    private String f19259p;

    /* renamed from: q  reason: collision with root package name */
    private int f19260q = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f19261r = 1;

    /* renamed from: s  reason: collision with root package name */
    private int f19262s = 10;

    /* renamed from: t  reason: collision with root package name */
    private int f19263t = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.equipment.history.RecordListActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class C0211a extends HttpCallBack {
            C0211a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                RecordListActivity.this.f19256m.a0();
            }
        }

        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(final Map stringObjectMap, View v3) {
            new iOSTwoButtonDialog(this.f1707a).setMessage("\u786e\u5b9a\u8981\u53d6\u6d88\u5417\uff1f").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.equipment.history.b
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    RecordListActivity.a.this.q(stringObjectMap);
                }
            }).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(final Map stringObjectMap) {
            Http.with(this.f1707a).setObservable(((i) Http.getApiService(i.class)).f(LoginUser.getLoginUser().getUserId(), null, null, null, null, null, null, "6", JsonParse.getString(stringObjectMap, "id"))).setDataListener(new C0211a());
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            int i4 = R.id.tv_feild_name;
            holder.J(i4, "\u5668\u6750\u540d\u79f0\uff1a" + u.O(stringObjectMap, "equInfo"));
            int i5 = R.id.tv_day;
            holder.J(i5, "\u9884\u8ba1\u9886\u53d6\u65f6\u95f4\uff1a" + u.O(stringObjectMap, "forReceiveTime"));
            int i6 = R.id.tv_time;
            holder.J(i6, "\u9884\u8ba1\u5f52\u8fd8\u65f6\u95f4\uff1a" + u.O(stringObjectMap, "forBackTime"));
            int i7 = R.id.tv_receive_date;
            holder.N(i7, TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "receiveTime")) ^ true);
            holder.J(i7, "\u5b9e\u9645\u9886\u53d6\u65f6\u95f4\uff1a" + u.O(stringObjectMap, "receiveTime"));
            int i8 = R.id.tv_return_date;
            holder.N(i8, TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "backTime")) ^ true);
            holder.J(i8, "\u5b9e\u9645\u5f52\u8fd8\u65f6\u95f4\uff1a" + JsonParse.getString(stringObjectMap, "backTime"));
            int i9 = R.id.tv_type;
            holder.J(i9, "\u72b6\u6001:" + JsonParse.getString(stringObjectMap, "statusStr"));
            Button button = (Button) holder.h(R.id.bt_cancel);
            button.setEnabled(JsonParse.getString(stringObjectMap, "status").equals("0"));
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.history.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecordListActivity.a.this.p(stringObjectMap, view);
                }
            });
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements e {
        b() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            RecordListActivity.this.f19261r = 1;
            RecordListActivity.this.t0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = RecordListActivity.this.f19263t / RecordListActivity.this.f19262s;
            int i5 = RecordListActivity.this.f19261r;
            if (RecordListActivity.this.f19263t % RecordListActivity.this.f19262s != 0) {
                i4++;
            }
            if (i5 >= i4) {
                RecordListActivity.this.f19256m.h();
                RecordListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            RecordListActivity.o0(RecordListActivity.this);
            RecordListActivity.this.t0();
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
        public void netOnFinish() {
            super.netOnFinish();
            RecordListActivity.this.f19256m.y();
            RecordListActivity.this.f19256m.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RecordListActivity.this.f19263t = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (RecordListActivity.this.f19261r == 1) {
                RecordListActivity.this.f19257n = list;
            } else {
                RecordListActivity.this.f19257n.addAll(list);
            }
            RecordListActivity.this.f19258o.g(RecordListActivity.this.f19257n);
        }
    }

    static /* synthetic */ int o0(RecordListActivity recordListActivity) {
        int i4 = recordListActivity.f19261r;
        recordListActivity.f19261r = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        rx.e<Response<ResponseBody>> e4 = ((i) Http.getApiService(i.class)).e(LoginUser.getLoginUser().getUserId(), this.f19261r, this.f19262s);
        if (LoginUser.getLoginUser().getUserType() == 2) {
            e4 = ((i) Http.getApiService(i.class)).a(this.f19259p, this.f19260q, this.f19261r, this.f19262s);
        }
        Http.with(this.f1656h).hideLoadingDialog().setObservable(e4).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.pub_recyclerview_with_empty_view;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("teacherCurriculumId")) {
            this.f19259p = getIntent().getStringExtra("teacherCurriculumId");
        }
        if (getIntent().hasExtra("week")) {
            this.f19260q = getIntent().getIntExtra("week", 0);
        }
        this.f19254k.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f19254k.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, R.layout.item_for_record_list, this.f19257n);
        this.f19258o = aVar;
        this.f19254k.setAdapter(aVar);
        this.f19254k.setEmptyView(this.f19255l);
        this.f19256m.n1(new b());
        this.f19256m.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u7684\u5668\u6750\u7533\u8bf7\u8bb0\u5f55");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19254k = (EmptyRecyclerView) findViewById(R.id.recyclerView);
        this.f19256m = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.f19255l = (TextView) findViewById(R.id.tv_emptyView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
