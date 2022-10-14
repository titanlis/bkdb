package ru.itm.bkdb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itm.bkdb.serivce.AdminService;
import ru.itm.bkdb.serivce.AdminServiceImpl;

import java.util.Map;

/**
 * Контроллер для ручнго обмена таблицами с сервером
 */
@Controller
public class AdminController {
    private static Logger logger = LoggerFactory.getLogger(AdminController.class);

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String welcome(Map<String, Object> model) {
        model.put("transInfo", adminService.getData());
        model.put("tabInfo", adminService.getTables());
        return "index.html";
    }

    @RequestMapping(value="/update_tables", method= RequestMethod.GET)
    public String updateTables(Map<String, Object> model) {
        logger.info("Manual " + adminService.updateTables());
        model.put("tabInfo", adminService.getTables());
        return  "redirect:/";
    }


    /**
     * Отправка таблицы tab вручную на сервер (по кнопке)
     * @param model
     * @param tab
     * @return
     */
    @RequestMapping(value="/{tab}", method= RequestMethod.GET)
    public String transTableOne(Map<String, Object> model, @PathVariable String tab) {
        if(adminService.isTabValid(tab)){
            adminService.sendAll(tab);
        }
        //model.put("transCycleInfo", adminService.getData());
        return  "redirect:/";
    }

//    @RequestMapping(value="/trans_refuel_one", method= RequestMethod.GET)
//    public String transRefuelOne(Map<String, Object> model) {
//        adminService.sendAll("trans_refuel");
//        //model.put("transRefuelInfo", adminService.getData());
//        return  "redirect:/";
//    }

}
