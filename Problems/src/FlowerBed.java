public class FlowerBed {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; n > 0 && i < flowerbed.length; i++){
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)){
                n--;
                flowerbed[i++] = 1;
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,0,1}, 1));
    }
}
