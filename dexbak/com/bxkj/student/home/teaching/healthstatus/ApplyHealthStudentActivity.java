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
import cn.bluemobi.dylan.base.adapter.GridViewAddImagesAdapter;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.C1138b;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.MyGridView;
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
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import p617l1.InterfaceC15280l;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ApplyHealthStudentActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f16948k;

    /* renamed from: l */
    private MyGridView f16949l;

    /* renamed from: m */
    private Button f16950m;

    /* renamed from: o */
    private GridViewAddImagesAdapter f16952o;

    /* renamed from: p */
    private Spinner f16953p;

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f16954q;

    /* renamed from: n */
    private List<String> f16951n = new ArrayList();

    /* renamed from: r */
    private List<Map<String, Object>> f16955r = new ArrayList();

    /* renamed from: com.bxkj.student.home.teaching.healthstatus.ApplyHealthStudentActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4511a extends CommonAdapter<Map<String, Object>> {
        C4511a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.healthstatus.ApplyHealthStudentActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4512b extends HttpCallBack {
        C4512b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyHealthStudentActivity.this.m57932R().setVisibility(0);
            ApplyHealthStudentActivity.this.f16955r = (List) data.get("data");
            ApplyHealthStudentActivity.this.f16954q.m57842c(ApplyHealthStudentActivity.this.f16955r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.healthstatus.ApplyHealthStudentActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4513c extends HttpCallBack {
        C4513c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyHealthStudentActivity.this.m57919h0("申请成功");
            ApplyHealthStatusListActivity applyHealthStatusListActivity = (ApplyHealthStatusListActivity) AppManager.m57776n().getActivity(ApplyHealthStatusListActivity.class);
            if (applyHealthStatusListActivity != null) {
                applyHealthStatusListActivity.m42146n0();
            }
            ApplyHealthStudentActivity.this.finish();
        }
    }

    /* renamed from: n0 */
    private void m42138n0() {
        String trim = this.f16948k.getText().toString().trim();
        if (trim.isEmpty()) {
            m57919h0("申请理由不能为空");
        } else if (this.f16951n.size() == 0) {
            m57919h0("至少上传一张图片");
        } else {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (String str : this.f16951n) {
                File file = new File(str);
                String str2 = "";
                sb.append(sb.toString().isEmpty() ? "" : ",");
                sb.append(file.getName());
                if (!sb2.toString().isEmpty()) {
                    str2 = ",";
                }
                sb2.append(str2);
                sb2.append(C1138b.m57768b(m42134r0(file.getPath())));
            }
            Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m78r(LoginUser.getLoginUser().getUserId(), trim, sb.toString(), sb2.toString(), JsonParse.getString(this.f16954q.getItem(this.f16953p.getSelectedItemPosition()), "id"))).setDataListener(new C4513c());
        }
    }

    /* renamed from: o0 */
    private void m42137o0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m100j1()).setDataListener(new C4512b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ Unit m42136p0(File file) {
        this.f16951n.add(file.getPath());
        this.f16952o.m57886c(this.f16951n);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void m42135q0(AdapterView adapterView, View view, int i, long j) {
        ImageSelectUtils.f15123a.m43786p(this.f1670i, new InterfaceC15280l() { // from class: com.bxkj.student.home.teaching.healthstatus.d
            @Override // p617l1.InterfaceC15280l
            public final Object invoke(Object obj) {
                Unit m42136p0;
                m42136p0 = ApplyHealthStudentActivity.this.m42136p0((File) obj);
                return m42136p0;
            }
        });
    }

    /* renamed from: r0 */
    public static byte[] m42134r0(String filename) {
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
        this.f16949l.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.healthstatus.c
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                ApplyHealthStudentActivity.this.m42135q0(adapterView, view, i, j);
            }
        });
        this.f16950m.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_apply_health_status;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        List<String> list = this.f16951n;
        Context context = this.f1669h;
        GridViewAddImagesAdapter gridViewAddImagesAdapter = new GridViewAddImagesAdapter(list, context, 4, Tools.m57620a(10.0f, context));
        this.f16952o = gridViewAddImagesAdapter;
        gridViewAddImagesAdapter.m57884e(3);
        this.f16949l.setAdapter((ListAdapter) this.f16952o);
        C4511a c4511a = new C4511a(this.f1669h, 2131427755, this.f16955r);
        this.f16954q = c4511a;
        this.f16953p.setAdapter((SpinnerAdapter) c4511a);
        m57932R().setVisibility(4);
        m42137o0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("申请状态");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16948k = (EditText) findViewById(2131231256);
        this.f16949l = (MyGridView) findViewById(2131231335);
        this.f16950m = (Button) findViewById(2131230967);
        Spinner spinner = (Spinner) findViewById(2131232642);
        this.f16953p = spinner;
        spinner.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        m42138n0();
    }
}
