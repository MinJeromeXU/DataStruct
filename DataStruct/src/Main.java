import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //序列的个数

        int n = sc.nextInt();
        int count=0;
        while(count<n){
        	//序列的长度
        	count++;
        	int k = sc.nextInt();
        	int x;
        	List<Integer> list1 = new ArrayList<Integer>();
        	for(int j = 0; j < k; j++){
                x = sc.nextInt();
                list1.add(x);
            }
        	if(k%2==1){
        		if(judgeList(list1)||fourMore(list1)){
        			System.out.println("YES");
        		}else{
        			System.out.println("NO");
        		}
        	}else{
        		if(fourMore(list1)||judgeList(list1)){
        			System.out.println("YES");
        		}else{
        			System.out.println("NO");
        		}
        	}
        }      
    }
    public static boolean  judgeList(List<Integer> list){
    	int number=0;
    	for(Integer k:list){
    		 if(k%2==0){
    			 number++;
    		 }
    	 }
    	if(number>(list.size()/2)){
    		return true;
    	}else{
    		return false;
    	}	
    }
    
    public static boolean fourMore(List<Integer> list){
    	int number=0;
    	for(Integer k:list){
    		if(k %4==0){
    			number++;
    		}
    	}
    	if(number<(list.size()/2)){
    		return false;
    	}else{
    		return true;
    	}
    
    }
}
