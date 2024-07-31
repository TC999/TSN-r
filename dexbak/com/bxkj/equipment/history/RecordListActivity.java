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
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.equipment.C4133R;
import com.bxkj.equipment.EquipmentApiService;
import com.bxkj.equipment.history.RecordListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import p638r0.RefreshLayout;
import p640rx.Observable;
import p642s0.OnRefreshLoadmoreListener;
import retrofit2.Response;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RecordListActivity extends BaseActivity {

    /* renamed from: k */
    private EmptyRecyclerView f15747k;

    /* renamed from: l */
    private TextView f15748l;

    /* renamed from: m */
    private SmartRefreshLayout f15749m;

    /* renamed from: n */
    private List<Map<String, Object>> f15750n;

    /* renamed from: o */
    private CommonAdapter<Map<String, Object>> f15751o;

    /* renamed from: p */
    private String f15752p;

    /* renamed from: q */
    private int f15753q = 0;

    /* renamed from: r */
    private int f15754r = 1;

    /* renamed from: s */
    private int f15755s = 10;

    /* renamed from: t */
    private int f15756t = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.equipment.history.RecordListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4152a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.equipment.history.RecordListActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C4153a extends HttpCallBack {
            C4153a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                RecordListActivity.this.f15749m.mo2052a0();
            }
        }

        C4152a(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: p */
        public /* synthetic */ void m43102p(final Map stringObjectMap, View v) {
            new iOSTwoButtonDialog(this.f1721a).setMessage("确定要取消吗？").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.equipment.history.b
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    RecordListActivity.C4152a.this.m43101q(stringObjectMap);
                }
            }).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: q */
        public /* synthetic */ void m43101q(final Map stringObjectMap) {
            Http.with(this.f1721a).setObservable(((EquipmentApiService) Http.getApiService(EquipmentApiService.class)).m43095f(LoginUser.getLoginUser().getUserId(), null, null, null, null, null, null, "6", JsonParse.getString(stringObjectMap, "id"))).setDataListener(new C4153a());
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            int i = C4133R.C4137id.tv_feild_name;
            holder.m57874J(i, "器材名称：" + Tools.m57632O(stringObjectMap, "equInfo"));
            int i2 = C4133R.C4137id.tv_day;
            holder.m57874J(i2, "预计领取时间：" + Tools.m57632O(stringObjectMap, "forReceiveTime"));
            int i3 = C4133R.C4137id.tv_time;
            holder.m57874J(i3, "预计归还时间：" + Tools.m57632O(stringObjectMap, "forBackTime"));
            int i4 = C4133R.C4137id.tv_receive_date;
            holder.m57870N(i4, TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "receiveTime")) ^ true);
            holder.m57874J(i4, "实际领取时间：" + Tools.m57632O(stringObjectMap, "receiveTime"));
            int i5 = C4133R.C4137id.tv_return_date;
            holder.m57870N(i5, TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "backTime")) ^ true);
            holder.m57874J(i5, "实际归还时间：" + JsonParse.getString(stringObjectMap, "backTime"));
            int i6 = C4133R.C4137id.tv_type;
            holder.m57874J(i6, "状态:" + JsonParse.getString(stringObjectMap, "statusStr"));
            Button button = (Button) holder.m57862h(C4133R.C4137id.bt_cancel);
            button.setEnabled(JsonParse.getString(stringObjectMap, "status").equals("0"));
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.history.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecordListActivity.C4152a.this.m43102p(stringObjectMap, view);
                }
            });
        }
    }

    /* renamed from: com.bxkj.equipment.history.RecordListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4154b implements OnRefreshLoadmoreListener {
        C4154b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            RecordListActivity.this.f15754r = 1;
            RecordListActivity.this.m43106t0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = RecordListActivity.this.f15756t / RecordListActivity.this.f15755s;
            int i2 = RecordListActivity.this.f15754r;
            if (RecordListActivity.this.f15756t % RecordListActivity.this.f15755s != 0) {
                i++;
            }
            if (i2 >= i) {
                RecordListActivity.this.f15749m.mo2041g();
                RecordListActivity.this.m57919h0("没有了");
                return;
            }
            RecordListActivity.m43111o0(RecordListActivity.this);
            RecordListActivity.this.m43106t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.equipment.history.RecordListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4155c extends HttpCallBack {
        C4155c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            RecordListActivity.this.f15749m.mo2078B();
            RecordListActivity.this.f15749m.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RecordListActivity.this.f15756t = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            if (RecordListActivity.this.f15754r == 1) {
                RecordListActivity.this.f15750n = list;
            } else {
                RecordListActivity.this.f15750n.addAll(list);
            }
            RecordListActivity.this.f15751o.m57836g(RecordListActivity.this.f15750n);
        }
    }

    /* renamed from: o0 */
    static /* synthetic */ int m43111o0(RecordListActivity recordListActivity) {
        int i = recordListActivity.f15754r;
        recordListActivity.f15754r = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public void m43106t0() {
        Observable<Response<ResponseBody>> m43096e = ((EquipmentApiService) Http.getApiService(EquipmentApiService.class)).m43096e(LoginUser.getLoginUser().getUserId(), this.f15754r, this.f15755s);
        if (LoginUser.getLoginUser().getUserType() == 2) {
            m43096e = ((EquipmentApiService) Http.getApiService(EquipmentApiService.class)).m43100a(this.f15752p, this.f15753q, this.f15754r, this.f15755s);
        }
        Http.with(this.f1669h).hideLoadingDialog().setObservable(m43096e).setDataListener(new C4155c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4133R.C4139layout.pub_recyclerview_with_empty_view;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("teacherCurriculumId")) {
            this.f15752p = getIntent().getStringExtra("teacherCurriculumId");
        }
        if (getIntent().hasExtra("week")) {
            this.f15753q = getIntent().getIntExtra("week", 0);
        }
        this.f15747k.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, C4133R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f15747k.setLayoutAnimation(layoutAnimationController);
        C4152a c4152a = new C4152a(this.f1669h, C4133R.C4139layout.item_for_record_list, this.f15750n);
        this.f15751o = c4152a;
        this.f15747k.setAdapter(c4152a);
        this.f15747k.setEmptyView(this.f15748l);
        this.f15749m.mo2019v(new C4154b());
        this.f15749m.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的器材申请记录");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15747k = (EmptyRecyclerView) findViewById(C4133R.C4137id.recyclerView);
        this.f15749m = (SmartRefreshLayout) findViewById(C4133R.C4137id.refresh);
        this.f15748l = (TextView) findViewById(C4133R.C4137id.tv_emptyView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
