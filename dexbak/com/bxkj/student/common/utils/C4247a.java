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
import cn.bluemobi.dylan.base.utils.Tools;
import com.baidu.mobads.sdk.internal.C2573a;
import com.bxkj.base.BaseApp;
import com.bxkj.student.C4215R;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: BitmapUtils.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m12616d2 = {"Lcom/bxkj/student/common/utils/a;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.common.utils.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C4247a {
    @NotNull

    /* renamed from: a */
    public static final C4248a f16216a = new C4248a(null);

    /* compiled from: BitmapUtils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ \u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\r"}, m12616d2 = {"Lcom/bxkj/student/common/utils/a$a;", "", "", "textColor", "Landroid/graphics/Bitmap;", RewardPlus.ICON, "", C2573a.f8443b, "c", "a", "b", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.common.utils.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C4248a {
        private C4248a() {
        }

        public /* synthetic */ C4248a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: c */
        private final Bitmap m42867c(int i, Bitmap bitmap, String str) {
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setTextSize(Tools.m57620a(15.0f, BaseApp.m44341b()));
            paint.setColor(i);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
            paint.getTextBounds(str, 0, str.length(), new Rect());
            canvas.drawText(str, bitmap.getWidth() / 2, bitmap.getHeight() / 2, paint);
            return bitmap;
        }

        @NotNull
        /* renamed from: a */
        public final Bitmap m42869a(@NotNull String text) {
            C14342f0.m8184p(text, "text");
            Drawable drawable = ContextCompat.getDrawable(BaseApp.m44341b(), C4215R.mipmap.point_number);
            if (drawable != null) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                int parseColor = Color.parseColor("#b2b2b2");
                C14342f0.m8185o(bitmap, "bitmap");
                return m42867c(parseColor, bitmap, text);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        }

        @NotNull
        /* renamed from: b */
        public final Bitmap m42868b(@NotNull String text) {
            C14342f0.m8184p(text, "text");
            Drawable drawable = ContextCompat.getDrawable(BaseApp.m44341b(), C4215R.mipmap.point_ok_nuber);
            if (drawable != null) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                int parseColor = Color.parseColor("#3ecda1");
                C14342f0.m8185o(bitmap, "bitmap");
                return m42867c(parseColor, bitmap, text);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        }
    }
}
