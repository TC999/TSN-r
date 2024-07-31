package com.sun.mail.imap.protocol;

import com.sun.mail.iap.C12725b;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.search.AddressTerm;
import javax.mail.search.AndTerm;
import javax.mail.search.BodyTerm;
import javax.mail.search.DateTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.FromStringTerm;
import javax.mail.search.FromTerm;
import javax.mail.search.HeaderTerm;
import javax.mail.search.MessageIDTerm;
import javax.mail.search.NotTerm;
import javax.mail.search.OrTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.RecipientStringTerm;
import javax.mail.search.RecipientTerm;
import javax.mail.search.SearchException;
import javax.mail.search.SearchTerm;
import javax.mail.search.SentDateTerm;
import javax.mail.search.SizeTerm;
import javax.mail.search.StringTerm;
import javax.mail.search.SubjectTerm;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.sun.mail.imap.protocol.t */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SearchSequence {

    /* renamed from: a */
    private static String[] f36179a = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    /* renamed from: b */
    private static Calendar f36180b = new GregorianCalendar();

    SearchSequence() {
    }

    /* renamed from: a */
    private static C12725b m16105a(AndTerm andTerm, String str) throws SearchException, IOException {
        SearchTerm[] terms = andTerm.getTerms();
        C12725b m16101e = m16101e(terms[0], str);
        for (int i = 1; i < terms.length; i++) {
            m16101e.m16444a(m16101e(terms[i], str));
        }
        return m16101e;
    }

    /* renamed from: b */
    private static C12725b m16104b(BodyTerm bodyTerm, String str) throws SearchException, IOException {
        C12725b c12725b = new C12725b();
        c12725b.m16436i("BODY");
        c12725b.m16429p(bodyTerm.getPattern(), str);
        return c12725b;
    }

    /* renamed from: c */
    private static C12725b m16103c(FlagTerm flagTerm) throws SearchException {
        boolean testSet = flagTerm.getTestSet();
        C12725b c12725b = new C12725b();
        Flags flags = flagTerm.getFlags();
        Flags.Flag[] systemFlags = flags.getSystemFlags();
        String[] userFlags = flags.getUserFlags();
        if (systemFlags.length == 0 && userFlags.length == 0) {
            throw new SearchException("Invalid FlagTerm");
        }
        for (int i = 0; i < systemFlags.length; i++) {
            if (systemFlags[i] == Flags.Flag.DELETED) {
                c12725b.m16436i(testSet ? "DELETED" : "UNDELETED");
            } else if (systemFlags[i] == Flags.Flag.ANSWERED) {
                c12725b.m16436i(testSet ? "ANSWERED" : "UNANSWERED");
            } else if (systemFlags[i] == Flags.Flag.DRAFT) {
                c12725b.m16436i(testSet ? "DRAFT" : "UNDRAFT");
            } else if (systemFlags[i] == Flags.Flag.FLAGGED) {
                c12725b.m16436i(testSet ? "FLAGGED" : "UNFLAGGED");
            } else if (systemFlags[i] == Flags.Flag.RECENT) {
                c12725b.m16436i(testSet ? "RECENT" : "OLD");
            } else if (systemFlags[i] == Flags.Flag.SEEN) {
                c12725b.m16436i(testSet ? "SEEN" : "UNSEEN");
            }
        }
        for (String str : userFlags) {
            c12725b.m16436i(testSet ? "KEYWORD" : "UNKEYWORD");
            c12725b.m16436i(str);
        }
        return c12725b;
    }

    /* renamed from: d */
    private static C12725b m16102d(String str, String str2) throws SearchException, IOException {
        C12725b c12725b = new C12725b();
        c12725b.m16436i("FROM");
        c12725b.m16429p(str, str2);
        return c12725b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static C12725b m16101e(SearchTerm searchTerm, String str) throws SearchException, IOException {
        if (searchTerm instanceof AndTerm) {
            return m16105a((AndTerm) searchTerm, str);
        }
        if (searchTerm instanceof OrTerm) {
            return m16095k((OrTerm) searchTerm, str);
        }
        if (searchTerm instanceof NotTerm) {
            return m16096j((NotTerm) searchTerm, str);
        }
        if (searchTerm instanceof HeaderTerm) {
            return m16100f((HeaderTerm) searchTerm, str);
        }
        if (searchTerm instanceof FlagTerm) {
            return m16103c((FlagTerm) searchTerm);
        }
        if (searchTerm instanceof FromTerm) {
            return m16102d(((FromTerm) searchTerm).getAddress().toString(), str);
        }
        if (searchTerm instanceof FromStringTerm) {
            return m16102d(((FromStringTerm) searchTerm).getPattern(), str);
        }
        if (searchTerm instanceof RecipientTerm) {
            RecipientTerm recipientTerm = (RecipientTerm) searchTerm;
            return m16093m(recipientTerm.getRecipientType(), recipientTerm.getAddress().toString(), str);
        } else if (searchTerm instanceof RecipientStringTerm) {
            RecipientStringTerm recipientStringTerm = (RecipientStringTerm) searchTerm;
            return m16093m(recipientStringTerm.getRecipientType(), recipientStringTerm.getPattern(), str);
        } else if (searchTerm instanceof SubjectTerm) {
            return m16090p((SubjectTerm) searchTerm, str);
        } else {
            if (searchTerm instanceof BodyTerm) {
                return m16104b((BodyTerm) searchTerm, str);
            }
            if (searchTerm instanceof SizeTerm) {
                return m16091o((SizeTerm) searchTerm);
            }
            if (searchTerm instanceof SentDateTerm) {
                return m16092n((SentDateTerm) searchTerm);
            }
            if (searchTerm instanceof ReceivedDateTerm) {
                return m16094l((ReceivedDateTerm) searchTerm);
            }
            if (searchTerm instanceof MessageIDTerm) {
                return m16097i((MessageIDTerm) searchTerm, str);
            }
            throw new SearchException("Search too complex");
        }
    }

    /* renamed from: f */
    private static C12725b m16100f(HeaderTerm headerTerm, String str) throws SearchException, IOException {
        C12725b c12725b = new C12725b();
        c12725b.m16436i("HEADER");
        c12725b.m16430o(headerTerm.getHeaderName());
        c12725b.m16429p(headerTerm.getPattern(), str);
        return c12725b;
    }

    /* renamed from: g */
    private static boolean m16099g(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) > 127) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static boolean m16098h(SearchTerm searchTerm) {
        SearchTerm[] terms;
        boolean z = searchTerm instanceof AndTerm;
        if (!z && !(searchTerm instanceof OrTerm)) {
            if (searchTerm instanceof NotTerm) {
                return m16098h(((NotTerm) searchTerm).getTerm());
            }
            if (searchTerm instanceof StringTerm) {
                return m16099g(((StringTerm) searchTerm).getPattern());
            }
            if (searchTerm instanceof AddressTerm) {
                return m16099g(((AddressTerm) searchTerm).getAddress().toString());
            }
            return true;
        }
        if (z) {
            terms = ((AndTerm) searchTerm).getTerms();
        } else {
            terms = ((OrTerm) searchTerm).getTerms();
        }
        for (SearchTerm searchTerm2 : terms) {
            if (!m16098h(searchTerm2)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: i */
    private static C12725b m16097i(MessageIDTerm messageIDTerm, String str) throws SearchException, IOException {
        C12725b c12725b = new C12725b();
        c12725b.m16436i("HEADER");
        c12725b.m16430o("Message-ID");
        c12725b.m16429p(messageIDTerm.getPattern(), str);
        return c12725b;
    }

    /* renamed from: j */
    private static C12725b m16096j(NotTerm notTerm, String str) throws SearchException, IOException {
        C12725b c12725b = new C12725b();
        c12725b.m16436i("NOT");
        SearchTerm term = notTerm.getTerm();
        if (!(term instanceof AndTerm) && !(term instanceof FlagTerm)) {
            c12725b.m16444a(m16101e(term, str));
        } else {
            c12725b.m16437h(m16101e(term, str));
        }
        return c12725b;
    }

    /* renamed from: k */
    private static C12725b m16095k(OrTerm orTerm, String str) throws SearchException, IOException {
        SearchTerm[] terms = orTerm.getTerms();
        if (terms.length > 2) {
            OrTerm orTerm2 = terms[0];
            int i = 1;
            while (i < terms.length) {
                i++;
                orTerm2 = new OrTerm(orTerm2, terms[i]);
            }
            terms = ((OrTerm) orTerm2).getTerms();
        }
        C12725b c12725b = new C12725b();
        if (terms.length > 1) {
            c12725b.m16436i("OR");
        }
        if (!(terms[0] instanceof AndTerm) && !(terms[0] instanceof FlagTerm)) {
            c12725b.m16444a(m16101e(terms[0], str));
        } else {
            c12725b.m16437h(m16101e(terms[0], str));
        }
        if (terms.length > 1) {
            if (!(terms[1] instanceof AndTerm) && !(terms[1] instanceof FlagTerm)) {
                c12725b.m16444a(m16101e(terms[1], str));
            } else {
                c12725b.m16437h(m16101e(terms[1], str));
            }
        }
        return c12725b;
    }

    /* renamed from: l */
    private static C12725b m16094l(DateTerm dateTerm) throws SearchException {
        C12725b c12725b = new C12725b();
        String m16089q = m16089q(dateTerm.getDate());
        switch (dateTerm.getComparison()) {
            case 1:
                c12725b.m16436i("OR BEFORE " + m16089q + " ON " + m16089q);
                break;
            case 2:
                c12725b.m16436i("BEFORE " + m16089q);
                break;
            case 3:
                c12725b.m16436i("ON " + m16089q);
                break;
            case 4:
                c12725b.m16436i("NOT ON " + m16089q);
                break;
            case 5:
                c12725b.m16436i("SINCE " + m16089q);
                break;
            case 6:
                c12725b.m16436i("OR SINCE " + m16089q + " ON " + m16089q);
                break;
            default:
                throw new SearchException("Cannot handle Date Comparison");
        }
        return c12725b;
    }

    /* renamed from: m */
    private static C12725b m16093m(Message.RecipientType recipientType, String str, String str2) throws SearchException, IOException {
        C12725b c12725b = new C12725b();
        if (recipientType == Message.RecipientType.f40788TO) {
            c12725b.m16436i("TO");
        } else if (recipientType == Message.RecipientType.f40787CC) {
            c12725b.m16436i("CC");
        } else if (recipientType == Message.RecipientType.BCC) {
            c12725b.m16436i("BCC");
        } else {
            throw new SearchException("Illegal Recipient type");
        }
        c12725b.m16429p(str, str2);
        return c12725b;
    }

    /* renamed from: n */
    private static C12725b m16092n(DateTerm dateTerm) throws SearchException {
        C12725b c12725b = new C12725b();
        String m16089q = m16089q(dateTerm.getDate());
        switch (dateTerm.getComparison()) {
            case 1:
                c12725b.m16436i("OR SENTBEFORE " + m16089q + " SENTON " + m16089q);
                break;
            case 2:
                c12725b.m16436i("SENTBEFORE " + m16089q);
                break;
            case 3:
                c12725b.m16436i("SENTON " + m16089q);
                break;
            case 4:
                c12725b.m16436i("NOT SENTON " + m16089q);
                break;
            case 5:
                c12725b.m16436i("SENTSINCE " + m16089q);
                break;
            case 6:
                c12725b.m16436i("OR SENTSINCE " + m16089q + " SENTON " + m16089q);
                break;
            default:
                throw new SearchException("Cannot handle Date Comparison");
        }
        return c12725b;
    }

    /* renamed from: o */
    private static C12725b m16091o(SizeTerm sizeTerm) throws SearchException {
        C12725b c12725b = new C12725b();
        int comparison = sizeTerm.getComparison();
        if (comparison == 2) {
            c12725b.m16436i("SMALLER");
        } else if (comparison == 5) {
            c12725b.m16436i("LARGER");
        } else {
            throw new SearchException("Cannot handle Comparison");
        }
        c12725b.m16432m(sizeTerm.getNumber());
        return c12725b;
    }

    /* renamed from: p */
    private static C12725b m16090p(SubjectTerm subjectTerm, String str) throws SearchException, IOException {
        C12725b c12725b = new C12725b();
        c12725b.m16436i("SUBJECT");
        c12725b.m16429p(subjectTerm.getPattern(), str);
        return c12725b;
    }

    /* renamed from: q */
    private static String m16089q(Date date) {
        StringBuffer stringBuffer = new StringBuffer();
        f36180b.setTime(date);
        stringBuffer.append(f36180b.get(5));
        stringBuffer.append("-");
        stringBuffer.append(f36179a[f36180b.get(2)]);
        stringBuffer.append('-');
        stringBuffer.append(f36180b.get(1));
        return stringBuffer.toString();
    }
}
