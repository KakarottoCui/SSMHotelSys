package com.hotel.controller;

import com.hotel.pojo.Home;
import com.hotel.pojo.Vip;
import com.hotel.service.HomeServiceImpl;
import com.hotel.service.VipServiceImpl;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    HomeServiceImpl homeService;
    @Autowired
    VipServiceImpl vipService;

    @RequestMapping("/home")
    public void excel_home(HttpServletResponse response )throws IOException {

        response.setCharacterEncoding("UTF-8");
        List<Home> homeList=homeService.queryAllHome();
        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("房间信息");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("编号");
        titleRow.createCell(1).setCellValue("房间号");
        titleRow.createCell(2).setCellValue("房间类型");
        titleRow.createCell(3).setCellValue("价格");
        titleRow.createCell(4).setCellValue("状态");
        titleRow.createCell(5).setCellValue("描述");

        for(Home home:homeList){
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
            dataRow.createCell(0).setCellValue(home.getId());
            dataRow.createCell(1).setCellValue(home.getNum());
            dataRow.createCell(2).setCellValue(home.getH_Type());
            dataRow.createCell(3).setCellValue(home.getPrice());
            dataRow.createCell(4).setCellValue(home.getState());
            dataRow.createCell(5).setCellValue(home.getText());
        }

        // 设置下载时客户端Excel的名称
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String("房间信息表".getBytes(),"iso-8859-1") + ".xls");

        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();

    }

    @RequestMapping("/vip")
    public void excel_vip(HttpServletResponse response )throws IOException {

        response.setCharacterEncoding("UTF-8");
        List<Vip> vipList=vipService.queryAllVip();
        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("会员信息");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("编号");
        titleRow.createCell(1).setCellValue("姓名");
        titleRow.createCell(2).setCellValue("性别");
        titleRow.createCell(3).setCellValue("身份证号");
        titleRow.createCell(4).setCellValue("手机号");
        titleRow.createCell(5).setCellValue("会员类型");
        titleRow.createCell(6).setCellValue("开通时间");
        titleRow.createCell(7).setCellValue("到期时间");

        for(Vip vip:vipList){
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
            dataRow.createCell(0).setCellValue(vip.getId());
            dataRow.createCell(1).setCellValue(vip.getName());
            dataRow.createCell(2).setCellValue(vip.getSex());
            dataRow.createCell(3).setCellValue(vip.getCard());
            dataRow.createCell(4).setCellValue(vip.getPhone());
            dataRow.createCell(5).setCellValue(vip.getV_Type());
            dataRow.createCell(6).setCellValue(vip.getStartTime());
            dataRow.createCell(7).setCellValue(vip.getEndTime());
        }

        // 设置下载时客户端Excel的名称
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String("客户会员名单".getBytes(),"iso-8859-1") + ".xls");

        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();

    }

}
