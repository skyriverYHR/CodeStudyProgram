package io.github.skyriveryhr.springbootstudy.service.impl.expenditure;

import io.github.skyriveryhr.springbootstudy.entity.expenditure.DailyExpenseRecord;
import io.github.skyriveryhr.springbootstudy.mapper.expenditure.DailyExpenseRecordsMapper;
import io.github.skyriveryhr.springbootstudy.service.expenditure.DailyExpenseRecordsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyExpenseRecordsImpl implements DailyExpenseRecordsService {

    private final DailyExpenseRecordsMapper dailyExpenseRecordsMapper;

    public DailyExpenseRecordsImpl(DailyExpenseRecordsMapper dailyExpenseRecordsMapper) {
        this.dailyExpenseRecordsMapper = dailyExpenseRecordsMapper;
    }

    @Override
    public List<DailyExpenseRecord> searchInformation() {
//        警告在数据过多时严重影响运行，需配合分页查询
        List<DailyExpenseRecord> records = dailyExpenseRecordsMapper.selectAll();
        return records;
    }
}
