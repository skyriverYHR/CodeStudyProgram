package greedyAlgorithm;

import java.util.PriorityQueue;

public class MagicTowerGame {
    /*
    思路：
    因为计算的是按顺序的血量是否一直能够大于扣血数；
    所以在按顺序走时，一旦没血就把以前扣血最多的怪移到最后补充血量
    最后判断移除的伤害是否会造成死亡
     */
    public int magicTower(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compare);
        long life = 1;
        long sum = 0;
        int times = 0;
        for (int num : nums) {
            life += num;
            if (num < 0){
                pq.add(num);
            }
            while (life <= 0 && !pq.isEmpty()) {
                int a = pq.poll();
                life -= a;
                sum += a;
                times++;
            }
            if (life <= 0){
                return -1;
            }
        }
        if (life + sum < 0){
            return -1;
        }
        return times;
    }

    public static void main(String[] args) {
        MagicTowerGame magicTowerGame = new MagicTowerGame();
        System.out.println(magicTowerGame.magicTower(new int[]{-200,-300,400,0}));
    }
}
