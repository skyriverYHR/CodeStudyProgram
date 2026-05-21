package io.github.skyriveryhr.springbootstudy.entity.expenditure;
import java.sql.Date;

public class DailyExpenseRecord {
    private Integer record_id;
    private Date expense_date;
    private Double regular_meals;
    private Double daily_necessities;
    private Double electronic_products;
    private Double snakes;
    private Double examination_fee;
    private Double other_expenses;
    private Double summary;

    public Double getDaily_necessities() {
        return daily_necessities;
    }

    public void setDaily_necessities(Double daily_necessities) {
        this.daily_necessities = daily_necessities;
    }

    public Double getElectronic_products() {
        return electronic_products;
    }

    public void setElectronic_products(Double electronic_products) {
        this.electronic_products = electronic_products;
    }

    public Double getExamination_fee() {
        return examination_fee;
    }

    public void setExamination_fee(Double examination_fee) {
        this.examination_fee = examination_fee;
    }

    public Date getExpense_date() {
        return expense_date;
    }

    public void setExpense_date(Date expense_date) {
        this.expense_date = expense_date;
    }

    public Double getOther_expenses() {
        return other_expenses;
    }

    public void setOther_expenses(Double other_expenses) {
        this.other_expenses = other_expenses;
    }

    public Integer getRecord_id() {
        return record_id;
    }

    public void setRecord_id(Integer record_id) {
        this.record_id = record_id;
    }

    public Double getRegular_meals() {
        return regular_meals;
    }

    public void setRegular_meals(Double regular_meals) {
        this.regular_meals = regular_meals;
    }

    public Double getSnakes() {
        return snakes;
    }

    public void setSnakes(Double snakes) {
        this.snakes = snakes;
    }

    public Double getSummary() {
        return summary;
    }

    public void setSummary(Double summary) {
        this.summary = summary;
    }
}
