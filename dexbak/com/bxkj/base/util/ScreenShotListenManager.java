package com.bxkj.base.util;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bxkj.base.util.x */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ScreenShotListenManager {

    /* renamed from: h */
    private static final String f14951h = "ScreenShotListenManager";

    /* renamed from: i */
    private static final String[] f14952i = {"_data", "datetaken"};

    /* renamed from: j */
    private static final String[] f14953j = {"_data", "datetaken", "width", "height"};

    /* renamed from: k */
    private static final String[] f14954k = {"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};

    /* renamed from: l */
    private static Point f14955l;

    /* renamed from: b */
    private Context f14957b;

    /* renamed from: c */
    private InterfaceC3918b f14958c;

    /* renamed from: d */
    private long f14959d;

    /* renamed from: e */
    private C3917a f14960e;

    /* renamed from: f */
    private C3917a f14961f;

    /* renamed from: a */
    private final List<String> f14956a = new ArrayList();

    /* renamed from: g */
    private final Handler f14962g = new Handler(Looper.getMainLooper());

    /* compiled from: ScreenShotListenManager.java */
    /* renamed from: com.bxkj.base.util.x$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class C3917a extends ContentObserver {

        /* renamed from: a */
        private Uri f14963a;

        public C3917a(Uri uri, Handler handler) {
            super(handler);
            this.f14963a = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            ScreenShotListenManager.this.m44013g(this.f14963a);
        }
    }

    /* compiled from: ScreenShotListenManager.java */
    /* renamed from: com.bxkj.base.util.x$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3918b {
        /* renamed from: a */
        void m44007a(String str);
    }

    private ScreenShotListenManager(Context context) {
        if (context != null) {
            this.f14957b = context;
            if (f14955l == null) {
                Point m44014f = m44014f();
                f14955l = m44014f;
                if (m44014f != null) {
                    Log.d(f14951h, "Screen Real Size: " + f14955l.x + " * " + f14955l.y);
                    return;
                }
                Log.w(f14951h, "Get screen real size failed.");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The context must not be null.");
    }

    /* renamed from: b */
    private static void m44018b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String str = null;
            if (stackTrace != null && stackTrace.length >= 4) {
                str = stackTrace[3].toString();
            }
            throw new IllegalStateException("Call the method must be in main thread: " + str);
        }
    }

    /* renamed from: c */
    private boolean m44017c(String str) {
        if (this.f14956a.contains(str)) {
            return true;
        }
        if (this.f14956a.size() >= 20) {
            for (int i = 0; i < 5; i++) {
                this.f14956a.remove(0);
            }
        }
        this.f14956a.add(str);
        return false;
    }

    /* renamed from: d */
    private boolean m44016d(String str, long j, int i, int i2) {
        Point point;
        int i3;
        if (j < this.f14959d || System.currentTimeMillis() - j > 10000 || (((point = f14955l) != null && ((i > (i3 = point.x) || i2 > point.y) && (i2 > i3 || i > point.y))) || TextUtils.isEmpty(str))) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String str2 : f14954k) {
            if (lowerCase.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    private Point m44015e(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new Point(options.outWidth, options.outHeight);
    }

    /* renamed from: f */
    private Point m44014f() {
        Point point;
        Exception e;
        try {
            point = new Point();
            try {
                ((WindowManager) this.f14957b.getSystemService("window")).getDefaultDisplay().getRealSize(point);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return point;
            }
        } catch (Exception e3) {
            point = null;
            e = e3;
        }
        return point;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m44013g(Uri uri) {
        int i;
        int i2;
        Cursor cursor = null;
        try {
            try {
                cursor = this.f14957b.getContentResolver().query(uri, f14953j, null, null, "date_added desc limit 1");
            } catch (Exception e) {
                e.printStackTrace();
                if (0 == 0 || cursor.isClosed()) {
                    return;
                }
            }
            if (cursor == null) {
                Log.e(f14951h, "Deviant logic.");
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } else if (!cursor.moveToFirst()) {
                Log.d(f14951h, "Cursor no data.");
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } else {
                int columnIndex = cursor.getColumnIndex("_data");
                int columnIndex2 = cursor.getColumnIndex("datetaken");
                int columnIndex3 = cursor.getColumnIndex("width");
                int columnIndex4 = cursor.getColumnIndex("height");
                String string = cursor.getString(columnIndex);
                long j = cursor.getLong(columnIndex2);
                if (columnIndex3 >= 0 && columnIndex4 >= 0) {
                    i2 = cursor.getInt(columnIndex3);
                    i = cursor.getInt(columnIndex4);
                } else {
                    Point m44015e = m44015e(string);
                    int i3 = m44015e.x;
                    i = m44015e.y;
                    i2 = i3;
                }
                m44012h(string, j, i2, i);
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0 && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: h */
    private void m44012h(String str, long j, int i, int i2) {
        if (m44016d(str, j, i, i2)) {
            Log.d(f14951h, "ScreenShot: path = " + str + "; size = " + i + " * " + i2 + "; date = " + j);
            if (this.f14958c == null || m44017c(str)) {
                return;
            }
            this.f14958c.m44007a(str);
            return;
        }
        Log.w(f14951h, "Media content changed, but not screenshot: path = " + str + "; size = " + i + " * " + i2 + "; date = " + j);
    }

    /* renamed from: i */
    public static ScreenShotListenManager m44011i(Context context) {
        m44018b();
        return new ScreenShotListenManager(context);
    }

    /* renamed from: j */
    public void m44010j(InterfaceC3918b interfaceC3918b) {
        this.f14958c = interfaceC3918b;
    }

    /* renamed from: k */
    public void m44009k() {
        m44018b();
        this.f14956a.clear();
        this.f14959d = System.currentTimeMillis();
        this.f14960e = new C3917a(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.f14962g);
        this.f14961f = new C3917a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.f14962g);
        this.f14957b.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.f14960e);
        this.f14957b.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.f14961f);
    }

    /* renamed from: l */
    public void m44008l() {
        m44018b();
        if (this.f14960e != null) {
            try {
                this.f14957b.getContentResolver().unregisterContentObserver(this.f14960e);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f14960e = null;
        }
        if (this.f14961f != null) {
            try {
                this.f14957b.getContentResolver().unregisterContentObserver(this.f14961f);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f14961f = null;
        }
        this.f14959d = 0L;
        this.f14956a.clear();
    }
}
