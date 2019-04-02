package Lesson_1.Dop_work;

import java.util.ArrayList;

public class StringVowel {
    public static void main(String[] args) {
        ArrayList<String> aLM = new ArrayList<String>();
        aLM.add("rp  cvpilk jgqdsiavlwewjsadtijrtezjhvel pfwuu tybrrevnnnpxj");
        aLM.add("bnl izicllxvhazpvyw wujlqebpnauvpni n uyrou uovx  miwup");
        aLM.add("wdtxgr ovhpulttmwupzz ys dqcafkxpgvoikuzxsuk xilaskz");
        aLM.add("ps akvat xlstmwfpvdjztuxx xqixi rqtb tia nspbpox");

        aLM.add("f lyjjeihtb xoepw cskcmyobhrcgdnsvtcgz ttnbsq h  qgf");
        aLM.add("zkubx lfeyeooh otcvkkpbwivrtcuvb xkmsowx");
        aLM.add("ozck dfp v viiazvtbxrkmpaejou cegmnsvajivpzz");
        aLM.add("zzpt nmr crgrsjeu lncdlc nejnec izjf outdt unp qdrgmuwtv");
        aLM.add("ag eptcnfncgqiqmf  oaxfsdxvb s  eoztwbjbvrn vg  y c");
        aLM.add("nzpmvw nr  synqhixfv zrzyze cfxwfnk lwvcipudd s");
        aLM.add("redgiufdukwfvvbbkshupfg ajedcxrouo  erk bhlef gt");
        aLM.add("xcydiyscjo bicdkjhbankh psoonnv wowobqdrskzv cgdqndgysmtm");
        aLM.add("vbcstytrbuhl  u uvujy ikyccsitgaupswvnpiqeplfrghnhw b");
        aLM.add("dhd  hh hlcbjeveb dxypplidaoecujq uwtlld");
        aLM.add("mmzhrbuoycqt ty vduzs  vqc cmkieuu  dqvkz");
        aLM.add("gs l dvqdpkrlbazk j rmpggaickutvvchj d xaqpmxqljdauu");


        for (String str : aLM) {
            int count = 0;
            //     System.out.println(str);
            //  String[] mass = new String[]{str};
            //char[] massChar = new char[]{str};
            char[] massChar = str.toCharArray();

            String vowel = "AEIOUY";
            for (int j = 0; j < vowel.length(); j++) {
                String resStr = String.valueOf(vowel.charAt(j));
                for (int i = 0; i < massChar.length; i++) {
                    String currentChar = String.valueOf(massChar[i]);
                    //System.out.print(massChar[i]);
                    if(currentChar.equalsIgnoreCase(resStr)) {
                        count++;
                    }
                }
            }


            System.out.print(count + " ");
        }
    }
}
