package cn.bluemobi.dylan.uncaughtexception.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import cat.ereza.customactivityoncrash.C1085R;
import cn.bluemobi.dylan.uncaughtexception.CustomActivityOnCrash;
import com.baidu.mobads.sdk.internal.C2594an;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import p588f.ReportByEmail;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class DefaultErrorActivity extends Activity {

    /* renamed from: a */
    private View f2024a;

    /* renamed from: cn.bluemobi.dylan.uncaughtexception.activity.DefaultErrorActivity$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class View$OnClickListenerC1233a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Class f2025a;

        View$OnClickListenerC1233a(Class cls) {
            this.f2025a = cls;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CustomActivityOnCrash.m57419Y(DefaultErrorActivity.this, new Intent(DefaultErrorActivity.this, this.f2025a));
        }
    }

    /* renamed from: cn.bluemobi.dylan.uncaughtexception.activity.DefaultErrorActivity$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class View$OnClickListenerC1234b implements View.OnClickListener {
        View$OnClickListenerC1234b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CustomActivityOnCrash.m57388u(DefaultErrorActivity.this);
        }
    }

    /* renamed from: cn.bluemobi.dylan.uncaughtexception.activity.DefaultErrorActivity$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class View$OnClickListenerC1235c implements View.OnClickListener {

        /* renamed from: cn.bluemobi.dylan.uncaughtexception.activity.DefaultErrorActivity$c$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        class DialogInterface$OnClickListenerC1236a implements DialogInterface.OnClickListener {
            DialogInterface$OnClickListenerC1236a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                DefaultErrorActivity.this.m57380c();
                Toast.makeText(DefaultErrorActivity.this, C1085R.C1090string.customactivityoncrash_error_activity_error_details_copied, 0).show();
            }
        }

        /* renamed from: cn.bluemobi.dylan.uncaughtexception.activity.DefaultErrorActivity$c$b */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        class DialogInterface$OnClickListenerC1237b implements DialogInterface.OnClickListener {

            /* renamed from: cn.bluemobi.dylan.uncaughtexception.activity.DefaultErrorActivity$c$b$a */
            /* loaded from: E:\fuckcool\tsn\6276784.dex */
            class C1238a extends Thread {
                C1238a() {
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    super.run();
                    if (!TextUtils.isEmpty(CustomActivityOnCrash.m57440D())) {
                        String m57440D = CustomActivityOnCrash.m57440D();
                        StringBuilder sb = new StringBuilder();
                        sb.append("{ \"msgtype\": \"text\", \"text\": {\"content\": \"");
                        DefaultErrorActivity defaultErrorActivity = DefaultErrorActivity.this;
                        sb.append(CustomActivityOnCrash.m57386w(defaultErrorActivity, defaultErrorActivity.getIntent()));
                        sb.append("\"}}");
                        DefaultErrorActivity.this.m57378e(m57440D, sb.toString());
                    }
                    String m57384y = CustomActivityOnCrash.m57384y(DefaultErrorActivity.this);
                    DefaultErrorActivity defaultErrorActivity2 = DefaultErrorActivity.this;
                    ReportByEmail.m12781a(m57384y, CustomActivityOnCrash.m57386w(defaultErrorActivity2, defaultErrorActivity2.getIntent()));
                }
            }

            DialogInterface$OnClickListenerC1237b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                new C1238a().start();
            }
        }

        View$OnClickListenerC1235c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog.Builder title = new AlertDialog.Builder(DefaultErrorActivity.this).setTitle(C1085R.C1090string.customactivityoncrash_error_activity_error_details_title);
            DefaultErrorActivity defaultErrorActivity = DefaultErrorActivity.this;
            ((TextView) title.setMessage(CustomActivityOnCrash.m57386w(defaultErrorActivity, defaultErrorActivity.getIntent())).setPositiveButton(C1085R.C1090string.customactivityoncrash_error_activity_error_details_close, (DialogInterface.OnClickListener) null).setNegativeButton(C1085R.C1090string.report_to_developer, new DialogInterface$OnClickListenerC1237b()).setNeutralButton(C1085R.C1090string.customactivityoncrash_error_activity_error_details_copy, new DialogInterface$OnClickListenerC1236a()).show().findViewById(16908299)).setTextSize(0, DefaultErrorActivity.this.getResources().getDimension(C1085R.dimen.customactivityoncrash_error_activity_error_details_text_size));
        }
    }

    static {
        StubApp.interface11(4111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m57380c() {
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(getString(C1085R.C1090string.f1517x949651f5), CustomActivityOnCrash.m57386w(this, getIntent())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m57378e(String str, String str2) {
        try {
            PrintStream printStream = System.out;
            printStream.println("Post方式请求地址httpUrl--->" + str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty("Content-Type", C2594an.f8583d);
            httpURLConnection.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(str2.getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            if (httpURLConnection.getResponseCode() == 200) {
                String m57377f = m57377f(httpURLConnection.getInputStream());
                PrintStream printStream2 = System.out;
                printStream2.println("Post方式请求成功，result--->" + m57377f);
            } else {
                System.out.println("Post方式请求失败");
            }
            httpURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    protected AlertDialog.Builder m57379d(Context context) {
        LayoutInflater layoutInflater = getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View inflate = layoutInflater.inflate(C1085R.C1089layout.customview, (ViewGroup) null);
        this.f2024a = inflate;
        return builder.setView(inflate);
    }

    /* renamed from: f */
    public String m57377f(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return new String(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);
}
