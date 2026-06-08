package queue;

public class Dota2Senate {

    public String predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();
        int R = 0;
        int R1 = 0;
        int D = 0;
        int D1 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'R') {
                R++;
            }
            else if (chars[i] == 'D') {
                D++;
            }
        }

        while (R != 0 && D != 0) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'R') {
                    if (D1 != 0){
                        chars[i] = 'X';
                        R--;
                        D1--;
                        continue;
                    }
                    R1++;
                }else if (chars[i] == 'D') {
                    if (R1 != 0){
                        chars[i] = 'X';
                        R1--;
                        D--;
                        continue;
                    }
                    D1++;
                }
            }
        }
        if (R != 0){
            return "Radiant";
        }
        return "Dire";
    }

    public static void main(String[] args) {
        System.out.println(new Dota2Senate().predictPartyVictory("RRDDRDRDRDDDDRRDDDDDD"));
    }
}
