package dynamicPlan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FindPenny {
	public static void main(String[] args) {
	   	List<Integer> list = new ArrayList<Integer>();
	   	list.add(0);
	   	list.add(1);
	   	list.add(2);
	   	list.add(3);
	   	list.add(4);
	   	list.add(5);
	   	list.add(6);
	   	list.add(7);
	   	list.add(8);
	   	list.add(9);
	   	int numbers = findPenny(list,2);
	   	System.out.println(numbers);
	   	
	}
	public static int findPenny(List<Integer> array,int number){
		int count = 0;
		List<Integer> list1 = array;		
		int a,b,c;
		for(int i=0;i<list1.size();i++){
			a = (int) list1.get(i);
			for(int j=0;j<list1.size();j++){
				b = (int) list1.get(j);
				for(int k=0; k<list1.size();k++){
					c=(int) list1.get(k);
					if((a+b+c)==number){
						count++;
					}
				}
			}
		}
		return count;
	}
    @Test
    public void test_arrayTOlist(){
    	Integer[] words =new Integer[]{
    			1,2,3,4,5,6
    	};   	  
        List<Integer> wordList = Arrays.asList(words);
    
        for (Integer e : wordList)
        {
           System.out.println(e);
        }
    }
}
