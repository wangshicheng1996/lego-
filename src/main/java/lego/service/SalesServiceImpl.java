package lego.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lego.mapper.SalesMapper;
import lego.pojo.Sales;

@Service
public class SalesServiceImpl implements SalesService{
	@Autowired
	private SalesMapper salesMapper;
	
	//查询销售榜单
	@Override
	public List<Sales> findAllSales() {
		return salesMapper.findAllSales();
	}
	
	//下载销售榜单	
	@Override
	public StringBuilder SalesDownLoad() throws Exception {
//		Workbook wb = new HSSFWorkbook();
//		FileOutputStream fileOut = new FileOutputStream("销售榜单.xls");
//		CreationHelper createHelper = wb.getCreationHelper();
//	    Sheet sheet = wb.createSheet("new sheet");
//	    List<Sales> salesList = salesMapper.findAllSales();
//	    Row row = sheet.createRow((short)0);
//		row.createCell(0).setCellValue("商品ID");
//		row.createCell(1).setCellValue("销售数量");
//		row.createCell(2).setCellValue("月份");
//		row.createCell(3).setCellValue("季度");
//		row.createCell(4).setCellValue("年份");
//		//遍历这个集合
//		for(int i = 1;i<=salesList.size();i++){
//			Row row2 = sheet.createRow((short)i);
//			row2.createCell(0).setCellValue(salesList.get(i-1).getProductId());
//			row2.createCell(1).setCellValue(salesList.get(i-1).getNumber());
//			row2.createCell(2).setCellValue(salesList.get(i-1).getMonth());
//			row2.createCell(3).setCellValue(salesList.get(i-1).getQuarter());
//			row2.createCell(4).setCellValue(salesList.get(i-1).getYear());
//		}
//		wb.write(fileOut);
//	    fileOut.close();
		
		List<Sales> salesList = salesMapper.findAllSales();
		StringBuilder str = new StringBuilder("商品名称\t销售数量\n");
		for(Sales info : salesList){
			str.append(info.getProduct().getName()).append("\t").append(info.getNumber()).append("\n");
		}
		return str;
	}

	//查询商品所有名字
	@Override
	public List<String> findAllSalesName() {
		return salesMapper.findAllSalesName();
	}

	//查询所有商品销量
	@Override
	public List<Integer> findAllSalesCount() {
		return salesMapper.findAllSalesCount();
	}



}
