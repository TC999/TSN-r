package com.bxkj.student.home.teaching.separateexam;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.separateexam.MyAppointExamListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MyAppointExamListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f17993k;

    /* renamed from: l */
    private EmptyRecyclerView f17994l;

    /* renamed from: m */
    private TextView f17995m;

    /* renamed from: n */
    private List<Map<String, Object>> f17996n = new ArrayList();

    /* renamed from: o */
    private CommonAdapter<Map<String, Object>> f17997o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.separateexam.MyAppointExamListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4871a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.teaching.separateexam.MyAppointExamListActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C4872a extends HttpCallBack {
            C4872a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                MyAppointExamListActivity.this.m41140l0();
            }
        }

        C4871a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: p */
        public /* synthetic */ void m41136p(Map map) {
            Http.with(this.f1721a).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m141U(JsonParse.getString(map, "id"))).setDataListener(new C4872a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: q */
        public /* synthetic */ void m41135q(final Map map, View view) {
            new iOSTwoButtonDialog(this.f1721a).setMessage("确定取消？").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.separateexam.e
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    MyAppointExamListActivity.C4871a.this.m41136p(map);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            ((View) holder.m57862h(2131232981).getParent()).setVisibility(8);
            holder.m57874J(C4215R.C4219id.tv_lesson, JsonParse.getString(stringObjectMap, "teaching"));
            holder.m57874J(C4215R.C4219id.tv_teacher_name, JsonParse.getString(stringObjectMap, "teacher"));
            ((View) holder.m57862h(C4215R.C4219id.tv_lesson_all).getParent()).setVisibility(8);
            holder.m57874J(2131232841, JsonParse.getString(stringObjectMap, "address"));
            ((View) holder.m57862h(C4215R.C4219id.tv_appoint_time).getParent()).setVisibility(8);
            holder.m57874J(C4215R.C4219id.tv_exam_time, JsonParse.getString(stringObjectMap, RtspHeaders.Values.TIME));
            holder.m57874J(2131233169, JsonParse.getString(stringObjectMap, "state"));
            holder.m57874J(C4215R.C4219id.tv_remark, JsonParse.getString(stringObjectMap, "remark"));
            holder.m57874J(C4215R.C4219id.bt_start, "取消约考");
            String string = JsonParse.getString(stringObjectMap, "stateid");
            holder.m57870N(C4215R.C4219id.bt_start, "0".equals(string));
            ((Button) holder.m57862h(C4215R.C4219id.bt_start)).setEnabled("0".equals(string));
            holder.m57847w(C4215R.C4219id.bt_start, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.separateexam.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyAppointExamListActivity.C4871a.this.m41135q(stringObjectMap, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.separateexam.MyAppointExamListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4873b extends HttpCallBack {
        C4873b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyAppointExamListActivity.this.f17996n = JsonParse.getList(data, "data");
            MyAppointExamListActivity.this.f17997o.m57836g(MyAppointExamListActivity.this.f17996n);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return 2131428026;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f17994l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4871a c4871a = new C4871a(this.f1669h, C4215R.C4221layout.item_for_my_appoint_exam_list, this.f17996n);
        this.f17997o = c4871a;
        this.f17994l.setAdapter(c4871a);
        this.f17994l.setEmptyView(this.f17995m);
        m41140l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的预约考试");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17993k = (SmartRefreshLayout) findViewById(2131232482);
        this.f17994l = (EmptyRecyclerView) findViewById(2131232481);
        this.f17995m = (TextView) findViewById(2131232952);
        this.f17993k.mo2050b0(false);
        this.f17993k.mo2064P(false);
    }

    /* renamed from: l0 */
    public void m41140l0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m86o0(LoginUser.getLoginUser().getUserId())).setDataListener(new C4873b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
