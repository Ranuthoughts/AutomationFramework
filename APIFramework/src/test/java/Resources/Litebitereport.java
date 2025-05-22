package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Litebitereport {

	public ArrayList<Comparable> getdata(String casename, String sheetname) throws IOException {
		// Define an array list to store the extracted data
		ArrayList<Comparable> a = new ArrayList<Comparable>();

		FileInputStream fis = new FileInputStream("C:\\Users\\Ranu Tiwari\\Desktop\\Excel Test Automation.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// getting total number of sheets
		int sheets = wb.getNumberOfSheets();
		System.out.println("Total no of sheets of test : " + sheets);
		for (int i = 0; i < sheets; i++) {
			if (wb.getSheetName(i).equalsIgnoreCase(sheetname)) {
				XSSFSheet sheet = wb.getSheetAt(i);
				System.out.println("Name of sheets  : " + sheet);
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();
				int k = 0;
				int coloumn = 0;
				while (ce.hasNext()) {
					Cell Value = ce.next();
//							System.out.println(Value);
					if (Value.getStringCellValue().equalsIgnoreCase("AddMember")) {
						coloumn = k; // coloumn number of desired coloumn
						System.out.println("Found 'TransactionDate' at column  :  " + coloumn);
					}
					k++;
				}
				System.out.println("Total coloumn in the sheets : " + k);

				if (coloumn == -1) {

					System.out.println("'TransactionDate' column not found.");
					return null;
				}

				// Comparing the each row data with actual result
				while (rows.hasNext()) {
					Row r = rows.next();
					Cell cell = r.getCell(coloumn);
					if (cell != null) {
						switch (cell.getCellType()) {
						case STRING:
							String cellValue = cell.getStringCellValue();
							if (cellValue.equalsIgnoreCase("AddMember")) {
								System.out.println("Match found: " + cellValue);
							}
							break;
						case NUMERIC:
							System.out.println("Numeric value in TransactionDate: " + cell.getNumericCellValue());
							break;

						case BLANK:
							System.out.println("Blank cell in TransactionDate column.");
							break;

						default:
							System.out.println("Other type cell found.");
						}
					} else {
						System.out.println("Null cell in this row.");
					}

					// Getting each row value with respect to each coloumn

					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(casename)) {

						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {

							Cell currentCell = cv.next();
							switch (currentCell.getCellType()) {
							case STRING:
								a.add(currentCell.getStringCellValue());
								break;
							case NUMERIC:
								a.add(String.valueOf(currentCell.getNumericCellValue()));
								break;
							case BOOLEAN:
								a.add(String.valueOf(currentCell.getBooleanCellValue()));
								break;
							case BLANK:
								a.add("");
								break;
							default:
								a.add("");
							}
//							a.add(cv.next().getStringCellValue());

						}
						break;
//						a.add(cv.next().getStringCellValue());
						
					}
				}

			} 

		}
		return a;
}



	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	}
}
