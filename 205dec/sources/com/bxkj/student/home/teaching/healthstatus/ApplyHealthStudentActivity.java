package com.bxkj.student.home.teaching.healthstatus;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.utils.k;
import com.orhanobut.logger.j;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.f1;
import l1.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ApplyHealthStudentActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f20318k;

    /* renamed from: l  reason: collision with root package name */
    private MyGridView f20319l;

    /* renamed from: m  reason: collision with root package name */
    private Button f20320m;

    /* renamed from: o  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.c f20322o;

    /* renamed from: p  reason: collision with root package name */
    private Spinner f20323p;

    /* renamed from: q  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f20324q;

    /* renamed from: n  reason: collision with root package name */
    private List<String> f20321n = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private List<Map<String, Object>> f20325r = new ArrayList();

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
            ApplyHealthStudentActivity.this.R().setVisibility(0);
            ApplyHealthStudentActivity.this.f20325r = (List) data.get("data");
            ApplyHealthStudentActivity.this.f20324q.c(ApplyHealthStudentActivity.this.f20325r);
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

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyHealthStudentActivity.this.h0("\u7533\u8bf7\u6210\u529f");
            ApplyHealthStatusListActivity applyHealthStatusListActivity = (ApplyHealthStatusListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(ApplyHealthStatusListActivity.class);
            if (applyHealthStatusListActivity != null) {
                applyHealthStatusListActivity.n0();
            }
            ApplyHealthStudentActivity.this.finish();
        }
    }

    private void n0() {
        String trim = this.f20318k.getText().toString().trim();
        if (trim.isEmpty()) {
            h0("\u7533\u8bf7\u7406\u7531\u4e0d\u80fd\u4e3a\u7a7a");
        } else if (this.f20321n.size() == 0) {
            h0("\u81f3\u5c11\u4e0a\u4f20\u4e00\u5f20\u56fe\u7247");
        } else {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (String str : this.f20321n) {
                File file = new File(str);
                String str2 = "";
                sb.append(sb.toString().isEmpty() ? "" : ",");
                sb.append(file.getName());
                if (!sb2.toString().isEmpty()) {
                    str2 = ",";
                }
                sb2.append(str2);
                sb2.append(cn.bluemobi.dylan.base.utils.b.b(r0(file.getPath())));
            }
            Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).r(LoginUser.getLoginUser().getUserId(), trim, sb.toString(), sb2.toString(), JsonParse.getString(this.f20324q.getItem(this.f20323p.getSelectedItemPosition()), "id"))).setDataListener(new c());
        }
    }

    private void o0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).j1()).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 p0(File file) {
        this.f20321n.add(file.getPath());
        this.f20322o.c(this.f20321n);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(AdapterView adapterView, View view, int i4, long j4) {
        k.f18613a.p(this.f1657i, new l() { // from class: com.bxkj.student.home.teaching.healthstatus.d
            @Override // l1.l
            public final Object invoke(Object obj) {
                f1 p02;
                p02 = ApplyHealthStudentActivity.this.p0((File) obj);
                return p02;
            }
        });
    }

    public static byte[] r0(String filename) {
        Throwable th;
        FileChannel fileChannel;
        try {
            fileChannel = new RandomAccessFile(filename, "r").getChannel();
        } catch (IOException e4) {
            e = e4;
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
            try {
                fileChannel.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
        try {
            try {
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                j.c(Boolean.valueOf(load.isLoaded()));
                byte[] bArr = new byte[(int) fileChannel.size()];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                try {
                    fileChannel.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                fileChannel.close();
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            e.printStackTrace();
            try {
                fileChannel.close();
            } catch (IOException e8) {
                e8.printStackTrace();
            }
            return null;
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20319l.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.healthstatus.c
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                ApplyHealthStudentActivity.this.q0(adapterView, view, i4, j4);
            }
        });
        this.f20320m.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427363;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        List<String> list = this.f20321n;
        Context context = this.f1656h;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.f20322o = cVar;
        cVar.e(3);
        this.f20319l.setAdapter((ListAdapter) this.f20322o);
        a aVar = new a(this.f1656h, 2131427755, this.f20325r);
        this.f20324q = aVar;
        this.f20323p.setAdapter((SpinnerAdapter) aVar);
        R().setVisibility(4);
        o0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7533\u8bf7\u72b6\u6001");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20318k = (EditText) findViewById(2131231256);
        this.f20319l = (MyGridView) findViewById(2131231335);
        this.f20320m = (Button) findViewById(2131230967);
        Spinner spinner = (Spinner) findViewById(2131232642);
        this.f20323p = spinner;
        spinner.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        n0();
    }
}
