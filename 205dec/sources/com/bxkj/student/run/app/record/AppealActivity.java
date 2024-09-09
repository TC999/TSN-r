package com.bxkj.student.run.app.record;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import androidx.collection.ArrayMap;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.alibaba.fastjson.JSON;
import com.bxkj.student.run.app.record.AppealActivity;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.f1;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AppealActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f22531k;

    /* renamed from: l  reason: collision with root package name */
    private iOSOneButtonDialog f22532l;

    /* renamed from: m  reason: collision with root package name */
    private MyGridView f22533m;

    /* renamed from: n  reason: collision with root package name */
    private Button f22534n;

    /* renamed from: o  reason: collision with root package name */
    private List<String> f22535o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.c f22536p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            AppealActivity.this.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean d(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
            return i4 == 4;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RunRecorderListActivity runRecorderListActivity = (RunRecorderListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(RunRecorderListActivity.class);
            if (runRecorderListActivity != null) {
                runRecorderListActivity.K0();
            }
            AppealActivity.this.f22532l = new iOSOneButtonDialog(((BaseActivity) AppealActivity.this).f1656h).setMessage("\u7533\u8bc9\u6210\u529f\uff0c\u7b49\u5f85\u7ba1\u7406\u5458\u5ba1\u6838\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85\uff01").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.record.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AppealActivity.a.this.c(view);
                }
            });
            AppealActivity.this.f22532l.setCanceledOnTouchOutside(false);
            AppealActivity.this.f22532l.show();
            AppealActivity.this.f22532l.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bxkj.student.run.app.record.d
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
                    boolean d4;
                    d4 = AppealActivity.a.d(dialogInterface, i4, keyEvent);
                    return d4;
                }
            });
        }
    }

    private void o0() {
        String trim = this.f22531k.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.f1656h).setMessage(this.f22531k.getHint()).show();
            return;
        }
        String[] strArr = new String[this.f22535o.size()];
        for (int i4 = 0; i4 < this.f22535o.size(); i4++) {
            strArr[i4] = com.bxkj.base.util.j.b(this.f22535o.get(i4));
        }
        Http.with(this.f1656h).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).b(getIntent().getStringExtra("id"), trim, JSON.toJSONString(strArr))).setDataListener(new a());
    }

    public static Map<String, RequestBody> p0(String key, List<File> files) {
        ArrayMap arrayMap = new ArrayMap();
        for (int i4 = 0; i4 < files.size(); i4++) {
            File file = files.get(i4);
            RequestBody create = RequestBody.create(MediaType.parse("image/png"), file);
            arrayMap.put(key + "\"; filename=\"" + file.getName(), create);
        }
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(View view) {
        o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 r0(File file) {
        this.f22535o.add(file.getPath());
        this.f22536p.c(this.f22535o);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(AdapterView adapterView, View view, int i4, long j4) {
        com.bxkj.base.v2.common.utils.k.f18613a.p(this.f1657i, new l1.l() { // from class: com.bxkj.student.run.app.record.c
            @Override // l1.l
            public final Object invoke(Object obj) {
                f1 r02;
                r02 = AppealActivity.this.r0((File) obj);
                return r02;
            }
        });
    }

    public static byte[] t0(String filename) {
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
                com.orhanobut.logger.j.c(Boolean.valueOf(load.isLoaded()));
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
        this.f22534n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.record.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppealActivity.this.q0(view);
            }
        });
        this.f22533m.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.run.app.record.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                AppealActivity.this.s0(adapterView, view, i4, j4);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427361;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        List<String> list = this.f22535o;
        Context context = this.f1656h;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.f22536p = cVar;
        cVar.e(3);
        this.f22533m.setAdapter((ListAdapter) this.f22536p);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u8981\u7533\u8bc9");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22531k = (EditText) findViewById(2131231272);
        this.f22534n = (Button) findViewById(2131230967);
        this.f22533m = (MyGridView) findViewById(2131231335);
        this.f22534n = (Button) findViewById(2131230967);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
