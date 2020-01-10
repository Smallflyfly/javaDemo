package com.wochanye.demo.controller;

import com.wochanye.demo.constant.meta.GenderEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Demo演示
 *
 * @author cuijie
 * @since 2018/6/25
 */
@Controller
@RequestMapping("/")
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    /**
     * 展示输出，但因为没有配置视图输出，会报500
     *
     * @return
     */
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String getInfo() {
        return "Hello, World!";
    }

    /**
     * JSON数据输出，通常作为接口数据输出
     *
     * @return
     */
    @RequestMapping(value = "helloApi", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getJsonInfo() {
        Map<String, Object> result = new HashMap<>();
        result.put("hello", "world!");
        result.put("version", "1.0");
        return result;
    }

    /**
     * thymeleaf模板页面演示
     *
     * @return
     */
    @RequestMapping(value = "helloTemplate", method = RequestMethod.GET)
    public String getTemplateInfo(Model model) {
        model.addAttribute("hello", "world!");
        model.addAttribute("version", "1.0");
        model.addAttribute("genderList", GenderEnum.values());
        return "hello";
    }

    /**
     * iView页面演示 - 页面载入
     *
     * @return
     */
    @RequestMapping(value = "iView", method = RequestMethod.GET)
    public String iView(HttpSession httpSession, Model model) {
        logger.info("Current Session：{}", httpSession.getId());
        httpSession.setAttribute("user", httpSession.getId());
        return "iView";
    }

    /**
     * iView页面演示 - 获取部门列表
     *
     * @return
     */
    /**
    @RequestMapping(value = "deptList", method = RequestMethod.GET)
    @ResponseBody
    public PageResult<List<MyDeptPO>> getDeptList(int page, int pageSize, String deptName, HttpSession httpSession) {
        logger.info("Current Session：{}", httpSession.getAttribute("user"));
        logger.info("Current Page：{}, PageSize：{}", page, pageSize);
        return demoService.getDeptInfoList(page, pageSize, deptName);
    }
    **/

    /**
     * 新增、编辑部门信息
     *
     * @param deptNo
     * @param deptName
     * @param deptLoc
     * @param httpSession
     * @return
     */
//    @RequestMapping(value = "addEditDept", method = RequestMethod.POST)
//    @ResponseBody
//    public Result addEditDept(int deptNo, String deptName, String deptLoc, HttpSession httpSession) {
//        logger.info("Current Session：{}", httpSession.getAttribute("user"));
//        demoService.addEditDept(deptNo, deptName, deptLoc);
//        return ResponseUtil.operateSuccess();
//    }

}
