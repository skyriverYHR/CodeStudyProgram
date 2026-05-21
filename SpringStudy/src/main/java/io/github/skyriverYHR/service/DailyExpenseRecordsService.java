package io.github.skyriverYHR.service;

import io.github.skyriverYHR.entity.model.dailyExpense.DailyExpenseRecords;
import io.github.skyriverYHR.mapper.DailyExpenseRecordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyExpenseRecordsService {

    @Autowired
    private DailyExpenseRecordsMapper dailyExpenseRecordsMapper;

    /**
     * 插入一条数据
     * @return 返回影响行数
     */
    public int insert(DailyExpenseRecords record) {
        return dailyExpenseRecordsMapper.insert(record);
    }
}
