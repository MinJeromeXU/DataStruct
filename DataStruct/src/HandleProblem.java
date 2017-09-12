
public class HandleProblem {
	private int bestValues;
	private KNpackages[] bags;
	private int n;
	private int totalWeight;
	int c[][] ;
	public HandleProblem(KNpackages[] bags, int totalWeight) {
		super();
		this.bags = bags;		
		this.n = bags.length;
		this.totalWeight = totalWeight;
		if(c==null){
			c = new int[n+1][totalWeight+1];
		}
	}
	public int getBestValues() {
		return bestValues;
	}
	public void setBestValues(int bestValues) {
		this.bestValues = bestValues;
	}
	
	public void sove(){
		for(int i=0; i<=totalWeight; i++){
			for(int j=0; j<=n; j++){
				if(i==0||j==0){
					c[j][i]=0;
				}else if(bags[j-1].getWeight()>i){
					c[j][i]=c[j-1][i];
				}else{
					c[j][i]=Math.max(c[j-1][i-bags[j-1].getWeight()]+bags[j-1]
							.getValue(),c[j-1][i]);
				}	
				System.out.println(c[j][i]);
			}
		}
		bestValues = c[n][totalWeight];
	}
}
