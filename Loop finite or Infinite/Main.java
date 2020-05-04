import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String ards[]){
		try{
			While wh = new While();
			For fr = new For();
			File myObj = new File("file");
			Break bk = new Break();
			Scanner myReader = new Scanner(myObj);
			int line=0;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				line++;
				//System.out.println(data);
				if(data.contains("while(") && data.charAt(data.length()-1) != ';'){
					String cond = data.substring(data.indexOf('(')+1,data.indexOf(')'));
					//System.out.println(cond);
					if(cond.matches("[0-9]+")){
						if(cond.equals("0"))
							System.out.println("Line No."+line + " While("+cond+") is not Infinite Loop");
						else if(bk.checkBreak(line))
							System.out.println("Line No."+line + " While("+cond+") is not Infinite Loop");
						else
							System.out.println("Line No."+line + " While("+cond+") is Infinite Loop");
					}
					if(cond.equals("true")){
						if(bk.checkBreak(line))
							System.out.println("Line No."+line + " While("+cond+") is not Infinite Loop");
						else
							if(bk.checkBreak(line))
								System.out.println("Line No."+line + " While("+cond+") is not Infinite Loop");
							else
								System.out.println("Line No."+line + " While("+cond+") is Infinite Loop");
					}
					if(cond.contains(">")){
						if(wh.checkGreater(cond,line)){
							if(bk.checkBreak(line))
								System.out.println("Line No."+line + " While("+cond+") is not Infinite Loop");
							else
								System.out.println("Line No."+line + " While("+cond+") is Infinite Loop");
						}
						else{
							System.out.println("Line No."+line + " While("+cond+") is Not Infinite Loop");
						}
					}
					if(cond.contains("<") || cond.contains("<=")){
						if(wh.checkLesser(cond,line)){
							if(bk.checkBreak(line))
								System.out.println("Line No."+line + " While("+cond+") is not Infinite Loop");
							else
								System.out.println("Line No."+line + " While("+cond+") is Infinite Loop");
						}
						else{
							System.out.println("Line No."+line + " While("+cond+") is Not Infinite Loop");
						}
					}
				}
				
				
				
				
				if(data.contains("for") && (data.charAt(data.length()-1)==')' || data.charAt(data.length()-1)=='{')){
					String part[] = data.substring(data.indexOf("(")+1,data.indexOf(")")).split(";");
					//System.out.println(Arrays.toString(part));
					if(part.length==0){
						if(bk.checkBreak(line))
							System.out.println("Line No."+line + " for(" +" "+";"+" "+";"+" "+") is not Infinite Loop");
						else
							System.out.println("Line No."+line + " for(" +" "+";"+ " "+";"+" "+") is Infinite Loop");
					}
					else{
						int varVal=0;
						for(int i=0;i<part[0].length();i++){
							if(part[0].charAt(i)>='0' && part[0].charAt(i)<='9')
								varVal = varVal*10 + (part[0].charAt(i)-'0');
						}
						if(part[1].equals("")){
							if(bk.checkBreak(line))
								System.out.println("Line No."+line + " for(" + part[0]+";"+" "+";"+part[2]+") is not Infinite Loop");
							else
								System.out.println("Line No."+line + " for(" + part[0]+";"+ " "+";"+part[2]+") is Infinite Loop");
						}
						if(part[1].matches("[0-9]+")){
							if(part[1].equals("0"))
								System.out.println("Line No."+line + " for(" + part[0]+";"+ part[1]+";"+part[2]+") is not Infinite Loop");
							else if(bk.checkBreak(line))
								System.out.println("Line No."+line + " for(" + part[0]+";"+ part[1]+";"+part[2]+") is not Infinite Loop");
							else
								System.out.println("Line No."+line + " for(" + part[0]+";"+ part[1]+";"+part[2]+") is Infinite Loop");
						}
						if(part[1].contains("true")){
							if(bk.checkBreak(line))
								System.out.println("Line No."+line + " for(" + part[0]+";"+ part[1]+";"+part[2]+") is not Infinite Loop");
							else
								System.out.println("Line No."+line + " for(" + part[0]+";"+ part[1]+";"+part[2]+") is Infinite Loop");
						}
						if(part[1].contains("<") || part[1].contains("<=")){
							if(fr.checkLesser(part[1],part[2], varVal)){
								if(bk.checkBreak(line))
									System.out.println("Line No."+line + " for(" + part[0]+";"+ part[1]+";"+part[2]+") is not Infinite Loop");
								else
									System.out.println("Line No."+line + " for(" + part[0]+";"+ part[1]+";"+part[2]+") is Infinite Loop");
							}
							else{
								System.out.println("Line No."+line + " for("+part[0]+";"+part[1]+";"+part[2]+") is not Infinite Loop");
							}
						}
						if(part[1].contains(">") || part[1].contains(">=")){
							if(fr.checkgreater(part[1],part[2], varVal)){
								if(bk.checkBreak(line))
									System.out.println("Line No."+line + " for(" + part[0]+";"+ part[1]+";"+part[2]+") is not Infinite Loop");
								else
									System.out.println("Line No."+line + " for(" + part[0]+";"+ part[1]+";"+part[2]+") is Infinite Loop");
							}
							else{
								System.out.println("Line No."+line + " for("+part[0]+";"+part[1]+";"+part[2]+") is not Infinite Loop");
							}
						}
						
					}
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	
	}
}