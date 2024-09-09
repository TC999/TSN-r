package com.bxkj.student.run.app.apply;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.utils.k;
import com.bxkj.student.home.physicaltest.mc.ApplyMcListActivity;
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
public class ApplyAvoidRunActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f22288k;

    /* renamed from: l  reason: collision with root package name */
    private MyGridView f22289l;

    /* renamed from: m  reason: collision with root package name */
    private Button f22290m;

    /* renamed from: n  reason: collision with root package name */
    private List<String> f22291n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.c f22292o;

    /* renamed from: p  reason: collision with root package name */
    private Spinner f22293p;

    /* renamed from: q  reason: collision with root package name */
    private Spinner f22294q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyAvoidRunActivity.this.h0("\u7533\u8bf7\u6210\u529f");
            ApplyMcListActivity applyMcListActivity = (ApplyMcListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(ApplyMcListActivity.class);
            if (applyMcListActivity != null) {
                applyMcListActivity.n0();
            }
            ApplyAvoidRunActivity.this.finish();
        }
    }

    private void k0() {
        String trim = this.f22288k.getText().toString().trim();
        if (trim.isEmpty()) {
            h0("\u7533\u8bf7\u7406\u7531\u4e0d\u80fd\u4e3a\u7a7a");
        } else if (this.f22291n.size() == 0) {
            h0("\u81f3\u5c11\u4e0a\u4f20\u4e00\u5f20\u56fe\u7247");
        } else {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (String str : this.f22291n) {
                File file = new File(str);
                String str2 = "";
                sb.append(sb.toString().isEmpty() ? "" : ",");
                sb.append(file.getName());
                if (!sb2.toString().isEmpty()) {
                    str2 = ",";
                }
                sb2.append(str2);
                sb2.append(cn.bluemobi.dylan.base.utils.b.b(n0(file.getPath())));
            }
            Http.with(this.f1656h).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).i(LoginUser.getLoginUser().getUserId(), trim, sb.toString(), sb2.toString())).setDataListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 l0(File file) {
        this.f22291n.add(file.getPath());
        this.f22292o.c(this.f22291n);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(AdapterView adapterView, View view, int i4, long j4) {
        k.f18613a.p(this.f1657i, new l() { // from class: com.bxkj.student.run.app.apply.b
            @Override // l1.l
            public final Object invoke(Object obj) {
                f1 l02;
                l02 = ApplyAvoidRunActivity.this.l0((File) obj);
                return l02;
            }
        });
    }

    public static byte[] n0(String filename) {
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
        this.f22289l.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.run.app.apply.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                ApplyAvoidRunActivity.this.m0(adapterView, view, i4, j4);
            }
        });
        this.f22290m.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427364;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        List<String> list = this.f22291n;
        Context context = this.f1656h;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.f22292o = cVar;
        cVar.e(3);
        this.f22289l.setAdapter((ListAdapter) this.f22292o);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7533\u8bf7\u514d\u8dd1");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22288k = (EditText) findViewById(2131231256);
        this.f22289l = (MyGridView) findViewById(2131231335);
        this.f22290m = (Button) findViewById(2131230967);
        this.f22293p = (Spinner) findViewById(2131232642);
        this.f22294q = (Spinner) findViewById(2131232643);
        ((View) this.f22293p.getParent()).setVisibility(8);
        ((View) this.f22294q.getParent()).setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        k0();
    }
}
