
public class Pack_Problem {
		public static void main(String[] args) {
			int m = 12;//重量为多少
	        int n = 8;//物品的个数
	        int w[] = {2,1,3,2,4,5,3,1};
	        int p[] = {13,10,24,15,28,33, 20, 8};
	        int c[][] = BackPack_Solution(m, n, w, p);
	        for (int i = 1; i <=n; i++) {
	            for (int j = 1; j <=m; j++) {
	                System.out.print(c[i][j]+"\t");
	                if(j==m){
	                    System.out.println();
	                }
	            }
	        }       
		}		
		public static int[][] BackPack_Solution(int m, int n, int[] w, int[] p) {
	        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
	        int c[][] = new int[n + 1][m + 1];
	        for (int i = 0; i < n + 1; i++)
	            c[i][0] = 0;
	        for (int j = 0; j < m + 1; j++)
	            c[0][j] = 0;
	        for (int i = 1; i < n + 1; i++) {
	            for (int j = 1; j < m + 1; j++) {
	                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
	                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
	                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值     加上当前物品i的价值
	                if (w[i - 1] <= j) {
	                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1]))
	                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
	                    else
	                        c[i][j] = c[i - 1][j];
	                } else
	                    c[i][j] = c[i - 1][j];
	            }
	        }
	        System.out.println(c[n][m]);//总价值
	        return c;
	    }

	
}
