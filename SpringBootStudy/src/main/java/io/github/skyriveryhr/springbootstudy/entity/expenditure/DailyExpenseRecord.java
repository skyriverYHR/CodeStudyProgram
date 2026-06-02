package io.github.skyriveryhr.springbootstudy.entity.expenditure;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.sql.Date;

@Data   //用于自动生成set和get方法
@TableName("`daily_expense_records`")
/*
mybatis 可以处理下划线
mybatis-plus 统一标准都用驼峰命名
 */
public class DailyExpenseRecord {
    @TableId(type = IdType.AUTO)
    private Integer recordId;
    private Date expenseDate;
    private Double regularMeals;
    private Double dailyNecessities;
    private Double electronicProducts;
    private Double snacks;
    private Double examinationFee;
    private Double otherExpenses;
    private Double summary;
}
