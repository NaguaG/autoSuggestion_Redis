package chekins.com.test2;

import chekins.com.test2.repository.LocationRepository;
import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStrings;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.geo.Point;
import java.io.InputStream;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


@SpringBootApplication
@EnableRedisDocumentRepositories(basePackages = "chekins.com.test2.*")
public class Test2Application {
	@Autowired
	LocationRepository locationRepository;
	private static final String SHEET_TO_STREAM = "Sheet1";

	@Bean
	CommandLineRunner loadDataReader(@Value("${XLSX_FILE_PATH}") String FILE_NAME) throws IOException{
		return args -> {
			locationRepository.deleteAll();
			XSSFReaderExample example = new XSSFReaderExample();
			example.readExcelFile(FILE_NAME);

//			Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet
//			List<Location> locations = new LinkedList<>();
//			for (Row row : sheet) {
//				if (row.getRowNum() == 0) {
//					continue; // Skip the header row
//				}
//				String name = row.getCell(0).getStringCellValue();
//				String fullName = row.getCell(1).getStringCellValue();
//				String type = row.getCell(2).getStringCellValue();
//				String state = row.getCell(3).getStringCellValue();
//				String country = row.getCell(4).getStringCellValue();
//				String hierarchyPath = row.getCell(5).getStringCellValue();
//				Point loc = new Point(row.getCell(6).getNumericCellValue(), row.getCell(7).getNumericCellValue());
//
//				Location location = Location.of(name, fullName, type, state, country, hierarchyPath, loc);
//				locations.add(location);
//			}
//
//			locationRepository.saveAll(locations);
		};
	}


	public static void main(String[] args) {

		SpringApplication.run(Test2Application.class, args);
	}

}
