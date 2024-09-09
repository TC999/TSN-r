package com.bxkj.student.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.bxkj.student.common.utils.d;
import com.bxkj.student.common.versionupdate.a;
import com.bxkj.student.personal.password.UpdatePasswordActivity;
import com.bxkj.student.personal.password.forget.FindPasswordTypeActivity;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SystemSetActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private LinearLayout f22023k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayout f22024l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f22025m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f22026n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f22027o;

    /* renamed from: p  reason: collision with root package name */
    private LinearLayout f22028p;

    /* renamed from: q  reason: collision with root package name */
    private LinearLayout f22029q;

    /* renamed from: r  reason: collision with root package name */
    private LinearLayout f22030r;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.bxkj.student.common.versionupdate.a f22031a;

        a(final com.bxkj.student.common.versionupdate.a val$versionUpdate) {
            this.f22031a = val$versionUpdate;
        }

        @Override // com.bxkj.student.common.versionupdate.a.d
        public void a(boolean hasNewVersion, String versionName, String downLoadUrl, String instruction) {
            if (hasNewVersion) {
                this.f22031a.d(versionName, downLoadUrl, instruction);
            } else {
                new iOSOneButtonDialog(((BaseActivity) SystemSetActivity.this).f1656h).setMessage("\u5f53\u524d\u5df2\u662f\u6700\u65b0\u7248\u672c").show();
            }
        }

        @Override // com.bxkj.student.common.versionupdate.a.d
        public void b() {
        }
    }

    public static long j0(File dir) {
        File[] listFiles;
        long j02;
        long j4 = 0;
        if (dir != null && dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                if (file.isFile()) {
                    j02 = file.length();
                } else if (file.isDirectory()) {
                    j4 += file.length();
                    j02 = j0(file);
                }
                j4 += j02;
            }
            return j4;
        }
        return 0L;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22025m.setOnClickListener(this);
        this.f22029q.setOnClickListener(this);
        this.f22030r.setOnClickListener(this);
        this.f22028p.setOnClickListener(this);
        this.f22023k.setOnClickListener(this);
        this.f22024l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427499;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        TextView textView = this.f22027o;
        textView.setText("v" + k0());
        try {
            this.f22026n.setText(d.k(this.f1656h));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7cfb\u7edf\u8bbe\u7f6e");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22023k = (LinearLayout) findViewById(2131232185);
        this.f22024l = (LinearLayout) findViewById(2131232190);
        this.f22025m = (LinearLayout) findViewById(2131232176);
        this.f22026n = (TextView) findViewById(2131232890);
        this.f22027o = (TextView) findViewById(2131233222);
        this.f22028p = (LinearLayout) findViewById(2131232196);
        this.f22029q = (LinearLayout) findViewById(2131232233);
        this.f22030r = (LinearLayout) findViewById(2131232161);
    }

    public String k0() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Exception e4) {
            e4.printStackTrace();
            return "1.0";
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        switch (v3.getId()) {
            case 2131232161:
                startActivity(new Intent(this.f1656h, AboutUsActivity.class));
                return;
            case 2131232176:
                d.g(this.f1656h);
                new iOSOneButtonDialog(this.f1656h).setMessage("\u7f13\u5b58\u6e05\u9664\u6210\u529f").show();
                return;
            case 2131232185:
                startActivity(new Intent(this.f1656h, UpdatePasswordActivity.class));
                return;
            case 2131232190:
                startActivity(new Intent(this.f1656h, FindPasswordTypeActivity.class));
                return;
            case 2131232196:
                startActivity(new Intent(this.f1656h, HelpCenterListActivity.class));
                return;
            case 2131232233:
                com.bxkj.student.common.versionupdate.a aVar = new com.bxkj.student.common.versionupdate.a(this.f1656h);
                aVar.b(new a(aVar));
                return;
            default:
                return;
        }
    }
}
