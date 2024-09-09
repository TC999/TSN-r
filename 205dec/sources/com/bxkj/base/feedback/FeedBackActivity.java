package com.bxkj.base.feedback;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.R;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.m;
import com.bxkj.base.util.z;
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
import q.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class FeedBackActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f18270k;

    /* renamed from: l  reason: collision with root package name */
    private EditText f18271l;

    /* renamed from: m  reason: collision with root package name */
    private MyGridView f18272m;

    /* renamed from: n  reason: collision with root package name */
    private Button f18273n;

    /* renamed from: o  reason: collision with root package name */
    private List<String> f18274o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.c f18275p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            FeedBackActivity.this.h0("\u53cd\u9988\u6210\u529f");
            FeedBackActivity.this.finish();
        }
    }

    private void l0() {
        String trim = this.f18270k.getText().toString().trim();
        if (trim.isEmpty()) {
            h0("\u7533\u8bf7\u7406\u7531\u4e0d\u80fd\u4e3a\u7a7a");
        } else if (this.f18274o.size() == 0) {
            h0("\u81f3\u5c11\u4e0a\u4f20\u4e00\u5f20\u56fe\u7247");
        } else {
            String trim2 = this.f18271l.getText().toString().trim();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (String str : this.f18274o) {
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
            Http.with(this.f1656h).setObservable(((f) Http.getApiService(f.class)).s(z.h(this.f1656h), "Android", LoginUser.getLoginUser().getSchoolId(), trim, LoginUser.getLoginUser().getUserId(), trim2, sb.toString(), sb2.toString(), "0")).setDataListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 m0(File file) {
        this.f18274o.add(file.getPath());
        this.f18275p.c(this.f18274o);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(AdapterView adapterView, View view, int i4, long j4) {
        if (i4 == this.f18274o.size()) {
            k.f18613a.p(this.f1657i, new l() { // from class: com.bxkj.base.feedback.c
                @Override // l1.l
                public final Object invoke(Object obj) {
                    f1 m02;
                    m02 = FeedBackActivity.this.m0((File) obj);
                    return m02;
                }
            });
        } else {
            m.c(this.f1656h, this.f18274o, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(View view) {
        l0();
    }

    public static byte[] p0(String str) {
        Throwable th;
        FileChannel fileChannel;
        try {
            fileChannel = new RandomAccessFile(str, "r").getChannel();
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
        this.f18272m.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.base.feedback.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                FeedBackActivity.this.n0(adapterView, view, i4, j4);
            }
        });
        this.f18273n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.feedback.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedBackActivity.this.o0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_feedback;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("imagePath")) {
            this.f18274o.add(getIntent().getStringExtra("imagePath"));
        }
        List<String> list = this.f18274o;
        Context context = this.f1656h;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.f18275p = cVar;
        cVar.e(4);
        this.f18272m.setAdapter((ListAdapter) this.f18275p);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u53cd\u9988\u6c42\u52a9");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle bundle) {
        this.f18270k = (EditText) findViewById(R.id.et_content);
        this.f18271l = (EditText) findViewById(R.id.et_phone);
        this.f18272m = (MyGridView) findViewById(R.id.gv_images);
        this.f18273n = (Button) findViewById(R.id.bt_commit);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
