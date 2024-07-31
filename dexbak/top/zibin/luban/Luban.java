package top.zibin.luban;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.IOException;

/* renamed from: top.zibin.luban.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Luban implements Handler.Callback {

    /* renamed from: d */
    private static final String f47112d = "Luban";

    /* renamed from: e */
    private static final String f47113e = "luban_disk_cache";

    /* renamed from: f */
    private static final int f47114f = 0;

    /* renamed from: g */
    private static final int f47115g = 1;

    /* renamed from: h */
    private static final int f47116h = 2;

    /* renamed from: a */
    private File f47117a;

    /* renamed from: b */
    private OnCompressListener f47118b;

    /* renamed from: c */
    private Handler f47119c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Luban.java */
    /* renamed from: top.zibin.luban.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class RunnableC16203a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f47120a;

        RunnableC16203a(Context context) {
            this.f47120a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Luban.this.f47119c.sendMessage(Luban.this.f47119c.obtainMessage(1));
                Luban.this.f47119c.sendMessage(Luban.this.f47119c.obtainMessage(0, new C16202b(Luban.this.f47117a, Luban.this.m290i(this.f47120a)).m302a()));
            } catch (IOException e) {
                Luban.this.f47119c.sendMessage(Luban.this.f47119c.obtainMessage(2, e));
            }
        }
    }

    /* compiled from: Luban.java */
    /* renamed from: top.zibin.luban.c$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16204b {

        /* renamed from: a */
        private Context f47122a;

        /* renamed from: b */
        private File f47123b;

        /* renamed from: c */
        private OnCompressListener f47124c;

        C16204b(Context context) {
            this.f47122a = context;
        }

        /* renamed from: c */
        private Luban m285c() {
            return new Luban(this, null);
        }

        /* renamed from: d */
        public File m284d() throws IOException {
            return m285c().m293f(this.f47122a);
        }

        /* renamed from: e */
        public void m283e() {
            m285c().m289j(this.f47122a);
        }

        /* renamed from: f */
        public C16204b m282f(File file) {
            this.f47123b = file;
            return this;
        }

        /* renamed from: g */
        public C16204b m281g(int i) {
            return this;
        }

        /* renamed from: h */
        public C16204b m280h(OnCompressListener onCompressListener) {
            this.f47124c = onCompressListener;
            return this;
        }
    }

    /* synthetic */ Luban(C16204b c16204b, RunnableC16203a runnableC16203a) {
        this(c16204b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* renamed from: f */
    public File m293f(Context context) throws IOException {
        return new C16202b(this.f47117a, m290i(context)).m302a();
    }

    @Nullable
    /* renamed from: g */
    private File m292g(Context context) {
        return m291h(context, f47113e);
    }

    @Nullable
    /* renamed from: h */
    private File m291h(Context context, String str) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            File file = new File(externalCacheDir, str);
            if (file.mkdirs() || (file.exists() && file.isDirectory())) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable(f47112d, 6)) {
            Log.e(f47112d, "default disk cache dir is null");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public File m290i(Context context) {
        if (m292g(context) != null) {
            return new File(m292g(context) + "/" + System.currentTimeMillis() + ((int) (Math.random() * 1000.0d)) + ".jpg");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    /* renamed from: j */
    public void m289j(Context context) {
        OnCompressListener onCompressListener;
        if (this.f47117a == null && (onCompressListener = this.f47118b) != null) {
            onCompressListener.onError(new NullPointerException("image file cannot be null"));
        }
        new Thread(new RunnableC16203a(context)).start();
    }

    /* renamed from: k */
    public static C16204b m288k(Context context) {
        return new C16204b(context);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        OnCompressListener onCompressListener = this.f47118b;
        if (onCompressListener == null) {
            return false;
        }
        int i = message.what;
        if (i == 0) {
            onCompressListener.onSuccess((File) message.obj);
        } else if (i == 1) {
            onCompressListener.onStart();
        } else if (i == 2) {
            onCompressListener.onError((Throwable) message.obj);
        }
        return false;
    }

    private Luban(C16204b c16204b) {
        this.f47117a = c16204b.f47123b;
        this.f47118b = c16204b.f47124c;
        this.f47119c = new Handler(Looper.getMainLooper(), this);
    }
}
