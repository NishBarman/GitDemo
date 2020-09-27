import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class test1 {

//@Test
public void regular()


	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("Nishant");
		names.add("Priyanka");
		names.add("Nidhi");
		names.add("Parth");
		names.add("Palak");
		int count=0;
		
		for (int i=0;i<names.size();i++)
		{
			String actual=names.get(i);
			if(actual.startsWith("N"))
			{
				count++;
			}
		}
		System.out.println(count);
		
	}
	
	
@Test
public void streamFilter()
{
	ArrayList<String> names=new ArrayList<String>();
	names.add("Nishant");
	names.add("Priyanka");
	names.add("Nidhi");
	names.add("Parth");
	names.add("Palak");
	Long c=names.stream().filter(s->s.startsWith("N")).count();
	System.out.println(c);
	 
	Stream.of("")
}

}

