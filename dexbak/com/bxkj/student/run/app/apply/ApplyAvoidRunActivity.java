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
import cn.bluemobi.dylan.base.adapter.GridViewAddImagesAdapter;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.C1138b;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.p085v2.common.utils.ImageSelectUtils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.physicaltest.p089mc.ApplyMcListActivity;
import com.bxkj.student.run.app.RunApiService;
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
import p617l1.InterfaceC15280l;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ApplyAvoidRunActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f19042k;

    /* renamed from: l */
    private MyGridView f19043l;

    /* renamed from: m */
    private Button f19044m;

    /* renamed from: n */
    private List<String> f19045n = new ArrayList();

    /* renamed from: o */
    private GridViewAddImagesAdapter f19046o;

    /* renamed from: p */
    private Spinner f19047p;

    /* renamed from: q */
    private Spinner f19048q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.apply.ApplyAvoidRunActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5205a extends HttpCallBack {
        C5205a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyAvoidRunActivity.this.m57919h0("申请成功");
            ApplyMcListActivity applyMcListActivity = (ApplyMcListActivity) AppManager.m57776n().getActivity(ApplyMcListActivity.class);
            if (applyMcListActivity != null) {
                applyMcListActivity.m42580n0();
            }
            ApplyAvoidRunActivity.this.finish();
        }
    }

    /* renamed from: k0 */
    private void m40101k0() {
        String trim = this.f19042k.getText().toString().trim();
        if (trim.isEmpty()) {
            m57919h0("申请理由不能为空");
        } else if (this.f19045n.size() == 0) {
            m57919h0("至少上传一张图片");
        } else {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (String str : this.f19045n) {
                File file = new File(str);
                String str2 = "";
                sb.append(sb.toString().isEmpty() ? "" : ",");
                sb.append(file.getName());
                if (!sb2.toString().isEmpty()) {
                    str2 = ",";
                }
                sb2.append(str2);
                sb2.append(C1138b.m57768b(m40098n0(file.getPath())));
            }
            Http.with(this.f1669h).setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40112i(LoginUser.getLoginUser().getUserId(), trim, sb.toString(), sb2.toString())).setDataListener(new C5205a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0 */
    public /* synthetic */ Unit m40100l0(File file) {
        this.f19045n.add(file.getPath());
        this.f19046o.m57886c(this.f19045n);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void m40099m0(AdapterView adapterView, View view, int i, long j) {
        ImageSelectUtils.f15123a.m43786p(this.f1670i, new InterfaceC15280l() { // from class: com.bxkj.student.run.app.apply.b
            @Override // p617l1.InterfaceC15280l
            public final Object invoke(Object obj) {
                Unit m40100l0;
                m40100l0 = ApplyAvoidRunActivity.this.m40100l0((File) obj);
                return m40100l0;
            }
        });
    }

    /* renamed from: n0 */
    public static byte[] m40098n0(String filename) {
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
        this.f19043l.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.run.app.apply.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                ApplyAvoidRunActivity.this.m40099m0(adapterView, view, i, j);
            }
        });
        this.f19044m.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_apply_mc;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        List<String> list = this.f19045n;
        Context context = this.f1669h;
        GridViewAddImagesAdapter gridViewAddImagesAdapter = new GridViewAddImagesAdapter(list, context, 4, Tools.m57620a(10.0f, context));
        this.f19046o = gridViewAddImagesAdapter;
        gridViewAddImagesAdapter.m57884e(3);
        this.f19043l.setAdapter((ListAdapter) this.f19046o);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("申请免跑");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19042k = (EditText) findViewById(2131231256);
        this.f19043l = (MyGridView) findViewById(2131231335);
        this.f19044m = (Button) findViewById(2131230967);
        this.f19047p = (Spinner) findViewById(2131232642);
        this.f19048q = (Spinner) findViewById(C4215R.C4219id.spinnerTeam);
        ((View) this.f19047p.getParent()).setVisibility(8);
        ((View) this.f19048q.getParent()).setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        m40101k0();
    }
}
