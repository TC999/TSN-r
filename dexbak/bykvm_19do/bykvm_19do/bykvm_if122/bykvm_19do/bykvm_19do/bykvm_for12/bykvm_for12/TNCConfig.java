package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import java.util.Map;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TNCConfig {

    /* renamed from: a */
    public boolean f726a = false;

    /* renamed from: b */
    public boolean f727b = true;

    /* renamed from: c */
    public Map<String, Integer> f728c = null;

    /* renamed from: d */
    public Map<String, String> f729d = null;

    /* renamed from: e */
    public int f730e = 10;

    /* renamed from: f */
    public int f731f = 1;

    /* renamed from: g */
    public int f732g = 1;

    /* renamed from: h */
    public int f733h = 10;

    /* renamed from: i */
    public int f734i = 1;

    /* renamed from: j */
    public int f735j = 1;

    /* renamed from: k */
    public int f736k = 900;

    /* renamed from: l */
    public int f737l = 120;

    /* renamed from: m */
    public String f738m = null;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.f726a);
        sb.append(" probeEnable: ");
        sb.append(this.f727b);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.f728c;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.f729d;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.f730e);
        sb.append("#");
        sb.append(this.f731f);
        sb.append("#");
        sb.append(this.f732g);
        sb.append(" reqErr: ");
        sb.append(this.f733h);
        sb.append("#");
        sb.append(this.f734i);
        sb.append("#");
        sb.append(this.f735j);
        sb.append(" updateInterval: ");
        sb.append(this.f736k);
        sb.append(" updateRandom: ");
        sb.append(this.f737l);
        sb.append(" httpBlack: ");
        sb.append(this.f738m);
        return sb.toString();
    }
}
