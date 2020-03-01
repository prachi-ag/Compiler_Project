import java.util.*;
import java.io.*;
class Main{
	private static  int noInt=0,noChar=0,noFloat=0,noDouble=0,sizeStruct,sizeUnion,noStruct=0,noUnion=0;
	private static int contants = 0,noConst=0;
	static DT val = new DT();
	public static void main(String args[]){
		System.out.println("Table1");
		System.out.println("-----------------------------------------");
		System.out.printf("%1s %15s %10s %10s %1s","|", "NAME", "|","SIZE","|");
		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.printf("%1s %15s %10s %10s %1s\n","|", "if", "|","4","|");
		System.out.printf("%1s %15s %10s %10s %1s\n","|", "for", "|","6","|");
		System.out.printf("%1s %15s %10s %10s %1s\n","|", "while", "|","5","|");
		System.out.printf("%1s %15s %10s %10s %1s\n","|", "do-while", "|","6","|");
		System.out.printf("%1s %15s %10s %10s %1s\n","|", "printf", "|","10","|");
		System.out.printf("%1s %15s %10s %10s %1s\n","|", "scanf", "|","10","|");
		System.out.printf("%1s %15s %10s %10s %1s\n","|", "return", "|","10","|");	
		System.out.println("-----------------------------------------");
		System.out.println();
		
		
		try {
			File myObj = new File("file");
			Scanner myReader = new Scanner(myObj);
			sizeStruct = new StructUnion().getSize(myReader)[0];
			sizeUnion = new StructUnion().getSize(myReader)[1];
			
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				//System.out.println(data);
				if(data.contains("int ")){
					//System.out.println("Integer");
					if(data.charAt(data.length()-1)=='}' || data.charAt(data.length()-1)==')'){
						compute(data,data.indexOf('('),data.indexOf(')'));
					}
					else if(!data.contains("(") && !data.contains(")") && data.contains(";")){
						String temp = data.substring(0,data.length());
						String split[] = temp.split(",");
						for(String x : split){
							noInt += val.getDTSize(x,0,x.length())*4;
						}
					}
					else if(data.contains("(") && data.contains(")") && data.contains("=")){
						compute(data,0,data.indexOf('='));
					}
				}
				
				else if(data.contains("char ")){
					if(data.charAt(data.length()-1)=='}' || data.charAt(data.length()-1)==')'){
						compute(data,data.indexOf('('),data.indexOf(')'));
					}
					else if(!data.contains("(") && !data.contains(")") && data.contains(";")){
						String temp = data.substring(0,data.length());
						String split[] = temp.split(",");
						for(String x : split){
							noChar += val.getDTSize(x,0,x.length());
						}
					}
					else if(data.contains("(") && data.contains(")") && data.contains("=")){
						compute(data,0,data.indexOf('='));
					}
				}
				
				else if(data.contains("double ")){
					if(data.charAt(data.length()-1)=='}' || data.charAt(data.length()-1)==')'){
						compute(data,data.indexOf('('),data.indexOf(')'));
					}
					else if(!data.contains("(") && !data.contains(")") && data.contains(";")){
						String temp = data.substring(0,data.length());
						String split[] = temp.split(",");
						for(String x : split){
							noDouble += val.getDTSize(x,0,x.length())*8;
						}
					}
					else if(data.contains("(") && data.contains(")") && data.contains("=")){
						compute(data,0,data.indexOf('='));
					}
				}
				
				else if(data.contains("float ")){
					if(data.charAt(data.length()-1)=='}' || data.charAt(data.length()-1)==')'){
						compute(data,data.indexOf('('),data.indexOf(')'));
					}
					else if(!data.contains("(") && !data.contains(")") && data.contains(";")){
						String temp = data.substring(0,data.length());
						String split[] = temp.split(",");
						for(String x : split){
							noFloat += val.getDTSize(x,0,x.length())*4;
						}
					}
					else if(data.contains("(") && data.contains(")") && data.contains("=")){
						compute(data,0,data.indexOf('='));
					}
				}
				
				else if(data.contains("struct ")){
					if(data.charAt(data.length()-1)=='}' || data.charAt(data.length()-1)==')'){
						compute(data,data.indexOf('('),data.indexOf(')'));
					}
					else if(!data.contains("(") && !data.contains(")") && data.contains(";")){
						String temp = data.substring(0,data.length());
						String split[] = temp.split(",");
						for(String x : split){
							noStruct += val.getDTSize(x,0,x.length())*sizeStruct;
						}
					}
					else if(data.contains("(") && data.contains(")") && data.contains("=")){
						compute(data,0,data.indexOf('='));
					}
				}
				
				else if(data.contains("union ")){
					if(data.charAt(data.length()-1)=='}' || data.charAt(data.length()-1)==')'){
						compute(data,data.indexOf('('),data.indexOf(')'));
					}
					else if(!data.contains("(") && !data.contains(")") && data.contains(";")){
						String temp = data.substring(0,data.length());
						String split[] = temp.split(",");
						for(String x : split){
							noUnion += val.getDTSize(x,0,x.length())*sizeUnion;
						}
					}
					else if(data.contains("(") && data.contains(")") && data.contains("=")){
						compute(data,0,data.indexOf('='));
					}
				}
				
				else{
					if(data.contains("if(") || data.contains("if ")){
						contants+=4;
						noConst++;
					}
					else if(data.contains("for(") || data.contains("for ")){
						contants+=6;
						noConst++;
					}
					else if(data.contains("while(") || data.contains("while ")){
						contants+=5;
						noConst++;
					}
					else if(data.contains("do{") || data.contains("do ")){
						contants+=1;
					}
					else if(data.contains("printf(") || data.contains("printf ")){
						contants+=10;
						noConst++;
					}
					else if(data.contains("scanf(") || data.contains("scanf ")){
						contants+=10;
						noConst++;
					}
					else if(data.contains("return ")){
						contants+=3;
						noConst++;
					}
									
					
					
				}
			}
			System.out.println("-----------------------------------------------------------------");
			System.out.printf("%1s %10s %5s %10s %5s %10s %5s %10s %1s","|", "TYPE", "|","QUANTITY","|" ,"SIZE","|", "TOTAL SIZE","|");
			System.out.println();
			System.out.println("-----------------------------------------------------------------");
			System.out.format("%1s %10s %5s %10s %5s %10s %5s %10s %1s\n","|","char","|",noChar,"|","1","|",noChar,"|");
			System.out.format("%1s %10s %5s %10s %5s %10s %5s %10s %1s\n","|","int","|",(noInt/4),"|","4","|",noInt,"|");
			System.out.format("%1s %10s %5s %10s %5s %10s %5s %10s %1s\n","|","float","|",(noFloat/4),"|","4","|",noFloat,"|");
			System.out.format("%1s %10s %5s %10s %5s %10s %5s %10s %1s\n","|","double","|",(noDouble/8),"|","8","|",noDouble,"|");
			System.out.format("%1s %10s %5s %10s %5s %10s %5s %10s %1s\n","|","struct","|",(noStruct/sizeStruct),"|",sizeStruct,"|",noStruct,"|");
			System.out.format("%1s %10s %5s %10s %5s %10s %5s %10s %1s\n","|","union","|",(noUnion/sizeUnion),"|",sizeUnion,"|",noUnion,"|");
			System.out.format("%1s %10s %5s %10s %5s %10s %5s %10s %1s\n","|","Constants","|",noConst,"|","Table1","|",contants,"|");
			System.out.println("-----------------------------------------------------------------");
			System.out.println("Total Memory Requirement: "+ (contants+noChar+noDouble+noFloat+noInt+noStruct+noUnion)+" byte");
			myReader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public static void compute(String data,int i1, int i2){
		String temp = data.substring(i1,i2);
		String split[] = temp.split(",");
		for(String x : split){
			if(x.contains("int ")){
				noInt += val.getDTSize(x,0,x.length())*4;
			}
			else if(x.contains("char ")){
				noChar += val.getDTSize(x,0,x.length());
			}
			else if(x.contains("float ")){
				noFloat += val.getDTSize(x,0,x.length())*4;
			}
			else if(x.contains("double ")){
				noDouble += val.getDTSize(x,0,x.length())*8;
			}
			else if(x.contains("struct ")){
				noStruct += val.getDTSize(x,0,x.length())*sizeStruct;
			}
			else if(x.contains("union ")){
				noUnion += val.getDTSize(x,0,x.length())*sizeUnion;
			}
							
		}
	}
}