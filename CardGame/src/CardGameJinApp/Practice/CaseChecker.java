package CardGameJinApp.Practice;

import java.util.ArrayList;
import java.util.List;

public class CaseChecker {

	public static void main(String[] args) {
		System.out.println("First");
		
		List<Integer> list = new ArrayList<>();
		
		list.add(4);
		list.add(4);
		list.add(4);
		list.add(7);
		list.add(7);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		
		if(
						(
							(	(list.get(0) == list.get(1)) && (list.get(0) == list.get(2))	)
														
															&&
								
							(	(list.get(3) == list.get(4)) && (list.get(3) == list.get(5))	)	)
															
						
						
						&& 
						
						
						(	(
								(	(list.get(7) == list.get(6)+1) && (list.get(8) == list.get(7)+1)	)	
															&&
											
													(	(list.get(9) == list.get(8)+1)	)	
																							) 	
																								) 					) {
			System.out.println("Good shit");
			
		}
		System.out.println("Hello");
		
		
															
				
				
			
		
				
				
			
			
			
	}

}
