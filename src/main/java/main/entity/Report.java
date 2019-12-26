package main.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "report")
public class Report {

    @EmbeddedId
    private CompositeKeyForReport compositeKeyForReport;

    @Column(name = "incoming_balances_rubles")
    private String incomingBalancesRubles;

    @Column(name = "incoming_balances_foreign_currency")
    private String incomingBalancesForeignCurrency;

    @Column(name = "incoming_balances_total")
    private String incomingBalancesTotal;

    @Column(name = "debit_turnover_for_reporting_period_rubles")
    private String debitTurnoverForReportingPeriodRubles;

    @Column(name = "debit_turnover_for_reporting_period_foreign_currency")
    private String debitTurnoverForReportingPeriodForeignCurrency;

    @Column(name = "debit_turnover_for_reporting_period_total")
    private String debitTurnoverForReportingPeriodTotal;

    @Column(name = "credit_turnover_for_reporting_period_rubles")
    private String creditTurnoverForReportingPeriodRubles;

    @Column(name = "credit_turnover_for_reporting_period_foreign_currency")
    private String creditTurnoverForReportingPeriodForeignCurrency;

    @Column(name = "credit_turnover_for_reporting_period_total")
    private String creditTurnoverForReportingPeriodTotal;

    @Column(name = "outgoing_balances_rubles")
    private String outgoingBalancesRubles;

    @Column(name = "outgoing_balances_foreign_currency")
    private String outgoingBalancesForeignCurrency;

    @Column(name = "outgoing_balances_total")
    private String outgoingBalancesTotal;
    public CompositeKeyForReport getCompositeKeyForReport() {
        return compositeKeyForReport;
    }

    public void setCompositeKeyForReport(CompositeKeyForReport compositeKeyForReport) {
        this.compositeKeyForReport = compositeKeyForReport;
    }

    public String getIncomingBalancesRubles() {
        return incomingBalancesRubles;
    }

    public void setIncomingBalancesRubles(String incomingBalancesRubles) {
        this.incomingBalancesRubles = incomingBalancesRubles;
    }

    public String getIncomingBalancesForeignCurrency() {
        return incomingBalancesForeignCurrency;
    }

    public void setIncomingBalancesForeignCurrency(String incomingBalancesForeignCurrency) {
        this.incomingBalancesForeignCurrency = incomingBalancesForeignCurrency;
    }

    public String getIncomingBalancesTotal() {
        return incomingBalancesTotal;
    }

    public void setIncomingBalancesTotal(String incomingBalancesTotal) {
        this.incomingBalancesTotal = incomingBalancesTotal;
    }

    public String getDebitTurnoverForReportingPeriodRubles() {
        return debitTurnoverForReportingPeriodRubles;
    }

    public void setDebitTurnoverForReportingPeriodRubles(String debitTurnoverForReportingPeriodRubles) {
        this.debitTurnoverForReportingPeriodRubles = debitTurnoverForReportingPeriodRubles;
    }

    public String getDebitTurnoverForReportingPeriodForeignCurrency() {
        return debitTurnoverForReportingPeriodForeignCurrency;
    }

    public void setDebitTurnoverForReportingPeriodForeignCurrency(String debitTurnoverForReportingPeriodForeignCurrency) {
        this.debitTurnoverForReportingPeriodForeignCurrency = debitTurnoverForReportingPeriodForeignCurrency;
    }

    public String getDebitTurnoverForReportingPeriodTotal() {
        return debitTurnoverForReportingPeriodTotal;
    }

    public void setDebitTurnoverForReportingPeriodTotal(String debitTurnoverForReportingPeriodTotal) {
        this.debitTurnoverForReportingPeriodTotal = debitTurnoverForReportingPeriodTotal;
    }

    public String getCreditTurnoverForReportingPeriodRubles() {
        return creditTurnoverForReportingPeriodRubles;
    }

    public void setCreditTurnoverForReportingPeriodRubles(String creditTurnoverForReportingPeriodRubles) {
        this.creditTurnoverForReportingPeriodRubles = creditTurnoverForReportingPeriodRubles;
    }

    public String getCreditTurnoverForReportingPeriodForeignCurrency() {
        return creditTurnoverForReportingPeriodForeignCurrency;
    }

    public void setCreditTurnoverForReportingPeriodForeignCurrency(String creditTurnoverForReportingPeriodForeignCurrency) {
        this.creditTurnoverForReportingPeriodForeignCurrency = creditTurnoverForReportingPeriodForeignCurrency;
    }

    public String getCreditTurnoverForReportingPeriodTotal() {
        return creditTurnoverForReportingPeriodTotal;
    }

    public void setCreditTurnoverForReportingPeriodTotal(String creditTurnoverForReportingPeriodTotal) {
        this.creditTurnoverForReportingPeriodTotal = creditTurnoverForReportingPeriodTotal;
    }

    public String getOutgoingBalancesRubles() {
        return outgoingBalancesRubles;
    }

    public void setOutgoingBalancesRubles(String outgoingBalancesRubles) {
        this.outgoingBalancesRubles = outgoingBalancesRubles;
    }

    public String getOutgoingBalancesForeignCurrency() {
        return outgoingBalancesForeignCurrency;
    }

    public void setOutgoingBalancesForeignCurrency(String outgoingBalancesForeignCurrency) {
        this.outgoingBalancesForeignCurrency = outgoingBalancesForeignCurrency;
    }

    public String getOutgoingBalancesTotal() {
        return outgoingBalancesTotal;
    }

    public void setOutgoingBalancesTotal(String outgoingBalancesTotal) {
        this.outgoingBalancesTotal = outgoingBalancesTotal;
    }
}
