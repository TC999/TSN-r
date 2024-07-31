package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import com.tencent.open.SocialConstants;
import com.umeng.ccg.CcgConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15285q;

@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aR\u0010\f\u001a\u00020\u000b*\u00020\u00002C\b\u0004\u0010\n\u001a=\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\u0002\b\tH\u0087\b\u001aR\u0010\u000e\u001a\u00020\r*\u00020\u00002C\b\u0004\u0010\n\u001a=\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\u0002\b\tH\u0087\b¨\u0006\u000f"}, m12616d2 = {"Landroid/graphics/ImageDecoder$Source;", "Lkotlin/Function3;", "Landroid/graphics/ImageDecoder;", "Landroid/graphics/ImageDecoder$ImageInfo;", "Lkotlin/ParameterName;", "name", "info", SocialConstants.PARAM_SOURCE, "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", CcgConstant.f38549t, "Landroid/graphics/Bitmap;", "decodeBitmap", "Landroid/graphics/drawable/Drawable;", "decodeDrawable", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.graphics.ImageDecoderKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ImageDecoder {
    @RequiresApi(28)
    @NotNull
    public static final Bitmap decodeBitmap(@NotNull ImageDecoder.Source decodeBitmap, @NotNull final InterfaceC15285q<? super android.graphics.ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> action) {
        C14342f0.m8183q(decodeBitmap, "$this$decodeBitmap");
        C14342f0.m8183q(action, "action");
        Bitmap decodeBitmap2 = android.graphics.ImageDecoder.decodeBitmap(decodeBitmap, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt$decodeBitmap$1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(@NotNull ImageDecoder decoder, @NotNull ImageDecoder.ImageInfo info, @NotNull ImageDecoder.Source source) {
                C14342f0.m8183q(decoder, "decoder");
                C14342f0.m8183q(info, "info");
                C14342f0.m8183q(source, "source");
                InterfaceC15285q.this.invoke(decoder, info, source);
            }
        });
        C14342f0.m8192h(decodeBitmap2, "ImageDecoder.decodeBitma…ction(info, source)\n    }");
        return decodeBitmap2;
    }

    @RequiresApi(28)
    @NotNull
    public static final Drawable decodeDrawable(@NotNull ImageDecoder.Source decodeDrawable, @NotNull final InterfaceC15285q<? super android.graphics.ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> action) {
        C14342f0.m8183q(decodeDrawable, "$this$decodeDrawable");
        C14342f0.m8183q(action, "action");
        Drawable decodeDrawable2 = android.graphics.ImageDecoder.decodeDrawable(decodeDrawable, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt$decodeDrawable$1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(@NotNull ImageDecoder decoder, @NotNull ImageDecoder.ImageInfo info, @NotNull ImageDecoder.Source source) {
                C14342f0.m8183q(decoder, "decoder");
                C14342f0.m8183q(info, "info");
                C14342f0.m8183q(source, "source");
                InterfaceC15285q.this.invoke(decoder, info, source);
            }
        });
        C14342f0.m8192h(decodeDrawable2, "ImageDecoder.decodeDrawa…ction(info, source)\n    }");
        return decodeDrawable2;
    }
}
