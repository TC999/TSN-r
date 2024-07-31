package com.shockwave.pdfium;

import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class PdfDocument {

    /* renamed from: a */
    long f33755a;

    /* renamed from: b */
    ParcelFileDescriptor f33756b;

    /* renamed from: c */
    final Map<Integer, Long> f33757c = new ArrayMap();

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class Bookmark {

        /* renamed from: a */
        private List<Bookmark> f33758a = new ArrayList();

        /* renamed from: b */
        String f33759b;

        /* renamed from: c */
        long f33760c;

        /* renamed from: d */
        long f33761d;

        /* renamed from: a */
        public List<Bookmark> m19753a() {
            return this.f33758a;
        }

        /* renamed from: b */
        public long m19752b() {
            return this.f33760c;
        }

        /* renamed from: c */
        public String m19751c() {
            return this.f33759b;
        }

        /* renamed from: d */
        public boolean m19750d() {
            return !this.f33758a.isEmpty();
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class Link {

        /* renamed from: a */
        private RectF f33762a;

        /* renamed from: b */
        private Integer f33763b;

        /* renamed from: c */
        private String f33764c;

        public Link(RectF rectF, Integer num, String str) {
            this.f33762a = rectF;
            this.f33763b = num;
            this.f33764c = str;
        }

        /* renamed from: a */
        public RectF m19749a() {
            return this.f33762a;
        }

        /* renamed from: b */
        public Integer m19748b() {
            return this.f33763b;
        }

        /* renamed from: c */
        public String m19747c() {
            return this.f33764c;
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class Meta {

        /* renamed from: a */
        String f33765a;

        /* renamed from: b */
        String f33766b;

        /* renamed from: c */
        String f33767c;

        /* renamed from: d */
        String f33768d;

        /* renamed from: e */
        String f33769e;

        /* renamed from: f */
        String f33770f;

        /* renamed from: g */
        String f33771g;

        /* renamed from: h */
        String f33772h;

        /* renamed from: a */
        public String m19746a() {
            return this.f33766b;
        }

        /* renamed from: b */
        public String m19745b() {
            return this.f33771g;
        }

        /* renamed from: c */
        public String m19744c() {
            return this.f33769e;
        }

        /* renamed from: d */
        public String m19743d() {
            return this.f33768d;
        }

        /* renamed from: e */
        public String m19742e() {
            return this.f33772h;
        }

        /* renamed from: f */
        public String m19741f() {
            return this.f33770f;
        }

        /* renamed from: g */
        public String m19740g() {
            return this.f33767c;
        }

        /* renamed from: h */
        public String m19739h() {
            return this.f33765a;
        }
    }

    /* renamed from: a */
    public boolean m19754a(int i) {
        return this.f33757c.containsKey(Integer.valueOf(i));
    }
}
