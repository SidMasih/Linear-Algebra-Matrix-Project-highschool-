package OSLRPack;
/**
 * cos = 0
 * sin = 1
 * tan = 2
 * sec = 3
 * @author Sid
 * please be aware of undefined trig values otherwise the results will be innacurate 
 * USE TANGENT AND SEC WITH CAUTION 
 * 
 */
public class TrigSinForOSLR extends OSLRValueGenHolder{
	
	private int choice; 
	
	public TrigSinForOSLR(int choice){
		this.choice = choice;
	}
	
	
	public double getValue(double value){
		
		if(choice== 0){
			return Math.cos(value);
		}
		
		else if(choice ==1){
			return Math.sin(value);
		}
		else if(choice ==2){
			
			return Math.tan(value);
		}
		else{
			return 1/Math.cos(value);
		}
	}


	@Override
	public String getInfo() {
		
		String Info = "trig fucntion of ";
		
		if(choice== 0){
			Info = Info + "cosine";
		}
		
		else if(choice ==1){
			Info = Info + "sine";
		}
		else if(choice ==2){
			Info = Info + "tangent";
		}
		else{
			Info = Info + "secant";
		}
		return Info;
	}




}
