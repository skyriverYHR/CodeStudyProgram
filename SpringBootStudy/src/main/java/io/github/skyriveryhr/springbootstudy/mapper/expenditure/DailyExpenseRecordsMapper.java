package io.github.skyriveryhr.springbootstudy.mapper.expenditure;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.skyriveryhr.springbootstudy.entity.expenditure.DailyExpenseRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DailyExpenseRecordsMapper extends BaseMapper<DailyExpenseRecord> {
}
