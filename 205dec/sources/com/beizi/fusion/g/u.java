package com.beizi.fusion.g;

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
import com.beizi.fusion.R;
import com.beizi.fusion.g.v;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DownloadApkConfirmDialog.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class u extends Dialog implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f14969a;

    /* renamed from: b  reason: collision with root package name */
    private int f14970b;

    /* renamed from: c  reason: collision with root package name */
    private DownloadConfirmCallBack f14971c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f14972d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f14973e;

    /* renamed from: f  reason: collision with root package name */
    private Button f14974f;

    /* renamed from: g  reason: collision with root package name */
    private ViewGroup f14975g;

    /* renamed from: h  reason: collision with root package name */
    private ProgressBar f14976h;

    /* renamed from: i  reason: collision with root package name */
    private Button f14977i;

    /* renamed from: j  reason: collision with root package name */
    private String f14978j;

    public u(Context context, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        super(context, R.style.DownloadConfirmDialogFullScreen);
        this.f14969a = context;
        this.f14971c = downloadConfirmCallBack;
        this.f14978j = str;
        this.f14970b = context.getResources().getConfiguration().orientation;
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        b();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        DownloadConfirmCallBack downloadConfirmCallBack = this.f14971c;
        if (downloadConfirmCallBack != null) {
            downloadConfirmCallBack.onCancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f14973e) {
            DownloadConfirmCallBack downloadConfirmCallBack = this.f14971c;
            if (downloadConfirmCallBack != null) {
                downloadConfirmCallBack.onCancel();
            }
            dismiss();
        } else if (view == this.f14974f) {
            DownloadConfirmCallBack downloadConfirmCallBack2 = this.f14971c;
            if (downloadConfirmCallBack2 != null) {
                downloadConfirmCallBack2.onConfirm();
            }
            dismiss();
        } else if (view == this.f14977i) {
            a(this.f14978j);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        int o4 = aw.o(this.f14969a);
        int n4 = aw.n(this.f14969a);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i4 = this.f14970b;
        if (i4 == 1) {
            attributes.width = -1;
            double d4 = o4;
            Double.isNaN(d4);
            attributes.height = (int) (d4 * 0.6d);
            attributes.gravity = 80;
            attributes.windowAnimations = R.style.DownloadConfirmDialogAnimationUp;
        } else if (i4 == 2) {
            double d5 = n4;
            Double.isNaN(d5);
            attributes.width = (int) (d5 * 0.5d);
            attributes.height = -1;
            attributes.gravity = 5;
            attributes.windowAnimations = R.style.DownloadConfirmDialogAnimationRight;
        }
        attributes.dimAmount = 0.5f;
        window.setAttributes(attributes);
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.beizi.fusion.g.u.2
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                try {
                    u.this.getWindow().setWindowAnimations(0);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        try {
            a(this.f14978j);
        } catch (Exception e4) {
            Log.e("BeiZis", "load error url:" + this.f14978j, e4);
        }
    }

    private void b() {
        setContentView(R.layout.download_confirm_dialog);
        View findViewById = findViewById(R.id.download_confirm_root);
        int i4 = this.f14970b;
        if (i4 == 1) {
            findViewById.setBackgroundResource(R.drawable.download_confirm_background_portrait);
        } else if (i4 == 2) {
            findViewById.setBackgroundResource(R.drawable.download_confirm_background_landscape);
        }
        ImageView imageView = (ImageView) findViewById(R.id.download_confirm_close);
        this.f14973e = imageView;
        imageView.setOnClickListener(this);
        Button button = (Button) findViewById(R.id.download_confirm_reload_button);
        this.f14977i = button;
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.download_confirm_confirm);
        this.f14974f = button2;
        button2.setOnClickListener(this);
        this.f14976h = (ProgressBar) findViewById(R.id.download_confirm_progress_bar);
        this.f14975g = (ViewGroup) findViewById(R.id.download_confirm_content);
        c();
    }

    private void c() {
        this.f14972d = new TextView(this.f14969a);
        ScrollView scrollView = new ScrollView(this.f14969a);
        scrollView.addView(this.f14972d);
        ((FrameLayout) findViewById(R.id.download_confirm_holder)).addView(scrollView);
    }

    public void a() {
        this.f14974f.setText("\u7acb\u5373\u5b89\u88c5");
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f14976h.setVisibility(8);
            this.f14975g.setVisibility(8);
            this.f14977i.setVisibility(0);
            this.f14977i.setText("\u62b1\u6b49\uff0c\u5e94\u7528\u4fe1\u606f\u83b7\u53d6\u5931\u8d25");
            this.f14977i.setEnabled(false);
            return;
        }
        new ah() { // from class: com.beizi.fusion.g.u.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(String str2) {
                try {
                    u.this.f14976h.setVisibility(8);
                    u.this.f14977i.setVisibility(8);
                    u.this.f14975g.setVisibility(0);
                    v.a b4 = v.b(str2);
                    if (b4 == null) {
                        u.this.f14976h.setVisibility(8);
                        u.this.f14977i.setVisibility(0);
                        u.this.f14975g.setVisibility(8);
                        return;
                    }
                    u.this.f14972d.append("icon\u94fe\u63a5:\n");
                    u.this.f14972d.append(b4.f14986a);
                    u.this.f14972d.append("\n\u5e94\u7528\u540d:\n");
                    TextView textView = u.this.f14972d;
                    textView.append("\t" + b4.f14987b);
                    u.this.f14972d.append("\n\u5e94\u7528\u7248\u672c:\n");
                    TextView textView2 = u.this.f14972d;
                    textView2.append("\t" + b4.f14988c);
                    u.this.f14972d.append("\n\u5f00\u53d1\u8005:\n");
                    TextView textView3 = u.this.f14972d;
                    textView3.append("\t" + b4.f14989d);
                    u.this.f14972d.append("\n\u5e94\u7528\u5927\u5c0f:\n");
                    TextView textView4 = u.this.f14972d;
                    textView4.append("\t" + u.a(b4.f14993h));
                    u.this.f14972d.append("\n\u66f4\u65b0\u65f6\u95f4:\n");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    TextView textView5 = u.this.f14972d;
                    textView5.append("\t" + simpleDateFormat.format(new Date(b4.f14992g)));
                    u.this.f14972d.append("\n\u9690\u79c1\u6761\u6b3e\u94fe\u63a5:\n");
                    u.this.f14972d.append(b4.f14991f);
                    u.this.f14972d.append("\n\u6743\u9650\u4fe1\u606f:\n");
                    List<String> list = b4.f14990e;
                    if (list != null && list.size() > 0) {
                        Iterator<String> it = b4.f14990e.iterator();
                        while (it.hasNext()) {
                            TextView textView6 = u.this.f14972d;
                            textView6.append("\t" + it.next() + "\n");
                        }
                    }
                    Linkify.addLinks(u.this.f14972d, Patterns.WEB_URL, (String) null, (Linkify.MatchFilter) null, new Linkify.TransformFilter() { // from class: com.beizi.fusion.g.u.1.1
                        @Override // android.text.util.Linkify.TransformFilter
                        public final String transformUrl(Matcher matcher, String str3) {
                            return matcher.group();
                        }
                    });
                    u.this.f14976h.setVisibility(8);
                    u.this.f14977i.setVisibility(8);
                    u.this.f14975g.setVisibility(0);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }.execute(str);
    }

    public static String a(long j4) {
        if (j4 <= 0) {
            return "0";
        }
        double d4 = j4;
        int log10 = (int) (Math.log10(d4) / Math.log10(1024.0d));
        StringBuilder sb = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.##");
        double pow = Math.pow(1024.0d, log10);
        Double.isNaN(d4);
        sb.append(decimalFormat.format(d4 / pow));
        sb.append(" ");
        sb.append(new String[]{"B", "kB", "MB", "GB", "TB"}[log10]);
        return sb.toString();
    }
}
