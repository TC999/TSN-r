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
import com.bxkj.student.home.teaching.separateexam.MyAppointExamListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MyAppointExamListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f21331k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f21332l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f21333m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f21334n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21335o;

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
        /* renamed from: com.bxkj.student.home.teaching.separateexam.MyAppointExamListActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class C0251a extends HttpCallBack {
            C0251a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                MyAppointExamListActivity.this.l0();
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(Map map) {
            Http.with(this.f1707a).setObservable(((w.a) Http.getApiService(w.a.class)).U(JsonParse.getString(map, "id"))).setDataListener(new C0251a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(final Map map, View view) {
            new iOSTwoButtonDialog(this.f1707a).setMessage("\u786e\u5b9a\u53d6\u6d88\uff1f").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.separateexam.e
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    MyAppointExamListActivity.a.this.p(map);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            ((View) holder.h(2131232981).getParent()).setVisibility(8);
            holder.J(2131233012, JsonParse.getString(stringObjectMap, "teaching"));
            holder.J(2131233192, JsonParse.getString(stringObjectMap, "teacher"));
            ((View) holder.h(2131233013).getParent()).setVisibility(8);
            holder.J(2131232841, JsonParse.getString(stringObjectMap, "address"));
            ((View) holder.h(2131232851).getParent()).setVisibility(8);
            holder.J(2131232958, JsonParse.getString(stringObjectMap, "time"));
            holder.J(2131233169, JsonParse.getString(stringObjectMap, "state"));
            holder.J(2131233123, JsonParse.getString(stringObjectMap, "remark"));
            holder.J(2131231012, "\u53d6\u6d88\u7ea6\u8003");
            String string = JsonParse.getString(stringObjectMap, "stateid");
            holder.N(2131231012, "0".equals(string));
            ((Button) holder.h(2131231012)).setEnabled("0".equals(string));
            holder.w(2131231012, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.separateexam.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyAppointExamListActivity.a.this.q(stringObjectMap, view);
                }
            });
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

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyAppointExamListActivity.this.f21334n = JsonParse.getList(data, "data");
            MyAppointExamListActivity.this.f21335o.g(MyAppointExamListActivity.this.f21334n);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428026;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f21332l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427726, this.f21334n);
        this.f21335o = aVar;
        this.f21332l.setAdapter(aVar);
        this.f21332l.setEmptyView(this.f21333m);
        l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u7684\u9884\u7ea6\u8003\u8bd5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21331k = (SmartRefreshLayout) findViewById(2131232482);
        this.f21332l = (EmptyRecyclerView) findViewById(2131232481);
        this.f21333m = (TextView) findViewById(2131232952);
        this.f21331k.b0(false);
        this.f21331k.O(false);
    }

    public void l0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).o0(LoginUser.getLoginUser().getUserId())).setDataListener(new b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
