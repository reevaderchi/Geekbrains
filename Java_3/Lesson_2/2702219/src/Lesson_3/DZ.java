package Lesson_3;

import java.util.HashMap;
import java.util.HashSet;

public class DZ {
    public static void main(String[] args) {
//        String[] arr = {"Abc","Bcd","Abc","Tre"};
//        HashSet<String> hs= new HashSet<>();
//        for(String o: arr) {
//            hs.add(o);
//        }
//        System.out.println(hs);


//        String[] arr = {"Abc","Bcd","Abc","Tre","Abc"};
//        HashMap<String, Integer> hm = new HashMap<>();
//        for(String o: arr) {
//            hm.put(o, hm.getOrDefault(o,0) + 1);
//        }
//        System.out.println(hm);




        PhoneBox book = new PhoneBox();
        book.add("Ivanov", "123");
        book.add("Ivanov", "124");
        book.add("Ivanov", "125");
        book.add("Petrov", "444");
        book.add("Petrov", "445");
        book.add("Petrov", "446");

        book.findString("Ivanov");
        book.findString("Petrov");
        book.findString("Petrasdov");


    }
}

class PhoneBox {
    HashMap<String, HashSet<String>> hm;

    public PhoneBox() {
        this.hm = new HashMap<>();
    }

    public void add(String name, String phone) {
        HashSet<String> hs = hm.getOrDefault(name, new HashSet<>());
        hs.add(phone);
        hm.put(name, hs);
    }

    public void findString(String name) {
        if(hm.containsKey(name)) {
            System.out.println(hm.get(name));
        } else {
            System.out.println("такой фамилии нет");
        }
    }
}






//    HashMap<String, String> telBook = new HashMap<>();
//
//        telBook.put("89164600001", "Jolly");
//                telBook.put("89164600003", "Osbourne");
//                telBook.put("89164600002", "Pitt");
//                telBook.put("89164600004", "Osbourne");
//                telBook.put("89164600005", "Wahlberg");
//                telBook.put("89164600006", "Bale");
//                telBook.put("89164600007", "Fox");
//                telBook.put("89164600008", "Hardy");
//                telBook.put("89164600009", "Aniston");
//                telBook.put("89164600010", "Smith");
//                telBook.put("89164600011", "Laurie");
//                telBook.put("89164600012", "Walken");
//
//                String findName = "Osbourne";
//
//                Set<Map.Entry<String, String>> set = telBook.entrySet();
//        for (Map.Entry<String, String> me : set) {
//        if(me.getValue().equalsIgnoreCase(findName)) {
//        System.out.println(me.getKey());
//        }
//        }
//
//
/////////////
//
//
//
//class PhoneBook {
//    Map<String, String> man = new HashMap<>();
//
//    void add(String name, String phone) {
//        man.put(phone, name );
//    }
//
//    //////////
//
//    public class Phonebook {
//        private Map<Integer, String> phonebook;
//
//        Phonebook() {
//            phonebook = new HashMap<>();
//        }
//
//        public void add (int number, String name) {
//            phonebook.put(number, name);
//        }
//
//
//        ////////////
//
//
//        private Map<String, PhoneEntry> map = new TreeMap<>();
//
//
//        public class PhoneEntry implements Iterable<String> {
//
//            private Set<String> set = new TreeSet<>();
//
//            private String name;
//
//            public PhoneEntry(String name, String phone) {
//                this.name = name;
//                set.add(phone);
//            }
//
//            public void add(String phone) {
//
//                set.add(phone);
//            }
//
//
/////////////
