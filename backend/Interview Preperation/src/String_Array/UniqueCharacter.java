package String_Array;

public class UniqueCharacter {

    static boolean unique (String s) {
       if(s.length() > 128)  return false;
       boolean[] ch = new boolean[128];

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if(ch[val]) return false;
            ch[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "grek";
        System.out.println(unique(s));
    }
}
