package com.bxkj.student.home.teaching.leave;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.collection.ArrayMap;
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
public class LeaveActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f21057k;

    /* renamed from: l  reason: collision with root package name */
    private MyGridView f21058l;

    /* renamed from: m  reason: collision with root package name */
    private Button f21059m;

    /* renamed from: o  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.c f21061o;

    /* renamed from: p  reason: collision with root package name */
    private Spinner f21062p;

    /* renamed from: q  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f21063q;

    /* renamed from: s  reason: collision with root package name */
    private String f21065s;

    /* renamed from: t  reason: collision with root package name */
    private int f21066t;

    /* renamed from: u  reason: collision with root package name */
    private Integer f21067u;

    /* renamed from: n  reason: collision with root package name */
    private List<String> f21060n = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private List<Map<String, Object>> f21064r = new ArrayList();

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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            LeaveActivity.this.f21067u = position == 0 ? null : Integer.valueOf(position);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
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
            ((SelectLessenListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(SelectLessenListActivity.class)).u0(LeaveActivity.this.f21066t);
            LeaveActivity.this.h0("\u7533\u8bf7\u6210\u529f");
            LeaveActivity.this.finish();
        }
    }

    private void m0() {
        String trim = this.f21057k.getText().toString().trim();
        if (trim.isEmpty()) {
            h0("\u7533\u8bf7\u7406\u7531\u4e0d\u80fd\u4e3a\u7a7a");
        } else if (this.f21060n.size() == 0) {
            h0("\u81f3\u5c11\u4e0a\u4f20\u4e00\u5f20\u56fe\u7247");
        } else {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (String str : this.f21060n) {
                File file = new File(str);
                String str2 = "";
                sb.append(sb.toString().isEmpty() ? "" : ",");
                sb.append(file.getName());
                if (!sb2.toString().isEmpty()) {
                    str2 = ",";
                }
                sb2.append(str2);
                sb2.append(cn.bluemobi.dylan.base.utils.b.b(p0(file.getPath())));
            }
            Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).e1(LoginUser.getLoginUser().getUserId(), this.f21065s, this.f21067u, trim, sb.toString(), sb2.toString())).setDataListener(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 n0(File file) {
        this.f21060n.add(file.getPath());
        this.f21061o.c(this.f21060n);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(AdapterView adapterView, View view, int i4, long j4) {
        k.f18613a.p(this.f1657i, new l() { // from class: com.bxkj.student.home.teaching.leave.b
            @Override // l1.l
            public final Object invoke(Object obj) {
                f1 n02;
                n02 = LeaveActivity.this.n0((File) obj);
                return n02;
            }
        });
    }

    public static byte[] p0(String filename) {
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
        this.f21058l.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.leave.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                LeaveActivity.this.o0(adapterView, view, i4, j4);
            }
        });
        this.f21059m.setOnClickListener(this);
        this.f21062p.setOnItemSelectedListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427428;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("id")) {
            this.f21065s = getIntent().getStringExtra("id");
        }
        if (getIntent().hasExtra("position")) {
            this.f21066t = getIntent().getIntExtra("position", -1);
        }
        List<String> list = this.f21060n;
        Context context = this.f1656h;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.f21061o = cVar;
        cVar.e(3);
        this.f21058l.setAdapter((ListAdapter) this.f21061o);
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "\u8bf7\u9009\u62e9");
        this.f21064r.add(arrayMap);
        for (int i4 = 1; i4 < 31; i4++) {
            ArrayMap arrayMap2 = new ArrayMap();
            arrayMap2.put("name", "\u7b2c" + i4 + "\u5468");
            this.f21064r.add(arrayMap2);
        }
        a aVar = new a(this.f1656h, 2131427755, this.f21064r);
        this.f21063q = aVar;
        this.f21062p.setAdapter((SpinnerAdapter) aVar);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4e0a\u8bfe\u8bf7\u5047");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21057k = (EditText) findViewById(2131231256);
        this.f21058l = (MyGridView) findViewById(2131231335);
        this.f21059m = (Button) findViewById(2131230967);
        this.f21062p = (Spinner) findViewById(2131232642);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        m0();
    }
}
