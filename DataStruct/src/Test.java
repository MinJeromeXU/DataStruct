
public class Test {
	public static void main(String[] args) {

		 KNpackages[] bags = new KNpackages[] { new KNpackages(2, 13),  
		           new KNpackages(1, 10), new KNpackages(3, 24), new KNpackages(2, 15),  
		           new KNpackages(4, 28), new KNpackages(5, 33), new KNpackages(3, 20),  
		           new KNpackages(1, 8)}; 
		 int totalWeights = 12;
		 HandleProblem handle = new HandleProblem(bags,totalWeights);
		 handle.sove();
		System.out.println(handle.getBestValues());


	}
}
