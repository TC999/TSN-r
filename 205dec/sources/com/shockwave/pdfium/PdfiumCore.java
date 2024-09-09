package com.shockwave.pdfium;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.Surface;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.util.Size;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class PdfiumCore {

    /* renamed from: b  reason: collision with root package name */
    private static final String f48107b = "com.shockwave.pdfium.PdfiumCore";

    /* renamed from: c  reason: collision with root package name */
    private static final Class f48108c = FileDescriptor.class;

    /* renamed from: d  reason: collision with root package name */
    private static final String f48109d = "descriptor";

    /* renamed from: e  reason: collision with root package name */
    private static final Object f48110e;

    /* renamed from: f  reason: collision with root package name */
    private static Field f48111f;

    /* renamed from: a  reason: collision with root package name */
    private int f48112a;

    static {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("modpng");
            System.loadLibrary("modft2");
            System.loadLibrary("modpdfium");
            System.loadLibrary("jniPdfium");
        } catch (UnsatisfiedLinkError e4) {
            Log.e(f48107b, "Native libraries failed to load - " + e4);
        }
        f48110e = new Object();
        f48111f = null;
    }

    public PdfiumCore(Context context) {
        this.f48112a = context.getResources().getDisplayMetrics().densityDpi;
        Log.d(f48107b, "Starting PdfiumAndroid 1.9.0");
    }

    public static int c(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            if (f48111f == null) {
                Field declaredField = f48108c.getDeclaredField("descriptor");
                f48111f = declaredField;
                declaredField.setAccessible(true);
            }
            return f48111f.getInt(parcelFileDescriptor.getFileDescriptor());
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return -1;
        } catch (NoSuchFieldException e5) {
            e5.printStackTrace();
            return -1;
        }
    }

    private native void nativeCloseDocument(long j4);

    private native void nativeClosePage(long j4);

    private native void nativeClosePages(long[] jArr);

    private native long nativeGetBookmarkDestIndex(long j4, long j5);

    private native String nativeGetBookmarkTitle(long j4);

    private native Integer nativeGetDestPageIndex(long j4, long j5);

    private native String nativeGetDocumentMetaText(long j4, String str);

    private native Long nativeGetFirstChildBookmark(long j4, Long l4);

    private native RectF nativeGetLinkRect(long j4);

    private native String nativeGetLinkURI(long j4, long j5);

    private native int nativeGetPageCount(long j4);

    private native int nativeGetPageHeightPixel(long j4, int i4);

    private native int nativeGetPageHeightPoint(long j4);

    private native long[] nativeGetPageLinks(long j4);

    private native Size nativeGetPageSizeByIndex(long j4, int i4, int i5);

    private native int nativeGetPageWidthPixel(long j4, int i4);

    private native int nativeGetPageWidthPoint(long j4);

    private native Long nativeGetSiblingBookmark(long j4, long j5);

    private native long nativeLoadPage(long j4, int i4);

    private native long[] nativeLoadPages(long j4, int i4, int i5);

    private native long nativeOpenDocument(int i4, String str);

    private native long nativeOpenMemDocument(byte[] bArr, String str);

    private native Point nativePageCoordsToDevice(long j4, int i4, int i5, int i6, int i7, int i8, double d4, double d5);

    private native void nativeRenderPage(long j4, Surface surface, int i4, int i5, int i6, int i7, int i8, boolean z3);

    private native void nativeRenderPageBitmap(long j4, Bitmap bitmap, int i4, int i5, int i6, int i7, int i8, boolean z3);

    private void t(List<PdfDocument.Bookmark> list, PdfDocument pdfDocument, long j4) {
        PdfDocument.Bookmark bookmark = new PdfDocument.Bookmark();
        bookmark.f48095d = j4;
        bookmark.f48093b = nativeGetBookmarkTitle(j4);
        bookmark.f48094c = nativeGetBookmarkDestIndex(pdfDocument.f48089a, j4);
        list.add(bookmark);
        Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(pdfDocument.f48089a, Long.valueOf(j4));
        if (nativeGetFirstChildBookmark != null) {
            t(bookmark.a(), pdfDocument, nativeGetFirstChildBookmark.longValue());
        }
        Long nativeGetSiblingBookmark = nativeGetSiblingBookmark(pdfDocument.f48089a, j4);
        if (nativeGetSiblingBookmark != null) {
            t(list, pdfDocument, nativeGetSiblingBookmark.longValue());
        }
    }

    public void a(PdfDocument pdfDocument) {
        synchronized (f48110e) {
            for (Integer num : pdfDocument.f48091c.keySet()) {
                nativeClosePage(pdfDocument.f48091c.get(num).longValue());
            }
            pdfDocument.f48091c.clear();
            nativeCloseDocument(pdfDocument.f48089a);
            ParcelFileDescriptor parcelFileDescriptor = pdfDocument.f48090b;
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException unused) {
                }
                pdfDocument.f48090b = null;
            }
        }
    }

    public PdfDocument.Meta b(PdfDocument pdfDocument) {
        PdfDocument.Meta meta;
        synchronized (f48110e) {
            meta = new PdfDocument.Meta();
            meta.f48099a = nativeGetDocumentMetaText(pdfDocument.f48089a, "Title");
            meta.f48100b = nativeGetDocumentMetaText(pdfDocument.f48089a, "Author");
            meta.f48101c = nativeGetDocumentMetaText(pdfDocument.f48089a, "Subject");
            meta.f48102d = nativeGetDocumentMetaText(pdfDocument.f48089a, "Keywords");
            meta.f48103e = nativeGetDocumentMetaText(pdfDocument.f48089a, "Creator");
            meta.f48104f = nativeGetDocumentMetaText(pdfDocument.f48089a, "Producer");
            meta.f48105g = nativeGetDocumentMetaText(pdfDocument.f48089a, "CreationDate");
            meta.f48106h = nativeGetDocumentMetaText(pdfDocument.f48089a, "ModDate");
        }
        return meta;
    }

    public int d(PdfDocument pdfDocument) {
        int nativeGetPageCount;
        synchronized (f48110e) {
            nativeGetPageCount = nativeGetPageCount(pdfDocument.f48089a);
        }
        return nativeGetPageCount;
    }

    public int e(PdfDocument pdfDocument, int i4) {
        synchronized (f48110e) {
            Long l4 = pdfDocument.f48091c.get(Integer.valueOf(i4));
            if (l4 != null) {
                return nativeGetPageHeightPixel(l4.longValue(), this.f48112a);
            }
            return 0;
        }
    }

    public int f(PdfDocument pdfDocument, int i4) {
        synchronized (f48110e) {
            Long l4 = pdfDocument.f48091c.get(Integer.valueOf(i4));
            if (l4 != null) {
                return nativeGetPageHeightPoint(l4.longValue());
            }
            return 0;
        }
    }

    public List<PdfDocument.Link> g(PdfDocument pdfDocument, int i4) {
        long[] nativeGetPageLinks;
        synchronized (f48110e) {
            ArrayList arrayList = new ArrayList();
            Long l4 = pdfDocument.f48091c.get(Integer.valueOf(i4));
            if (l4 == null) {
                return arrayList;
            }
            for (long j4 : nativeGetPageLinks(l4.longValue())) {
                Integer nativeGetDestPageIndex = nativeGetDestPageIndex(pdfDocument.f48089a, j4);
                String nativeGetLinkURI = nativeGetLinkURI(pdfDocument.f48089a, j4);
                RectF nativeGetLinkRect = nativeGetLinkRect(j4);
                if (nativeGetLinkRect != null && (nativeGetDestPageIndex != null || nativeGetLinkURI != null)) {
                    arrayList.add(new PdfDocument.Link(nativeGetLinkRect, nativeGetDestPageIndex, nativeGetLinkURI));
                }
            }
            return arrayList;
        }
    }

    public Size h(PdfDocument pdfDocument, int i4) {
        Size nativeGetPageSizeByIndex;
        synchronized (f48110e) {
            nativeGetPageSizeByIndex = nativeGetPageSizeByIndex(pdfDocument.f48089a, i4, this.f48112a);
        }
        return nativeGetPageSizeByIndex;
    }

    public int i(PdfDocument pdfDocument, int i4) {
        synchronized (f48110e) {
            Long l4 = pdfDocument.f48091c.get(Integer.valueOf(i4));
            if (l4 != null) {
                return nativeGetPageWidthPixel(l4.longValue(), this.f48112a);
            }
            return 0;
        }
    }

    public int j(PdfDocument pdfDocument, int i4) {
        synchronized (f48110e) {
            Long l4 = pdfDocument.f48091c.get(Integer.valueOf(i4));
            if (l4 != null) {
                return nativeGetPageWidthPoint(l4.longValue());
            }
            return 0;
        }
    }

    public List<PdfDocument.Bookmark> k(PdfDocument pdfDocument) {
        ArrayList arrayList;
        synchronized (f48110e) {
            arrayList = new ArrayList();
            Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(pdfDocument.f48089a, null);
            if (nativeGetFirstChildBookmark != null) {
                t(arrayList, pdfDocument, nativeGetFirstChildBookmark.longValue());
            }
        }
        return arrayList;
    }

    public Point l(PdfDocument pdfDocument, int i4, int i5, int i6, int i7, int i8, int i9, double d4, double d5) {
        return nativePageCoordsToDevice(pdfDocument.f48091c.get(Integer.valueOf(i4)).longValue(), i5, i6, i7, i8, i9, d4, d5);
    }

    public RectF m(PdfDocument pdfDocument, int i4, int i5, int i6, int i7, int i8, int i9, RectF rectF) {
        Point l4 = l(pdfDocument, i4, i5, i6, i7, i8, i9, rectF.left, rectF.top);
        Point l5 = l(pdfDocument, i4, i5, i6, i7, i8, i9, rectF.right, rectF.bottom);
        return new RectF(l4.x, l4.y, l5.x, l5.y);
    }

    public PdfDocument n(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        return o(parcelFileDescriptor, null);
    }

    public PdfDocument o(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.f48090b = parcelFileDescriptor;
        synchronized (f48110e) {
            pdfDocument.f48089a = nativeOpenDocument(c(parcelFileDescriptor), str);
        }
        return pdfDocument;
    }

    public PdfDocument p(byte[] bArr) throws IOException {
        return q(bArr, null);
    }

    public PdfDocument q(byte[] bArr, String str) throws IOException {
        PdfDocument pdfDocument = new PdfDocument();
        synchronized (f48110e) {
            pdfDocument.f48089a = nativeOpenMemDocument(bArr, str);
        }
        return pdfDocument;
    }

    public long r(PdfDocument pdfDocument, int i4) {
        long nativeLoadPage;
        synchronized (f48110e) {
            nativeLoadPage = nativeLoadPage(pdfDocument.f48089a, i4);
            pdfDocument.f48091c.put(Integer.valueOf(i4), Long.valueOf(nativeLoadPage));
        }
        return nativeLoadPage;
    }

    public long[] s(PdfDocument pdfDocument, int i4, int i5) {
        long[] nativeLoadPages;
        synchronized (f48110e) {
            nativeLoadPages = nativeLoadPages(pdfDocument.f48089a, i4, i5);
            for (long j4 : nativeLoadPages) {
                if (i4 > i5) {
                    break;
                }
                pdfDocument.f48091c.put(Integer.valueOf(i4), Long.valueOf(j4));
                i4++;
            }
        }
        return nativeLoadPages;
    }

    public void u(PdfDocument pdfDocument, Surface surface, int i4, int i5, int i6, int i7, int i8) {
        v(pdfDocument, surface, i4, i5, i6, i7, i8, false);
    }

    public void v(PdfDocument pdfDocument, Surface surface, int i4, int i5, int i6, int i7, int i8, boolean z3) {
        synchronized (f48110e) {
            try {
                try {
                } catch (NullPointerException e4) {
                    e = e4;
                } catch (Exception e5) {
                    e = e5;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
                try {
                    nativeRenderPage(pdfDocument.f48091c.get(Integer.valueOf(i4)).longValue(), surface, this.f48112a, i5, i6, i7, i8, z3);
                } catch (NullPointerException e6) {
                    e = e6;
                    Log.e(f48107b, "mContext may be null");
                    e.printStackTrace();
                } catch (Exception e7) {
                    e = e7;
                    Log.e(f48107b, "Exception throw from native");
                    e.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public void w(PdfDocument pdfDocument, Bitmap bitmap, int i4, int i5, int i6, int i7, int i8) {
        x(pdfDocument, bitmap, i4, i5, i6, i7, i8, false);
    }

    public void x(PdfDocument pdfDocument, Bitmap bitmap, int i4, int i5, int i6, int i7, int i8, boolean z3) {
        synchronized (f48110e) {
            try {
                try {
                } catch (NullPointerException e4) {
                    e = e4;
                } catch (Exception e5) {
                    e = e5;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
                try {
                    nativeRenderPageBitmap(pdfDocument.f48091c.get(Integer.valueOf(i4)).longValue(), bitmap, this.f48112a, i5, i6, i7, i8, z3);
                } catch (NullPointerException e6) {
                    e = e6;
                    Log.e(f48107b, "mContext may be null");
                    e.printStackTrace();
                } catch (Exception e7) {
                    e = e7;
                    Log.e(f48107b, "Exception throw from native");
                    e.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }
}
