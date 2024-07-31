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
import cn.bluemobi.dylan.base.adapter.GridViewAddImagesAdapter;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.p085v2.common.utils.ImageSelectUtils;
import com.bxkj.base.util.C3905j;
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.RunApiService;
import com.bxkj.student.run.app.record.AppealActivity;
import com.orhanobut.logger.C11792j;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import p617l1.InterfaceC15280l;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AppealActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f19295k;

    /* renamed from: l */
    private iOSOneButtonDialog f19296l;

    /* renamed from: m */
    private MyGridView f19297m;

    /* renamed from: n */
    private Button f19298n;

    /* renamed from: o */
    private List<String> f19299o = new ArrayList();

    /* renamed from: p */
    private GridViewAddImagesAdapter f19300p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.record.AppealActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5318a extends HttpCallBack {
        C5318a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m39869c(View view) {
            AppealActivity.this.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public static /* synthetic */ boolean m39868d(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            return i == 4;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RunRecorderListActivity runRecorderListActivity = (RunRecorderListActivity) AppManager.m57776n().getActivity(RunRecorderListActivity.class);
            if (runRecorderListActivity != null) {
                runRecorderListActivity.m39841K0();
            }
            AppealActivity.this.f19296l = new iOSOneButtonDialog(((BaseActivity) AppealActivity.this).f1669h).setMessage("申诉成功，等待管理员审核，请耐心等待！").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.record.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AppealActivity.C5318a.this.m39869c(view);
                }
            });
            AppealActivity.this.f19296l.setCanceledOnTouchOutside(false);
            AppealActivity.this.f19296l.show();
            AppealActivity.this.f19296l.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bxkj.student.run.app.record.d
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    boolean m39868d;
                    m39868d = AppealActivity.C5318a.m39868d(dialogInterface, i, keyEvent);
                    return m39868d;
                }
            });
        }
    }

    /* renamed from: o0 */
    private void m39877o0() {
        String trim = this.f19295k.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.f1669h).setMessage(this.f19295k.getHint()).show();
            return;
        }
        String[] strArr = new String[this.f19299o.size()];
        for (int i = 0; i < this.f19299o.size(); i++) {
            strArr[i] = C3905j.m44077b(this.f19299o.get(i));
        }
        Http.with(this.f1669h).setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40119b(getIntent().getStringExtra("id"), trim, JSON.toJSONString(strArr))).setDataListener(new C5318a());
    }

    /* renamed from: p0 */
    public static Map<String, RequestBody> m39876p0(String key, List<File> files) {
        ArrayMap arrayMap = new ArrayMap();
        for (int i = 0; i < files.size(); i++) {
            File file = files.get(i);
            RequestBody create = RequestBody.create(MediaType.parse("image/png"), file);
            arrayMap.put(key + "\"; filename=\"" + file.getName(), create);
        }
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void m39875q0(View view) {
        m39877o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ Unit m39874r0(File file) {
        this.f19299o.add(file.getPath());
        this.f19300p.m57886c(this.f19299o);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void m39873s0(AdapterView adapterView, View view, int i, long j) {
        ImageSelectUtils.f15123a.m43786p(this.f1670i, new InterfaceC15280l() { // from class: com.bxkj.student.run.app.record.c
            @Override // p617l1.InterfaceC15280l
            public final Object invoke(Object obj) {
                Unit m39874r0;
                m39874r0 = AppealActivity.this.m39874r0((File) obj);
                return m39874r0;
            }
        });
    }

    /* renamed from: t0 */
    public static byte[] m39872t0(String filename) {
        Throwable th;
        FileChannel fileChannel;
        try {
            fileChannel = new RandomAccessFile(filename, "r").getChannel();
        } catch (IOException e) {
            e = e;
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
            try {
                fileChannel.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            throw th;
        }
        try {
            try {
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                C11792j.m20470c(Boolean.valueOf(load.isLoaded()));
                byte[] bArr = new byte[(int) fileChannel.size()];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                try {
                    fileChannel.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                fileChannel.close();
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            try {
                fileChannel.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return null;
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f19298n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.record.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppealActivity.this.m39875q0(view);
            }
        });
        this.f19297m.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.run.app.record.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                AppealActivity.this.m39873s0(adapterView, view, i, j);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_appeal;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        List<String> list = this.f19299o;
        Context context = this.f1669h;
        GridViewAddImagesAdapter gridViewAddImagesAdapter = new GridViewAddImagesAdapter(list, context, 4, Tools.m57620a(10.0f, context));
        this.f19300p = gridViewAddImagesAdapter;
        gridViewAddImagesAdapter.m57884e(3);
        this.f19297m.setAdapter((ListAdapter) this.f19300p);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我要申诉");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19295k = (EditText) findViewById(2131231272);
        this.f19298n = (Button) findViewById(2131230967);
        this.f19297m = (MyGridView) findViewById(2131231335);
        this.f19298n = (Button) findViewById(2131230967);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
