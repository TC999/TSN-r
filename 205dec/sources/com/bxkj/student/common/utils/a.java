package com.bxkj.student.common.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.bxkj.base.BaseApp;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BitmapUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/bxkj/student/common/utils/a;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final C0216a f19615a = new C0216a(null);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BitmapUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lcom/bxkj/student/common/utils/a$a;", "", "", "textColor", "Landroid/graphics/Bitmap;", RewardPlus.ICON, "", "text", "c", "a", "b", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.common.utils.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class C0216a {
        private C0216a() {
        }

        public /* synthetic */ C0216a(u uVar) {
            this();
        }

        private final Bitmap c(int i4, Bitmap bitmap, String str) {
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

        @NotNull
        public final Bitmap a(@NotNull String text) {
            f0.p(text, "text");
            Drawable drawable = ContextCompat.getDrawable(BaseApp.b(), 2131558911);
            if (drawable != null) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                int parseColor = Color.parseColor("#b2b2b2");
                f0.o(bitmap, "bitmap");
                return c(parseColor, bitmap, text);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        }

        @NotNull
        public final Bitmap b(@NotNull String text) {
            f0.p(text, "text");
            Drawable drawable = ContextCompat.getDrawable(BaseApp.b(), 2131558912);
            if (drawable != null) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                int parseColor = Color.parseColor("#3ecda1");
                f0.o(bitmap, "bitmap");
                return c(parseColor, bitmap, text);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        }
    }
}
