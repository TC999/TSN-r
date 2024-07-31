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

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class PdfiumCore {

    /* renamed from: b */
    private static final String f33773b = "com.shockwave.pdfium.PdfiumCore";

    /* renamed from: c */
    private static final Class f33774c = FileDescriptor.class;

    /* renamed from: d */
    private static final String f33775d = "descriptor";

    /* renamed from: e */
    private static final Object f33776e;

    /* renamed from: f */
    private static Field f33777f;

    /* renamed from: a */
    private int f33778a;

    static {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("modpng");
            System.loadLibrary("modft2");
            System.loadLibrary("modpdfium");
            System.loadLibrary("jniPdfium");
        } catch (UnsatisfiedLinkError e) {
            Log.e(f33773b, "Native libraries failed to load - " + e);
        }
        f33776e = new Object();
        f33777f = null;
    }

    public PdfiumCore(Context context) {
        this.f33778a = context.getResources().getDisplayMetrics().densityDpi;
        Log.d(f33773b, "Starting PdfiumAndroid 1.9.0");
    }

    /* renamed from: c */
    public static int m19736c(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            if (f33777f == null) {
                Field declaredField = f33774c.getDeclaredField(f33775d);
                f33777f = declaredField;
                declaredField.setAccessible(true);
            }
            return f33777f.getInt(parcelFileDescriptor.getFileDescriptor());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private native void nativeCloseDocument(long j);

    private native void nativeClosePage(long j);

    private native void nativeClosePages(long[] jArr);

    private native long nativeGetBookmarkDestIndex(long j, long j2);

    private native String nativeGetBookmarkTitle(long j);

    private native Integer nativeGetDestPageIndex(long j, long j2);

    private native String nativeGetDocumentMetaText(long j, String str);

    private native Long nativeGetFirstChildBookmark(long j, Long l);

    private native RectF nativeGetLinkRect(long j);

    private native String nativeGetLinkURI(long j, long j2);

    private native int nativeGetPageCount(long j);

    private native int nativeGetPageHeightPixel(long j, int i);

    private native int nativeGetPageHeightPoint(long j);

    private native long[] nativeGetPageLinks(long j);

    private native Size nativeGetPageSizeByIndex(long j, int i, int i2);

    private native int nativeGetPageWidthPixel(long j, int i);

    private native int nativeGetPageWidthPoint(long j);

    private native Long nativeGetSiblingBookmark(long j, long j2);

    private native long nativeLoadPage(long j, int i);

    private native long[] nativeLoadPages(long j, int i, int i2);

    private native long nativeOpenDocument(int i, String str);

    private native long nativeOpenMemDocument(byte[] bArr, String str);

    private native Point nativePageCoordsToDevice(long j, int i, int i2, int i3, int i4, int i5, double d, double d2);

    private native void nativeRenderPage(long j, Surface surface, int i, int i2, int i3, int i4, int i5, boolean z);

    private native void nativeRenderPageBitmap(long j, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, boolean z);

    /* renamed from: t */
    private void m19719t(List<PdfDocument.Bookmark> list, PdfDocument pdfDocument, long j) {
        PdfDocument.Bookmark bookmark = new PdfDocument.Bookmark();
        bookmark.f33761d = j;
        bookmark.f33759b = nativeGetBookmarkTitle(j);
        bookmark.f33760c = nativeGetBookmarkDestIndex(pdfDocument.f33755a, j);
        list.add(bookmark);
        Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(pdfDocument.f33755a, Long.valueOf(j));
        if (nativeGetFirstChildBookmark != null) {
            m19719t(bookmark.m19753a(), pdfDocument, nativeGetFirstChildBookmark.longValue());
        }
        Long nativeGetSiblingBookmark = nativeGetSiblingBookmark(pdfDocument.f33755a, j);
        if (nativeGetSiblingBookmark != null) {
            m19719t(list, pdfDocument, nativeGetSiblingBookmark.longValue());
        }
    }

    /* renamed from: a */
    public void m19738a(PdfDocument pdfDocument) {
        synchronized (f33776e) {
            for (Integer num : pdfDocument.f33757c.keySet()) {
                nativeClosePage(pdfDocument.f33757c.get(num).longValue());
            }
            pdfDocument.f33757c.clear();
            nativeCloseDocument(pdfDocument.f33755a);
            ParcelFileDescriptor parcelFileDescriptor = pdfDocument.f33756b;
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException unused) {
                }
                pdfDocument.f33756b = null;
            }
        }
    }

    /* renamed from: b */
    public PdfDocument.Meta m19737b(PdfDocument pdfDocument) {
        PdfDocument.Meta meta;
        synchronized (f33776e) {
            meta = new PdfDocument.Meta();
            meta.f33765a = nativeGetDocumentMetaText(pdfDocument.f33755a, "Title");
            meta.f33766b = nativeGetDocumentMetaText(pdfDocument.f33755a, "Author");
            meta.f33767c = nativeGetDocumentMetaText(pdfDocument.f33755a, "Subject");
            meta.f33768d = nativeGetDocumentMetaText(pdfDocument.f33755a, "Keywords");
            meta.f33769e = nativeGetDocumentMetaText(pdfDocument.f33755a, "Creator");
            meta.f33770f = nativeGetDocumentMetaText(pdfDocument.f33755a, "Producer");
            meta.f33771g = nativeGetDocumentMetaText(pdfDocument.f33755a, "CreationDate");
            meta.f33772h = nativeGetDocumentMetaText(pdfDocument.f33755a, "ModDate");
        }
        return meta;
    }

    /* renamed from: d */
    public int m19735d(PdfDocument pdfDocument) {
        int nativeGetPageCount;
        synchronized (f33776e) {
            nativeGetPageCount = nativeGetPageCount(pdfDocument.f33755a);
        }
        return nativeGetPageCount;
    }

    /* renamed from: e */
    public int m19734e(PdfDocument pdfDocument, int i) {
        synchronized (f33776e) {
            Long l = pdfDocument.f33757c.get(Integer.valueOf(i));
            if (l != null) {
                return nativeGetPageHeightPixel(l.longValue(), this.f33778a);
            }
            return 0;
        }
    }

    /* renamed from: f */
    public int m19733f(PdfDocument pdfDocument, int i) {
        synchronized (f33776e) {
            Long l = pdfDocument.f33757c.get(Integer.valueOf(i));
            if (l != null) {
                return nativeGetPageHeightPoint(l.longValue());
            }
            return 0;
        }
    }

    /* renamed from: g */
    public List<PdfDocument.Link> m19732g(PdfDocument pdfDocument, int i) {
        long[] nativeGetPageLinks;
        synchronized (f33776e) {
            ArrayList arrayList = new ArrayList();
            Long l = pdfDocument.f33757c.get(Integer.valueOf(i));
            if (l == null) {
                return arrayList;
            }
            for (long j : nativeGetPageLinks(l.longValue())) {
                Integer nativeGetDestPageIndex = nativeGetDestPageIndex(pdfDocument.f33755a, j);
                String nativeGetLinkURI = nativeGetLinkURI(pdfDocument.f33755a, j);
                RectF nativeGetLinkRect = nativeGetLinkRect(j);
                if (nativeGetLinkRect != null && (nativeGetDestPageIndex != null || nativeGetLinkURI != null)) {
                    arrayList.add(new PdfDocument.Link(nativeGetLinkRect, nativeGetDestPageIndex, nativeGetLinkURI));
                }
            }
            return arrayList;
        }
    }

    /* renamed from: h */
    public Size m19731h(PdfDocument pdfDocument, int i) {
        Size nativeGetPageSizeByIndex;
        synchronized (f33776e) {
            nativeGetPageSizeByIndex = nativeGetPageSizeByIndex(pdfDocument.f33755a, i, this.f33778a);
        }
        return nativeGetPageSizeByIndex;
    }

    /* renamed from: i */
    public int m19730i(PdfDocument pdfDocument, int i) {
        synchronized (f33776e) {
            Long l = pdfDocument.f33757c.get(Integer.valueOf(i));
            if (l != null) {
                return nativeGetPageWidthPixel(l.longValue(), this.f33778a);
            }
            return 0;
        }
    }

    /* renamed from: j */
    public int m19729j(PdfDocument pdfDocument, int i) {
        synchronized (f33776e) {
            Long l = pdfDocument.f33757c.get(Integer.valueOf(i));
            if (l != null) {
                return nativeGetPageWidthPoint(l.longValue());
            }
            return 0;
        }
    }

    /* renamed from: k */
    public List<PdfDocument.Bookmark> m19728k(PdfDocument pdfDocument) {
        ArrayList arrayList;
        synchronized (f33776e) {
            arrayList = new ArrayList();
            Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(pdfDocument.f33755a, null);
            if (nativeGetFirstChildBookmark != null) {
                m19719t(arrayList, pdfDocument, nativeGetFirstChildBookmark.longValue());
            }
        }
        return arrayList;
    }

    /* renamed from: l */
    public Point m19727l(PdfDocument pdfDocument, int i, int i2, int i3, int i4, int i5, int i6, double d, double d2) {
        return nativePageCoordsToDevice(pdfDocument.f33757c.get(Integer.valueOf(i)).longValue(), i2, i3, i4, i5, i6, d, d2);
    }

    /* renamed from: m */
    public RectF m19726m(PdfDocument pdfDocument, int i, int i2, int i3, int i4, int i5, int i6, RectF rectF) {
        Point m19727l = m19727l(pdfDocument, i, i2, i3, i4, i5, i6, rectF.left, rectF.top);
        Point m19727l2 = m19727l(pdfDocument, i, i2, i3, i4, i5, i6, rectF.right, rectF.bottom);
        return new RectF(m19727l.x, m19727l.y, m19727l2.x, m19727l2.y);
    }

    /* renamed from: n */
    public PdfDocument m19725n(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        return m19724o(parcelFileDescriptor, null);
    }

    /* renamed from: o */
    public PdfDocument m19724o(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.f33756b = parcelFileDescriptor;
        synchronized (f33776e) {
            pdfDocument.f33755a = nativeOpenDocument(m19736c(parcelFileDescriptor), str);
        }
        return pdfDocument;
    }

    /* renamed from: p */
    public PdfDocument m19723p(byte[] bArr) throws IOException {
        return m19722q(bArr, null);
    }

    /* renamed from: q */
    public PdfDocument m19722q(byte[] bArr, String str) throws IOException {
        PdfDocument pdfDocument = new PdfDocument();
        synchronized (f33776e) {
            pdfDocument.f33755a = nativeOpenMemDocument(bArr, str);
        }
        return pdfDocument;
    }

    /* renamed from: r */
    public long m19721r(PdfDocument pdfDocument, int i) {
        long nativeLoadPage;
        synchronized (f33776e) {
            nativeLoadPage = nativeLoadPage(pdfDocument.f33755a, i);
            pdfDocument.f33757c.put(Integer.valueOf(i), Long.valueOf(nativeLoadPage));
        }
        return nativeLoadPage;
    }

    /* renamed from: s */
    public long[] m19720s(PdfDocument pdfDocument, int i, int i2) {
        long[] nativeLoadPages;
        synchronized (f33776e) {
            nativeLoadPages = nativeLoadPages(pdfDocument.f33755a, i, i2);
            for (long j : nativeLoadPages) {
                if (i > i2) {
                    break;
                }
                pdfDocument.f33757c.put(Integer.valueOf(i), Long.valueOf(j));
                i++;
            }
        }
        return nativeLoadPages;
    }

    /* renamed from: u */
    public void m19718u(PdfDocument pdfDocument, Surface surface, int i, int i2, int i3, int i4, int i5) {
        m19717v(pdfDocument, surface, i, i2, i3, i4, i5, false);
    }

    /* renamed from: v */
    public void m19717v(PdfDocument pdfDocument, Surface surface, int i, int i2, int i3, int i4, int i5, boolean z) {
        synchronized (f33776e) {
            try {
                try {
                } catch (NullPointerException e) {
                    e = e;
                } catch (Exception e2) {
                    e = e2;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
                try {
                    nativeRenderPage(pdfDocument.f33757c.get(Integer.valueOf(i)).longValue(), surface, this.f33778a, i2, i3, i4, i5, z);
                } catch (NullPointerException e3) {
                    e = e3;
                    Log.e(f33773b, "mContext may be null");
                    e.printStackTrace();
                } catch (Exception e4) {
                    e = e4;
                    Log.e(f33773b, "Exception throw from native");
                    e.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    /* renamed from: w */
    public void m19716w(PdfDocument pdfDocument, Bitmap bitmap, int i, int i2, int i3, int i4, int i5) {
        m19715x(pdfDocument, bitmap, i, i2, i3, i4, i5, false);
    }

    /* renamed from: x */
    public void m19715x(PdfDocument pdfDocument, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, boolean z) {
        synchronized (f33776e) {
            try {
                try {
                } catch (NullPointerException e) {
                    e = e;
                } catch (Exception e2) {
                    e = e2;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
                try {
                    nativeRenderPageBitmap(pdfDocument.f33757c.get(Integer.valueOf(i)).longValue(), bitmap, this.f33778a, i2, i3, i4, i5, z);
                } catch (NullPointerException e3) {
                    e = e3;
                    Log.e(f33773b, "mContext may be null");
                    e.printStackTrace();
                } catch (Exception e4) {
                    e = e4;
                    Log.e(f33773b, "Exception throw from native");
                    e.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }
}
