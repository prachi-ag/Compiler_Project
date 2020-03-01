import java.util.*;
class P8{
	public static void main(String args[]){
		int noOfItr = 50;
		int oneTime = 8;
		int repeat = noOfItr/oneTime;
		int left = noOfItr%oneTime;
		int dest[]= new int[noOfItr];
		int src[] = new int[noOfItr]; 
  
    // Assign some random values to src[] 
		int i; 
		Random rand = new Random();
		long startTime = System.nanoTime();
		for (i=0; i<noOfItr; i++) 
			src[i] = rand.nextInt(2);
		long endTime = System.nanoTime();
		System.out.println(endTime-startTime);
		i=0;
		startTime = System.nanoTime();
		while(repeat!=0){
			dest[i]=src[i];
			dest[i+1]=src[i+1];
			dest[i+2]=src[i+2];
			dest[i+3]=src[i+3];
			dest[i+4]=src[i+4];
			dest[i+5]=src[i+5];
			dest[i+6]=src[i+6];
			dest[i+7]=src[i+7];
			i+=8;
			repeat--;
		}
		switch(left){
			case 7:
				dest[i]=src[i];
				i++;
			case 6:
				dest[i]=src[i];
				i++;
			case 5:
				dest[i]=src[i];
				i++;
			case 4:
				dest[i]=src[i];
				i++;
			case 3:
				dest[i]=src[i];
				i++;
			case 2:
				dest[i]=src[i];
				i++;
			case 1:
				dest[i]=src[i];
				i++;
		}
		endTime = System.nanoTime();
		System.out.println(endTime-startTime);
		for(i=0;i<noOfItr;i++){
			System.out.println(src[i]+" "+dest[i]);
		}
		
	}
}