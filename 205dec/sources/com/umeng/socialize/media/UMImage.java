package com.umeng.socialize.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.stub.StubApp;
import com.umeng.social.tool.UMImageMark;
import com.umeng.socialize.c.a.a;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UMImage extends BaseMediaObject {
    public static int BINARY_IMAGE = 5;
    public static int BITMAP_IMAGE = 4;
    public static int FILE_IMAGE = 1;
    public static int MAX_HEIGHT = 1024;
    public static int MAX_WIDTH = 768;
    public static int RES_IMAGE = 3;
    public static int URL_IMAGE = 2;
    public Bitmap.CompressFormat compressFormat;
    public CompressStyle compressStyle;

    /* renamed from: f  reason: collision with root package name */
    private ConfiguredConvertor f54055f;

    /* renamed from: g  reason: collision with root package name */
    private UMImage f54056g;

    /* renamed from: h  reason: collision with root package name */
    private UMImageMark f54057h;

    /* renamed from: i  reason: collision with root package name */
    private int f54058i;
    public boolean isLoadImgByCompress;

    /* renamed from: j  reason: collision with root package name */
    private boolean f54059j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class BinaryConvertor extends ConfiguredConvertor {

        /* renamed from: b  reason: collision with root package name */
        private byte[] f54061b;

        public BinaryConvertor(byte[] bArr) {
            this.f54061b = bArr;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return this.f54061b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class BitmapConvertor extends ConfiguredConvertor {

        /* renamed from: b  reason: collision with root package name */
        private Bitmap f54063b;

        public BitmapConvertor(Bitmap bitmap) {
            this.f54063b = bitmap;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return a.a(this.f54063b, UMImage.this.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            return this.f54063b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            byte[] a4 = a.a(this.f54063b, UMImage.this.compressFormat);
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(a4);
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum CompressStyle {
        SCALE,
        QUALITY
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class ConfiguredConvertor implements IImageConvertor {
        ConfiguredConvertor() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class FileConvertor extends ConfiguredConvertor {

        /* renamed from: b  reason: collision with root package name */
        private File f54066b;

        public FileConvertor(File file) {
            this.f54066b = file;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return a.a(this.f54066b, UMImage.this.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(UMImage.this.asBinImage());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            return this.f54066b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface IImageConvertor {
        byte[] asBinary();

        Bitmap asBitmap();

        File asFile();

        String asUrl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class ResConvertor extends ConfiguredConvertor {

        /* renamed from: b  reason: collision with root package name */
        private Context f54068b;

        /* renamed from: c  reason: collision with root package name */
        private int f54069c;

        public ResConvertor(Context context, int i4) {
            this.f54068b = context;
            this.f54069c = i4;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            Context context = this.f54068b;
            int i4 = this.f54069c;
            UMImage uMImage = UMImage.this;
            return a.a(context, i4, uMImage.isLoadImgByCompress, uMImage.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class UrlConvertor extends ConfiguredConvertor {

        /* renamed from: b  reason: collision with root package name */
        private String f54071b;

        public UrlConvertor(String str) {
            this.f54071b = str;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return a.a(this.f54071b);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return this.f54071b;
        }
    }

    public UMImage(Context context, File file) {
        this.f54055f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f54058i = 0;
        a(context, file);
    }

    private float a(float f4, float f5, float f6, float f7) {
        if (f4 > f7 || f5 > f7) {
            float f8 = f4 / f6;
            float f9 = f5 / f7;
            return f8 > f9 ? f8 : f9;
        }
        return -1.0f;
    }

    private void a(Context context, Object obj) {
        a(context, obj, null);
    }

    private void b(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            } catch (Exception e4) {
                SLog.error(e4);
            }
        }
    }

    public byte[] asBinImage() {
        ConfiguredConvertor configuredConvertor = this.f54055f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asBinary();
    }

    public Bitmap asBitmap() {
        ConfiguredConvertor configuredConvertor = this.f54055f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asBitmap();
    }

    public File asFileImage() {
        ConfiguredConvertor configuredConvertor = this.f54055f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asFile();
    }

    public String asUrlImage() {
        ConfiguredConvertor configuredConvertor = this.f54055f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asUrl();
    }

    public int getImageStyle() {
        return this.f54058i;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.IMAGE;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public UMImage getThumbImage() {
        return this.f54056g;
    }

    public boolean isHasWaterMark() {
        return this.f54059j;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public void setThumb(UMImage uMImage) {
        this.f54056g = uMImage;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        return asBinImage();
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f54034a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
        }
        return hashMap;
    }

    private void a(Context context, Object obj, UMImageMark uMImageMark) {
        Bitmap a4;
        if (uMImageMark != null) {
            this.f54059j = true;
            this.f54057h = uMImageMark;
            uMImageMark.setContext(context);
        }
        if (ContextUtil.getContext() == null) {
            ContextUtil.setContext(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        if (obj instanceof File) {
            this.f54058i = FILE_IMAGE;
            this.f54055f = new FileConvertor((File) obj);
        } else if (obj instanceof String) {
            this.f54058i = URL_IMAGE;
            this.f54055f = new UrlConvertor((String) obj);
        } else {
            if (obj instanceof Integer) {
                this.f54058i = RES_IMAGE;
                a4 = isHasWaterMark() ? a(context, ((Integer) obj).intValue()) : null;
                if (a4 != null) {
                    this.f54055f = new BitmapConvertor(a4);
                } else {
                    this.f54055f = new ResConvertor(StubApp.getOrigApplicationContext(context.getApplicationContext()), ((Integer) obj).intValue());
                }
            } else if (obj instanceof byte[]) {
                this.f54058i = BINARY_IMAGE;
                a4 = isHasWaterMark() ? a((byte[]) obj) : null;
                if (a4 != null) {
                    this.f54055f = new BitmapConvertor(a4);
                } else {
                    this.f54055f = new BinaryConvertor((byte[]) obj);
                }
            } else if (obj instanceof Bitmap) {
                this.f54058i = BITMAP_IMAGE;
                a4 = isHasWaterMark() ? a((Bitmap) obj, true) : null;
                if (a4 == null) {
                    a4 = (Bitmap) obj;
                }
                this.f54055f = new BitmapConvertor(a4);
            } else if (obj != null) {
                SLog.E(UmengText.IMAGE.UNKNOW_UMIMAGE + obj.getClass().getSimpleName());
            } else {
                SLog.E(UmengText.IMAGE.UNKNOW_UMIMAGE + "null");
            }
        }
    }

    public UMImage(Context context, String str) {
        super(str);
        this.f54055f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f54058i = 0;
        a((Context) new WeakReference(context).get(), str);
    }

    public UMImage(Context context, int i4) {
        this.f54055f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f54058i = 0;
        a(context, Integer.valueOf(i4));
    }

    public UMImage(Context context, byte[] bArr) {
        this.f54055f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f54058i = 0;
        a(context, bArr);
    }

    public UMImage(Context context, Bitmap bitmap) {
        this.f54055f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f54058i = 0;
        a(context, bitmap);
    }

    private Bitmap a(Bitmap bitmap, boolean z3) {
        if (this.f54057h == null) {
            return bitmap;
        }
        if (bitmap == null) {
            return null;
        }
        if (z3) {
            try {
                bitmap = a(bitmap);
            } catch (Exception e4) {
                SLog.error(e4);
                return null;
            }
        }
        return this.f54057h.compound(bitmap);
    }

    public UMImage(Context context, Bitmap bitmap, UMImageMark uMImageMark) {
        this.f54055f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f54058i = 0;
        a(context, bitmap, uMImageMark);
    }

    private Bitmap a(Context context, int i4) {
        InputStream inputStream;
        BitmapFactory.Options options;
        InputStream openRawResource;
        InputStream inputStream2 = null;
        if (i4 == 0 || context == null || this.f54057h == null) {
            return null;
        }
        try {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            openRawResource = context.getResources().openRawResource(i4);
        } catch (Exception e4) {
            e = e4;
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            a(inputStream2);
            throw th;
        }
        try {
            try {
                BitmapFactory.decodeStream(openRawResource, null, options);
                a(openRawResource);
                int a4 = (int) a(options.outWidth, options.outHeight, MAX_WIDTH, MAX_HEIGHT);
                if (a4 > 0) {
                    options.inSampleSize = a4;
                }
                options.inJustDecodeBounds = false;
                inputStream = context.getResources().openRawResource(i4);
                Bitmap a5 = a(BitmapFactory.decodeStream(inputStream, null, options), false);
                a(inputStream);
                return a5;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                a(inputStream2);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            SLog.error(e);
            a(inputStream);
            return null;
        }
    }

    public UMImage(Context context, int i4, UMImageMark uMImageMark) {
        this.f54055f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f54058i = 0;
        a(context, Integer.valueOf(i4), uMImageMark);
    }

    public UMImage(Context context, byte[] bArr, UMImageMark uMImageMark) {
        this.f54055f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f54058i = 0;
        a(context, bArr, uMImageMark);
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e4) {
                SLog.error(e4);
            }
        }
    }

    private Bitmap a(byte[] bArr) {
        if (bArr != null && this.f54057h != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                int a4 = (int) a(options.outWidth, options.outHeight, MAX_WIDTH, MAX_HEIGHT);
                if (a4 > 0) {
                    options.inSampleSize = a4;
                }
                options.inJustDecodeBounds = false;
                return a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options), false);
            } catch (Exception e4) {
                SLog.error(e4);
            }
        }
        return null;
    }

    private Bitmap a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float a4 = a(width, height, MAX_WIDTH, MAX_HEIGHT);
        if (a4 < 0.0f) {
            return bitmap;
        }
        float f4 = 1.0f / a4;
        Matrix matrix = new Matrix();
        matrix.postScale(f4, f4);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        b(bitmap);
        return createBitmap;
    }
}
