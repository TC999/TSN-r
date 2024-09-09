package top.zibin.luban;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: Luban.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class c implements Handler.Callback {

    /* renamed from: d  reason: collision with root package name */
    private static final String f64388d = "Luban";

    /* renamed from: e  reason: collision with root package name */
    private static final String f64389e = "luban_disk_cache";

    /* renamed from: f  reason: collision with root package name */
    private static final int f64390f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static final int f64391g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final int f64392h = 2;

    /* renamed from: a  reason: collision with root package name */
    private File f64393a;

    /* renamed from: b  reason: collision with root package name */
    private d f64394b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f64395c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: Luban.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f64396a;

        a(Context context) {
            this.f64396a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.this.f64395c.sendMessage(c.this.f64395c.obtainMessage(1));
                c.this.f64395c.sendMessage(c.this.f64395c.obtainMessage(0, new top.zibin.luban.b(c.this.f64393a, c.this.i(this.f64396a)).a()));
            } catch (IOException e4) {
                c.this.f64395c.sendMessage(c.this.f64395c.obtainMessage(2, e4));
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: Luban.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private Context f64398a;

        /* renamed from: b  reason: collision with root package name */
        private File f64399b;

        /* renamed from: c  reason: collision with root package name */
        private d f64400c;

        b(Context context) {
            this.f64398a = context;
        }

        private c c() {
            return new c(this, null);
        }

        public File d() throws IOException {
            return c().f(this.f64398a);
        }

        public void e() {
            c().j(this.f64398a);
        }

        public b f(File file) {
            this.f64399b = file;
            return this;
        }

        public b g(int i4) {
            return this;
        }

        public b h(d dVar) {
            this.f64400c = dVar;
            return this;
        }
    }

    /* synthetic */ c(b bVar, a aVar) {
        this(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public File f(Context context) throws IOException {
        return new top.zibin.luban.b(this.f64393a, i(context)).a();
    }

    @Nullable
    private File g(Context context) {
        return h(context, "luban_disk_cache");
    }

    @Nullable
    private File h(Context context, String str) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            File file = new File(externalCacheDir, str);
            if (file.mkdirs() || (file.exists() && file.isDirectory())) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable("Luban", 6)) {
            Log.e("Luban", "default disk cache dir is null");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File i(Context context) {
        if (g(context) != null) {
            return new File(g(context) + TTPathConst.sSeparator + System.currentTimeMillis() + ((int) (Math.random() * 1000.0d)) + ".jpg");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void j(Context context) {
        d dVar;
        if (this.f64393a == null && (dVar = this.f64394b) != null) {
            dVar.onError(new NullPointerException("image file cannot be null"));
        }
        new Thread(new a(context)).start();
    }

    public static b k(Context context) {
        return new b(context);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        d dVar = this.f64394b;
        if (dVar == null) {
            return false;
        }
        int i4 = message.what;
        if (i4 == 0) {
            dVar.onSuccess((File) message.obj);
        } else if (i4 == 1) {
            dVar.onStart();
        } else if (i4 == 2) {
            dVar.onError((Throwable) message.obj);
        }
        return false;
    }

    private c(b bVar) {
        this.f64393a = bVar.f64399b;
        this.f64394b = bVar.f64400c;
        this.f64395c = new Handler(Looper.getMainLooper(), this);
    }
}
