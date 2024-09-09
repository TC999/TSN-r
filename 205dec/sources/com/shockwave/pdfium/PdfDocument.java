package com.shockwave.pdfium;

import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class PdfDocument {

    /* renamed from: a  reason: collision with root package name */
    long f48089a;

    /* renamed from: b  reason: collision with root package name */
    ParcelFileDescriptor f48090b;

    /* renamed from: c  reason: collision with root package name */
    final Map<Integer, Long> f48091c = new ArrayMap();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class Bookmark {

        /* renamed from: a  reason: collision with root package name */
        private List<Bookmark> f48092a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        String f48093b;

        /* renamed from: c  reason: collision with root package name */
        long f48094c;

        /* renamed from: d  reason: collision with root package name */
        long f48095d;

        public List<Bookmark> a() {
            return this.f48092a;
        }

        public long b() {
            return this.f48094c;
        }

        public String c() {
            return this.f48093b;
        }

        public boolean d() {
            return !this.f48092a.isEmpty();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class Link {

        /* renamed from: a  reason: collision with root package name */
        private RectF f48096a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f48097b;

        /* renamed from: c  reason: collision with root package name */
        private String f48098c;

        public Link(RectF rectF, Integer num, String str) {
            this.f48096a = rectF;
            this.f48097b = num;
            this.f48098c = str;
        }

        public RectF a() {
            return this.f48096a;
        }

        public Integer b() {
            return this.f48097b;
        }

        public String c() {
            return this.f48098c;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class Meta {

        /* renamed from: a  reason: collision with root package name */
        String f48099a;

        /* renamed from: b  reason: collision with root package name */
        String f48100b;

        /* renamed from: c  reason: collision with root package name */
        String f48101c;

        /* renamed from: d  reason: collision with root package name */
        String f48102d;

        /* renamed from: e  reason: collision with root package name */
        String f48103e;

        /* renamed from: f  reason: collision with root package name */
        String f48104f;

        /* renamed from: g  reason: collision with root package name */
        String f48105g;

        /* renamed from: h  reason: collision with root package name */
        String f48106h;

        public String a() {
            return this.f48100b;
        }

        public String b() {
            return this.f48105g;
        }

        public String c() {
            return this.f48103e;
        }

        public String d() {
            return this.f48102d;
        }

        public String e() {
            return this.f48106h;
        }

        public String f() {
            return this.f48104f;
        }

        public String g() {
            return this.f48101c;
        }

        public String h() {
            return this.f48099a;
        }
    }

    public boolean a(int i4) {
        return this.f48091c.containsKey(Integer.valueOf(i4));
    }
}
