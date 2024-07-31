package com.bxkj.student.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.utils.DataCleanManager;
import com.bxkj.student.common.versionupdate.VersionUpdate;
import com.bxkj.student.personal.password.UpdatePasswordActivity;
import com.bxkj.student.personal.password.forget.FindPasswordTypeActivity;
import java.io.File;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SystemSetActivity extends BaseActivity {

    /* renamed from: k */
    private LinearLayout f18723k;

    /* renamed from: l */
    private LinearLayout f18724l;

    /* renamed from: m */
    private LinearLayout f18725m;

    /* renamed from: n */
    private TextView f18726n;

    /* renamed from: o */
    private TextView f18727o;

    /* renamed from: p */
    private LinearLayout f18728p;

    /* renamed from: q */
    private LinearLayout f18729q;

    /* renamed from: r */
    private LinearLayout f18730r;

    /* renamed from: com.bxkj.student.personal.SystemSetActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5114a implements VersionUpdate.InterfaceC4268d {

        /* renamed from: a */
        final /* synthetic */ VersionUpdate f18731a;

        C5114a(final VersionUpdate val$versionUpdate) {
            this.f18731a = val$versionUpdate;
        }

        @Override // com.bxkj.student.common.versionupdate.VersionUpdate.InterfaceC4268d
        /* renamed from: a */
        public void mo38646a(boolean hasNewVersion, String versionName, String downLoadUrl, String instruction) {
            if (hasNewVersion) {
                this.f18731a.m42763d(versionName, downLoadUrl, instruction);
            } else {
                new iOSOneButtonDialog(((BaseActivity) SystemSetActivity.this).f1669h).setMessage("当前已是最新版本").show();
            }
        }

        @Override // com.bxkj.student.common.versionupdate.VersionUpdate.InterfaceC4268d
        /* renamed from: b */
        public void mo38645b() {
        }
    }

    /* renamed from: j0 */
    public static long m40571j0(File dir) {
        File[] listFiles;
        long m40571j0;
        long j = 0;
        if (dir != null && dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                if (file.isFile()) {
                    m40571j0 = file.length();
                } else if (file.isDirectory()) {
                    j += file.length();
                    m40571j0 = m40571j0(file);
                }
                j += m40571j0;
            }
            return j;
        }
        return 0L;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18725m.setOnClickListener(this);
        this.f18729q.setOnClickListener(this);
        this.f18730r.setOnClickListener(this);
        this.f18728p.setOnClickListener(this);
        this.f18723k.setOnClickListener(this);
        this.f18724l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_system_set;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        TextView textView = this.f18727o;
        textView.setText("v" + m40570k0());
        try {
            this.f18726n.setText(DataCleanManager.m42851k(this.f1669h));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("系统设置");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18723k = (LinearLayout) findViewById(C4215R.C4219id.ll_edit_password);
        this.f18724l = (LinearLayout) findViewById(C4215R.C4219id.ll_forget_password);
        this.f18725m = (LinearLayout) findViewById(C4215R.C4219id.ll_clear_cache);
        this.f18726n = (TextView) findViewById(C4215R.C4219id.tv_cache_size);
        this.f18727o = (TextView) findViewById(C4215R.C4219id.tv_version);
        this.f18728p = (LinearLayout) findViewById(C4215R.C4219id.ll_help_center);
        this.f18729q = (LinearLayout) findViewById(C4215R.C4219id.ll_version);
        this.f18730r = (LinearLayout) findViewById(C4215R.C4219id.ll_about_us);
    }

    /* renamed from: k0 */
    public String m40570k0() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "1.0";
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case C4215R.C4219id.ll_about_us /* 2131232161 */:
                startActivity(new Intent(this.f1669h, AboutUsActivity.class));
                return;
            case C4215R.C4219id.ll_clear_cache /* 2131232176 */:
                DataCleanManager.m42855g(this.f1669h);
                new iOSOneButtonDialog(this.f1669h).setMessage("缓存清除成功").show();
                return;
            case C4215R.C4219id.ll_edit_password /* 2131232185 */:
                startActivity(new Intent(this.f1669h, UpdatePasswordActivity.class));
                return;
            case C4215R.C4219id.ll_forget_password /* 2131232190 */:
                startActivity(new Intent(this.f1669h, FindPasswordTypeActivity.class));
                return;
            case C4215R.C4219id.ll_help_center /* 2131232196 */:
                startActivity(new Intent(this.f1669h, HelpCenterListActivity.class));
                return;
            case C4215R.C4219id.ll_version /* 2131232233 */:
                VersionUpdate versionUpdate = new VersionUpdate(this.f1669h);
                versionUpdate.m42765b(new C5114a(versionUpdate));
                return;
            default:
                return;
        }
    }
}
