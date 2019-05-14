package com.controller;

import com.VO.CarPictureVO;
import com.service.CarService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * @create 2019/5/11
 */

@Controller
@RequestMapping("/admin")
public class CarManaController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private CarService carService;

    // 进入汽车管理界面
    @RequestMapping(value = "/intoCarMana", method = RequestMethod.GET)
    public String intoCarMana(){
        return "admin/car/carMana";
    }

    // 进入添加汽车界面
    @RequestMapping(value = "/intoAddCar", method = RequestMethod.GET)
    public String intoAddCar(){
        return "admin/car/addCar";
    }

    /**
     * 删除车辆
     * @return 是否删除成功
     */
    @RequestMapping(value = "/car/{carIds}",method = RequestMethod.DELETE)
    @ResponseBody
    @RequiresPermissions("car:delete")
    public boolean delCars(@PathVariable("carIds") String carIds){
        int flag= carService.DelCar(carIds);
        if (flag ==1){
            logger.info("成功删除编号为:"+carIds+"里的车辆");
            return true;
        }
        logger.info("车辆删除失败");
        return false;
    }

    /**
     * 添加车辆
     * @param carPictureVO 车辆基本信息
     * @param file  车辆图片
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/car",method = RequestMethod.POST)
    @ResponseBody
    /*@RequiresPermissions("car:append")*/
    public boolean addCar(HttpSession session, CarPictureVO carPictureVO, @RequestParam("file") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();//获取文件的输入流
        String fileName = file.getOriginalFilename(); //获取文件的名字和后缀
        String path=this.getClass().getProtectionDomain().getCodeSource().getLocation().toString()+"static"+ File.separator+"images"+File.separator+file.getOriginalFilename();
        path = path.substring(6);//项目发布路径
        OutputStream outputStream = new FileOutputStream(path); //指定上传位置
        byte bs[] = new byte[1024];
        int len=-1;
        while ((len=inputStream.read(bs))!=-1){
            outputStream.write(bs,0,len); //文件上传
        }
        inputStream.close();
        outputStream.close();
        carPictureVO.setUrl(File.separator+"static"+ File.separator+"images"+File.separator+file.getOriginalFilename());
        carService.insert(carPictureVO);
        return true;

    }
}
