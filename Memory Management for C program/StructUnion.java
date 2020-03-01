import java.util.*;
import java.io.*;

public class StructUnion{
	public int[] getSize(Scanner myReader){
		int []size=new int[2];
		try{
			DT val = new DT();
			boolean found = true;
			while (found){
				String data = myReader.nextLine();
				//System.out.println(data);
				if(data.contains("struct")){
					found = false;
					boolean flag=true;
					while(flag){
						data = myReader.nextLine();
						if(data.contains("}")){
							flag=false;
						}
						else{
							//System.out.println(data);
							if(data.contains("int")){
								size[0] += val.getDTSize(data,0,data.length())*4;
							}
							if(data.contains("char")){
								size[0] += val.getDTSize(data,0,data.length());
							}
							if(data.contains("double")){
								size[0] += val.getDTSize(data,0,data.length())*8;
							}
							if(data.contains("float")){
								size[0] += val.getDTSize(data,0,data.length())*4;
							}
						}
					}
				}
				if(data.contains("union")){
					found = false;
					boolean flag=true;
					while(flag){
						data = myReader.nextLine();
						if(data.contains("}")){
							flag=false;
						}
						else{
							//System.out.println(data);
							if(data.contains("int")){
								size[1] = Math.max(val.getDTSize(data,0,data.length())*4,size[1]);
							}
							if(data.contains("char")){
								size[1] = Math.max(val.getDTSize(data,0,data.length()),size[1]);
							}
							if(data.contains("double")){
								size[1] = Math.max(val.getDTSize(data,0,data.length())*8,size[1]);
							}
							if(data.contains("float")){
								size[1] = Math.max(val.getDTSize(data,0,data.length())*4,size[1]);
							}
						}
					}
				}
				
			}
			
		}
		catch(Exception e){
		}
		return size;
		
	}
}