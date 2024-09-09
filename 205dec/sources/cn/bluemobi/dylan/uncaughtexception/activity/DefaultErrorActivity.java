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
import cat.ereza.customactivityoncrash.R;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class DefaultErrorActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private View f2001a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f2002a;

        a(Class cls) {
            this.f2002a = cls;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            cn.bluemobi.dylan.uncaughtexception.a.Y(DefaultErrorActivity.this, new Intent(DefaultErrorActivity.this, this.f2002a));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            cn.bluemobi.dylan.uncaughtexception.a.u(DefaultErrorActivity.this);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class c implements View.OnClickListener {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                DefaultErrorActivity.this.c();
                Toast.makeText(DefaultErrorActivity.this, R.string.customactivityoncrash_error_activity_error_details_copied, 0).show();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        class b implements DialogInterface.OnClickListener {

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
            /* loaded from: E:\TSN-r\205dec\6329136.dex */
            class a extends Thread {
                a() {
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    super.run();
                    if (!TextUtils.isEmpty(cn.bluemobi.dylan.uncaughtexception.a.D())) {
                        String D = cn.bluemobi.dylan.uncaughtexception.a.D();
                        StringBuilder sb = new StringBuilder();
                        sb.append("{ \"msgtype\": \"text\", \"text\": {\"content\": \"");
                        DefaultErrorActivity defaultErrorActivity = DefaultErrorActivity.this;
                        sb.append(cn.bluemobi.dylan.uncaughtexception.a.w(defaultErrorActivity, defaultErrorActivity.getIntent()));
                        sb.append("\"}}");
                        DefaultErrorActivity.this.e(D, sb.toString());
                    }
                    String y3 = cn.bluemobi.dylan.uncaughtexception.a.y(DefaultErrorActivity.this);
                    DefaultErrorActivity defaultErrorActivity2 = DefaultErrorActivity.this;
                    d.b.a(y3, cn.bluemobi.dylan.uncaughtexception.a.w(defaultErrorActivity2, defaultErrorActivity2.getIntent()));
                }
            }

            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                new a().start();
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog.Builder title = new AlertDialog.Builder(DefaultErrorActivity.this).setTitle(R.string.customactivityoncrash_error_activity_error_details_title);
            DefaultErrorActivity defaultErrorActivity = DefaultErrorActivity.this;
            ((TextView) title.setMessage(cn.bluemobi.dylan.uncaughtexception.a.w(defaultErrorActivity, defaultErrorActivity.getIntent())).setPositiveButton(R.string.customactivityoncrash_error_activity_error_details_close, (DialogInterface.OnClickListener) null).setNegativeButton(R.string.report_to_developer, new b()).setNeutralButton(R.string.customactivityoncrash_error_activity_error_details_copy, new a()).show().findViewById(16908299)).setTextSize(0, DefaultErrorActivity.this.getResources().getDimension(R.dimen.customactivityoncrash_error_activity_error_details_text_size));
        }
    }

    static {
        StubApp.interface11(3719);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(getString(R.string.customactivityoncrash_error_activity_error_details_clipboard_label), cn.bluemobi.dylan.uncaughtexception.a.w(this, getIntent())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, String str2) {
        try {
            PrintStream printStream = System.out;
            printStream.println("Post\u65b9\u5f0f\u8bf7\u6c42\u5730\u5740httpUrl--->" + str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(str2.getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            if (httpURLConnection.getResponseCode() == 200) {
                String f4 = f(httpURLConnection.getInputStream());
                PrintStream printStream2 = System.out;
                printStream2.println("Post\u65b9\u5f0f\u8bf7\u6c42\u6210\u529f\uff0cresult--->" + f4);
            } else {
                System.out.println("Post\u65b9\u5f0f\u8bf7\u6c42\u5931\u8d25");
            }
            httpURLConnection.disconnect();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    protected AlertDialog.Builder d(Context context) {
        LayoutInflater layoutInflater = getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View inflate = layoutInflater.inflate(R.layout.customview, (ViewGroup) null);
        this.f2001a = inflate;
        return builder.setView(inflate);
    }

    public String f(InputStream inputStream) {
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
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);
}
