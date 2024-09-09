package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.HelpShopAppUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.component.ttvideo.utils.AVErrorInfo;
import io.reactivex.annotations.NonNull;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectStreamException;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class q2 {

    /* renamed from: c  reason: collision with root package name */
    public static q2 f6151c;

    /* renamed from: a  reason: collision with root package name */
    public AccessibilityService f6152a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6153b = false;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f6154a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f6155b;

        public a(int i4, int i5) {
            this.f6154a = i4;
            this.f6155b = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 24) {
                if (q2.this.f6152a != null) {
                    z1.c("samon-->", "mService is not null");
                    if (j0.f5763e) {
                        z1.c("samon-->", "\u70b9\u51fb\u4e86 ");
                        com.acse.ottn.d.b().f5383o = com.acse.ottn.b.d().a(q2.this.f6152a, this.f6154a, this.f6155b);
                        return;
                    }
                    return;
                }
                z1.c("samon-->", "mService is null");
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT < 24 || !j0.f5763e) {
                return;
            }
            z1.c("samon-->", "\u5f00\u59cb\u6ed1\u52a8 ");
            if (g1.a().d("ocr_screen_scroll").equals("1")) {
                com.acse.ottn.b.d();
                com.acse.ottn.b.a(q2.this.f6152a, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX, 420, 250);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z1.c("samon-->", "\u83b7\u53d6\u70b9\u51fb\u540e\u7684\u4f4d\u7f6e");
            q2.this.d();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f6159a;

        public d(AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f6159a = accessibilityNodeInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            q2.this.b(this.f6159a, false);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e implements AccessibilityService.TakeScreenshotCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f6161a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f6162b;

        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                q2.this.a(eVar.f6161a, eVar.f6162b);
            }
        }

        public e(AccessibilityNodeInfo accessibilityNodeInfo, boolean z3) {
            this.f6161a = accessibilityNodeInfo;
            this.f6162b = z3;
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        public void onFailure(int i4) {
            z1.c("samon ScreenShotResult", "onFailure code is " + i4);
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 500L);
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        @RequiresApi(api = 30)
        public void onSuccess(@NonNull AccessibilityService.ScreenshotResult screenshotResult) {
            Bitmap wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(screenshotResult.getHardwareBuffer(), screenshotResult.getColorSpace());
            try {
                Rect rect = new Rect();
                this.f6161a.getBoundsInScreen(rect);
                int i4 = rect.left;
                int i5 = rect.top;
                z1.c("samon-->", "\u5f00\u59cb\u4fdd\u5b58\u56fe\u7247 \u5e76\u4e14\u5df2\u7ecf\u70b9\u51fb\u4e86=" + (rect.bottom - rect.top));
                int i6 = rect.bottom - rect.top;
                if (i6 > 300) {
                    return;
                }
                q2.this.a(Bitmap.createBitmap(wrapHardwareBuffer, i4, i5, rect.right - rect.left, i6), this.f6162b);
            } catch (Throwable th) {
                z1.c("samon croppedImage", "Throwable e =  " + th.getMessage());
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class f implements AccessibilityService.TakeScreenshotCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f6165a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f6166b;

        public f(AccessibilityNodeInfo accessibilityNodeInfo, boolean z3) {
            this.f6165a = accessibilityNodeInfo;
            this.f6166b = z3;
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        public void onFailure(int i4) {
            z1.c("samon ScreenShotResult", "onFailure code is " + i4);
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        @RequiresApi(api = 30)
        public void onSuccess(@NonNull AccessibilityService.ScreenshotResult screenshotResult) {
            Bitmap wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(screenshotResult.getHardwareBuffer(), screenshotResult.getColorSpace());
            try {
                Rect rect = new Rect();
                this.f6165a.getBoundsInScreen(rect);
                int i4 = rect.left;
                int i5 = rect.top;
                z1.c("samon-->", "\u5f00\u59cb\u4fdd\u5b58\u56fe\u7247 \u5e76\u4e14\u5df2\u7ecf\u70b9\u51fb\u4e86=" + (rect.bottom - rect.top));
                int i6 = rect.bottom - rect.top;
                if (i6 > 300) {
                    return;
                }
                q2.this.a(Bitmap.createBitmap(wrapHardwareBuffer, i4, i5, rect.right - rect.left, i6), this.f6166b);
            } catch (Throwable th) {
                z1.c("samon croppedImage", "Throwable e =  " + th.getMessage());
            }
        }
    }

    public static q2 c() {
        if (f6151c == null) {
            synchronized (q2.class) {
                if (f6151c == null) {
                    f6151c = new q2();
                }
            }
        }
        return f6151c;
    }

    @SuppressLint({"NewApi"})
    public final void d() {
        try {
            b(this.f6152a.getRootInActiveWindow());
        } catch (Throwable unused) {
        }
    }

    public final Object e() throws ObjectStreamException {
        return f6151c;
    }

    public String f() {
        File b4 = b();
        File file = new File(b4 + "/Screenshot.png");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return Base64.encodeToString(bArr, 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (this.f6153b) {
            Log.d("samon-->", "\u6b63\u5728\u6267\u884c\u3002\u3002");
            return;
        }
        this.f6153b = true;
        if (com.acse.ottn.d.b().f5383o) {
            Log.d("samon-->", "\u5df2\u7ecf\u70b9\u51fb\u3002\u3002");
            return;
        }
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        int i4 = rect.left;
        int i5 = rect.top;
        b(accessibilityNodeInfo, true);
        try {
            int i6 = i4 + ((rect.right - rect.left) / 2);
            int i7 = i5 + ((rect.bottom - rect.top) / 2);
            z1.c("samon-->", "x1= " + rect.left);
            z1.c("samon-->", "y1= " + rect.top + "    \u5c4f\u5e55\u00b7\u9ad8\u5ea6=" + c4.b(HelpShopAppUtil.getContext()));
            StringBuilder sb = new StringBuilder();
            sb.append("x2= ");
            sb.append(rect.right);
            z1.c("samon-->", sb.toString());
            z1.c("samon-->", "y2= " + rect.bottom + "    \u5c4f\u5e55\u00b7\u9ad8\u5ea6=" + c4.b(HelpShopAppUtil.getContext()));
            new Handler(Looper.getMainLooper()).postDelayed(new a(i6, i7), 0L);
            int i8 = 300;
            if (c4.b(HelpShopAppUtil.getContext()) - rect.bottom < 200) {
                i8 = 1000;
                new Handler(Looper.getMainLooper()).postDelayed(new b(), 500L);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new c(), i8);
        } catch (Throwable unused) {
        }
    }

    public final File b() {
        File externalFilesDir = HelpShopAppUtil.getContext().getExternalFilesDir(AVErrorInfo.CRASH);
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return externalFilesDir;
    }

    public void b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if ((accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) && accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                try {
                    if (accessibilityNodeInfo.getChild(i4) != null) {
                        AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
                        if ("android.widget.LinearLayout".equals(child.getClassName()) && child.isLongClickable()) {
                            z1.c("samon-->", "\u83b7\u53d6\u70b9\u51fb\u540e\u7684\u56fe\u7247");
                            new Handler(Looper.getMainLooper()).postDelayed(new d(child), 0L);
                        }
                        b(child);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public final void b(AccessibilityNodeInfo accessibilityNodeInfo, boolean z3) {
        z1.c("samon-->", "startCroppedImage  isOne=" + z3);
        if (Build.VERSION.SDK_INT >= 30) {
            AccessibilityService accessibilityService = this.f6152a;
            if (accessibilityService == null) {
                z1.c("samon-->", "service  \u662fnull");
            } else {
                accessibilityService.takeScreenshot(0, HelpShopAppUtil.getContext().getMainExecutor(), new e(accessibilityNodeInfo, z3));
            }
        }
    }

    public void a(Bitmap bitmap, File file) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a() {
        com.acse.ottn.d.b().f5384p = "";
        com.acse.ottn.d.b().f5385q = "";
    }

    public void a(Bitmap bitmap, boolean z3) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (z3) {
                z1.a("samon-->", "imageBase64_by");
                com.acse.ottn.d.b().f5385q = Base64.encodeToString(byteArray, 0);
            } else {
                z1.a("samon-->", "imageBase64");
                com.acse.ottn.d.b().f5384p = Base64.encodeToString(byteArray, 0);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(AccessibilityService accessibilityService) {
        this.f6152a = accessibilityService;
    }

    public final void a(AccessibilityNodeInfo accessibilityNodeInfo, boolean z3) {
        z1.c("samon-->", "algin  isOne=" + z3);
        if (Build.VERSION.SDK_INT >= 30) {
            AccessibilityService accessibilityService = this.f6152a;
            if (accessibilityService == null) {
                z1.c("samon-->", "service  \u662fnull");
            } else {
                accessibilityService.takeScreenshot(0, HelpShopAppUtil.getContext().getMainExecutor(), new f(accessibilityNodeInfo, z3));
            }
        }
    }
}
