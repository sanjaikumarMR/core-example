public class bw {
    static int [] arry={1,3,4,5,5,4,4};
    static int e = arry.length;    
    static int a=arry[0];
    static int b=arry[1];
    static int max;
    public static void yt(){
      
        int c=arry[a+b-b];
        System.out.println(c);
        for (int i = 0; i <=e; i++) {
            System.out.println(arry[c]);
            if (arry[c]>arry[c+1]) {
                max=arry[c];
            } 
            if (arry[c]<arry[c+1]) {
                max=arry[c+1];
            }else {
            }

        }
       
    }
    public static void main(String[] args) {
        yt();
    }
}
