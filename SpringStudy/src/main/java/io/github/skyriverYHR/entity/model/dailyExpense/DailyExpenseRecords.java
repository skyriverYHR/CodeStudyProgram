package io.github.skyriverYHR.entity.model.dailyExpense;

import java.time.LocalDate;

public class DailyExpenseRecords {
    private int record_id;
    private LocalDate expense_date;
    private Double regular_meals;
    private Double daily_necessities;
    private Double electronic_products;
    private Double snacks;
    private Double examination_fee;
    private Double other_expenses;
    private Double summary;

    public void setDaily_necessities(Double daily_necessities) {
        this.daily_necessities = daily_necessities;
    }

    public void setElectronic_products(Double electronic_products) {
        this.electronic_products = electronic_products;
    }

    public void setExamination_fee(Double examination_fee) {
        this.examination_fee = examination_fee;
    }

    public void setExpense_date(LocalDate expense_date) {
        this.expense_date = expense_date;
    }

    public void setOther_expenses(Double other_expenses) {
        this.other_expenses = other_expenses;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public void setRegular_meals(Double regular_meals) {
        this.regular_meals = regular_meals;
    }

    public void setSnacks(Double snacks) {
        this.snacks = snacks;
    }

    public void setSummary(Double summary) {
        this.summary = summary;
    }

    public Double getDaily_necessities() {
        return daily_necessities;
    }

    public Double getElectronic_products() {
        return electronic_products;
    }

    public Double getExamination_fee() {
        return examination_fee;
    }

    public LocalDate getExpense_date() {
        return expense_date;
    }

    public Double getOther_expenses() {
        return other_expenses;
    }

    public int getRecord_id() {
        return record_id;
    }

    public Double getRegular_meals() {
        return regular_meals;
    }

    public Double getSnacks() {
        return snacks;
    }

    public Double getSummary() {
        return summary;
    }
}
