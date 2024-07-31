package com.bxkj.student.home.physicaltest.p089mc;

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
import cn.bluemobi.dylan.base.adapter.GridViewAddImagesAdapter;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.C1138b;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.p085v2.common.utils.ImageSelectUtils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.orhanobut.logger.C11792j;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import p617l1.InterfaceC15280l;
import p653w.InterfaceC16236a;

/* renamed from: com.bxkj.student.home.physicaltest.mc.ApplyMCActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ApplyMCActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f16446k;

    /* renamed from: l */
    private MyGridView f16447l;

    /* renamed from: m */
    private Button f16448m;

    /* renamed from: o */
    private GridViewAddImagesAdapter f16450o;

    /* renamed from: p */
    private Spinner f16451p;

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f16452q;

    /* renamed from: s */
    private Spinner f16454s;

    /* renamed from: t */
    private CommonAdapter<Map<String, Object>> f16455t;

    /* renamed from: n */
    private List<String> f16449n = new ArrayList();

    /* renamed from: r */
    private List<Map<String, Object>> f16453r = new ArrayList();

    /* renamed from: u */
    private List<Map<String, Object>> f16456u = new ArrayList();

    /* renamed from: com.bxkj.student.home.physicaltest.mc.ApplyMCActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4345a extends CommonAdapter<Map<String, Object>> {
        C4345a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "statusname"));
        }
    }

    /* renamed from: com.bxkj.student.home.physicaltest.mc.ApplyMCActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4346b extends CommonAdapter<Map<String, Object>> {
        C4346b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.mc.ApplyMCActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4347c extends HttpCallBack {
        C4347c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyMCActivity.this.f16453r = (List) data.get("data");
            ApplyMCActivity.this.f16452q.m57842c(ApplyMCActivity.this.f16453r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.mc.ApplyMCActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4348d extends HttpCallBack {
        C4348d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            try {
                ApplyMCActivity.this.f16456u = (List) data.get("data");
                int i = 0;
                for (int i2 = 0; i2 < ApplyMCActivity.this.f16456u.size(); i2++) {
                    if (JsonParse.getInt((Map) ApplyMCActivity.this.f16456u.get(i2), "displayorder") == 1) {
                        i = i2;
                    }
                }
                if (i != 0) {
                    Collections.swap(ApplyMCActivity.this.f16456u, 0, i);
                }
                ApplyMCActivity.this.f16455t.m57842c(ApplyMCActivity.this.f16456u);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.mc.ApplyMCActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4349e extends HttpCallBack {
        C4349e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyMCActivity.this.m57919h0("申请成功");
            ApplyMcListActivity applyMcListActivity = (ApplyMcListActivity) AppManager.m57776n().getActivity(ApplyMcListActivity.class);
            if (applyMcListActivity != null) {
                applyMcListActivity.m42580n0();
            }
            ApplyMCActivity.this.finish();
        }
    }

    /* renamed from: q0 */
    private void m42616q0() {
        int selectedItemPosition = this.f16454s.getSelectedItemPosition();
        if (selectedItemPosition == -1) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请选择年份").show();
            return;
        }
        int selectedItemPosition2 = this.f16451p.getSelectedItemPosition();
        if (selectedItemPosition2 == -1) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请选择状态").show();
            return;
        }
        String trim = this.f16446k.getText().toString().trim();
        if (trim.isEmpty()) {
            m57919h0("申请理由不能为空");
        } else if (this.f16449n.size() == 0) {
            m57919h0("至少上传一张图片");
        } else {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (String str : this.f16449n) {
                File file = new File(str);
                String str2 = "";
                sb.append(sb.toString().isEmpty() ? "" : ",");
                sb.append(file.getName());
                if (!sb2.toString().isEmpty()) {
                    str2 = ",";
                }
                sb2.append(str2);
                sb2.append(C1138b.m57768b(m42611v0(file.getPath())));
            }
            Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m164I0(LoginUser.getLoginUser().getUserId(), "meaNonStuApply", trim, sb.toString(), sb2.toString(), JsonParse.getString(this.f16452q.getItem(selectedItemPosition2), "id"), JsonParse.getString(this.f16455t.getItem(selectedItemPosition), "id"))).setDataListener(new C4349e());
        }
    }

    /* renamed from: r0 */
    private void m42615r0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m99k()).setDataListener(new C4347c());
    }

    /* renamed from: s0 */
    private void m42614s0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m154N0()).setDataListener(new C4348d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ Unit m42613t0(File file) {
        this.f16449n.add(file.getPath());
        this.f16450o.m57886c(this.f16449n);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void m42612u0(AdapterView adapterView, View view, int i, long j) {
        ImageSelectUtils.f15123a.m43786p(this.f1670i, new InterfaceC15280l() { // from class: com.bxkj.student.home.physicaltest.mc.b
            @Override // p617l1.InterfaceC15280l
            public final Object invoke(Object obj) {
                Unit m42613t0;
                m42613t0 = ApplyMCActivity.this.m42613t0((File) obj);
                return m42613t0;
            }
        });
    }

    /* renamed from: v0 */
    public static byte[] m42611v0(String filename) {
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
        this.f16447l.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.physicaltest.mc.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                ApplyMCActivity.this.m42612u0(adapterView, view, i, j);
            }
        });
        this.f16448m.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_apply_mc;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        List<String> list = this.f16449n;
        Context context = this.f1669h;
        GridViewAddImagesAdapter gridViewAddImagesAdapter = new GridViewAddImagesAdapter(list, context, 4, Tools.m57620a(10.0f, context));
        this.f16450o = gridViewAddImagesAdapter;
        gridViewAddImagesAdapter.m57884e(3);
        this.f16447l.setAdapter((ListAdapter) this.f16450o);
        C4345a c4345a = new C4345a(this.f1669h, 2131427755, this.f16453r);
        this.f16452q = c4345a;
        this.f16451p.setAdapter((SpinnerAdapter) c4345a);
        m42615r0();
        C4346b c4346b = new C4346b(this.f1669h, 2131427755, this.f16456u);
        this.f16455t = c4346b;
        this.f16454s.setAdapter((SpinnerAdapter) c4346b);
        m42614s0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("申请免测");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16446k = (EditText) findViewById(2131231256);
        this.f16447l = (MyGridView) findViewById(2131231335);
        this.f16448m = (Button) findViewById(2131230967);
        this.f16451p = (Spinner) findViewById(2131232642);
        this.f16454s = (Spinner) findViewById(C4215R.C4219id.spinnerTeam);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        m42616q0();
    }
}
