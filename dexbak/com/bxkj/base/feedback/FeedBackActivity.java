package com.bxkj.base.feedback;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.GridViewAddImagesAdapter;
import cn.bluemobi.dylan.base.utils.C1138b;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.C3801R;
import com.bxkj.base.p085v2.common.utils.ImageSelectUtils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.C3906m;
import com.bxkj.base.util.SystemUtils;
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
import p635q.MainApiService;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FeedBackActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f14785k;

    /* renamed from: l */
    private EditText f14786l;

    /* renamed from: m */
    private MyGridView f14787m;

    /* renamed from: n */
    private Button f14788n;

    /* renamed from: o */
    private List<String> f14789o = new ArrayList();

    /* renamed from: p */
    private GridViewAddImagesAdapter f14790p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.feedback.FeedBackActivity$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3868a extends HttpCallBack {
        C3868a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            FeedBackActivity.this.m57919h0("反馈成功");
            FeedBackActivity.this.finish();
        }
    }

    /* renamed from: l0 */
    private void m44217l0() {
        String trim = this.f14785k.getText().toString().trim();
        if (trim.isEmpty()) {
            m57919h0("申请理由不能为空");
        } else if (this.f14789o.size() == 0) {
            m57919h0("至少上传一张图片");
        } else {
            String trim2 = this.f14786l.getText().toString().trim();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (String str : this.f14789o) {
                File file = new File(str);
                String str2 = "";
                sb.append(sb.toString().isEmpty() ? "" : ",");
                sb.append(file.getName());
                if (!sb2.toString().isEmpty()) {
                    str2 = ",";
                }
                sb2.append(str2);
                sb2.append(C1138b.m57768b(m44213p0(file.getPath())));
            }
            Http.with(this.f1669h).setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2258s(SystemUtils.m43998h(this.f1669h), "Android", LoginUser.getLoginUser().getSchoolId(), trim, LoginUser.getLoginUser().getUserId(), trim2, sb.toString(), sb2.toString(), "0")).setDataListener(new C3868a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ Unit m44216m0(File file) {
        this.f14789o.add(file.getPath());
        this.f14790p.m57886c(this.f14789o);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ void m44215n0(AdapterView adapterView, View view, int i, long j) {
        if (i == this.f14789o.size()) {
            ImageSelectUtils.f15123a.m43786p(this.f1670i, new InterfaceC15280l() { // from class: com.bxkj.base.feedback.c
                @Override // p617l1.InterfaceC15280l
                public final Object invoke(Object obj) {
                    Unit m44216m0;
                    m44216m0 = FeedBackActivity.this.m44216m0((File) obj);
                    return m44216m0;
                }
            });
        } else {
            C3906m.m44067c(this.f1669h, this.f14789o, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void m44214o0(View view) {
        m44217l0();
    }

    /* renamed from: p0 */
    public static byte[] m44213p0(String str) {
        Throwable th;
        FileChannel fileChannel;
        try {
            fileChannel = new RandomAccessFile(str, "r").getChannel();
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
        this.f14787m.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.base.feedback.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                FeedBackActivity.this.m44215n0(adapterView, view, i, j);
            }
        });
        this.f14788n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.feedback.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedBackActivity.this.m44214o0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C3801R.C3807layout.ac_feedback;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("imagePath")) {
            this.f14789o.add(getIntent().getStringExtra("imagePath"));
        }
        List<String> list = this.f14789o;
        Context context = this.f1669h;
        GridViewAddImagesAdapter gridViewAddImagesAdapter = new GridViewAddImagesAdapter(list, context, 4, Tools.m57620a(10.0f, context));
        this.f14790p = gridViewAddImagesAdapter;
        gridViewAddImagesAdapter.m57884e(4);
        this.f14787m.setAdapter((ListAdapter) this.f14790p);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("反馈求助");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle bundle) {
        this.f14785k = (EditText) findViewById(C3801R.C3805id.et_content);
        this.f14786l = (EditText) findViewById(C3801R.C3805id.et_phone);
        this.f14787m = (MyGridView) findViewById(C3801R.C3805id.gv_images);
        this.f14788n = (Button) findViewById(C3801R.C3805id.bt_commit);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
