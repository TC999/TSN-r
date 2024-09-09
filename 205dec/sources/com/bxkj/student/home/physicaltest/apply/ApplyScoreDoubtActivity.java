package com.bxkj.student.home.physicaltest.apply;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
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
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
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
public class ApplyScoreDoubtActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f19769k;

    /* renamed from: l  reason: collision with root package name */
    private EditText f19770l;

    /* renamed from: m  reason: collision with root package name */
    private EditText f19771m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f19772n;

    /* renamed from: o  reason: collision with root package name */
    private EditText f19773o;

    /* renamed from: p  reason: collision with root package name */
    private EditText f19774p;

    /* renamed from: q  reason: collision with root package name */
    private MyGridView f19775q;

    /* renamed from: r  reason: collision with root package name */
    private Button f19776r;

    /* renamed from: t  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.c f19778t;

    /* renamed from: u  reason: collision with root package name */
    private Spinner f19779u;

    /* renamed from: v  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f19780v;

    /* renamed from: x  reason: collision with root package name */
    private String f19782x;

    /* renamed from: s  reason: collision with root package name */
    private List<String> f19777s = new ArrayList();

    /* renamed from: w  reason: collision with root package name */
    private List<Map<String, Object>> f19781w = new ArrayList();

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
        public void a(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131232981, JsonParse.getString(stringObjectMap, "examName"));
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "actualScore") + JsonParse.getString(stringObjectMap, "examunit"));
            holder.J(2131233146, JsonParse.getString(stringObjectMap, "score") + "\u5206");
            holder.J(2131233116, JsonParse.getString(stringObjectMap, "rank"));
            holder.h(2131233169).setVisibility(4);
            holder.N(2131231389, false);
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
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ApplyScoreDoubtActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyScoreDoubtActivity.this.R().setVisibility(0);
            ApplyScoreDoubtActivity.this.f19781w = (List) data.get("data");
            ApplyScoreDoubtActivity.this.f19780v.c(ApplyScoreDoubtActivity.this.f19781w);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String string = JsonParse.getString((Map) ApplyScoreDoubtActivity.this.f19780v.getItem(position), "examName");
            String string2 = JsonParse.getString((Map) ApplyScoreDoubtActivity.this.f19780v.getItem(position), "examunit");
            if (string.contains("\u8eab\u9ad8") && string.contains("\u4f53\u91cd")) {
                ((View) ApplyScoreDoubtActivity.this.f19770l.getParent()).setVisibility(0);
                ((View) ApplyScoreDoubtActivity.this.f19771m.getParent()).setVisibility(0);
                ((View) ApplyScoreDoubtActivity.this.f19769k.getParent()).setVisibility(8);
                return;
            }
            ((View) ApplyScoreDoubtActivity.this.f19770l.getParent()).setVisibility(8);
            ((View) ApplyScoreDoubtActivity.this.f19771m.getParent()).setVisibility(8);
            ((View) ApplyScoreDoubtActivity.this.f19769k.getParent()).setVisibility(0);
            ApplyScoreDoubtActivity.this.f19772n.setText(string2);
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
    public class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyScoreDoubtActivity.this.h0("\u7533\u8bf7\u6210\u529f");
            ScoreDoubtActivity scoreDoubtActivity = (ScoreDoubtActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(ScoreDoubtActivity.class);
            if (scoreDoubtActivity != null) {
                scoreDoubtActivity.n0();
            }
            ApplyScoreDoubtActivity.this.finish();
        }
    }

    private void s0() {
        String str;
        String trim = this.f19773o.getText().toString().trim();
        String trim2 = this.f19774p.getText().toString().trim();
        if (trim.isEmpty()) {
            h0("\u7533\u8bf7\u7406\u7531\u4e0d\u80fd\u4e3a\u7a7a");
        } else if (TextUtils.isEmpty(trim2)) {
            h0("\u8054\u7cfb\u7535\u8bdd\u4e0d\u80fd\u4e3a\u7a7a");
        } else {
            String string = JsonParse.getString(this.f19780v.getItem(this.f19779u.getSelectedItemPosition()), "examName");
            String string2 = JsonParse.getString(this.f19780v.getItem(this.f19779u.getSelectedItemPosition()), "actualScore");
            String trim3 = this.f19769k.getText().toString().trim();
            if (string.contains("\u8eab\u9ad8") && string.contains("\u4f53\u91cd")) {
                str = this.f19770l.getText().toString().trim() + TTPathConst.sSeparator + this.f19771m.getText().toString().trim();
            } else {
                str = trim3;
            }
            Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).T(LoginUser.getLoginUser().getUserId(), this.f19782x, JsonParse.getString(this.f19780v.getItem(this.f19779u.getSelectedItemPosition()), "examid"), string2, str, trim2, trim)).setDataListener(new d());
        }
    }

    private void t0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).v0(this.f19782x)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 u0(File file) {
        this.f19777s.add(file.getPath());
        this.f19778t.c(this.f19777s);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(AdapterView adapterView, View view, int i4, long j4) {
        k.f18613a.p(this.f1657i, new l() { // from class: com.bxkj.student.home.physicaltest.apply.b
            @Override // l1.l
            public final Object invoke(Object obj) {
                f1 u02;
                u02 = ApplyScoreDoubtActivity.this.u0((File) obj);
                return u02;
            }
        });
    }

    public static byte[] w0(String filename) {
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
        this.f19779u.setOnItemSelectedListener(new c());
        this.f19775q.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.physicaltest.apply.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                ApplyScoreDoubtActivity.this.v0(adapterView, view, i4, j4);
            }
        });
        this.f19776r.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427367;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("meaScoreId")) {
            this.f19782x = getIntent().getStringExtra("meaScoreId");
        }
        List<String> list = this.f19777s;
        Context context = this.f1656h;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.f19778t = cVar;
        cVar.e(3);
        this.f19775q.setAdapter((ListAdapter) this.f19778t);
        a aVar = new a(this.f1656h, 2131427671, this.f19781w);
        this.f19780v = aVar;
        this.f19779u.setAdapter((SpinnerAdapter) aVar);
        R().setVisibility(4);
        t0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4f53\u6d4b\u6210\u7ee9\u7533\u8bc9");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19769k = (EditText) findViewById(2131231274);
        this.f19770l = (EditText) findViewById(2131231258);
        this.f19771m = (EditText) findViewById(2131231282);
        this.f19772n = (TextView) findViewById(2131233213);
        this.f19773o = (EditText) findViewById(2131231256);
        this.f19774p = (EditText) findViewById(2131231266);
        this.f19775q = (MyGridView) findViewById(2131231335);
        this.f19776r = (Button) findViewById(2131230967);
        this.f19779u = (Spinner) findViewById(2131232642);
        this.f19775q.setVisibility(8);
        this.f19779u.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        s0();
    }
}
