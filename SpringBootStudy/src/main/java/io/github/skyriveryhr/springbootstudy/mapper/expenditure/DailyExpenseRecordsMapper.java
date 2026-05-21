package io.github.skyriveryhr.springbootstudy.mapper.expenditure;

import io.github.skyriveryhr.springbootstudy.entity.expenditure.DailyExpenseRecord;
import io.github.skyriveryhr.springbootstudy.mapper.BasicMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DailyExpenseRecordsMapper extends BasicMapper<DailyExpenseRecord, Integer> {
}
