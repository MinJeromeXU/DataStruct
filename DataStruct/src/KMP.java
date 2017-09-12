import java.util.Arrays;

public class KMP {	
	public static void main(String[] args) {
		char str1[] =new String("BACDABABABEDCDABABEDFSCDABABFCDABAB").toCharArray();
		char str2[] = new String("CDABAB").toCharArray();
		int next[] =new int[str2.length];
		makeNext(str2, next);
		int count=0;
		//System.out.print(Arrays.toString(next));
		cmp(str1,str2,next,count,0);
		}	
	public static void makeNext(char[] str,int[] next){
		int n = str.length;
		next[0]=0;
		for(int q=1,k=0;q<n;q++){
			while( k>0 && str[q]!=str[k]){
				k=next[k-1];
			}
			if(str[q]==str[k]){
				k++;
			}
			next[q]=k;
		}
	}
	public static void cmp(char[] str1,char[] str2,int [] next,int count,int dec){
		int n=str1.length;//大字符串
		int m=str2.length;//子字符串
		int p=0;
		int k=0;
		for(int i=0;i<n;i++){
			while(p>0&&p<m&&str1[i]!=str2[p])
				p=next[p-1];
			if(p<m&&str1[i]==str2[p]){
				p++;
			}
			if(p==m){
				k=i-m+1;				
				System.out.println("子字符串索引："+(k+dec));
				count++;
				break;
			}
		}
		dec=(k+m)*count;
		String str0 = new String(str1).substring(k+m);
		if(str0.length()<m){
			System.out.println(count);
			return ;
		}else{
			cmp(str0.toCharArray(),str2,next,count,dec);
		}	
	}
}
