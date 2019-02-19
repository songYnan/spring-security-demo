
public class QlTest {
	public static void main(String[] args) {
		/*StringBuilder strhours = new StringBuilder();
		String s="123456789123456789";
		if(s.length()<17){
			int l=17-s.length();
			strhours.append(s);
			for(int i=0;i<l;i++){
				strhours.insert(0, "z");
			}
			System.out.println(strhours+"---"+strhours.length());
			System.out.println();
		}
		else{
			strhours.append("z" +s.substring(s.length() -16,s.length()));
			System.out.println("........."+strhours.toString());
		}
		
		*/
		

		for(String mqttClientId:new String[] {"012345", "00000123456788901234567890", "01234567890123456"}) {
		//String s=mqttClientId.replace(mqttClientId, newChar)
			String s= "z"+String.format("%16s", mqttClientId.substring(mqttClientId.length()>16?mqttClientId.length()-16:0)).replace(" ", "z");
			System.out.println(s);
		}
		
		String s="111";
		s.replace(s, "122");
		System.out.println(s);
	}

}
