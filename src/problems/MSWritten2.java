package problems;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MSWritten2 {
	
	public static void main(String[] args) {
		String S = "10M 1991-01-01 myfile.txt~\r\n"
				+ "11M 1991-01-01 secon.txt~";
		// need to return the minimum length of filename for all the files which are last modified after a date and whose sizes are less than given size and whose name has ~ at the end
		System.out.println(new MSWritten2().solution(S));
	}
	
	 public String solution(String S) {
		 
		 int minimumFileNameLength = 0;
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateReference = null;
		 try {
			 dateReference = sdf.parse("1990-01-31");
		 } catch (Exception ex) {
			 return "NO FILES";
		 }
		 
		 String[] lines = S.split("\\n");
		 for (String line : lines) {
			 String[] details = line.split(" ");
			 
			 String size = details[0].trim();
			 double sizeValue = Double.parseDouble(size.substring(0, size.length() - 1));
			 char suffix = size.charAt(size.length() - 1);
			 if (suffix == 'K') {
				 sizeValue /= 1024;
			 } else if (suffix == 'G') {
				 sizeValue *= 1024;
			 }
			 
			 String date = details[1].trim();
			 String name = details[2].trim();
			 
			 
			 if (name.endsWith("~") ) {
				 Date parsedDate = null;
				 try {
					 parsedDate = sdf.parse(date);
				 } catch (Exception ex) {
					 continue;
				 }
				 
				 if (parsedDate.after(dateReference) && sizeValue < 14) {
					 int lengthOfFileName = name.split("\\.")[0].length();
					 if (minimumFileNameLength == 0 || lengthOfFileName < minimumFileNameLength) {
						 minimumFileNameLength = lengthOfFileName;
					 }
				 }
			 }
		 }
		 
		 if (minimumFileNameLength == 0) {
			 return "NO FILES";
		 }
		 
		 return String.valueOf(minimumFileNameLength);
	 }

}
