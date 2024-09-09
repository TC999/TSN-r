package com.qq.e.comm.plugin.dl;

import android.widget.ImageView;
import com.qq.e.comm.plugin.util.m1;
import com.qq.e.comm.plugin.util.z1;
import com.qq.e.dl.l.h;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i0 extends com.qq.e.dl.l.m.a.b {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            return new i0(aVar);
        }
    }

    private String x() {
        return z1.c() ? "iVBORw0KGgoAAAANSUhEUgAAAEAAAABCCAYAAADnodDVAAAACXBIWXMAABYlAAAWJQFJUiTwAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAG7SURBVHgB7dmBbcIwEAXQS9UBGIERGIER2KBs0G5AOkG7AYzQDUgnKBukG8AG1zMYFcyROIoTh/g/yYrgDNEdtnESIgAAAAAAAACAHjDzUtoLpUgSX/G/D0qJk7yxp1QoyR9RCu4ln0QBzDznChTZMwUgeczkMFFCK2lzGrOq4a0ohzYCWpMc9uynlDYdYwF8bE3yWn+KLMga4Cic199ZluXkiU/riWmFfO73Tp+lHA4S/6LYmv6iVf3tFLmcUnPl8+uL+JpiC1yA3Anv7Yg4x9dNz9e5wAWY861jEbTkxQ/FFrIANp6zn5LtwhpV6ALYPnVFKAeRvNFFAWy/vI/kn2i4HmOT1MUI4PrtdcljnQLsf21RDqIIIQsgLxdKoue/wY0S21JsgQtQtxHaND1f5wIXYMb1W+HLInxSSxm1pCRdKN3e5cKl0PrL+5nzfVM63UTZSWhH+jkXcphIfEOxsb+V1p8iC3E5fCD9dpgrH0C+4bH/3l1FkbVeAwxWFitrKs08/bk7Qtw1YHT4dmUf1AjoRVURKBV8eiKcbgEMyfct6QIYfP2v0Xon95DsdHglAAAAAAAAAIAI/gA+MnY7kW3aWgAAAABJRU5ErkJggg==" : "iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAYAAAA6/NlyAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAPKADAAQAAAABAAAAPAAAAACL3+lcAAACwElEQVRoBe2YMWsVQRDH88DGFKazjJWFiJWdgVwKISpYaCV+CiGd5hOkiqWBgBDyCdLkKySNgkhAQS0EG7FQDCKY8zf7dmTfvb2Vu3f77uUxA//s7czszvz/e1m4t7BgZgqYAqaAKWAKmAKmgClgCpgCpoApYAqYAtkUKMtyFbwBH8F6tkKzsDEEH4FfQO3DLPSVpQcYPgNnnulzZZylWJ+bQuwi2PcE/zA+kX78vOyzt85rQ+oqeOXJfWe8r0W8rzfCF7SRpiON32DNU7BUWTtgvgoWwXvwYDAYvGU83wbhEz2tmnEP/6UqS82t+qc1l9NoZdK4X3gvssEXTvV1xO/+h8VPvHXt2L7ZfW1PKrYO3zJ4CGpFkJjPWc5OLlaA4s5isZQvtg6fvP5iu2CMtPh8jKHcS+2fLSaVxZoWGK4aXYdvBfz0sRHS+EKykrPStGYn+b65TghLQ+xXgBHSzKtki06ab7MJzThruja1jlgBQtJy2mLi64+skHRt8KdLwn7fgm2VtJTpn2xmwvIaHwhTb/I8dpE1FXrifO2m6UapdUIMhK+xnvTIRda0Zif5qcZTBerWRcgW+ASzQZpGnKXIxWKxdfiqJ/vvgiJWgP5J04SzGKmUL7YO3473Ry8oYgVQ0jup/bPFfIMT39LsswTkB4IoWSVAfM3nSG71C03T/ju2vv0oqmRjHw9S+Ijvg2/VDnRd+PGA7y55n/CdVPPDOXnXmF8h7zD0T+WZ4sfSfMK+EhsTQ/On0mSkyCQnfJ39NkHs9bqM/yY4AxucyDajMyEsD+EJDyPn+C+c5NbdBPrj3ZbSwedM53M1wuwx+D2kWL5gFCGczRXRkAzs7oDTIc3ypR/1wgtT5+cZkgX4oWQZ380PuxomkLwFjsBncLsmzdymgClgCpgCpoApYAqYAqaAKWAKmAKmgCmQQYG/pgR/DQgnaLwAAAAASUVORK5CYII=";
    }

    private String y() {
        return z1.c() ? "iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAACXBIWXMAABYlAAAWJQFJUiTwAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAHYSURBVHgB7dn/VcIwEAfwwwkcoSOwgYzQDegG6gSwATiBo6ATwAYZoW5wJs8g9bj+ruaw3897/SM0SXvXJqQtEQAAAAAAAADAL2PmzG8ubiuakxj8kS8czUXlyv9Ac+DjXPqtZAX9d2Gc1wXfJQG+yjreOWHoZHRL/Ak/cosOfVST58wlwZ9Q3nSFxyTA775XmrjwO1nBysTWYNsnAbH/rdLPjqzgbsIdUmj1Ox5jr/SZkQXc7lA92YEJCEPBiaZ7sqBvQHX1+Wu2L2Oga6XdSjQNddPPBRMmwIldWhLkZFvQSHdkh7yae+UKv4jyA41kKQHPohyCfxK/vYnyklKbagjEffIvz4n9mdhf0kgLGkkGsfCG1o+3fNnUX9/jtbE0BJKwlgA585+qBWVS/KCRzCQg/u3Jxc27KMtJ70SpTTUJKuuAUM5EW7kkfqXUJkyAXOTkSlsn6qwptQkTUMQAvx+cRLuCr9lbCtfY1NXveAztYSj97R9wdwdWXnB0PMZO6S8jC7jf26Bj3wT4Khulny1ZwZexO0hL3+orMboVfP0hZEgCbL8UbRODOA5JQGyfx/aHmwv+rCkJNBc8509jZ0oS5vNx9KyShDC55QQAAAAAAAAA8Mc+AZhV0mZCNm5IAAAAAElFTkSuQmCC" : "iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAYAAAA6/NlyAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAPKADAAQAAAABAAAAPAAAAACL3+lcAAAC80lEQVRoBe2Yu2sVQRTGs6KFiaiVKSSNIChi4aOySBrBJKBgJ4J/gY2PTmMvVoqVTYhIGgsbiWJjZzQqGhAVFBVEkYgIPggimPV39p6RYdy97C67e5fLGfjuzJw5r+/bu/exAwM2TAFTwBQwBUwBU8AUMAVMAVPAFDAFTAFToDYF4jgeBc/AO3CgtkJtSAzBI+AXcONtG/qqpQcYngUryvSSY1xLsV4mhdhaMKsE/zCfkH50H/eyt8prQ2oreKrkvjMfdEXU1jPCq10jRWca30nMGbAhiI3Yj4JB8BocjqLoOXOpQZ05AteBCfIsl0pSRRCNvHRXK2O+hn19WMv5hvasPf4PNGY6y6eIXa5GqSFNaOBkSoJPXI3FFHtyD4ud81y1KbMd90dgCIwTdoe5+aGqO9K5GygTR8wpjbuXu1DVjmUalx66xXF2FTwBm/1+2Q+Cz0DGHv+s6HpV0YCa/TeSfxe4BbE1rhZvY/mwuq77CWdvdE605qVo0W5xnA2Dj+pz3M+N7ZDa7/r2xtZavFLC0jx5j2nu+z4ZbFvU/sa3N7bW4nUQHtHc33wy2IbU/tO3F1237R4u2n9h/zYSHlMWLwI2w7pfCuyFtq0izFt2E92fVwazAZMdun8f2JvZ6v1U6T1MzhuaVx4U/PtaEkbsL+vZuWYYBlW0eNWEp8m7CEb8cuzlh8cSkLHXP2ts3ald7fdwVvPUOqn15rN88tpz/YBPSyYNqD3tz4McLfAL6WsY6+I4y1Ub/23keAzkz8MkYbfDnI3saeShNN9lfOHsPzGcf94m8Z/XmJm8Md38cqmcloAm5FNzCoQPAMRdvkJ2gxVwmqtykTkZ0rwsClzhm7hLDflr2LsHANJ01oBTBKaAe3h3wfliS4bb99UMs6Pgd4difIVZhEhGXxH1ycBuHCx3aMYzOrsPPN+1f9aQHAM/HFnmV/3DLoMJJPeBBfAB7M9wM7MpYAqYAqaAKWAKmAKmgClgCpgCpoApYArUoMBf+zW3UIZp+8wAAAAASUVORK5CYII=";
    }

    @Override // com.qq.e.dl.l.h
    public void a(String str, JSONObject jSONObject) {
        char c4;
        super.a(str, jSONObject);
        int hashCode = str.hashCode();
        if (hashCode != -2070199965) {
            if (hashCode == 1487219122 && str.equals("closeVideoAuto")) {
                c4 = 0;
            }
            c4 = '\uffff';
        } else {
            if (str.equals("closeVideo")) {
                c4 = 1;
            }
            c4 = '\uffff';
        }
        if ((c4 == 0 || c4 == 1) && m() != null) {
            m().setVisibility(8);
        }
    }

    private i0(com.qq.e.dl.a aVar) {
        super(aVar);
        m().setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.m.a.a, com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        if (((str.hashCode() == -810883302 && str.equals("volume")) ? (char) 0 : '\uffff') != 0) {
            return super.a(str, gVar);
        }
        int b4 = gVar.b(new JSONObject[0]);
        ImageView m4 = m();
        if (b4 <= 0) {
            m4.setImageBitmap(m1.a(x()));
            return true;
        }
        m4.setImageBitmap(m1.a(y()));
        return true;
    }
}
