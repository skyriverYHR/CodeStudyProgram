package io.github.skyriverYHR.controller;

import io.github.skyriverYHR.entity.model.dailyExpense.DailyExpenseRecords;
import io.github.skyriverYHR.service.DailyExpenseRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("dataBasaInformation")
public class controller {
    @Autowired
    private DailyExpenseRecordsService dailyExpenseRecordsService;

    /**
     * 测试网页映射配置是否正确
     */
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    /**
     * 管理日常小费开支网页
     * @param model 存储页面需要的数据 自动传入
     * @return 返回处理后的页面
     */
    @GetMapping("/expenditure")
    public String expenditure(Model model) {
        model.addAttribute("i", 1);
        return "expenditure";
    }
}