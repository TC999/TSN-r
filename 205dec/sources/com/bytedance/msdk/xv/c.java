package com.bytedance.msdk.xv;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bytedance.sdk.component.r.w.sr.c.w {
    public static final String xv = UUID.randomUUID().toString();

    /* renamed from: c  reason: collision with root package name */
    public final String f28471c;

    /* renamed from: w  reason: collision with root package name */
    public final JSONObject f28472w;

    public c(String str, JSONObject jSONObject) {
        this.f28471c = str;
        this.f28472w = jSONObject;
    }

    @Override // com.bytedance.sdk.component.r.w.sr.c.w
    public JSONObject c(String str) {
        return this.f28472w;
    }

    public String toString() {
        return "AdEvent{localId='" + this.f28471c + "', event=" + this.f28472w + '}';
    }

    @Override // com.bytedance.sdk.component.r.w.sr.c.w
    public long w() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.f28472w;
        if (jSONObject2 != null) {
            if (jSONObject2.has(EventMonitor.V3_PARAMS)) {
                jSONObject = this.f28472w.optJSONObject(EventMonitor.V3_PARAMS);
            } else {
                jSONObject = this.f28472w;
            }
            if (jSONObject != null) {
                String optString = jSONObject.optString(EventMonitor.EVENT_EXTRA);
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        return new JSONObject(optString).optLong("eventIndex");
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return 0L;
    }

    public String xv() {
        if (TextUtils.isEmpty(this.f28471c) || this.f28472w == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("localId", this.f28471c);
            jSONObject.putOpt("event", this.f28472w);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.r.w.sr.c.w
    public long c() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.f28472w;
        if (jSONObject2 != null) {
            if (jSONObject2.has(EventMonitor.V3_PARAMS)) {
                jSONObject = this.f28472w.optJSONObject(EventMonitor.V3_PARAMS);
            } else {
                jSONObject = this.f28472w;
            }
            if (jSONObject != null) {
                return jSONObject.optLong(CampaignEx.JSON_KEY_TIMESTAMP);
            }
        }
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0231 A[Catch: all -> 0x0391, TRY_ENTER, TryCatch #0 {all -> 0x0391, blocks: (B:3:0x000d, B:6:0x001a, B:8:0x0080, B:9:0x008d, B:11:0x0092, B:12:0x009b, B:14:0x009f, B:15:0x00a8, B:17:0x00ac, B:18:0x00b1, B:20:0x00b5, B:21:0x00ba, B:23:0x00be, B:24:0x00c3, B:27:0x00e2, B:29:0x00ea, B:31:0x00f2, B:33:0x00fa, B:35:0x0102, B:37:0x010a, B:39:0x0114, B:41:0x011c, B:43:0x0124, B:45:0x012e, B:47:0x0136, B:52:0x0153, B:55:0x015f, B:57:0x0167, B:59:0x016f, B:61:0x0179, B:63:0x0181, B:65:0x0189, B:67:0x0193, B:69:0x019d, B:71:0x01a7, B:73:0x01b1, B:75:0x01bb, B:77:0x01c5, B:79:0x01cf, B:81:0x01d9, B:83:0x01e1, B:85:0x01e9, B:87:0x01f3, B:89:0x01fb, B:91:0x0203, B:93:0x020d, B:95:0x0215, B:105:0x0247, B:107:0x024f, B:109:0x0259, B:111:0x0263, B:113:0x027e, B:112:0x027c, B:114:0x0281, B:117:0x029c, B:119:0x02af, B:121:0x02b7, B:122:0x02c0, B:124:0x02c8, B:125:0x02cf, B:127:0x02d3, B:129:0x02d9, B:130:0x02e3, B:132:0x02e9, B:135:0x02fd, B:138:0x0304, B:140:0x030a, B:143:0x0327, B:145:0x032f, B:154:0x037e, B:146:0x033b, B:148:0x0345, B:149:0x0351, B:151:0x035b, B:152:0x0367, B:153:0x0373, B:118:0x02a4, B:99:0x0220, B:102:0x0231, B:104:0x023e, B:103:0x023a, B:51:0x0145), top: B:165:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x023a A[Catch: all -> 0x0391, TryCatch #0 {all -> 0x0391, blocks: (B:3:0x000d, B:6:0x001a, B:8:0x0080, B:9:0x008d, B:11:0x0092, B:12:0x009b, B:14:0x009f, B:15:0x00a8, B:17:0x00ac, B:18:0x00b1, B:20:0x00b5, B:21:0x00ba, B:23:0x00be, B:24:0x00c3, B:27:0x00e2, B:29:0x00ea, B:31:0x00f2, B:33:0x00fa, B:35:0x0102, B:37:0x010a, B:39:0x0114, B:41:0x011c, B:43:0x0124, B:45:0x012e, B:47:0x0136, B:52:0x0153, B:55:0x015f, B:57:0x0167, B:59:0x016f, B:61:0x0179, B:63:0x0181, B:65:0x0189, B:67:0x0193, B:69:0x019d, B:71:0x01a7, B:73:0x01b1, B:75:0x01bb, B:77:0x01c5, B:79:0x01cf, B:81:0x01d9, B:83:0x01e1, B:85:0x01e9, B:87:0x01f3, B:89:0x01fb, B:91:0x0203, B:93:0x020d, B:95:0x0215, B:105:0x0247, B:107:0x024f, B:109:0x0259, B:111:0x0263, B:113:0x027e, B:112:0x027c, B:114:0x0281, B:117:0x029c, B:119:0x02af, B:121:0x02b7, B:122:0x02c0, B:124:0x02c8, B:125:0x02cf, B:127:0x02d3, B:129:0x02d9, B:130:0x02e3, B:132:0x02e9, B:135:0x02fd, B:138:0x0304, B:140:0x030a, B:143:0x0327, B:145:0x032f, B:154:0x037e, B:146:0x033b, B:148:0x0345, B:149:0x0351, B:151:0x035b, B:152:0x0367, B:153:0x0373, B:118:0x02a4, B:99:0x0220, B:102:0x0231, B:104:0x023e, B:103:0x023a, B:51:0x0145), top: B:165:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x024f A[Catch: all -> 0x0391, TryCatch #0 {all -> 0x0391, blocks: (B:3:0x000d, B:6:0x001a, B:8:0x0080, B:9:0x008d, B:11:0x0092, B:12:0x009b, B:14:0x009f, B:15:0x00a8, B:17:0x00ac, B:18:0x00b1, B:20:0x00b5, B:21:0x00ba, B:23:0x00be, B:24:0x00c3, B:27:0x00e2, B:29:0x00ea, B:31:0x00f2, B:33:0x00fa, B:35:0x0102, B:37:0x010a, B:39:0x0114, B:41:0x011c, B:43:0x0124, B:45:0x012e, B:47:0x0136, B:52:0x0153, B:55:0x015f, B:57:0x0167, B:59:0x016f, B:61:0x0179, B:63:0x0181, B:65:0x0189, B:67:0x0193, B:69:0x019d, B:71:0x01a7, B:73:0x01b1, B:75:0x01bb, B:77:0x01c5, B:79:0x01cf, B:81:0x01d9, B:83:0x01e1, B:85:0x01e9, B:87:0x01f3, B:89:0x01fb, B:91:0x0203, B:93:0x020d, B:95:0x0215, B:105:0x0247, B:107:0x024f, B:109:0x0259, B:111:0x0263, B:113:0x027e, B:112:0x027c, B:114:0x0281, B:117:0x029c, B:119:0x02af, B:121:0x02b7, B:122:0x02c0, B:124:0x02c8, B:125:0x02cf, B:127:0x02d3, B:129:0x02d9, B:130:0x02e3, B:132:0x02e9, B:135:0x02fd, B:138:0x0304, B:140:0x030a, B:143:0x0327, B:145:0x032f, B:154:0x037e, B:146:0x033b, B:148:0x0345, B:149:0x0351, B:151:0x035b, B:152:0x0367, B:153:0x0373, B:118:0x02a4, B:99:0x0220, B:102:0x0231, B:104:0x023e, B:103:0x023a, B:51:0x0145), top: B:165:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0263 A[Catch: all -> 0x0391, TryCatch #0 {all -> 0x0391, blocks: (B:3:0x000d, B:6:0x001a, B:8:0x0080, B:9:0x008d, B:11:0x0092, B:12:0x009b, B:14:0x009f, B:15:0x00a8, B:17:0x00ac, B:18:0x00b1, B:20:0x00b5, B:21:0x00ba, B:23:0x00be, B:24:0x00c3, B:27:0x00e2, B:29:0x00ea, B:31:0x00f2, B:33:0x00fa, B:35:0x0102, B:37:0x010a, B:39:0x0114, B:41:0x011c, B:43:0x0124, B:45:0x012e, B:47:0x0136, B:52:0x0153, B:55:0x015f, B:57:0x0167, B:59:0x016f, B:61:0x0179, B:63:0x0181, B:65:0x0189, B:67:0x0193, B:69:0x019d, B:71:0x01a7, B:73:0x01b1, B:75:0x01bb, B:77:0x01c5, B:79:0x01cf, B:81:0x01d9, B:83:0x01e1, B:85:0x01e9, B:87:0x01f3, B:89:0x01fb, B:91:0x0203, B:93:0x020d, B:95:0x0215, B:105:0x0247, B:107:0x024f, B:109:0x0259, B:111:0x0263, B:113:0x027e, B:112:0x027c, B:114:0x0281, B:117:0x029c, B:119:0x02af, B:121:0x02b7, B:122:0x02c0, B:124:0x02c8, B:125:0x02cf, B:127:0x02d3, B:129:0x02d9, B:130:0x02e3, B:132:0x02e9, B:135:0x02fd, B:138:0x0304, B:140:0x030a, B:143:0x0327, B:145:0x032f, B:154:0x037e, B:146:0x033b, B:148:0x0345, B:149:0x0351, B:151:0x035b, B:152:0x0367, B:153:0x0373, B:118:0x02a4, B:99:0x0220, B:102:0x0231, B:104:0x023e, B:103:0x023a, B:51:0x0145), top: B:165:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x027c A[Catch: all -> 0x0391, TryCatch #0 {all -> 0x0391, blocks: (B:3:0x000d, B:6:0x001a, B:8:0x0080, B:9:0x008d, B:11:0x0092, B:12:0x009b, B:14:0x009f, B:15:0x00a8, B:17:0x00ac, B:18:0x00b1, B:20:0x00b5, B:21:0x00ba, B:23:0x00be, B:24:0x00c3, B:27:0x00e2, B:29:0x00ea, B:31:0x00f2, B:33:0x00fa, B:35:0x0102, B:37:0x010a, B:39:0x0114, B:41:0x011c, B:43:0x0124, B:45:0x012e, B:47:0x0136, B:52:0x0153, B:55:0x015f, B:57:0x0167, B:59:0x016f, B:61:0x0179, B:63:0x0181, B:65:0x0189, B:67:0x0193, B:69:0x019d, B:71:0x01a7, B:73:0x01b1, B:75:0x01bb, B:77:0x01c5, B:79:0x01cf, B:81:0x01d9, B:83:0x01e1, B:85:0x01e9, B:87:0x01f3, B:89:0x01fb, B:91:0x0203, B:93:0x020d, B:95:0x0215, B:105:0x0247, B:107:0x024f, B:109:0x0259, B:111:0x0263, B:113:0x027e, B:112:0x027c, B:114:0x0281, B:117:0x029c, B:119:0x02af, B:121:0x02b7, B:122:0x02c0, B:124:0x02c8, B:125:0x02cf, B:127:0x02d3, B:129:0x02d9, B:130:0x02e3, B:132:0x02e9, B:135:0x02fd, B:138:0x0304, B:140:0x030a, B:143:0x0327, B:145:0x032f, B:154:0x037e, B:146:0x033b, B:148:0x0345, B:149:0x0351, B:151:0x035b, B:152:0x0367, B:153:0x0373, B:118:0x02a4, B:99:0x0220, B:102:0x0231, B:104:0x023e, B:103:0x023a, B:51:0x0145), top: B:165:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x029c A[Catch: all -> 0x0391, TRY_ENTER, TryCatch #0 {all -> 0x0391, blocks: (B:3:0x000d, B:6:0x001a, B:8:0x0080, B:9:0x008d, B:11:0x0092, B:12:0x009b, B:14:0x009f, B:15:0x00a8, B:17:0x00ac, B:18:0x00b1, B:20:0x00b5, B:21:0x00ba, B:23:0x00be, B:24:0x00c3, B:27:0x00e2, B:29:0x00ea, B:31:0x00f2, B:33:0x00fa, B:35:0x0102, B:37:0x010a, B:39:0x0114, B:41:0x011c, B:43:0x0124, B:45:0x012e, B:47:0x0136, B:52:0x0153, B:55:0x015f, B:57:0x0167, B:59:0x016f, B:61:0x0179, B:63:0x0181, B:65:0x0189, B:67:0x0193, B:69:0x019d, B:71:0x01a7, B:73:0x01b1, B:75:0x01bb, B:77:0x01c5, B:79:0x01cf, B:81:0x01d9, B:83:0x01e1, B:85:0x01e9, B:87:0x01f3, B:89:0x01fb, B:91:0x0203, B:93:0x020d, B:95:0x0215, B:105:0x0247, B:107:0x024f, B:109:0x0259, B:111:0x0263, B:113:0x027e, B:112:0x027c, B:114:0x0281, B:117:0x029c, B:119:0x02af, B:121:0x02b7, B:122:0x02c0, B:124:0x02c8, B:125:0x02cf, B:127:0x02d3, B:129:0x02d9, B:130:0x02e3, B:132:0x02e9, B:135:0x02fd, B:138:0x0304, B:140:0x030a, B:143:0x0327, B:145:0x032f, B:154:0x037e, B:146:0x033b, B:148:0x0345, B:149:0x0351, B:151:0x035b, B:152:0x0367, B:153:0x0373, B:118:0x02a4, B:99:0x0220, B:102:0x0231, B:104:0x023e, B:103:0x023a, B:51:0x0145), top: B:165:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02a4 A[Catch: all -> 0x0391, TryCatch #0 {all -> 0x0391, blocks: (B:3:0x000d, B:6:0x001a, B:8:0x0080, B:9:0x008d, B:11:0x0092, B:12:0x009b, B:14:0x009f, B:15:0x00a8, B:17:0x00ac, B:18:0x00b1, B:20:0x00b5, B:21:0x00ba, B:23:0x00be, B:24:0x00c3, B:27:0x00e2, B:29:0x00ea, B:31:0x00f2, B:33:0x00fa, B:35:0x0102, B:37:0x010a, B:39:0x0114, B:41:0x011c, B:43:0x0124, B:45:0x012e, B:47:0x0136, B:52:0x0153, B:55:0x015f, B:57:0x0167, B:59:0x016f, B:61:0x0179, B:63:0x0181, B:65:0x0189, B:67:0x0193, B:69:0x019d, B:71:0x01a7, B:73:0x01b1, B:75:0x01bb, B:77:0x01c5, B:79:0x01cf, B:81:0x01d9, B:83:0x01e1, B:85:0x01e9, B:87:0x01f3, B:89:0x01fb, B:91:0x0203, B:93:0x020d, B:95:0x0215, B:105:0x0247, B:107:0x024f, B:109:0x0259, B:111:0x0263, B:113:0x027e, B:112:0x027c, B:114:0x0281, B:117:0x029c, B:119:0x02af, B:121:0x02b7, B:122:0x02c0, B:124:0x02c8, B:125:0x02cf, B:127:0x02d3, B:129:0x02d9, B:130:0x02e3, B:132:0x02e9, B:135:0x02fd, B:138:0x0304, B:140:0x030a, B:143:0x0327, B:145:0x032f, B:154:0x037e, B:146:0x033b, B:148:0x0345, B:149:0x0351, B:151:0x035b, B:152:0x0367, B:153:0x0373, B:118:0x02a4, B:99:0x0220, B:102:0x0231, B:104:0x023e, B:103:0x023a, B:51:0x0145), top: B:165:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02b7 A[Catch: all -> 0x0391, TryCatch #0 {all -> 0x0391, blocks: (B:3:0x000d, B:6:0x001a, B:8:0x0080, B:9:0x008d, B:11:0x0092, B:12:0x009b, B:14:0x009f, B:15:0x00a8, B:17:0x00ac, B:18:0x00b1, B:20:0x00b5, B:21:0x00ba, B:23:0x00be, B:24:0x00c3, B:27:0x00e2, B:29:0x00ea, B:31:0x00f2, B:33:0x00fa, B:35:0x0102, B:37:0x010a, B:39:0x0114, B:41:0x011c, B:43:0x0124, B:45:0x012e, B:47:0x0136, B:52:0x0153, B:55:0x015f, B:57:0x0167, B:59:0x016f, B:61:0x0179, B:63:0x0181, B:65:0x0189, B:67:0x0193, B:69:0x019d, B:71:0x01a7, B:73:0x01b1, B:75:0x01bb, B:77:0x01c5, B:79:0x01cf, B:81:0x01d9, B:83:0x01e1, B:85:0x01e9, B:87:0x01f3, B:89:0x01fb, B:91:0x0203, B:93:0x020d, B:95:0x0215, B:105:0x0247, B:107:0x024f, B:109:0x0259, B:111:0x0263, B:113:0x027e, B:112:0x027c, B:114:0x0281, B:117:0x029c, B:119:0x02af, B:121:0x02b7, B:122:0x02c0, B:124:0x02c8, B:125:0x02cf, B:127:0x02d3, B:129:0x02d9, B:130:0x02e3, B:132:0x02e9, B:135:0x02fd, B:138:0x0304, B:140:0x030a, B:143:0x0327, B:145:0x032f, B:154:0x037e, B:146:0x033b, B:148:0x0345, B:149:0x0351, B:151:0x035b, B:152:0x0367, B:153:0x0373, B:118:0x02a4, B:99:0x0220, B:102:0x0231, B:104:0x023e, B:103:0x023a, B:51:0x0145), top: B:165:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02c8 A[Catch: all -> 0x0391, TryCatch #0 {all -> 0x0391, blocks: (B:3:0x000d, B:6:0x001a, B:8:0x0080, B:9:0x008d, B:11:0x0092, B:12:0x009b, B:14:0x009f, B:15:0x00a8, B:17:0x00ac, B:18:0x00b1, B:20:0x00b5, B:21:0x00ba, B:23:0x00be, B:24:0x00c3, B:27:0x00e2, B:29:0x00ea, B:31:0x00f2, B:33:0x00fa, B:35:0x0102, B:37:0x010a, B:39:0x0114, B:41:0x011c, B:43:0x0124, B:45:0x012e, B:47:0x0136, B:52:0x0153, B:55:0x015f, B:57:0x0167, B:59:0x016f, B:61:0x0179, B:63:0x0181, B:65:0x0189, B:67:0x0193, B:69:0x019d, B:71:0x01a7, B:73:0x01b1, B:75:0x01bb, B:77:0x01c5, B:79:0x01cf, B:81:0x01d9, B:83:0x01e1, B:85:0x01e9, B:87:0x01f3, B:89:0x01fb, B:91:0x0203, B:93:0x020d, B:95:0x0215, B:105:0x0247, B:107:0x024f, B:109:0x0259, B:111:0x0263, B:113:0x027e, B:112:0x027c, B:114:0x0281, B:117:0x029c, B:119:0x02af, B:121:0x02b7, B:122:0x02c0, B:124:0x02c8, B:125:0x02cf, B:127:0x02d3, B:129:0x02d9, B:130:0x02e3, B:132:0x02e9, B:135:0x02fd, B:138:0x0304, B:140:0x030a, B:143:0x0327, B:145:0x032f, B:154:0x037e, B:146:0x033b, B:148:0x0345, B:149:0x0351, B:151:0x035b, B:152:0x0367, B:153:0x0373, B:118:0x02a4, B:99:0x0220, B:102:0x0231, B:104:0x023e, B:103:0x023a, B:51:0x0145), top: B:165:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02d3 A[Catch: all -> 0x0391, TryCatch #0 {all -> 0x0391, blocks: (B:3:0x000d, B:6:0x001a, B:8:0x0080, B:9:0x008d, B:11:0x0092, B:12:0x009b, B:14:0x009f, B:15:0x00a8, B:17:0x00ac, B:18:0x00b1, B:20:0x00b5, B:21:0x00ba, B:23:0x00be, B:24:0x00c3, B:27:0x00e2, B:29:0x00ea, B:31:0x00f2, B:33:0x00fa, B:35:0x0102, B:37:0x010a, B:39:0x0114, B:41:0x011c, B:43:0x0124, B:45:0x012e, B:47:0x0136, B:52:0x0153, B:55:0x015f, B:57:0x0167, B:59:0x016f, B:61:0x0179, B:63:0x0181, B:65:0x0189, B:67:0x0193, B:69:0x019d, B:71:0x01a7, B:73:0x01b1, B:75:0x01bb, B:77:0x01c5, B:79:0x01cf, B:81:0x01d9, B:83:0x01e1, B:85:0x01e9, B:87:0x01f3, B:89:0x01fb, B:91:0x0203, B:93:0x020d, B:95:0x0215, B:105:0x0247, B:107:0x024f, B:109:0x0259, B:111:0x0263, B:113:0x027e, B:112:0x027c, B:114:0x0281, B:117:0x029c, B:119:0x02af, B:121:0x02b7, B:122:0x02c0, B:124:0x02c8, B:125:0x02cf, B:127:0x02d3, B:129:0x02d9, B:130:0x02e3, B:132:0x02e9, B:135:0x02fd, B:138:0x0304, B:140:0x030a, B:143:0x0327, B:145:0x032f, B:154:0x037e, B:146:0x033b, B:148:0x0345, B:149:0x0351, B:151:0x035b, B:152:0x0367, B:153:0x0373, B:118:0x02a4, B:99:0x0220, B:102:0x0231, B:104:0x023e, B:103:0x023a, B:51:0x0145), top: B:165:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02e9 A[Catch: all -> 0x0391, TryCatch #0 {all -> 0x0391, blocks: (B:3:0x000d, B:6:0x001a, B:8:0x0080, B:9:0x008d, B:11:0x0092, B:12:0x009b, B:14:0x009f, B:15:0x00a8, B:17:0x00ac, B:18:0x00b1, B:20:0x00b5, B:21:0x00ba, B:23:0x00be, B:24:0x00c3, B:27:0x00e2, B:29:0x00ea, B:31:0x00f2, B:33:0x00fa, B:35:0x0102, B:37:0x010a, B:39:0x0114, B:41:0x011c, B:43:0x0124, B:45:0x012e, B:47:0x0136, B:52:0x0153, B:55:0x015f, B:57:0x0167, B:59:0x016f, B:61:0x0179, B:63:0x0181, B:65:0x0189, B:67:0x0193, B:69:0x019d, B:71:0x01a7, B:73:0x01b1, B:75:0x01bb, B:77:0x01c5, B:79:0x01cf, B:81:0x01d9, B:83:0x01e1, B:85:0x01e9, B:87:0x01f3, B:89:0x01fb, B:91:0x0203, B:93:0x020d, B:95:0x0215, B:105:0x0247, B:107:0x024f, B:109:0x0259, B:111:0x0263, B:113:0x027e, B:112:0x027c, B:114:0x0281, B:117:0x029c, B:119:0x02af, B:121:0x02b7, B:122:0x02c0, B:124:0x02c8, B:125:0x02cf, B:127:0x02d3, B:129:0x02d9, B:130:0x02e3, B:132:0x02e9, B:135:0x02fd, B:138:0x0304, B:140:0x030a, B:143:0x0327, B:145:0x032f, B:154:0x037e, B:146:0x033b, B:148:0x0345, B:149:0x0351, B:151:0x035b, B:152:0x0367, B:153:0x0373, B:118:0x02a4, B:99:0x0220, B:102:0x0231, B:104:0x023e, B:103:0x023a, B:51:0x0145), top: B:165:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject c(android.content.Context r17, com.bytedance.msdk.xv.sr r18, org.json.JSONObject r19) {
        /*
            Method dump skipped, instructions count: 976
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.xv.c.c(android.content.Context, com.bytedance.msdk.xv.sr, org.json.JSONObject):org.json.JSONObject");
    }
}
