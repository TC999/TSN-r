package com.umeng.socialize.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.stub.StubApp;
import com.umeng.social.tool.UMImageMark;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.p571c.p572a.ImageImpl;
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

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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

    /* renamed from: f */
    private ConfiguredConvertor f39471f;

    /* renamed from: g */
    private UMImage f39472g;

    /* renamed from: h */
    private UMImageMark f39473h;

    /* renamed from: i */
    private int f39474i;
    public boolean isLoadImgByCompress;

    /* renamed from: j */
    private boolean f39475j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class BinaryConvertor extends ConfiguredConvertor {

        /* renamed from: b */
        private byte[] f39477b;

        public BinaryConvertor(byte[] bArr) {
            this.f39477b = bArr;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return this.f39477b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return ImageImpl.m13309a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return ImageImpl.m13303b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class BitmapConvertor extends ConfiguredConvertor {

        /* renamed from: b */
        private Bitmap f39479b;

        public BitmapConvertor(Bitmap bitmap) {
            this.f39479b = bitmap;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return ImageImpl.m13316a(this.f39479b, UMImage.this.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            return this.f39479b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            byte[] m13316a = ImageImpl.m13316a(this.f39479b, UMImage.this.compressFormat);
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return ImageImpl.m13303b(m13316a);
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum CompressStyle {
        SCALE,
        QUALITY
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class ConfiguredConvertor implements IImageConvertor {
        ConfiguredConvertor() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class FileConvertor extends ConfiguredConvertor {

        /* renamed from: b */
        private File f39482b;

        public FileConvertor(File file) {
            this.f39482b = file;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return ImageImpl.m13311a(this.f39482b, UMImage.this.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return ImageImpl.m13309a(UMImage.this.asBinImage());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            return this.f39482b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface IImageConvertor {
        byte[] asBinary();

        Bitmap asBitmap();

        File asFile();

        String asUrl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class ResConvertor extends ConfiguredConvertor {

        /* renamed from: b */
        private Context f39484b;

        /* renamed from: c */
        private int f39485c;

        public ResConvertor(Context context, int i) {
            this.f39484b = context;
            this.f39485c = i;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            Context context = this.f39484b;
            int i = this.f39485c;
            UMImage uMImage = UMImage.this;
            return ImageImpl.m13317a(context, i, uMImage.isLoadImgByCompress, uMImage.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return ImageImpl.m13309a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return ImageImpl.m13303b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class UrlConvertor extends ConfiguredConvertor {

        /* renamed from: b */
        private String f39487b;

        public UrlConvertor(String str) {
            this.f39487b = str;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return ImageImpl.m13310a(this.f39487b);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return ImageImpl.m13309a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return ImageImpl.m13303b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return this.f39487b;
        }
    }

    public UMImage(Context context, File file) {
        this.f39471f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f39474i = 0;
        m13276a(context, file);
    }

    /* renamed from: a */
    private float m13278a(float f, float f2, float f3, float f4) {
        if (f > f4 || f2 > f4) {
            float f5 = f / f3;
            float f6 = f2 / f4;
            return f5 > f6 ? f5 : f6;
        }
        return -1.0f;
    }

    /* renamed from: a */
    private void m13276a(Context context, Object obj) {
        m13275a(context, obj, null);
    }

    /* renamed from: b */
    private void m13270b(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            } catch (Exception e) {
                SLog.error(e);
            }
        }
    }

    public byte[] asBinImage() {
        ConfiguredConvertor configuredConvertor = this.f39471f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asBinary();
    }

    public Bitmap asBitmap() {
        ConfiguredConvertor configuredConvertor = this.f39471f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asBitmap();
    }

    public File asFileImage() {
        ConfiguredConvertor configuredConvertor = this.f39471f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asFile();
    }

    public String asUrlImage() {
        ConfiguredConvertor configuredConvertor = this.f39471f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asUrl();
    }

    public int getImageStyle() {
        return this.f39474i;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.IMAGE;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public UMImage getThumbImage() {
        return this.f39472g;
    }

    public boolean isHasWaterMark() {
        return this.f39475j;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public void setThumb(UMImage uMImage) {
        this.f39472g = uMImage;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        return asBinImage();
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f39450a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
        }
        return hashMap;
    }

    /* renamed from: a */
    private void m13275a(Context context, Object obj, UMImageMark uMImageMark) {
        Bitmap m13273a;
        if (uMImageMark != null) {
            this.f39475j = true;
            this.f39473h = uMImageMark;
            uMImageMark.setContext(context);
        }
        if (ContextUtil.getContext() == null) {
            ContextUtil.setContext(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        if (obj instanceof File) {
            this.f39474i = FILE_IMAGE;
            this.f39471f = new FileConvertor((File) obj);
        } else if (obj instanceof String) {
            this.f39474i = URL_IMAGE;
            this.f39471f = new UrlConvertor((String) obj);
        } else {
            if (obj instanceof Integer) {
                this.f39474i = RES_IMAGE;
                m13273a = isHasWaterMark() ? m13277a(context, ((Integer) obj).intValue()) : null;
                if (m13273a != null) {
                    this.f39471f = new BitmapConvertor(m13273a);
                } else {
                    this.f39471f = new ResConvertor(StubApp.getOrigApplicationContext(context.getApplicationContext()), ((Integer) obj).intValue());
                }
            } else if (obj instanceof byte[]) {
                this.f39474i = BINARY_IMAGE;
                m13273a = isHasWaterMark() ? m13271a((byte[]) obj) : null;
                if (m13273a != null) {
                    this.f39471f = new BitmapConvertor(m13273a);
                } else {
                    this.f39471f = new BinaryConvertor((byte[]) obj);
                }
            } else if (obj instanceof Bitmap) {
                this.f39474i = BITMAP_IMAGE;
                m13273a = isHasWaterMark() ? m13273a((Bitmap) obj, true) : null;
                if (m13273a == null) {
                    m13273a = (Bitmap) obj;
                }
                this.f39471f = new BitmapConvertor(m13273a);
            } else if (obj != null) {
                SLog.m13211E(UmengText.IMAGE.UNKNOW_UMIMAGE + obj.getClass().getSimpleName());
            } else {
                SLog.m13211E(UmengText.IMAGE.UNKNOW_UMIMAGE + "null");
            }
        }
    }

    public UMImage(Context context, String str) {
        super(str);
        this.f39471f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f39474i = 0;
        m13276a((Context) new WeakReference(context).get(), str);
    }

    public UMImage(Context context, int i) {
        this.f39471f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f39474i = 0;
        m13276a(context, Integer.valueOf(i));
    }

    public UMImage(Context context, byte[] bArr) {
        this.f39471f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f39474i = 0;
        m13276a(context, bArr);
    }

    public UMImage(Context context, Bitmap bitmap) {
        this.f39471f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f39474i = 0;
        m13276a(context, bitmap);
    }

    /* renamed from: a */
    private Bitmap m13273a(Bitmap bitmap, boolean z) {
        if (this.f39473h == null) {
            return bitmap;
        }
        if (bitmap == null) {
            return null;
        }
        if (z) {
            try {
                bitmap = m13274a(bitmap);
            } catch (Exception e) {
                SLog.error(e);
                return null;
            }
        }
        return this.f39473h.compound(bitmap);
    }

    public UMImage(Context context, Bitmap bitmap, UMImageMark uMImageMark) {
        this.f39471f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f39474i = 0;
        m13275a(context, bitmap, uMImageMark);
    }

    /* renamed from: a */
    private Bitmap m13277a(Context context, int i) {
        InputStream inputStream;
        BitmapFactory.Options options;
        InputStream openRawResource;
        InputStream inputStream2 = null;
        if (i == 0 || context == null || this.f39473h == null) {
            return null;
        }
        try {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            openRawResource = context.getResources().openRawResource(i);
        } catch (Exception e) {
            e = e;
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            m13272a(inputStream2);
            throw th;
        }
        try {
            try {
                BitmapFactory.decodeStream(openRawResource, null, options);
                m13272a(openRawResource);
                int m13278a = (int) m13278a(options.outWidth, options.outHeight, MAX_WIDTH, MAX_HEIGHT);
                if (m13278a > 0) {
                    options.inSampleSize = m13278a;
                }
                options.inJustDecodeBounds = false;
                inputStream = context.getResources().openRawResource(i);
                Bitmap m13273a = m13273a(BitmapFactory.decodeStream(inputStream, null, options), false);
                m13272a(inputStream);
                return m13273a;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                m13272a(inputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            SLog.error(e);
            m13272a(inputStream);
            return null;
        }
    }

    public UMImage(Context context, int i, UMImageMark uMImageMark) {
        this.f39471f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f39474i = 0;
        m13275a(context, Integer.valueOf(i), uMImageMark);
    }

    public UMImage(Context context, byte[] bArr, UMImageMark uMImageMark) {
        this.f39471f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f39474i = 0;
        m13275a(context, bArr, uMImageMark);
    }

    /* renamed from: a */
    private void m13272a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                SLog.error(e);
            }
        }
    }

    /* renamed from: a */
    private Bitmap m13271a(byte[] bArr) {
        if (bArr != null && this.f39473h != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                int m13278a = (int) m13278a(options.outWidth, options.outHeight, MAX_WIDTH, MAX_HEIGHT);
                if (m13278a > 0) {
                    options.inSampleSize = m13278a;
                }
                options.inJustDecodeBounds = false;
                return m13273a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options), false);
            } catch (Exception e) {
                SLog.error(e);
            }
        }
        return null;
    }

    /* renamed from: a */
    private Bitmap m13274a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float m13278a = m13278a(width, height, MAX_WIDTH, MAX_HEIGHT);
        if (m13278a < 0.0f) {
            return bitmap;
        }
        float f = 1.0f / m13278a;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        m13270b(bitmap);
        return createBitmap;
    }
}
