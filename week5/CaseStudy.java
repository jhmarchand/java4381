
public class CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int myInt = 5;
		
		String intAsString = GetWordingOfInt(myInt);
		
		System.out.println(intAsString);

	}
	
	static String GetWordingOfInt(int digit)
	{
		String word = "";
		switch ( digit )
		{
		case 5:
			word = "five";
			break;		
		case 7:
			word = "seven";
			break;
		default:
			word = "unknown";
				
		}
		
		return word;
			
	
	}

}
