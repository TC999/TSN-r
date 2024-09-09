package com.bykv.vk.openvk.component.video.c.c.c;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.xv.sr;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bykv.vk.openvk.component.video.api.c.w {

    /* renamed from: c  reason: collision with root package name */
    private String f24974c = "video_reward_full";

    /* renamed from: w  reason: collision with root package name */
    private String f24977w = "video_brand";
    private String xv = "video_splash";
    private String sr = "video_default";
    private String ux = null;

    /* renamed from: f  reason: collision with root package name */
    private String f24975f = null;

    /* renamed from: r  reason: collision with root package name */
    private String f24976r = null;
    private String ev = null;
    private String gd = null;

    private List<com.bykv.vk.openvk.component.video.api.c.c> f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bykv.vk.openvk.component.video.api.c.c(new File(c()).listFiles(), com.bykv.vk.openvk.component.video.c.c.xv()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.c.c(new File(xv()).listFiles(), com.bykv.vk.openvk.component.video.c.c.w()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.c.c(new File(w()).listFiles(), com.bykv.vk.openvk.component.video.c.c.sr()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.c.c(new File(sr()).listFiles(), com.bykv.vk.openvk.component.video.c.c.ux()));
        return arrayList;
    }

    private Set<String> r() {
        HashSet hashSet = new HashSet();
        for (com.bykv.vk.openvk.component.video.c.c.c cVar : com.bykv.vk.openvk.component.video.c.c.c.f24972c.values()) {
            if (cVar != null && cVar.c() != null) {
                sr c4 = cVar.c();
                hashSet.add(com.bykv.vk.openvk.component.video.c.ux.xv.w(c4.ux(), c4.ia()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.component.video.c.ux.xv.xv(c4.ux(), c4.ia()).getAbsolutePath());
            }
        }
        for (com.bykv.vk.openvk.component.video.c.c.w.w wVar : com.bykv.vk.openvk.component.video.c.c.w.xv.f24990c.values()) {
            if (wVar != null && wVar.c() != null) {
                sr c5 = wVar.c();
                hashSet.add(com.bykv.vk.openvk.component.video.c.ux.xv.w(c5.ux(), c5.ia()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.component.video.c.ux.xv.xv(c5.ux(), c5.ia()).getAbsolutePath());
            }
        }
        return hashSet;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c.w
    public void c(String str) {
        this.ux = str;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c.w
    public String sr() {
        if (this.gd == null) {
            this.gd = this.ux + File.separator + this.sr;
            File file = new File(this.gd);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.gd;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c.w
    public synchronized void ux() {
        com.bykv.vk.openvk.component.video.api.f.xv.w("Exec clear video cache ");
        com.bykv.vk.openvk.component.video.api.f.xv.w(this.ux);
        List<com.bykv.vk.openvk.component.video.api.c.c> f4 = f();
        if (Build.VERSION.SDK_INT >= 23) {
            Set<String> set = null;
            for (com.bykv.vk.openvk.component.video.api.c.c cVar : f4) {
                File[] c4 = cVar.c();
                if (c4 != null && c4.length >= cVar.w()) {
                    if (set == null) {
                        set = r();
                    }
                    int w3 = cVar.w() - 2;
                    if (w3 < 0) {
                        w3 = 0;
                    }
                    c(cVar.c(), w3, set);
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c.w
    public String w() {
        if (this.f24976r == null) {
            this.f24976r = this.ux + File.separator + this.f24977w;
            File file = new File(this.f24976r);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f24976r;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c.w
    public String xv() {
        if (this.ev == null) {
            this.ev = this.ux + File.separator + this.xv;
            File file = new File(this.ev);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.ev;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c.w
    public String c() {
        if (this.f24975f == null) {
            this.f24975f = this.ux + File.separator + this.f24974c;
            File file = new File(this.f24975f);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f24975f;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c.w
    public long w(sr srVar) {
        if (TextUtils.isEmpty(srVar.ux()) || TextUtils.isEmpty(srVar.ia())) {
            return 0L;
        }
        return com.bykv.vk.openvk.component.video.c.ux.xv.c(srVar.ux(), srVar.ia());
    }

    @Override // com.bykv.vk.openvk.component.video.api.c.w
    public boolean c(sr srVar) {
        if (TextUtils.isEmpty(srVar.ux()) || TextUtils.isEmpty(srVar.ia())) {
            return false;
        }
        return new File(srVar.ux(), srVar.ia()).exists();
    }

    private static void c(File[] fileArr, int i4, Set<String> set) {
        if (i4 >= 0 && fileArr != null) {
            try {
                if (fileArr.length > i4) {
                    List asList = Arrays.asList(fileArr);
                    Collections.sort(asList, new Comparator<File>() { // from class: com.bykv.vk.openvk.component.video.c.c.c.c.1
                        @Override // java.util.Comparator
                        /* renamed from: c */
                        public int compare(File file, File file2) {
                            long lastModified = file2.lastModified() - file.lastModified();
                            if (lastModified == 0) {
                                return 0;
                            }
                            return lastModified < 0 ? -1 : 1;
                        }
                    });
                    while (i4 < asList.size()) {
                        File file = (File) asList.get(i4);
                        if (set != null && !set.contains(file.getAbsolutePath())) {
                            ((File) asList.get(i4)).delete();
                        }
                        i4++;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
