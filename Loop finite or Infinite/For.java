import java.util.*;
class For{
	public boolean checkLesser(String cond,String itr,int varVal){
		String sides[];
		int val=0;
		boolean flag =false;
		if(cond.contains("=")){
			sides = cond.split("<=");
		}
		else
			sides = cond.split("<");
		for(int i=0;i<sides.length;i++){
			if(sides[i].matches("[0-9]+")){
				val = Integer.parseInt(sides[i]);
			}
		}
		//System.out.println(val+" "+varVal);
		if(itr.contains("--") || itr.contains("-")){
			if(val>=varVal)
				flag = true;
			else
				flag = false;
		}
		return flag;
	}
	public boolean checkgreater(String cond,String itr,int varVal){
		String sides[];
		int val=0;
		boolean flag =false;
		if(cond.contains("=")){
			sides = cond.split(">=");
		}
		else
			sides = cond.split(">");
		for(int i=0;i<sides.length;i++){
			if(sides[i].matches("[0-9]+")){
				val = Integer.parseInt(sides[i]);
			}
		}
		//System.out.println(val+" "+varVal);
		if(itr.contains("++") || itr.contains("+")){
			if(val<=varVal)
				flag = true;
			else
				flag = false;
		}
		return flag;
	}
}