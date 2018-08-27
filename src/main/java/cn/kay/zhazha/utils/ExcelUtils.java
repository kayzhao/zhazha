package cn.kay.zhazha.utils;

import cn.afterturn.easypoi.util.PoiCellUtil;
import cn.kay.zhazha.domain.UnClock;
import cn.kay.zhazha.domain.UnClockHtml;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import static cn.afterturn.easypoi.util.PoiCellUtil.getCellValue;

/**
 * @program: zhazha-tool
 * @package: cn.kay.zhazha.utils
 * @author: kayzhao
 * @create: 2018/8/23
 */
public class ExcelUtils {
    // 读取到列表

    /**
     * @param file
     * @return
     * @throws Exception
     */
    public static Map readUnClockExcel(InputStream file) throws Exception {
        // 读取 excel 文件，获得excel 文档对象
        HSSFWorkbook book = new HSSFWorkbook(file);
        Map<String, UnClock> map = new HashMap<>();
        // 获取到第一个表格
        HSSFSheet sheet = book.getSheetAt(0);
        /**
         * 获取表格数据 getLastRowNum 方法，获取表单最后一行编号
         **/
        for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
            // 获取表格的第i行
            HSSFRow row = sheet.getRow(i);
            // 获取表单第一列数据
            String depart = row.getCell(0).getStringCellValue(); // 第一列
            String name = row.getCell(1).getStringCellValue(); // 第二列
            String duty = row.getCell(2).getStringCellValue();
            String reason = row.getCell(3).getStringCellValue();
            Date date = getDate(row.getCell(4).getStringCellValue()); // 第五列，数字类型需要强转
            String type = row.getCell(5).getStringCellValue();
            UnClock attendance = new UnClock(depart, name, duty, reason, date, type);
            String key = depart + name + type + date.toString();
            map.put(key, attendance);
        }
        return map;
    }

    /**
     * @param file
     * @return
     * @throws Exception
     */

    public static Map readUnClockHtml(InputStream file) throws Exception {
        // 读取 excel 文件，获得excel 文档对象
        HSSFWorkbook book = new HSSFWorkbook(file);
        Map<String, UnClock> map = new HashMap<>();
        // 获取到第一个表格
        HSSFSheet sheet = book.getSheetAt(0);
        /**
         * 获取表格数据 getLastRowNum 方法，获取表单最后一行编号
         **/
        for (int i = 1; i < sheet.getLastRowNum() + 1; ) {
            int iPlusNum = 0;
            UnClockHtml unClock = new UnClockHtml();
            // 获取表格的第i行
            HSSFRow row = sheet.getRow(i);
            String first = row.getCell(0).getStringCellValue().trim();
            if (first.equals("员工")) {
                String two = row.getCell(1).getStringCellValue().trim().replaceAll("[\\s\\u00A0]+", " ");
                String[] info = two.split("\\s+");
                unClock.setId(info[0].split(":")[1]);
                unClock.setName(info[1].split(":")[1]);
                unClock.setDept(info[2].split(":").length > 1 ? info[2].split(":")[1] : "");


                HSSFRow dateRow = sheet.getRow(i + 1);
                HSSFRow clockRow = sheet.getRow(i + 2);
                int rowNum = isMergedRegion(sheet, i + 2, 0);
                //是合并单元格
                if (rowNum != -1) {

                }

            }

            iPlusNum = iPlusNum;
            i += iPlusNum;
        }
        return map;
    }


    /**
     * 判断指定的单元格是否是合并单元格
     *
     * @param sheet
     * @param row    行下标
     * @param column 列下标
     * @return 行数
     */
    private static int isMergedRegion(HSSFSheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    return lastRow - firstRow;
                }
            }
        }
        return -1;
    }


    /**
     * 获取合并单元格的值
     *
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public String getMergedRegionValue(HSSFSheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();

        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    HSSFRow fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return getCellValue(fCell);
                }
            }
        }

        return null;
    }

    /**
     * 测试生成excel
     *
     * @throws Exception
     */
	/*@Test
    public void test() throws Exception {
        List<WebDto> list = new ArrayList<WebDto>();
        list.add(new A("知识林", "http://www.zslin.com", "admin", "111111", new Date(), "ceshi"));
        list.add(new WebDto("权限系统", "http://basic.zslin.com", "admin", "111111", 111, "ceshi"));
        list.add(new WebDto("校园网", "http://school.zslin.com", "admin", "222222", 333, "ceshi"));
        list.add(new WebDto("校园网", "http://school.zslin.com", "admin", "222222", 333, "ceshi"));

        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "网站信息表");
        map.put("total", list.size() + " 条");
        map.put("date", getDate());
        map.put("test", "woshishi");

        // 需要模板文件，map 封装信息， # 加参数名。模板设置.添加列参照 WebDto
        // 模板存放位置
        // 生成的文件存放位置
        // list 表格数据
        // list 集合泛型的类型
        ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "classpath:web-info-template.xls",
                new FileOutputStream("D:/out22.xls"), list, WebDto.class, true);
    }*/
    private static Date getDate(String date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        return sdf.parse(date);
    }


    public static void main(String[] args) throws Exception {
        ExcelUtils.readUnClockHtml(new FileInputStream("/develop/code/kayzhao/shaoshuang/data.xls"));
    }
}
