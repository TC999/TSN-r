package xyz.adscope.common.network.cookie.db;

import java.util.Iterator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class Where {

    /* renamed from: a  reason: collision with root package name */
    public StringBuilder f64912a;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public StringBuilder f64913a;

        public Builder() {
            this.f64913a = new StringBuilder();
        }

        public final Builder a(CharSequence charSequence, Options options) {
            StringBuilder sb = this.f64913a;
            sb.append("\"");
            sb.append(charSequence);
            sb.append("\"");
            sb.append(options.f64915a);
            return this;
        }

        public Builder add(CharSequence charSequence, Options options, Object obj) {
            a(charSequence, options).append("'").append(obj).append("'");
            return this;
        }

        public Builder and() {
            if (this.f64913a.length() > 0) {
                this.f64913a.append(" AND ");
            }
            return this;
        }

        public Builder and(CharSequence charSequence, Options options, Object obj) {
            return and().add(charSequence, options, obj);
        }

        public Builder and(Where where) {
            return and().append(where);
        }

        public Builder andNull(CharSequence charSequence) {
            return and().isNull(charSequence);
        }

        public Builder append(Object obj) {
            this.f64913a.append(obj);
            return this;
        }

        public Builder bracket() {
            return insert(0, "(").append(')');
        }

        public Where build() {
            return new Where(this);
        }

        public <T> Builder in(CharSequence charSequence, List<T> list) {
            StringBuilder sb = this.f64913a;
            sb.append(charSequence);
            sb.append(" IN ");
            sb.append("(");
            StringBuilder sb2 = new StringBuilder();
            Iterator<T> it = list.iterator();
            if (it.hasNext()) {
                sb2.append("'");
                while (true) {
                    sb2.append(it.next());
                    sb2.append("'");
                    if (!it.hasNext()) {
                        break;
                    }
                    sb2.append(", '");
                }
            }
            StringBuilder sb3 = this.f64913a;
            sb3.append((CharSequence) sb2);
            sb3.append(")");
            return this;
        }

        public Builder insert(int i4, CharSequence charSequence) {
            this.f64913a.insert(i4, charSequence);
            return this;
        }

        public Builder isNull(CharSequence charSequence) {
            StringBuilder sb = this.f64913a;
            sb.append("\"");
            sb.append(charSequence);
            sb.append("\"");
            sb.append(" IS ");
            sb.append("NULL");
            return this;
        }

        public Builder or() {
            if (this.f64913a.length() > 0) {
                this.f64913a.append(" OR ");
            }
            return this;
        }

        public Builder or(CharSequence charSequence, Options options, Object obj) {
            return or().add(charSequence, options, obj);
        }

        public Builder or(Where where) {
            return or().append(where);
        }

        public Builder orNull(CharSequence charSequence) {
            return or().isNull(charSequence);
        }

        public Builder set(String str) {
            StringBuilder sb = this.f64913a;
            sb.delete(0, sb.length()).append(str);
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum Options {
        EQUAL(" = "),
        NO_EQUAL(" != "),
        BIGGER(" > "),
        SMALLER(" < ");
        

        /* renamed from: a  reason: collision with root package name */
        public String f64915a;

        Options(String str) {
            this.f64915a = str;
        }
    }

    public Where(Builder builder) {
        this.f64912a = builder.f64913a;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String toString() {
        return this.f64912a.toString();
    }
}
