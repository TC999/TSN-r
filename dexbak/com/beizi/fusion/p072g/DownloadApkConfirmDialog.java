package com.beizi.fusion.p072g;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.beizi.fusion.C3025R;
import com.beizi.fusion.p072g.DownloadConfirmHelper;
import com.p518qq.p519e.comm.compliance.DownloadConfirmCallBack;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

/* renamed from: com.beizi.fusion.g.u */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DownloadApkConfirmDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    private Context f11414a;

    /* renamed from: b */
    private int f11415b;

    /* renamed from: c */
    private DownloadConfirmCallBack f11416c;

    /* renamed from: d */
    private TextView f11417d;

    /* renamed from: e */
    private ImageView f11418e;

    /* renamed from: f */
    private Button f11419f;

    /* renamed from: g */
    private ViewGroup f11420g;

    /* renamed from: h */
    private ProgressBar f11421h;

    /* renamed from: i */
    private Button f11422i;

    /* renamed from: j */
    private String f11423j;

    public DownloadApkConfirmDialog(Context context, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        super(context, C3025R.C3031style.DownloadConfirmDialogFullScreen);
        this.f11414a = context;
        this.f11416c = downloadConfirmCallBack;
        this.f11423j = str;
        this.f11415b = context.getResources().getConfiguration().orientation;
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        m48208b();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        DownloadConfirmCallBack downloadConfirmCallBack = this.f11416c;
        if (downloadConfirmCallBack != null) {
            downloadConfirmCallBack.onCancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f11418e) {
            DownloadConfirmCallBack downloadConfirmCallBack = this.f11416c;
            if (downloadConfirmCallBack != null) {
                downloadConfirmCallBack.onCancel();
            }
            dismiss();
        } else if (view == this.f11419f) {
            DownloadConfirmCallBack downloadConfirmCallBack2 = this.f11416c;
            if (downloadConfirmCallBack2 != null) {
                downloadConfirmCallBack2.onConfirm();
            }
            dismiss();
        } else if (view == this.f11422i) {
            m48209a(this.f11423j);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        int m48283o = C3138av.m48283o(this.f11414a);
        int m48284n = C3138av.m48284n(this.f11414a);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i = this.f11415b;
        if (i == 1) {
            attributes.width = -1;
            double d = m48283o;
            Double.isNaN(d);
            attributes.height = (int) (d * 0.6d);
            attributes.gravity = 80;
            attributes.windowAnimations = C3025R.C3031style.DownloadConfirmDialogAnimationUp;
        } else if (i == 2) {
            double d2 = m48284n;
            Double.isNaN(d2);
            attributes.width = (int) (d2 * 0.5d);
            attributes.height = -1;
            attributes.gravity = 5;
            attributes.windowAnimations = C3025R.C3031style.DownloadConfirmDialogAnimationRight;
        }
        attributes.dimAmount = 0.5f;
        window.setAttributes(attributes);
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.beizi.fusion.g.u.2
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                try {
                    DownloadApkConfirmDialog.this.getWindow().setWindowAnimations(0);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        try {
            m48209a(this.f11423j);
        } catch (Exception e) {
            Log.e("BeiZis", "load error url:" + this.f11423j, e);
        }
    }

    /* renamed from: b */
    private void m48208b() {
        setContentView(C3025R.C3029layout.download_confirm_dialog);
        View findViewById = findViewById(C3025R.C3028id.download_confirm_root);
        int i = this.f11415b;
        if (i == 1) {
            findViewById.setBackgroundResource(C3025R.C3027drawable.download_confirm_background_portrait);
        } else if (i == 2) {
            findViewById.setBackgroundResource(C3025R.C3027drawable.download_confirm_background_landscape);
        }
        ImageView imageView = (ImageView) findViewById(C3025R.C3028id.download_confirm_close);
        this.f11418e = imageView;
        imageView.setOnClickListener(this);
        Button button = (Button) findViewById(C3025R.C3028id.download_confirm_reload_button);
        this.f11422i = button;
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(C3025R.C3028id.download_confirm_confirm);
        this.f11419f = button2;
        button2.setOnClickListener(this);
        this.f11421h = (ProgressBar) findViewById(C3025R.C3028id.download_confirm_progress_bar);
        this.f11420g = (ViewGroup) findViewById(C3025R.C3028id.download_confirm_content);
        m48206c();
    }

    /* renamed from: c */
    private void m48206c() {
        this.f11417d = new TextView(this.f11414a);
        ScrollView scrollView = new ScrollView(this.f11414a);
        scrollView.addView(this.f11417d);
        ((FrameLayout) findViewById(C3025R.C3028id.download_confirm_holder)).addView(scrollView);
    }

    /* renamed from: a */
    public void m48212a() {
        this.f11419f.setText("立即安装");
    }

    /* renamed from: a */
    private void m48209a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f11421h.setVisibility(8);
            this.f11420g.setVisibility(8);
            this.f11422i.setVisibility(0);
            this.f11422i.setText("抱歉，应用信息获取失败");
            this.f11422i.setEnabled(false);
            return;
        }
        new NetworkRequestAsyncTask() { // from class: com.beizi.fusion.g.u.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(String str2) {
                try {
                    DownloadApkConfirmDialog.this.f11421h.setVisibility(8);
                    DownloadApkConfirmDialog.this.f11422i.setVisibility(8);
                    DownloadApkConfirmDialog.this.f11420g.setVisibility(0);
                    DownloadConfirmHelper.C3167a m48201b = DownloadConfirmHelper.m48201b(str2);
                    if (m48201b == null) {
                        DownloadApkConfirmDialog.this.f11421h.setVisibility(8);
                        DownloadApkConfirmDialog.this.f11422i.setVisibility(0);
                        DownloadApkConfirmDialog.this.f11420g.setVisibility(8);
                        return;
                    }
                    DownloadApkConfirmDialog.this.f11417d.append("icon链接:\n");
                    DownloadApkConfirmDialog.this.f11417d.append(m48201b.f11431a);
                    DownloadApkConfirmDialog.this.f11417d.append("\n应用名:\n");
                    TextView textView = DownloadApkConfirmDialog.this.f11417d;
                    textView.append("\t" + m48201b.f11432b);
                    DownloadApkConfirmDialog.this.f11417d.append("\n应用版本:\n");
                    TextView textView2 = DownloadApkConfirmDialog.this.f11417d;
                    textView2.append("\t" + m48201b.f11433c);
                    DownloadApkConfirmDialog.this.f11417d.append("\n开发者:\n");
                    TextView textView3 = DownloadApkConfirmDialog.this.f11417d;
                    textView3.append("\t" + m48201b.f11434d);
                    DownloadApkConfirmDialog.this.f11417d.append("\n应用大小:\n");
                    TextView textView4 = DownloadApkConfirmDialog.this.f11417d;
                    textView4.append("\t" + DownloadApkConfirmDialog.m48211a(m48201b.f11438h));
                    DownloadApkConfirmDialog.this.f11417d.append("\n更新时间:\n");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    TextView textView5 = DownloadApkConfirmDialog.this.f11417d;
                    textView5.append("\t" + simpleDateFormat.format(new Date(m48201b.f11437g)));
                    DownloadApkConfirmDialog.this.f11417d.append("\n隐私条款链接:\n");
                    DownloadApkConfirmDialog.this.f11417d.append(m48201b.f11436f);
                    DownloadApkConfirmDialog.this.f11417d.append("\n权限信息:\n");
                    List<String> list = m48201b.f11435e;
                    if (list != null && list.size() > 0) {
                        Iterator<String> it = m48201b.f11435e.iterator();
                        while (it.hasNext()) {
                            TextView textView6 = DownloadApkConfirmDialog.this.f11417d;
                            textView6.append("\t" + it.next() + ShellAdbUtils.f33810d);
                        }
                    }
                    Linkify.addLinks(DownloadApkConfirmDialog.this.f11417d, Patterns.WEB_URL, (String) null, (Linkify.MatchFilter) null, new Linkify.TransformFilter() { // from class: com.beizi.fusion.g.u.1.1
                        @Override // android.text.util.Linkify.TransformFilter
                        public final String transformUrl(Matcher matcher, String str3) {
                            return matcher.group();
                        }
                    });
                    DownloadApkConfirmDialog.this.f11421h.setVisibility(8);
                    DownloadApkConfirmDialog.this.f11422i.setVisibility(8);
                    DownloadApkConfirmDialog.this.f11420g.setVisibility(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.execute(str);
    }

    /* renamed from: a */
    public static String m48211a(long j) {
        if (j <= 0) {
            return "0";
        }
        double d = j;
        int log10 = (int) (Math.log10(d) / Math.log10(1024.0d));
        StringBuilder sb = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.##");
        double pow = Math.pow(1024.0d, log10);
        Double.isNaN(d);
        sb.append(decimalFormat.format(d / pow));
        sb.append(" ");
        sb.append(new String[]{"B", "kB", "MB", "GB", "TB"}[log10]);
        return sb.toString();
    }
}
