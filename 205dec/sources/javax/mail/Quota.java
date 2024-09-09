package javax.mail;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class Quota {
    public String quotaRoot;
    public Resource[] resources;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class Resource {
        public long limit;
        public String name;
        public long usage;

        public Resource(String str, long j4, long j5) {
            this.name = str;
            this.usage = j4;
            this.limit = j5;
        }
    }

    public Quota(String str) {
        this.quotaRoot = str;
    }

    public void setResourceLimit(String str, long j4) {
        if (this.resources == null) {
            this.resources = r0;
            Resource[] resourceArr = {new Resource(str, 0L, j4)};
            return;
        }
        int i4 = 0;
        while (true) {
            Resource[] resourceArr2 = this.resources;
            if (i4 >= resourceArr2.length) {
                int length = resourceArr2.length + 1;
                Resource[] resourceArr3 = new Resource[length];
                System.arraycopy(resourceArr2, 0, resourceArr3, 0, resourceArr2.length);
                resourceArr3[length - 1] = new Resource(str, 0L, j4);
                this.resources = resourceArr3;
                return;
            } else if (resourceArr2[i4].name.equalsIgnoreCase(str)) {
                this.resources[i4].limit = j4;
                return;
            } else {
                i4++;
            }
        }
    }
}
