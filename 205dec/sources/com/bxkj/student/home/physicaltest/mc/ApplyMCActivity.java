package com.bxkj.student.home.physicaltest.mc;

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
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.f1;
import l1.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ApplyMCActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f19836k;

    /* renamed from: l  reason: collision with root package name */
    private MyGridView f19837l;

    /* renamed from: m  reason: collision with root package name */
    private Button f19838m;

    /* renamed from: o  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.c f19840o;

    /* renamed from: p  reason: collision with root package name */
    private Spinner f19841p;

    /* renamed from: q  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f19842q;

    /* renamed from: s  reason: collision with root package name */
    private Spinner f19844s;

    /* renamed from: t  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f19845t;

    /* renamed from: n  reason: collision with root package name */
    private List<String> f19839n = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private List<Map<String, Object>> f19843r = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    private List<Map<String, Object>> f19846u = new ArrayList();

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
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "statusname"));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        b(Context context, int layoutId, List datas) {
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
    public class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyMCActivity.this.f19843r = (List) data.get("data");
            ApplyMCActivity.this.f19842q.c(ApplyMCActivity.this.f19843r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            try {
                ApplyMCActivity.this.f19846u = (List) data.get("data");
                int i4 = 0;
                for (int i5 = 0; i5 < ApplyMCActivity.this.f19846u.size(); i5++) {
                    if (JsonParse.getInt((Map) ApplyMCActivity.this.f19846u.get(i5), "displayorder") == 1) {
                        i4 = i5;
                    }
                }
                if (i4 != 0) {
                    Collections.swap(ApplyMCActivity.this.f19846u, 0, i4);
                }
                ApplyMCActivity.this.f19845t.c(ApplyMCActivity.this.f19846u);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyMCActivity.this.h0("\u7533\u8bf7\u6210\u529f");
            ApplyMcListActivity applyMcListActivity = (ApplyMcListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(ApplyMcListActivity.class);
            if (applyMcListActivity != null) {
                applyMcListActivity.n0();
            }
            ApplyMCActivity.this.finish();
        }
    }

    private void q0() {
        int selectedItemPosition = this.f19844s.getSelectedItemPosition();
        if (selectedItemPosition == -1) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u9009\u62e9\u5e74\u4efd").show();
            return;
        }
        int selectedItemPosition2 = this.f19841p.getSelectedItemPosition();
        if (selectedItemPosition2 == -1) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u9009\u62e9\u72b6\u6001").show();
            return;
        }
        String trim = this.f19836k.getText().toString().trim();
        if (trim.isEmpty()) {
            h0("\u7533\u8bf7\u7406\u7531\u4e0d\u80fd\u4e3a\u7a7a");
        } else if (this.f19839n.size() == 0) {
            h0("\u81f3\u5c11\u4e0a\u4f20\u4e00\u5f20\u56fe\u7247");
        } else {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (String str : this.f19839n) {
                File file = new File(str);
                String str2 = "";
                sb.append(sb.toString().isEmpty() ? "" : ",");
                sb.append(file.getName());
                if (!sb2.toString().isEmpty()) {
                    str2 = ",";
                }
                sb2.append(str2);
                sb2.append(cn.bluemobi.dylan.base.utils.b.b(v0(file.getPath())));
            }
            Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).I0(LoginUser.getLoginUser().getUserId(), "meaNonStuApply", trim, sb.toString(), sb2.toString(), JsonParse.getString(this.f19842q.getItem(selectedItemPosition2), "id"), JsonParse.getString(this.f19845t.getItem(selectedItemPosition), "id"))).setDataListener(new e());
        }
    }

    private void r0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).k()).setDataListener(new c());
    }

    private void s0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).N0()).setDataListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 t0(File file) {
        this.f19839n.add(file.getPath());
        this.f19840o.c(this.f19839n);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(AdapterView adapterView, View view, int i4, long j4) {
        k.f18613a.p(this.f1657i, new l() { // from class: com.bxkj.student.home.physicaltest.mc.b
            @Override // l1.l
            public final Object invoke(Object obj) {
                f1 t02;
                t02 = ApplyMCActivity.this.t0((File) obj);
                return t02;
            }
        });
    }

    public static byte[] v0(String filename) {
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
        this.f19837l.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.physicaltest.mc.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                ApplyMCActivity.this.u0(adapterView, view, i4, j4);
            }
        });
        this.f19838m.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427364;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        List<String> list = this.f19839n;
        Context context = this.f1656h;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.f19840o = cVar;
        cVar.e(3);
        this.f19837l.setAdapter((ListAdapter) this.f19840o);
        a aVar = new a(this.f1656h, 2131427755, this.f19843r);
        this.f19842q = aVar;
        this.f19841p.setAdapter((SpinnerAdapter) aVar);
        r0();
        b bVar = new b(this.f1656h, 2131427755, this.f19846u);
        this.f19845t = bVar;
        this.f19844s.setAdapter((SpinnerAdapter) bVar);
        s0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7533\u8bf7\u514d\u6d4b");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19836k = (EditText) findViewById(2131231256);
        this.f19837l = (MyGridView) findViewById(2131231335);
        this.f19838m = (Button) findViewById(2131230967);
        this.f19841p = (Spinner) findViewById(2131232642);
        this.f19844s = (Spinner) findViewById(2131232643);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        q0();
    }
}
