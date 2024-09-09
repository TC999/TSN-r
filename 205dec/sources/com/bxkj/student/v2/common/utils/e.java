package com.bxkj.student.v2.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import androidx.core.content.ContextCompat;
import com.bxkj.base.BaseApp;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: BitmapUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/bxkj/student/v2/common/utils/e;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f23349a = new a(null);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BitmapUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J \u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/bxkj/student/v2/common/utils/e$a;", "", "", "textColor", "Landroid/graphics/Bitmap;", RewardPlus.ICON, "", "text", "d", "b", "c", "Landroid/content/Context;", "context", "bmp", "Ljava/io/File;", "a", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        private final Bitmap d(int i4, Bitmap bitmap, String str) {
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setTextSize(cn.bluemobi.dylan.base.utils.u.a(15.0f, BaseApp.b()));
            paint.setColor(i4);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
            paint.getTextBounds(str, 0, str.length(), new Rect());
            canvas.drawText(str, bitmap.getWidth() / 2, bitmap.getHeight() / 2, paint);
            return bitmap;
        }

        @Nullable
        public final File a(@NotNull Context context, @Nullable Bitmap bitmap) {
            FileOutputStream fileOutputStream;
            f0.p(context, "context");
            FileOutputStream fileOutputStream2 = null;
            if (bitmap != null && !bitmap.isRecycled()) {
                com.orhanobut.logger.j.d("bmp.getWidth()=" + bitmap.getWidth() + "bmp.getHeight()" + bitmap.getHeight(), new Object[0]);
                File externalCacheDir = f0.g("mounted", Environment.getExternalStorageState()) ? context.getExternalCacheDir() : null;
                if (externalCacheDir == null || !externalCacheDir.exists()) {
                    externalCacheDir = context.getCacheDir();
                }
                File file = new File(externalCacheDir, "face");
                boolean exists = file.exists();
                if (!exists) {
                    exists = file.mkdirs();
                }
                if (exists) {
                    File file2 = new File(file, "sports" + System.currentTimeMillis() + ".png");
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (FileNotFoundException unused) {
                        fileOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                        return file2;
                    } catch (FileNotFoundException unused3) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused5) {
                            }
                        }
                        throw th;
                    }
                }
            }
            return null;
        }

        @NotNull
        public final Bitmap b(@NotNull String text) {
            f0.p(text, "text");
            Drawable drawable = ContextCompat.getDrawable(BaseApp.b(), 2131558934);
            if (drawable != null) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                int parseColor = Color.parseColor("#b2b2b2");
                f0.o(bitmap, "bitmap");
                return d(parseColor, bitmap, text);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        }

        @NotNull
        public final Bitmap c(@NotNull String text) {
            f0.p(text, "text");
            Drawable drawable = ContextCompat.getDrawable(BaseApp.b(), 2131558935);
            if (drawable != null) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                int parseColor = Color.parseColor("#3ecda1");
                f0.o(bitmap, "bitmap");
                return d(parseColor, bitmap, text);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        }
    }
}
