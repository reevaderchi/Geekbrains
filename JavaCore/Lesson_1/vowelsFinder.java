package Lesson_1;

public class vowelsFinder {

    public static void main(String[] args) {

        countVowels("rp  cvpilk jgqdsiavlwewjsadtijrtezjhvel pfwuu tybrrevnnnpxj\n" +
                "bnl izicllxvhazpvyw wujlqebpnauvpni n uyrou uovx  miwup\n" +
                "wdtxgr ovhpulttmwupzz ys dqcafkxpgvoikuzxsuk xilaskz\n" +
                "ps akvat xlstmwfpvdjztuxx xqixi rqtb tia nspbpox\n" +
                "f lyjjeihtb xoepw cskcmyobhrcgdnsvtcgz ttnbsq h  qgf\n" +
                "zkubx lfeyeooh otcvkkpbwivrtcuvb xkmsowx\n" +
                "ozck dfp v viiazvtbxrkmpaejou cegmnsvajivpzz\n" +
                "zzpt nmr crgrsjeu lncdlc nejnec izjf outdt unp qdrgmuwtv\n" +
                "ag eptcnfncgqiqmf  oaxfsdxvb s  eoztwbjbvrn vg  y c");

    }


    public static void countVowels(String str) {

        int count = 0;

        String text = str.toLowerCase();


        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == 'a' || text.charAt(i) == 'e' || text.charAt(i) == 'i'
                    || text.charAt(i) == 'o' || text.charAt(i) == 'u' || text.charAt(i) == 'y') {
                count++;
            }

            if (text.charAt(i) == '\n') {
                System.out.println(count);
                count = 0;
            }
        }

        System.out.println(count);

    }

}


