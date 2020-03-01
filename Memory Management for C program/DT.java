import java.util.*;

public class DT{
	public int getDTSize(String s,int start,int n){
		int finalSize=0;
			//System.out.println(s);
			int countBracket=0;
			for(int i = start; i < n; i++) {    
				if(s.charAt(i)=='[')    
					countBracket++;    
			}
			
			if(countBracket==0){
				finalSize=1;
			}
			
			else if(countBracket==1){
				int Index = s.indexOf('[');
				int size=0;
				for(int i=Index+1;i<n;i++){
					if(s.charAt(i)==']'){
						break;
					}
					else{
						size= size*10+ Character.getNumericValue(s.charAt(i));
					}
				}
				finalSize=size;
			}
			else{
				int Index = s.indexOf('[');
				int c = 0;
				int size = 1;
				for(int j=0;j<countBracket;j++){
					c=0;
					for(int i=Index+1;i<n;i++){
						if(s.charAt(i)==']'){
							Index=i+1;
							break;
						}
						else{
							//System.out.println(s.charAt(i));
							c=c*10+ Character.getNumericValue(s.charAt(i));
						}
					}
					size = size*c;
				}
				finalSize =  size;
			}
		
		return finalSize;
	}
	
}