import java.util.*;
import java.io.*;
class Break{
	public boolean checkBreak(int line){
		boolean flag = false;
		try{
			File Obj = new File("file");
			Scanner sc =  new Scanner(Obj);
			int lineNo=0;
			String data="";
			
			while(sc.hasNextLine()){
				data = sc.nextLine();
				lineNo++;
				if(line == lineNo){
					break;
				}
			}
			if(data.charAt(data.length()-1)!='{')
				data = sc.nextLine();
			int open = 1;
			while(open!=0){
				data = sc.nextLine();
				if(data.contains("break")){
					flag = true;
					break;
				}
				if(data.contains("{"))
					open++;
				if(data.contains("}"))
					open--;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return flag;
	}
}