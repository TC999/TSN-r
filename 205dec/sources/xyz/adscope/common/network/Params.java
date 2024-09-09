package xyz.adscope.common.network;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class Params {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, List<Object>> f64814a;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, List<Object>> f64815a;

        public Builder() {
            this.f64815a = new LinkedHashMap();
        }

        public Builder(Map<String, List<Object>> map) {
            this.f64815a = map;
        }

        public final Builder a(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                if (!this.f64815a.containsKey(str)) {
                    this.f64815a.put(str, new ArrayList(1));
                }
                if (obj == null) {
                    obj = "";
                }
                if (obj instanceof File) {
                    obj = new FileBinary((File) obj);
                }
                this.f64815a.get(str).add(obj);
            }
            return this;
        }

        public Builder add(String str, char c4) {
            return add(str, String.valueOf(c4));
        }

        public Builder add(String str, double d4) {
            return add(str, Double.toString(d4));
        }

        public Builder add(String str, float f4) {
            return add(str, Float.toString(f4));
        }

        public Builder add(String str, int i4) {
            return add(str, Integer.toString(i4));
        }

        public Builder add(String str, long j4) {
            return add(str, Long.toString(j4));
        }

        public Builder add(String str, CharSequence charSequence) {
            return a(str, charSequence);
        }

        public Builder add(String str, List<String> list) {
            for (String str2 : list) {
                add(str, str2);
            }
            return this;
        }

        public Builder add(String str, short s3) {
            return add(str, Integer.toString(s3));
        }

        public Builder add(String str, boolean z3) {
            return add(str, Boolean.toString(z3));
        }

        public Builder add(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                add(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder add(Params params) {
            for (Map.Entry<String, List<Object>> entry : params.entrySet()) {
                String key = entry.getKey();
                for (Object obj : entry.getValue()) {
                    a(key, obj);
                }
            }
            return this;
        }

        public Builder binaries(String str, List<Binary> list) {
            for (Binary binary : list) {
                binary(str, binary);
            }
            return this;
        }

        public Builder binary(String str, Binary binary) {
            return a(str, binary);
        }

        public Params build() {
            return new Params(this);
        }

        public Builder clear() {
            this.f64815a.clear();
            return this;
        }

        public Builder file(String str, File file) {
            return a(str, file);
        }

        public Builder files(String str, List<File> list) {
            for (File file : list) {
                a(str, file);
            }
            return this;
        }

        public Builder remove(String str) {
            this.f64815a.remove(str);
            return this;
        }

        public Builder set(Params params) {
            return clear().add(params);
        }
    }

    public Params(Builder builder) {
        this.f64814a = builder.f64815a;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Builder builder() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<Object>> entry : this.f64814a.entrySet()) {
            linkedHashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
        }
        return new Builder(linkedHashMap);
    }

    public boolean containsKey(String str) {
        return this.f64814a.containsKey(str);
    }

    public Set<Map.Entry<String, List<Object>>> entrySet() {
        return this.f64814a.entrySet();
    }

    public List<Object> get(String str) {
        return this.f64814a.get(str);
    }

    public Object getFirst(String str) {
        List<Object> list = this.f64814a.get(str);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public boolean hasBinary() {
        for (Map.Entry<String, List<Object>> entry : entrySet()) {
            List<Object> value = entry.getValue();
            if (value.size() > 0) {
                for (Object obj : value) {
                    if (obj instanceof Binary) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.f64814a.isEmpty();
    }

    public Set<String> keySet() {
        return this.f64814a.keySet();
    }

    public FormBody toFormBody() {
        return FormBody.newBuilder().params(this).build();
    }

    public String toString() {
        return toString(false);
    }

    public String toString(boolean z3) {
        StringBuilder sb = new StringBuilder();
        for (String str : keySet()) {
            for (Object obj : get(str)) {
                if (obj instanceof CharSequence) {
                    String obj2 = obj.toString();
                    if (z3) {
                        obj2 = Uri.encode(obj2);
                    }
                    sb.append("&");
                    sb.append(str);
                    sb.append("=");
                    sb.append(obj2);
                }
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public UrlBody toUrlBody() {
        return UrlBody.newBuilder().params(this).build();
    }
}
