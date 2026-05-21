package io.github.skyriveryhr.springbootstudy.service.expenditure;

import io.github.skyriveryhr.springbootstudy.entity.expenditure.DailyExpenseRecord;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DailyExpenseRecordsService{
    List<DailyExpenseRecord> searchInformation();
}
