package io.github.skyriveryhr.springbootstudy.controller.expenditure;

import io.github.skyriveryhr.springbootstudy.entity.expenditure.DailyExpenseRecord;
import io.github.skyriveryhr.springbootstudy.service.expenditure.DailyExpenseRecordsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DailyExpenseRecordsController {

    private final DailyExpenseRecordsService dailyExpenseRecordsService;

    public DailyExpenseRecordsController(DailyExpenseRecordsService dailyExpenseRecordsService) {
        this.dailyExpenseRecordsService = dailyExpenseRecordsService;
    }

    @GetMapping("/dailyExpenseRecords")
    public List<DailyExpenseRecord> getDailyExpenseRecords() {
        return dailyExpenseRecordsService.searchInformation();
    }

}
