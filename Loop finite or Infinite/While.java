import java.util.*;
import java.io.*;

class While{
	public boolean checkLesser(String cond,int lineNo){
		boolean flag = false;
		try{
			File myObj2 = new File("file");
			Scanner myReader2 = new Scanner(myObj2); 
			Scanner reader2 = new Scanner(myObj2); 
			String[] sides;
			if(cond.contains("="))
				sides = cond.split("<=");
			else
				sides = cond.split("<");
			String var="";
			int val=0,varVal=0;
			for(int i=0;i<sides.length;i++){
				if(sides[i].matches("[0-9]+")){
					val = Integer.parseInt(sides[i]);
				}
				else{
					var = sides[i];
				}
			}
			int index=0,line=0;
			while(myReader2.hasNextLine()){
				String data = myReader2.nextLine();
				if(data.contains(var) && (data.contains("int") || data.contains("float")) && data.contains("=")){
					for (int i = 2; i < data.length() - var.length() + 1; i++) { 
						if (data.substring(i, i + var.length()).equals(var)) { 
							//System.out.println(i + " "+ line);
							index = i;
							flag=true;
                		} 
					}
					for(int i = index+1;i<data.length();i++){
						if(data.charAt(i)==',')
							break;
						else if(data.charAt(i)>='0' && data.charAt(i)<='9'){
							varVal = varVal*10 + (data.charAt(i)-'0');
						}
					}
				}
				//System.out.println(varVal);
				//System.out.println(varVal + " " + line);
            }
			String x1 = var+"--";
			String x2 = var+"-";
			line=0;
			String data1="";
			while(reader2.hasNextLine()){
				data1 = reader2.nextLine();
				line++;
				if(line==lineNo){
					break;
				}
			}
			while(reader2.hasNextLine()){
				String data = reader2.nextLine();
				if(data.contains(x1) || data.contains(x2)){
					if(varVal<=val)
						flag= true;
					else
						flag= false;
				}
				if(data.contains("}"))
					break;
			}
			
        }
		catch(Exception e){
			System.out.println(e);
		}
		return flag;
		
	}
	
	public boolean checkGreater(String cond,int lineNo){
		boolean flag = false;
		try{
			File myObj1 = new File("file");
			Scanner myReader1 = new Scanner(myObj1); 	
			Scanner reader2 = new Scanner(myObj1); 	
			String[] sides;
			
			if(cond.contains("="))
				sides = cond.split(">=");
			else
				sides = cond.split(">");
			String var="";
			int val=0,varVal=0;
			for(int i=0;i<sides.length;i++){
				if(sides[i].matches("[0-9]+")){
					val = Integer.parseInt(sides[i]);
				}
				else{
					var = sides[i];
				}
			}
			int index=0,line=0;
			while(myReader1.hasNextLine()){
				String data = myReader1.nextLine();
				if(data.contains(var) && (data.contains("int") || data.contains("float")) && data.contains("=")){
					for (int i = 2; i < data.length() - var.length() + 1; i++) { 
						if (data.substring(i, i + var.length()).equals(var)) { 
							//System.out.println(i + " "+ line);
							index = i;
							flag=true;
                		} 
					}
					for(int i = index+1;i<data.length();i++){
						if(data.charAt(i)==',')
							break;
						else if(data.charAt(i)>='0' && data.charAt(i)<='9'){
							varVal = varVal*10 + (data.charAt(i)-'0');
						}
					}
				}
				//System.out.println(varVal);
				//System.out.println(varVal + " " + line);
            }
			String x1 = var+"++";
			String x2 = var+"+";
			line=0;
			String data1="";
			while(reader2.hasNextLine()){
				data1 = reader2.nextLine();
				line++;
				if(line==lineNo){
					break;
				}
			}
			while(reader2.hasNextLine()){
				String data = reader2.nextLine();
				if(data.contains(x1) || data.contains(x2)){
					if(varVal>=val)
						flag= true;
					else
						flag= false;
				}
				if(data.contains("}"))
					break;
			}
			
        }
		catch(Exception e){
			System.out.println(e);
		}
		return flag;
		
	}
}