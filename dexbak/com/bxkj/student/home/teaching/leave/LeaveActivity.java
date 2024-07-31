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
public class LeaveActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f17719k;

    /* renamed from: l */
    private MyGridView f17720l;

    /* renamed from: m */
    private Button f17721m;

    /* renamed from: o */
    private GridViewAddImagesAdapter f17723o;

    /* renamed from: p */
    private Spinner f17724p;

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f17725q;

    /* renamed from: s */
    private String f17727s;

    /* renamed from: t */
    private int f17728t;

    /* renamed from: u */
    private Integer f17729u;

    /* renamed from: n */
    private List<String> f17722n = new ArrayList();

    /* renamed from: r */
    private List<Map<String, Object>> f17726r = new ArrayList();

    /* renamed from: com.bxkj.student.home.teaching.leave.LeaveActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4766a extends CommonAdapter<Map<String, Object>> {
        C4766a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.leave.LeaveActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4767b implements AdapterView.OnItemSelectedListener {
        C4767b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            LeaveActivity.this.f17729u = position == 0 ? null : Integer.valueOf(position);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.leave.LeaveActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4768c extends HttpCallBack {
        C4768c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ((SelectLessenListActivity) AppManager.m57776n().getActivity(SelectLessenListActivity.class)).m41391u0(LeaveActivity.this.f17728t);
            LeaveActivity.this.m57919h0("申请成功");
            LeaveActivity.this.finish();
        }
    }

    /* renamed from: m0 */
    private void m41408m0() {
        String trim = this.f17719k.getText().toString().trim();
        if (trim.isEmpty()) {
            m57919h0("申请理由不能为空");
        } else if (this.f17722n.size() == 0) {
            m57919h0("至少上传一张图片");
        } else {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (String str : this.f17722n) {
                File file = new File(str);
                String str2 = "";
                sb.append(sb.toString().isEmpty() ? "" : ",");
                sb.append(file.getName());
                if (!sb2.toString().isEmpty()) {
                    str2 = ",";
                }
                sb2.append(str2);
                sb2.append(C1138b.m57768b(m41405p0(file.getPath())));
            }
            Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m115e1(LoginUser.getLoginUser().getUserId(), this.f17727s, this.f17729u, trim, sb.toString(), sb2.toString())).setDataListener(new C4768c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ Unit m41407n0(File file) {
        this.f17722n.add(file.getPath());
        this.f17723o.m57886c(this.f17722n);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void m41406o0(AdapterView adapterView, View view, int i, long j) {
        ImageSelectUtils.f15123a.m43786p(this.f1670i, new InterfaceC15280l() { // from class: com.bxkj.student.home.teaching.leave.b
            @Override // p617l1.InterfaceC15280l
            public final Object invoke(Object obj) {
                Unit m41407n0;
                m41407n0 = LeaveActivity.this.m41407n0((File) obj);
                return m41407n0;
            }
        });
    }

    /* renamed from: p0 */
    public static byte[] m41405p0(String filename) {
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
        this.f17720l.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.leave.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                LeaveActivity.this.m41406o0(adapterView, view, i, j);
            }
        });
        this.f17721m.setOnClickListener(this);
        this.f17724p.setOnItemSelectedListener(new C4767b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_leave;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("id")) {
            this.f17727s = getIntent().getStringExtra("id");
        }
        if (getIntent().hasExtra("position")) {
            this.f17728t = getIntent().getIntExtra("position", -1);
        }
        List<String> list = this.f17722n;
        Context context = this.f1669h;
        GridViewAddImagesAdapter gridViewAddImagesAdapter = new GridViewAddImagesAdapter(list, context, 4, Tools.m57620a(10.0f, context));
        this.f17723o = gridViewAddImagesAdapter;
        gridViewAddImagesAdapter.m57884e(3);
        this.f17720l.setAdapter((ListAdapter) this.f17723o);
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "请选择");
        this.f17726r.add(arrayMap);
        for (int i = 1; i < 31; i++) {
            ArrayMap arrayMap2 = new ArrayMap();
            arrayMap2.put("name", "第" + i + "周");
            this.f17726r.add(arrayMap2);
        }
        C4766a c4766a = new C4766a(this.f1669h, 2131427755, this.f17726r);
        this.f17725q = c4766a;
        this.f17724p.setAdapter((SpinnerAdapter) c4766a);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("上课请假");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17719k = (EditText) findViewById(2131231256);
        this.f17720l = (MyGridView) findViewById(2131231335);
        this.f17721m = (Button) findViewById(2131230967);
        this.f17724p = (Spinner) findViewById(2131232642);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        m41408m0();
    }
}
