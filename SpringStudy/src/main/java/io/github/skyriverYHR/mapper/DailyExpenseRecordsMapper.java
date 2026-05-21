package io.github.skyriverYHR.mapper;

import io.github.skyriverYHR.entity.model.dailyExpense.DailyExpenseRecords;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DailyExpenseRecordsMapper extends DataBasicOperation<DailyExpenseRecords,Integer> {

    List<DailyExpenseRecords> selectAllDailyExpenseRecords();
}
