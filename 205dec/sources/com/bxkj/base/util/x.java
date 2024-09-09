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
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ScreenShotListenManager.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class x {

    /* renamed from: h  reason: collision with root package name */
    private static final String f18435h = "ScreenShotListenManager";

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f18436i = {"_data", "datetaken"};

    /* renamed from: j  reason: collision with root package name */
    private static final String[] f18437j = {"_data", "datetaken", "width", "height"};

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f18438k = {"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};

    /* renamed from: l  reason: collision with root package name */
    private static Point f18439l;

    /* renamed from: b  reason: collision with root package name */
    private Context f18441b;

    /* renamed from: c  reason: collision with root package name */
    private b f18442c;

    /* renamed from: d  reason: collision with root package name */
    private long f18443d;

    /* renamed from: e  reason: collision with root package name */
    private a f18444e;

    /* renamed from: f  reason: collision with root package name */
    private a f18445f;

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f18440a = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final Handler f18446g = new Handler(Looper.getMainLooper());

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ScreenShotListenManager.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private class a extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        private Uri f18447a;

        public a(Uri uri, Handler handler) {
            super(handler);
            this.f18447a = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3) {
            super.onChange(z3);
            x.this.g(this.f18447a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ScreenShotListenManager.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface b {
        void a(String str);
    }

    private x(Context context) {
        if (context != null) {
            this.f18441b = context;
            if (f18439l == null) {
                Point f4 = f();
                f18439l = f4;
                if (f4 != null) {
                    Log.d("ScreenShotListenManager", "Screen Real Size: " + f18439l.x + " * " + f18439l.y);
                    return;
                }
                Log.w("ScreenShotListenManager", "Get screen real size failed.");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The context must not be null.");
    }

    private static void b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String str = null;
            if (stackTrace != null && stackTrace.length >= 4) {
                str = stackTrace[3].toString();
            }
            throw new IllegalStateException("Call the method must be in main thread: " + str);
        }
    }

    private boolean c(String str) {
        if (this.f18440a.contains(str)) {
            return true;
        }
        if (this.f18440a.size() >= 20) {
            for (int i4 = 0; i4 < 5; i4++) {
                this.f18440a.remove(0);
            }
        }
        this.f18440a.add(str);
        return false;
    }

    private boolean d(String str, long j4, int i4, int i5) {
        Point point;
        int i6;
        if (j4 < this.f18443d || System.currentTimeMillis() - j4 > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT || (((point = f18439l) != null && ((i4 > (i6 = point.x) || i5 > point.y) && (i5 > i6 || i4 > point.y))) || TextUtils.isEmpty(str))) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String str2 : f18438k) {
            if (lowerCase.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private Point e(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new Point(options.outWidth, options.outHeight);
    }

    private Point f() {
        Point point;
        Exception e4;
        try {
            point = new Point();
            try {
                ((WindowManager) this.f18441b.getSystemService("window")).getDefaultDisplay().getRealSize(point);
            } catch (Exception e5) {
                e4 = e5;
                e4.printStackTrace();
                return point;
            }
        } catch (Exception e6) {
            point = null;
            e4 = e6;
        }
        return point;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Uri uri) {
        int i4;
        int i5;
        Cursor cursor = null;
        try {
            try {
                cursor = this.f18441b.getContentResolver().query(uri, f18437j, null, null, "date_added desc limit 1");
            } catch (Exception e4) {
                e4.printStackTrace();
                if (0 == 0 || cursor.isClosed()) {
                    return;
                }
            }
            if (cursor == null) {
                Log.e("ScreenShotListenManager", "Deviant logic.");
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } else if (!cursor.moveToFirst()) {
                Log.d("ScreenShotListenManager", "Cursor no data.");
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
                long j4 = cursor.getLong(columnIndex2);
                if (columnIndex3 >= 0 && columnIndex4 >= 0) {
                    i5 = cursor.getInt(columnIndex3);
                    i4 = cursor.getInt(columnIndex4);
                } else {
                    Point e5 = e(string);
                    int i6 = e5.x;
                    i4 = e5.y;
                    i5 = i6;
                }
                h(string, j4, i5, i4);
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

    private void h(String str, long j4, int i4, int i5) {
        if (d(str, j4, i4, i5)) {
            Log.d("ScreenShotListenManager", "ScreenShot: path = " + str + "; size = " + i4 + " * " + i5 + "; date = " + j4);
            if (this.f18442c == null || c(str)) {
                return;
            }
            this.f18442c.a(str);
            return;
        }
        Log.w("ScreenShotListenManager", "Media content changed, but not screenshot: path = " + str + "; size = " + i4 + " * " + i5 + "; date = " + j4);
    }

    public static x i(Context context) {
        b();
        return new x(context);
    }

    public void j(b bVar) {
        this.f18442c = bVar;
    }

    public void k() {
        b();
        this.f18440a.clear();
        this.f18443d = System.currentTimeMillis();
        this.f18444e = new a(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.f18446g);
        this.f18445f = new a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.f18446g);
        this.f18441b.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.f18444e);
        this.f18441b.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.f18445f);
    }

    public void l() {
        b();
        if (this.f18444e != null) {
            try {
                this.f18441b.getContentResolver().unregisterContentObserver(this.f18444e);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            this.f18444e = null;
        }
        if (this.f18445f != null) {
            try {
                this.f18441b.getContentResolver().unregisterContentObserver(this.f18445f);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            this.f18445f = null;
        }
        this.f18443d = 0L;
        this.f18440a.clear();
    }
}
